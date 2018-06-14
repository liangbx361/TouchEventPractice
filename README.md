# 事件分发详解

## 事件调用链
```java
main(ZygoteInit) --> run(ZygoteInit$MethodAndArgsCaller) --> main(ActivityThread) --> loop(Looper) --> next(MessageQueue) --> nativePollOnce --> dispatchInputEvent (InputEventReceiver) --> onInputEvent(ViewRootImpl$WindowInputEventReceiver) --> enqueueInputEvent (ViewRootImpl) --> doProcessInputEvents--> deliverInputEvent--> deliver (ViewRootImpl$InputStage) --> apply--> forward -->onDeliverToNext --> deliver --> apply(ViewRootImpl$AsyncInputStage) --> apply(ViewRootImpl$InputStage) --> forward(ViewRootImpl$AsyncInputStage) --> forward(ViewRootImpl$InputStage) --> onDeliverToNext --> deliver --> onProcess(ViewRootImpl$ViewPostImeInputStage) --> processPointerEvent --> dispatchPointerEvent(DecorView) --> dispatchTouchEvent(WindowCallbackWrapper) --> dispatchTouchEvent(Activity) --> superDispatchTouchEvent(PhoneWindow) --> superDispatchTouchEvent(DecorView) --> dispatchTouchEvent --> dispatchTransformedTouchEvent
```

## 关键类
* InputEventReceiver（抽象类） 系统输入事件的接收器，负责在主线程的Looper中注册事件接收者，随后输入事件会分发到该对象上（在ViewRootImpl上的实现是WindowInputEventReceiver）
* ViewRootImpl 系统事件的接收者，负责与底层系统服务进行通信，分发事件给DecorView
* DecorView 控件树最顶层的控件，负责分发事件给子控件
* InputStage（ViewRootImpl内部类）链表结构，用户处理事件，并决定是否传递给下一个节点
* ViewPostImeInputStage 处理视图控件的事件分发

### 注册事件接收者
*. 调用 setView(ViewRootImpl) 
*  创建WindowInputEventReciverd对象，并完成向MessageQueue注册InputEvent的接收者
* 后续会把InputEvent事件分发到 WindowInputEventReciverd

### 接收事件并处理
* 当有InputEvent发生，会通过dispatchInputEvent（InputEventReceiver)回调从Native回调出来
* 调用onInputEvent（WindowInputEventReceiver）
* 调用enqueueInputEvent（ViewRootImpl）
* 调用doProcessInputEvents（ViewRootImpl）
* 调用deliverInputEvent（ViewRootImpl）
* 调用deliver（InputStage 链表结构，会进行循环处理，触摸事件一般在ViewPostImeInputStage）
* 调用onProcess方法来决定处理条件（包含：FORWARD、FINISH_HANDLED、FINISH_NOT_HANDLED）
* 调用apply，把处理条件传入
* 如果为FORWARD，调用直接forward
* 如果为FINISH_HANDLED、FINISH_NOT_HANDLED 调用finish，标记当前InputStage已处理结束，发给下一个InputStage进行处理
* 调用onDeliverToNext
* 如果还有下一个节点，调用下一个节点的deliver方法，否则调用finishInputEvent（ViewRootImpl)
* ViewPostImeInputStage的 onProcess 中把事件调用processPointerEvent方法，进入事件分发流程了
* processPointerEvent根据结果标记为FINISH_HANDLED或FPRWARD
* 当调用finishInputEvent（ViewRootImpl)，会调用 finishInputEvent（InputEventReceiver）告诉系统是否已处理事件，如果不处理，事件的其他状态不会发送过来

## 触摸事件MotionEvent

## 单点触控

| 类型                   | 说明         |
| ---------------------- | ------------ |
| ACTION_DOWN            | 手指按下触发 |
| ACTION_MOVE            | 手指移动触发 |
| ACTION_UP              | 手指离开触发 |
| ACTION_CANCEL（特殊）  |              |
| ACTION_OUTSIDE（特殊） |              |

## 多点触控

| 类型                | 说明                                 |
| ------------------- | ------------------------------------ |
| ACTION_DOWN         | 第一个手指按下触发                   |
| ACTION_MOVE         | 手指移动触发（可能是第一个或者其他） |
| ACTION_POINTER_DOWN | 其他手指按下触发                     |
| ACTION_POINTER_UP   | 非最后一个手指离开触发               |
| ACTION_UP           | 最后一个手指离开触发                 |

| 方法                            | 说明                           |
| ------------------------------- | ------------------------------ |
| getActionIndex()                | 获取该事件是哪个索引手指产生的 |
| getPointerCount()               | 获取屏幕上的手指个数           |
| getPointerId(int pointerIndex)  | 通过索引获取的手指ID           |
| findPointerIndex(int pointerId) | 通过手指ID获取索引             |

### 参考

[MotionEvent详解] (http://www.gcssloop.com/customview/motionevent)
package com.liangbx.android.practice.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liangbx.android.practice.touchevent.controller.DispatchStrategyFactory;
import com.liangbx.android.practice.touchevent.widget.DispatchView;
import com.liangbx.android.practice.touchevent.widget.DispatchViewGroup;

/**
 * <p>Title: 事件分发示例 </p>
 * <p>Description: Activity --> DecorView --> ViewGroup --> View </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2018/3/15
 */
public class DispatchActivity extends AppCompatActivity {

    private DispatchViewGroup mDispatchViewGroup;
    private DispatchView mDispatchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);

        mDispatchViewGroup = findViewById(R.id.targetVg);
        mDispatchView = findViewById(R.id.targetView);

//        // ViewGroup 不处理
//        mDispatchViewGroup.setController(DispatchStrategyFactory.getViewGroupController(DispatchStrategyFactory.ViewGroupStrategy.NOT_HANDLE));
//        // View 不处理
//        mDispatchView.setController(DispatchStrategyFactory.getViewController(DispatchStrategyFactory.ViewStrategy.NOT_HANDLE));

//        // ViewGroup 不处理
//        mDispatchViewGroup.setController(DispatchStrategyFactory.getViewGroupController(DispatchStrategyFactory.ViewGroupStrategy.NOT_HANDLE));
//        // View 处理
//        mDispatchView.setController(DispatchStrategyFactory.getViewController(DispatchStrategyFactory.ViewStrategy.HANDLE));

//        // ViewGroup 拦截但不处理
//        mDispatchViewGroup.setController(DispatchStrategyFactory.getViewGroupController(DispatchStrategyFactory.ViewGroupStrategy.INTERCEPT_AND_NOT_HANDLE));
//        // View 处理
//        mDispatchView.setController(DispatchStrategyFactory.getViewController(DispatchStrategyFactory.ViewStrategy.HANDLE));

//        // ViewGroup 拦截且处理
//        mDispatchViewGroup.setController(DispatchStrategyFactory.getViewGroupController(DispatchStrategyFactory.ViewGroupStrategy.INTERCEPT_AND_HANDLE));
//        // View 处理
//        mDispatchView.setController(DispatchStrategyFactory.getViewController(DispatchStrategyFactory.ViewStrategy.HANDLE));

        // ViewGroup 处理
        mDispatchViewGroup.setController(DispatchStrategyFactory.getViewGroupController(DispatchStrategyFactory.ViewGroupStrategy.HANDLE));
        // View 处理
        mDispatchView.setController(DispatchStrategyFactory.getViewController(DispatchStrategyFactory.ViewStrategy.HANDLE));
    }


}

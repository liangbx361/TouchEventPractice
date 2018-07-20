package com.liangbx.android.practice.touchevent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.liangbx.android.practice.touchevent.controller.ViewGroupDispatchController;
import com.liangbx.android.practice.touchevent.util.TouchEventInfo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2018/3/15
 */

public class DispatchViewGroup extends FrameLayout {

    private static final String TAG = "Group";

    private ViewGroupDispatchController mController;

    public DispatchViewGroup(Context context) {
        super(context);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public DispatchViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent --> " + TouchEventInfo.getActionName(ev));

        boolean result = super.dispatchTouchEvent(ev);
//        if(mController != null) {
//            result |= mController.dispatchTouchEvent(ev);
//        }

        Log.d(TAG, "dispatchTouchEvent result --> " + result);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent --> " + TouchEventInfo.getActionName(ev));

        boolean result = super.onInterceptTouchEvent(ev);
        if(mController != null) {
            result |= mController.onInterceptTouchEvent(ev);
        }

        Log.d(TAG, "onInterceptTouchEvent result --> " + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent --> " + TouchEventInfo.getActionName(ev));

        boolean result = super.onTouchEvent(ev);
        if(mController != null) {
            result |= mController.onTouchEvent(ev);
        }

        Log.d(TAG, "onTouchEvent result --> " + result);
        return result;
    }

    public void setController(ViewGroupDispatchController controller) {
        mController = controller;
    }
}

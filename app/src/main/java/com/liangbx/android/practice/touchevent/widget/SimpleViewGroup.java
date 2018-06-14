package com.liangbx.android.practice.touchevent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.liangbx.android.practice.touchevent.util.TouchEventUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2018/3/15
 */

public class SimpleViewGroup extends FrameLayout {

    private static final String TAG = "SimpleVg";

    public SimpleViewGroup(Context context) {
        super(context);
    }

    public SimpleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public SimpleViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d(TAG, "dispatchTouchEvent --> " + TouchEventUtil.getActionName(ev));

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent ev) {

        Log.d(TAG, "onInterceptHoverEvent --> " + TouchEventUtil.getActionName(ev));

        return super.onInterceptHoverEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        Log.d(TAG, "onTouchEvent --> " + TouchEventUtil.getActionName(ev));

        return super.onTouchEvent(ev);
    }
}

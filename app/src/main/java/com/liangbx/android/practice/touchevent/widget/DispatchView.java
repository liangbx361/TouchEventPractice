package com.liangbx.android.practice.touchevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.liangbx.android.practice.touchevent.controller.ViewDispatchController;
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

public class DispatchView extends View {

    private static final String TAG = "View";

    private ViewDispatchController mController;

    public DispatchView(Context context) {
        super(context);
    }

    public DispatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onTouchEvent --> " + TouchEventInfo.getActionName(ev));

        boolean result = super.onTouchEvent(ev);
        result = false;
        if(mController != null) {
            result |= mController.onTouchEvent(ev);
        }

        Log.d(TAG, "onTouchEvent result --> " + result);
        return result;
    }

    public void setController(ViewDispatchController controller) {
        mController = controller;
    }
}

package com.liangbx.android.practice.touchevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2018/3/15
 */

public class SimpleView extends android.support.v7.widget.AppCompatButton {

    private static final String TAG = "SimpleView";

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d(TAG, "dispatchTouchEvent");

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d(TAG, "onTouchEvent");

        return super.onTouchEvent(event);
    }
}

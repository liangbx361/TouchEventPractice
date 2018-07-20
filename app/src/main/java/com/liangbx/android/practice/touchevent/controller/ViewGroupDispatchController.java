package com.liangbx.android.practice.touchevent.controller;

import android.view.MotionEvent;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2018<／p>
 * <p>Company: <／p>
 *
 * @author liangbx
 * @version 2018/7/2
 */
public interface ViewGroupDispatchController {

    boolean dispatchTouchEvent(MotionEvent ev);

    boolean onInterceptTouchEvent(MotionEvent ev);

    boolean onTouchEvent(MotionEvent event);
}

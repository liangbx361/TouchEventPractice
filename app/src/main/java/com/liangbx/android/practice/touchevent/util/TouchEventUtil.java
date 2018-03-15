package com.liangbx.android.practice.touchevent.util;

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

public class TouchEventUtil {

    public static String getAction(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";

            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";

            case MotionEvent.ACTION_UP:
                return "ACTION_UP";

            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";

            default:
                return "unknown";
        }
    }
}

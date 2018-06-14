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

    public static String getActionName(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            // 0
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";

            // 1
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";

            // 2
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";

            // 3
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";

            // 4
            case MotionEvent.ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";

            // 5
            case MotionEvent.ACTION_POINTER_DOWN:
                return "ACTION_POINTER_DOWN";

            // 6
            case MotionEvent.ACTION_POINTER_UP:
                return "ACTION_POINTER_UP";

            // 7
            case MotionEvent.ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";

            // 8
            case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                return "ACTION_POINTER_INDEX_SHIFT";

            // 9
            case MotionEvent.ACTION_HOVER_ENTER:
                return "ACTION_HOVER_ENTER";

            // 10
            case MotionEvent.ACTION_HOVER_EXIT:
                return "ACTION_HOVER_EXIT";

            // 11
            case MotionEvent.ACTION_BUTTON_PRESS:
                return "ACTION_BUTTON_PRESS";

            // 12
            case MotionEvent.ACTION_BUTTON_RELEASE:
                return "ACTION_BUTTON_RELEASE";

            default:
                return "unknown";
        }
    }
}

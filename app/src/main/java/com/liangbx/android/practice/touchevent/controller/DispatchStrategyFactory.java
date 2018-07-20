package com.liangbx.android.practice.touchevent.controller;

import android.view.MotionEvent;

/**
 * <p>Title: 事件分发策略<／p>
 * <p>Description: <／p>
 * <p>1. 都不处理 </p>
 * <P>2. ViewGroup拦截处理</P>
 * <p>3. View处理</p>
 * <p>Copyright: Copyright (c) 2018<／p>
 * <p>Company: <／p>
 *
 * @author liangbx
 * @version 2018/7/2
 */
public class DispatchStrategyFactory {

    public enum ViewStrategy {
        NOT_HANDLE,
        HANDLE
    }

    public enum ViewGroupStrategy {
        NOT_HANDLE,
        INTERCEPT_AND_NOT_HANDLE,
        INTERCEPT_AND_HANDLE,
        HANDLE
    }

    public static ViewDispatchController getViewController(ViewStrategy strategy) {
        switch (strategy) {
            case HANDLE:
                return new ViewHandle();

            case NOT_HANDLE:
            default:
                return new ViewNotHandle();
        }
    }

    public static ViewGroupDispatchController getViewGroupController(ViewGroupStrategy strategy) {
        switch (strategy) {
            case HANDLE:
                return new ViewGroupHandle();

            case INTERCEPT_AND_HANDLE:
                return new ViewGroupInterceptAndHandle();

            case INTERCEPT_AND_NOT_HANDLE:
                return new ViewGroupInterceptAndNotHandle();

            case NOT_HANDLE:
            default:
                return new ViewGroupNotHandle();
        }
    }

    public static class ViewNotHandle implements ViewDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return false;
        }
    }

    public static class ViewHandle implements ViewDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return true;
        }
    }

    public static class ViewGroupNotHandle implements ViewGroupDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return false;
        }
    }

    public static class ViewGroupInterceptAndNotHandle implements ViewGroupDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return true;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return false;
        }
    }

    public static class ViewGroupInterceptAndHandle implements ViewGroupDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return true;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return true;
        }
    }

    public static class ViewGroupHandle implements ViewGroupDispatchController {

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            return true;
        }
    }
}

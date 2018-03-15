package com.liangbx.android.practice.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * <p>Title: 测试最简单的情况</p>
 * <p>Description: Activity --> DecorView --> ViewGroup --> View </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <P>Company: 17173</p>
 *
 * @author liangbx
 * @version 2018/3/15
 */
public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }
}

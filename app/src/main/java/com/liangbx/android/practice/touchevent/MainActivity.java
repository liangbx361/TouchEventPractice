package com.liangbx.android.practice.touchevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navToSimple(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    public void navToAction(View view) {
        startActivity(new Intent(this, ActionSampleActivity.class));
    }
}

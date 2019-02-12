package com.cdx.example.scroller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cdx.example.scroller.R;
import com.cdx.example.scroller.view.MyView;

public class Test1Activity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        myView = findViewById(R.id.view);

    }

    public void click(View view) {
        myView.smoothScrollTo(-500,-500);
    }
    public void click2(View view) {
        myView.directScrollTo(-500,-500);
        myView.invalidate();
    }
}

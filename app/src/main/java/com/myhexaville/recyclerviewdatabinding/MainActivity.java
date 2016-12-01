package com.myhexaville.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myhexaville.recyclerviewdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

}

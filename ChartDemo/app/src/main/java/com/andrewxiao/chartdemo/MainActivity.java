package com.andrewxiao.chartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private DemoLineChart demoLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        demoLineChart = (DemoLineChart) findViewById(R.id.demoChart);

        demoLineChart.init(this);
        demoLineChart.drawData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Demo", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Demo", "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Demo", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Demo", "onStop");
    }
}

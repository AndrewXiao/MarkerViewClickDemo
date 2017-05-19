package com.andrewxiao.chartdemo;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class DemoLineChart extends LineChart {
    private Context context;

    public DemoLineChart(Context context) {
        super(context);
    }

    public DemoLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(Context context){
        this.context = context;
        initBBTXAxis();
        initBBTYAxis();

        initBBTChart();
    }

    private void initBBTXAxis(){
        XAxis xAxis = this.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//default is top
        xAxis.setAxisMinValue(0);
        xAxis.setAxisMaxValue(10);
        xAxis.setLabelCount(10);
        xAxis.setTextSize(12);
        xAxis.setTypeface(Typeface.create("Regular", Typeface.NORMAL));
    }

    private void initBBTYAxis(){
        YAxis leftAxis = this.getAxisLeft();
        setBBTYAxisBase(leftAxis);

        YAxis rightAxis = this.getAxisRight();
        rightAxis.setDrawAxisLine(true);
        rightAxis.setDrawLabels(true);
        setBBTYAxisBase(rightAxis);
    }

    private void setBBTYAxisBase(YAxis yAxis){
        yAxis.setAxisMinValue(0);
        yAxis.setAxisMaxValue(10);
        yAxis.setLabelCount(10);
        yAxis.setTextSize(12);
    }

    private void initBBTChart(){
        getAxisRight().setEnabled(true);

        setScaleEnabled(false);

        DemoMarkerView demoMarkerView = new DemoMarkerView(context, R.layout.demo_markerview);
        setMarkerView(demoMarkerView);

        setDrawBorders(true);
        setBorderWidth(0.5f);
        setBorderColor(Color.LTGRAY);

        setHardwareAccelerationEnabled(false);
    }

    public void drawData(){
        List<Entry> EntryList = new ArrayList<>();

        EntryList.add(new Entry(2, 2));
        EntryList.add(new Entry(5, 5));
        EntryList.add(new Entry(7, 7));

        LineDataSet lineDataSet = new LineDataSet(EntryList, "demo");

        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(5f);
        lineDataSet.setCircleHoleRadius(3f);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawValues(false); // 不在圆圈旁边显示Y值, 默认为true

        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setHighlightLineWidth(2f);

        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setHighlightLineWidth(2f);

        ArrayList<ILineDataSet> lineDataSetList = new ArrayList<>();
        lineDataSetList.add(lineDataSet);
        LineData data = new LineData(lineDataSetList);

        // set data
        setData(data);
    }
}

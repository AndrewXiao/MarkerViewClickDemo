package com.andrewxiao.chartdemo;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

public class DemoMarkerView  extends MarkerView{
    private Context context;
    private TextView tv;
    private Button minusBtn;
    private Button addBtn;
    private float minusBtnLeft, minusBtnTop, minusBtnRight, minusBtnBottom;
    private float addBtnLeft, addBtnTop, addBtnRight, addBtnBottom;

    public DemoMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        this.context = context;
        tv = (TextView) findViewById(R.id.tv);
        minusBtn = (Button) findViewById(R.id.minus);
        addBtn = (Button) findViewById(R.id.add);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        super.refreshContent(e, highlight);
        tv.setText("x = " + e.getX() + ", y = " + e.getY());

        minusBtnLeft = minusBtn.getLeft();
        minusBtnTop = minusBtn.getTop();
        minusBtnRight = minusBtn.getRight();
        minusBtnBottom = minusBtn.getBottom();

        addBtnLeft = addBtn.getLeft();
        addBtnTop = addBtn.getTop();
        addBtnRight = addBtn.getRight();
        addBtnBottom = addBtn.getBottom();

        Log.e("Demo", "minusBtn: left = " + minusBtn.getLeft() + ", top = " + minusBtn.getTop() + ", right = " + minusBtn.getRight() + ", bottom = " + minusBtn.getBottom());
    }

    @Override
    public MPPointF getOffset() {
        MPPointF mpPointF = new MPPointF();
        mpPointF.x = - getWidth() / 2;
        mpPointF.y = - getHeight();

        return mpPointF;
    }

    @Override
    public void markViewClick() {
        Log.e("Demo", "onClick relativeTouchPointX = " + getRelativeTouchPointX() + ", relativeTouchPointY = " + getRelativeTouchPointY());
        
        float x = getRelativeTouchPointX();
        float y = getRelativeTouchPointY();

        if(new RectF(minusBtnLeft, minusBtnTop, minusBtnRight, minusBtnBottom).contains(x, y))
            Toast.makeText(context, "onClick minusButton!", Toast.LENGTH_SHORT).show();
        else if(new RectF(addBtnLeft, addBtnTop, addBtnRight, addBtnBottom).contains(x, y))
            Toast.makeText(context, "onClick addButton!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "onClick markerView!", Toast.LENGTH_SHORT).show();
    }
}

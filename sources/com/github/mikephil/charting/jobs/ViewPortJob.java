package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ViewPortJob implements Runnable {
    protected Transformer mTrans;
    protected ViewPortHandler mViewPortHandler;
    protected float[] pts = new float[2];
    protected View view;
    protected float xValue;
    protected float yValue;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f10, float f11, Transformer transformer, View view2) {
        this.mViewPortHandler = viewPortHandler;
        this.xValue = f10;
        this.yValue = f11;
        this.mTrans = transformer;
        this.view = view2;
    }

    public float getXValue() {
        return this.xValue;
    }

    public float getYValue() {
        return this.yValue;
    }
}

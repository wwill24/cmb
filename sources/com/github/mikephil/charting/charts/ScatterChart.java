package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {

    public enum ScatterShape {
        SQUARE,
        CIRCLE,
        TRIANGLE,
        CROSS,
        X
    }

    public ScatterChart(Context context) {
        super(context);
    }

    public static ScatterShape[] getAllPossibleShapes() {
        return new ScatterShape[]{ScatterShape.SQUARE, ScatterShape.CIRCLE, ScatterShape.TRIANGLE, ScatterShape.CROSS};
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        if (this.mDeltaX == 0.0f && ((ScatterData) this.mData).getYValCount() > 0) {
            this.mDeltaX = 1.0f;
        }
        float f10 = this.mXChartMax + 0.5f;
        this.mXChartMax = f10;
        this.mDeltaX = Math.abs(f10 - this.mXChartMin);
    }

    public ScatterData getScatterData() {
        return (ScatterData) this.mData;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new ScatterChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXChartMin = -0.5f;
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

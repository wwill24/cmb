package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    public LineChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        if (this.mDeltaX == 0.0f && ((LineData) this.mData).getYValCount() > 0) {
            this.mDeltaX = 1.0f;
        }
    }

    public LineData getLineData() {
        return (LineData) this.mData;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new LineChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof LineChartRenderer)) {
            ((LineChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;

public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {
    public BubbleChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        if (this.mDeltaX == 0.0f && ((BubbleData) this.mData).getYValCount() > 0) {
            this.mDeltaX = 1.0f;
        }
        this.mXChartMin = -0.5f;
        this.mXChartMax = ((float) ((BubbleData) this.mData).getXValCount()) - 0.5f;
        if (this.mRenderer != null) {
            for (IBubbleDataSet iBubbleDataSet : ((BubbleData) this.mData).getDataSets()) {
                float xMin = iBubbleDataSet.getXMin();
                float xMax = iBubbleDataSet.getXMax();
                if (xMin < this.mXChartMin) {
                    this.mXChartMin = xMin;
                }
                if (xMax > this.mXChartMax) {
                    this.mXChartMax = xMax;
                }
            }
        }
        this.mDeltaX = Math.abs(this.mXChartMax - this.mXChartMin);
    }

    public BubbleData getBubbleData() {
        return (BubbleData) this.mData;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new BubbleChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

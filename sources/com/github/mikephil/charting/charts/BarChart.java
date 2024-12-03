package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererBarChart;

public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean mDrawBarShadow = false;
    private boolean mDrawHighlightArrow = false;
    private boolean mDrawValueAboveBar = true;

    public BarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        float f10 = this.mDeltaX + 0.5f;
        this.mDeltaX = f10;
        this.mDeltaX = f10 * ((float) ((BarData) this.mData).getDataSetCount());
        float xValCount = this.mDeltaX + (((float) ((BarData) this.mData).getXValCount()) * ((BarData) this.mData).getGroupSpace());
        this.mDeltaX = xValCount;
        this.mXChartMax = xValCount - this.mXChartMin;
    }

    public RectF getBarBounds(BarEntry barEntry) {
        float f10;
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarData) this.mData).getDataSetForEntry(barEntry);
        if (iBarDataSet == null) {
            return null;
        }
        float barSpace = iBarDataSet.getBarSpace();
        float val = barEntry.getVal();
        float xIndex = (float) barEntry.getXIndex();
        float f11 = barSpace / 2.0f;
        float f12 = (xIndex - 0.5f) + f11;
        float f13 = (xIndex + 0.5f) - f11;
        if (val >= 0.0f) {
            f10 = val;
        } else {
            f10 = 0.0f;
        }
        if (val > 0.0f) {
            val = 0.0f;
        }
        RectF rectF = new RectF(f12, f10, f13, val);
        getTransformer(iBarDataSet.getAxisDependency()).rectValueToPixel(rectF);
        return rectF;
    }

    public BarData getBarData() {
        return (BarData) this.mData;
    }

    public int getHighestVisibleXIndex() {
        float f10;
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        float f11 = 1.0f;
        if (dataSetCount > 1.0f) {
            f11 = ((BarData) this.mData).getGroupSpace() + dataSetCount;
        }
        float[] fArr = {this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[0] >= getXChartMax()) {
            f10 = getXChartMax();
        } else {
            f10 = fArr[0];
        }
        return (int) (f10 / f11);
    }

    public Highlight getHighlightByTouchPoint(float f10, float f11) {
        if (this.mData == null) {
            return null;
        }
        return getHighlighter().getHighlight(f10, f11);
    }

    public int getLowestVisibleXIndex() {
        float f10;
        float f11;
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        if (dataSetCount <= 1.0f) {
            f10 = 1.0f;
        } else {
            f10 = dataSetCount + ((BarData) this.mData).getGroupSpace();
        }
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[0] <= getXChartMin()) {
            f11 = 0.0f;
        } else {
            f11 = (fArr[0] / f10) + 1.0f;
        }
        return (int) f11;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxisRenderer = new XAxisRendererBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
        setHighlighter(new BarHighlighter(this));
        this.mXChartMin = -0.5f;
    }

    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    public boolean isDrawHighlightArrowEnabled() {
        return this.mDrawHighlightArrow;
    }

    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    public void setDrawBarShadow(boolean z10) {
        this.mDrawBarShadow = z10;
    }

    public void setDrawHighlightArrow(boolean z10) {
        this.mDrawHighlightArrow = z10;
    }

    public void setDrawValueAboveBar(boolean z10) {
        this.mDrawValueAboveBar = z10;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

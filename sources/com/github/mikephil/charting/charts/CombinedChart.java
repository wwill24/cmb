package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

public class CombinedChart extends BarLineChartBase<CombinedData> implements LineDataProvider, BarDataProvider, ScatterDataProvider, CandleDataProvider, BubbleDataProvider {
    private boolean mDrawBarShadow = false;
    private boolean mDrawHighlightArrow = false;
    protected DrawOrder[] mDrawOrder = {DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
    private boolean mDrawValueAboveBar = true;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        if (!(getBarData() == null && getCandleData() == null && getBubbleData() == null)) {
            this.mXChartMin = -0.5f;
            this.mXChartMax = ((float) ((CombinedData) this.mData).getXVals().size()) - 0.5f;
            if (getBubbleData() != null) {
                for (IBubbleDataSet iBubbleDataSet : getBubbleData().getDataSets()) {
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
        }
        float abs = Math.abs(this.mXChartMax - this.mXChartMin);
        this.mDeltaX = abs;
        if (abs == 0.0f && getLineData() != null && getLineData().getYValCount() > 0) {
            this.mDeltaX = 1.0f;
        }
    }

    public BarData getBarData() {
        T t10 = this.mData;
        if (t10 == null) {
            return null;
        }
        return ((CombinedData) t10).getBarData();
    }

    public BubbleData getBubbleData() {
        T t10 = this.mData;
        if (t10 == null) {
            return null;
        }
        return ((CombinedData) t10).getBubbleData();
    }

    public CandleData getCandleData() {
        T t10 = this.mData;
        if (t10 == null) {
            return null;
        }
        return ((CombinedData) t10).getCandleData();
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    public LineData getLineData() {
        T t10 = this.mData;
        if (t10 == null) {
            return null;
        }
        return ((CombinedData) t10).getLineData();
    }

    public ScatterData getScatterData() {
        T t10 = this.mData;
        if (t10 == null) {
            return null;
        }
        return ((CombinedData) t10).getScatterData();
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        setHighlighter(new CombinedHighlighter(this));
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

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr != null && drawOrderArr.length > 0) {
            this.mDrawOrder = drawOrderArr;
        }
    }

    public void setDrawValueAboveBar(boolean z10) {
        this.mDrawValueAboveBar = z10;
    }

    public void setData(CombinedData combinedData) {
        this.mData = null;
        this.mRenderer = null;
        super.setData(combinedData);
        CombinedChartRenderer combinedChartRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mRenderer = combinedChartRenderer;
        combinedChartRenderer.initBuffers();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

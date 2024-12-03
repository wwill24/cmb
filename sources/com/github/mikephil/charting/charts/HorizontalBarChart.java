package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;

public class HorizontalBarChart extends BarChart {
    public HorizontalBarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcModulus() {
        float[] fArr = new float[9];
        this.mViewPortHandler.getMatrixTouch().getValues(fArr);
        this.mXAxis.mAxisLabelModulus = (int) Math.ceil((double) (((float) (((BarData) this.mData).getXValCount() * this.mXAxis.mLabelRotatedHeight)) / (this.mViewPortHandler.contentHeight() * fArr[4])));
        XAxis xAxis = this.mXAxis;
        if (xAxis.mAxisLabelModulus < 1) {
            xAxis.mAxisLabelModulus = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateOffsets() {
        /*
            r9 = this;
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            r1 = 0
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x00f4
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x00d2
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x0023
            goto L_0x00d2
        L_0x0023:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r0 == r2) goto L_0x00b0
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x0039
            goto L_0x00b0
        L_0x0039:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r0 == r2) goto L_0x0095
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r0 == r2) goto L_0x0095
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r0 != r2) goto L_0x0058
            goto L_0x0095
        L_0x0058:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r0 == r2) goto L_0x0076
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r0 == r2) goto L_0x0076
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r0 != r2) goto L_0x00f4
        L_0x0076:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r2 = r0.mTextHeightMax
            float r2 = r2 * r3
            float r0 = r0.mNeededHeight
            float r0 = r0 + r2
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartHeight()
            com.github.mikephil.charting.components.Legend r3 = r9.mLegend
            float r3 = r3.getMaxSizePercent()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            float r0 = r0 + r1
            r2 = r1
            r3 = r2
            r1 = r0
            r0 = r3
            goto L_0x00f7
        L_0x0095:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r2 = r0.mTextHeightMax
            float r0 = r0.mNeededHeight
            float r0 = r0 + r2
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartHeight()
            com.github.mikephil.charting.components.Legend r3 = r9.mLegend
            float r3 = r3.getMaxSizePercent()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            float r0 = r0 + r1
            r2 = r1
            goto L_0x00f6
        L_0x00b0:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mNeededWidth
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartWidth()
            com.github.mikephil.charting.components.Legend r4 = r9.mLegend
            float r4 = r4.getMaxSizePercent()
            float r2 = r2 * r4
            float r0 = java.lang.Math.min(r0, r2)
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.getXOffset()
            float r2 = r2 * r3
            float r0 = r0 + r2
            float r0 = r0 + r1
            r2 = r0
            r0 = r1
            r3 = r0
            goto L_0x00f7
        L_0x00d2:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            float r0 = r0.mNeededWidth
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r9.mViewPortHandler
            float r2 = r2.getChartWidth()
            com.github.mikephil.charting.components.Legend r4 = r9.mLegend
            float r4 = r4.getMaxSizePercent()
            float r2 = r2 * r4
            float r0 = java.lang.Math.min(r0, r2)
            com.github.mikephil.charting.components.Legend r2 = r9.mLegend
            float r2 = r2.getXOffset()
            float r2 = r2 * r3
            float r0 = r0 + r2
            float r0 = r0 + r1
            r3 = r0
            r0 = r1
            r2 = r0
            goto L_0x00f7
        L_0x00f4:
            r0 = r1
            r2 = r0
        L_0x00f6:
            r3 = r2
        L_0x00f7:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x010c
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererLeft
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredHeightSpace(r5)
            float r1 = r1 + r4
        L_0x010c:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0121
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererRight
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredHeightSpace(r5)
            float r0 = r0 + r4
        L_0x0121:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            int r5 = r4.mLabelRotatedWidth
            float r5 = (float) r5
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x0150
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
            if (r4 != r6) goto L_0x0138
            float r2 = r2 + r5
            goto L_0x0150
        L_0x0138:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.TOP
            if (r4 != r6) goto L_0x0144
        L_0x0142:
            float r3 = r3 + r5
            goto L_0x0150
        L_0x0144:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTH_SIDED
            if (r4 != r6) goto L_0x0150
            float r2 = r2 + r5
            goto L_0x0142
        L_0x0150:
            float r4 = r9.getExtraTopOffset()
            float r1 = r1 + r4
            float r4 = r9.getExtraRightOffset()
            float r3 = r3 + r4
            float r4 = r9.getExtraBottomOffset()
            float r0 = r0 + r4
            float r4 = r9.getExtraLeftOffset()
            float r2 = r2 + r4
            float r4 = r9.mMinOffset
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            com.github.mikephil.charting.utils.ViewPortHandler r5 = r9.mViewPortHandler
            float r6 = java.lang.Math.max(r4, r2)
            float r7 = java.lang.Math.max(r4, r1)
            float r8 = java.lang.Math.max(r4, r3)
            float r4 = java.lang.Math.max(r4, r0)
            r5.restrainViewPort(r6, r7, r8, r4)
            boolean r4 = r9.mLogEnabled
            if (r4 == 0) goto L_0x01bf
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", offsetTop: "
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", offsetBottom: "
            r4.append(r1)
            r4.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Content: "
            r0.append(r1)
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r9.mViewPortHandler
            android.graphics.RectF r1 = r1.getContentRect()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x01bf:
            r9.prepareOffsetMatrix()
            r9.prepareValuePxMatrix()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.HorizontalBarChart.calculateOffsets():void");
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
        RectF rectF = new RectF(f10, f12, val, f13);
        getTransformer(iBarDataSet.getAxisDependency()).rectValueToPixel(rectF);
        return rectF;
    }

    public int getHighestVisibleXIndex() {
        float f10;
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        float f11 = 1.0f;
        if (dataSetCount > 1.0f) {
            f11 = ((BarData) this.mData).getGroupSpace() + dataSetCount;
        }
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[1] >= getXChartMax()) {
            f10 = getXChartMax();
        } else {
            f10 = fArr[1];
        }
        return (int) (f10 / f11);
    }

    public Highlight getHighlightByTouchPoint(float f10, float f11) {
        if (this.mData == null) {
            return null;
        }
        return getHighlighter().getHighlight(f11, f10);
    }

    public int getLowestVisibleXIndex() {
        float f10;
        float dataSetCount = (float) ((BarData) this.mData).getDataSetCount();
        if (dataSetCount <= 1.0f) {
            f10 = 1.0f;
        } else {
            f10 = dataSetCount + ((BarData) this.mData).getGroupSpace();
        }
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f11 = fArr[1];
        float f12 = 0.0f;
        if (f11 > 0.0f) {
            f12 = f11 / f10;
        }
        return (int) (f12 + 1.0f);
    }

    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {entry.getVal(), (float) entry.getXIndex()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    /* access modifiers changed from: protected */
    public void prepareValuePxMatrix() {
        Transformer transformer = this.mRightAxisTransformer;
        YAxis yAxis = this.mAxisRight;
        transformer.prepareMatrixValuePx(yAxis.mAxisMinimum, yAxis.mAxisRange, this.mDeltaX, this.mXChartMin);
        Transformer transformer2 = this.mLeftAxisTransformer;
        YAxis yAxis2 = this.mAxisLeft;
        transformer2.prepareMatrixValuePx(yAxis2.mAxisMinimum, yAxis2.mAxisRange, this.mDeltaX, this.mXChartMin);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

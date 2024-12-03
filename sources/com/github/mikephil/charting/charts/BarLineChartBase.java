package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    private long drawCycles = 0;
    private Integer mAutoScaleLastHighestVisibleXIndex = null;
    private Integer mAutoScaleLastLowestVisibleXIndex = null;
    private boolean mAutoScaleMinMaxEnabled = false;
    protected YAxis mAxisLeft;
    protected YAxisRenderer mAxisRendererLeft;
    protected YAxisRenderer mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    private boolean mCustomViewPortEnabled = false;
    protected boolean mDoubleTapToZoomEnabled = true;
    private boolean mDragEnabled = true;
    protected boolean mDrawBorders = false;
    protected boolean mDrawGridBackground = false;
    protected OnDrawListener mDrawListener;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled = true;
    protected Transformer mLeftAxisTransformer;
    protected int mMaxVisibleCount = 100;
    protected float mMinOffset = 15.0f;
    protected boolean mPinchZoomEnabled = false;
    protected Transformer mRightAxisTransformer;
    private boolean mScaleXEnabled = true;
    private boolean mScaleYEnabled = true;
    protected XAxis mXAxis;
    protected XAxisRenderer mXAxisRenderer;
    private long totalTime = 0;

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        if (this.mAutoScaleMinMaxEnabled) {
            ((BarLineScatterCandleBubbleData) this.mData).calcMinMax(getLowestVisibleXIndex(), getHighestVisibleXIndex());
        }
        if (!Float.isNaN(this.mAxisLeft.getAxisMinValue())) {
            f10 = this.mAxisLeft.getAxisMinValue();
        } else {
            f10 = ((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.LEFT);
        }
        if (!Float.isNaN(this.mAxisLeft.getAxisMaxValue())) {
            f11 = this.mAxisLeft.getAxisMaxValue();
        } else {
            f11 = ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.LEFT);
        }
        if (!Float.isNaN(this.mAxisRight.getAxisMinValue())) {
            f12 = this.mAxisRight.getAxisMinValue();
        } else {
            f12 = ((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.RIGHT);
        }
        if (!Float.isNaN(this.mAxisRight.getAxisMaxValue())) {
            f13 = this.mAxisRight.getAxisMaxValue();
        } else {
            f13 = ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.RIGHT);
        }
        float abs = Math.abs(f11 - f10);
        float abs2 = Math.abs(f13 - f12);
        if (abs == 0.0f) {
            f11 += 1.0f;
            f10 -= 1.0f;
        }
        if (abs2 == 0.0f) {
            f13 += 1.0f;
            f12 -= 1.0f;
        }
        float f18 = abs / 100.0f;
        float spaceTop = this.mAxisLeft.getSpaceTop() * f18;
        float f19 = abs2 / 100.0f;
        float spaceTop2 = this.mAxisRight.getSpaceTop() * f19;
        float spaceBottom = f18 * this.mAxisLeft.getSpaceBottom();
        float spaceBottom2 = f19 * this.mAxisRight.getSpaceBottom();
        float size = (float) (((BarLineScatterCandleBubbleData) this.mData).getXVals().size() - 1);
        this.mXChartMax = size;
        this.mDeltaX = Math.abs(size - this.mXChartMin);
        YAxis yAxis = this.mAxisLeft;
        if (!Float.isNaN(yAxis.getAxisMinValue())) {
            f14 = this.mAxisLeft.getAxisMinValue();
        } else {
            f14 = f10 - spaceBottom;
        }
        yAxis.mAxisMinimum = f14;
        YAxis yAxis2 = this.mAxisLeft;
        if (!Float.isNaN(yAxis2.getAxisMaxValue())) {
            f15 = this.mAxisLeft.getAxisMaxValue();
        } else {
            f15 = f11 + spaceTop;
        }
        yAxis2.mAxisMaximum = f15;
        YAxis yAxis3 = this.mAxisRight;
        if (!Float.isNaN(yAxis3.getAxisMinValue())) {
            f16 = this.mAxisRight.getAxisMinValue();
        } else {
            f16 = f12 - spaceBottom2;
        }
        yAxis3.mAxisMinimum = f16;
        YAxis yAxis4 = this.mAxisRight;
        if (!Float.isNaN(yAxis4.getAxisMaxValue())) {
            f17 = this.mAxisRight.getAxisMaxValue();
        } else {
            f17 = f13 + spaceTop2;
        }
        yAxis4.mAxisMaximum = f17;
        YAxis yAxis5 = this.mAxisLeft;
        yAxis5.mAxisRange = Math.abs(yAxis5.mAxisMaximum - yAxis5.mAxisMinimum);
        YAxis yAxis6 = this.mAxisRight;
        yAxis6.mAxisRange = Math.abs(yAxis6.mAxisMaximum - yAxis6.mAxisMinimum);
    }

    /* access modifiers changed from: protected */
    public void calcModulus() {
        XAxis xAxis = this.mXAxis;
        if (xAxis != null && xAxis.isEnabled()) {
            if (!this.mXAxis.isAxisModulusCustom()) {
                float[] fArr = new float[9];
                this.mViewPortHandler.getMatrixTouch().getValues(fArr);
                this.mXAxis.mAxisLabelModulus = (int) Math.ceil((double) (((float) (((BarLineScatterCandleBubbleData) this.mData).getXValCount() * this.mXAxis.mLabelRotatedWidth)) / (this.mViewPortHandler.contentWidth() * fArr[0])));
            }
            if (this.mLogEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("X-Axis modulus: ");
                sb2.append(this.mXAxis.mAxisLabelModulus);
                sb2.append(", x-axis label width: ");
                sb2.append(this.mXAxis.mLabelWidth);
                sb2.append(", x-axis label rotated width: ");
                sb2.append(this.mXAxis.mLabelRotatedWidth);
                sb2.append(", content width: ");
                sb2.append(this.mViewPortHandler.contentWidth());
            }
            XAxis xAxis2 = this.mXAxis;
            if (xAxis2.mAxisLabelModulus < 1) {
                xAxis2.mAxisLabelModulus = 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateOffsets() {
        /*
            r9 = this;
            boolean r0 = r9.mCustomViewPortEnabled
            if (r0 != 0) goto L_0x01d2
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            r1 = 0
            if (r0 == 0) goto L_0x00f8
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x00f8
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L_0x00d8
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.RIGHT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x0027
            goto L_0x00d8
        L_0x0027:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART
            if (r0 == r2) goto L_0x00b5
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.LEFT_OF_CHART_CENTER
            if (r0 != r2) goto L_0x003d
            goto L_0x00b5
        L_0x003d:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_LEFT
            if (r0 == r2) goto L_0x0098
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_RIGHT
            if (r0 == r2) goto L_0x0098
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.BELOW_CHART_CENTER
            if (r0 != r2) goto L_0x005c
            goto L_0x0098
        L_0x005c:
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_LEFT
            if (r0 == r2) goto L_0x007a
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_RIGHT
            if (r0 == r2) goto L_0x007a
            com.github.mikephil.charting.components.Legend r0 = r9.mLegend
            com.github.mikephil.charting.components.Legend$LegendPosition r0 = r0.getPosition()
            com.github.mikephil.charting.components.Legend$LegendPosition r2 = com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER
            if (r0 != r2) goto L_0x00f8
        L_0x007a:
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
            r3 = r0
            r0 = r1
            r2 = r0
            goto L_0x00fb
        L_0x0098:
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
            r2 = r0
            r0 = r1
            r3 = r0
            goto L_0x00fb
        L_0x00b5:
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
            r2 = r1
            r3 = r2
            r1 = r0
            r0 = r3
            goto L_0x00fb
        L_0x00d8:
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
            r2 = r1
            goto L_0x00fa
        L_0x00f8:
            r0 = r1
            r2 = r0
        L_0x00fa:
            r3 = r2
        L_0x00fb:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0110
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisLeft
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererLeft
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredWidthSpace(r5)
            float r1 = r1 + r4
        L_0x0110:
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            boolean r4 = r4.needsOffset()
            if (r4 == 0) goto L_0x0125
            com.github.mikephil.charting.components.YAxis r4 = r9.mAxisRight
            com.github.mikephil.charting.renderer.YAxisRenderer r5 = r9.mAxisRendererRight
            android.graphics.Paint r5 = r5.getPaintAxisLabels()
            float r4 = r4.getRequiredWidthSpace(r5)
            float r0 = r0 + r4
        L_0x0125:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x0163
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            boolean r4 = r4.isDrawLabelsEnabled()
            if (r4 == 0) goto L_0x0163
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            int r5 = r4.mLabelRotatedHeight
            float r5 = (float) r5
            float r4 = r4.getYOffset()
            float r5 = r5 + r4
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
            if (r4 != r6) goto L_0x014b
            float r2 = r2 + r5
            goto L_0x0163
        L_0x014b:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.TOP
            if (r4 != r6) goto L_0x0157
        L_0x0155:
            float r3 = r3 + r5
            goto L_0x0163
        L_0x0157:
            com.github.mikephil.charting.components.XAxis r4 = r9.mXAxis
            com.github.mikephil.charting.components.XAxis$XAxisPosition r4 = r4.getPosition()
            com.github.mikephil.charting.components.XAxis$XAxisPosition r6 = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTH_SIDED
            if (r4 != r6) goto L_0x0163
            float r2 = r2 + r5
            goto L_0x0155
        L_0x0163:
            float r4 = r9.getExtraTopOffset()
            float r3 = r3 + r4
            float r4 = r9.getExtraRightOffset()
            float r0 = r0 + r4
            float r4 = r9.getExtraBottomOffset()
            float r2 = r2 + r4
            float r4 = r9.getExtraLeftOffset()
            float r1 = r1 + r4
            float r4 = r9.mMinOffset
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            com.github.mikephil.charting.utils.ViewPortHandler r5 = r9.mViewPortHandler
            float r6 = java.lang.Math.max(r4, r1)
            float r7 = java.lang.Math.max(r4, r3)
            float r8 = java.lang.Math.max(r4, r0)
            float r4 = java.lang.Math.max(r4, r2)
            r5.restrainViewPort(r6, r7, r8, r4)
            boolean r4 = r9.mLogEnabled
            if (r4 == 0) goto L_0x01d2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", offsetTop: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r4.append(r0)
            r4.append(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Content: "
            r0.append(r1)
            com.github.mikephil.charting.utils.ViewPortHandler r1 = r9.mViewPortHandler
            android.graphics.RectF r1 = r1.getContentRect()
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x01d2:
            r9.prepareOffsetMatrix()
            r9.prepareValuePxMatrix()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.BarLineChartBase.calculateOffsets():void");
    }

    public void centerViewTo(float f10, float f11, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f10 - ((((float) getXAxis().getValues().size()) / this.mViewPortHandler.getScaleX()) / 2.0f), f11 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void centerViewToAnimated(float f10, float f11, YAxis.AxisDependency axisDependency, long j10) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency);
        float deltaY = getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY();
        float size = ((float) getXAxis().getValues().size()) / this.mViewPortHandler.getScaleX();
        addViewportJob(new AnimatedMoveViewJob(this.mViewPortHandler, f10 - (size / 2.0f), f11 + (deltaY / 2.0f), getTransformer(axisDependency), this, (float) valuesByTouchPoint.f37954x, (float) valuesByTouchPoint.f37955y, j10));
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) chartTouchListener).computeScroll();
        }
    }

    /* access modifiers changed from: protected */
    public void drawGridBackground(Canvas canvas) {
        if (this.mDrawGridBackground) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            canvas.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
        }
    }

    public void fitScreen() {
        this.mViewPortHandler.refresh(this.mViewPortHandler.fitScreen(), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public YAxis getAxis(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft;
        }
        return this.mAxisRight;
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public IBarLineScatterCandleBubbleDataSet getDataSetByTouchPoint(float f10, float f11) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f10, f11);
        if (highlightByTouchPoint != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).getDataSetByIndex(highlightByTouchPoint.getDataSetIndex());
        }
        return null;
    }

    public float getDeltaY(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mAxisLeft.mAxisRange;
        }
        return this.mAxisRight.mAxisRange;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public Entry getEntryByTouchPoint(float f10, float f11) {
        Highlight highlightByTouchPoint = getHighlightByTouchPoint(f10, f11);
        if (highlightByTouchPoint != null) {
            return ((BarLineScatterCandleBubbleData) this.mData).getEntryForHighlight(highlightByTouchPoint);
        }
        return null;
    }

    public int getHighestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        if (fArr[0] >= ((float) ((BarLineScatterCandleBubbleData) this.mData).getXValCount())) {
            return ((BarLineScatterCandleBubbleData) this.mData).getXValCount() - 1;
        }
        return (int) fArr[0];
    }

    public Highlight getHighlightByTouchPoint(float f10, float f11) {
        if (this.mData == null) {
            return null;
        }
        return getHighlighter().getHighlight(f10, f11);
    }

    public int getLowestVisibleXIndex() {
        float[] fArr = {this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()};
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(fArr);
        float f10 = fArr[0];
        if (f10 <= 0.0f) {
            return 0;
        }
        return (int) (f10 + 1.0f);
    }

    /* access modifiers changed from: protected */
    public float[] getMarkerPosition(Entry entry, Highlight highlight) {
        float f10;
        float f11;
        float f12;
        int dataSetIndex = highlight.getDataSetIndex();
        float xIndex = (float) entry.getXIndex();
        float val = entry.getVal();
        if (this instanceof BarChart) {
            float groupSpace = ((BarData) this.mData).getGroupSpace();
            int dataSetCount = ((BarLineScatterCandleBubbleData) this.mData).getDataSetCount();
            int xIndex2 = entry.getXIndex();
            if (this instanceof HorizontalBarChart) {
                f10 = ((float) (((dataSetCount - 1) * xIndex2) + xIndex2 + dataSetIndex)) + (((float) xIndex2) * groupSpace) + (groupSpace / 2.0f);
                if (((BarEntry) entry).getVals() != null) {
                    f12 = highlight.getRange().to;
                } else {
                    f12 = entry.getVal();
                }
                xIndex = f12 * this.mAnimator.getPhaseY();
            } else {
                float f13 = ((float) (((dataSetCount - 1) * xIndex2) + xIndex2 + dataSetIndex)) + (((float) xIndex2) * groupSpace) + (groupSpace / 2.0f);
                if (((BarEntry) entry).getVals() != null) {
                    f11 = highlight.getRange().to;
                } else {
                    f11 = entry.getVal();
                }
                xIndex = f13;
                f10 = f11 * this.mAnimator.getPhaseY();
            }
        } else {
            f10 = val * this.mAnimator.getPhaseY();
        }
        float[] fArr = {xIndex, f10};
        getTransformer(((IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).getDataSetByIndex(dataSetIndex)).getAxisDependency()).pointValuesToPixel(fArr);
        return fArr;
    }

    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public Paint getPaint(int i10) {
        Paint paint = super.getPaint(i10);
        if (paint != null) {
            return paint;
        }
        if (i10 != 4) {
            return null;
        }
        return this.mGridBackgroundPaint;
    }

    public PointD getPixelsForValues(float f10, float f11, YAxis.AxisDependency axisDependency) {
        float[] fArr = {f10, f11};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointD((double) fArr[0], (double) fArr[1]);
    }

    public PointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = {(float) entry.getXIndex(), entry.getVal()};
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public float getScaleX() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.getScaleX();
    }

    public float getScaleY() {
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.getScaleY();
    }

    public Transformer getTransformer(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.mLeftAxisTransformer;
        }
        return this.mRightAxisTransformer;
    }

    public PointD getValuesByTouchPoint(float f10, float f11, YAxis.AxisDependency axisDependency) {
        float[] fArr = {f10, f11};
        getTransformer(axisDependency).pixelsToValue(fArr);
        return new PointD((double) fArr[0], (double) fArr[1]);
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public float getYChartMax() {
        return Math.max(this.mAxisLeft.mAxisMaximum, this.mAxisRight.mAxisMaximum);
    }

    public float getYChartMin() {
        return Math.min(this.mAxisLeft.mAxisMinimum, this.mAxisRight.mAxisMinimum);
    }

    public float getYValueByTouchPoint(float f10, float f11, YAxis.AxisDependency axisDependency) {
        return (float) getValuesByTouchPoint(f10, f11, axisDependency).f37955y;
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.hasNoDragOffset();
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mXAxis = new XAxis();
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        setHighlighter(new ChartHighlighter(this));
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.getMatrixTouch());
        Paint paint = new Paint();
        this.mGridBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    public boolean isAnyAxisInverted() {
        if (!this.mAxisLeft.isInverted() && !this.mAxisRight.isInverted()) {
            return false;
        }
        return true;
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.isFullyZoomedOut();
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        return getAxis(axisDependency).isInverted();
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public boolean isScaleXEnabled() {
        return this.mScaleXEnabled;
    }

    public boolean isScaleYEnabled() {
        return this.mScaleYEnabled;
    }

    public void moveViewTo(float f10, float f11, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f10, f11 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void moveViewToAnimated(float f10, float f11, YAxis.AxisDependency axisDependency, long j10) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency);
        float deltaY = getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY();
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        float f12 = f11 + (deltaY / 2.0f);
        addViewportJob(new AnimatedMoveViewJob(viewPortHandler, f10, f12, getTransformer(axisDependency), this, (float) valuesByTouchPoint.f37954x, (float) valuesByTouchPoint.f37955y, j10));
    }

    public void moveViewToX(float f10) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, f10, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this));
    }

    public void moveViewToY(float f10, YAxis.AxisDependency axisDependency) {
        addViewportJob(new MoveViewJob(this.mViewPortHandler, 0.0f, f10 + ((getDeltaY(axisDependency) / this.mViewPortHandler.getScaleY()) / 2.0f), getTransformer(axisDependency), this));
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            DataRenderer dataRenderer = this.mRenderer;
            if (dataRenderer != null) {
                dataRenderer.initBuffers();
            }
            calcMinMax();
            YAxisRenderer yAxisRenderer = this.mAxisRendererLeft;
            YAxis yAxis = this.mAxisLeft;
            yAxisRenderer.computeAxis(yAxis.mAxisMinimum, yAxis.mAxisMaximum);
            YAxisRenderer yAxisRenderer2 = this.mAxisRendererRight;
            YAxis yAxis2 = this.mAxisRight;
            yAxisRenderer2.computeAxis(yAxis2.mAxisMinimum, yAxis2.mAxisMaximum);
            this.mXAxisRenderer.computeAxis(((BarLineScatterCandleBubbleData) this.mData).getXValMaximumLength(), ((BarLineScatterCandleBubbleData) this.mData).getXVals());
            if (this.mLegend != null) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Integer num;
        super.onDraw(canvas);
        if (this.mData != null) {
            long currentTimeMillis = System.currentTimeMillis();
            calcModulus();
            this.mXAxisRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
            this.mRenderer.calcXBounds(this, this.mXAxis.mAxisLabelModulus);
            drawGridBackground(canvas);
            if (this.mAxisLeft.isEnabled()) {
                YAxisRenderer yAxisRenderer = this.mAxisRendererLeft;
                YAxis yAxis = this.mAxisLeft;
                yAxisRenderer.computeAxis(yAxis.mAxisMinimum, yAxis.mAxisMaximum);
            }
            if (this.mAxisRight.isEnabled()) {
                YAxisRenderer yAxisRenderer2 = this.mAxisRendererRight;
                YAxis yAxis2 = this.mAxisRight;
                yAxisRenderer2.computeAxis(yAxis2.mAxisMinimum, yAxis2.mAxisMaximum);
            }
            this.mXAxisRenderer.renderAxisLine(canvas);
            this.mAxisRendererLeft.renderAxisLine(canvas);
            this.mAxisRendererRight.renderAxisLine(canvas);
            if (this.mAutoScaleMinMaxEnabled) {
                int lowestVisibleXIndex = getLowestVisibleXIndex();
                int highestVisibleXIndex = getHighestVisibleXIndex();
                Integer num2 = this.mAutoScaleLastLowestVisibleXIndex;
                if (num2 == null || num2.intValue() != lowestVisibleXIndex || (num = this.mAutoScaleLastHighestVisibleXIndex) == null || num.intValue() != highestVisibleXIndex) {
                    calcMinMax();
                    calculateOffsets();
                    this.mAutoScaleLastLowestVisibleXIndex = Integer.valueOf(lowestVisibleXIndex);
                    this.mAutoScaleLastHighestVisibleXIndex = Integer.valueOf(highestVisibleXIndex);
                }
            }
            int save = canvas.save();
            canvas.clipRect(this.mViewPortHandler.getContentRect());
            this.mXAxisRenderer.renderGridLines(canvas);
            this.mAxisRendererLeft.renderGridLines(canvas);
            this.mAxisRendererRight.renderGridLines(canvas);
            if (this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
                this.mXAxisRenderer.renderLimitLines(canvas);
            }
            if (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererLeft.renderLimitLines(canvas);
            }
            if (this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererRight.renderLimitLines(canvas);
            }
            this.mRenderer.drawData(canvas);
            if (!this.mXAxis.isDrawLimitLinesBehindDataEnabled()) {
                this.mXAxisRenderer.renderLimitLines(canvas);
            }
            if (!this.mAxisLeft.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererLeft.renderLimitLines(canvas);
            }
            if (!this.mAxisRight.isDrawLimitLinesBehindDataEnabled()) {
                this.mAxisRendererRight.renderLimitLines(canvas);
            }
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            canvas.restoreToCount(save);
            this.mRenderer.drawExtras(canvas);
            this.mXAxisRenderer.renderAxisLabels(canvas);
            this.mAxisRendererLeft.renderAxisLabels(canvas);
            this.mAxisRendererRight.renderAxisLabels(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawMarkers(canvas);
            drawDescription(canvas);
            if (this.mLogEnabled) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j10 = this.totalTime + currentTimeMillis2;
                this.totalTime = j10;
                long j11 = this.drawCycles + 1;
                this.drawCycles = j11;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Drawtime: ");
                sb2.append(currentTimeMillis2);
                sb2.append(" ms, average: ");
                sb2.append(j10 / j11);
                sb2.append(" ms, cycles: ");
                sb2.append(this.drawCycles);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener == null || this.mData == null || !this.mTouchEnabled) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    /* access modifiers changed from: protected */
    public void prepareOffsetMatrix() {
        this.mRightAxisTransformer.prepareMatrixOffset(this.mAxisRight.isInverted());
        this.mLeftAxisTransformer.prepareMatrixOffset(this.mAxisLeft.isInverted());
    }

    /* access modifiers changed from: protected */
    public void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Preparing Value-Px Matrix, xmin: ");
            sb2.append(this.mXChartMin);
            sb2.append(", xmax: ");
            sb2.append(this.mXChartMax);
            sb2.append(", xdelta: ");
            sb2.append(this.mDeltaX);
        }
        Transformer transformer = this.mRightAxisTransformer;
        float f10 = this.mXChartMin;
        float f11 = this.mDeltaX;
        YAxis yAxis = this.mAxisRight;
        transformer.prepareMatrixValuePx(f10, f11, yAxis.mAxisRange, yAxis.mAxisMinimum);
        Transformer transformer2 = this.mLeftAxisTransformer;
        float f12 = this.mXChartMin;
        float f13 = this.mDeltaX;
        YAxis yAxis2 = this.mAxisLeft;
        transformer2.prepareMatrixValuePx(f12, f13, yAxis2.mAxisRange, yAxis2.mAxisMinimum);
    }

    public void resetTracking() {
        this.totalTime = 0;
        this.drawCycles = 0;
    }

    public void resetViewPortOffsets() {
        this.mCustomViewPortEnabled = false;
        calculateOffsets();
    }

    public void setAutoScaleMinMaxEnabled(boolean z10) {
        this.mAutoScaleMinMaxEnabled = z10;
    }

    public void setBorderColor(int i10) {
        this.mBorderPaint.setColor(i10);
    }

    public void setBorderWidth(float f10) {
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(f10));
    }

    public void setDoubleTapToZoomEnabled(boolean z10) {
        this.mDoubleTapToZoomEnabled = z10;
    }

    public void setDragEnabled(boolean z10) {
        this.mDragEnabled = z10;
    }

    public void setDragOffsetX(float f10) {
        this.mViewPortHandler.setDragOffsetX(f10);
    }

    public void setDragOffsetY(float f10) {
        this.mViewPortHandler.setDragOffsetY(f10);
    }

    public void setDrawBorders(boolean z10) {
        this.mDrawBorders = z10;
    }

    public void setDrawGridBackground(boolean z10) {
        this.mDrawGridBackground = z10;
    }

    public void setGridBackgroundColor(int i10) {
        this.mGridBackgroundPaint.setColor(i10);
    }

    public void setHighlightPerDragEnabled(boolean z10) {
        this.mHighlightPerDragEnabled = z10;
    }

    public void setMaxVisibleValueCount(int i10) {
        this.mMaxVisibleCount = i10;
    }

    public void setMinOffset(float f10) {
        this.mMinOffset = f10;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mDrawListener = onDrawListener;
    }

    public void setPaint(Paint paint, int i10) {
        super.setPaint(paint, i10);
        if (i10 == 4) {
            this.mGridBackgroundPaint = paint;
        }
    }

    public void setPinchZoom(boolean z10) {
        this.mPinchZoomEnabled = z10;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererLeft = yAxisRenderer;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.mAxisRendererRight = yAxisRenderer;
    }

    public void setScaleEnabled(boolean z10) {
        this.mScaleXEnabled = z10;
        this.mScaleYEnabled = z10;
    }

    public void setScaleMinima(float f10, float f11) {
        this.mViewPortHandler.setMinimumScaleX(f10);
        this.mViewPortHandler.setMinimumScaleY(f11);
    }

    public void setScaleXEnabled(boolean z10) {
        this.mScaleXEnabled = z10;
    }

    public void setScaleYEnabled(boolean z10) {
        this.mScaleYEnabled = z10;
    }

    public void setViewPortOffsets(float f10, float f11, float f12, float f13) {
        this.mCustomViewPortEnabled = true;
        final float f14 = f10;
        final float f15 = f11;
        final float f16 = f12;
        final float f17 = f13;
        post(new Runnable() {
            public void run() {
                BarLineChartBase.this.mViewPortHandler.restrainViewPort(f14, f15, f16, f17);
                BarLineChartBase.this.prepareOffsetMatrix();
                BarLineChartBase.this.prepareValuePxMatrix();
            }
        });
    }

    public void setVisibleXRange(float f10, float f11) {
        float f12 = this.mDeltaX;
        float f13 = f12 / f10;
        this.mViewPortHandler.setMinMaxScaleX(f12 / f11, f13);
    }

    public void setVisibleXRangeMaximum(float f10) {
        this.mViewPortHandler.setMinimumScaleX(this.mDeltaX / f10);
    }

    public void setVisibleXRangeMinimum(float f10) {
        this.mViewPortHandler.setMaximumScaleX(this.mDeltaX / f10);
    }

    public void setVisibleYRangeMaximum(float f10, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMinimumScaleY(getDeltaY(axisDependency) / f10);
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.mXAxisRenderer = xAxisRenderer;
    }

    public void zoom(float f10, float f11, float f12, float f13) {
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoom(f10, f11, f12, -f13), this, false);
        calculateOffsets();
        postInvalidate();
    }

    @TargetApi(11)
    public void zoomAndCenterAnimated(float f10, float f11, float f12, float f13, YAxis.AxisDependency axisDependency, long j10) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        PointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), axisDependency2);
        AnimatedZoomJob animatedZoomJob = r0;
        AnimatedZoomJob animatedZoomJob2 = new AnimatedZoomJob(this.mViewPortHandler, this, getTransformer(axisDependency2), getAxis(axisDependency2), (float) this.mXAxis.getValues().size(), f10, f11, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), f12, f13, (float) valuesByTouchPoint.f37954x, (float) valuesByTouchPoint.f37955y, j10);
        addViewportJob(animatedZoomJob);
    }

    public void zoomIn() {
        PointF contentCenter = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomIn(contentCenter.x, -contentCenter.y), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomOut() {
        PointF contentCenter = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.refresh(this.mViewPortHandler.zoomOut(contentCenter.x, -contentCenter.y), this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float f10, float f11, float f12, float f13, YAxis.AxisDependency axisDependency) {
        addViewportJob(new ZoomJob(this.mViewPortHandler, f10, f11, f12, f13, getTransformer(axisDependency), axisDependency, this));
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarLineChartBase(Context context) {
        super(context);
    }
}

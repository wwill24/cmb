package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;
import net.bytebuddy.jar.asm.Opcodes;

public class RadarChart extends PieRadarChartBase<RadarData> {
    private boolean mDrawWeb = true;
    private float mInnerWebLineWidth = 1.5f;
    private int mSkipWebLineCount = 0;
    private int mWebAlpha = Opcodes.FCMPG;
    private int mWebColor = Color.rgb(122, 122, 122);
    private int mWebColorInner = Color.rgb(122, 122, 122);
    private float mWebLineWidth = 2.5f;
    private XAxis mXAxis;
    protected XAxisRendererRadarChart mXAxisRenderer;
    private YAxis mYAxis;
    protected YAxisRendererRadarChart mYAxisRenderer;

    public RadarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        float f10;
        float f11;
        float f12;
        float f13;
        super.calcMinMax();
        if (!Float.isNaN(this.mYAxis.getAxisMinValue())) {
            f10 = this.mYAxis.getAxisMinValue();
        } else {
            f10 = ((RadarData) this.mData).getYMin(YAxis.AxisDependency.LEFT);
        }
        if (!Float.isNaN(this.mYAxis.getAxisMaxValue())) {
            f11 = this.mYAxis.getAxisMaxValue();
        } else {
            f11 = ((RadarData) this.mData).getYMax(YAxis.AxisDependency.LEFT);
        }
        float size = (float) (((RadarData) this.mData).getXVals().size() - 1);
        this.mXChartMax = size;
        this.mDeltaX = Math.abs(size - this.mXChartMin);
        float abs = Math.abs(f11 - f10) / 100.0f;
        float spaceTop = this.mYAxis.getSpaceTop() * abs;
        float spaceBottom = abs * this.mYAxis.getSpaceBottom();
        float size2 = (float) (((RadarData) this.mData).getXVals().size() - 1);
        this.mXChartMax = size2;
        this.mDeltaX = Math.abs(size2 - this.mXChartMin);
        YAxis yAxis = this.mYAxis;
        if (!Float.isNaN(yAxis.getAxisMinValue())) {
            f12 = this.mYAxis.getAxisMinValue();
        } else {
            f12 = f10 - spaceBottom;
        }
        yAxis.mAxisMinimum = f12;
        YAxis yAxis2 = this.mYAxis;
        if (!Float.isNaN(yAxis2.getAxisMaxValue())) {
            f13 = this.mYAxis.getAxisMaxValue();
        } else {
            f13 = f11 + spaceTop;
        }
        yAxis2.mAxisMaximum = f13;
        YAxis yAxis3 = this.mYAxis;
        yAxis3.mAxisRange = Math.abs(yAxis3.mAxisMaximum - yAxis3.mAxisMinimum);
    }

    public float getFactor() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f) / this.mYAxis.mAxisRange;
    }

    public int getIndexForAngle(float f10) {
        float normalizedAngle = Utils.getNormalizedAngle(f10 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int i10 = 0;
        while (i10 < ((RadarData) this.mData).getXValCount()) {
            int i11 = i10 + 1;
            if ((((float) i11) * sliceAngle) - (sliceAngle / 2.0f) > normalizedAngle) {
                return i10;
            }
            i10 = i11;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public float[] getMarkerPosition(Entry entry, Highlight highlight) {
        float sliceAngle = (getSliceAngle() * ((float) entry.getXIndex())) + getRotationAngle();
        float val = entry.getVal() * getFactor();
        PointF centerOffsets = getCenterOffsets();
        double d10 = (double) val;
        double d11 = (double) sliceAngle;
        PointF pointF = new PointF((float) (((double) centerOffsets.x) + (Math.cos(Math.toRadians(d11)) * d10)), (float) (((double) centerOffsets.y) + (d10 * Math.sin(Math.toRadians(d11)))));
        return new float[]{pointF.x, pointF.y};
    }

    public float getRadius() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        if (!this.mXAxis.isEnabled() || !this.mXAxis.isDrawLabelsEnabled()) {
            return Utils.convertDpToPixel(10.0f);
        }
        return (float) this.mXAxis.mLabelRotatedWidth;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.mSkipWebLineCount;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((RadarData) this.mData).getXValCount());
    }

    public int getWebAlpha() {
        return this.mWebAlpha;
    }

    public int getWebColor() {
        return this.mWebColor;
    }

    public int getWebColorInner() {
        return this.mWebColorInner;
    }

    public float getWebLineWidth() {
        return this.mWebLineWidth;
    }

    public float getWebLineWidthInner() {
        return this.mInnerWebLineWidth;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public YAxis getYAxis() {
        return this.mYAxis;
    }

    public float getYChartMax() {
        return this.mYAxis.mAxisMaximum;
    }

    public float getYChartMin() {
        return this.mYAxis.mAxisMinimum;
    }

    public float getYRange() {
        return this.mYAxis.mAxisRange;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
        XAxis xAxis = new XAxis();
        this.mXAxis = xAxis;
        xAxis.setSpaceBetweenLabels(0);
        this.mWebLineWidth = Utils.convertDpToPixel(1.5f);
        this.mInnerWebLineWidth = Utils.convertDpToPixel(0.75f);
        this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.mYAxis, this);
        this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            calcMinMax();
            YAxisRendererRadarChart yAxisRendererRadarChart = this.mYAxisRenderer;
            YAxis yAxis = this.mYAxis;
            yAxisRendererRadarChart.computeAxis(yAxis.mAxisMinimum, yAxis.mAxisMaximum);
            this.mXAxisRenderer.computeAxis(((RadarData) this.mData).getXValMaximumLength(), ((RadarData) this.mData).getXVals());
            Legend legend = this.mLegend;
            if (legend != null && !legend.isLegendCustom()) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            this.mXAxisRenderer.renderAxisLabels(canvas);
            if (this.mDrawWeb) {
                this.mRenderer.drawExtras(canvas);
            }
            this.mYAxisRenderer.renderLimitLines(canvas);
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            this.mYAxisRenderer.renderAxisLabels(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public void setDrawWeb(boolean z10) {
        this.mDrawWeb = z10;
    }

    public void setSkipWebLineCount(int i10) {
        this.mSkipWebLineCount = Math.max(0, i10);
    }

    public void setWebAlpha(int i10) {
        this.mWebAlpha = i10;
    }

    public void setWebColor(int i10) {
        this.mWebColor = i10;
    }

    public void setWebColorInner(int i10) {
        this.mWebColorInner = i10;
    }

    public void setWebLineWidth(float f10) {
        this.mWebLineWidth = Utils.convertDpToPixel(f10);
    }

    public void setWebLineWidthInner(float f10) {
        this.mInnerWebLineWidth = Utils.convertDpToPixel(f10);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

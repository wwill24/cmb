package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText = "";
    private float mCenterTextRadiusPercent = 100.0f;
    private RectF mCircleBox = new RectF();
    private float[] mDrawAngles;
    private boolean mDrawCenterText = true;
    private boolean mDrawHole = true;
    private boolean mDrawRoundedSlices = false;
    private boolean mDrawSlicesUnderHole = false;
    private boolean mDrawXLabels = true;
    private float mHoleRadiusPercent = 50.0f;
    protected float mMaxAngle = 360.0f;
    protected float mTransparentCircleRadiusPercent = 55.0f;
    private boolean mUsePercentValues = false;

    public PieChart(Context context) {
        super(context);
    }

    private float calcAngle(float f10) {
        return calcAngle(f10, ((PieData) this.mData).getYValueSum());
    }

    private void calcAngles() {
        this.mDrawAngles = new float[((PieData) this.mData).getYValCount()];
        this.mAbsoluteAngles = new float[((PieData) this.mData).getYValCount()];
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List dataSets = ((PieData) this.mData).getDataSets();
        int i10 = 0;
        for (int i11 = 0; i11 < ((PieData) this.mData).getDataSetCount(); i11++) {
            IPieDataSet iPieDataSet = (IPieDataSet) dataSets.get(i11);
            for (int i12 = 0; i12 < iPieDataSet.getEntryCount(); i12++) {
                this.mDrawAngles[i10] = calcAngle(Math.abs(iPieDataSet.getEntryForIndex(i12).getVal()), yValueSum);
                if (i10 == 0) {
                    this.mAbsoluteAngles[i10] = this.mDrawAngles[i10];
                } else {
                    float[] fArr = this.mAbsoluteAngles;
                    fArr[i10] = fArr[i10 - 1] + this.mDrawAngles[i10];
                }
                i10++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        calcAngles();
    }

    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData != null) {
            float diameter = getDiameter() / 2.0f;
            PointF centerOffsets = getCenterOffsets();
            float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
            RectF rectF = this.mCircleBox;
            float f10 = centerOffsets.x;
            float f11 = centerOffsets.y;
            rectF.set((f10 - diameter) + selectionShift, (f11 - diameter) + selectionShift, (f10 + diameter) - selectionShift, (f11 + diameter) - selectionShift);
        }
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public PointF getCenterCircleBox() {
        return new PointF(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i10) {
        List dataSets = ((PieData) this.mData).getDataSets();
        for (int i11 = 0; i11 < dataSets.size(); i11++) {
            if (((IPieDataSet) dataSets.get(i11)).getEntryForXIndex(i10) != null) {
                return i11;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    public int getIndexForAngle(float f10) {
        float normalizedAngle = Utils.getNormalizedAngle(f10 - getRotationAngle());
        int i10 = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i10 >= fArr.length) {
                return -1;
            }
            if (fArr[i10] > normalizedAngle) {
                return i10;
            }
            i10++;
        }
    }

    /* access modifiers changed from: protected */
    public float[] getMarkerPosition(Entry entry, Highlight highlight) {
        PointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f10 = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f10 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f11 = radius - f10;
        float rotationAngle = getRotationAngle();
        int xIndex = entry.getXIndex();
        float f12 = this.mDrawAngles[xIndex] / 2.0f;
        double d10 = (double) f11;
        return new float[]{(float) ((Math.cos(Math.toRadians((double) (((this.mAbsoluteAngles[xIndex] + rotationAngle) - f12) * this.mAnimator.getPhaseY()))) * d10) + ((double) centerCircleBox.x)), (float) ((d10 * Math.sin(Math.toRadians((double) (((rotationAngle + this.mAbsoluteAngles[xIndex]) - f12) * this.mAnimator.getPhaseY())))) + ((double) centerCircleBox.y))};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSliceTextEnabled() {
        return this.mDrawXLabels;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public boolean needsHighlight(int i10, int i11) {
        if (valuesToHighlight() && i11 >= 0) {
            int i12 = 0;
            while (true) {
                Highlight[] highlightArr = this.mIndicesToHighlight;
                if (i12 >= highlightArr.length) {
                    break;
                } else if (highlightArr[i12].getXIndex() == i10 && this.mIndicesToHighlight[i12].getDataSetIndex() == i11) {
                    return true;
                } else {
                    i12++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            this.mRenderer.drawExtras(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = "";
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i10) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i10);
    }

    public void setCenterTextRadiusPercent(float f10) {
        this.mCenterTextRadiusPercent = f10;
    }

    public void setCenterTextSize(float f10) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f10));
    }

    public void setCenterTextSizePixels(float f10) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f10);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z10) {
        this.mDrawCenterText = z10;
    }

    public void setDrawHoleEnabled(boolean z10) {
        this.mDrawHole = z10;
    }

    public void setDrawSliceText(boolean z10) {
        this.mDrawXLabels = z10;
    }

    public void setDrawSlicesUnderHole(boolean z10) {
        this.mDrawSlicesUnderHole = z10;
    }

    public void setHoleColor(int i10) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i10);
    }

    public void setHoleRadius(float f10) {
        this.mHoleRadiusPercent = f10;
    }

    public void setMaxAngle(float f10) {
        if (f10 > 360.0f) {
            f10 = 360.0f;
        }
        if (f10 < 90.0f) {
            f10 = 90.0f;
        }
        this.mMaxAngle = f10;
    }

    public void setTransparentCircleAlpha(int i10) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i10);
    }

    public void setTransparentCircleColor(int i10) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i10);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f10) {
        this.mTransparentCircleRadiusPercent = f10;
    }

    public void setUsePercentValues(boolean z10) {
        this.mUsePercentValues = z10;
    }

    private float calcAngle(float f10, float f11) {
        return (f10 / f11) * this.mMaxAngle;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

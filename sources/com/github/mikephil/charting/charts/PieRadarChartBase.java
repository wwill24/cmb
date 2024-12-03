package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset = 0.0f;
    private float mRawRotationAngle = 270.0f;
    protected boolean mRotateEnabled = true;
    private float mRotationAngle = 270.0f;

    public PieRadarChartBase(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        this.mDeltaX = (float) (this.mData.getXVals().size() - 1);
    }

    public void calculateOffsets() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float convertDpToPixel;
        float f15;
        float f16;
        Legend legend = this.mLegend;
        float f17 = 0.0f;
        if (legend == null || !legend.isEnabled()) {
            f12 = 0.0f;
            f11 = 0.0f;
            f10 = 0.0f;
        } else {
            float min = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getFormSize() + this.mLegend.getFormToTextSpace();
            if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART_CENTER) {
                f14 = min + Utils.convertDpToPixel(13.0f);
            } else if (this.mLegend.getPosition() == Legend.LegendPosition.RIGHT_OF_CHART) {
                f14 = min + Utils.convertDpToPixel(8.0f);
                Legend legend2 = this.mLegend;
                float f18 = legend2.mNeededHeight + legend2.mTextHeightMax;
                PointF center = getCenter();
                PointF pointF = new PointF((((float) getWidth()) - f14) + 15.0f, f18 + 15.0f);
                float distanceToCenter = distanceToCenter(pointF.x, pointF.y);
                PointF position = getPosition(center, getRadius(), getAngleForPoint(pointF.x, pointF.y));
                float distanceToCenter2 = distanceToCenter(position.x, position.y);
                float convertDpToPixel2 = Utils.convertDpToPixel(5.0f);
                if (distanceToCenter < distanceToCenter2) {
                    f16 = convertDpToPixel2 + (distanceToCenter2 - distanceToCenter);
                } else {
                    f16 = 0.0f;
                }
                if (pointF.y < center.y || ((float) getHeight()) - f14 <= ((float) getWidth())) {
                    f14 = f16;
                }
            } else {
                if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART_CENTER) {
                    convertDpToPixel = min + Utils.convertDpToPixel(13.0f);
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.LEFT_OF_CHART) {
                    convertDpToPixel = min + Utils.convertDpToPixel(8.0f);
                    Legend legend3 = this.mLegend;
                    float f19 = legend3.mNeededHeight + legend3.mTextHeightMax;
                    PointF center2 = getCenter();
                    PointF pointF2 = new PointF(convertDpToPixel - 15.0f, f19 + 15.0f);
                    float distanceToCenter3 = distanceToCenter(pointF2.x, pointF2.y);
                    PointF position2 = getPosition(center2, getRadius(), getAngleForPoint(pointF2.x, pointF2.y));
                    float distanceToCenter4 = distanceToCenter(position2.x, position2.y);
                    float convertDpToPixel3 = Utils.convertDpToPixel(5.0f);
                    if (distanceToCenter3 < distanceToCenter4) {
                        f15 = convertDpToPixel3 + (distanceToCenter4 - distanceToCenter3);
                    } else {
                        f15 = 0.0f;
                    }
                    if (pointF2.y < center2.y || ((float) getHeight()) - convertDpToPixel <= ((float) getWidth())) {
                        convertDpToPixel = f15;
                    }
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_LEFT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_RIGHT || this.mLegend.getPosition() == Legend.LegendPosition.BELOW_CHART_CENTER) {
                    f10 = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                    f14 = 0.0f;
                    f13 = 0.0f;
                    f17 += getRequiredBaseOffset();
                    f12 = f14 + getRequiredBaseOffset();
                    f11 = f13 + getRequiredBaseOffset();
                } else if (this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_LEFT || this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_RIGHT || this.mLegend.getPosition() == Legend.LegendPosition.ABOVE_CHART_CENTER) {
                    f13 = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                    f14 = 0.0f;
                    f10 = 0.0f;
                    f17 += getRequiredBaseOffset();
                    f12 = f14 + getRequiredBaseOffset();
                    f11 = f13 + getRequiredBaseOffset();
                } else {
                    f14 = 0.0f;
                    f13 = 0.0f;
                    f10 = f13;
                    f17 += getRequiredBaseOffset();
                    f12 = f14 + getRequiredBaseOffset();
                    f11 = f13 + getRequiredBaseOffset();
                }
                f13 = 0.0f;
                f10 = 0.0f;
                f17 = convertDpToPixel;
                f14 = 0.0f;
                f17 += getRequiredBaseOffset();
                f12 = f14 + getRequiredBaseOffset();
                f11 = f13 + getRequiredBaseOffset();
            }
            f13 = 0.0f;
            f10 = f13;
            f17 += getRequiredBaseOffset();
            f12 = f14 + getRequiredBaseOffset();
            f11 = f13 + getRequiredBaseOffset();
        }
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mMinOffset);
        if (this instanceof RadarChart) {
            XAxis xAxis = ((RadarChart) this).getXAxis();
            if (xAxis.isEnabled() && xAxis.isDrawLabelsEnabled()) {
                convertDpToPixel4 = Math.max(convertDpToPixel4, (float) xAxis.mLabelRotatedWidth);
            }
        }
        float extraTopOffset = f11 + getExtraTopOffset();
        float extraRightOffset = f12 + getExtraRightOffset();
        float extraBottomOffset = f10 + getExtraBottomOffset();
        float max = Math.max(convertDpToPixel4, f17 + getExtraLeftOffset());
        float max2 = Math.max(convertDpToPixel4, extraTopOffset);
        float max3 = Math.max(convertDpToPixel4, extraRightOffset);
        float max4 = Math.max(convertDpToPixel4, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.mViewPortHandler.restrainViewPort(max, max2, max3, max4);
        if (this.mLogEnabled) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("offsetLeft: ");
            sb2.append(max);
            sb2.append(", offsetTop: ");
            sb2.append(max2);
            sb2.append(", offsetRight: ");
            sb2.append(max3);
            sb2.append(", offsetBottom: ");
            sb2.append(max4);
        }
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) chartTouchListener).computeScroll();
        }
    }

    public float distanceToCenter(float f10, float f11) {
        float f12;
        float f13;
        PointF centerOffsets = getCenterOffsets();
        float f14 = centerOffsets.x;
        if (f10 > f14) {
            f12 = f10 - f14;
        } else {
            f12 = f14 - f10;
        }
        float f15 = centerOffsets.y;
        if (f11 > f15) {
            f13 = f11 - f15;
        } else {
            f13 = f15 - f11;
        }
        return (float) Math.sqrt(Math.pow((double) f12, 2.0d) + Math.pow((double) f13, 2.0d));
    }

    public float getAngleForPoint(float f10, float f11) {
        PointF centerOffsets = getCenterOffsets();
        double d10 = (double) (f10 - centerOffsets.x);
        double d11 = (double) (f11 - centerOffsets.y);
        float degrees = (float) Math.toDegrees(Math.acos(d11 / Math.sqrt((d10 * d10) + (d11 * d11))));
        if (f10 > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f12 = degrees + 90.0f;
        if (f12 > 360.0f) {
            return f12 - 360.0f;
        }
        return f12;
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width(), contentRect.height());
    }

    public abstract int getIndexForAngle(float f10);

    public float getMinOffset() {
        return this.mMinOffset;
    }

    /* access modifiers changed from: protected */
    public PointF getPosition(PointF pointF, float f10, float f11) {
        double d10 = (double) f10;
        double d11 = (double) f11;
        return new PointF((float) (((double) pointF.x) + (Math.cos(Math.toRadians(d11)) * d10)), (float) (((double) pointF.y) + (d10 * Math.sin(Math.toRadians(d11)))));
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    /* access modifiers changed from: protected */
    public abstract float getRequiredBaseOffset();

    /* access modifiers changed from: protected */
    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public List<SelectionDetail> getSelectionDetailsAtIndex(int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.mData.getDataSetCount(); i11++) {
            IDataSet dataSetByIndex = this.mData.getDataSetByIndex(i11);
            float yValForXIndex = dataSetByIndex.getYValForXIndex(i10);
            if (yValForXIndex != Float.NaN) {
                arrayList.add(new SelectionDetail(yValForXIndex, i11, dataSetByIndex));
            }
        }
        return arrayList;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            calcMinMax();
            if (this.mLegend != null) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        if (!this.mTouchEnabled || (chartTouchListener = this.mChartTouchListener) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f10) {
        this.mMinOffset = f10;
    }

    public void setRotationAngle(float f10) {
        this.mRawRotationAngle = f10;
        this.mRotationAngle = Utils.getNormalizedAngle(f10);
    }

    public void setRotationEnabled(boolean z10) {
        this.mRotateEnabled = z10;
    }

    @SuppressLint({"NewApi"})
    public void spin(int i10, float f10, float f11, Easing.EasingOption easingOption) {
        setRotationAngle(f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", new float[]{f10, f11});
        ofFloat.setDuration((long) i10);
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        ofFloat.start();
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

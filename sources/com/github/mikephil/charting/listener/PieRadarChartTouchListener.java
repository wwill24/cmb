package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private ArrayList<AngularVelocitySample> _velocitySamples = new ArrayList<>();
    private float mDecelerationAngularVelocity = 0.0f;
    private long mDecelerationLastTime = 0;
    private float mStartAngle = 0.0f;
    private PointF mTouchStartPoint = new PointF();

    private class AngularVelocitySample {
        public float angle;
        public long time;

        public AngularVelocitySample(long j10, float f10) {
            this.time = j10;
            this.angle = f10;
        }
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
    }

    private float calculateVelocity() {
        if (this._velocitySamples.isEmpty()) {
            return 0.0f;
        }
        boolean z10 = false;
        AngularVelocitySample angularVelocitySample = this._velocitySamples.get(0);
        ArrayList<AngularVelocitySample> arrayList = this._velocitySamples;
        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this._velocitySamples.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = this._velocitySamples.get(size);
            if (angularVelocitySample3.angle != angularVelocitySample2.angle) {
                break;
            }
        }
        float f10 = ((float) (angularVelocitySample2.time - angularVelocitySample.time)) / 1000.0f;
        if (f10 == 0.0f) {
            f10 = 0.1f;
        }
        float f11 = angularVelocitySample2.angle;
        float f12 = angularVelocitySample3.angle;
        if (f11 >= f12) {
            z10 = true;
        }
        if (((double) Math.abs(f11 - f12)) > 270.0d) {
            z10 = !z10;
        }
        float f13 = angularVelocitySample2.angle;
        float f14 = angularVelocitySample.angle;
        if (((double) (f13 - f14)) > 180.0d) {
            angularVelocitySample.angle = (float) (((double) f14) + 360.0d);
        } else if (((double) (f14 - f13)) > 180.0d) {
            angularVelocitySample2.angle = (float) (((double) f13) + 360.0d);
        }
        float abs = Math.abs((angularVelocitySample2.angle - angularVelocitySample.angle) / f10);
        if (!z10) {
            return -abs;
        }
        return abs;
    }

    private void resetVelocity() {
        this._velocitySamples.clear();
    }

    private void sampleVelocity(float f10, float f11) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this._velocitySamples.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.mChart).getAngleForPoint(f10, f11)));
        for (int size = this._velocitySamples.size(); size - 2 > 0 && currentAnimationTimeMillis - this._velocitySamples.get(0).time > 1000; size--) {
            this._velocitySamples.remove(0);
        }
    }

    public void computeScroll() {
        if (this.mDecelerationAngularVelocity != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mDecelerationAngularVelocity *= ((PieRadarChartBase) this.mChart).getDragDecelerationFrictionCoef();
            T t10 = this.mChart;
            ((PieRadarChartBase) t10).setRotationAngle(((PieRadarChartBase) t10).getRotationAngle() + (this.mDecelerationAngularVelocity * (((float) (currentAnimationTimeMillis - this.mDecelerationLastTime)) / 1000.0f)));
            this.mDecelerationLastTime = currentAnimationTimeMillis;
            if (((double) Math.abs(this.mDecelerationAngularVelocity)) >= 0.001d) {
                Utils.postInvalidateOnAnimation(this.mChart);
            } else {
                stopDeceleration();
            }
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        int i10 = 0;
        if (!((PieRadarChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        float distanceToCenter = ((PieRadarChartBase) this.mChart).distanceToCenter(motionEvent.getX(), motionEvent.getY());
        if (distanceToCenter > ((PieRadarChartBase) this.mChart).getRadius()) {
            if (this.mLastHighlighted == null) {
                ((PieRadarChartBase) this.mChart).highlightValues((Highlight[]) null);
            } else {
                ((PieRadarChartBase) this.mChart).highlightTouch((Highlight) null);
            }
            this.mLastHighlighted = null;
            return true;
        }
        float angleForPoint = ((PieRadarChartBase) this.mChart).getAngleForPoint(motionEvent.getX(), motionEvent.getY());
        T t10 = this.mChart;
        if (t10 instanceof PieChart) {
            angleForPoint /= ((PieRadarChartBase) t10).getAnimator().getPhaseY();
        }
        int indexForAngle = ((PieRadarChartBase) this.mChart).getIndexForAngle(angleForPoint);
        if (indexForAngle < 0) {
            ((PieRadarChartBase) this.mChart).highlightValues((Highlight[]) null);
            this.mLastHighlighted = null;
            return true;
        }
        List<SelectionDetail> selectionDetailsAtIndex = ((PieRadarChartBase) this.mChart).getSelectionDetailsAtIndex(indexForAngle);
        T t11 = this.mChart;
        if (t11 instanceof RadarChart) {
            i10 = Utils.getClosestDataSetIndex(selectionDetailsAtIndex, distanceToCenter / ((RadarChart) t11).getFactor(), (YAxis.AxisDependency) null);
        }
        if (i10 < 0) {
            ((PieRadarChartBase) this.mChart).highlightValues((Highlight[]) null);
            this.mLastHighlighted = null;
            return true;
        }
        performHighlight(new Highlight(indexForAngle, i10), motionEvent);
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mGestureDetector.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.mChart).isRotationEnabled()) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                startAction(motionEvent);
                stopDeceleration();
                resetVelocity();
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    sampleVelocity(x10, y10);
                }
                setGestureStartAngle(x10, y10);
                PointF pointF = this.mTouchStartPoint;
                pointF.x = x10;
                pointF.y = y10;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    stopDeceleration();
                    sampleVelocity(x10, y10);
                    float calculateVelocity = calculateVelocity();
                    this.mDecelerationAngularVelocity = calculateVelocity;
                    if (calculateVelocity != 0.0f) {
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                }
                ((PieRadarChartBase) this.mChart).enableScroll();
                this.mTouchMode = 0;
                endAction(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    sampleVelocity(x10, y10);
                }
                if (this.mTouchMode == 0) {
                    PointF pointF2 = this.mTouchStartPoint;
                    if (ChartTouchListener.distance(x10, pointF2.x, y10, pointF2.y) > Utils.convertDpToPixel(8.0f)) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.ROTATE;
                        this.mTouchMode = 6;
                        ((PieRadarChartBase) this.mChart).disableScroll();
                        endAction(motionEvent);
                    }
                }
                if (this.mTouchMode == 6) {
                    updateGestureRotation(x10, y10);
                    ((PieRadarChartBase) this.mChart).invalidate();
                }
                endAction(motionEvent);
            }
        }
        return true;
    }

    public void setGestureStartAngle(float f10, float f11) {
        this.mStartAngle = ((PieRadarChartBase) this.mChart).getAngleForPoint(f10, f11) - ((PieRadarChartBase) this.mChart).getRawRotationAngle();
    }

    public void stopDeceleration() {
        this.mDecelerationAngularVelocity = 0.0f;
    }

    public void updateGestureRotation(float f10, float f11) {
        T t10 = this.mChart;
        ((PieRadarChartBase) t10).setRotationAngle(((PieRadarChartBase) t10).getAngleForPoint(f10, f11) - this.mStartAngle);
    }
}

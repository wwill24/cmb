package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private IDataSet mClosestDataSetToTouch;
    private PointF mDecelerationCurrentPoint = new PointF();
    private long mDecelerationLastTime = 0;
    private PointF mDecelerationVelocity = new PointF();
    private Matrix mMatrix = new Matrix();
    private float mSavedDist = 1.0f;
    private Matrix mSavedMatrix = new Matrix();
    private float mSavedXDist = 1.0f;
    private float mSavedYDist = 1.0f;
    private PointF mTouchPointCenter = new PointF();
    private PointF mTouchStartPoint = new PointF();
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix) {
        super(barLineChartBase);
        this.mMatrix = matrix;
    }

    private static float getXDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float getYDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private static void midPoint(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void performDrag(android.view.MotionEvent r5) {
        /*
            r4 = this;
            com.github.mikephil.charting.listener.ChartTouchListener$ChartGesture r0 = com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture.DRAG
            r4.mLastGesture = r0
            android.graphics.Matrix r0 = r4.mMatrix
            android.graphics.Matrix r1 = r4.mSavedMatrix
            r0.set(r1)
            T r0 = r4.mChart
            com.github.mikephil.charting.charts.BarLineChartBase r0 = (com.github.mikephil.charting.charts.BarLineChartBase) r0
            com.github.mikephil.charting.listener.OnChartGestureListener r0 = r0.getOnChartGestureListener()
            T r1 = r4.mChart
            com.github.mikephil.charting.charts.BarLineChartBase r1 = (com.github.mikephil.charting.charts.BarLineChartBase) r1
            boolean r1 = r1.isAnyAxisInverted()
            if (r1 == 0) goto L_0x0060
            com.github.mikephil.charting.interfaces.datasets.IDataSet r1 = r4.mClosestDataSetToTouch
            if (r1 == 0) goto L_0x0060
            T r2 = r4.mChart
            com.github.mikephil.charting.charts.BarLineChartBase r2 = (com.github.mikephil.charting.charts.BarLineChartBase) r2
            com.github.mikephil.charting.components.YAxis$AxisDependency r1 = r1.getAxisDependency()
            com.github.mikephil.charting.components.YAxis r1 = r2.getAxis(r1)
            boolean r1 = r1.isInverted()
            if (r1 == 0) goto L_0x0060
            T r1 = r4.mChart
            boolean r1 = r1 instanceof com.github.mikephil.charting.charts.HorizontalBarChart
            if (r1 == 0) goto L_0x004c
            float r1 = r5.getX()
            android.graphics.PointF r2 = r4.mTouchStartPoint
            float r2 = r2.x
            float r1 = r1 - r2
            float r1 = -r1
            float r2 = r5.getY()
            android.graphics.PointF r3 = r4.mTouchStartPoint
            float r3 = r3.y
            goto L_0x0071
        L_0x004c:
            float r1 = r5.getX()
            android.graphics.PointF r2 = r4.mTouchStartPoint
            float r2 = r2.x
            float r1 = r1 - r2
            float r2 = r5.getY()
            android.graphics.PointF r3 = r4.mTouchStartPoint
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = -r2
            goto L_0x0072
        L_0x0060:
            float r1 = r5.getX()
            android.graphics.PointF r2 = r4.mTouchStartPoint
            float r2 = r2.x
            float r1 = r1 - r2
            float r2 = r5.getY()
            android.graphics.PointF r3 = r4.mTouchStartPoint
            float r3 = r3.y
        L_0x0071:
            float r2 = r2 - r3
        L_0x0072:
            android.graphics.Matrix r3 = r4.mMatrix
            r3.postTranslate(r1, r2)
            if (r0 == 0) goto L_0x007c
            r0.onChartTranslate(r5, r1, r2)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.BarLineChartTouchListener.performDrag(android.view.MotionEvent):void");
    }

    private void performHighlightDrag(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint != null && !highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            this.mLastHighlighted = highlightByTouchPoint;
            ((BarLineChartBase) this.mChart).highlightTouch(highlightByTouchPoint);
        }
    }

    private void performZoom(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        float f10;
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float spacing = spacing(motionEvent);
            if (spacing > 10.0f) {
                PointF pointF = this.mTouchPointCenter;
                PointF trans = getTrans(pointF.x, pointF.y);
                int i10 = this.mTouchMode;
                boolean z12 = true;
                float f11 = 1.0f;
                if (i10 == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f12 = spacing / this.mSavedDist;
                    if (f12 >= 1.0f) {
                        z12 = false;
                    }
                    if (z12) {
                        z11 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX();
                    } else {
                        z11 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    }
                    if (((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                        f10 = f12;
                    } else {
                        f10 = 1.0f;
                    }
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                        f11 = f12;
                    }
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled() || z11) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(f10, f11, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f10, f11);
                        }
                    }
                } else if (i10 == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float xDist = getXDist(motionEvent) / this.mSavedXDist;
                    if (xDist >= 1.0f) {
                        z12 = false;
                    }
                    if (z12) {
                        z10 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomOutMoreX();
                    } else {
                        z10 = ((BarLineChartBase) this.mChart).getViewPortHandler().canZoomInMoreX();
                    }
                    if (z10) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(xDist, 1.0f, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, xDist, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float yDist = getYDist(motionEvent) / this.mSavedYDist;
                    this.mMatrix.set(this.mSavedMatrix);
                    this.mMatrix.postScale(1.0f, yDist, trans.x, trans.y);
                    if (onChartGestureListener != null) {
                        onChartGestureListener.onChartScale(motionEvent, 1.0f, yDist);
                    }
                }
            }
        }
    }

    private void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.set(motionEvent.getX(), motionEvent.getY());
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    private static float spacing(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x10 * x10) + (y10 * y10)));
    }

    public void computeScroll() {
        PointF pointF = this.mDecelerationVelocity;
        if (pointF.x != 0.0f || pointF.y != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mDecelerationVelocity.x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
            this.mDecelerationVelocity.y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
            float f10 = ((float) (currentAnimationTimeMillis - this.mDecelerationLastTime)) / 1000.0f;
            PointF pointF2 = this.mDecelerationVelocity;
            float f11 = pointF2.x * f10;
            float f12 = pointF2.y * f10;
            PointF pointF3 = this.mDecelerationCurrentPoint;
            float f13 = pointF3.x + f11;
            pointF3.x = f13;
            float f14 = pointF3.y + f12;
            pointF3.y = f14;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f13, f14, 0);
            performDrag(obtain);
            obtain.recycle();
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
            this.mDecelerationLastTime = currentAnimationTimeMillis;
            if (((double) Math.abs(this.mDecelerationVelocity.x)) >= 0.01d || ((double) Math.abs(this.mDecelerationVelocity.y)) >= 0.01d) {
                Utils.postInvalidateOnAnimation(this.mChart);
                return;
            }
            ((BarLineChartBase) this.mChart).calculateOffsets();
            ((BarLineChartBase) this.mChart).postInvalidate();
            stopDeceleration();
        }
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public PointF getTrans(float f10, float f11) {
        float f12;
        IDataSet iDataSet;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float offsetLeft = f10 - viewPortHandler.offsetLeft();
        if (!((BarLineChartBase) this.mChart).isAnyAxisInverted() || (iDataSet = this.mClosestDataSetToTouch) == null || !((BarLineChartBase) this.mChart).isInverted(iDataSet.getAxisDependency())) {
            f12 = -((((float) ((BarLineChartBase) this.mChart).getMeasuredHeight()) - f11) - viewPortHandler.offsetBottom());
        } else {
            f12 = -(f11 - viewPortHandler.offsetTop());
        }
        return new PointF(offsetLeft, f12);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f10;
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled()) {
            PointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            T t10 = this.mChart;
            BarLineChartBase barLineChartBase = (BarLineChartBase) t10;
            float f11 = 1.4f;
            if (((BarLineChartBase) t10).isScaleXEnabled()) {
                f10 = 1.4f;
            } else {
                f10 = 1.0f;
            }
            if (!((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                f11 = 1.0f;
            }
            barLineChartBase.zoom(f10, f11, trans.x, trans.y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Double-Tap, Zooming In, x: ");
                sb2.append(trans.x);
                sb2.append(", y: ");
                sb2.append(trans.y);
            }
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f10, f11);
        }
        return super.onFling(motionEvent, motionEvent2, f10, f11);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isDragEnabled() && !((BarLineChartBase) this.mChart).isScaleXEnabled() && !((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            startAction(motionEvent);
            stopDeceleration();
            saveTouchStart(motionEvent);
        } else if (action == 1) {
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            int pointerId = motionEvent.getPointerId(0);
            velocityTracker2.computeCurrentVelocity(1000, (float) Utils.getMaximumFlingVelocity());
            float yVelocity = velocityTracker2.getYVelocity(pointerId);
            float xVelocity = velocityTracker2.getXVelocity(pointerId);
            if ((Math.abs(xVelocity) > ((float) Utils.getMinimumFlingVelocity()) || Math.abs(yVelocity) > ((float) Utils.getMinimumFlingVelocity())) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                stopDeceleration();
                this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDecelerationCurrentPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                this.mDecelerationVelocity = new PointF(xVelocity, yVelocity);
                Utils.postInvalidateOnAnimation(this.mChart);
            }
            int i10 = this.mTouchMode;
            if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                ((BarLineChartBase) this.mChart).calculateOffsets();
                ((BarLineChartBase) this.mChart).postInvalidate();
            }
            this.mTouchMode = 0;
            ((BarLineChartBase) this.mChart).enableScroll();
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
            endAction(motionEvent);
        } else if (action == 2) {
            int i11 = this.mTouchMode;
            if (i11 == 1) {
                ((BarLineChartBase) this.mChart).disableScroll();
                performDrag(motionEvent);
            } else if (i11 == 2 || i11 == 3 || i11 == 4) {
                ((BarLineChartBase) this.mChart).disableScroll();
                if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    performZoom(motionEvent);
                }
            } else if (i11 == 0 && Math.abs(ChartTouchListener.distance(motionEvent.getX(), this.mTouchStartPoint.x, motionEvent.getY(), this.mTouchStartPoint.y)) > 5.0f) {
                if (((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                    if (((BarLineChartBase) this.mChart).isFullyZoomedOut() || !((BarLineChartBase) this.mChart).isDragEnabled()) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                        if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                            performHighlightDrag(motionEvent);
                        }
                    } else {
                        this.mTouchMode = 1;
                    }
                } else if (((BarLineChartBase) this.mChart).isDragEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                    this.mTouchMode = 1;
                }
            }
        } else if (action == 3) {
            this.mTouchMode = 0;
            endAction(motionEvent);
        } else if (action != 5) {
            if (action == 6) {
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.mVelocityTracker);
                this.mTouchMode = 5;
            }
        } else if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.mChart).disableScroll();
            saveTouchStart(motionEvent);
            this.mSavedXDist = getXDist(motionEvent);
            this.mSavedYDist = getYDist(motionEvent);
            float spacing = spacing(motionEvent);
            this.mSavedDist = spacing;
            if (spacing > 10.0f) {
                if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                    this.mTouchMode = 4;
                } else if (this.mSavedXDist > this.mSavedYDist) {
                    this.mTouchMode = 2;
                } else {
                    this.mTouchMode = 3;
                }
            }
            midPoint(this.mTouchPointCenter, motionEvent);
        }
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        return true;
    }

    public void stopDeceleration() {
        this.mDecelerationVelocity = new PointF(0.0f, 0.0f);
    }
}

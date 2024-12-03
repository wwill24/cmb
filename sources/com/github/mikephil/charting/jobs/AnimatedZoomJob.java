package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    protected float xValCount;
    protected YAxis yAxis;
    protected float zoomCenterX;
    protected float zoomCenterY;
    protected float zoomOriginX;
    protected float zoomOriginY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis2, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, long j10) {
        super(viewPortHandler, f11, f12, transformer, view, f13, f14, j10);
        this.zoomCenterX = f15;
        this.zoomCenterY = f16;
        this.zoomOriginX = f17;
        this.zoomOriginY = f18;
        this.animator.addListener(this);
        this.yAxis = yAxis2;
        this.xValCount = f10;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f10 = this.xOrigin;
        float f11 = this.phase;
        float f12 = f10 + ((this.xValue - f10) * f11);
        float f13 = this.yOrigin;
        this.mViewPortHandler.refresh(this.mViewPortHandler.setZoom(f12, f13 + ((this.yValue - f13) * f11)), this.view, false);
        float scaleY = this.yAxis.mAxisRange / this.mViewPortHandler.getScaleY();
        float scaleX = this.xValCount / this.mViewPortHandler.getScaleX();
        float[] fArr = this.pts;
        float f14 = this.zoomOriginX;
        float f15 = this.phase;
        fArr[0] = f14 + (((this.zoomCenterX - (scaleX / 2.0f)) - f14) * f15);
        float f16 = this.zoomOriginY;
        fArr[1] = f16 + (((this.zoomCenterY + (scaleY / 2.0f)) - f16) * f15);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.refresh(this.mViewPortHandler.translate(this.pts), this.view, true);
    }
}

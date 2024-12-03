package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f10, float f11, Transformer transformer, View view, float f12, float f13, long j10) {
        super(viewPortHandler, f10, f11, transformer, view, f12, f13, j10);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.pts;
        float f10 = this.xOrigin;
        float f11 = this.phase;
        fArr[0] = f10 + ((this.xValue - f10) * f11);
        float f12 = this.yOrigin;
        fArr[1] = f12 + ((this.yValue - f12) * f11);
        this.mTrans.pointValuesToPixel(fArr);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }
}

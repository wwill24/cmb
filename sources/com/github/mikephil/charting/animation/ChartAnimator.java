package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import com.github.mikephil.charting.animation.Easing;

@SuppressLint({"NewApi"})
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseX = 1.0f;
    protected float mPhaseY = 1.0f;

    public ChartAnimator() {
    }

    public void animateX(int i10, EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateXY(int i10, int i11, EasingFunction easingFunction, EasingFunction easingFunction2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction2);
        ofFloat.setDuration((long) i11);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(easingFunction);
        ofFloat2.setDuration((long) i10);
        if (i10 > i11) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }

    public void animateY(int i10, EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseX(float f10) {
        this.mPhaseX = f10;
    }

    public void setPhaseY(float f10) {
        this.mPhaseY = f10;
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    public void animateX(int i10, Easing.EasingOption easingOption) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateY(int i10, Easing.EasingOption easingOption) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateX(int i10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateXY(int i10, int i11, Easing.EasingOption easingOption, Easing.EasingOption easingOption2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption2));
        ofFloat.setDuration((long) i11);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat2.setDuration((long) i10);
        if (i10 > i11) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }

    public void animateY(int i10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) i10);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateXY(int i10, int i11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) i11);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat2.setDuration((long) i10);
        if (i10 > i11) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }
}

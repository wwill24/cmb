package com.github.mikephil.charting.jobs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener {
    protected ObjectAnimator animator;
    protected float phase;
    protected float xOrigin;
    protected float yOrigin;

    public AnimatedViewPortJob(ViewPortHandler viewPortHandler, float f10, float f11, Transformer transformer, View view, float f12, float f13, long j10) {
        super(viewPortHandler, f10, f11, transformer, view);
        this.xOrigin = f12;
        this.yOrigin = f13;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phase", new float[]{0.0f, 1.0f});
        this.animator = ofFloat;
        ofFloat.setDuration(j10);
        this.animator.addUpdateListener(this);
    }

    public float getPhase() {
        return this.phase;
    }

    public float getXOrigin() {
        return this.xOrigin;
    }

    public float getYOrigin() {
        return this.yOrigin;
    }

    @SuppressLint({"NewApi"})
    public void run() {
        this.animator.start();
    }

    public void setPhase(float f10) {
        this.phase = f10;
    }
}

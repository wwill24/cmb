package com.coffeemeetsbagel.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class c extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f37589a;

    /* renamed from: b  reason: collision with root package name */
    private float f37590b;

    /* renamed from: c  reason: collision with root package name */
    private float f37591c;

    public c(ProgressBar progressBar, float f10, float f11) {
        this.f37589a = progressBar;
        this.f37590b = f10;
        this.f37591c = f11;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f10, Transformation transformation) {
        super.applyTransformation(f10, transformation);
        float f11 = this.f37590b;
        this.f37589a.setProgress((int) (f11 + ((this.f37591c - f11) * f10)));
    }
}

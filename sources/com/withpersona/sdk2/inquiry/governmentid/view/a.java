package com.withpersona.sdk2.inquiry.governmentid.view;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScanningView f26035a;

    public /* synthetic */ a(ScanningView scanningView) {
        this.f26035a = scanningView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ScanningView.d(this.f26035a, valueAnimator);
    }
}

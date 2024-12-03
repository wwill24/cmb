package com.withpersona.sdk2.inquiry.selfie.view;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressArcView f27483a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f27484b;

    public /* synthetic */ b(ProgressArcView progressArcView, ValueAnimator valueAnimator) {
        this.f27483a = progressArcView;
        this.f27484b = valueAnimator;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ProgressArcView.i(this.f27483a, this.f27484b, valueAnimator);
    }
}

package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import tf.g;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f19091a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f19092b;

    public /* synthetic */ a(AppBarLayout appBarLayout, g gVar) {
        this.f19091a = appBarLayout;
        this.f19092b = gVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19091a.q(this.f19092b, valueAnimator);
    }
}

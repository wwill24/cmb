package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import tf.g;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f19093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f19094b;

    public /* synthetic */ b(AppBarLayout appBarLayout, g gVar) {
        this.f19093a = appBarLayout;
        this.f19094b = gVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19093a.r(this.f19094b, valueAnimator);
    }
}

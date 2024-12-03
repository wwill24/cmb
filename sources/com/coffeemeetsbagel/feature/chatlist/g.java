package com.coffeemeetsbagel.feature.chatlist;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f12922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f12923b;

    public /* synthetic */ g(ViewGroup.LayoutParams layoutParams, View view) {
        this.f12922a = layoutParams;
        this.f12923b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        BannerHolderUtil.c(this.f12922a, this.f12923b, valueAnimator);
    }
}

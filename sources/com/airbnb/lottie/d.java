package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f8539a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f8540b;

    public /* synthetic */ d(LottieAnimationView lottieAnimationView, int i10) {
        this.f8539a = lottieAnimationView;
        this.f8540b = i10;
    }

    public final Object call() {
        return this.f8539a.v(this.f8540b);
    }
}

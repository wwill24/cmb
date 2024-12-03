package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f8548a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8549b;

    public /* synthetic */ g(LottieAnimationView lottieAnimationView, String str) {
        this.f8548a = lottieAnimationView;
        this.f8549b = str;
    }

    public final Object call() {
        return this.f8548a.u(this.f8549b);
    }
}

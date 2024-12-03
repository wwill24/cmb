package com.google.firebase.concurrent;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LimitedConcurrencyExecutor f20996a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20997b;

    public /* synthetic */ w(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        this.f20996a = limitedConcurrencyExecutor;
        this.f20997b = runnable;
    }

    public final void run() {
        this.f20996a.lambda$decorate$0(this.f20997b);
    }
}

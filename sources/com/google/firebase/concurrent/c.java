package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f20962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20963b;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20962a = runnable;
        this.f20963b = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f20962a, this.f20963b);
    }
}

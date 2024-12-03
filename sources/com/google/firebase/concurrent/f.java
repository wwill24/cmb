package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f20969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20970b;

    public /* synthetic */ f(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20969a = runnable;
        this.f20970b = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f20969a, this.f20970b);
    }
}

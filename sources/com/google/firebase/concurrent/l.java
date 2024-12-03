package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20991a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20992b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20993c;

    public /* synthetic */ l(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20991a = delegatingScheduledExecutorService;
        this.f20992b = runnable;
        this.f20993c = completer;
    }

    public final void run() {
        this.f20991a.lambda$schedule$1(this.f20992b, this.f20993c);
    }
}

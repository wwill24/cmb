package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20973c;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20971a = delegatingScheduledExecutorService;
        this.f20972b = runnable;
        this.f20973c = completer;
    }

    public final void run() {
        this.f20971a.lambda$scheduleAtFixedRate$7(this.f20972b, this.f20973c);
    }
}

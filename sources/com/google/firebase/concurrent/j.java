package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f20983a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f20984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20985c;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20983a = delegatingScheduledExecutorService;
        this.f20984b = runnable;
        this.f20985c = completer;
    }

    public final void run() {
        this.f20983a.lambda$scheduleWithFixedDelay$10(this.f20984b, this.f20985c);
    }
}

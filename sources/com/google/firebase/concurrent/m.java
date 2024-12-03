package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f20994a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20995b;

    public /* synthetic */ m(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f20994a = runnable;
        this.f20995b = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$0(this.f20994a, this.f20995b);
    }
}

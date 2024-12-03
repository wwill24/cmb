package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f20967a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f20968b;

    public /* synthetic */ e(Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.f20967a = callable;
        this.f20968b = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.lambda$schedule$3(this.f20967a, this.f20968b);
    }
}

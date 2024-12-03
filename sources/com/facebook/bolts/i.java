package com.facebook.bolts;

import com.facebook.bolts.Task;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Continuation f37798c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Task f37799d;

    public /* synthetic */ i(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.f37796a = cancellationToken;
        this.f37797b = taskCompletionSource;
        this.f37798c = continuation;
        this.f37799d = task;
    }

    public final void run() {
        Task.Companion.m96completeImmediately$lambda5(this.f37796a, this.f37797b, this.f37798c, this.f37799d);
    }
}

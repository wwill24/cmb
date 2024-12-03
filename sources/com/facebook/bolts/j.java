package com.facebook.bolts;

import com.facebook.bolts.Task;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37800a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37801b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Continuation f37802c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Task f37803d;

    public /* synthetic */ j(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.f37800a = cancellationToken;
        this.f37801b = taskCompletionSource;
        this.f37802c = continuation;
        this.f37803d = task;
    }

    public final void run() {
        Task.Companion.m94completeAfterTask$lambda7(this.f37800a, this.f37801b, this.f37802c, this.f37803d);
    }
}

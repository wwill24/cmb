package com.facebook.bolts;

import java.util.concurrent.Executor;

public final /* synthetic */ class d implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37785a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f37786b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f37787c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37788d;

    public /* synthetic */ d(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
        this.f37785a = taskCompletionSource;
        this.f37786b = continuation;
        this.f37787c = executor;
        this.f37788d = cancellationToken;
    }

    public final Object then(Task task) {
        return Task.m89continueWithTask$lambda12$lambda11(this.f37785a, this.f37786b, this.f37787c, this.f37788d, task);
    }
}

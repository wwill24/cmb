package com.facebook.bolts;

import java.util.concurrent.Executor;

public final /* synthetic */ class c implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37781a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f37782b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f37783c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37784d;

    public /* synthetic */ c(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
        this.f37781a = taskCompletionSource;
        this.f37782b = continuation;
        this.f37783c = executor;
        this.f37784d = cancellationToken;
    }

    public final Object then(Task task) {
        return Task.m88continueWith$lambda10$lambda9(this.f37781a, this.f37782b, this.f37783c, this.f37784d, task);
    }
}

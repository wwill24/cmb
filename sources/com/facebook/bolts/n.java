package com.facebook.bolts;

import com.facebook.bolts.Task;

public final /* synthetic */ class n implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37810b;

    public /* synthetic */ n(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource) {
        this.f37809a = cancellationToken;
        this.f37810b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m95completeAfterTask$lambda7$lambda6(this.f37809a, this.f37810b, task);
    }
}

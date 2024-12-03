package com.facebook.bolts;

public final /* synthetic */ class b implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37779a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f37780b;

    public /* synthetic */ b(CancellationToken cancellationToken, Continuation continuation) {
        this.f37779a = cancellationToken;
        this.f37780b = continuation;
    }

    public final Object then(Task task) {
        return Task.m91onSuccess$lambda13(this.f37779a, this.f37780b, task);
    }
}

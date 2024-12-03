package com.facebook.bolts;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationToken f37789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation f37790b;

    public /* synthetic */ f(CancellationToken cancellationToken, Continuation continuation) {
        this.f37789a = cancellationToken;
        this.f37790b = continuation;
    }

    public final Object then(Task task) {
        return Task.m92onSuccessTask$lambda14(this.f37789a, this.f37790b, task);
    }
}

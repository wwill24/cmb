package com.facebook.internal;

import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LockOnGetVariable f37865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f37866b;

    public /* synthetic */ o(LockOnGetVariable lockOnGetVariable, Callable callable) {
        this.f37865a = lockOnGetVariable;
        this.f37866b = callable;
    }

    public final Object call() {
        return LockOnGetVariable.m125_init_$lambda0(this.f37865a, this.f37866b);
    }
}

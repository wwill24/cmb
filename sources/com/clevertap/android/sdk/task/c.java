package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

abstract class c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    protected final Executor f10800a;

    c(Executor executor) {
        this.f10800a = executor;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(TResult tresult);
}

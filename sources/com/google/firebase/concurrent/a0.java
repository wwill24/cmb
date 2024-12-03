package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class a0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f20957a;

    public /* synthetic */ a0(Runnable runnable) {
        this.f20957a = runnable;
    }

    public final Object call() {
        return this.f20957a.run();
    }
}

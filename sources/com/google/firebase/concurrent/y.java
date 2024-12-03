package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f21000a;

    public /* synthetic */ y(Runnable runnable) {
        this.f21000a = runnable;
    }

    public final Object call() {
        return this.f21000a.run();
    }
}

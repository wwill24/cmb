package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class z implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f21001a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f21002b;

    public /* synthetic */ z(Runnable runnable, Object obj) {
        this.f21001a = runnable;
        this.f21002b = obj;
    }

    public final Object call() {
        return this.f21001a.run();
    }
}

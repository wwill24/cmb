package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class x implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f20998a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f20999b;

    public /* synthetic */ x(Runnable runnable, Object obj) {
        this.f20998a = runnable;
        this.f20999b = obj;
    }

    public final Object call() {
        return this.f20998a.run();
    }
}

package com.google.mlkit.common.sdkinternal;

import java.util.Deque;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f21461a;

    public /* synthetic */ v(Runnable runnable) {
        this.f21461a = runnable;
    }

    public final void run() {
        j.c((Deque) j.f21410b.get(), this.f21461a);
    }
}

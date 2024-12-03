package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;

final class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f31106a;

    u0() {
        this(Looper.getMainLooper());
    }

    public Thread a() {
        return this.f31106a.getLooper().getThread();
    }

    public void b(Runnable runnable) {
        this.f31106a.post(runnable);
    }

    u0(Looper looper) {
        this.f31106a = new Handler(looper);
    }
}

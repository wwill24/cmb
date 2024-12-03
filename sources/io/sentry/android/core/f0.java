package io.sentry.android.core;

import io.sentry.g0;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppLifecycleIntegration f30969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f30970b;

    public /* synthetic */ f0(AppLifecycleIntegration appLifecycleIntegration, g0 g0Var) {
        this.f30969a = appLifecycleIntegration;
        this.f30970b = g0Var;
    }

    public final void run() {
        this.f30969a.k(this.f30970b);
    }
}

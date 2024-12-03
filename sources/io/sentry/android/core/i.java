package io.sentry.android.core;

import io.sentry.m0;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityLifecycleIntegration f30989a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f30990b;

    public /* synthetic */ i(ActivityLifecycleIntegration activityLifecycleIntegration, m0 m0Var) {
        this.f30989a = activityLifecycleIntegration;
        this.f30990b = m0Var;
    }

    public final void run() {
        this.f30989a.s0(this.f30990b);
    }
}

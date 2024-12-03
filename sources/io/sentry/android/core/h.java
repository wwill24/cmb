package io.sentry.android.core;

import io.sentry.m0;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityLifecycleIntegration f30985a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f30986b;

    public /* synthetic */ h(ActivityLifecycleIntegration activityLifecycleIntegration, m0 m0Var) {
        this.f30985a = activityLifecycleIntegration;
        this.f30986b = m0Var;
    }

    public final void run() {
        this.f30985a.r0(this.f30986b);
    }
}

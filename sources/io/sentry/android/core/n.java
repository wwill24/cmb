package io.sentry.android.core;

import android.app.Activity;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityLifecycleIntegration f31066a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f31067b;

    public /* synthetic */ n(ActivityLifecycleIntegration activityLifecycleIntegration, Activity activity) {
        this.f31066a = activityLifecycleIntegration;
        this.f31067b = activity;
    }

    public final void run() {
        this.f31066a.u0(this.f31067b);
    }
}

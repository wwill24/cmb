package com.google.firebase.perf.metrics;

import com.google.firebase.perf.v1.TraceMetric;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f21151a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraceMetric.Builder f21152b;

    public /* synthetic */ e(AppStartTrace appStartTrace, TraceMetric.Builder builder) {
        this.f21151a = appStartTrace;
        this.f21152b = builder;
    }

    public final void run() {
        this.f21151a.lambda$logExperimentTrace$0(this.f21152b);
    }
}

package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransportManager f21170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TraceMetric f21171b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f21172c;

    public /* synthetic */ b(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.f21170a = transportManager;
        this.f21171b = traceMetric;
        this.f21172c = applicationProcessState;
    }

    public final void run() {
        this.f21170a.lambda$log$2(this.f21171b, this.f21172c);
    }
}

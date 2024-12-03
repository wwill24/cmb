package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MemoryGaugeCollector f21168a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Timer f21169b;

    public /* synthetic */ i(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f21168a = memoryGaugeCollector;
        this.f21169b = timer;
    }

    public final void run() {
        this.f21168a.lambda$scheduleMemoryMetricCollectionOnce$1(this.f21169b);
    }
}

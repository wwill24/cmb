package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CpuGaugeCollector f21158a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Timer f21159b;

    public /* synthetic */ b(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f21158a = cpuGaugeCollector;
        this.f21159b = timer;
    }

    public final void run() {
        this.f21158a.lambda$scheduleCpuMetricCollectionOnce$1(this.f21159b);
    }
}

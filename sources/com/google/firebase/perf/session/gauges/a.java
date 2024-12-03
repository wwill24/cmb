package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CpuGaugeCollector f21156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Timer f21157b;

    public /* synthetic */ a(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f21156a = cpuGaugeCollector;
        this.f21157b = timer;
    }

    public final void run() {
        this.f21156a.lambda$scheduleCpuMetricCollectionWithRate$0(this.f21157b);
    }
}

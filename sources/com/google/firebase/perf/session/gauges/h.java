package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MemoryGaugeCollector f21166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Timer f21167b;

    public /* synthetic */ h(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f21166a = memoryGaugeCollector;
        this.f21167b = timer;
    }

    public final void run() {
        this.f21166a.lambda$scheduleMemoryMetricCollectionWithRate$0(this.f21167b);
    }
}

package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransportManager f21180a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GaugeMetric f21181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f21182c;

    public /* synthetic */ g(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.f21180a = transportManager;
        this.f21181b = gaugeMetric;
        this.f21182c = applicationProcessState;
    }

    public final void run() {
        this.f21180a.lambda$log$4(this.f21181b, this.f21182c);
    }
}

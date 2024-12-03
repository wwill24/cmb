package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.v1.ApplicationProcessState;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GaugeManager f21160a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21161b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f21162c;

    public /* synthetic */ c(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f21160a = gaugeManager;
        this.f21161b = str;
        this.f21162c = applicationProcessState;
    }

    public final void run() {
        this.f21160a.lambda$stopCollectingGauges$3(this.f21161b, this.f21162c);
    }
}

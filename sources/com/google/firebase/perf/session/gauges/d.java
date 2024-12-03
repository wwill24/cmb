package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.v1.ApplicationProcessState;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GaugeManager f21163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f21165c;

    public /* synthetic */ d(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f21163a = gaugeManager;
        this.f21164b = str;
        this.f21165c = applicationProcessState;
    }

    public final void run() {
        this.f21163a.lambda$startCollectingGauges$2(this.f21164b, this.f21165c);
    }
}

package com.google.firebase.perf.transport;

import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransportManager f21174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkRequestMetric f21175b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f21176c;

    public /* synthetic */ d(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.f21174a = transportManager;
        this.f21175b = networkRequestMetric;
        this.f21176c = applicationProcessState;
    }

    public final void run() {
        this.f21174a.lambda$log$3(this.f21175b, this.f21176c);
    }
}

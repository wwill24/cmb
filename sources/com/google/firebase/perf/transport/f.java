package com.google.firebase.perf.transport;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransportManager f21178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PendingPerfEvent f21179b;

    public /* synthetic */ f(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.f21178a = transportManager;
        this.f21179b = pendingPerfEvent;
    }

    public final void run() {
        this.f21178a.lambda$finishInitialization$0(this.f21179b);
    }
}

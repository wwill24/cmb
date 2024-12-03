package com.google.firebase.perf.transport;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransportManager f21173a;

    public /* synthetic */ c(TransportManager transportManager) {
        this.f21173a = transportManager;
    }

    public final void run() {
        this.f21173a.syncInit();
    }
}

package com.google.firebase.perf.metrics;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f21149a;

    public /* synthetic */ c(AppStartTrace appStartTrace) {
        this.f21149a = appStartTrace;
    }

    public final void run() {
        this.f21149a.recordPreDrawFrontOfQueue();
    }
}

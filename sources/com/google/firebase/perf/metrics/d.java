package com.google.firebase.perf.metrics;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f21150a;

    public /* synthetic */ d(AppStartTrace appStartTrace) {
        this.f21150a = appStartTrace;
    }

    public final void run() {
        this.f21150a.logAppStartTrace();
    }
}

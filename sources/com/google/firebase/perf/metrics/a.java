package com.google.firebase.perf.metrics;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f21147a;

    public /* synthetic */ a(AppStartTrace appStartTrace) {
        this.f21147a = appStartTrace;
    }

    public final void run() {
        this.f21147a.recordOnDrawFrontOfQueue();
    }
}

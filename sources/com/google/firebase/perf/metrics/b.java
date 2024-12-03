package com.google.firebase.perf.metrics;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f21148a;

    public /* synthetic */ b(AppStartTrace appStartTrace) {
        this.f21148a = appStartTrace;
    }

    public final void run() {
        this.f21148a.recordPreDraw();
    }
}

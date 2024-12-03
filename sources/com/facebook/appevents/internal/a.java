package com.facebook.appevents.internal;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37757a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37758b;

    public /* synthetic */ a(long j10, String str) {
        this.f37757a = j10;
        this.f37758b = str;
    }

    public final void run() {
        ActivityLifecycleTracker.m73onActivityPaused$lambda6$lambda4(this.f37757a, this.f37758b);
    }
}

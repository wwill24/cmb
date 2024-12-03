package com.facebook.appevents.internal;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37760b;

    public /* synthetic */ b(long j10, String str) {
        this.f37759a = j10;
        this.f37760b = str;
    }

    public final void run() {
        ActivityLifecycleTracker.m72onActivityPaused$lambda6(this.f37759a, this.f37760b);
    }
}

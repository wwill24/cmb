package com.facebook.appevents.internal;

import android.content.Context;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37761a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37762b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f37763c;

    public /* synthetic */ c(long j10, String str, Context context) {
        this.f37761a = j10;
        this.f37762b = str;
        this.f37763c = context;
    }

    public final void run() {
        ActivityLifecycleTracker.m74onActivityResumed$lambda2(this.f37761a, this.f37762b, this.f37763c);
    }
}

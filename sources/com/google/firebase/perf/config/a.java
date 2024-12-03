package com.google.firebase.perf.config;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceCacheManager f21143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21144b;

    public /* synthetic */ a(DeviceCacheManager deviceCacheManager, Context context) {
        this.f21143a = deviceCacheManager;
        this.f21144b = context;
    }

    public final void run() {
        this.f21143a.lambda$setContext$0(this.f21144b);
    }
}

package com.facebook.appevents.ondeviceprocessing;

import com.facebook.appevents.AppEvent;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37769a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppEvent f37770b;

    public /* synthetic */ b(String str, AppEvent appEvent) {
        this.f37769a = str;
        this.f37770b = appEvent;
    }

    public final void run() {
        OnDeviceProcessingManager.m81sendCustomEventAsync$lambda1(this.f37769a, this.f37770b);
    }
}

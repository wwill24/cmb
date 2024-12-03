package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37766a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37768c;

    public /* synthetic */ a(Context context, String str, String str2) {
        this.f37766a = context;
        this.f37767b = str;
        this.f37768c = str2;
    }

    public final void run() {
        OnDeviceProcessingManager.m82sendInstallEventAsync$lambda0(this.f37766a, this.f37767b, this.f37768c);
    }
}

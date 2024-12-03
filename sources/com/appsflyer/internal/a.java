package com.appsflyer.internal;

import android.hardware.SensorEvent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFa1jSDK f9061a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SensorEvent f9062b;

    public /* synthetic */ a(AFa1jSDK aFa1jSDK, SensorEvent sensorEvent) {
        this.f9061a = aFa1jSDK;
        this.f9062b = sensorEvent;
    }

    public final void run() {
        this.f9061a.valueOf(this.f9062b);
    }
}

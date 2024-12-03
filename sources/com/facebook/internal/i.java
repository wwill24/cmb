package com.facebook.internal;

import com.facebook.internal.FetchedAppSettingsManager;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettingsManager.FetchedAppSettingsCallback f37856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f37857b;

    public /* synthetic */ i(FetchedAppSettingsManager.FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings) {
        this.f37856a = fetchedAppSettingsCallback;
        this.f37857b = fetchedAppSettings;
    }

    public final void run() {
        FetchedAppSettingsManager.m119pollCallbacks$lambda2(this.f37856a, this.f37857b);
    }
}

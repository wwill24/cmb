package com.facebook.internal;

import com.facebook.internal.FetchedAppSettingsManager;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettingsManager.FetchedAppSettingsCallback f37855a;

    public /* synthetic */ h(FetchedAppSettingsManager.FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        this.f37855a = fetchedAppSettingsCallback;
    }

    public final void run() {
        FetchedAppSettingsManager.m118pollCallbacks$lambda1(this.f37855a);
    }
}

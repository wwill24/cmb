package com.facebook.appevents.codeless;

import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.internal.FetchedAppSettings;

public final /* synthetic */ class c implements ViewIndexingTrigger.OnShakeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f37740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37741b;

    public /* synthetic */ c(FetchedAppSettings fetchedAppSettings, String str) {
        this.f37740a = fetchedAppSettings;
        this.f37741b = str;
    }

    public final void onShake() {
        CodelessManager.m61onActivityResumed$lambda0(this.f37740a, this.f37741b);
    }
}

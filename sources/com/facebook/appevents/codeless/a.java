package com.facebook.appevents.codeless;

import android.os.Bundle;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37737a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f37738b;

    public /* synthetic */ a(String str, Bundle bundle) {
        this.f37737a = str;
        this.f37738b = bundle;
    }

    public final void run() {
        CodelessLoggingEventListener.m59logEvent$lambda0(this.f37737a, this.f37738b);
    }
}

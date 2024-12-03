package com.facebook.login;

import android.os.Bundle;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginLogger f37900a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f37901b;

    public /* synthetic */ l(LoginLogger loginLogger, Bundle bundle) {
        this.f37900a = loginLogger;
        this.f37901b = bundle;
    }

    public final void run() {
        LoginLogger.m162logHeartbeatEvent$lambda0(this.f37900a, this.f37901b);
    }
}

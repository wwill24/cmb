package com.facebook.appevents;

import android.os.Bundle;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f37771a;

    public /* synthetic */ q(Bundle bundle) {
        this.f37771a = bundle;
    }

    public final void run() {
        UserDataStore.m52setUserDataAndHash$lambda1(this.f37771a);
    }
}

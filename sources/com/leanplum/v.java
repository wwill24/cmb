package com.leanplum;

import android.os.Bundle;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f22223a;

    public /* synthetic */ v(Bundle bundle) {
        this.f22223a = bundle;
    }

    public final void run() {
        LeanplumPushService.performPushNotificationAction(this.f22223a);
    }
}

package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FcmLifecycleCallbacks f21115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f21116b;

    public /* synthetic */ g(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.f21115a = fcmLifecycleCallbacks;
        this.f21116b = intent;
    }

    public final void run() {
        this.f21115a.lambda$onActivityCreated$0(this.f21116b);
    }
}

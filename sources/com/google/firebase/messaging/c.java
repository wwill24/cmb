package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f21103b;

    public /* synthetic */ c(Context context, Intent intent) {
        this.f21102a = context;
        this.f21103b = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f21102a, this.f21103b));
    }
}

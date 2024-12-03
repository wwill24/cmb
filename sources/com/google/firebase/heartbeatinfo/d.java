package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21082a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21083b;

    public /* synthetic */ d(Context context, String str) {
        this.f21082a = context;
        this.f21083b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.f21082a, this.f21083b);
    }
}

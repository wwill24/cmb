package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFb1zSDK f9063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f9064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f9065c;

    public /* synthetic */ c(AFb1zSDK aFb1zSDK, Context context, Intent intent) {
        this.f9063a = aFb1zSDK;
        this.f9064b = context;
        this.f9065c = intent;
    }

    public final void run() {
        this.f9063a.valueOf(this.f9064b, this.f9065c);
    }
}

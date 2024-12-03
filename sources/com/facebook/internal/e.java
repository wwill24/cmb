package com.facebook.internal;

import android.content.Context;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37848a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f37849b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37850c;

    public /* synthetic */ e(String str, Context context, String str2) {
        this.f37848a = str;
        this.f37849b = context;
        this.f37850c = str2;
    }

    public final void run() {
        FetchedAppGateKeepersManager.m115loadAppGateKeepersAsync$lambda0(this.f37848a, this.f37849b, this.f37850c);
    }
}

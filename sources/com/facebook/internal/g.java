package com.facebook.internal;

import android.content.Context;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37852a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37853b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37854c;

    public /* synthetic */ g(Context context, String str, String str2) {
        this.f37852a = context;
        this.f37853b = str;
        this.f37854c = str2;
    }

    public final void run() {
        FetchedAppSettingsManager.m117loadAppSettingsAsync$lambda0(this.f37852a, this.f37853b, this.f37854c);
    }
}

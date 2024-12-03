package com.facebook;

import android.content.Context;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37823a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37824b;

    public /* synthetic */ g(Context context, String str) {
        this.f37823a = context;
        this.f37824b = str;
    }

    public final void run() {
        FacebookSdk.m19publishInstallAsync$lambda15(this.f37823a, this.f37824b);
    }
}

package com.facebook.login;

import android.os.Bundle;
import com.facebook.login.LoginClient;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeAppLoginMethodHandler f37911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f37912b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f37913c;

    public /* synthetic */ q(NativeAppLoginMethodHandler nativeAppLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        this.f37911a = nativeAppLoginMethodHandler;
        this.f37912b = request;
        this.f37913c = bundle;
    }

    public final void run() {
        NativeAppLoginMethodHandler.m167processSuccessResponse$lambda0(this.f37911a, this.f37912b, this.f37913c);
    }
}

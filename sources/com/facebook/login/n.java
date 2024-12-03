package com.facebook.login;

import android.os.Bundle;
import com.facebook.LoginStatusCallback;
import com.facebook.internal.PlatformServiceClient;

public final /* synthetic */ class n implements PlatformServiceClient.CompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginLogger f37905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginStatusCallback f37906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37907d;

    public /* synthetic */ n(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2) {
        this.f37904a = str;
        this.f37905b = loginLogger;
        this.f37906c = loginStatusCallback;
        this.f37907d = str2;
    }

    public final void completed(Bundle bundle) {
        LoginManager.m164retrieveLoginStatusImpl$lambda2(this.f37904a, this.f37905b, this.f37906c, this.f37907d, bundle);
    }
}

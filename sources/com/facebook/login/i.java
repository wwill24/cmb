package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;

public final /* synthetic */ class i implements PlatformServiceClient.CompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GetTokenLoginMethodHandler f37896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f37897b;

    public /* synthetic */ i(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
        this.f37896a = getTokenLoginMethodHandler;
        this.f37897b = request;
    }

    public final void completed(Bundle bundle) {
        GetTokenLoginMethodHandler.m159tryAuthorize$lambda1(this.f37896a, this.f37897b, bundle);
    }
}

package com.facebook.login;

import android.os.Bundle;
import com.facebook.login.LoginClient;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomTabLoginMethodHandler f37878a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginClient.Request f37879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f37880c;

    public /* synthetic */ a(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        this.f37878a = customTabLoginMethodHandler;
        this.f37879b = request;
        this.f37880c = bundle;
    }

    public final void run() {
        CustomTabLoginMethodHandler.m151onCustomTabComplete$lambda0(this.f37878a, this.f37879b, this.f37880c);
    }
}

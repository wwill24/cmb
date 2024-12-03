package com.facebook.login.widget;

import com.facebook.internal.FetchedAppSettings;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginButton f37914a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f37915b;

    public /* synthetic */ c(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        this.f37914a = loginButton;
        this.f37915b = fetchedAppSettings;
    }

    public final void run() {
        LoginButton.m170checkToolTipSettings$lambda3$lambda2(this.f37914a, this.f37915b);
    }
}

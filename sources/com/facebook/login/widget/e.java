package com.facebook.login.widget;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginButton f37917b;

    public /* synthetic */ e(String str, LoginButton loginButton) {
        this.f37916a = str;
        this.f37917b = loginButton;
    }

    public final void run() {
        LoginButton.m169checkToolTipSettings$lambda3(this.f37916a, this.f37917b);
    }
}

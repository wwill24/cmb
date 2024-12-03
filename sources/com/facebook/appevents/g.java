package com.facebook.appevents;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f37753a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppEvent f37754b;

    public /* synthetic */ g(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.f37753a = accessTokenAppIdPair;
        this.f37754b = appEvent;
    }

    public final void run() {
        AppEventQueue.m37add$lambda3(this.f37753a, this.f37754b);
    }
}

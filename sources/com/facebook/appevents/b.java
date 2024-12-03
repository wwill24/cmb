package com.facebook.appevents;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37731a;

    public /* synthetic */ b(String str) {
        this.f37731a = str;
    }

    public final void run() {
        AnalyticsUserIDStore.m36setUserID$lambda1(this.f37731a);
    }
}

package com.facebook.appevents.codeless;

import java.util.TimerTask;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewIndexer f37743a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TimerTask f37744b;

    public /* synthetic */ e(ViewIndexer viewIndexer, TimerTask timerTask) {
        this.f37743a = viewIndexer;
        this.f37744b = timerTask;
    }

    public final void run() {
        ViewIndexer.m63schedule$lambda0(this.f37743a, this.f37744b);
    }
}

package com.facebook.appevents;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlushReason f37752a;

    public /* synthetic */ e(FlushReason flushReason) {
        this.f37752a = flushReason;
    }

    public final void run() {
        AppEventQueue.m39flush$lambda2(this.f37752a);
    }
}

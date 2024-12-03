package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f21030a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f21031b;

    public /* synthetic */ c(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.f21030a = reportQueue;
        this.f21031b = countDownLatch;
    }

    public final void run() {
        this.f21030a.lambda$flushScheduledReportsIfAble$0(this.f21031b);
    }
}

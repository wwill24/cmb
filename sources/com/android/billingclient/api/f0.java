package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class f0 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f8911a = Executors.defaultThreadFactory();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f8912b = new AtomicInteger(1);

    f0(f fVar) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f8911a.newThread(runnable);
        int andIncrement = this.f8912b.getAndIncrement();
        newThread.setName("PlayBillingLibrary-" + andIncrement);
        return newThread;
    }
}

package com.facebook.internal;

import com.facebook.internal.WorkQueue;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkQueue.WorkNode f37875a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkQueue f37876b;

    public /* synthetic */ w(WorkQueue.WorkNode workNode, WorkQueue workQueue) {
        this.f37875a = workNode;
        this.f37876b = workQueue;
    }

    public final void run() {
        WorkQueue.m133execute$lambda2(this.f37875a, this.f37876b);
    }
}

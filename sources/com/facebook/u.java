package com.facebook;

import com.facebook.GraphRequestBatch;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequestBatch.Callback f37945a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressOutputStream f37946b;

    public /* synthetic */ u(GraphRequestBatch.Callback callback, ProgressOutputStream progressOutputStream) {
        this.f37945a = callback;
        this.f37946b = progressOutputStream;
    }

    public final void run() {
        ProgressOutputStream.m31reportBatchProgress$lambda0(this.f37945a, this.f37946b);
    }
}

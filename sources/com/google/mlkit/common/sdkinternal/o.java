package com.google.mlkit.common.sdkinternal;

import java.lang.ref.ReferenceQueue;
import java.util.Set;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReferenceQueue f21452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f21453b;

    public /* synthetic */ o(ReferenceQueue referenceQueue, Set set) {
        this.f21452a = referenceQueue;
        this.f21453b = set;
    }

    public final void run() {
        ReferenceQueue referenceQueue = this.f21452a;
        Set set = this.f21453b;
        while (!set.isEmpty()) {
            try {
                ((r) referenceQueue.remove()).a();
            } catch (InterruptedException unused) {
            }
        }
    }
}

package com.google.android.gms.common.api.internal;

final class o3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f38713a;

    o3(y yVar) {
        this.f38713a = yVar;
    }

    public final void run() {
        this.f38713a.f38818n.lock();
        try {
            y.z(this.f38713a);
        } finally {
            this.f38713a.f38818n.unlock();
        }
    }
}

package androidx.camera.core.impl;

import zf.a;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2567a;

    public /* synthetic */ m0(a aVar) {
        this.f2567a = aVar;
    }

    public final void run() {
        this.f2567a.cancel(true);
    }
}

package androidx.camera.core;

import zf.a;

public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2929a;

    public /* synthetic */ w0(a aVar) {
        this.f2929a = aVar;
    }

    public final void run() {
        this.f2929a.cancel(true);
    }
}

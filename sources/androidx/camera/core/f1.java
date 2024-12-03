package androidx.camera.core;

import androidx.camera.core.h1;

public final /* synthetic */ class f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1.m f2239a;

    public /* synthetic */ f1(h1.m mVar) {
        this.f2239a = mVar;
    }

    public final void run() {
        this.f2239a.b(new ImageCaptureException(0, "Request is canceled", (Throwable) null));
    }
}

package androidx.camera.camera2.internal;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class o2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f1899a;

    public /* synthetic */ o2(DeferrableSurface deferrableSurface) {
        this.f1899a = deferrableSurface;
    }

    public final void run() {
        ProcessingCaptureSession.f1637q.remove(this.f1899a);
    }
}

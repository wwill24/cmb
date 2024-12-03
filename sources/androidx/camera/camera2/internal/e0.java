package androidx.camera.camera2.internal;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f1728a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f1729b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f1730c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f1731d;

    public /* synthetic */ e0(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession, DeferrableSurface deferrableSurface, Runnable runnable) {
        this.f1728a = camera2CameraImpl;
        this.f1729b = captureSession;
        this.f1730c = deferrableSurface;
        this.f1731d = runnable;
    }

    public final void run() {
        this.f1728a.P(this.f1729b, this.f1730c, this.f1731d);
    }
}

package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16749b;

    public /* synthetic */ t(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16748a = cVar;
        this.f16749b = cameraCaptureSession;
    }

    public final void run() {
        this.f16748a.k(this.f16749b);
    }
}

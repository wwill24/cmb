package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16750a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16751b;

    public /* synthetic */ u(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16750a = cVar;
        this.f16751b = cameraCaptureSession;
    }

    public final void run() {
        this.f16750a.m(this.f16751b);
    }
}

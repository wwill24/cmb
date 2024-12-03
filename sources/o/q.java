package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16736a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16737b;

    public /* synthetic */ q(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16736a = cVar;
        this.f16737b = cameraCaptureSession;
    }

    public final void run() {
        this.f16736a.j(this.f16737b);
    }
}

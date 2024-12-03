package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16745b;

    public /* synthetic */ r(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16744a = cVar;
        this.f16745b = cameraCaptureSession;
    }

    public final void run() {
        this.f16744a.i(this.f16745b);
    }
}

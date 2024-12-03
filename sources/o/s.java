package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16746a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16747b;

    public /* synthetic */ s(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16746a = cVar;
        this.f16747b = cameraCaptureSession;
    }

    public final void run() {
        this.f16746a.h(this.f16747b);
    }
}

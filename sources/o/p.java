package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16732a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16733b;

    public /* synthetic */ p(h.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f16732a = cVar;
        this.f16733b = cameraCaptureSession;
    }

    public final void run() {
        this.f16732a.l(this.f16733b);
    }
}

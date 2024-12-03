package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16697a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16698b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f16699c;

    public /* synthetic */ i(h.b bVar, CameraCaptureSession cameraCaptureSession, int i10) {
        this.f16697a = bVar;
        this.f16698b = cameraCaptureSession;
        this.f16699c = i10;
    }

    public final void run() {
        this.f16697a.l(this.f16698b, this.f16699c);
    }
}

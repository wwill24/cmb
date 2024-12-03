package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import o.h;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16726a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f16728c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureFailure f16729d;

    public /* synthetic */ o(h.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        this.f16726a = bVar;
        this.f16727b = cameraCaptureSession;
        this.f16728c = captureRequest;
        this.f16729d = captureFailure;
    }

    public final void run() {
        this.f16726a.j(this.f16727b, this.f16728c, this.f16729d);
    }
}

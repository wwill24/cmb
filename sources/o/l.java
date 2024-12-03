package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import o.h;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16709a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16710b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f16711c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureResult f16712d;

    public /* synthetic */ l(h.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        this.f16709a = bVar;
        this.f16710b = cameraCaptureSession;
        this.f16711c = captureRequest;
        this.f16712d = captureResult;
    }

    public final void run() {
        this.f16709a.k(this.f16710b, this.f16711c, this.f16712d);
    }
}

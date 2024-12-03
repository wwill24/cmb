package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import o.h;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f16715c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TotalCaptureResult f16716d;

    public /* synthetic */ m(h.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        this.f16713a = bVar;
        this.f16714b = cameraCaptureSession;
        this.f16715c = captureRequest;
        this.f16716d = totalCaptureResult;
    }

    public final void run() {
        this.f16713a.i(this.f16714b, this.f16715c, this.f16716d);
    }
}

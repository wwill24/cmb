package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import o.h;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16720a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f16722c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f16723d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f16724e;

    public /* synthetic */ n(h.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j10, long j11) {
        this.f16720a = bVar;
        this.f16721b = cameraCaptureSession;
        this.f16722c = captureRequest;
        this.f16723d = j10;
        this.f16724e = j11;
    }

    public final void run() {
        this.f16720a.n(this.f16721b, this.f16722c, this.f16723d, this.f16724e);
    }
}

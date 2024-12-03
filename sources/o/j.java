package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import o.h;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16700a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16701b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f16702c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Surface f16703d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f16704e;

    public /* synthetic */ j(h.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j10) {
        this.f16700a = bVar;
        this.f16701b = cameraCaptureSession;
        this.f16702c = captureRequest;
        this.f16703d = surface;
        this.f16704e = j10;
    }

    public final void run() {
        this.f16700a.h(this.f16701b, this.f16702c, this.f16703d, this.f16704e);
    }
}

package o;

import android.hardware.camera2.CameraCaptureSession;
import o.h;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b f16705a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16706b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f16707c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f16708d;

    public /* synthetic */ k(h.b bVar, CameraCaptureSession cameraCaptureSession, int i10, long j10) {
        this.f16705a = bVar;
        this.f16706b = cameraCaptureSession;
        this.f16707c = i10;
        this.f16708d = j10;
    }

    public final void run() {
        this.f16705a.m(this.f16706b, this.f16707c, this.f16708d);
    }
}

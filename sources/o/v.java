package o;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import o.h;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f16752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f16753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f16754c;

    public /* synthetic */ v(h.c cVar, CameraCaptureSession cameraCaptureSession, Surface surface) {
        this.f16752a = cVar;
        this.f16753b = cameraCaptureSession;
        this.f16754c = surface;
    }

    public final void run() {
        this.f16752a.n(this.f16753b, this.f16754c);
    }
}

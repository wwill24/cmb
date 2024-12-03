package o;

import android.hardware.camera2.CameraDevice;
import o.d0;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.b f16694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f16695b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f16696c;

    public /* synthetic */ h0(d0.b bVar, CameraDevice cameraDevice, int i10) {
        this.f16694a = bVar;
        this.f16695b = cameraDevice;
        this.f16696c = i10;
    }

    public final void run() {
        this.f16694a.g(this.f16695b, this.f16696c);
    }
}

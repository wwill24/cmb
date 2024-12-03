package o;

import android.hardware.camera2.CameraDevice;
import o.d0;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.b f16687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f16688b;

    public /* synthetic */ g0(d0.b bVar, CameraDevice cameraDevice) {
        this.f16687a = bVar;
        this.f16688b = cameraDevice;
    }

    public final void run() {
        this.f16687a.h(this.f16688b);
    }
}

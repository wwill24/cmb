package o;

import android.hardware.camera2.CameraDevice;
import o.d0;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.b f16683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f16684b;

    public /* synthetic */ e0(d0.b bVar, CameraDevice cameraDevice) {
        this.f16683a = bVar;
        this.f16684b = cameraDevice;
    }

    public final void run() {
        this.f16683a.e(this.f16684b);
    }
}

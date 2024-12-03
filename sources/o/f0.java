package o;

import android.hardware.camera2.CameraDevice;
import o.d0;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0.b f16685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f16686b;

    public /* synthetic */ f0(d0.b bVar, CameraDevice cameraDevice) {
        this.f16685a = bVar;
        this.f16686b = cameraDevice;
    }

    public final void run() {
        this.f16685a.f(this.f16686b);
    }
}

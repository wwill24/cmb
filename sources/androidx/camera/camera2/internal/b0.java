package androidx.camera.camera2.internal;

import java.util.List;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f1683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f1684b;

    public /* synthetic */ b0(Camera2CameraImpl camera2CameraImpl, List list) {
        this.f1683a = camera2CameraImpl;
        this.f1684b = list;
    }

    public final void run() {
        this.f1683a.Q(this.f1684b);
    }
}

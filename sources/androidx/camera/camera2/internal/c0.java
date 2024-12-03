package androidx.camera.camera2.internal;

import java.util.List;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f1691a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f1692b;

    public /* synthetic */ c0(Camera2CameraImpl camera2CameraImpl, List list) {
        this.f1691a = camera2CameraImpl;
        this.f1692b = list;
    }

    public final void run() {
        this.f1691a.N(this.f1692b);
    }
}

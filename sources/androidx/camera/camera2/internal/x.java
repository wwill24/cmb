package androidx.camera.camera2.internal;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f2019a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2020b;

    public /* synthetic */ x(Camera2CameraImpl camera2CameraImpl, boolean z10) {
        this.f2019a = camera2CameraImpl;
        this.f2020b = z10;
    }

    public final void run() {
        this.f2019a.W(this.f2020b);
    }
}

package androidx.camera.camera2.internal;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f2008a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2009b;

    public /* synthetic */ w(Camera2CameraImpl camera2CameraImpl, String str) {
        this.f2008a = camera2CameraImpl;
        this.f2009b = str;
    }

    public final void run() {
        this.f2008a.S(this.f2009b);
    }
}

package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Surface f1712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f1713b;

    public /* synthetic */ d0(Surface surface, SurfaceTexture surfaceTexture) {
        this.f1712a = surface;
        this.f1713b = surfaceTexture;
    }

    public final void run() {
        Camera2CameraImpl.O(this.f1712a, this.f1713b);
    }
}

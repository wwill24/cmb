package a0;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f48a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f49b;

    public /* synthetic */ h(k kVar, SurfaceRequest surfaceRequest) {
        this.f48a = kVar;
        this.f49b = surfaceRequest;
    }

    public final void run() {
        this.f48a.o(this.f49b);
    }
}

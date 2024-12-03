package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class e3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.g f2227a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.f f2228b;

    public /* synthetic */ e3(SurfaceRequest.g gVar, SurfaceRequest.f fVar) {
        this.f2227a = gVar;
        this.f2228b = fVar;
    }

    public final void run() {
        this.f2227a.a(this.f2228b);
    }
}

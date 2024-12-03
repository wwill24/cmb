package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class b3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.g f2188a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.f f2189b;

    public /* synthetic */ b3(SurfaceRequest.g gVar, SurfaceRequest.f fVar) {
        this.f2188a = gVar;
        this.f2189b = fVar;
    }

    public final void run() {
        this.f2188a.a(this.f2189b);
    }
}

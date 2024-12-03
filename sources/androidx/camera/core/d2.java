package androidx.camera.core;

import androidx.camera.core.f2;

public final /* synthetic */ class d2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f2.d f2217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f2218b;

    public /* synthetic */ d2(f2.d dVar, SurfaceRequest surfaceRequest) {
        this.f2217a = dVar;
        this.f2218b = surfaceRequest;
    }

    public final void run() {
        this.f2217a.a(this.f2218b);
    }
}

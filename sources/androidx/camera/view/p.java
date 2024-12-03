package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f3504a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f3505b;

    public /* synthetic */ p(r rVar, SurfaceRequest surfaceRequest) {
        this.f3504a = rVar;
        this.f3505b = surfaceRequest;
    }

    public final void run() {
        this.f3504a.o(this.f3505b);
    }
}

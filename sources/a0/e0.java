package a0;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f37a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f38b;

    public /* synthetic */ e0(g0 g0Var, SurfaceRequest surfaceRequest) {
        this.f37a = g0Var;
        this.f38b = surfaceRequest;
    }

    public final void run() {
        this.f37a.e(this.f38b);
    }
}

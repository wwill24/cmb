package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f3516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f3517b;

    public /* synthetic */ u(z zVar, SurfaceRequest surfaceRequest) {
        this.f3516a = zVar;
        this.f3517b = surfaceRequest;
    }

    public final void run() {
        this.f3516a.p(this.f3517b);
    }
}

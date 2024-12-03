package a0;

import androidx.camera.core.SurfaceOutput;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f44a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f45b;

    public /* synthetic */ g(k kVar, SurfaceOutput surfaceOutput) {
        this.f44a = kVar;
        this.f45b = surfaceOutput;
    }

    public final void run() {
        this.f44a.q(this.f45b);
    }
}

package a0;

import androidx.camera.core.SurfaceOutput;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f42a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f43b;

    public /* synthetic */ f0(g0 g0Var, SurfaceOutput surfaceOutput) {
        this.f42a = g0Var;
        this.f43b = surfaceOutput;
    }

    public final void run() {
        this.f42a.f(this.f43b);
    }
}

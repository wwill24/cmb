package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.f2;
import androidx.camera.core.impl.Config;
import v.i;

public final class p1 implements f2<f2>, v0, i {
    public static final Config.a<t0> B = Config.a.a("camerax.core.preview.imageInfoProcessor", t0.class);
    public static final Config.a<e0> C = Config.a.a("camerax.core.preview.captureProcessor", e0.class);
    public static final Config.a<Boolean> D = Config.a.a("camerax.core.preview.isRgba8888SurfaceRequired", Boolean.class);
    private final n1 A;

    public p1(@NonNull n1 n1Var) {
        this.A = n1Var;
    }

    public e0 K(e0 e0Var) {
        return (e0) g(C, e0Var);
    }

    public t0 L(t0 t0Var) {
        return (t0) g(B, t0Var);
    }

    public boolean M(boolean z10) {
        return ((Boolean) g(D, Boolean.valueOf(z10))).booleanValue();
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }

    public int l() {
        return ((Integer) a(u0.f2585f)).intValue();
    }
}

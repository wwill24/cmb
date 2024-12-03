package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.l0;
import androidx.camera.core.p1;
import v.i;

public final class r0 implements f2<l0>, v0, i {
    public static final Config.a<Integer> B = Config.a.a("camerax.core.imageAnalysis.backpressureStrategy", l0.b.class);
    public static final Config.a<Integer> C = Config.a.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.a<p1> D = Config.a.a("camerax.core.imageAnalysis.imageReaderProxyProvider", p1.class);
    public static final Config.a<Integer> E = Config.a.a("camerax.core.imageAnalysis.outputImageFormat", l0.e.class);
    public static final Config.a<Boolean> F;
    public static final Config.a<Boolean> G;
    private final n1 A;

    static {
        Class<Boolean> cls = Boolean.class;
        F = Config.a.a("camerax.core.imageAnalysis.onePixelShiftEnabled", cls);
        G = Config.a.a("camerax.core.imageAnalysis.outputImageRotationEnabled", cls);
    }

    public r0(@NonNull n1 n1Var) {
        this.A = n1Var;
    }

    public int K(int i10) {
        return ((Integer) g(B, Integer.valueOf(i10))).intValue();
    }

    public int L(int i10) {
        return ((Integer) g(C, Integer.valueOf(i10))).intValue();
    }

    public p1 M() {
        return (p1) g(D, null);
    }

    public Boolean N(Boolean bool) {
        return (Boolean) g(F, bool);
    }

    public int O(int i10) {
        return ((Integer) g(E, Integer.valueOf(i10))).intValue();
    }

    public Boolean P(Boolean bool) {
        return (Boolean) g(G, bool);
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }

    public int l() {
        return 35;
    }
}

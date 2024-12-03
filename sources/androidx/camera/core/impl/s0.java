package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.h1;
import androidx.camera.core.impl.Config;
import androidx.camera.core.p1;
import java.util.concurrent.Executor;
import v.g;

public final class s0 implements f2<h1>, v0, g {
    public static final Config.a<Integer> B;
    public static final Config.a<Integer> C;
    public static final Config.a<c0> D = Config.a.a("camerax.core.imageCapture.captureBundle", c0.class);
    public static final Config.a<e0> E = Config.a.a("camerax.core.imageCapture.captureProcessor", e0.class);
    public static final Config.a<Integer> F;
    public static final Config.a<Integer> G;
    public static final Config.a<p1> H = Config.a.a("camerax.core.imageCapture.imageReaderProxyProvider", p1.class);
    public static final Config.a<Boolean> I = Config.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
    public static final Config.a<Integer> J;
    public static final Config.a<Integer> K;
    private final n1 A;

    static {
        Class<Integer> cls = Integer.class;
        Class cls2 = Integer.TYPE;
        B = Config.a.a("camerax.core.imageCapture.captureMode", cls2);
        C = Config.a.a("camerax.core.imageCapture.flashMode", cls2);
        F = Config.a.a("camerax.core.imageCapture.bufferFormat", cls);
        G = Config.a.a("camerax.core.imageCapture.maxCaptureStages", cls);
        J = Config.a.a("camerax.core.imageCapture.flashType", cls2);
        K = Config.a.a("camerax.core.imageCapture.jpegCompressionQuality", cls2);
    }

    public s0(@NonNull n1 n1Var) {
        this.A = n1Var;
    }

    public c0 K(c0 c0Var) {
        return (c0) g(D, c0Var);
    }

    public int L() {
        return ((Integer) a(B)).intValue();
    }

    public e0 M(e0 e0Var) {
        return (e0) g(E, e0Var);
    }

    public int N(int i10) {
        return ((Integer) g(C, Integer.valueOf(i10))).intValue();
    }

    public int O(int i10) {
        return ((Integer) g(J, Integer.valueOf(i10))).intValue();
    }

    public p1 P() {
        return (p1) g(H, null);
    }

    public Executor Q(Executor executor) {
        return (Executor) g(g.f18037v, executor);
    }

    public int R() {
        return ((Integer) a(K)).intValue();
    }

    public int S(int i10) {
        return ((Integer) g(G, Integer.valueOf(i10))).intValue();
    }

    public boolean T() {
        return b(B);
    }

    public boolean U() {
        return ((Boolean) g(I, Boolean.FALSE)).booleanValue();
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }

    public int l() {
        return ((Integer) a(u0.f2585f)).intValue();
    }
}

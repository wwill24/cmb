package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.Config;
import v.i;

public final class g2 implements f2<VideoCapture>, v0, i {
    public static final Config.a<Integer> B;
    public static final Config.a<Integer> C;
    public static final Config.a<Integer> D;
    public static final Config.a<Integer> E;
    public static final Config.a<Integer> F;
    public static final Config.a<Integer> G;
    public static final Config.a<Integer> H;
    private final n1 A;

    static {
        Class cls = Integer.TYPE;
        B = Config.a.a("camerax.core.videoCapture.recordingFrameRate", cls);
        C = Config.a.a("camerax.core.videoCapture.bitRate", cls);
        D = Config.a.a("camerax.core.videoCapture.intraFrameInterval", cls);
        E = Config.a.a("camerax.core.videoCapture.audioBitRate", cls);
        F = Config.a.a("camerax.core.videoCapture.audioSampleRate", cls);
        G = Config.a.a("camerax.core.videoCapture.audioChannelCount", cls);
        H = Config.a.a("camerax.core.videoCapture.audioMinBufferSize", cls);
    }

    public g2(@NonNull n1 n1Var) {
        this.A = n1Var;
    }

    public int K() {
        return ((Integer) a(E)).intValue();
    }

    public int L() {
        return ((Integer) a(G)).intValue();
    }

    public int M() {
        return ((Integer) a(H)).intValue();
    }

    public int N() {
        return ((Integer) a(F)).intValue();
    }

    public int O() {
        return ((Integer) a(C)).intValue();
    }

    public int P() {
        return ((Integer) a(D)).intValue();
    }

    public int Q() {
        return ((Integer) a(B)).intValue();
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }

    public int l() {
        return 34;
    }
}

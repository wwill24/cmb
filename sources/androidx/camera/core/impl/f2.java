package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.e0;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.d0;
import androidx.camera.core.r;
import v.h;
import v.j;

public interface f2<T extends UseCase> extends h<T>, j, u0 {

    /* renamed from: n  reason: collision with root package name */
    public static final Config.a<SessionConfig> f2524n = Config.a.a("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);

    /* renamed from: o  reason: collision with root package name */
    public static final Config.a<d0> f2525o = Config.a.a("camerax.core.useCase.defaultCaptureConfig", d0.class);

    /* renamed from: p  reason: collision with root package name */
    public static final Config.a<SessionConfig.d> f2526p = Config.a.a("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.d.class);

    /* renamed from: q  reason: collision with root package name */
    public static final Config.a<d0.b> f2527q = Config.a.a("camerax.core.useCase.captureConfigUnpacker", d0.b.class);

    /* renamed from: r  reason: collision with root package name */
    public static final Config.a<Integer> f2528r = Config.a.a("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);

    /* renamed from: s  reason: collision with root package name */
    public static final Config.a<r> f2529s;

    /* renamed from: t  reason: collision with root package name */
    public static final Config.a<Range<Integer>> f2530t;

    /* renamed from: u  reason: collision with root package name */
    public static final Config.a<Boolean> f2531u = Config.a.a("camerax.core.useCase.zslDisabled", Boolean.TYPE);

    public interface a<T extends UseCase, C extends f2<T>, B> extends e0<T> {
        @NonNull
        C b();
    }

    static {
        Class<r> cls = r.class;
        f2529s = Config.a.a("camerax.core.useCase.cameraSelector", cls);
        f2530t = Config.a.a("camerax.core.useCase.targetFrameRate", cls);
    }

    boolean A(boolean z10) {
        return ((Boolean) g(f2531u, Boolean.valueOf(z10))).booleanValue();
    }

    Range<Integer> C(Range<Integer> range) {
        return (Range) g(f2530t, range);
    }

    r G(r rVar) {
        return (r) g(f2529s, rVar);
    }

    SessionConfig.d I(SessionConfig.d dVar) {
        return (SessionConfig.d) g(f2526p, dVar);
    }

    SessionConfig m(SessionConfig sessionConfig) {
        return (SessionConfig) g(f2524n, sessionConfig);
    }

    d0.b o(d0.b bVar) {
        return (d0.b) g(f2527q, bVar);
    }

    d0 q(d0 d0Var) {
        return (d0) g(f2525o, d0Var);
    }

    int w(int i10) {
        return ((Integer) g(f2528r, Integer.valueOf(i10))).intValue();
    }
}

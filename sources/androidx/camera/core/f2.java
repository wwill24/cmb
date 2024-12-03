package androidx.camera.core;

import a0.a0;
import a0.d0;
import a0.u;
import a0.w;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.t0;
import androidx.camera.core.impl.v0;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.commons.cli.HelpFormatter;
import v.h;

public final class f2 extends UseCase {

    /* renamed from: t  reason: collision with root package name */
    public static final c f2240t = new c();

    /* renamed from: u  reason: collision with root package name */
    private static final Executor f2241u = androidx.camera.core.impl.utils.executor.a.d();

    /* renamed from: m  reason: collision with root package name */
    private d f2242m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    private Executor f2243n = f2241u;

    /* renamed from: o  reason: collision with root package name */
    private DeferrableSurface f2244o;

    /* renamed from: p  reason: collision with root package name */
    SurfaceRequest f2245p;

    /* renamed from: q  reason: collision with root package name */
    private Size f2246q;

    /* renamed from: r  reason: collision with root package name */
    private a0 f2247r;

    /* renamed from: s  reason: collision with root package name */
    private d0 f2248s;

    class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t0 f2249a;

        a(t0 t0Var) {
            this.f2249a = t0Var;
        }

        public void b(@NonNull p pVar) {
            super.b(pVar);
            if (this.f2249a.a(new v.c(pVar))) {
                f2.this.w();
            }
        }
    }

    public static final class b implements f2.a<f2, p1, b> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f2251a;

        public b() {
            this(i1.O());
        }

        @NonNull
        static b d(@NonNull Config config) {
            return new b(i1.P(config));
        }

        @NonNull
        public h1 a() {
            return this.f2251a;
        }

        @NonNull
        public f2 c() {
            if (a().g(v0.f2689g, null) == null || a().g(v0.f2692j, null) == null) {
                return new f2(b());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @NonNull
        /* renamed from: e */
        public p1 b() {
            return new p1(n1.M(this.f2251a));
        }

        @NonNull
        public b f(int i10) {
            a().p(androidx.camera.core.impl.f2.f2528r, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public b g(int i10) {
            a().p(v0.f2689g, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public b h(@NonNull Class<f2> cls) {
            a().p(h.f18039x, cls);
            if (a().g(h.f18038w, null) == null) {
                i(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public b i(@NonNull String str) {
            a().p(h.f18038w, str);
            return this;
        }

        @NonNull
        public b j(int i10) {
            a().p(v0.f2690h, Integer.valueOf(i10));
            a().p(v0.f2691i, Integer.valueOf(i10));
            return this;
        }

        private b(i1 i1Var) {
            Class<f2> cls = f2.class;
            this.f2251a = i1Var;
            Class cls2 = (Class) i1Var.g(h.f18039x, null);
            if (cls2 == null || cls2.equals(cls)) {
                h(cls);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private static final p1 f2252a = new b().f(2).g(0).b();

        @NonNull
        public p1 a() {
            return f2252a;
        }
    }

    public interface d {
        void a(@NonNull SurfaceRequest surfaceRequest);
    }

    f2(@NonNull p1 p1Var) {
        super(p1Var);
    }

    private void N(@NonNull SessionConfig.b bVar, @NonNull String str, @NonNull p1 p1Var, @NonNull Size size) {
        if (this.f2242m != null) {
            bVar.k(this.f2244o);
        }
        bVar.f(new e2(this, str, p1Var, size));
    }

    private void O() {
        DeferrableSurface deferrableSurface = this.f2244o;
        if (deferrableSurface != null) {
            deferrableSurface.c();
            this.f2244o = null;
        }
        d0 d0Var = this.f2248s;
        if (d0Var != null) {
            d0Var.f();
            this.f2248s = null;
        }
        this.f2245p = null;
    }

    @NonNull
    private SessionConfig.b Q(@NonNull String str, @NonNull p1 p1Var, @NonNull Size size) {
        Size size2 = size;
        androidx.camera.core.impl.utils.p.a();
        androidx.core.util.h.g(this.f2247r);
        CameraInternal d10 = d();
        androidx.core.util.h.g(d10);
        O();
        this.f2248s = new d0(d10, SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM, this.f2247r);
        Matrix matrix = new Matrix();
        Rect R = R(size2);
        Objects.requireNonNull(R);
        Rect rect = R;
        u uVar = new u(1, size, 34, matrix, true, R, k(d10), false);
        w a10 = w.a(Collections.singletonList(uVar));
        this.f2244o = uVar;
        this.f2245p = this.f2248s.i(a10).b().get(0).u(d10);
        if (this.f2242m != null) {
            U();
        }
        SessionConfig.b o10 = SessionConfig.b.o(p1Var);
        String str2 = str;
        p1 p1Var2 = p1Var;
        N(o10, str, p1Var, size2);
        return o10;
    }

    private Rect R(Size size) {
        if (p() != null) {
            return p();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(String str, p1 p1Var, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (q(str)) {
            J(P(str, p1Var, size).m());
            u();
        }
    }

    private void U() {
        this.f2243n.execute(new d2((d) androidx.core.util.h.g(this.f2242m), (SurfaceRequest) androidx.core.util.h.g(this.f2245p)));
        V();
    }

    private void V() {
        CameraInternal d10 = d();
        d dVar = this.f2242m;
        Rect R = R(this.f2246q);
        SurfaceRequest surfaceRequest = this.f2245p;
        if (d10 != null && dVar != null && R != null && surfaceRequest != null) {
            surfaceRequest.y(SurfaceRequest.f.d(R, k(d10), b()));
        }
    }

    private void Z(@NonNull String str, @NonNull p1 p1Var, @NonNull Size size) {
        J(P(str, p1Var, size).m());
    }

    public void B() {
        O();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.camera.core.impl.f2$a, androidx.camera.core.impl.f2$a<?, ?, ?>, androidx.camera.core.e0] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.f2<?> C(@androidx.annotation.NonNull androidx.camera.core.impl.x r3, @androidx.annotation.NonNull androidx.camera.core.impl.f2.a<?, ?, ?> r4) {
        /*
            r2 = this;
            androidx.camera.core.impl.h1 r3 = r4.a()
            androidx.camera.core.impl.Config$a<androidx.camera.core.impl.e0> r0 = androidx.camera.core.impl.p1.C
            r1 = 0
            java.lang.Object r3 = r3.g(r0, r1)
            if (r3 == 0) goto L_0x001d
            androidx.camera.core.impl.h1 r3 = r4.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r0 = androidx.camera.core.impl.u0.f2585f
            r1 = 35
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.p(r0, r1)
            goto L_0x002c
        L_0x001d:
            androidx.camera.core.impl.h1 r3 = r4.a()
            androidx.camera.core.impl.Config$a<java.lang.Integer> r0 = androidx.camera.core.impl.u0.f2585f
            r1 = 34
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.p(r0, r1)
        L_0x002c:
            androidx.camera.core.impl.f2 r3 = r4.b()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.f2.C(androidx.camera.core.impl.x, androidx.camera.core.impl.f2$a):androidx.camera.core.impl.f2");
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Size F(@NonNull Size size) {
        this.f2246q = size;
        Z(f(), (p1) g(), this.f2246q);
        return size;
    }

    public void I(@NonNull Rect rect) {
        super.I(rect);
        V();
    }

    /* access modifiers changed from: package-private */
    public SessionConfig.b P(@NonNull String str, @NonNull p1 p1Var, @NonNull Size size) {
        p1 p1Var2 = p1Var;
        Size size2 = size;
        if (this.f2247r != null) {
            return Q(str, p1Var, size);
        }
        androidx.camera.core.impl.utils.p.a();
        SessionConfig.b o10 = SessionConfig.b.o(p1Var);
        e0 K = p1Var2.K((e0) null);
        O();
        SurfaceRequest surfaceRequest = new SurfaceRequest(size2, d(), p1Var2.M(false));
        this.f2245p = surfaceRequest;
        if (this.f2242m != null) {
            U();
        }
        if (K != null) {
            f0.a aVar = new f0.a();
            HandlerThread handlerThread = new HandlerThread("CameraX-preview_processing");
            handlerThread.start();
            String num = Integer.toString(aVar.hashCode());
            p2 p2Var = r5;
            p2 p2Var2 = new p2(size.getWidth(), size.getHeight(), p1Var.l(), new Handler(handlerThread.getLooper()), aVar, K, surfaceRequest.k(), num);
            o10.d(p2Var.s());
            p2Var.i().addListener(new c2(handlerThread), androidx.camera.core.impl.utils.executor.a.a());
            this.f2244o = p2Var;
            o10.l(num, Integer.valueOf(aVar.getId()));
        } else {
            t0 L = p1Var2.L((t0) null);
            if (L != null) {
                o10.d(new a(L));
            }
            this.f2244o = surfaceRequest.k();
        }
        N(o10, str, p1Var2, size2);
        return o10;
    }

    public void W(a0 a0Var) {
        this.f2247r = a0Var;
    }

    public void X(d dVar) {
        Y(f2241u, dVar);
    }

    public void Y(@NonNull Executor executor, d dVar) {
        androidx.camera.core.impl.utils.p.a();
        if (dVar == null) {
            this.f2242m = null;
            t();
            return;
        }
        this.f2242m = dVar;
        this.f2243n = executor;
        s();
        if (c() != null) {
            Z(f(), (p1) g(), c());
            u();
        }
    }

    public androidx.camera.core.impl.f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a10 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.PREVIEW, 1);
        if (z10) {
            a10 = Config.D(a10, f2240t.a());
        }
        if (a10 == null) {
            return null;
        }
        return o(a10).b();
    }

    @NonNull
    public f2.a<?, ?, ?> o(@NonNull Config config) {
        return b.d(config);
    }

    @NonNull
    public String toString() {
        return "Preview:" + j();
    }
}

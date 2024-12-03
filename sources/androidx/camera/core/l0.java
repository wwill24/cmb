package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.r0;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.y0;
import com.leanplum.internal.ResourceQualifiers;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import java.util.concurrent.Executor;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;
import v.h;

public final class l0 extends UseCase {

    /* renamed from: q  reason: collision with root package name */
    public static final d f2794q = new d();

    /* renamed from: r  reason: collision with root package name */
    private static final Boolean f2795r = null;

    /* renamed from: m  reason: collision with root package name */
    final o0 f2796m;

    /* renamed from: n  reason: collision with root package name */
    private final Object f2797n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private a f2798o;

    /* renamed from: p  reason: collision with root package name */
    private DeferrableSurface f2799p;

    public interface a {
        Size b() {
            return null;
        }

        void i(@NonNull o1 o1Var);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static final class c implements f2.a<l0, r0, c> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f2800a;

        public c() {
            this(i1.O());
        }

        @NonNull
        static c d(@NonNull Config config) {
            return new c(i1.P(config));
        }

        @NonNull
        public h1 a() {
            return this.f2800a;
        }

        @NonNull
        public l0 c() {
            if (a().g(v0.f2689g, null) == null || a().g(v0.f2692j, null) == null) {
                return new l0(b());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @NonNull
        /* renamed from: e */
        public r0 b() {
            return new r0(n1.M(this.f2800a));
        }

        @NonNull
        public c f(@NonNull Size size) {
            a().p(v0.f2693k, size);
            return this;
        }

        @NonNull
        public c g(int i10) {
            a().p(r0.C, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c h(int i10) {
            a().p(f2.f2528r, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c i(int i10) {
            a().p(v0.f2689g, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c j(@NonNull Class<l0> cls) {
            a().p(h.f18039x, cls);
            if (a().g(h.f18038w, null) == null) {
                k(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public c k(@NonNull String str) {
            a().p(h.f18038w, str);
            return this;
        }

        @NonNull
        public c l(@NonNull Size size) {
            a().p(v0.f2692j, size);
            return this;
        }

        @NonNull
        public c m(int i10) {
            a().p(v0.f2690h, Integer.valueOf(i10));
            return this;
        }

        private c(i1 i1Var) {
            Class<l0> cls = l0.class;
            this.f2800a = i1Var;
            Class cls2 = (Class) i1Var.g(h.f18039x, null);
            if (cls2 == null || cls2.equals(cls)) {
                j(cls);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private static final Size f2801a;

        /* renamed from: b  reason: collision with root package name */
        private static final r0 f2802b;

        static {
            Size size = new Size(640, ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_XXHIGH);
            f2801a = size;
            f2802b = new c().f(size).h(1).i(0).b();
        }

        @NonNull
        public r0 a() {
            return f2802b;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    l0(@NonNull r0 r0Var) {
        super(r0Var);
        if (((r0) g()).K(0) == 1) {
            this.f2796m = new p0();
        } else {
            this.f2796m = new q0(r0Var.F(androidx.camera.core.impl.utils.executor.a.b()));
        }
        this.f2796m.t(T());
        this.f2796m.u(V());
    }

    private boolean U(@NonNull CameraInternal cameraInternal) {
        if (!V() || k(cameraInternal) % Opcodes.GETFIELD == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void W(s2 s2Var, s2 s2Var2) {
        s2Var.l();
        if (s2Var2 != null) {
            s2Var2.l();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(String str, r0 r0Var, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        O();
        this.f2796m.g();
        if (q(str)) {
            J(P(str, r0Var, size).m());
            u();
        }
    }

    private void a0() {
        CameraInternal d10 = d();
        if (d10 != null) {
            this.f2796m.w(k(d10));
        }
    }

    public void B() {
        O();
        this.f2796m.j();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.camera.core.impl.f2$a, androidx.camera.core.impl.f2$a<?, ?, ?>, androidx.camera.core.e0] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.f2<?> C(@androidx.annotation.NonNull androidx.camera.core.impl.x r3, @androidx.annotation.NonNull androidx.camera.core.impl.f2.a<?, ?, ?> r4) {
        /*
            r2 = this;
            java.lang.Boolean r0 = r2.S()
            androidx.camera.core.impl.r1 r3 = r3.e()
            java.lang.Class<x.d> r1 = x.d.class
            boolean r3 = r3.a(r1)
            androidx.camera.core.o0 r1 = r2.f2796m
            if (r0 != 0) goto L_0x0013
            goto L_0x0017
        L_0x0013:
            boolean r3 = r0.booleanValue()
        L_0x0017:
            r1.s(r3)
            java.lang.Object r3 = r2.f2797n
            monitor-enter(r3)
            androidx.camera.core.l0$a r0 = r2.f2798o     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0026
            android.util.Size r0 = r0.b()     // Catch:{ all -> 0x0042 }
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x003d
            androidx.camera.core.impl.f2 r3 = r4.b()
            androidx.camera.core.impl.Config$a<android.util.Size> r1 = androidx.camera.core.impl.v0.f2692j
            boolean r3 = r3.b(r1)
            if (r3 != 0) goto L_0x003d
            androidx.camera.core.impl.h1 r3 = r4.a()
            r3.p(r1, r0)
        L_0x003d:
            androidx.camera.core.impl.f2 r3 = r4.b()
            return r3
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.l0.C(androidx.camera.core.impl.x, androidx.camera.core.impl.f2$a):androidx.camera.core.impl.f2");
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Size F(@NonNull Size size) {
        J(P(f(), (r0) g(), size).m());
        return size;
    }

    public void H(@NonNull Matrix matrix) {
        super.H(matrix);
        this.f2796m.x(matrix);
    }

    public void I(@NonNull Rect rect) {
        super.I(rect);
        this.f2796m.y(rect);
    }

    /* access modifiers changed from: package-private */
    public void O() {
        p.a();
        DeferrableSurface deferrableSurface = this.f2799p;
        if (deferrableSurface != null) {
            deferrableSurface.c();
            this.f2799p = null;
        }
    }

    /* access modifiers changed from: package-private */
    public SessionConfig.b P(@NonNull String str, @NonNull r0 r0Var, @NonNull Size size) {
        int i10;
        s2 s2Var;
        boolean z10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        s2 s2Var2;
        p.a();
        Executor executor = (Executor) androidx.core.util.h.g(r0Var.F(androidx.camera.core.impl.utils.executor.a.b()));
        boolean z12 = true;
        if (Q() == 1) {
            i10 = R();
        } else {
            i10 = 4;
        }
        int i14 = i10;
        if (r0Var.M() != null) {
            s2Var = new s2(r0Var.M().a(size.getWidth(), size.getHeight(), i(), i14, 0));
        } else {
            s2Var = new s2(q1.a(size.getWidth(), size.getHeight(), i(), i14));
        }
        if (d() != null) {
            z10 = U(d());
        } else {
            z10 = false;
        }
        if (z10) {
            i11 = size.getHeight();
        } else {
            i11 = size.getWidth();
        }
        if (z10) {
            i12 = size.getWidth();
        } else {
            i12 = size.getHeight();
        }
        if (T() == 2) {
            i13 = 1;
        } else {
            i13 = 35;
        }
        if (i() == 35 && T() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i() != 35 || ((d() == null || k(d()) == 0) && !Boolean.TRUE.equals(S()))) {
            z12 = false;
        }
        if (z11 || z12) {
            s2Var2 = new s2(q1.a(i11, i12, i13, s2Var.e()));
        } else {
            s2Var2 = null;
        }
        if (s2Var2 != null) {
            this.f2796m.v(s2Var2);
        }
        a0();
        s2Var.f(this.f2796m, executor);
        SessionConfig.b o10 = SessionConfig.b.o(r0Var);
        DeferrableSurface deferrableSurface = this.f2799p;
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
        y0 y0Var = new y0(s2Var.getSurface(), size, i());
        this.f2799p = y0Var;
        y0Var.i().addListener(new i0(s2Var, s2Var2), androidx.camera.core.impl.utils.executor.a.d());
        o10.k(this.f2799p);
        o10.f(new j0(this, str, r0Var, size));
        return o10;
    }

    public int Q() {
        return ((r0) g()).K(0);
    }

    public int R() {
        return ((r0) g()).L(6);
    }

    public Boolean S() {
        return ((r0) g()).N(f2795r);
    }

    public int T() {
        return ((r0) g()).O(1);
    }

    public boolean V() {
        return ((r0) g()).P(Boolean.FALSE).booleanValue();
    }

    public void Z(@NonNull Executor executor, @NonNull a aVar) {
        synchronized (this.f2797n) {
            this.f2796m.r(executor, new k0(aVar));
            if (this.f2798o == null) {
                s();
            }
            this.f2798o = aVar;
        }
    }

    public f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a10 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS, 1);
        if (z10) {
            a10 = Config.D(a10, f2794q.a());
        }
        if (a10 == null) {
            return null;
        }
        return o(a10).b();
    }

    @NonNull
    public f2.a<?, ?, ?> o(@NonNull Config config) {
        return c.d(config);
    }

    @NonNull
    public String toString() {
        return "ImageAnalysis:" + j();
    }

    public void y() {
        this.f2796m.f();
    }
}

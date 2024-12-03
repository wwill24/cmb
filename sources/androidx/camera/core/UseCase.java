package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.x;
import androidx.core.util.h;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c> f2126a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Object f2127b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private State f2128c = State.INACTIVE;

    /* renamed from: d  reason: collision with root package name */
    private f2<?> f2129d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private f2<?> f2130e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private f2<?> f2131f;

    /* renamed from: g  reason: collision with root package name */
    private Size f2132g;

    /* renamed from: h  reason: collision with root package name */
    private f2<?> f2133h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f2134i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private Matrix f2135j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    private CameraInternal f2136k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private SessionConfig f2137l = SessionConfig.a();

    enum State {
        ACTIVE,
        INACTIVE
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2141a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.UseCase$State[] r0 = androidx.camera.core.UseCase.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2141a = r0
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.INACTIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2141a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.ACTIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.a.<clinit>():void");
        }
    }

    public interface b {
        void a(@NonNull q qVar);

        void b();
    }

    public interface c {
        void d(@NonNull UseCase useCase);

        void e(@NonNull UseCase useCase);

        void i(@NonNull UseCase useCase);

        void n(@NonNull UseCase useCase);
    }

    protected UseCase(@NonNull f2<?> f2Var) {
        this.f2130e = f2Var;
        this.f2131f = f2Var;
    }

    private void G(@NonNull c cVar) {
        this.f2126a.remove(cVar);
    }

    private void a(@NonNull c cVar) {
        this.f2126a.add(cVar);
    }

    public void A(@NonNull CameraInternal cameraInternal) {
        boolean z10;
        B();
        b H = this.f2131f.H((b) null);
        if (H != null) {
            H.b();
        }
        synchronized (this.f2127b) {
            if (cameraInternal == this.f2136k) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.a(z10);
            G(this.f2136k);
            this.f2136k = null;
        }
        this.f2132g = null;
        this.f2134i = null;
        this.f2131f = this.f2130e;
        this.f2129d = null;
        this.f2133h = null;
    }

    public void B() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.camera.core.impl.f2$a, androidx.camera.core.impl.f2$a<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.f2<?> C(@androidx.annotation.NonNull androidx.camera.core.impl.x r1, @androidx.annotation.NonNull androidx.camera.core.impl.f2.a<?, ?, ?> r2) {
        /*
            r0 = this;
            androidx.camera.core.impl.f2 r1 = r2.b()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.C(androidx.camera.core.impl.x, androidx.camera.core.impl.f2$a):androidx.camera.core.impl.f2");
    }

    public void D() {
        z();
    }

    public void E() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract Size F(@NonNull Size size);

    public void H(@NonNull Matrix matrix) {
        this.f2135j = new Matrix(matrix);
    }

    public void I(@NonNull Rect rect) {
        this.f2134i = rect;
    }

    /* access modifiers changed from: protected */
    public void J(@NonNull SessionConfig sessionConfig) {
        this.f2137l = sessionConfig;
        for (DeferrableSurface next : sessionConfig.k()) {
            if (next.e() == null) {
                next.o(getClass());
            }
        }
    }

    public void K(@NonNull Size size) {
        this.f2132g = F(size);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return ((v0) this.f2131f).r(-1);
    }

    public Size c() {
        return this.f2132g;
    }

    public CameraInternal d() {
        CameraInternal cameraInternal;
        synchronized (this.f2127b) {
            cameraInternal = this.f2136k;
        }
        return cameraInternal;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public CameraControlInternal e() {
        synchronized (this.f2127b) {
            CameraInternal cameraInternal = this.f2136k;
            if (cameraInternal == null) {
                CameraControlInternal cameraControlInternal = CameraControlInternal.f2386a;
                return cameraControlInternal;
            }
            CameraControlInternal f10 = cameraInternal.f();
            return f10;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String f() {
        CameraInternal d10 = d();
        return ((CameraInternal) h.h(d10, "No camera attached to use case: " + this)).l().a();
    }

    @NonNull
    public f2<?> g() {
        return this.f2131f;
    }

    public abstract f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory);

    public int i() {
        return this.f2131f.l();
    }

    @NonNull
    public String j() {
        f2<?> f2Var = this.f2131f;
        String s10 = f2Var.s("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(s10);
        return s10;
    }

    /* access modifiers changed from: protected */
    public int k(@NonNull CameraInternal cameraInternal) {
        return cameraInternal.l().i(n());
    }

    @NonNull
    public Matrix l() {
        return this.f2135j;
    }

    @NonNull
    public SessionConfig m() {
        return this.f2137l;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public int n() {
        return ((v0) this.f2131f).y(0);
    }

    @NonNull
    public abstract f2.a<?, ?, ?> o(@NonNull Config config);

    public Rect p() {
        return this.f2134i;
    }

    /* access modifiers changed from: protected */
    public boolean q(@NonNull String str) {
        if (d() == null) {
            return false;
        }
        return Objects.equals(str, f());
    }

    @NonNull
    public f2<?> r(@NonNull x xVar, f2<?> f2Var, f2<?> f2Var2) {
        i1 i1Var;
        if (f2Var2 != null) {
            i1Var = i1.P(f2Var2);
            i1Var.Q(v.h.f18038w);
        } else {
            i1Var = i1.O();
        }
        for (Config.a next : this.f2130e.e()) {
            i1Var.n(next, this.f2130e.h(next), this.f2130e.a(next));
        }
        if (f2Var != null) {
            for (Config.a next2 : f2Var.e()) {
                if (!next2.c().equals(v.h.f18038w.c())) {
                    i1Var.n(next2, f2Var.h(next2), f2Var.a(next2));
                }
            }
        }
        if (i1Var.b(v0.f2692j)) {
            Config.a<Integer> aVar = v0.f2689g;
            if (i1Var.b(aVar)) {
                i1Var.Q(aVar);
            }
        }
        return C(xVar, o(i1Var));
    }

    /* access modifiers changed from: protected */
    public final void s() {
        this.f2128c = State.ACTIVE;
        v();
    }

    /* access modifiers changed from: protected */
    public final void t() {
        this.f2128c = State.INACTIVE;
        v();
    }

    /* access modifiers changed from: protected */
    public final void u() {
        for (c i10 : this.f2126a) {
            i10.i(this);
        }
    }

    public final void v() {
        int i10 = a.f2141a[this.f2128c.ordinal()];
        if (i10 == 1) {
            for (c n10 : this.f2126a) {
                n10.n(this);
            }
        } else if (i10 == 2) {
            for (c d10 : this.f2126a) {
                d10.d(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void w() {
        for (c e10 : this.f2126a) {
            e10.e(this);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void x(@NonNull CameraInternal cameraInternal, f2<?> f2Var, f2<?> f2Var2) {
        synchronized (this.f2127b) {
            this.f2136k = cameraInternal;
            a(cameraInternal);
        }
        this.f2129d = f2Var;
        this.f2133h = f2Var2;
        f2<?> r10 = r(cameraInternal.l(), this.f2129d, this.f2133h);
        this.f2131f = r10;
        b H = r10.H((b) null);
        if (H != null) {
            H.a(cameraInternal.l());
        }
        y();
    }

    public void y() {
    }

    /* access modifiers changed from: protected */
    public void z() {
    }
}

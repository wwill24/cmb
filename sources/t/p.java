package t;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.h0;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.w;
import androidx.core.util.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import t.m;
import y.a;

public class p {

    /* renamed from: g  reason: collision with root package name */
    static final a f17610g = new a();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final s0 f17611a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final d0 f17612b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final m f17613c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final g0 f17614d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final a0 f17615e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final m.a f17616f;

    public p(@NonNull s0 s0Var, @NonNull Size size) {
        androidx.camera.core.impl.utils.p.a();
        this.f17611a = s0Var;
        this.f17612b = d0.a.j(s0Var).h();
        m mVar = new m();
        this.f17613c = mVar;
        g0 g0Var = new g0();
        this.f17614d = g0Var;
        Executor Q = s0Var.Q(androidx.camera.core.impl.utils.executor.a.c());
        Objects.requireNonNull(Q);
        a0 a0Var = new a0(Q);
        this.f17615e = a0Var;
        m.a g10 = m.a.g(size, s0Var.l());
        this.f17616f = g10;
        a0Var.p(g0Var.f(mVar.i(g10)));
    }

    private j b(@NonNull c0 c0Var, @NonNull p0 p0Var, @NonNull h0 h0Var) {
        ArrayList arrayList = new ArrayList();
        String valueOf = String.valueOf(c0Var.hashCode());
        List<f0> a10 = c0Var.a();
        Objects.requireNonNull(a10);
        for (f0 f0Var : a10) {
            d0.a aVar = new d0.a();
            aVar.q(this.f17612b.g());
            aVar.e(this.f17612b.d());
            aVar.a(p0Var.m());
            aVar.f(this.f17616f.f());
            if (this.f17616f.c() == 256) {
                if (f17610g.a()) {
                    aVar.d(d0.f2485h, Integer.valueOf(p0Var.k()));
                }
                aVar.d(d0.f2486i, Integer.valueOf(g(p0Var)));
            }
            aVar.e(f0Var.a().d());
            aVar.g(valueOf, Integer.valueOf(f0Var.getId()));
            aVar.c(this.f17616f.b());
            arrayList.add(aVar.h());
        }
        return new j(arrayList, h0Var);
    }

    @NonNull
    private c0 c() {
        c0 K = this.f17611a.K(w.c());
        Objects.requireNonNull(K);
        return K;
    }

    @NonNull
    private b0 d(@NonNull c0 c0Var, @NonNull p0 p0Var, @NonNull h0 h0Var) {
        return new b0(c0Var, p0Var.j(), p0Var.f(), p0Var.k(), p0Var.h(), p0Var.l(), h0Var);
    }

    public void a() {
        androidx.camera.core.impl.utils.p.a();
        this.f17613c.g();
        this.f17614d.d();
        this.f17615e.n();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public d<j, b0> e(@NonNull p0 p0Var, @NonNull h0 h0Var) {
        androidx.camera.core.impl.utils.p.a();
        c0 c10 = c();
        return new d<>(b(c10, p0Var, h0Var), d(c10, p0Var, h0Var));
    }

    @NonNull
    public SessionConfig.b f() {
        SessionConfig.b o10 = SessionConfig.b.o(this.f17611a);
        o10.h(this.f17616f.f());
        return o10;
    }

    /* access modifiers changed from: package-private */
    public int g(@NonNull p0 p0Var) {
        boolean z10;
        if (p0Var.i() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean e10 = q.e(p0Var.f(), this.f17616f.e());
        if (!z10 || !e10) {
            return p0Var.h();
        }
        if (p0Var.e() == 0) {
            return 100;
        }
        return 95;
    }

    public int h() {
        androidx.camera.core.impl.utils.p.a();
        return this.f17613c.b();
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull b0 b0Var) {
        androidx.camera.core.impl.utils.p.a();
        this.f17616f.d().accept(b0Var);
    }

    public void j(@NonNull h0.a aVar) {
        androidx.camera.core.impl.utils.p.a();
        this.f17613c.h(aVar);
    }
}

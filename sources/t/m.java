package t;

import a0.l;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.h0;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.y0;
import androidx.camera.core.o1;
import androidx.camera.core.s2;
import androidx.camera.core.y1;
import androidx.core.util.h;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class m {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Set<Integer> f17596a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<o1> f17597b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private b0 f17598c = null;

    /* renamed from: d  reason: collision with root package name */
    s2 f17599d;

    /* renamed from: e  reason: collision with root package name */
    private b f17600e;

    /* renamed from: f  reason: collision with root package name */
    private a f17601f;

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17602a;

        /* renamed from: b  reason: collision with root package name */
        private DeferrableSurface f17603b;

        a() {
        }

        @NonNull
        static a g(Size size, int i10) {
            return new b(size, i10, new l());
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f17603b.c();
        }

        /* access modifiers changed from: package-private */
        public n b() {
            return this.f17602a;
        }

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract l<b0> d();

        /* access modifiers changed from: package-private */
        public abstract Size e();

        /* access modifiers changed from: package-private */
        @NonNull
        public DeferrableSurface f() {
            return this.f17603b;
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull n nVar) {
            this.f17602a = nVar;
        }

        /* access modifiers changed from: package-private */
        public void i(@NonNull Surface surface) {
            boolean z10;
            if (this.f17603b == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "The surface is already set.");
            this.f17603b = new y0(surface);
        }
    }

    static abstract class b {
        b() {
        }

        static b d(int i10) {
            return new c(new l(), new l(), i10);
        }

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract l<o1> b();

        /* access modifiers changed from: package-private */
        public abstract l<b0> c();
    }

    m() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(x0 x0Var) {
        o1 g10 = x0Var.g();
        Objects.requireNonNull(g10);
        e(g10);
    }

    private void d(@NonNull o1 o1Var) {
        Object c10 = o1Var.z1().c().c(this.f17598c.g());
        Objects.requireNonNull(c10);
        int intValue = ((Integer) c10).intValue();
        boolean contains = this.f17596a.contains(Integer.valueOf(intValue));
        h.j(contains, "Received an unexpected stage id" + intValue);
        this.f17596a.remove(Integer.valueOf(intValue));
        if (this.f17596a.isEmpty()) {
            this.f17598c.l();
            this.f17598c = null;
        }
        this.f17600e.b().accept(o1Var);
    }

    public int b() {
        boolean z10;
        p.a();
        if (this.f17599d != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "The ImageReader is not initialized.");
        return this.f17599d.i();
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull o1 o1Var) {
        p.a();
        if (this.f17598c == null) {
            this.f17597b.add(o1Var);
        } else {
            d(o1Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull b0 b0Var) {
        boolean z10;
        p.a();
        boolean z11 = true;
        if (b() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "Too many acquire images. Close image to be able to process next.");
        if (this.f17598c != null && !this.f17596a.isEmpty()) {
            z11 = false;
        }
        h.j(z11, "The previous request is not complete");
        this.f17598c = b0Var;
        this.f17596a.addAll(b0Var.f());
        this.f17600e.c().accept(b0Var);
        for (o1 d10 : this.f17597b) {
            d(d10);
        }
        this.f17597b.clear();
    }

    public void g() {
        p.a();
        s2 s2Var = this.f17599d;
        if (s2Var != null) {
            s2Var.l();
        }
        a aVar = this.f17601f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void h(h0.a aVar) {
        boolean z10;
        p.a();
        if (this.f17599d != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "The ImageReader is not initialized.");
        this.f17599d.m(aVar);
    }

    @NonNull
    public b i(@NonNull a aVar) {
        this.f17601f = aVar;
        Size e10 = aVar.e();
        y1 y1Var = new y1(e10.getWidth(), e10.getHeight(), aVar.c(), 4);
        this.f17599d = new s2(y1Var);
        aVar.h(y1Var.m());
        Surface surface = y1Var.getSurface();
        Objects.requireNonNull(surface);
        Surface surface2 = surface;
        aVar.i(surface);
        y1Var.f(new k(this), androidx.camera.core.impl.utils.executor.a.d());
        aVar.d().a(new l(this));
        b d10 = b.d(aVar.c());
        this.f17600e = d10;
        return d10;
    }
}

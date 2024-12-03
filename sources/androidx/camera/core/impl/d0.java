package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d0 {

    /* renamed from: h  reason: collision with root package name */
    public static final Config.a<Integer> f2485h = Config.a.a("camerax.core.captureConfig.rotation", Integer.TYPE);

    /* renamed from: i  reason: collision with root package name */
    public static final Config.a<Integer> f2486i = Config.a.a("camerax.core.captureConfig.jpegQuality", Integer.class);

    /* renamed from: a  reason: collision with root package name */
    final List<DeferrableSurface> f2487a;

    /* renamed from: b  reason: collision with root package name */
    final Config f2488b;

    /* renamed from: c  reason: collision with root package name */
    final int f2489c;

    /* renamed from: d  reason: collision with root package name */
    final List<n> f2490d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2491e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final a2 f2492f;

    /* renamed from: g  reason: collision with root package name */
    private final p f2493g;

    public interface b {
        void a(@NonNull f2<?> f2Var, @NonNull a aVar);
    }

    d0(List<DeferrableSurface> list, Config config, int i10, List<n> list2, boolean z10, @NonNull a2 a2Var, p pVar) {
        this.f2487a = list;
        this.f2488b = config;
        this.f2489c = i10;
        this.f2490d = Collections.unmodifiableList(list2);
        this.f2491e = z10;
        this.f2492f = a2Var;
        this.f2493g = pVar;
    }

    @NonNull
    public static d0 a() {
        return new a().h();
    }

    @NonNull
    public List<n> b() {
        return this.f2490d;
    }

    public p c() {
        return this.f2493g;
    }

    @NonNull
    public Config d() {
        return this.f2488b;
    }

    @NonNull
    public List<DeferrableSurface> e() {
        return Collections.unmodifiableList(this.f2487a);
    }

    @NonNull
    public a2 f() {
        return this.f2492f;
    }

    public int g() {
        return this.f2489c;
    }

    public boolean h() {
        return this.f2491e;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<DeferrableSurface> f2494a;

        /* renamed from: b  reason: collision with root package name */
        private h1 f2495b;

        /* renamed from: c  reason: collision with root package name */
        private int f2496c;

        /* renamed from: d  reason: collision with root package name */
        private List<n> f2497d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2498e;

        /* renamed from: f  reason: collision with root package name */
        private k1 f2499f;

        /* renamed from: g  reason: collision with root package name */
        private p f2500g;

        public a() {
            this.f2494a = new HashSet();
            this.f2495b = i1.O();
            this.f2496c = -1;
            this.f2497d = new ArrayList();
            this.f2498e = false;
            this.f2499f = k1.f();
        }

        @NonNull
        public static a j(@NonNull f2<?> f2Var) {
            b o10 = f2Var.o((b) null);
            if (o10 != null) {
                a aVar = new a();
                o10.a(f2Var, aVar);
                return aVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + f2Var.s(f2Var.toString()));
        }

        @NonNull
        public static a k(@NonNull d0 d0Var) {
            return new a(d0Var);
        }

        public void a(@NonNull Collection<n> collection) {
            for (n c10 : collection) {
                c(c10);
            }
        }

        public void b(@NonNull a2 a2Var) {
            this.f2499f.e(a2Var);
        }

        public void c(@NonNull n nVar) {
            if (!this.f2497d.contains(nVar)) {
                this.f2497d.add(nVar);
            }
        }

        public <T> void d(@NonNull Config.a<T> aVar, @NonNull T t10) {
            this.f2495b.p(aVar, t10);
        }

        public void e(@NonNull Config config) {
            for (Config.a next : config.e()) {
                Object g10 = this.f2495b.g(next, null);
                Object a10 = config.a(next);
                if (g10 instanceof g1) {
                    ((g1) g10).a(((g1) a10).c());
                } else {
                    if (a10 instanceof g1) {
                        a10 = ((g1) a10).clone();
                    }
                    this.f2495b.n(next, config.h(next), a10);
                }
            }
        }

        public void f(@NonNull DeferrableSurface deferrableSurface) {
            this.f2494a.add(deferrableSurface);
        }

        public void g(@NonNull String str, @NonNull Object obj) {
            this.f2499f.h(str, obj);
        }

        @NonNull
        public d0 h() {
            return new d0(new ArrayList(this.f2494a), n1.M(this.f2495b), this.f2496c, this.f2497d, this.f2498e, a2.b(this.f2499f), this.f2500g);
        }

        public void i() {
            this.f2494a.clear();
        }

        @NonNull
        public Set<DeferrableSurface> l() {
            return this.f2494a;
        }

        public int m() {
            return this.f2496c;
        }

        public boolean n(@NonNull n nVar) {
            return this.f2497d.remove(nVar);
        }

        public void o(@NonNull p pVar) {
            this.f2500g = pVar;
        }

        public void p(@NonNull Config config) {
            this.f2495b = i1.P(config);
        }

        public void q(int i10) {
            this.f2496c = i10;
        }

        public void r(boolean z10) {
            this.f2498e = z10;
        }

        private a(d0 d0Var) {
            HashSet hashSet = new HashSet();
            this.f2494a = hashSet;
            this.f2495b = i1.O();
            this.f2496c = -1;
            this.f2497d = new ArrayList();
            this.f2498e = false;
            this.f2499f = k1.f();
            hashSet.addAll(d0Var.f2487a);
            this.f2495b = i1.P(d0Var.f2488b);
            this.f2496c = d0Var.f2489c;
            this.f2497d.addAll(d0Var.b());
            this.f2498e = d0Var.h();
            this.f2499f = k1.g(d0Var.f());
        }
    }
}

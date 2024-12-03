package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.x0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class j2 implements x0 {

    /* renamed from: a  reason: collision with root package name */
    final Object f2748a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private x0.a f2749b = new a();

    /* renamed from: c  reason: collision with root package name */
    private x0.a f2750c = new b();

    /* renamed from: d  reason: collision with root package name */
    private u.c<List<o1>> f2751d = new c();

    /* renamed from: e  reason: collision with root package name */
    boolean f2752e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f2753f = false;

    /* renamed from: g  reason: collision with root package name */
    final x0 f2754g;

    /* renamed from: h  reason: collision with root package name */
    final x0 f2755h;

    /* renamed from: i  reason: collision with root package name */
    x0.a f2756i;

    /* renamed from: j  reason: collision with root package name */
    Executor f2757j;

    /* renamed from: k  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f2758k;

    /* renamed from: l  reason: collision with root package name */
    private zf.a<Void> f2759l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    final Executor f2760m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    final e0 f2761n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    private final zf.a<Void> f2762o;

    /* renamed from: p  reason: collision with root package name */
    private String f2763p = new String();
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    u2 f2764q = new u2(Collections.emptyList(), this.f2763p);

    /* renamed from: r  reason: collision with root package name */
    private final List<Integer> f2765r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private zf.a<List<o1>> f2766s = u.f.h(new ArrayList());

    /* renamed from: t  reason: collision with root package name */
    f f2767t;

    /* renamed from: u  reason: collision with root package name */
    Executor f2768u;

    class a implements x0.a {
        a() {
        }

        public void a(@NonNull x0 x0Var) {
            j2.this.o(x0Var);
        }
    }

    class b implements x0.a {
        b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(x0.a aVar) {
            aVar.a(j2.this);
        }

        public void a(@NonNull x0 x0Var) {
            x0.a aVar;
            Executor executor;
            synchronized (j2.this.f2748a) {
                j2 j2Var = j2.this;
                aVar = j2Var.f2756i;
                executor = j2Var.f2757j;
                j2Var.f2764q.e();
                j2.this.u();
            }
            if (aVar == null) {
                return;
            }
            if (executor != null) {
                executor.execute(new k2(this, aVar));
            } else {
                aVar.a(j2.this);
            }
        }
    }

    class c implements u.c<List<o1>> {
        c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r0.f2761n.d(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
            monitor-enter(r4.f2771a.f2748a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r4.f2771a.f2764q.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            r3.execute(new androidx.camera.core.l2(r2, r5));
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(java.util.List<androidx.camera.core.o1> r5) {
            /*
                r4 = this;
                androidx.camera.core.j2 r5 = androidx.camera.core.j2.this
                java.lang.Object r5 = r5.f2748a
                monitor-enter(r5)
                androidx.camera.core.j2 r0 = androidx.camera.core.j2.this     // Catch:{ all -> 0x004c }
                boolean r1 = r0.f2752e     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x000d
                monitor-exit(r5)     // Catch:{ all -> 0x004c }
                return
            L_0x000d:
                r1 = 1
                r0.f2753f = r1     // Catch:{ all -> 0x004c }
                androidx.camera.core.u2 r1 = r0.f2764q     // Catch:{ all -> 0x004c }
                androidx.camera.core.j2$f r2 = r0.f2767t     // Catch:{ all -> 0x004c }
                java.util.concurrent.Executor r3 = r0.f2768u     // Catch:{ all -> 0x004c }
                monitor-exit(r5)     // Catch:{ all -> 0x004c }
                androidx.camera.core.impl.e0 r5 = r0.f2761n     // Catch:{ Exception -> 0x001d }
                r5.d(r1)     // Catch:{ Exception -> 0x001d }
                goto L_0x0037
            L_0x001d:
                r5 = move-exception
                androidx.camera.core.j2 r0 = androidx.camera.core.j2.this
                java.lang.Object r0 = r0.f2748a
                monitor-enter(r0)
                androidx.camera.core.j2 r1 = androidx.camera.core.j2.this     // Catch:{ all -> 0x0049 }
                androidx.camera.core.u2 r1 = r1.f2764q     // Catch:{ all -> 0x0049 }
                r1.e()     // Catch:{ all -> 0x0049 }
                if (r2 == 0) goto L_0x0036
                if (r3 == 0) goto L_0x0036
                androidx.camera.core.l2 r1 = new androidx.camera.core.l2     // Catch:{ all -> 0x0049 }
                r1.<init>(r2, r5)     // Catch:{ all -> 0x0049 }
                r3.execute(r1)     // Catch:{ all -> 0x0049 }
            L_0x0036:
                monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            L_0x0037:
                androidx.camera.core.j2 r5 = androidx.camera.core.j2.this
                java.lang.Object r5 = r5.f2748a
                monitor-enter(r5)
                androidx.camera.core.j2 r0 = androidx.camera.core.j2.this     // Catch:{ all -> 0x0046 }
                r1 = 0
                r0.f2753f = r1     // Catch:{ all -> 0x0046 }
                monitor-exit(r5)     // Catch:{ all -> 0x0046 }
                r0.k()
                return
            L_0x0046:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0046 }
                throw r0
            L_0x0049:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0049 }
                throw r5
            L_0x004c:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x004c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.j2.c.onSuccess(java.util.List):void");
        }

        public void onFailure(@NonNull Throwable th2) {
        }
    }

    class d extends n {
        d() {
        }
    }

    interface f {
        void a(String str, Throwable th2);
    }

    j2(@NonNull e eVar) {
        if (eVar.f2773a.e() >= eVar.f2774b.a().size()) {
            x0 x0Var = eVar.f2773a;
            this.f2754g = x0Var;
            int width = x0Var.getWidth();
            int height = x0Var.getHeight();
            int i10 = eVar.f2776d;
            if (i10 == 256) {
                width = ((int) (((float) (width * height)) * 1.5f)) + 64000;
                height = 1;
            }
            d dVar = new d(ImageReader.newInstance(width, height, i10, x0Var.e()));
            this.f2755h = dVar;
            this.f2760m = eVar.f2777e;
            e0 e0Var = eVar.f2775c;
            this.f2761n = e0Var;
            e0Var.a(dVar.getSurface(), eVar.f2776d);
            e0Var.c(new Size(x0Var.getWidth(), x0Var.getHeight()));
            this.f2762o = e0Var.b();
            s(eVar.f2774b);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }

    private void j() {
        synchronized (this.f2748a) {
            if (!this.f2766s.isDone()) {
                this.f2766s.cancel(true);
            }
            this.f2764q.e();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(CallbackToFutureAdapter.a aVar) {
        j();
        if (aVar != null) {
            aVar.c(null);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void q(Void voidR) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f2748a) {
            this.f2758k = aVar;
        }
        return "ProcessingImageReader-close";
    }

    public o1 b() {
        o1 b10;
        synchronized (this.f2748a) {
            b10 = this.f2755h.b();
        }
        return b10;
    }

    public int c() {
        int c10;
        synchronized (this.f2748a) {
            c10 = this.f2755h.c();
        }
        return c10;
    }

    public void close() {
        synchronized (this.f2748a) {
            if (!this.f2752e) {
                this.f2754g.d();
                this.f2755h.d();
                this.f2752e = true;
                this.f2761n.close();
                k();
            }
        }
    }

    public void d() {
        synchronized (this.f2748a) {
            this.f2756i = null;
            this.f2757j = null;
            this.f2754g.d();
            this.f2755h.d();
            if (!this.f2753f) {
                this.f2764q.d();
            }
        }
    }

    public int e() {
        int e10;
        synchronized (this.f2748a) {
            e10 = this.f2754g.e();
        }
        return e10;
    }

    public void f(@NonNull x0.a aVar, @NonNull Executor executor) {
        synchronized (this.f2748a) {
            this.f2756i = (x0.a) h.g(aVar);
            this.f2757j = (Executor) h.g(executor);
            this.f2754g.f(this.f2749b, executor);
            this.f2755h.f(this.f2750c, executor);
        }
    }

    public o1 g() {
        o1 g10;
        synchronized (this.f2748a) {
            g10 = this.f2755h.g();
        }
        return g10;
    }

    public int getHeight() {
        int height;
        synchronized (this.f2748a) {
            height = this.f2754g.getHeight();
        }
        return height;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.f2748a) {
            surface = this.f2754g.getSurface();
        }
        return surface;
    }

    public int getWidth() {
        int width;
        synchronized (this.f2748a) {
            width = this.f2754g.getWidth();
        }
        return width;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        boolean z10;
        boolean z11;
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f2748a) {
            z10 = this.f2752e;
            z11 = this.f2753f;
            aVar = this.f2758k;
            if (z10 && !z11) {
                this.f2754g.close();
                this.f2764q.d();
                this.f2755h.close();
            }
        }
        if (z10 && !z11) {
            this.f2762o.addListener(new i2(this, aVar), androidx.camera.core.impl.utils.executor.a.a());
        }
    }

    /* access modifiers changed from: package-private */
    public n l() {
        synchronized (this.f2748a) {
            x0 x0Var = this.f2754g;
            if (x0Var instanceof y1) {
                n m10 = ((y1) x0Var).m();
                return m10;
            }
            d dVar = new d();
            return dVar;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<Void> m() {
        zf.a<Void> aVar;
        synchronized (this.f2748a) {
            if (!this.f2752e || this.f2753f) {
                if (this.f2759l == null) {
                    this.f2759l = CallbackToFutureAdapter.a(new h2(this));
                }
                aVar = u.f.j(this.f2759l);
            } else {
                aVar = u.f.o(this.f2762o, new g2(), androidx.camera.core.impl.utils.executor.a.a());
            }
        }
        return aVar;
    }

    @NonNull
    public String n() {
        return this.f2763p;
    }

    /* access modifiers changed from: package-private */
    public void o(x0 x0Var) {
        synchronized (this.f2748a) {
            if (!this.f2752e) {
                try {
                    o1 g10 = x0Var.g();
                    if (g10 != null) {
                        Integer num = (Integer) g10.z1().c().c(this.f2763p);
                        if (!this.f2765r.contains(num)) {
                            v1.l("ProcessingImageReader", "ImageProxyBundle does not contain this id: " + num);
                            g10.close();
                        } else {
                            this.f2764q.c(g10);
                        }
                    }
                } catch (IllegalStateException e10) {
                    v1.d("ProcessingImageReader", "Failed to acquire latest image.", e10);
                }
                return;
            }
            return;
        }
    }

    public void s(@NonNull c0 c0Var) {
        synchronized (this.f2748a) {
            if (!this.f2752e) {
                j();
                if (c0Var.a() != null) {
                    if (this.f2754g.e() >= c0Var.a().size()) {
                        this.f2765r.clear();
                        for (f0 next : c0Var.a()) {
                            if (next != null) {
                                this.f2765r.add(Integer.valueOf(next.getId()));
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                    }
                }
                String num = Integer.toString(c0Var.hashCode());
                this.f2763p = num;
                this.f2764q = new u2(this.f2765r, num);
                u();
            }
        }
    }

    public void t(@NonNull Executor executor, @NonNull f fVar) {
        synchronized (this.f2748a) {
            this.f2768u = executor;
            this.f2767t = fVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.f2765r) {
            arrayList.add(this.f2764q.b(intValue.intValue()));
        }
        this.f2766s = u.f.c(arrayList);
        u.f.b(u.f.c(arrayList), this.f2751d, this.f2760m);
    }

    static final class e {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        protected final x0 f2773a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        protected final c0 f2774b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        protected final e0 f2775c;

        /* renamed from: d  reason: collision with root package name */
        protected int f2776d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        protected Executor f2777e;

        e(@NonNull x0 x0Var, @NonNull c0 c0Var, @NonNull e0 e0Var) {
            this.f2777e = Executors.newSingleThreadExecutor();
            this.f2773a = x0Var;
            this.f2774b = c0Var;
            this.f2775c = e0Var;
            this.f2776d = x0Var.c();
        }

        /* access modifiers changed from: package-private */
        public j2 a() {
            return new j2(this);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public e b(int i10) {
            this.f2776d = i10;
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public e c(@NonNull Executor executor) {
            this.f2777e = executor;
            return this;
        }

        e(int i10, int i11, int i12, int i13, @NonNull c0 c0Var, @NonNull e0 e0Var) {
            this(new y1(i10, i11, i12, i13), c0Var, e0Var);
        }
    }
}

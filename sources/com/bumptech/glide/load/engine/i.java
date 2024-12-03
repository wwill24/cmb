package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.m;
import f4.j;
import g4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class i<R> implements DecodeJob.b<R>, a.f {
    private static final c F = new c();
    private boolean B;
    m<?> C;
    private DecodeJob<R> D;
    private volatile boolean E;

    /* renamed from: a  reason: collision with root package name */
    final e f9365a;

    /* renamed from: b  reason: collision with root package name */
    private final g4.c f9366b;

    /* renamed from: c  reason: collision with root package name */
    private final m.a f9367c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.core.util.e<i<?>> f9368d;

    /* renamed from: e  reason: collision with root package name */
    private final c f9369e;

    /* renamed from: f  reason: collision with root package name */
    private final j f9370f;

    /* renamed from: g  reason: collision with root package name */
    private final o3.a f9371g;

    /* renamed from: h  reason: collision with root package name */
    private final o3.a f9372h;

    /* renamed from: j  reason: collision with root package name */
    private final o3.a f9373j;

    /* renamed from: k  reason: collision with root package name */
    private final o3.a f9374k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicInteger f9375l;

    /* renamed from: m  reason: collision with root package name */
    private i3.b f9376m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9377n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9378p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9379q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9380t;

    /* renamed from: w  reason: collision with root package name */
    private l3.c<?> f9381w;

    /* renamed from: x  reason: collision with root package name */
    DataSource f9382x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f9383y;

    /* renamed from: z  reason: collision with root package name */
    GlideException f9384z;

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final b4.d f9385a;

        a(b4.d dVar) {
            this.f9385a = dVar;
        }

        public void run() {
            synchronized (this.f9385a.g()) {
                synchronized (i.this) {
                    if (i.this.f9365a.d(this.f9385a)) {
                        i.this.f(this.f9385a);
                    }
                    i.this.i();
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final b4.d f9387a;

        b(b4.d dVar) {
            this.f9387a = dVar;
        }

        public void run() {
            synchronized (this.f9387a.g()) {
                synchronized (i.this) {
                    if (i.this.f9365a.d(this.f9387a)) {
                        i.this.C.c();
                        i.this.g(this.f9387a);
                        i.this.r(this.f9387a);
                    }
                    i.this.i();
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> m<R> a(l3.c<R> cVar, boolean z10, i3.b bVar, m.a aVar) {
            return new m(cVar, z10, true, bVar, aVar);
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        final b4.d f9389a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f9390b;

        d(b4.d dVar, Executor executor) {
            this.f9389a = dVar;
            this.f9390b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f9389a.equals(((d) obj).f9389a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9389a.hashCode();
        }
    }

    static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f9391a;

        e() {
            this(new ArrayList(2));
        }

        private static d g(b4.d dVar) {
            return new d(dVar, f4.e.a());
        }

        /* access modifiers changed from: package-private */
        public void b(b4.d dVar, Executor executor) {
            this.f9391a.add(new d(dVar, executor));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.f9391a.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean d(b4.d dVar) {
            return this.f9391a.contains(g(dVar));
        }

        /* access modifiers changed from: package-private */
        public e f() {
            return new e(new ArrayList(this.f9391a));
        }

        /* access modifiers changed from: package-private */
        public void i(b4.d dVar) {
            this.f9391a.remove(g(dVar));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.f9391a.isEmpty();
        }

        @NonNull
        public Iterator<d> iterator() {
            return this.f9391a.iterator();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.f9391a.size();
        }

        e(List<d> list) {
            this.f9391a = list;
        }
    }

    i(o3.a aVar, o3.a aVar2, o3.a aVar3, o3.a aVar4, j jVar, m.a aVar5, androidx.core.util.e<i<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, jVar, aVar5, eVar, F);
    }

    private o3.a j() {
        if (this.f9378p) {
            return this.f9373j;
        }
        if (this.f9379q) {
            return this.f9374k;
        }
        return this.f9372h;
    }

    private boolean m() {
        return this.B || this.f9383y || this.E;
    }

    private synchronized void q() {
        if (this.f9376m != null) {
            this.f9365a.clear();
            this.f9376m = null;
            this.C = null;
            this.f9381w = null;
            this.B = false;
            this.E = false;
            this.f9383y = false;
            this.D.A(false);
            this.D = null;
            this.f9384z = null;
            this.f9382x = null;
            this.f9368d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    public void b(GlideException glideException) {
        synchronized (this) {
            this.f9384z = glideException;
        }
        n();
    }

    public void c(l3.c<R> cVar, DataSource dataSource) {
        synchronized (this) {
            this.f9381w = cVar;
            this.f9382x = dataSource;
        }
        o();
    }

    @NonNull
    public g4.c d() {
        return this.f9366b;
    }

    /* access modifiers changed from: package-private */
    public synchronized void e(b4.d dVar, Executor executor) {
        this.f9366b.c();
        this.f9365a.b(dVar, executor);
        boolean z10 = true;
        if (this.f9383y) {
            k(1);
            executor.execute(new b(dVar));
        } else if (this.B) {
            k(1);
            executor.execute(new a(dVar));
        } else {
            if (this.E) {
                z10 = false;
            }
            j.a(z10, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(b4.d dVar) {
        try {
            dVar.b(this.f9384z);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(b4.d dVar) {
        try {
            dVar.c(this.C, this.f9382x);
        } catch (Throwable th2) {
            throw new CallbackException(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (!m()) {
            this.E = true;
            this.D.e();
            this.f9370f.c(this, this.f9376m);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        boolean z10;
        m<?> mVar;
        synchronized (this) {
            this.f9366b.c();
            j.a(m(), "Not yet complete!");
            int decrementAndGet = this.f9375l.decrementAndGet();
            if (decrementAndGet >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            j.a(z10, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                mVar = this.C;
                q();
            } else {
                mVar = null;
            }
        }
        if (mVar != null) {
            mVar.f();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(int i10) {
        m<?> mVar;
        j.a(m(), "Not yet complete!");
        if (this.f9375l.getAndAdd(i10) == 0 && (mVar = this.C) != null) {
            mVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i<R> l(i3.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f9376m = bVar;
        this.f9377n = z10;
        this.f9378p = z11;
        this.f9379q = z12;
        this.f9380t = z13;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f9370f.b(r4, r1, (com.bumptech.glide.load.engine.m<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f9390b.execute(new com.bumptech.glide.load.engine.i.a(r4, r1.f9389a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r4 = this;
            monitor-enter(r4)
            g4.c r0 = r4.f9366b     // Catch:{ all -> 0x0066 }
            r0.c()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.E     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.q()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.i$e r0 = r4.f9365a     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.B     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.B = r0     // Catch:{ all -> 0x0066 }
            i3.b r1 = r4.f9376m     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.i$e r2 = r4.f9365a     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.i$e r2 = r2.f()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.k(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.j r0 = r4.f9370f
            r3 = 0
            r0.b(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.i$d r1 = (com.bumptech.glide.load.engine.i.d) r1
            java.util.concurrent.Executor r2 = r1.f9390b
            com.bumptech.glide.load.engine.i$a r3 = new com.bumptech.glide.load.engine.i$a
            b4.d r1 = r1.f9389a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.i()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.i.n():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f9370f.b(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f9390b.execute(new com.bumptech.glide.load.engine.i.b(r5, r1.f9389a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r5 = this;
            monitor-enter(r5)
            g4.c r0 = r5.f9366b     // Catch:{ all -> 0x007c }
            r0.c()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.E     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            l3.c<?> r0 = r5.f9381w     // Catch:{ all -> 0x007c }
            r0.a()     // Catch:{ all -> 0x007c }
            r5.q()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.i$e r0 = r5.f9365a     // Catch:{ all -> 0x007c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.f9383y     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            com.bumptech.glide.load.engine.i$c r0 = r5.f9369e     // Catch:{ all -> 0x007c }
            l3.c<?> r1 = r5.f9381w     // Catch:{ all -> 0x007c }
            boolean r2 = r5.f9377n     // Catch:{ all -> 0x007c }
            i3.b r3 = r5.f9376m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m$a r4 = r5.f9367c     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.C = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.f9383y = r0     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.i$e r1 = r5.f9365a     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.i$e r1 = r1.f()     // Catch:{ all -> 0x007c }
            int r2 = r1.size()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.k(r2)     // Catch:{ all -> 0x007c }
            i3.b r0 = r5.f9376m     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.m<?> r2 = r5.C     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.j r3 = r5.f9370f
            r3.b(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.i$d r1 = (com.bumptech.glide.load.engine.i.d) r1
            java.util.concurrent.Executor r2 = r1.f9390b
            com.bumptech.glide.load.engine.i$b r3 = new com.bumptech.glide.load.engine.i$b
            b4.d r1 = r1.f9389a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.i()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.i.o():void");
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f9380t;
    }

    /* access modifiers changed from: package-private */
    public synchronized void r(b4.d dVar) {
        boolean z10;
        this.f9366b.c();
        this.f9365a.i(dVar);
        if (this.f9365a.isEmpty()) {
            h();
            if (!this.f9383y) {
                if (!this.B) {
                    z10 = false;
                    if (z10 && this.f9375l.get() == 0) {
                        q();
                    }
                }
            }
            z10 = true;
            q();
        }
    }

    public synchronized void s(DecodeJob<R> decodeJob) {
        o3.a aVar;
        this.D = decodeJob;
        if (decodeJob.I()) {
            aVar = this.f9371g;
        } else {
            aVar = j();
        }
        aVar.execute(decodeJob);
    }

    i(o3.a aVar, o3.a aVar2, o3.a aVar3, o3.a aVar4, j jVar, m.a aVar5, androidx.core.util.e<i<?>> eVar, c cVar) {
        this.f9365a = new e();
        this.f9366b = g4.c.a();
        this.f9375l = new AtomicInteger();
        this.f9371g = aVar;
        this.f9372h = aVar2;
        this.f9373j = aVar3;
        this.f9374k = aVar4;
        this.f9370f = jVar;
        this.f9367c = aVar5;
        this.f9368d = eVar;
        this.f9369e = cVar;
    }
}

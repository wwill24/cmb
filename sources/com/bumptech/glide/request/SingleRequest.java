package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import b4.a;
import b4.b;
import b4.d;
import c4.g;
import c4.h;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.h;
import f4.f;
import f4.k;
import g4.c;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements a, g, d {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    private final String f9509a;

    /* renamed from: b  reason: collision with root package name */
    private final c f9510b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f9511c;

    /* renamed from: d  reason: collision with root package name */
    private final b<R> f9512d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f9513e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f9514f;

    /* renamed from: g  reason: collision with root package name */
    private final e f9515g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f9516h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f9517i;

    /* renamed from: j  reason: collision with root package name */
    private final a<?> f9518j;

    /* renamed from: k  reason: collision with root package name */
    private final int f9519k;

    /* renamed from: l  reason: collision with root package name */
    private final int f9520l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f9521m;

    /* renamed from: n  reason: collision with root package name */
    private final h<R> f9522n;

    /* renamed from: o  reason: collision with root package name */
    private final List<b<R>> f9523o;

    /* renamed from: p  reason: collision with root package name */
    private final d4.g<? super R> f9524p;

    /* renamed from: q  reason: collision with root package name */
    private final Executor f9525q;

    /* renamed from: r  reason: collision with root package name */
    private l3.c<R> f9526r;

    /* renamed from: s  reason: collision with root package name */
    private h.d f9527s;

    /* renamed from: t  reason: collision with root package name */
    private long f9528t;

    /* renamed from: u  reason: collision with root package name */
    private volatile com.bumptech.glide.load.engine.h f9529u;

    /* renamed from: v  reason: collision with root package name */
    private Status f9530v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f9531w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f9532x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f9533y;

    /* renamed from: z  reason: collision with root package name */
    private int f9534z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, e eVar, @NonNull Object obj, Object obj2, Class<R> cls, a<?> aVar, int i10, int i11, Priority priority, c4.h<R> hVar, b<R> bVar, List<b<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.h hVar2, d4.g<? super R> gVar, Executor executor) {
        String str;
        if (D) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.f9509a = str;
        this.f9510b = c.a();
        this.f9511c = obj;
        this.f9514f = context;
        this.f9515g = eVar;
        this.f9516h = obj2;
        this.f9517i = cls;
        this.f9518j = aVar;
        this.f9519k = i10;
        this.f9520l = i11;
        this.f9521m = priority;
        this.f9522n = hVar;
        this.f9512d = bVar;
        this.f9523o = list;
        this.f9513e = requestCoordinator;
        this.f9529u = hVar2;
        this.f9524p = gVar;
        this.f9525q = executor;
        this.f9530v = Status.PENDING;
        if (this.C == null && eVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void A() {
        if (l()) {
            Drawable drawable = null;
            if (this.f9516h == null) {
                drawable = p();
            }
            if (drawable == null) {
                drawable = o();
            }
            if (drawable == null) {
                drawable = q();
            }
            this.f9522n.l(drawable);
        }
    }

    private void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f9513e;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f9513e;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f9513e;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private void n() {
        i();
        this.f9510b.c();
        this.f9522n.j(this);
        h.d dVar = this.f9527s;
        if (dVar != null) {
            dVar.a();
            this.f9527s = null;
        }
    }

    private Drawable o() {
        if (this.f9531w == null) {
            Drawable o10 = this.f9518j.o();
            this.f9531w = o10;
            if (o10 == null && this.f9518j.l() > 0) {
                this.f9531w = s(this.f9518j.l());
            }
        }
        return this.f9531w;
    }

    private Drawable p() {
        if (this.f9533y == null) {
            Drawable p10 = this.f9518j.p();
            this.f9533y = p10;
            if (p10 == null && this.f9518j.q() > 0) {
                this.f9533y = s(this.f9518j.q());
            }
        }
        return this.f9533y;
    }

    private Drawable q() {
        if (this.f9532x == null) {
            Drawable v10 = this.f9518j.v();
            this.f9532x = v10;
            if (v10 == null && this.f9518j.w() > 0) {
                this.f9532x = s(this.f9518j.w());
            }
        }
        return this.f9532x;
    }

    private boolean r() {
        RequestCoordinator requestCoordinator = this.f9513e;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    private Drawable s(int i10) {
        Resources.Theme theme;
        if (this.f9518j.B() != null) {
            theme = this.f9518j.B();
        } else {
            theme = this.f9514f.getTheme();
        }
        return u3.a.a(this.f9515g, i10, theme);
    }

    private void t(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" this: ");
        sb2.append(this.f9509a);
    }

    private static int u(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * ((float) i10));
    }

    private void v() {
        RequestCoordinator requestCoordinator = this.f9513e;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    private void w() {
        RequestCoordinator requestCoordinator = this.f9513e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public static <R> SingleRequest<R> x(Context context, e eVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i10, int i11, Priority priority, c4.h<R> hVar, b<R> bVar, List<b<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.h hVar2, d4.g<? super R> gVar, Executor executor) {
        return new SingleRequest(context, eVar, obj, obj2, cls, aVar, i10, i11, priority, hVar, bVar, list, requestCoordinator, hVar2, gVar, executor);
    }

    /* JADX INFO: finally extract failed */
    private void y(GlideException glideException, int i10) {
        boolean z10;
        this.f9510b.c();
        synchronized (this.f9511c) {
            glideException.k(this.C);
            int g10 = this.f9515g.g();
            if (g10 <= i10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Load failed for ");
                sb2.append(this.f9516h);
                sb2.append(" with size [");
                sb2.append(this.f9534z);
                sb2.append("x");
                sb2.append(this.A);
                sb2.append("]");
                if (g10 <= 4) {
                    glideException.g("Glide");
                }
            }
            this.f9527s = null;
            this.f9530v = Status.FAILED;
            boolean z11 = true;
            this.B = true;
            try {
                List<b<R>> list = this.f9523o;
                if (list != null) {
                    z10 = false;
                    for (b<R> a10 : list) {
                        z10 |= a10.a(glideException, this.f9516h, this.f9522n, r());
                    }
                } else {
                    z10 = false;
                }
                b<R> bVar = this.f9512d;
                if (bVar == null || !bVar.a(glideException, this.f9516h, this.f9522n, r())) {
                    z11 = false;
                }
                if (!z10 && !z11) {
                    A();
                }
                this.B = false;
                v();
            } catch (Throwable th2) {
                this.B = false;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e A[Catch:{ all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z(l3.c<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.r()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.f9530v = r0
            r10.f9526r = r11
            com.bumptech.glide.e r11 = r10.f9515g
            int r11 = r11.g()
            r0 = 3
            if (r11 > r0) goto L_0x0061
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f9516h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.f9534z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.f9528t
            double r0 = f4.f.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
        L_0x0061:
            r11 = 1
            r10.B = r11
            r7 = 0
            java.util.List<b4.b<R>> r0 = r10.f9523o     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0087
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00af }
            r9 = r7
        L_0x006e:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00af }
            b4.b r0 = (b4.b) r0     // Catch:{ all -> 0x00af }
            java.lang.Object r2 = r10.f9516h     // Catch:{ all -> 0x00af }
            c4.h<R> r3 = r10.f9522n     // Catch:{ all -> 0x00af }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.b(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00af }
            r9 = r9 | r0
            goto L_0x006e
        L_0x0087:
            r9 = r7
        L_0x0088:
            b4.b<R> r0 = r10.f9512d     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x009a
            java.lang.Object r2 = r10.f9516h     // Catch:{ all -> 0x00af }
            c4.h<R> r3 = r10.f9522n     // Catch:{ all -> 0x00af }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.b(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r11 = r7
        L_0x009b:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00a9
            d4.g<? super R> r11 = r10.f9524p     // Catch:{ all -> 0x00af }
            d4.f r11 = r11.a(r13, r6)     // Catch:{ all -> 0x00af }
            c4.h<R> r13 = r10.f9522n     // Catch:{ all -> 0x00af }
            r13.f(r12, r11)     // Catch:{ all -> 0x00af }
        L_0x00a9:
            r10.B = r7
            r10.w()
            return
        L_0x00af:
            r11 = move-exception
            r10.B = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.z(l3.c, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f9511c) {
            if (this.f9530v == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void b(GlideException glideException) {
        y(glideException, 5);
    }

    public void c(l3.c<?> cVar, DataSource dataSource) {
        Object obj;
        String str;
        this.f9510b.c();
        l3.c<?> cVar2 = null;
        try {
            synchronized (this.f9511c) {
                try {
                    this.f9527s = null;
                    if (cVar == null) {
                        b(new GlideException("Expected to receive a Resource<R> with an object of " + this.f9517i + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = cVar.get();
                    if (obj2 != null) {
                        if (this.f9517i.isAssignableFrom(obj2.getClass())) {
                            if (!m()) {
                                try {
                                    this.f9526r = null;
                                    this.f9530v = Status.COMPLETE;
                                    this.f9529u.k(cVar);
                                    return;
                                } catch (Throwable th2) {
                                    cVar2 = cVar;
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                z(cVar, obj2, dataSource);
                                return;
                            }
                        }
                    }
                    this.f9526r = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected to receive an object of ");
                    sb2.append(this.f9517i);
                    sb2.append(" but instead got ");
                    if (obj2 != null) {
                        obj = obj2.getClass();
                    } else {
                        obj = "";
                    }
                    sb2.append(obj);
                    sb2.append("{");
                    sb2.append(obj2);
                    sb2.append("} inside Resource{");
                    sb2.append(cVar);
                    sb2.append("}.");
                    if (obj2 != null) {
                        str = "";
                    } else {
                        str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                    }
                    sb2.append(str);
                    b(new GlideException(sb2.toString()));
                    this.f9529u.k(cVar);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            if (cVar2 != null) {
                this.f9529u.k(cVar2);
            }
            throw th4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.f9529u.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f9511c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x0039 }
            g4.c r1 = r5.f9510b     // Catch:{ all -> 0x0039 }
            r1.c()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f9530v     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.n()     // Catch:{ all -> 0x0039 }
            l3.c<R> r1 = r5.f9526r     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f9526r = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.k()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            c4.h<R> r3 = r5.f9522n     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.q()     // Catch:{ all -> 0x0039 }
            r3.k(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.f9530v = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.h r0 = r5.f9529u
            r0.k(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public void d(int i10, int i11) {
        Object obj;
        this.f9510b.c();
        Object obj2 = this.f9511c;
        synchronized (obj2) {
            try {
                boolean z10 = D;
                if (z10) {
                    t("Got onSizeReady in " + f.a(this.f9528t));
                }
                if (this.f9530v == Status.WAITING_FOR_SIZE) {
                    Status status = Status.RUNNING;
                    this.f9530v = status;
                    float A2 = this.f9518j.A();
                    this.f9534z = u(i10, A2);
                    this.A = u(i11, A2);
                    if (z10) {
                        t("finished setup for calling load in " + f.a(this.f9528t));
                    }
                    Status status2 = status;
                    boolean z11 = z10;
                    Status status3 = status2;
                    obj = obj2;
                    try {
                        this.f9527s = this.f9529u.f(this.f9515g, this.f9516h, this.f9518j.z(), this.f9534z, this.A, this.f9518j.y(), this.f9517i, this.f9521m, this.f9518j.k(), this.f9518j.C(), this.f9518j.M(), this.f9518j.H(), this.f9518j.s(), this.f9518j.F(), this.f9518j.E(), this.f9518j.D(), this.f9518j.r(), this, this.f9525q);
                        if (this.f9530v != status3) {
                            this.f9527s = null;
                        }
                        if (z11) {
                            t("finished onSizeReady in " + f.a(this.f9528t));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    public boolean e(a aVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        a<?> aVar2;
        Priority priority;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class<R> cls2;
        a<?> aVar3;
        Priority priority2;
        int i15;
        a aVar4 = aVar;
        if (!(aVar4 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f9511c) {
            i10 = this.f9519k;
            i11 = this.f9520l;
            obj = this.f9516h;
            cls = this.f9517i;
            aVar2 = this.f9518j;
            priority = this.f9521m;
            List<b<R>> list = this.f9523o;
            if (list != null) {
                i12 = list.size();
            } else {
                i12 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) aVar4;
        synchronized (singleRequest.f9511c) {
            i13 = singleRequest.f9519k;
            i14 = singleRequest.f9520l;
            obj2 = singleRequest.f9516h;
            cls2 = singleRequest.f9517i;
            aVar3 = singleRequest.f9518j;
            priority2 = singleRequest.f9521m;
            List<b<R>> list2 = singleRequest.f9523o;
            if (list2 != null) {
                i15 = list2.size();
            } else {
                i15 = 0;
            }
        }
        if (i10 == i13 && i11 == i14 && k.b(obj, obj2) && cls.equals(cls2) && aVar2.equals(aVar3) && priority == priority2 && i12 == i15) {
            return true;
        }
        return false;
    }

    public boolean f() {
        boolean z10;
        synchronized (this.f9511c) {
            if (this.f9530v == Status.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public Object g() {
        this.f9510b.c();
        return this.f9511c;
    }

    public boolean h() {
        boolean z10;
        synchronized (this.f9511c) {
            if (this.f9530v == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.f9511c) {
            Status status = this.f9530v;
            if (status != Status.RUNNING) {
                if (status != Status.WAITING_FOR_SIZE) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f9511c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x00a7 }
            g4.c r1 = r5.f9510b     // Catch:{ all -> 0x00a7 }
            r1.c()     // Catch:{ all -> 0x00a7 }
            long r1 = f4.f.b()     // Catch:{ all -> 0x00a7 }
            r5.f9528t = r1     // Catch:{ all -> 0x00a7 }
            java.lang.Object r1 = r5.f9516h     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.f9519k     // Catch:{ all -> 0x00a7 }
            int r2 = r5.f9520l     // Catch:{ all -> 0x00a7 }
            boolean r1 = f4.k.r(r1, r2)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.f9519k     // Catch:{ all -> 0x00a7 }
            r5.f9534z = r1     // Catch:{ all -> 0x00a7 }
            int r1 = r5.f9520l     // Catch:{ all -> 0x00a7 }
            r5.A = r1     // Catch:{ all -> 0x00a7 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.p()     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a7 }
            r5.y(r2, r1)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.f9530v     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a7 }
            if (r1 == r2) goto L_0x009f
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00a7 }
            if (r1 != r3) goto L_0x004f
            l3.c<R> r1 = r5.f9526r     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a7 }
            r5.c(r1, r2)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x004f:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a7 }
            r5.f9530v = r1     // Catch:{ all -> 0x00a7 }
            int r3 = r5.f9519k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f9520l     // Catch:{ all -> 0x00a7 }
            boolean r3 = f4.k.r(r3, r4)     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x0065
            int r3 = r5.f9519k     // Catch:{ all -> 0x00a7 }
            int r4 = r5.f9520l     // Catch:{ all -> 0x00a7 }
            r5.d(r3, r4)     // Catch:{ all -> 0x00a7 }
            goto L_0x006a
        L_0x0065:
            c4.h<R> r3 = r5.f9522n     // Catch:{ all -> 0x00a7 }
            r3.c(r5)     // Catch:{ all -> 0x00a7 }
        L_0x006a:
            com.bumptech.glide.request.SingleRequest$Status r3 = r5.f9530v     // Catch:{ all -> 0x00a7 }
            if (r3 == r2) goto L_0x0070
            if (r3 != r1) goto L_0x007f
        L_0x0070:
            boolean r1 = r5.l()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x007f
            c4.h<R> r1 = r5.f9522n     // Catch:{ all -> 0x00a7 }
            android.graphics.drawable.Drawable r2 = r5.q()     // Catch:{ all -> 0x00a7 }
            r1.i(r2)     // Catch:{ all -> 0x00a7 }
        L_0x007f:
            boolean r1 = D     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x009d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            long r2 = r5.f9528t     // Catch:{ all -> 0x00a7 }
            double r2 = f4.f.a(r2)     // Catch:{ all -> 0x00a7 }
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a7 }
            r5.t(r1)     // Catch:{ all -> 0x00a7 }
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            return
        L_0x009f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a7 }
            throw r1     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.j():void");
    }

    public void pause() {
        synchronized (this.f9511c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}

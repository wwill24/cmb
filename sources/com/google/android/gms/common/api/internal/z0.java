package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h0;
import com.google.android.gms.common.internal.i0;
import com.google.android.gms.common.internal.p;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class z0 extends d implements u1 {

    /* renamed from: b  reason: collision with root package name */
    private final Lock f38829b;

    /* renamed from: c  reason: collision with root package name */
    private final i0 f38830c;

    /* renamed from: d  reason: collision with root package name */
    private w1 f38831d = null;

    /* renamed from: e  reason: collision with root package name */
    private final int f38832e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f38833f;

    /* renamed from: g  reason: collision with root package name */
    private final Looper f38834g;

    /* renamed from: h  reason: collision with root package name */
    final Queue f38835h = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f38836i;

    /* renamed from: j  reason: collision with root package name */
    private long f38837j;

    /* renamed from: k  reason: collision with root package name */
    private long f38838k;

    /* renamed from: l  reason: collision with root package name */
    private final x0 f38839l;

    /* renamed from: m  reason: collision with root package name */
    private final c f38840m;

    /* renamed from: n  reason: collision with root package name */
    s1 f38841n;

    /* renamed from: o  reason: collision with root package name */
    final Map f38842o;

    /* renamed from: p  reason: collision with root package name */
    Set f38843p;

    /* renamed from: q  reason: collision with root package name */
    final e f38844q;

    /* renamed from: r  reason: collision with root package name */
    final Map f38845r;

    /* renamed from: s  reason: collision with root package name */
    final a.C0480a f38846s;

    /* renamed from: t  reason: collision with root package name */
    private final l f38847t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList f38848u;

    /* renamed from: v  reason: collision with root package name */
    private Integer f38849v;

    /* renamed from: w  reason: collision with root package name */
    Set f38850w;

    /* renamed from: x  reason: collision with root package name */
    final w2 f38851x;

    /* renamed from: y  reason: collision with root package name */
    private final h0 f38852y;

    public z0(Context context, Lock lock, Looper looper, e eVar, c cVar, a.C0480a aVar, Map map, List list, List list2, Map map2, int i10, int i11, ArrayList arrayList) {
        Looper looper2 = looper;
        int i12 = i10;
        this.f38837j = true != me.e.c() ? 120000 : 10000;
        this.f38838k = 5000;
        this.f38843p = new HashSet();
        this.f38847t = new l();
        this.f38849v = null;
        this.f38850w = null;
        w0 w0Var = new w0(this);
        this.f38852y = w0Var;
        this.f38833f = context;
        this.f38829b = lock;
        this.f38830c = new i0(looper, w0Var);
        this.f38834g = looper2;
        this.f38839l = new x0(this, looper);
        this.f38840m = cVar;
        this.f38832e = i12;
        if (i12 >= 0) {
            this.f38849v = Integer.valueOf(i11);
        }
        this.f38845r = map;
        this.f38842o = map2;
        this.f38848u = arrayList;
        this.f38851x = new w2();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f38830c.f((d.b) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f38830c.g((d.c) it2.next());
        }
        this.f38844q = eVar;
        this.f38846s = aVar;
    }

    private final void B(int i10) {
        Integer num = this.f38849v;
        if (num == null) {
            this.f38849v = Integer.valueOf(i10);
        } else if (num.intValue() != i10) {
            int intValue = this.f38849v.intValue();
            throw new IllegalStateException("Cannot use sign-in mode: " + x(i10) + ". Mode was already set to " + x(intValue));
        }
        if (this.f38831d == null) {
            boolean z10 = false;
            boolean z11 = false;
            for (a.f fVar : this.f38842o.values()) {
                z10 |= fVar.requiresSignIn();
                z11 |= fVar.providesSignIn();
            }
            int intValue2 = this.f38849v.intValue();
            if (intValue2 != 1) {
                if (intValue2 == 2 && z10) {
                    this.f38831d = y.q(this.f38833f, this, this.f38829b, this.f38834g, this.f38840m, this.f38842o, this.f38844q, this.f38845r, this.f38846s, this.f38848u);
                    return;
                }
            } else if (!z10) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z11) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.f38831d = new d1(this.f38833f, this, this.f38829b, this.f38834g, this.f38840m, this.f38842o, this.f38844q, this.f38845r, this.f38846s, this.f38848u, this);
        }
    }

    private final void C() {
        this.f38830c.b();
        ((w1) p.k(this.f38831d)).a();
    }

    public static int v(Iterable iterable, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            a.f fVar = (a.f) it.next();
            z11 |= fVar.requiresSignIn();
            z12 |= fVar.providesSignIn();
        }
        if (!z11) {
            return 3;
        }
        if (!z12 || !z10) {
            return 1;
        }
        return 2;
    }

    static String x(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? IdentityHttpResponse.UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    static /* bridge */ /* synthetic */ void y(z0 z0Var) {
        z0Var.f38829b.lock();
        try {
            if (z0Var.f38836i) {
                z0Var.C();
            }
        } finally {
            z0Var.f38829b.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void z(z0 z0Var) {
        z0Var.f38829b.lock();
        try {
            if (z0Var.A()) {
                z0Var.C();
            }
        } finally {
            z0Var.f38829b.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean A() {
        if (!this.f38836i) {
            return false;
        }
        this.f38836i = false;
        this.f38839l.removeMessages(2);
        this.f38839l.removeMessages(1);
        s1 s1Var = this.f38841n;
        if (s1Var != null) {
            s1Var.b();
            this.f38841n = null;
        }
        return true;
    }

    public final void a(Bundle bundle) {
        while (!this.f38835h.isEmpty()) {
            h((d) this.f38835h.remove());
        }
        this.f38830c.d(bundle);
    }

    public final void b(int i10, boolean z10) {
        if (i10 == 1) {
            if (!z10 && !this.f38836i) {
                this.f38836i = true;
                if (this.f38841n == null && !me.e.c()) {
                    try {
                        this.f38841n = this.f38840m.u(this.f38833f.getApplicationContext(), new y0(this));
                    } catch (SecurityException unused) {
                    }
                }
                x0 x0Var = this.f38839l;
                x0Var.sendMessageDelayed(x0Var.obtainMessage(1), this.f38837j);
                x0 x0Var2 = this.f38839l;
                x0Var2.sendMessageDelayed(x0Var2.obtainMessage(2), this.f38838k);
            }
            i10 = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.f38851x.f38795a.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(w2.f38794c);
        }
        this.f38830c.e(i10);
        this.f38830c.a();
        if (i10 == 2) {
            C();
        }
    }

    public final void c(ConnectionResult connectionResult) {
        if (!this.f38840m.k(this.f38833f, connectionResult.S())) {
            A();
        }
        if (!this.f38836i) {
            this.f38830c.c(connectionResult);
            this.f38830c.a();
        }
    }

    public final void d() {
        boolean z10;
        this.f38829b.lock();
        try {
            int i10 = 2;
            boolean z11 = false;
            if (this.f38832e >= 0) {
                if (this.f38849v != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                p.p(z10, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f38849v;
                if (num == null) {
                    this.f38849v = Integer.valueOf(v(this.f38842o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) p.k(this.f38849v)).intValue();
            this.f38829b.lock();
            if (intValue == 3 || intValue == 1) {
                i10 = intValue;
            } else if (intValue != 2) {
                i10 = intValue;
                p.b(z11, "Illegal sign-in mode: " + i10);
                B(i10);
                C();
            }
            z11 = true;
            p.b(z11, "Illegal sign-in mode: " + i10);
            B(i10);
            C();
        } catch (Throwable th2) {
            throw th2;
        } finally {
            this.f38829b.unlock();
        }
    }

    public final void e() {
        Lock lock;
        this.f38829b.lock();
        try {
            this.f38851x.b();
            w1 w1Var = this.f38831d;
            if (w1Var != null) {
                w1Var.e();
            }
            this.f38847t.d();
            for (d dVar : this.f38835h) {
                dVar.zan((v2) null);
                dVar.cancel();
            }
            this.f38835h.clear();
            if (this.f38831d == null) {
                lock = this.f38829b;
            } else {
                A();
                this.f38830c.a();
                lock = this.f38829b;
            }
            lock.unlock();
        } catch (Throwable th2) {
            this.f38829b.unlock();
            throw th2;
        }
    }

    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f38833f);
        printWriter.append(str).append("mResuming=").print(this.f38836i);
        printWriter.append(" mWorkQueue.size()=").print(this.f38835h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f38851x.f38795a.size());
        w1 w1Var = this.f38831d;
        if (w1Var != null) {
            w1Var.h(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends a.b, R extends j, T extends d<R, A>> T g(@NonNull T t10) {
        String str;
        Lock lock;
        a<?> api = t10.getApi();
        boolean containsKey = this.f38842o.containsKey(t10.getClientKey());
        if (api != null) {
            str = api.d();
        } else {
            str = "the API";
        }
        p.b(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.f38829b.lock();
        try {
            w1 w1Var = this.f38831d;
            if (w1Var == null) {
                this.f38835h.add(t10);
                lock = this.f38829b;
            } else {
                t10 = w1Var.j(t10);
                lock = this.f38829b;
            }
            lock.unlock();
            return t10;
        } catch (Throwable th2) {
            this.f38829b.unlock();
            throw th2;
        }
    }

    public final <A extends a.b, T extends d<? extends j, A>> T h(@NonNull T t10) {
        String str;
        Lock lock;
        a<?> api = t10.getApi();
        boolean containsKey = this.f38842o.containsKey(t10.getClientKey());
        if (api != null) {
            str = api.d();
        } else {
            str = "the API";
        }
        p.b(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.f38829b.lock();
        try {
            w1 w1Var = this.f38831d;
            if (w1Var != null) {
                if (this.f38836i) {
                    this.f38835h.add(t10);
                    while (!this.f38835h.isEmpty()) {
                        d dVar = (d) this.f38835h.remove();
                        this.f38851x.a(dVar);
                        dVar.setFailedResult(Status.f38502j);
                    }
                    lock = this.f38829b;
                } else {
                    t10 = w1Var.l(t10);
                    lock = this.f38829b;
                }
                lock.unlock();
                return t10;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th2) {
            this.f38829b.unlock();
            throw th2;
        }
    }

    @NonNull
    public final <C extends a.f> C j(@NonNull a.c<C> cVar) {
        C c10 = (a.f) this.f38842o.get(cVar);
        p.l(c10, "Appropriate Api was not requested.");
        return c10;
    }

    public final Context k() {
        return this.f38833f;
    }

    public final Looper l() {
        return this.f38834g;
    }

    public final boolean m() {
        w1 w1Var = this.f38831d;
        return w1Var != null && w1Var.k();
    }

    public final boolean n() {
        w1 w1Var = this.f38831d;
        return w1Var != null && w1Var.i();
    }

    public final boolean o(r rVar) {
        w1 w1Var = this.f38831d;
        return w1Var != null && w1Var.g(rVar);
    }

    public final void p() {
        w1 w1Var = this.f38831d;
        if (w1Var != null) {
            w1Var.d();
        }
    }

    public final void q(@NonNull d.c cVar) {
        this.f38830c.g(cVar);
    }

    public final void r(@NonNull d.c cVar) {
        this.f38830c.h(cVar);
    }

    public final void s(u2 u2Var) {
        this.f38829b.lock();
        try {
            if (this.f38850w == null) {
                this.f38850w = new HashSet();
            }
            this.f38850w.add(u2Var);
        } finally {
            this.f38829b.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(com.google.android.gms.common.api.internal.u2 r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f38829b
            r0.lock()
            java.util.Set r0 = r2.f38850w     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0016
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0016:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0027
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0027:
            java.util.concurrent.locks.Lock r3 = r2.f38829b     // Catch:{ all -> 0x0057 }
            r3.lock()     // Catch:{ all -> 0x0057 }
            java.util.Set r3 = r2.f38850w     // Catch:{ all -> 0x0050 }
            if (r3 != 0) goto L_0x0036
            java.util.concurrent.locks.Lock r3 = r2.f38829b     // Catch:{ all -> 0x0057 }
            r3.unlock()     // Catch:{ all -> 0x0057 }
            goto L_0x0043
        L_0x0036:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0050 }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.f38829b     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x004a
        L_0x0043:
            com.google.android.gms.common.api.internal.w1 r3 = r2.f38831d     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x004a
            r3.b()     // Catch:{ all -> 0x0057 }
        L_0x004a:
            java.util.concurrent.locks.Lock r3 = r2.f38829b
            r3.unlock()
            return
        L_0x0050:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f38829b     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f38829b
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.z0.t(com.google.android.gms.common.api.internal.u2):void");
    }

    /* access modifiers changed from: package-private */
    public final String w() {
        StringWriter stringWriter = new StringWriter();
        f("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }
}

package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import ge.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import me.b;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class l1 implements d.b, d.c, n3 {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f38659a = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: b  reason: collision with root package name */
    public final a.f f38660b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f38661c;

    /* renamed from: d  reason: collision with root package name */
    private final b0 f38662d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f38663e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Map f38664f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final int f38665g;

    /* renamed from: h  reason: collision with root package name */
    private final o2 f38666h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f38667j;

    /* renamed from: k  reason: collision with root package name */
    private final List f38668k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private ConnectionResult f38669l = null;

    /* renamed from: m  reason: collision with root package name */
    private int f38670m = 0;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ g f38671n;

    public l1(g gVar, c cVar) {
        this.f38671n = gVar;
        a.f zab = cVar.zab(gVar.f38623p.getLooper(), this);
        this.f38660b = zab;
        this.f38661c = cVar.getApiKey();
        this.f38662d = new b0();
        this.f38665g = cVar.zaa();
        if (zab.requiresSignIn()) {
            this.f38666h = cVar.zac(gVar.f38614g, gVar.f38623p);
        } else {
            this.f38666h = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(l1 l1Var, n1 n1Var) {
        if (!l1Var.f38668k.contains(n1Var) || l1Var.f38667j) {
            return;
        }
        if (!l1Var.f38660b.isConnected()) {
            l1Var.E();
        } else {
            l1Var.i();
        }
    }

    static /* bridge */ /* synthetic */ void C(l1 l1Var, n1 n1Var) {
        Feature[] g10;
        if (l1Var.f38668k.remove(n1Var)) {
            l1Var.f38671n.f38623p.removeMessages(15, n1Var);
            l1Var.f38671n.f38623p.removeMessages(16, n1Var);
            Feature a10 = n1Var.f38696b;
            ArrayList arrayList = new ArrayList(l1Var.f38659a.size());
            for (b3 b3Var : l1Var.f38659a) {
                if ((b3Var instanceof v1) && (g10 = ((v1) b3Var).g(l1Var)) != null && b.b(g10, a10)) {
                    arrayList.add(b3Var);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                b3 b3Var2 = (b3) arrayList.get(i10);
                l1Var.f38659a.remove(b3Var2);
                b3Var2.b(new UnsupportedApiCallException(a10));
            }
        }
    }

    private final Feature b(Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] availableFeatures = this.f38660b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            androidx.collection.a aVar = new androidx.collection.a(r3);
            for (Feature feature : availableFeatures) {
                aVar.put(feature.S(), Long.valueOf(feature.Y()));
            }
            for (Feature feature2 : featureArr) {
                Long l10 = (Long) aVar.get(feature2.S());
                if (l10 == null || l10.longValue() < feature2.Y()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    private final void d(ConnectionResult connectionResult) {
        String str;
        for (e3 e3Var : this.f38663e) {
            if (n.b(connectionResult, ConnectionResult.f38485e)) {
                str = this.f38660b.getEndpointPackageName();
            } else {
                str = null;
            }
            e3Var.b(this.f38661c, connectionResult, str);
        }
        this.f38663e.clear();
    }

    /* access modifiers changed from: private */
    public final void e(Status status) {
        p.d(this.f38671n.f38623p);
        h(status, (Exception) null, false);
    }

    private final void h(Status status, Exception exc, boolean z10) {
        boolean z11;
        p.d(this.f38671n.f38623p);
        boolean z12 = false;
        if (status != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (exc == null) {
            z12 = true;
        }
        if (z11 != z12) {
            Iterator it = this.f38659a.iterator();
            while (it.hasNext()) {
                b3 b3Var = (b3) it.next();
                if (!z10 || b3Var.f38554a == 2) {
                    if (status != null) {
                        b3Var.a(status);
                    } else {
                        b3Var.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void i() {
        ArrayList arrayList = new ArrayList(this.f38659a);
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            b3 b3Var = (b3) arrayList.get(i10);
            if (this.f38660b.isConnected()) {
                if (o(b3Var)) {
                    this.f38659a.remove(b3Var);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        D();
        d(ConnectionResult.f38485e);
        n();
        Iterator it = this.f38664f.values().iterator();
        while (it.hasNext()) {
            d2 d2Var = (d2) it.next();
            if (b(d2Var.f38587a.c()) != null) {
                it.remove();
            } else {
                try {
                    d2Var.f38587a.d(this.f38660b, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    f(3);
                    this.f38660b.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        i();
        l();
    }

    /* access modifiers changed from: private */
    public final void k(int i10) {
        D();
        this.f38667j = true;
        this.f38662d.e(i10, this.f38660b.getLastDisconnectMessage());
        g gVar = this.f38671n;
        gVar.f38623p.sendMessageDelayed(Message.obtain(gVar.f38623p, 9, this.f38661c), this.f38671n.f38608a);
        g gVar2 = this.f38671n;
        gVar2.f38623p.sendMessageDelayed(Message.obtain(gVar2.f38623p, 11, this.f38661c), this.f38671n.f38609b);
        this.f38671n.f38616i.c();
        for (d2 d2Var : this.f38664f.values()) {
            d2Var.f38589c.run();
        }
    }

    private final void l() {
        this.f38671n.f38623p.removeMessages(12, this.f38661c);
        g gVar = this.f38671n;
        gVar.f38623p.sendMessageDelayed(gVar.f38623p.obtainMessage(12, this.f38661c), this.f38671n.f38610c);
    }

    private final void m(b3 b3Var) {
        b3Var.d(this.f38662d, P());
        try {
            b3Var.c(this);
        } catch (DeadObjectException unused) {
            f(1);
            this.f38660b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void n() {
        if (this.f38667j) {
            this.f38671n.f38623p.removeMessages(11, this.f38661c);
            this.f38671n.f38623p.removeMessages(9, this.f38661c);
            this.f38667j = false;
        }
    }

    private final boolean o(b3 b3Var) {
        if (!(b3Var instanceof v1)) {
            m(b3Var);
            return true;
        }
        v1 v1Var = (v1) b3Var;
        Feature b10 = b(v1Var.g(this));
        if (b10 == null) {
            m(b3Var);
            return true;
        }
        String name = this.f38660b.getClass().getName();
        String S = b10.S();
        long Y = b10.Y();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(S);
        sb2.append(", ");
        sb2.append(Y);
        sb2.append(").");
        if (!this.f38671n.f38624q || !v1Var.f(this)) {
            v1Var.b(new UnsupportedApiCallException(b10));
            return true;
        }
        n1 n1Var = new n1(this.f38661c, b10, (m1) null);
        int indexOf = this.f38668k.indexOf(n1Var);
        if (indexOf >= 0) {
            n1 n1Var2 = (n1) this.f38668k.get(indexOf);
            this.f38671n.f38623p.removeMessages(15, n1Var2);
            g gVar = this.f38671n;
            gVar.f38623p.sendMessageDelayed(Message.obtain(gVar.f38623p, 15, n1Var2), this.f38671n.f38608a);
            return false;
        }
        this.f38668k.add(n1Var);
        g gVar2 = this.f38671n;
        gVar2.f38623p.sendMessageDelayed(Message.obtain(gVar2.f38623p, 15, n1Var), this.f38671n.f38608a);
        g gVar3 = this.f38671n;
        gVar3.f38623p.sendMessageDelayed(Message.obtain(gVar3.f38623p, 16, n1Var), this.f38671n.f38609b);
        ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
        if (p(connectionResult)) {
            return false;
        }
        this.f38671n.h(connectionResult, this.f38665g);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean p(@androidx.annotation.NonNull com.google.android.gms.common.ConnectionResult r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.g.f38606t
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.g r1 = r3.f38671n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.c0 r2 = r1.f38620m     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0027
            java.util.Set r1 = r1.f38621n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.b r2 = r3.f38661c     // Catch:{ all -> 0x002a }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0027
            com.google.android.gms.common.api.internal.g r1 = r3.f38671n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.c0 r1 = r1.f38620m     // Catch:{ all -> 0x002a }
            int r2 = r3.f38665g     // Catch:{ all -> 0x002a }
            r1.h(r4, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 1
            return r4
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 0
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.l1.p(com.google.android.gms.common.ConnectionResult):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean q(boolean z10) {
        p.d(this.f38671n.f38623p);
        if (!this.f38660b.isConnected() || this.f38664f.size() != 0) {
            return false;
        }
        if (this.f38662d.g()) {
            if (z10) {
                l();
            }
            return false;
        }
        this.f38660b.disconnect("Timing out service connection.");
        return true;
    }

    public final void D() {
        p.d(this.f38671n.f38623p);
        this.f38669l = null;
    }

    public final void E() {
        p.d(this.f38671n.f38623p);
        if (!this.f38660b.isConnected() && !this.f38660b.isConnecting()) {
            try {
                g gVar = this.f38671n;
                int b10 = gVar.f38616i.b(gVar.f38614g, this.f38660b);
                if (b10 != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(b10, (PendingIntent) null);
                    String name = this.f38660b.getClass().getName();
                    String obj = connectionResult.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("The service for ");
                    sb2.append(name);
                    sb2.append(" is not available: ");
                    sb2.append(obj);
                    H(connectionResult, (Exception) null);
                    return;
                }
                g gVar2 = this.f38671n;
                a.f fVar = this.f38660b;
                p1 p1Var = new p1(gVar2, fVar, this.f38661c);
                if (fVar.requiresSignIn()) {
                    ((o2) p.k(this.f38666h)).x0(p1Var);
                }
                try {
                    this.f38660b.connect(p1Var);
                } catch (SecurityException e10) {
                    H(new ConnectionResult(10), e10);
                }
            } catch (IllegalStateException e11) {
                H(new ConnectionResult(10), e11);
            }
        }
    }

    public final void F(b3 b3Var) {
        p.d(this.f38671n.f38623p);
        if (!this.f38660b.isConnected()) {
            this.f38659a.add(b3Var);
            ConnectionResult connectionResult = this.f38669l;
            if (connectionResult == null || !connectionResult.f0()) {
                E();
            } else {
                H(this.f38669l, (Exception) null);
            }
        } else if (o(b3Var)) {
            l();
        } else {
            this.f38659a.add(b3Var);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        this.f38670m++;
    }

    public final void H(@NonNull ConnectionResult connectionResult, Exception exc) {
        p.d(this.f38671n.f38623p);
        o2 o2Var = this.f38666h;
        if (o2Var != null) {
            o2Var.y0();
        }
        D();
        this.f38671n.f38616i.c();
        d(connectionResult);
        if ((this.f38660b instanceof e) && connectionResult.S() != 24) {
            this.f38671n.f38611d = true;
            g gVar = this.f38671n;
            gVar.f38623p.sendMessageDelayed(gVar.f38623p.obtainMessage(19), 300000);
        }
        if (connectionResult.S() == 4) {
            e(g.f38605s);
        } else if (this.f38659a.isEmpty()) {
            this.f38669l = connectionResult;
        } else if (exc != null) {
            p.d(this.f38671n.f38623p);
            h((Status) null, exc, false);
        } else if (this.f38671n.f38624q) {
            h(g.i(this.f38661c, connectionResult), (Exception) null, true);
            if (!this.f38659a.isEmpty() && !p(connectionResult) && !this.f38671n.h(connectionResult, this.f38665g)) {
                if (connectionResult.S() == 18) {
                    this.f38667j = true;
                }
                if (this.f38667j) {
                    g gVar2 = this.f38671n;
                    gVar2.f38623p.sendMessageDelayed(Message.obtain(gVar2.f38623p, 9, this.f38661c), this.f38671n.f38608a);
                    return;
                }
                e(g.i(this.f38661c, connectionResult));
            }
        } else {
            e(g.i(this.f38661c, connectionResult));
        }
    }

    public final void I(@NonNull ConnectionResult connectionResult) {
        p.d(this.f38671n.f38623p);
        a.f fVar = this.f38660b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        fVar.disconnect("onSignInFailed for " + name + " with " + valueOf);
        H(connectionResult, (Exception) null);
    }

    public final void J(e3 e3Var) {
        p.d(this.f38671n.f38623p);
        this.f38663e.add(e3Var);
    }

    public final void K() {
        p.d(this.f38671n.f38623p);
        if (this.f38667j) {
            E();
        }
    }

    public final void L() {
        p.d(this.f38671n.f38623p);
        e(g.f38604r);
        this.f38662d.f();
        for (k.a a3Var : (k.a[]) this.f38664f.keySet().toArray(new k.a[0])) {
            F(new a3(a3Var, new TaskCompletionSource()));
        }
        d(new ConnectionResult(4));
        if (this.f38660b.isConnected()) {
            this.f38660b.onUserSignOut(new k1(this));
        }
    }

    public final void M() {
        Status status;
        p.d(this.f38671n.f38623p);
        if (this.f38667j) {
            n();
            g gVar = this.f38671n;
            if (gVar.f38615h.i(gVar.f38614g) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            e(status);
            this.f38660b.disconnect("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O() {
        return this.f38660b.isConnected();
    }

    public final boolean P() {
        return this.f38660b.requiresSignIn();
    }

    public final void W(ConnectionResult connectionResult, a aVar, boolean z10) {
        throw null;
    }

    public final boolean a() {
        return q(true);
    }

    public final void c(Bundle bundle) {
        if (Looper.myLooper() == this.f38671n.f38623p.getLooper()) {
            j();
        } else {
            this.f38671n.f38623p.post(new h1(this));
        }
    }

    public final void f(int i10) {
        if (Looper.myLooper() == this.f38671n.f38623p.getLooper()) {
            k(i10);
        } else {
            this.f38671n.f38623p.post(new i1(this, i10));
        }
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        H(connectionResult, (Exception) null);
    }

    public final int r() {
        return this.f38665g;
    }

    /* access modifiers changed from: package-private */
    public final int s() {
        return this.f38670m;
    }

    public final ConnectionResult t() {
        p.d(this.f38671n.f38623p);
        return this.f38669l;
    }

    public final a.f v() {
        return this.f38660b;
    }

    public final Map x() {
        return this.f38664f;
    }
}

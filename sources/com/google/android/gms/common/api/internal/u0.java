package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import ye.f;

public final class u0 implements a1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d1 f38747a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Lock f38748b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f38749c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d f38750d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f38751e;

    /* renamed from: f  reason: collision with root package name */
    private int f38752f;

    /* renamed from: g  reason: collision with root package name */
    private int f38753g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f38754h;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f38755i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set f38756j = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public f f38757k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f38758l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f38759m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f38760n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public i f38761o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f38762p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f38763q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final e f38764r;

    /* renamed from: s  reason: collision with root package name */
    private final Map f38765s;

    /* renamed from: t  reason: collision with root package name */
    private final a.C0480a f38766t;

    /* renamed from: u  reason: collision with root package name */
    private final ArrayList f38767u = new ArrayList();

    public u0(d1 d1Var, e eVar, Map map, d dVar, a.C0480a aVar, Lock lock, Context context) {
        this.f38747a = d1Var;
        this.f38764r = eVar;
        this.f38765s = map;
        this.f38750d = dVar;
        this.f38766t = aVar;
        this.f38748b = lock;
        this.f38749c = context;
    }

    static /* bridge */ /* synthetic */ void B(u0 u0Var, zak zak) {
        if (u0Var.o(0)) {
            ConnectionResult S = zak.S();
            if (S.i0()) {
                zav zav = (zav) p.k(zak.Y());
                ConnectionResult S2 = zav.S();
                if (!S2.i0()) {
                    String valueOf = String.valueOf(S2);
                    Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                    u0Var.l(S2);
                    return;
                }
                u0Var.f38760n = true;
                u0Var.f38761o = (i) p.k(zav.Y());
                u0Var.f38762p = zav.c0();
                u0Var.f38763q = zav.f0();
                u0Var.n();
            } else if (u0Var.q(S)) {
                u0Var.i();
                u0Var.n();
            } else {
                u0Var.l(S);
            }
        }
    }

    private final void J() {
        ArrayList arrayList = this.f38767u;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Future) arrayList.get(i10)).cancel(true);
        }
        this.f38767u.clear();
    }

    /* access modifiers changed from: private */
    public final void i() {
        this.f38759m = false;
        this.f38747a.f38585p.f38843p = Collections.emptySet();
        for (a.c cVar : this.f38756j) {
            if (!this.f38747a.f38578g.containsKey(cVar)) {
                this.f38747a.f38578g.put(cVar, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void j(boolean z10) {
        f fVar = this.f38757k;
        if (fVar != null) {
            if (fVar.isConnected() && z10) {
                fVar.a();
            }
            fVar.disconnect();
            e eVar = (e) p.k(this.f38764r);
            this.f38761o = null;
        }
    }

    private final void k() {
        Bundle bundle;
        this.f38747a.o();
        e1.a().execute(new i0(this));
        f fVar = this.f38757k;
        if (fVar != null) {
            if (this.f38762p) {
                fVar.d((i) p.k(this.f38761o), this.f38763q);
            }
            j(false);
        }
        for (a.c cVar : this.f38747a.f38578g.keySet()) {
            ((a.f) p.k((a.f) this.f38747a.f38577f.get(cVar))).disconnect();
        }
        if (this.f38755i.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f38755i;
        }
        this.f38747a.f38586q.a(bundle);
    }

    /* access modifiers changed from: private */
    public final void l(ConnectionResult connectionResult) {
        J();
        j(!connectionResult.f0());
        this.f38747a.q(connectionResult);
        this.f38747a.f38586q.c(connectionResult);
    }

    /* access modifiers changed from: private */
    public final void m(ConnectionResult connectionResult, a aVar, boolean z10) {
        int priority = aVar.c().getPriority();
        if ((!z10 || connectionResult.f0() || this.f38750d.c(connectionResult.S()) != null) && (this.f38751e == null || priority < this.f38752f)) {
            this.f38751e = connectionResult;
            this.f38752f = priority;
        }
        this.f38747a.f38578g.put(aVar.b(), connectionResult);
    }

    /* access modifiers changed from: private */
    public final void n() {
        if (this.f38754h == 0) {
            if (!this.f38759m || this.f38760n) {
                ArrayList arrayList = new ArrayList();
                this.f38753g = 1;
                this.f38754h = this.f38747a.f38577f.size();
                for (a.c cVar : this.f38747a.f38577f.keySet()) {
                    if (!this.f38747a.f38578g.containsKey(cVar)) {
                        arrayList.add((a.f) this.f38747a.f38577f.get(cVar));
                    } else if (p()) {
                        k();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f38767u.add(e1.a().submit(new n0(this, arrayList)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean o(int i10) {
        if (this.f38753g == i10) {
            return true;
        }
        this.f38747a.f38585p.w();
        "Unexpected callback in ".concat(toString());
        int i11 = this.f38754h;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mRemainingConnections=");
        sb2.append(i11);
        int i12 = this.f38753g;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(r(i12));
        sb3.append(" but received callback for step ");
        sb3.append(r(i10));
        new Exception();
        l(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean p() {
        int i10 = this.f38754h - 1;
        this.f38754h = i10;
        if (i10 > 0) {
            return false;
        }
        if (i10 < 0) {
            this.f38747a.f38585p.w();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            l(new ConnectionResult(8, (PendingIntent) null));
            return false;
        }
        ConnectionResult connectionResult = this.f38751e;
        if (connectionResult == null) {
            return true;
        }
        this.f38747a.f38584n = this.f38752f;
        l(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean q(ConnectionResult connectionResult) {
        return this.f38758l && !connectionResult.f0();
    }

    private static final String r(int i10) {
        return i10 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set y(u0 u0Var) {
        e eVar = u0Var.f38764r;
        if (eVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(eVar.g());
        Map k10 = u0Var.f38764r.k();
        for (a aVar : k10.keySet()) {
            if (!u0Var.f38747a.f38578g.containsKey(aVar.b())) {
                hashSet.addAll(((z) k10.get(aVar)).f39071a);
            }
        }
        return hashSet;
    }

    public final void a(Bundle bundle) {
        if (o(1)) {
            if (bundle != null) {
                this.f38755i.putAll(bundle);
            }
            if (p()) {
                k();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.api.a$f, ye.f] */
    public final void b() {
        boolean z10;
        this.f38747a.f38578g.clear();
        this.f38759m = false;
        this.f38751e = null;
        this.f38753g = 0;
        this.f38758l = true;
        this.f38760n = false;
        this.f38762p = false;
        HashMap hashMap = new HashMap();
        boolean z11 = false;
        for (a aVar : this.f38765s.keySet()) {
            a.f fVar = (a.f) p.k((a.f) this.f38747a.f38577f.get(aVar.b()));
            if (aVar.c().getPriority() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 |= z10;
            boolean booleanValue = ((Boolean) this.f38765s.get(aVar)).booleanValue();
            if (fVar.requiresSignIn()) {
                this.f38759m = true;
                if (booleanValue) {
                    this.f38756j.add(aVar.b());
                } else {
                    this.f38758l = false;
                }
            }
            hashMap.put(fVar, new j0(this, aVar, booleanValue));
        }
        if (z11) {
            this.f38759m = false;
        }
        if (this.f38759m) {
            p.k(this.f38764r);
            p.k(this.f38766t);
            this.f38764r.l(Integer.valueOf(System.identityHashCode(this.f38747a.f38585p)));
            r0 r0Var = new r0(this, (q0) null);
            a.C0480a aVar2 = this.f38766t;
            Context context = this.f38749c;
            Looper l10 = this.f38747a.f38585p.l();
            e eVar = this.f38764r;
            this.f38757k = aVar2.buildClient(context, l10, eVar, eVar.h(), (d.b) r0Var, (d.c) r0Var);
        }
        this.f38754h = this.f38747a.f38577f.size();
        this.f38767u.add(e1.a().submit(new m0(this, hashMap)));
    }

    public final void c() {
    }

    public final void d(ConnectionResult connectionResult, a aVar, boolean z10) {
        if (o(1)) {
            m(connectionResult, aVar, z10);
            if (p()) {
                k();
            }
        }
    }

    public final void e(int i10) {
        l(new ConnectionResult(8, (PendingIntent) null));
    }

    public final d f(d dVar) {
        this.f38747a.f38585p.f38835h.add(dVar);
        return dVar;
    }

    public final boolean g() {
        J();
        j(true);
        this.f38747a.q((ConnectionResult) null);
        return true;
    }

    public final d h(d dVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}

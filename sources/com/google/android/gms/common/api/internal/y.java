package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zau;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class y implements w1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38806a;

    /* renamed from: b  reason: collision with root package name */
    private final z0 f38807b;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f38808c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final d1 f38809d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final d1 f38810e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f38811f;

    /* renamed from: g  reason: collision with root package name */
    private final Set f38812g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: h  reason: collision with root package name */
    private final a.f f38813h;

    /* renamed from: j  reason: collision with root package name */
    private Bundle f38814j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ConnectionResult f38815k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ConnectionResult f38816l = null;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f38817m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Lock f38818n;

    /* renamed from: p  reason: collision with root package name */
    private int f38819p = 0;

    private y(Context context, z0 z0Var, Lock lock, Looper looper, d dVar, Map map, Map map2, e eVar, a.C0480a aVar, a.f fVar, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f38806a = context;
        this.f38807b = z0Var;
        this.f38818n = lock;
        this.f38808c = looper;
        this.f38813h = fVar;
        Context context2 = context;
        z0 z0Var2 = z0Var;
        Lock lock2 = lock;
        Looper looper2 = looper;
        d dVar2 = dVar;
        d1 d1Var = r3;
        d1 d1Var2 = new d1(context2, z0Var2, lock2, looper2, dVar2, map2, (e) null, map4, (a.C0480a) null, arrayList2, new q3(this, (p3) null));
        this.f38809d = d1Var;
        this.f38810e = new d1(context2, z0Var2, lock2, looper2, dVar2, map, eVar, map3, aVar, arrayList, new s3(this, (r3) null));
        androidx.collection.a aVar2 = new androidx.collection.a();
        for (a.c put : map2.keySet()) {
            aVar2.put(put, this.f38809d);
        }
        for (a.c put2 : map.keySet()) {
            aVar2.put(put2, this.f38810e);
        }
        this.f38811f = Collections.unmodifiableMap(aVar2);
    }

    private final PendingIntent B() {
        if (this.f38813h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f38806a, System.identityHashCode(this.f38807b), this.f38813h.getSignInIntent(), zap.zaa | 134217728);
    }

    private final void c(ConnectionResult connectionResult) {
        int i10 = this.f38819p;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f38819p = 0;
            }
            this.f38807b.c(connectionResult);
        }
        f();
        this.f38819p = 0;
    }

    private final void f() {
        for (r onComplete : this.f38812g) {
            onComplete.onComplete();
        }
        this.f38812g.clear();
    }

    private final boolean m() {
        ConnectionResult connectionResult = this.f38816l;
        return connectionResult != null && connectionResult.S() == 4;
    }

    private final boolean n(d dVar) {
        d1 d1Var = (d1) this.f38811f.get(dVar.getClientKey());
        p.l(d1Var, "GoogleApiClient is not configured to use the API required for this call.");
        return d1Var.equals(this.f38810e);
    }

    private static boolean o(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.i0();
    }

    public static y q(Context context, z0 z0Var, Lock lock, Looper looper, d dVar, Map map, e eVar, Map map2, a.C0480a aVar, ArrayList arrayList) {
        Map map3 = map2;
        androidx.collection.a aVar2 = new androidx.collection.a();
        androidx.collection.a aVar3 = new androidx.collection.a();
        a.f fVar = null;
        for (Map.Entry entry : map.entrySet()) {
            a.f fVar2 = (a.f) entry.getValue();
            if (true == fVar2.providesSignIn()) {
                fVar = fVar2;
            }
            if (fVar2.requiresSignIn()) {
                aVar2.put((a.c) entry.getKey(), fVar2);
            } else {
                aVar3.put((a.c) entry.getKey(), fVar2);
            }
        }
        p.p(!aVar2.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.collection.a aVar4 = new androidx.collection.a();
        androidx.collection.a aVar5 = new androidx.collection.a();
        for (a aVar6 : map2.keySet()) {
            a.c b10 = aVar6.b();
            if (aVar2.containsKey(b10)) {
                aVar4.put(aVar6, (Boolean) map3.get(aVar6));
            } else if (aVar3.containsKey(b10)) {
                aVar5.put(aVar6, (Boolean) map3.get(aVar6));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m3 m3Var = (m3) arrayList.get(i10);
            if (aVar4.containsKey(m3Var.f38690a)) {
                arrayList2.add(m3Var);
            } else if (aVar5.containsKey(m3Var.f38690a)) {
                arrayList3.add(m3Var);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new y(context, z0Var, lock, looper, dVar, aVar2, aVar3, eVar, aVar, fVar, arrayList2, arrayList3, aVar4, aVar5);
    }

    static /* bridge */ /* synthetic */ void x(y yVar, int i10, boolean z10) {
        yVar.f38807b.b(i10, z10);
        yVar.f38816l = null;
        yVar.f38815k = null;
    }

    static /* bridge */ /* synthetic */ void y(y yVar, Bundle bundle) {
        Bundle bundle2 = yVar.f38814j;
        if (bundle2 == null) {
            yVar.f38814j = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void z(y yVar) {
        ConnectionResult connectionResult;
        if (o(yVar.f38815k)) {
            if (o(yVar.f38816l) || yVar.m()) {
                int i10 = yVar.f38819p;
                if (i10 != 1) {
                    if (i10 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        yVar.f38819p = 0;
                        return;
                    }
                    ((z0) p.k(yVar.f38807b)).a(yVar.f38814j);
                }
                yVar.f();
                yVar.f38819p = 0;
                return;
            }
            ConnectionResult connectionResult2 = yVar.f38816l;
            if (connectionResult2 == null) {
                return;
            }
            if (yVar.f38819p == 1) {
                yVar.f();
                return;
            }
            yVar.c(connectionResult2);
            yVar.f38809d.e();
        } else if (yVar.f38815k == null || !o(yVar.f38816l)) {
            ConnectionResult connectionResult3 = yVar.f38815k;
            if (connectionResult3 != null && (connectionResult = yVar.f38816l) != null) {
                if (yVar.f38810e.f38584n < yVar.f38809d.f38584n) {
                    connectionResult3 = connectionResult;
                }
                yVar.c(connectionResult3);
            }
        } else {
            yVar.f38810e.e();
            yVar.c((ConnectionResult) p.k(yVar.f38815k));
        }
    }

    public final void a() {
        this.f38819p = 2;
        this.f38817m = false;
        this.f38816l = null;
        this.f38815k = null;
        this.f38809d.a();
        this.f38810e.a();
    }

    public final void b() {
        this.f38809d.b();
        this.f38810e.b();
    }

    public final void d() {
        this.f38818n.lock();
        try {
            boolean i10 = i();
            this.f38810e.e();
            this.f38816l = new ConnectionResult(4);
            if (i10) {
                new zau(this.f38808c).post(new o3(this));
            } else {
                f();
            }
        } finally {
            this.f38818n.unlock();
        }
    }

    public final void e() {
        this.f38816l = null;
        this.f38815k = null;
        this.f38819p = 0;
        this.f38809d.e();
        this.f38810e.e();
        f();
    }

    public final boolean g(r rVar) {
        this.f38818n.lock();
        try {
            if ((i() || k()) && !this.f38810e.k()) {
                this.f38812g.add(rVar);
                if (this.f38819p == 0) {
                    this.f38819p = 1;
                }
                this.f38816l = null;
                this.f38810e.a();
                return true;
            }
            this.f38818n.unlock();
            return false;
        } finally {
            this.f38818n.unlock();
        }
    }

    public final void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(CertificateUtil.DELIMITER);
        this.f38810e.h(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(CertificateUtil.DELIMITER);
        this.f38809d.h(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean i() {
        boolean z10;
        this.f38818n.lock();
        try {
            if (this.f38819p == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            return z10;
        } finally {
            this.f38818n.unlock();
        }
    }

    public final d j(@NonNull d dVar) {
        if (!n(dVar)) {
            this.f38809d.j(dVar);
            return dVar;
        } else if (m()) {
            dVar.setFailedResult(new Status(4, (String) null, B()));
            return dVar;
        } else {
            this.f38810e.j(dVar);
            return dVar;
        }
    }

    public final boolean k() {
        this.f38818n.lock();
        try {
            boolean z10 = false;
            if (this.f38809d.k() && (this.f38810e.k() || m() || this.f38819p == 1)) {
                z10 = true;
            }
            return z10;
        } finally {
            this.f38818n.unlock();
        }
    }

    public final d l(@NonNull d dVar) {
        if (!n(dVar)) {
            return this.f38809d.l(dVar);
        }
        if (!m()) {
            return this.f38810e.l(dVar);
        }
        dVar.setFailedResult(new Status(4, (String) null, B()));
        return dVar;
    }
}

package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class d1 implements w1, n3 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Lock f38572a;

    /* renamed from: b  reason: collision with root package name */
    private final Condition f38573b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f38574c;

    /* renamed from: d  reason: collision with root package name */
    private final d f38575d;

    /* renamed from: e  reason: collision with root package name */
    private final c1 f38576e;

    /* renamed from: f  reason: collision with root package name */
    final Map f38577f;

    /* renamed from: g  reason: collision with root package name */
    final Map f38578g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final e f38579h;

    /* renamed from: j  reason: collision with root package name */
    final Map f38580j;

    /* renamed from: k  reason: collision with root package name */
    final a.C0480a f38581k;
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: l  reason: collision with root package name */
    public volatile a1 f38582l;

    /* renamed from: m  reason: collision with root package name */
    private ConnectionResult f38583m = null;

    /* renamed from: n  reason: collision with root package name */
    int f38584n;

    /* renamed from: p  reason: collision with root package name */
    final z0 f38585p;

    /* renamed from: q  reason: collision with root package name */
    final u1 f38586q;

    public d1(Context context, z0 z0Var, Lock lock, Looper looper, d dVar, Map map, e eVar, Map map2, a.C0480a aVar, ArrayList arrayList, u1 u1Var) {
        this.f38574c = context;
        this.f38572a = lock;
        this.f38575d = dVar;
        this.f38577f = map;
        this.f38579h = eVar;
        this.f38580j = map2;
        this.f38581k = aVar;
        this.f38585p = z0Var;
        this.f38586q = u1Var;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m3) arrayList.get(i10)).a(this);
        }
        this.f38576e = new c1(this, looper);
        this.f38573b = lock.newCondition();
        this.f38582l = new v0(this);
    }

    public final void W(@NonNull ConnectionResult connectionResult, @NonNull a aVar, boolean z10) {
        this.f38572a.lock();
        try {
            this.f38582l.d(connectionResult, aVar, z10);
        } finally {
            this.f38572a.unlock();
        }
    }

    public final void a() {
        this.f38582l.c();
    }

    public final void b() {
        if (this.f38582l instanceof h0) {
            ((h0) this.f38582l).j();
        }
    }

    public final void c(Bundle bundle) {
        this.f38572a.lock();
        try {
            this.f38582l.a(bundle);
        } finally {
            this.f38572a.unlock();
        }
    }

    public final void d() {
    }

    public final void e() {
        if (this.f38582l.g()) {
            this.f38578g.clear();
        }
    }

    public final void f(int i10) {
        this.f38572a.lock();
        try {
            this.f38582l.e(i10);
        } finally {
            this.f38572a.unlock();
        }
    }

    public final boolean g(r rVar) {
        return false;
    }

    public final void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f38582l);
        for (a aVar : this.f38580j.keySet()) {
            printWriter.append(str).append(aVar.d()).println(CertificateUtil.DELIMITER);
            ((a.f) p.k((a.f) this.f38577f.get(aVar.b()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean i() {
        return this.f38582l instanceof u0;
    }

    public final d j(@NonNull d dVar) {
        dVar.zak();
        this.f38582l.f(dVar);
        return dVar;
    }

    public final boolean k() {
        return this.f38582l instanceof h0;
    }

    public final d l(@NonNull d dVar) {
        dVar.zak();
        return this.f38582l.h(dVar);
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        this.f38572a.lock();
        try {
            this.f38585p.A();
            this.f38582l = new h0(this);
            this.f38582l.b();
            this.f38573b.signalAll();
        } finally {
            this.f38572a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        this.f38572a.lock();
        try {
            this.f38582l = new u0(this, this.f38579h, this.f38580j, this.f38575d, this.f38581k, this.f38572a, this.f38574c);
            this.f38582l.b();
            this.f38573b.signalAll();
        } finally {
            this.f38572a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(ConnectionResult connectionResult) {
        this.f38572a.lock();
        try {
            this.f38583m = connectionResult;
            this.f38582l = new v0(this);
            this.f38582l.b();
            this.f38573b.signalAll();
        } finally {
            this.f38572a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void r(b1 b1Var) {
        this.f38576e.sendMessage(this.f38576e.obtainMessage(1, b1Var));
    }

    /* access modifiers changed from: package-private */
    public final void s(RuntimeException runtimeException) {
        this.f38576e.sendMessage(this.f38576e.obtainMessage(2, runtimeException));
    }
}

package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class d3 extends i3 {

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray f38590e = new SparseArray();

    private d3(j jVar) {
        super(jVar, c.p());
        this.mLifecycleFragment.p("AutoManageHelper", this);
    }

    public static d3 i(i iVar) {
        j fragment = LifecycleCallback.getFragment(iVar);
        d3 d3Var = (d3) fragment.y("AutoManageHelper", d3.class);
        if (d3Var != null) {
            return d3Var;
        }
        return new d3(fragment);
    }

    private final c3 l(int i10) {
        if (this.f38590e.size() <= i10) {
            return null;
        }
        SparseArray sparseArray = this.f38590e;
        return (c3) sparseArray.get(sparseArray.keyAt(i10));
    }

    /* access modifiers changed from: protected */
    public final void b(ConnectionResult connectionResult, int i10) {
        if (i10 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        c3 c3Var = (c3) this.f38590e.get(i10);
        if (c3Var != null) {
            k(i10);
            d.c cVar = c3Var.f38568c;
            if (cVar != null) {
                cVar.g(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        for (int i10 = 0; i10 < this.f38590e.size(); i10++) {
            c3 l10 = l(i10);
            if (l10 != null) {
                l10.f38567b.d();
            }
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i10 = 0; i10 < this.f38590e.size(); i10++) {
            c3 l10 = l(i10);
            if (l10 != null) {
                printWriter.append(str).append("GoogleApiClient #").print(l10.f38566a);
                printWriter.println(CertificateUtil.DELIMITER);
                l10.f38567b.f(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void j(int i10, d dVar, d.c cVar) {
        boolean z10;
        p.l(dVar, "GoogleApiClient instance cannot be null");
        if (this.f38590e.indexOfKey(i10) < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, "Already managing a GoogleApiClient with id " + i10);
        f3 f3Var = (f3) this.f38640b.get();
        boolean z11 = this.f38639a;
        String valueOf = String.valueOf(f3Var);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("starting AutoManage for client ");
        sb2.append(i10);
        sb2.append(" ");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(valueOf);
        c3 c3Var = new c3(this, i10, dVar, cVar);
        dVar.q(c3Var);
        this.f38590e.put(i10, c3Var);
        if (this.f38639a && f3Var == null) {
            "connecting ".concat(dVar.toString());
            dVar.d();
        }
    }

    public final void k(int i10) {
        c3 c3Var = (c3) this.f38590e.get(i10);
        this.f38590e.remove(i10);
        if (c3Var != null) {
            c3Var.f38567b.r(c3Var);
            c3Var.f38567b.e();
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z10 = this.f38639a;
        String valueOf = String.valueOf(this.f38590e);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStart ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append(valueOf);
        if (this.f38640b.get() == null) {
            for (int i10 = 0; i10 < this.f38590e.size(); i10++) {
                c3 l10 = l(i10);
                if (l10 != null) {
                    l10.f38567b.d();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i10 = 0; i10 < this.f38590e.size(); i10++) {
            c3 l10 = l(i10);
            if (l10 != null) {
                l10.f38567b.e();
            }
        }
    }
}

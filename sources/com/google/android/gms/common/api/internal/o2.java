package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import ye.e;
import ye.f;
import ze.a;

public final class o2 extends a implements d.b, d.c {

    /* renamed from: h  reason: collision with root package name */
    private static final a.C0480a f38705h = e.f42178c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f38706a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f38707b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0480a f38708c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f38709d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.common.internal.e f38710e;

    /* renamed from: f  reason: collision with root package name */
    private f f38711f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public n2 f38712g;

    public o2(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.e eVar) {
        a.C0480a aVar = f38705h;
        this.f38706a = context;
        this.f38707b = handler;
        this.f38710e = (com.google.android.gms.common.internal.e) p.l(eVar, "ClientSettings must not be null");
        this.f38709d = eVar.g();
        this.f38708c = aVar;
    }

    static /* bridge */ /* synthetic */ void w0(o2 o2Var, zak zak) {
        ConnectionResult S = zak.S();
        if (S.i0()) {
            zav zav = (zav) p.k(zak.Y());
            ConnectionResult S2 = zav.S();
            if (!S2.i0()) {
                String valueOf = String.valueOf(S2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                o2Var.f38712g.c(S2);
                o2Var.f38711f.disconnect();
                return;
            }
            o2Var.f38712g.b(zav.Y(), o2Var.f38709d);
        } else {
            o2Var.f38712g.c(S);
        }
        o2Var.f38711f.disconnect();
    }

    public final void c(Bundle bundle) {
        this.f38711f.c(this);
    }

    public final void f(int i10) {
        this.f38711f.disconnect();
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        this.f38712g.c(connectionResult);
    }

    public final void n(zak zak) {
        this.f38707b.post(new m2(this, zak));
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, ye.f] */
    public final void x0(n2 n2Var) {
        f fVar = this.f38711f;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.f38710e.l(Integer.valueOf(System.identityHashCode(this)));
        a.C0480a aVar = this.f38708c;
        Context context = this.f38706a;
        Looper looper = this.f38707b.getLooper();
        com.google.android.gms.common.internal.e eVar = this.f38710e;
        this.f38711f = aVar.buildClient(context, looper, eVar, eVar.h(), (d.b) this, (d.c) this);
        this.f38712g = n2Var;
        Set set = this.f38709d;
        if (set == null || set.isEmpty()) {
            this.f38707b.post(new l2(this));
        } else {
            this.f38711f.b();
        }
    }

    public final void y0() {
        f fVar = this.f38711f;
        if (fVar != null) {
            fVar.disconnect();
        }
    }
}

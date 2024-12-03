package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.i;
import java.util.Set;

final class p1 implements d.c, n2 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a.f f38725a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f38726b;

    /* renamed from: c  reason: collision with root package name */
    private i f38727c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f38728d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f38729e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g f38730f;

    public p1(g gVar, a.f fVar, b bVar) {
        this.f38730f = gVar;
        this.f38725a = fVar;
        this.f38726b = bVar;
    }

    /* access modifiers changed from: private */
    public final void h() {
        i iVar;
        if (this.f38729e && (iVar = this.f38727c) != null) {
            this.f38725a.getRemoteService(iVar, this.f38728d);
        }
    }

    public final void a(@NonNull ConnectionResult connectionResult) {
        this.f38730f.f38623p.post(new o1(this, connectionResult));
    }

    public final void b(i iVar, Set set) {
        if (iVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new ConnectionResult(4));
            return;
        }
        this.f38727c = iVar;
        this.f38728d = set;
        h();
    }

    public final void c(ConnectionResult connectionResult) {
        l1 l1Var = (l1) this.f38730f.f38619l.get(this.f38726b);
        if (l1Var != null) {
            l1Var.I(connectionResult);
        }
    }
}

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class h1 extends s0 {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ d f39006g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(d dVar, int i10, Bundle bundle) {
        super(dVar, i10, (Bundle) null);
        this.f39006g = dVar;
    }

    /* access modifiers changed from: protected */
    public final void f(ConnectionResult connectionResult) {
        if (!this.f39006g.enableLocalFallback() || !d.zzo(this.f39006g)) {
            this.f39006g.zzc.a(connectionResult);
            this.f39006g.onConnectionFailed(connectionResult);
            return;
        }
        d.zzk(this.f39006g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.f39006g.zzc.a(ConnectionResult.f38485e);
        return true;
    }
}

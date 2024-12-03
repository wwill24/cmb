package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.p;

public final class m3 implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    public final a f38690a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38691b;

    /* renamed from: c  reason: collision with root package name */
    private n3 f38692c;

    public m3(a aVar, boolean z10) {
        this.f38690a = aVar;
        this.f38691b = z10;
    }

    private final n3 b() {
        p.l(this.f38692c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f38692c;
    }

    public final void a(n3 n3Var) {
        this.f38692c = n3Var;
    }

    public final void c(Bundle bundle) {
        b().c(bundle);
    }

    public final void f(int i10) {
        b().f(i10);
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        b().W(connectionResult, this.f38690a, this.f38691b);
    }
}

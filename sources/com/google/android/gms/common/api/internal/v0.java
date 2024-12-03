package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class v0 implements a1 {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final d1 f38788a;

    public v0(d1 d1Var) {
        this.f38788a = d1Var;
    }

    public final void a(Bundle bundle) {
    }

    public final void b() {
        for (a.f disconnect : this.f38788a.f38577f.values()) {
            disconnect.disconnect();
        }
        this.f38788a.f38585p.f38843p = Collections.emptySet();
    }

    public final void c() {
        this.f38788a.p();
    }

    public final void d(ConnectionResult connectionResult, a aVar, boolean z10) {
    }

    public final void e(int i10) {
    }

    public final d f(d dVar) {
        this.f38788a.f38585p.f38835h.add(dVar);
        return dVar;
    }

    public final boolean g() {
        return true;
    }

    public final d h(d dVar) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}

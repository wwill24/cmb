package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.p;

public final class c0 extends i3 {

    /* renamed from: e  reason: collision with root package name */
    private final b f38560e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final g f38561f;

    c0(j jVar, g gVar, c cVar) {
        super(jVar, cVar);
        this.f38561f = gVar;
        this.mLifecycleFragment.p("ConnectionlessLifecycleHelper", this);
    }

    public static void j(Activity activity, g gVar, b bVar) {
        j fragment = LifecycleCallback.getFragment(activity);
        c0 c0Var = (c0) fragment.y("ConnectionlessLifecycleHelper", c0.class);
        if (c0Var == null) {
            c0Var = new c0(fragment, gVar, c.p());
        }
        p.l(bVar, "ApiKey cannot be null");
        c0Var.f38560e.add(bVar);
        gVar.d(c0Var);
    }

    private final void k() {
        if (!this.f38560e.isEmpty()) {
            this.f38561f.d(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(ConnectionResult connectionResult, int i10) {
        this.f38561f.K(connectionResult, i10);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        this.f38561f.b();
    }

    /* access modifiers changed from: package-private */
    public final b i() {
        return this.f38560e;
    }

    public final void onResume() {
        super.onResume();
        k();
    }

    public final void onStart() {
        super.onStart();
        k();
    }

    public final void onStop() {
        super.onStop();
        this.f38561f.e(this);
    }
}

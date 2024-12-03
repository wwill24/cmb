package com.coffeemeetsbagel.store;

import android.content.Context;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import fj.d;
import fj.g;
import fk.a;

public final class t0 implements d<CmbBillingClient> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f36997a;

    public t0(a<Context> aVar) {
        this.f36997a = aVar;
    }

    public static CmbBillingClient a(Context context) {
        return (CmbBillingClient) g.e(s0.f36931a.a(context));
    }

    public static t0 b(a<Context> aVar) {
        return new t0(aVar);
    }

    /* renamed from: c */
    public CmbBillingClient get() {
        return a(this.f36997a.get());
    }
}

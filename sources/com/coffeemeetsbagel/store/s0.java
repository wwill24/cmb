package com.coffeemeetsbagel.store;

import android.content.Context;
import c7.d;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import kotlin.jvm.internal.j;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s0 f36931a = new s0();

    private s0() {
    }

    public final CmbBillingClient a(Context context) {
        j.g(context, "applicationContext");
        return new CmbBillingClient(context);
    }

    public final i0 b(d dVar) {
        j.g(dVar, "retrofit");
        Object c10 = dVar.c(i0.class);
        j.f(c10, "retrofit.getApiService(PriceService::class.java)");
        return (i0) c10;
    }
}

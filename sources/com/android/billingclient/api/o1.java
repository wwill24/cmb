package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

final class o1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8992a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final n1 f8993b;

    o1(Context context, x0 x0Var, y0 y0Var) {
        this.f8992a = context;
        this.f8993b = new n1(this, (x0) null, y0Var, (m1) null);
    }

    /* access modifiers changed from: package-private */
    public final x0 b() {
        x0 unused = this.f8993b.f8954b;
        return null;
    }

    /* access modifiers changed from: package-private */
    public final s c() {
        return this.f8993b.f8953a;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f8993b.c(this.f8992a, intentFilter);
    }

    o1(Context context, s sVar, c cVar, y0 y0Var) {
        this.f8992a = context;
        this.f8993b = new n1(this, sVar, cVar, y0Var, (m1) null);
    }
}

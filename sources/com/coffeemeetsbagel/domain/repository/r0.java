package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.google_play.CmbBillingClient;
import fj.d;
import fk.a;
import hb.c;

public final class r0 implements d<SkuDetailsRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbBillingClient> f12564a;

    /* renamed from: b  reason: collision with root package name */
    private final a<UserRepository> f12565b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f12566c;

    public r0(a<CmbBillingClient> aVar, a<UserRepository> aVar2, a<c> aVar3) {
        this.f12564a = aVar;
        this.f12565b = aVar2;
        this.f12566c = aVar3;
    }

    public static r0 a(a<CmbBillingClient> aVar, a<UserRepository> aVar2, a<c> aVar3) {
        return new r0(aVar, aVar2, aVar3);
    }

    public static SkuDetailsRepository c(CmbBillingClient cmbBillingClient, UserRepository userRepository, c cVar) {
        return new SkuDetailsRepository(cmbBillingClient, userRepository, cVar);
    }

    /* renamed from: b */
    public SkuDetailsRepository get() {
        return c(this.f12564a.get(), this.f12565b.get(), this.f12566c.get());
    }
}

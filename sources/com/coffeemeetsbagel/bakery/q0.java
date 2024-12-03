package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseApi;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.store.PriceRepository;
import fj.d;
import fj.g;
import fk.a;

public final class q0 implements d<PurchaseManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PriceRepository> f11362a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileManager> f11363b;

    /* renamed from: c  reason: collision with root package name */
    private final a<a7.a> f11364c;

    /* renamed from: d  reason: collision with root package name */
    private final a<PurchaseApi> f11365d;

    /* renamed from: e  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11366e;

    public q0(a<PriceRepository> aVar, a<ProfileManager> aVar2, a<a7.a> aVar3, a<PurchaseApi> aVar4, a<AuthenticationScopeProvider> aVar5) {
        this.f11362a = aVar;
        this.f11363b = aVar2;
        this.f11364c = aVar3;
        this.f11365d = aVar4;
        this.f11366e = aVar5;
    }

    public static q0 a(a<PriceRepository> aVar, a<ProfileManager> aVar2, a<a7.a> aVar3, a<PurchaseApi> aVar4, a<AuthenticationScopeProvider> aVar5) {
        return new q0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static PurchaseManager c(PriceRepository priceRepository, ProfileManager profileManager, a7.a aVar, PurchaseApi purchaseApi, AuthenticationScopeProvider authenticationScopeProvider) {
        return (PurchaseManager) g.e(c.O(priceRepository, profileManager, aVar, purchaseApi, authenticationScopeProvider));
    }

    /* renamed from: b */
    public PurchaseManager get() {
        return c(this.f11362a.get(), this.f11363b.get(), this.f11364c.get(), this.f11365d.get(), this.f11366e.get());
    }
}

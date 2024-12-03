package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.store.PriceRepository;
import fj.d;
import fk.a;

public final class PurchaseManager_Factory implements d<PurchaseManager> {
    private final a<a7.a> analyticsManagerProvider;
    private final a<AuthenticationScopeProvider> authenticationScopeProvider;
    private final a<PriceRepository> priceRepositoryProvider;
    private final a<ProfileManager> profileManagerProvider;
    private final a<PurchaseApi> purchaseApiProvider;

    public PurchaseManager_Factory(a<PriceRepository> aVar, a<ProfileManager> aVar2, a<a7.a> aVar3, a<PurchaseApi> aVar4, a<AuthenticationScopeProvider> aVar5) {
        this.priceRepositoryProvider = aVar;
        this.profileManagerProvider = aVar2;
        this.analyticsManagerProvider = aVar3;
        this.purchaseApiProvider = aVar4;
        this.authenticationScopeProvider = aVar5;
    }

    public static PurchaseManager_Factory create(a<PriceRepository> aVar, a<ProfileManager> aVar2, a<a7.a> aVar3, a<PurchaseApi> aVar4, a<AuthenticationScopeProvider> aVar5) {
        return new PurchaseManager_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static PurchaseManager newInstance(PriceRepository priceRepository, ProfileManager profileManager, a7.a aVar, PurchaseApi purchaseApi, AuthenticationScopeProvider authenticationScopeProvider2) {
        return new PurchaseManager(priceRepository, profileManager, aVar, purchaseApi, authenticationScopeProvider2);
    }

    public PurchaseManager get() {
        return newInstance(this.priceRepositoryProvider.get(), this.profileManagerProvider.get(), this.analyticsManagerProvider.get(), this.purchaseApiProvider.get(), this.authenticationScopeProvider.get());
    }
}

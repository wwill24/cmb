package com.coffeemeetsbagel.feature.sync;

import com.coffeemeetsbagel.domain.repository.SkuDetailsRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import fj.d;
import fk.a;
import ma.c;

public final class p implements d<SyncBillingUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SkuDetailsRepository> f13449a;

    /* renamed from: b  reason: collision with root package name */
    private final a<CmbBillingClient> f13450b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f13451c;

    /* renamed from: d  reason: collision with root package name */
    private final a<SubscriptionRepository> f13452d;

    /* renamed from: e  reason: collision with root package name */
    private final a<a7.a> f13453e;

    /* renamed from: f  reason: collision with root package name */
    private final a<FeatureFlagRepository> f13454f;

    public p(a<SkuDetailsRepository> aVar, a<CmbBillingClient> aVar2, a<c> aVar3, a<SubscriptionRepository> aVar4, a<a7.a> aVar5, a<FeatureFlagRepository> aVar6) {
        this.f13449a = aVar;
        this.f13450b = aVar2;
        this.f13451c = aVar3;
        this.f13452d = aVar4;
        this.f13453e = aVar5;
        this.f13454f = aVar6;
    }

    public static p a(a<SkuDetailsRepository> aVar, a<CmbBillingClient> aVar2, a<c> aVar3, a<SubscriptionRepository> aVar4, a<a7.a> aVar5, a<FeatureFlagRepository> aVar6) {
        return new p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static SyncBillingUseCase c(SkuDetailsRepository skuDetailsRepository, CmbBillingClient cmbBillingClient, c cVar, SubscriptionRepository subscriptionRepository, a7.a aVar, FeatureFlagRepository featureFlagRepository) {
        return new SyncBillingUseCase(skuDetailsRepository, cmbBillingClient, cVar, subscriptionRepository, aVar, featureFlagRepository);
    }

    /* renamed from: b */
    public SyncBillingUseCase get() {
        return c(this.f13449a.get(), this.f13450b.get(), this.f13451c.get(), this.f13452d.get(), this.f13453e.get(), this.f13454f.get());
    }
}

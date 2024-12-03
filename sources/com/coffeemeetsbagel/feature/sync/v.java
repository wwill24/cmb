package com.coffeemeetsbagel.feature.sync;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import fj.d;
import fk.a;

public final class v implements d<SyncSubscriptionHistoryUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbBillingClient> f13458a;

    /* renamed from: b  reason: collision with root package name */
    private final a<UserRepository> f13459b;

    public v(a<CmbBillingClient> aVar, a<UserRepository> aVar2) {
        this.f13458a = aVar;
        this.f13459b = aVar2;
    }

    public static v a(a<CmbBillingClient> aVar, a<UserRepository> aVar2) {
        return new v(aVar, aVar2);
    }

    public static SyncSubscriptionHistoryUseCase c(CmbBillingClient cmbBillingClient, UserRepository userRepository) {
        return new SyncSubscriptionHistoryUseCase(cmbBillingClient, userRepository);
    }

    /* renamed from: b */
    public SyncSubscriptionHistoryUseCase get() {
        return c(this.f13458a.get(), this.f13459b.get());
    }
}

package com.coffeemeetsbagel.boost;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.store.alc.d;
import kotlin.jvm.internal.j;
import m1.a;

public final class i extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private PurchaseManager f11463i;

    /* renamed from: j  reason: collision with root package name */
    private ProfileManager f11464j;

    /* renamed from: k  reason: collision with root package name */
    private d f11465k;

    /* renamed from: l  reason: collision with root package name */
    private SubscriptionRepository f11466l;

    public i(PurchaseManager purchaseManager, ProfileManager profileManager, d dVar, SubscriptionRepository subscriptionRepository) {
        j.g(purchaseManager, "purchaseManager");
        j.g(profileManager, "profileManager");
        j.g(dVar, "purchaseItemUseCase");
        j.g(subscriptionRepository, "subscriptionRepository");
        this.f11463i = purchaseManager;
        this.f11464j = profileManager;
        this.f11465k = dVar;
        this.f11466l = subscriptionRepository;
    }

    public <T extends f0> T b(Class<T> cls, a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new BoostViewModel(this.f11463i, this.f11464j, this.f11465k, this.f11466l);
    }
}

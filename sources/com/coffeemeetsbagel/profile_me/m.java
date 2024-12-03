package com.coffeemeetsbagel.profile_me;

import a7.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import kotlin.jvm.internal.j;
import wb.c;

public final class m extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private PurchaseManager f36198i;

    /* renamed from: j  reason: collision with root package name */
    private a f36199j;

    /* renamed from: k  reason: collision with root package name */
    private GetMyOwnProfileLocalUseCase f36200k;

    /* renamed from: l  reason: collision with root package name */
    private c f36201l;

    public m(PurchaseManager purchaseManager, a aVar, GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, c cVar) {
        j.g(purchaseManager, "purchaseManager");
        j.g(aVar, "analyticsManager");
        j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileLocalUseCase");
        j.g(cVar, "getActiveSubscriptionUseCase");
        this.f36198i = purchaseManager;
        this.f36199j = aVar;
        this.f36200k = getMyOwnProfileLocalUseCase;
        this.f36201l = cVar;
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new MeProfileViewModel(this.f36198i, this.f36199j, this.f36200k, this.f36201l);
    }
}

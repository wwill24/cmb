package com.coffeemeetsbagel.store.subscription_benefits;

import a7.a;
import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellInteractor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import vb.b;
import vb.c;

public final class g extends s<j, SubscriptionBenefitsRouter> implements k {

    /* renamed from: f  reason: collision with root package name */
    private final List<b> f36943f;

    /* renamed from: g  reason: collision with root package name */
    private final PremiumUpsellInteractor.a f36944g;

    /* renamed from: h  reason: collision with root package name */
    private final c f36945h;

    /* renamed from: j  reason: collision with root package name */
    private final SubscriptionBenefitAttribution f36946j;

    /* renamed from: k  reason: collision with root package name */
    private final String f36947k = "SubscriptionBenefitsInteractor";

    /* renamed from: l  reason: collision with root package name */
    private final b f36948l = new b("default", q.j(), "Members get up to 2x as many quality matches and dates.", "", "", "Double the dates", "Double the dates");

    /* renamed from: m  reason: collision with root package name */
    public a f36949m;

    /* renamed from: n  reason: collision with root package name */
    public SubscriptionRepository f36950n;

    /* renamed from: p  reason: collision with root package name */
    public PremiumUpsellAnalytics f36951p;

    public g(PurchaseSource purchaseSource, List<b> list, PremiumUpsellInteractor.a aVar, c cVar) {
        j.g(purchaseSource, "purchaseSource");
        j.g(list, "defaultBenefits");
        j.g(aVar, "parentListener");
        j.g(cVar, "bundle");
        this.f36943f = list;
        this.f36944g = aVar;
        this.f36945h = cVar;
        this.f36946j = SubscriptionBenefitAttribution.f36723a.a(purchaseSource);
    }

    private final void J1(List<b> list) {
        if (list.isEmpty()) {
            H1().d("Subscription - Default benefits displayed");
            list = this.f36943f;
        }
        K1(list, this.f36946j);
    }

    private final void K1(List<b> list, SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        b bVar;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = -1;
        for (T next : list) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            b bVar2 = (b) next;
            if (bVar2.a().contains(subscriptionBenefitAttribution.c())) {
                i11 = i10;
            } else {
                arrayList.add(bVar2);
            }
            i10 = i12;
        }
        if (i11 > -1) {
            bVar = list.get(i11);
        } else {
            bVar = this.f36948l;
        }
        ((j) this.f7875e).l(bVar, arrayList);
    }

    public final a H1() {
        a aVar = this.f36949m;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final PremiumUpsellAnalytics I1() {
        PremiumUpsellAnalytics premiumUpsellAnalytics = this.f36951p;
        if (premiumUpsellAnalytics != null) {
            return premiumUpsellAnalytics;
        }
        j.y("tracker");
        return null;
    }

    public void j0() {
        this.f36944g.a();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        I1().m(PremiumUpsellAnalytics.DropOffPoint.SUBSCRIPTION_BENEFITS);
        fa.a.f40771d.a(this.f36947k, "didBecomeActive()");
        if (!this.f36945h.a().isEmpty()) {
            J1(this.f36945h.a());
        } else {
            J1(this.f36943f);
        }
    }
}

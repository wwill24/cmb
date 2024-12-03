package com.coffeemeetsbagel.feature.sync;

import a7.a;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.domain.repository.SkuDetailsRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import com.coffeemeetsbagel.models.BeansPurchaseRedemptionData;
import gk.h;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.c;
import qj.f;

public final class SyncBillingUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final SkuDetailsRepository f13406a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final CmbBillingClient f13407b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f13408c;

    /* renamed from: d  reason: collision with root package name */
    private final SubscriptionRepository f13409d;

    /* renamed from: e  reason: collision with root package name */
    private final a f13410e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final FeatureFlagRepository f13411f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f13412g;

    public SyncBillingUseCase(SkuDetailsRepository skuDetailsRepository, CmbBillingClient cmbBillingClient, c cVar, SubscriptionRepository subscriptionRepository, a aVar, FeatureFlagRepository featureFlagRepository) {
        j.g(skuDetailsRepository, "skuDetailsRepository");
        j.g(cmbBillingClient, "billingClient");
        j.g(cVar, "beansService");
        j.g(subscriptionRepository, "subscriptionRepository");
        j.g(aVar, "analyticsManager");
        j.g(featureFlagRepository, "featureFlagRepository");
        this.f13406a = skuDetailsRepository;
        this.f13407b = cmbBillingClient;
        this.f13408c = cVar;
        this.f13409d = subscriptionRepository;
        this.f13410e = aVar;
        this.f13411f = featureFlagRepository;
        String simpleName = SyncBillingUseCase.class.getSimpleName();
        j.f(simpleName, "SyncBillingUseCase::class.java.simpleName");
        this.f13412g = simpleName;
    }

    private final qj.a A() {
        qj.a C = this.f13406a.i().B().C(new o(new SyncBillingUseCase$refreshInAppPrices$1(this)));
        j.f(C, "private fun refreshInApp…ete()\n            }\n    }");
        return C;
    }

    /* access modifiers changed from: private */
    public static final f B(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    private final qj.a C() {
        qj.a C = this.f13409d.C0(false).C(new k(new SyncBillingUseCase$refreshSubscriptions$1(this)));
        j.f(C, "private fun refreshSubsc…ete()\n            }\n    }");
        return C;
    }

    /* access modifiers changed from: private */
    public static final f D(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void E(BeansPurchaseRedemptionData beansPurchaseRedemptionData) {
        this.f13410e.trackEvent("redemption code redeemed", h0.l(h.a("redemption_code", beansPurchaseRedemptionData.getRedemption_code_identifier()), h.a("sku", beansPurchaseRedemptionData.getSku())));
    }

    private final qj.a p() {
        qj.a C = this.f13407b.X("subs").z(new l(SyncBillingUseCase$acknowledgeUnacknowledged$1.f13413a)).O(new m(new SyncBillingUseCase$acknowledgeUnacknowledged$2(this))).C(new n(new SyncBillingUseCase$acknowledgeUnacknowledged$3(this)));
        j.f(C, "private fun acknowledgeU…ete()\n            }\n    }");
        return C;
    }

    /* access modifiers changed from: private */
    public static final Iterable q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Iterable) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f r(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    private final qj.a t() {
        qj.a C = this.f13407b.X("inapp").z(new h(SyncBillingUseCase$consumeUnconsumed$1.f13414a)).O(new i(new SyncBillingUseCase$consumeUnconsumed$2(this))).C(new j(new SyncBillingUseCase$consumeUnconsumed$3(this)));
        j.f(C, "private fun consumeUncon…ete()\n            }\n    }");
        return C;
    }

    /* access modifiers changed from: private */
    public static final Iterable u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Iterable) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void z(SyncBillingUseCase syncBillingUseCase) {
        j.g(syncBillingUseCase, "this$0");
        fa.a.f40771d.a(syncBillingUseCase.f13412g, "Billing sync complete.");
        g1.d("billing_sync");
    }

    public final qj.a x() {
        qj.a F = A().b(t()).b(p()).b(C()).t(new f(new SyncBillingUseCase$invoke$1(this))).q(new g(this)).F(dk.a.c());
        j.f(F, "operator fun invoke(): C…On(Schedulers.io())\n    }");
        return F;
    }
}

package com.coffeemeetsbagel.domain.repository;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.o;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import com.coffeemeetsbagel.store.w0;
import com.coffeemeetsbagel.subscription.network.models.NetworkActiveSubscription;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant;
import com.coffeemeetsbagel.subscription.network.models.SubscriptionResponseData;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.jakewharton.rxrelay2.PublishRelay;
import fa.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.MissingResourceException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ma.j;
import pk.n;
import qj.b0;
import qj.f;
import qj.h;
import qj.q;
import qj.w;
import u6.o;
import u6.p;
import vb.d;

public final class SubscriptionRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CmbBillingClient f12427a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final j f12428b;

    /* renamed from: c  reason: collision with root package name */
    private final u6.b f12429c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final u6.c f12430d;

    /* renamed from: e  reason: collision with root package name */
    private final p f12431e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final o f12432f;

    /* renamed from: g  reason: collision with root package name */
    private final UserRepository f12433g;

    /* renamed from: h  reason: collision with root package name */
    private final hb.c f12434h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final long f12435i = 14400000;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f12436j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final HashMap<String, com.android.billingclient.api.o> f12437k;

    /* renamed from: l  reason: collision with root package name */
    private final PublishRelay<a> f12438l;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f12439a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12440b;

        public a(String str, boolean z10) {
            kotlin.jvm.internal.j.g(str, "sku");
            this.f12439a = str;
            this.f12440b = z10;
        }

        public final String a() {
            return this.f12439a;
        }

        public final boolean b() {
            return this.f12440b;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f12439a, ((a) obj).f12439a);
        }

        public int hashCode() {
            return Integer.parseInt(this.f12439a);
        }
    }

    public static final class b<T> implements Comparator {
        public final int compare(T t10, T t11) {
            return b.a(Integer.valueOf(((NetworkSubscriptionBundleVariant) t10).getNumberOfUnits()), Integer.valueOf(((NetworkSubscriptionBundleVariant) t11).getNumberOfUnits()));
        }
    }

    public static final class c<T> implements Comparator {
        public final int compare(T t10, T t11) {
            return b.a(Integer.valueOf(((NetworkSubscriptionBundleVariant) t10).getNumberOfUnits()), Integer.valueOf(((NetworkSubscriptionBundleVariant) t11).getNumberOfUnits()));
        }
    }

    public SubscriptionRepository(CmbBillingClient cmbBillingClient, j jVar, u6.b bVar, u6.c cVar, p pVar, o oVar, UserRepository userRepository, hb.c cVar2) {
        kotlin.jvm.internal.j.g(cmbBillingClient, "billingClient");
        kotlin.jvm.internal.j.g(jVar, "network");
        kotlin.jvm.internal.j.g(bVar, "activeSubscriptionDao");
        kotlin.jvm.internal.j.g(cVar, "benefitDao");
        kotlin.jvm.internal.j.g(pVar, "subscriptionVariantsDao");
        kotlin.jvm.internal.j.g(oVar, "subscriptionBundlesDao");
        kotlin.jvm.internal.j.g(userRepository, "userRepository");
        kotlin.jvm.internal.j.g(cVar2, "sharedPrefsMan");
        this.f12427a = cmbBillingClient;
        this.f12428b = jVar;
        this.f12429c = bVar;
        this.f12430d = cVar;
        this.f12431e = pVar;
        this.f12432f = oVar;
        this.f12433g = userRepository;
        this.f12434h = cVar2;
        String simpleName = SubscriptionRepository.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "SubscriptionRepository::class.java.simpleName");
        this.f12436j = simpleName;
        this.f12437k = new HashMap<>();
        PublishRelay<a> C0 = PublishRelay.C0();
        kotlin.jvm.internal.j.f(C0, "create<PurchaseFlow>()");
        this.f12438l = C0;
    }

    /* access modifiers changed from: private */
    public static final b0 A0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void B0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f D0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    private final qj.a E0(boolean z10, SubscriptionResponseData subscriptionResponseData) {
        w<R> wVar;
        if (z10) {
            wVar = w.C(Boolean.TRUE);
        } else {
            wVar = this.f12430d.c().D(new l1(new SubscriptionRepository$updateBenefits$1(this)));
        }
        qj.a w10 = wVar.w(new m1(new SubscriptionRepository$updateBenefits$2(this, subscriptionResponseData)));
        kotlin.jvm.internal.j.f(w10, "private fun updateBenefi…    }\n            }\n    }");
        return w10;
    }

    /* access modifiers changed from: private */
    public static final Boolean F0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f G0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    private final qj.a H0(SubscriptionResponseData subscriptionResponseData) {
        qj.a w10 = this.f12430d.a().L().D(new p1(new SubscriptionRepository$updateBundles$1(subscriptionResponseData))).w(new q1(new SubscriptionRepository$updateBundles$2(this)));
        kotlin.jvm.internal.j.f(w10, "private fun updateBundle…sertAll(entities) }\n    }");
        return w10;
    }

    /* access modifiers changed from: private */
    public static final List I0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f J0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    private final qj.a K0(SubscriptionResponseData subscriptionResponseData) {
        List<NetworkSubscriptionBundle> subscriptionBundles = subscriptionResponseData.getSubscriptionBundles();
        ArrayList arrayList = new ArrayList(r.t(subscriptionBundles, 10));
        for (NetworkSubscriptionBundle variants : subscriptionBundles) {
            arrayList.add(variants.getVariants());
        }
        List<NetworkSubscriptionBundleVariant> u10 = r.u(arrayList);
        ArrayList arrayList2 = new ArrayList(r.t(u10, 10));
        for (NetworkSubscriptionBundleVariant sku : u10) {
            arrayList2.add(sku.getSku());
        }
        return O(arrayList2);
    }

    private final qj.a L0(NetworkActiveSubscription networkActiveSubscription) {
        ActiveSubscriptionEntity activeSubscriptionEntity;
        if (networkActiveSubscription != null) {
            activeSubscriptionEntity = com.coffeemeetsbagel.store.a.f36745a.b(networkActiveSubscription);
        } else {
            activeSubscriptionEntity = null;
        }
        return this.f12429c.a(activeSubscriptionEntity);
    }

    private final qj.a M0(SubscriptionResponseData subscriptionResponseData) {
        SubscriptionEntity subscriptionEntity;
        List<NetworkSubscriptionBundle> subscriptionBundles = subscriptionResponseData.getSubscriptionBundles();
        ArrayList arrayList = new ArrayList(r.t(subscriptionBundles, 10));
        for (NetworkSubscriptionBundle networkSubscriptionBundle : subscriptionBundles) {
            String f02 = f0(networkSubscriptionBundle);
            List<NetworkSubscriptionBundleVariant> variants = networkSubscriptionBundle.getVariants();
            ArrayList arrayList2 = new ArrayList(r.t(variants, 10));
            for (NetworkSubscriptionBundleVariant networkSubscriptionBundleVariant : variants) {
                if (kotlin.jvm.internal.j.b(f02, networkSubscriptionBundleVariant.getSku())) {
                    subscriptionEntity = w0.f37004a.c(networkSubscriptionBundle.getId(), networkSubscriptionBundleVariant, (String) null);
                } else {
                    subscriptionEntity = w0.f37004a.c(networkSubscriptionBundle.getId(), networkSubscriptionBundleVariant, f02);
                }
                arrayList2.add(subscriptionEntity);
            }
            arrayList.add(arrayList2);
        }
        return this.f12431e.c(r.u(arrayList));
    }

    /* access modifiers changed from: private */
    public final qj.a O(List<String> list) {
        Collection<com.android.billingclient.api.o> values = this.f12437k.values();
        kotlin.jvm.internal.j.f(values, "skuDetailsCache.values");
        ArrayList arrayList = new ArrayList(r.t(values, 10));
        for (com.android.billingclient.api.o b10 : values) {
            arrayList.add(b10.b());
        }
        if (arrayList.containsAll(list)) {
            qj.a m10 = qj.a.m();
            kotlin.jvm.internal.j.f(m10, "{\n            Completable.complete()\n        }");
            return m10;
        }
        qj.a B = this.f12427a.R(list, "subs").r(new t0(new SubscriptionRepository$cacheSubscriptionPriceMicros$1(this))).p(new u0(new SubscriptionRepository$cacheSubscriptionPriceMicros$2(this, list))).B();
        kotlin.jvm.internal.j.f(B, "private fun cacheSubscri…is ready.\n        }\n    }");
        return B;
    }

    /* access modifiers changed from: private */
    public static final void P(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final RewardPrice R(SubscriptionEntity subscriptionEntity) {
        List<o.d> d10;
        o.d dVar;
        o.c b10;
        List<o.b> a10;
        o.b bVar;
        Collection<com.android.billingclient.api.o> values = this.f12437k.values();
        kotlin.jvm.internal.j.f(values, "skuDetailsCache.values");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(values, 10)), 16));
        for (T next : values) {
            linkedHashMap.put(((com.android.billingclient.api.o) next).b(), next);
        }
        com.android.billingclient.api.o oVar = (com.android.billingclient.api.o) linkedHashMap.get(subscriptionEntity.getSku());
        if (oVar == null || (d10 = oVar.d()) == null || (dVar = (o.d) CollectionsKt___CollectionsKt.P(d10)) == null || (b10 = dVar.b()) == null || (a10 = b10.a()) == null || (bVar = (o.b) CollectionsKt___CollectionsKt.P(a10)) == null) {
            return null;
        }
        String c10 = bVar.c();
        kotlin.jvm.internal.j.f(c10, "details.priceCurrencyCode");
        String a11 = bVar.a();
        kotlin.jvm.internal.j.f(a11, "details.formattedPrice");
        return new RewardPrice(c10, a11, String.valueOf(bVar.b()));
    }

    /* access modifiers changed from: private */
    public final String S() {
        String str;
        if (this.f12434h.p("is_set_to_baking")) {
            str = "staging";
        } else {
            str = "production";
        }
        return this.f12433g.l() + ':' + str;
    }

    /* access modifiers changed from: private */
    public static final rn.a U(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final h<List<vb.b>> V(List<String> list) {
        h<R> Y = this.f12430d.a().Y(new j1(new SubscriptionRepository$getBenefitList$1(list)));
        kotlin.jvm.internal.j.f(Y, "benefits: List<String>):…itEntity) }\n            }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final List W(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    private final h<Optional<vb.c>> Y(String str) {
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f12436j;
        aVar.a(str2, "getHighestTierSubscriptionBundleByIntent: " + str);
        h<R> o02 = this.f12432f.g(str).S(new d1(new SubscriptionRepository$getHighestTierSubscriptionBundleByIntent$1(this))).o0(dk.a.c());
        kotlin.jvm.internal.j.f(o02, "private fun getHighestTi…On(Schedulers.io())\n    }");
        return o02;
    }

    /* access modifiers changed from: private */
    public static final b0 Z(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    private final w<com.android.billingclient.api.o> a0(String str) {
        if (this.f12437k.containsKey(str)) {
            w<com.android.billingclient.api.o> C = w.C(this.f12437k.get(str));
            kotlin.jvm.internal.j.f(C, "{\n            Single.jus…ailsCache[sku])\n        }");
            return C;
        }
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f12436j;
        aVar.a(str2, "Didn't have details for " + str + ", querying.");
        w<R> D = this.f12427a.R(p.e(str), "subs").D(new f1(new SubscriptionRepository$getInAppItemSkuDetails$1(str)));
        kotlin.jvm.internal.j.f(D, "sku: String): Single<Pro…              }\n        }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final com.android.billingclient.api.o b0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (com.android.billingclient.api.o) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<List<Pair<SubscriptionEntity, RewardPrice>>> c0(List<SubscriptionEntity> list) {
        w<List<Pair<SubscriptionEntity, RewardPrice>>> I = w.C(list).w(new h1(new SubscriptionRepository$getPricesForVariants$1(this))).I(new i1(list, this));
        kotlin.jvm.internal.j.f(I, "private fun getPricesFor…    }\n            }\n    }");
        return I;
    }

    /* access modifiers changed from: private */
    public static final f d0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List e0(List list, SubscriptionRepository subscriptionRepository) {
        kotlin.jvm.internal.j.g(list, "$variants");
        kotlin.jvm.internal.j.g(subscriptionRepository, "this$0");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubscriptionEntity subscriptionEntity = (SubscriptionEntity) it.next();
            RewardPrice R = subscriptionRepository.R(subscriptionEntity);
            if (R != null) {
                arrayList.add(new Pair(subscriptionEntity, R));
            } else {
                throw new MissingResourceException("Missing SKU: " + subscriptionEntity.getSku(), subscriptionRepository.f12436j, subscriptionEntity.getSku());
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String f0(com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getVariants()
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L_0x0011
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0011
        L_0x000f:
            r0 = r2
            goto L_0x0032
        L_0x0011:
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x000f
            java.lang.Object r1 = r0.next()
            com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant r1 = (com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant) r1
            java.lang.String r1 = r1.getUnit()
            com.coffeemeetsbagel.store.domain.VariantUnits r3 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r3 = r3.b()
            boolean r1 = kotlin.jvm.internal.j.b(r1, r3)
            if (r1 == 0) goto L_0x0015
            r0 = 1
        L_0x0032:
            if (r0 == 0) goto L_0x0076
            java.util.List r6 = r6.getVariants()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0041:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r6.next()
            r3 = r1
            com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant r3 = (com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant) r3
            java.lang.String r3 = r3.getUnit()
            com.coffeemeetsbagel.store.domain.VariantUnits r4 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r4 = r4.b()
            boolean r3 = kotlin.jvm.internal.j.b(r3, r4)
            if (r3 == 0) goto L_0x0041
            r0.add(r1)
            goto L_0x0041
        L_0x0062:
            com.coffeemeetsbagel.domain.repository.SubscriptionRepository$b r6 = new com.coffeemeetsbagel.domain.repository.SubscriptionRepository$b
            r6.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.q0(r0, r6)
            java.lang.Object r6 = r6.get(r2)
            com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant r6 = (com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant) r6
            java.lang.String r6 = r6.getSku()
            goto L_0x008d
        L_0x0076:
            java.util.List r6 = r6.getVariants()
            com.coffeemeetsbagel.domain.repository.SubscriptionRepository$c r0 = new com.coffeemeetsbagel.domain.repository.SubscriptionRepository$c
            r0.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.q0(r6, r0)
            java.lang.Object r6 = r6.get(r2)
            com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant r6 = (com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant) r6
            java.lang.String r6 = r6.getSku()
        L_0x008d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.domain.repository.SubscriptionRepository.f0(com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static final rn.a h0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    private final h<List<vb.c>> i0(String str, int i10) {
        h<R> S = this.f12432f.f(str, i10).S(new y0(new SubscriptionRepository$getSubscriptionBundles$1(this)));
        kotlin.jvm.internal.j.f(S, "private fun getSubscript…nding\n            }\n    }");
        return S;
    }

    /* access modifiers changed from: private */
    public static final b0 j0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public static /* synthetic */ h l0(SubscriptionRepository subscriptionRepository, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        return subscriptionRepository.k0(str, i10);
    }

    /* access modifiers changed from: private */
    public final h<List<d>> n0(String str) {
        h<R> Y = this.f12431e.a(str).S(new c1(new SubscriptionRepository$getVariantList$1(this))).Y(new e1(new SubscriptionRepository$getVariantList$2(str)));
        kotlin.jvm.internal.j.f(Y, "private fun getVariantLi…    }\n            }\n    }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final b0 o0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List p0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<vb.c> q0(SubscriptionBundleEntity subscriptionBundleEntity) {
        w<R> D = w.S(V(subscriptionBundleEntity.getBenefits()).L(), n0(subscriptionBundleEntity.getId()).L(), new n1(SubscriptionRepository$inflateBundle$1.f12445a)).D(new o1(new SubscriptionRepository$inflateBundle$2(subscriptionBundleEntity)));
        kotlin.jvm.internal.j.f(D, "bundleEntity: Subscripti…air.second)\n            }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final Pair r0(Function2 function2, Object obj, Object obj2) {
        kotlin.jvm.internal.j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final vb.c s0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (vb.c) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a u0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean v0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final String w0(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final qj.a x0(boolean z10, SubscriptionResponseData subscriptionResponseData) {
        qj.a b10 = E0(z10, subscriptionResponseData).b(H0(subscriptionResponseData)).b(M0(subscriptionResponseData)).b(L0(subscriptionResponseData.getActiveSubscription())).b(K0(subscriptionResponseData));
        kotlin.jvm.internal.j.f(b10, "updateBenefits(refreshBe…dThen(updatePrices(data))");
        return b10;
    }

    /* access modifiers changed from: private */
    public static final Triple z0(n nVar, Object obj, Object obj2, Object obj3) {
        kotlin.jvm.internal.j.g(nVar, "$tmp0");
        return (Triple) nVar.l(obj, obj2, obj3);
    }

    public final qj.a C0(boolean z10) {
        qj.a F = this.f12428b.b().w(new k1(new SubscriptionRepository$refreshSubscriptions$1(this, z10))).F(dk.a.c());
        kotlin.jvm.internal.j.f(F, "fun refreshSubscriptions…On(Schedulers.io())\n    }");
        return F;
    }

    public final qj.a N(Purchase purchase) {
        kotlin.jvm.internal.j.g(purchase, "purchase");
        return this.f12427a.x(purchase);
    }

    public final h<Optional<vb.a>> T() {
        h<R> M = this.f12429c.f().o0(dk.a.c()).M(new s0(new SubscriptionRepository$getActiveSubscription$1(this)));
        kotlin.jvm.internal.j.f(M, "fun getActiveSubscriptio…    }\n            }\n    }");
        return M;
    }

    public final h<Optional<vb.c>> X() {
        return Y("");
    }

    public final h<Optional<vb.c>> g0(String str) {
        kotlin.jvm.internal.j.g(str, "bundleId");
        h<R> M = this.f12432f.a(str).o0(dk.a.c()).M(new g1(new SubscriptionRepository$getSubscriptionBundle$1(this)));
        kotlin.jvm.internal.j.f(M, "fun getSubscriptionBundl…    }\n            }\n    }");
        return M;
    }

    public final h<List<vb.c>> k0(String str, int i10) {
        kotlin.jvm.internal.j.g(str, SDKConstants.PARAM_INTENT);
        h<List<vb.c>> o02 = i0(str, i10).o0(dk.a.c());
        kotlin.jvm.internal.j.f(o02, "getSubscriptionBundles(i…scribeOn(Schedulers.io())");
        return o02;
    }

    public final PublishRelay<a> m0() {
        return this.f12438l;
    }

    public final q<String> t0() {
        q<R> P = q.Y(this.f12438l, this.f12427a.J().W(new z0(SubscriptionRepository$observeSubscriptionChanges$clientStream$1.f12448a))).s().B(new a1(SubscriptionRepository$observeSubscriptionChanges$1.f12446a)).W(new b1(SubscriptionRepository$observeSubscriptionChanges$2.f12447a)).P();
        kotlin.jvm.internal.j.f(P, "merge(subscriptionPurcha…sku }\n            .hide()");
        return P;
    }

    public final w<Purchase> y0(Activity activity, String str) {
        kotlin.jvm.internal.j.g(activity, "activity");
        kotlin.jvm.internal.j.g(str, "sku");
        w<R> r10 = w.R(a0(str), T().L(), this.f12429c.c().L(), new v0(SubscriptionRepository$purchaseSubscription$1.f12449a)).v(new w0(new SubscriptionRepository$purchaseSubscription$2(this, activity))).r(new x0(new SubscriptionRepository$purchaseSubscription$3(this, str)));
        kotlin.jvm.internal.j.f(r10, "fun purchaseSubscription…rue))\n            }\n    }");
        return r10;
    }
}

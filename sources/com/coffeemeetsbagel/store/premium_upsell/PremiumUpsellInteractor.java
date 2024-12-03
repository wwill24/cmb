package com.coffeemeetsbagel.store.premium_upsell;

import b6.s;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.premium_upsell.x;
import com.uber.autodispose.t;
import fa.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import vb.c;

public final class PremiumUpsellInteractor extends s<x, PremiumUpsellRouter> implements x.a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final PurchaseSource f36847f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f36848g;

    /* renamed from: h  reason: collision with root package name */
    private final SubscriptionBenefitAttribution f36849h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f36850j = "PremiumUpsellInteractor";

    /* renamed from: k  reason: collision with root package name */
    public PremiumUpsellAnalytics f36851k;

    /* renamed from: l  reason: collision with root package name */
    public s9.a f36852l;

    /* renamed from: m  reason: collision with root package name */
    public GetSubscriptionBundlesUseCase f36853m;

    /* renamed from: n  reason: collision with root package name */
    private c f36854n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public List<c> f36855p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final b f36856q = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public vb.a f36857t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public c f36858w;

    public interface a {
        void a();

        void b(c cVar);
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PremiumUpsellInteractor f36859a;

        b(PremiumUpsellInteractor premiumUpsellInteractor) {
            this.f36859a = premiumUpsellInteractor;
        }

        public void a() {
            this.f36859a.g2();
        }

        public void b(c cVar) {
            j.g(cVar, "bundle");
            this.f36859a.h2(cVar);
        }
    }

    public PremiumUpsellInteractor(PurchaseSource purchaseSource, boolean z10) {
        j.g(purchaseSource, "purchaseSource");
        this.f36847f = purchaseSource;
        this.f36848g = z10;
        this.f36849h = SubscriptionBenefitAttribution.f36723a.a(purchaseSource);
    }

    /* access modifiers changed from: private */
    public static final void W1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final Pair<vb.a, c> Y1() {
        vb.a aVar = this.f36857t;
        if (aVar == null || this.f36858w == null) {
            return null;
        }
        j.d(aVar);
        c cVar = this.f36858w;
        j.d(cVar);
        return new Pair<>(aVar, cVar);
    }

    /* access modifiers changed from: private */
    public final List<c> Z1(List<c> list) {
        if (!(!list.isEmpty())) {
            return q.j();
        }
        if (this.f36848g) {
            return p.e(CollectionsKt___CollectionsKt.Y(list));
        }
        c cVar = this.f36858w;
        if (cVar != null) {
            j.d(cVar);
            return q.m(cVar, (c) CollectionsKt___CollectionsKt.Y(list));
        } else if (list.size() < 2) {
            return p.e(CollectionsKt___CollectionsKt.Y(list));
        } else {
            return q.m((c) CollectionsKt___CollectionsKt.N(list), (c) CollectionsKt___CollectionsKt.Y(list));
        }
    }

    private final Pair<String, String> c2() {
        c cVar = this.f36854n;
        if (cVar == null) {
            return new Pair<>("", "");
        }
        j.d(cVar);
        String b10 = cVar.b();
        c cVar2 = this.f36854n;
        j.d(cVar2);
        return new Pair<>(b10, cVar2.d());
    }

    /* access modifiers changed from: private */
    public final void e2(Throwable th2) {
        ((PremiumUpsellRouter) B1()).n(PurchaseFailureType.GENERIC);
        fa.a.f40771d.c(this.f36850j, "Error in MPU loading subscriptions.", th2);
    }

    /* access modifiers changed from: private */
    public final void g2() {
        fa.a.f40771d.a(this.f36850j, "processBenefitsContinue");
        List<c> list = this.f36855p;
        List<c> list2 = null;
        if (list == null) {
            j.y("availableSubscriptions");
            list = null;
        }
        if (!list.isEmpty()) {
            List<c> list3 = this.f36855p;
            if (list3 == null) {
                j.y("availableSubscriptions");
                list3 = null;
            }
            if (list3.size() >= 2) {
                PremiumUpsellRouter premiumUpsellRouter = (PremiumUpsellRouter) B1();
                PurchaseSource purchaseSource = this.f36847f;
                List<c> list4 = this.f36855p;
                if (list4 == null) {
                    j.y("availableSubscriptions");
                } else {
                    list2 = list4;
                }
                premiumUpsellRouter.s(purchaseSource, list2, this.f36856q, Y1());
                return;
            }
            List<c> list5 = this.f36855p;
            if (list5 == null) {
                j.y("availableSubscriptions");
            } else {
                list2 = list5;
            }
            h2((c) CollectionsKt___CollectionsKt.Y(list2));
            return;
        }
        e2(new Exception("No variants to show for bundle."));
    }

    /* access modifiers changed from: private */
    public final void h2(c cVar) {
        this.f36854n = cVar;
        ((PremiumUpsellRouter) B1()).u(a2().a("ModularPremiumUpsellV2.Android"), this.f36847f, cVar, Y1());
    }

    public final s9.a a2() {
        s9.a aVar = this.f36852l;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final GetSubscriptionBundlesUseCase b2() {
        GetSubscriptionBundlesUseCase getSubscriptionBundlesUseCase = this.f36853m;
        if (getSubscriptionBundlesUseCase != null) {
            return getSubscriptionBundlesUseCase;
        }
        j.y("getSubscriptionBundlesUseCase");
        return null;
    }

    public final PremiumUpsellAnalytics d2() {
        PremiumUpsellAnalytics premiumUpsellAnalytics = this.f36851k;
        if (premiumUpsellAnalytics != null) {
            return premiumUpsellAnalytics;
        }
        j.y("tracker");
        return null;
    }

    public final void f2() {
        Pair<String, String> c22 = c2();
        d2().i(c22.c(), c22.d());
    }

    public final void i2() {
        ((x) this.f7875e).m();
    }

    public final void j2() {
        ((x) this.f7875e).n();
    }

    public void onCancel() {
        Pair<String, String> c22 = c2();
        d2().i(c22.c(), c22.d());
        ((PremiumUpsellRouter) B1()).m();
    }

    public void v0() {
        ((PremiumUpsellRouter) B1()).p();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f36850j;
        String c10 = this.f36849h.c();
        aVar.a(str, "didBecomeActive, benefitTag: " + c10);
        ((t) b2().l(this.f36849h.c()).L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new s(new PremiumUpsellInteractor$didBecomeActive$1(this)), new t(new PremiumUpsellInteractor$didBecomeActive$2(this)));
    }
}

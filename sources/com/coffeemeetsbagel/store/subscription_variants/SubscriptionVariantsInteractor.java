package com.coffeemeetsbagel.store.subscription_variants;

import b6.s;
import c6.b;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.google_play.BillingUserCancelled;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseFailureException;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import com.coffeemeetsbagel.store.subscription_variants.d;
import com.uber.autodispose.m;
import fa.a;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import vb.a;
import vb.c;
import vb.d;
import wb.e;

public final class SubscriptionVariantsInteractor extends s<o, SubscriptionVariantsRouter> implements p {

    /* renamed from: f  reason: collision with root package name */
    private final PurchaseSource f36958f;

    /* renamed from: g  reason: collision with root package name */
    private final c f36959g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f36960h;

    /* renamed from: j  reason: collision with root package name */
    private final Pair<a, c> f36961j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final String f36962k = "SubscriptionVariantsInteractor";

    /* renamed from: l  reason: collision with root package name */
    public SubscriptionRepository f36963l;

    /* renamed from: m  reason: collision with root package name */
    public BuySubscriptionUseCase f36964m;

    /* renamed from: n  reason: collision with root package name */
    public e f36965n;

    /* renamed from: p  reason: collision with root package name */
    public b f36966p;

    /* renamed from: q  reason: collision with root package name */
    public PremiumUpsellAnalytics f36967q;

    /* renamed from: t  reason: collision with root package name */
    public UserRepository f36968t;

    /* renamed from: w  reason: collision with root package name */
    public SubscriptionRepository f36969w;

    /* renamed from: x  reason: collision with root package name */
    public s9.a f36970x;

    public SubscriptionVariantsInteractor(PurchaseSource purchaseSource, c cVar, boolean z10, Pair<a, c> pair) {
        j.g(purchaseSource, "purchaseSource");
        j.g(cVar, "bundle");
        this.f36958f = purchaseSource;
        this.f36959g = cVar;
        this.f36960h = z10;
        this.f36961j = pair;
    }

    /* access modifiers changed from: private */
    public final void T1(Throwable th2) {
        if ((th2 instanceof BillingUserCancelled) || (th2.getCause() instanceof BillingUserCancelled)) {
            R1().m(PremiumUpsellAnalytics.DropOffPoint.PAYMENT_DIALOG);
            R1().i(this.f36959g.b(), this.f36959g.d());
        } else if ((th2 instanceof PurchaseFailureException) || (th2.getCause() instanceof PurchaseFailureException)) {
            R1().l(this.f36959g.b(), this.f36959g.d(), PremiumUpsellAnalytics.DropOffPoint.PAYMENT_DIALOG);
            ((SubscriptionVariantsRouter) B1()).m(PurchaseFailureType.UNABLE_TO_CONSUME);
        } else {
            R1().l(this.f36959g.b(), this.f36959g.d(), PremiumUpsellAnalytics.DropOffPoint.PAYMENT_DIALOG);
            ((SubscriptionVariantsRouter) B1()).m(PurchaseFailureType.GENERIC);
        }
    }

    private final void U1(d dVar) {
        R1().p(this.f36959g.b(), this.f36959g.d(), this.f36959g.i(), dVar.d());
        ((m) Q1().a().t(new h(new SubscriptionVariantsInteractor$handleSubscriptionSuccess$1(this))).z(sj.a.a()).u(new i(this)).j(com.uber.autodispose.a.a(this))).f(new j(this), new k(new SubscriptionVariantsInteractor$handleSubscriptionSuccess$4(this)));
    }

    /* access modifiers changed from: private */
    public static final void V1(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        j.g(subscriptionVariantsInteractor, "this$0");
        ((SubscriptionVariantsRouter) subscriptionVariantsInteractor.B1()).q(false);
    }

    /* access modifiers changed from: private */
    public static final void W1(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        j.g(subscriptionVariantsInteractor, "this$0");
        ((SubscriptionVariantsRouter) subscriptionVariantsInteractor.B1()).p();
    }

    /* access modifiers changed from: private */
    public static final void X1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Y1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Z1(SubscriptionVariantsInteractor subscriptionVariantsInteractor, d dVar) {
        j.g(subscriptionVariantsInteractor, "this$0");
        j.g(dVar, "$item");
        subscriptionVariantsInteractor.U1(dVar);
    }

    /* access modifiers changed from: private */
    public static final void a2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final BuySubscriptionUseCase P1() {
        BuySubscriptionUseCase buySubscriptionUseCase = this.f36964m;
        if (buySubscriptionUseCase != null) {
            return buySubscriptionUseCase;
        }
        j.y("buySubscriptionUseCase");
        return null;
    }

    public final e Q1() {
        e eVar = this.f36965n;
        if (eVar != null) {
            return eVar;
        }
        j.y("refreshSubscriptionUseCase");
        return null;
    }

    public final PremiumUpsellAnalytics R1() {
        PremiumUpsellAnalytics premiumUpsellAnalytics = this.f36967q;
        if (premiumUpsellAnalytics != null) {
            return premiumUpsellAnalytics;
        }
        j.y("tracker");
        return null;
    }

    public final Pair<d, d> S1() {
        T t10;
        d dVar;
        T t11;
        boolean z10;
        Pair<a, c> pair = this.f36961j;
        if (pair == null) {
            return null;
        }
        String e10 = pair.c().e();
        Iterator<T> it = this.f36961j.d().k().iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((d) t10).h().equals(e10)) {
                break;
            }
        }
        d dVar2 = (d) t10;
        if (dVar2 != null) {
            Iterator<T> it2 = this.f36959g.k().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (t11.d() == dVar2.d()) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (z10) {
                    break;
                }
            }
            dVar = (d) t11;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            return new Pair<>(dVar2, dVar);
        }
        return null;
    }

    public void m() {
        ((SubscriptionVariantsRouter) B1()).o();
    }

    public void o0() {
        R1().m(PremiumUpsellAnalytics.DropOffPoint.SUBSCRIPTION_VARIANTS);
        ((o) this.f7875e).o(this.f36959g.d(), this.f36959g.k());
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f36962k;
        c cVar = this.f36959g;
        aVar.a(str, "didBecomeActive(): " + cVar);
        Pair<d, d> S1 = S1();
        if (S1 != null) {
            R1().m(PremiumUpsellAnalytics.DropOffPoint.COMPARE_PLAN);
            ((o) this.f7875e).r(this.f36959g.d(), S1.c(), S1.d());
        } else if (this.f36960h) {
            R1().m(PremiumUpsellAnalytics.DropOffPoint.RECOMMENDED_PLAN);
            ((o) this.f7875e).q(this.f36959g.d(), this.f36959g.k());
        } else {
            R1().m(PremiumUpsellAnalytics.DropOffPoint.SUBSCRIPTION_VARIANTS);
            ((o) this.f7875e).o(this.f36959g.d(), this.f36959g.k());
        }
    }

    public void z0(d dVar) {
        j.g(dVar, "item");
        ((m) P1().l(dVar.h(), ((d.b) ((SubscriptionVariantsRouter) B1()).e()).i(), this.f36958f, false).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new f(this, dVar), new g(new SubscriptionVariantsInteractor$onSubscribeConfirmed$2(this)));
    }
}

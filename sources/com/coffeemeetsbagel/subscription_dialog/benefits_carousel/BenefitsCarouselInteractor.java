package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import a7.a;
import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.q;

public final class BenefitsCarouselInteractor extends s<g, h> {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final SubscriptionBenefitAttribution f37009f;

    /* renamed from: g  reason: collision with root package name */
    private final long f37010g = 4;

    /* renamed from: h  reason: collision with root package name */
    public a f37011h;

    /* renamed from: j  reason: collision with root package name */
    public SubscriptionRepository f37012j;

    /* renamed from: k  reason: collision with root package name */
    public cb.a f37013k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final String f37014l;

    public BenefitsCarouselInteractor(SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        j.g(subscriptionBenefitAttribution, "topBenefit");
        this.f37009f = subscriptionBenefitAttribution;
        String simpleName = BenefitsCarouselInteractor.class.getSimpleName();
        j.f(simpleName, "BenefitsCarouselInteractor::class.java.simpleName");
        this.f37014l = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void N1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final a Q1() {
        a aVar = this.f37011h;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final cb.a R1() {
        cb.a aVar = this.f37013k;
        if (aVar != null) {
            return aVar;
        }
        j.y("schedulerProvider");
        return null;
    }

    public final SubscriptionRepository S1() {
        SubscriptionRepository subscriptionRepository = this.f37012j;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        j.y("subscriptionRepository");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) S1().X().L().K(R1().c()).E(R1().a()).g(com.uber.autodispose.a.a(this))).b(new c(new BenefitsCarouselInteractor$didBecomeActive$1(this)), new d(new BenefitsCarouselInteractor$didBecomeActive$2(this)));
        ((p) q.U(this.f37010g, TimeUnit.SECONDS, R1().b()).a0(R1().a()).g(com.uber.autodispose.a.a(this))).c(new e(new BenefitsCarouselInteractor$didBecomeActive$3(this)));
    }
}

package com.coffeemeetsbagel.shop.post_subscription_benefits;

import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.shop.post_subscription_benefits.l;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import vb.a;

public final class PostSubscriptionBenefitsCardInteractor extends s<l, m> implements l.a {

    /* renamed from: f  reason: collision with root package name */
    public SubscriptionRepository f36466f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36467g;

    public PostSubscriptionBenefitsCardInteractor() {
        String simpleName = PostSubscriptionBenefitsCardInteractor.class.getSimpleName();
        j.f(simpleName, "PostSubscriptionBenefits…or::class.java.simpleName");
        this.f36467g = simpleName;
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
    public final void R1(a aVar) {
        if (aVar.g() > 0) {
            ((t) P1().X().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h(new PostSubscriptionBenefitsCardInteractor$setUpdateButton$1(aVar, this)), new i(new PostSubscriptionBenefitsCardInteractor$setUpdateButton$2(this)));
        } else {
            ((l) this.f7875e).n(false, this);
        }
    }

    /* access modifiers changed from: private */
    public static final void S1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final SubscriptionRepository P1() {
        SubscriptionRepository subscriptionRepository = this.f36466f;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        j.y("subscriptionRepository");
        return null;
    }

    public final String Q1() {
        return this.f36467g;
    }

    public void f1() {
        ((m) B1()).m();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) P1().T().a0(sj.a.a()).A(new f(new PostSubscriptionBenefitsCardInteractor$didBecomeActive$1(this))).g(com.uber.autodispose.a.a(this))).c(new g(new PostSubscriptionBenefitsCardInteractor$didBecomeActive$2(this)));
    }
}

package com.coffeemeetsbagel.shop.subscription_comparison;

import b6.q;
import b6.s;
import com.coffeemeetsbagel.shop.subscription_comparison.i;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.uber.autodispose.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class SubscriptionComparisonInteractor extends s<i, j> {

    /* renamed from: f  reason: collision with root package name */
    public GetSubscriptionBundlesUseCase f36614f;

    /* renamed from: g  reason: collision with root package name */
    private final String f36615g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final a f36616h = new a(this);

    public static final class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SubscriptionComparisonInteractor f36617a;

        a(SubscriptionComparisonInteractor subscriptionComparisonInteractor) {
            this.f36617a = subscriptionComparisonInteractor;
        }

        public void a() {
            ((j) this.f36617a.B1()).m(true);
        }

        public void b() {
            q B1 = this.f36617a.B1();
            j.f(B1, "router");
            j.n((j) B1, false, 1, (Object) null);
        }
    }

    public SubscriptionComparisonInteractor() {
        String simpleName = SubscriptionComparisonInteractor.class.getSimpleName();
        j.f(simpleName, "SubscriptionComparisonIn…or::class.java.simpleName");
        this.f36615g = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void K1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final GetSubscriptionBundlesUseCase L1() {
        GetSubscriptionBundlesUseCase getSubscriptionBundlesUseCase = this.f36614f;
        if (getSubscriptionBundlesUseCase != null) {
            return getSubscriptionBundlesUseCase;
        }
        j.y("subscriptionBundlesUseCase");
        return null;
    }

    public final String M1() {
        return this.f36615g;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) L1().l("").a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new g(new SubscriptionComparisonInteractor$didBecomeActive$1(this)));
    }
}

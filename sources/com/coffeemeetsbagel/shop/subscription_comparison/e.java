package com.coffeemeetsbagel.shop.subscription_comparison;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.shop.subscription_comparison.b;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;

public final class e extends b6.c<j, a> {

    public interface a {
        androidx.appcompat.app.c i();

        GetSubscriptionBundlesUseCase k();
    }

    public interface b extends j<SubscriptionComparisonInteractor> {
        androidx.appcompat.app.c i();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final View f36625a;

        public c(View view) {
            kotlin.jvm.internal.j.g(view, "subscriptionComparisonView");
            this.f36625a = view;
        }

        public final i a() {
            return new i(this.f36625a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final j b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        SubscriptionComparisonInteractor subscriptionComparisonInteractor = new SubscriptionComparisonInteractor();
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        kotlin.jvm.internal.j.f(from, "from(parentViewGroup.context)");
        View inflate = from.inflate(R.layout.shop_subscription_comparison, viewGroup, false);
        b.a a10 = b.a();
        kotlin.jvm.internal.j.f(inflate, "bundleComparisonView");
        b a11 = a10.c(new c(inflate)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a11, "component");
        return new j(inflate, a11, subscriptionComparisonInteractor);
    }
}

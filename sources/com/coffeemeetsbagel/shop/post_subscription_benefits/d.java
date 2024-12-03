package com.coffeemeetsbagel.shop.post_subscription_benefits;

import android.content.Context;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;

public final class d extends b6.c<m, a> {

    public interface a {
        androidx.appcompat.app.c i();

        SubscriptionRepository m();
    }

    public interface b extends j<PostSubscriptionBenefitsCardInteractor> {
        androidx.appcompat.app.c i();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final n f36473a;

        public c(n nVar) {
            kotlin.jvm.internal.j.g(nVar, "postSubscriptionBenefitsView");
            this.f36473a = nVar;
        }

        public final l a() {
            return new l(this.f36473a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final m b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor = new PostSubscriptionBenefitsCardInteractor();
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.j.f(context, "parentViewGroup.context");
        n nVar = new n(context);
        b a10 = b.a().c(new c(nVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new m(nVar, a10, postSubscriptionBenefitsCardInteractor);
    }
}

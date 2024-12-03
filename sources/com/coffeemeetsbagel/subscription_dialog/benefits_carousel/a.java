package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import android.content.Context;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;

public final class a extends b6.c<h, c> {

    /* renamed from: com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a$a  reason: collision with other inner class name */
    public interface C0456a extends j<BenefitsCarouselInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final i f37015a;

        public b(i iVar) {
            kotlin.jvm.internal.j.g(iVar, "benefitsCarouselView");
            this.f37015a = iVar;
        }

        public final g a() {
            return new g(this.f37015a);
        }
    }

    public interface c {
        a7.a c();

        cb.a f();

        SubscriptionRepository m();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final h b(Context context, SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        kotlin.jvm.internal.j.g(context, "viewContext");
        kotlin.jvm.internal.j.g(subscriptionBenefitAttribution, "topBenefit");
        BenefitsCarouselInteractor benefitsCarouselInteractor = new BenefitsCarouselInteractor(subscriptionBenefitAttribution);
        i iVar = new i(context);
        C0456a b10 = k.a().a(new b(iVar)).c((c) a()).b();
        kotlin.jvm.internal.j.f(b10, "component");
        return new h(iVar, b10, benefitsCarouselInteractor);
    }
}

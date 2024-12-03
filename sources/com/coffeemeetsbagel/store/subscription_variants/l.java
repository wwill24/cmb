package com.coffeemeetsbagel.store.subscription_variants;

import c6.b;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellAnalytics;
import s9.a;
import wb.e;

public final class l {
    public static void a(SubscriptionVariantsInteractor subscriptionVariantsInteractor, b bVar) {
        subscriptionVariantsInteractor.f36966p = bVar;
    }

    public static void b(SubscriptionVariantsInteractor subscriptionVariantsInteractor, BuySubscriptionUseCase buySubscriptionUseCase) {
        subscriptionVariantsInteractor.f36964m = buySubscriptionUseCase;
    }

    public static void c(SubscriptionVariantsInteractor subscriptionVariantsInteractor, a aVar) {
        subscriptionVariantsInteractor.f36970x = aVar;
    }

    public static void d(SubscriptionVariantsInteractor subscriptionVariantsInteractor, e eVar) {
        subscriptionVariantsInteractor.f36965n = eVar;
    }

    public static void e(SubscriptionVariantsInteractor subscriptionVariantsInteractor, SubscriptionRepository subscriptionRepository) {
        subscriptionVariantsInteractor.f36963l = subscriptionRepository;
    }

    public static void f(SubscriptionVariantsInteractor subscriptionVariantsInteractor, SubscriptionRepository subscriptionRepository) {
        subscriptionVariantsInteractor.f36969w = subscriptionRepository;
    }

    public static void g(SubscriptionVariantsInteractor subscriptionVariantsInteractor, PremiumUpsellAnalytics premiumUpsellAnalytics) {
        subscriptionVariantsInteractor.f36967q = premiumUpsellAnalytics;
    }

    public static void h(SubscriptionVariantsInteractor subscriptionVariantsInteractor, UserRepository userRepository) {
        subscriptionVariantsInteractor.f36968t = userRepository;
    }
}

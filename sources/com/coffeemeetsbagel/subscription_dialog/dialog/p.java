package com.coffeemeetsbagel.subscription_dialog.dialog;

import a7.a;
import androidx.appcompat.app.c;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.n;

public final class p {
    public static void a(SubscriptionDialogInteractor subscriptionDialogInteractor, c cVar) {
        subscriptionDialogInteractor.f37032j = cVar;
    }

    public static void b(SubscriptionDialogInteractor subscriptionDialogInteractor, a aVar) {
        subscriptionDialogInteractor.f37036n = aVar;
    }

    public static void c(SubscriptionDialogInteractor subscriptionDialogInteractor, BuySubscriptionUseCase buySubscriptionUseCase) {
        subscriptionDialogInteractor.f37030g = buySubscriptionUseCase;
    }

    public static void d(SubscriptionDialogInteractor subscriptionDialogInteractor, s9.a aVar) {
        subscriptionDialogInteractor.f37033k = aVar;
    }

    public static void e(SubscriptionDialogInteractor subscriptionDialogInteractor, GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase) {
        subscriptionDialogInteractor.f37037p = getMyOwnProfileLocalUseCase;
    }

    public static void f(SubscriptionDialogInteractor subscriptionDialogInteractor, SubscriptionRepository subscriptionRepository) {
        subscriptionDialogInteractor.f37031h = subscriptionRepository;
    }

    public static void g(SubscriptionDialogInteractor subscriptionDialogInteractor, UserRepository userRepository) {
        subscriptionDialogInteractor.f37034l = userRepository;
    }

    public static void h(SubscriptionDialogInteractor subscriptionDialogInteractor, n nVar) {
        subscriptionDialogInteractor.f37035m = nVar;
    }
}

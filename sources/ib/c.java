package ib;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import p9.d;
import s9.a;

public interface c {
    t B();

    hb.c H();

    BuyBeansUseCase I0();

    GetPlayAvailabilityUseCase J0();

    SubscriptionRepository P();

    com.coffeemeetsbagel.feature.instagram.c U();

    a b();

    a7.a c();

    ProfileManager d();

    UserRepository e();

    cb.a f();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    PurchaseManager j();

    wb.c r();

    d r0();
}

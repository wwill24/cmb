package com.coffeemeetsbagel.shop.shop;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.post_subscription_benefits.d;
import com.coffeemeetsbagel.shop.subscription_comparison.e;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import h5.m;
import lc.k;
import lc.p;

public class h extends b6.c<p0, a> {

    public interface a {
        t B();

        BuyBeansUseCase I0();

        GetPlayAvailabilityUseCase J0();

        jb.c L0();

        SubscriptionRepository P();

        com.coffeemeetsbagel.feature.instagram.c U();

        d a();

        s9.a b();

        a7.a c();

        ProfileManager d();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        androidx.appcompat.app.c i();

        PurchaseManager j();

        GetSubscriptionBundlesUseCase k();

        wb.c r();

        p9.d r0();
    }

    public interface b extends j<z>, e.a, a.c, d.a, e.a {
        com.coffeemeetsbagel.feature.instagram.c U();

        b6.d a();

        p9.d r0();
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final ShopShopView f36536a;

        /* renamed from: b  reason: collision with root package name */
        private final z f36537b;

        c(ShopShopView shopShopView, z zVar) {
            this.f36536a = shopShopView;
            this.f36537b = zVar;
        }

        /* access modifiers changed from: package-private */
        public o0 a(b6.d dVar) {
            return new o0(dVar, new sb.b(dVar), this.f36536a, this.f36537b, new lb.d());
        }

        /* access modifiers changed from: package-private */
        public k b() {
            return new k();
        }
    }

    public h(a aVar) {
        super(aVar);
    }

    public p0 b(ViewGroup viewGroup, PurchaseSource purchaseSource) {
        z zVar = new z(purchaseSource);
        ShopShopView shopShopView = (ShopShopView) LayoutInflater.from(((a) a()).a()).inflate(R.layout.shop_shop_dls, viewGroup, false);
        b a10 = b.a().c(new c(shopShopView, zVar)).b((a) a()).a();
        return new p0(shopShopView, a10, zVar, a10.a(), a10.r0(), a10.U(), new m(), new p(), new StringUtils());
    }
}

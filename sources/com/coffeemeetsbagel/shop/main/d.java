package com.coffeemeetsbagel.shop.main;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.shop.shop.h;
import com.coffeemeetsbagel.shop.wallet.d;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;

public class d extends b6.c<o, c> {

    public interface a extends j<k>, h.a, d.a {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final MainShopComponentView f36442a;

        /* renamed from: b  reason: collision with root package name */
        private final k f36443b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f36444c;

        b(MainShopComponentView mainShopComponentView, k kVar, Uri uri) {
            this.f36442a = mainShopComponentView;
            this.f36443b = kVar;
            this.f36444c = uri;
        }

        /* access modifiers changed from: package-private */
        public n a(b6.d dVar) {
            return new n(dVar, this.f36442a, this.f36443b);
        }

        /* access modifiers changed from: package-private */
        public MainShopTabs b() {
            Uri uri = this.f36444c;
            return uri != null ? MainShopTabs.f36429a.a(uri.getHost()) : MainShopTabs.SHOP;
        }
    }

    public interface c {
        t B();

        hb.c H();

        BuyBeansUseCase I0();

        GetPlayAvailabilityUseCase J0();

        jb.c L0();

        kb.a M0();

        d6.a N0();

        kb.c O0();

        SubscriptionRepository P();

        com.coffeemeetsbagel.feature.instagram.c U();

        b6.d a();

        s9.a b();

        a7.a c();

        ProfileManager d();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        androidx.appcompat.app.c i();

        PurchaseManager j();

        wb.c r();

        p9.d r0();
    }

    public d(c cVar) {
        super(cVar);
    }

    public o b(ViewGroup viewGroup, PurchaseSource purchaseSource, Uri uri) {
        k kVar = new k();
        MainShopComponentView mainShopComponentView = (MainShopComponentView) LayoutInflater.from(((c) a()).a()).inflate(R.layout.shop_main, viewGroup, false);
        return new o(mainShopComponentView, b.a().b(new b(mainShopComponentView, kVar, uri)).c((c) a()).a(), kVar, purchaseSource);
    }
}

package com.coffeemeetsbagel.shop.wallet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;

public final class d extends b6.c<l, a> {

    public interface a {
        kb.a M0();

        b6.d<?, ?> a();

        s9.a b();

        PurchaseManager j();
    }

    public interface b extends j<ShopWalletInteractor> {
        b6.d<?, ?> a();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclerView f36647a;

        public c(RecyclerView recyclerView) {
            kotlin.jvm.internal.j.g(recyclerView, "ShopWalletView");
            this.f36647a = recyclerView;
        }

        public final j a(b6.d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "componentActivity");
            return new j(this.f36647a, new k(com.coffeemeetsbagel.image_loader.b.f13967a), dVar);
        }

        public final k9.b b(s9.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "featureManager");
            return new k9.b(aVar);
        }
    }

    public d(a aVar) {
        super(aVar);
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        ShopWalletInteractor shopWalletInteractor = new ShopWalletInteractor();
        View inflate = LayoutInflater.from(((a) a()).a()).inflate(R.layout.shop_wallet_dls, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) inflate;
        b a10 = b.a().c(new c(recyclerView)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(recyclerView, a10, shopWalletInteractor);
    }
}

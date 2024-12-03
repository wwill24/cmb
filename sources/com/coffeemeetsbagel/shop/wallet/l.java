package com.coffeemeetsbagel.shop.wallet;

import android.view.View;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.shop.wallet.d;
import e6.b;
import kotlin.jvm.internal.j;

public final class l extends b<View, d.b, ShopWalletInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ViewGroup viewGroup, d.b bVar, ShopWalletInteractor shopWalletInteractor) {
        super(viewGroup, bVar, shopWalletInteractor);
        j.g(viewGroup, "view");
        j.g(bVar, "component");
        j.g(shopWalletInteractor, "interactor");
    }

    public String m() {
        b6.j e10 = e();
        j.d(e10);
        String string = ((d.b) e10).a().getString(R.string.wallet_caps);
        j.f(string, "component!!.componentAct…ing(R.string.wallet_caps)");
        return string;
    }
}

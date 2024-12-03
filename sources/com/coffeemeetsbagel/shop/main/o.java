package com.coffeemeetsbagel.shop.main;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.shop.main.d;
import com.coffeemeetsbagel.shop.shop.h;
import com.coffeemeetsbagel.shop.shop.p0;
import com.coffeemeetsbagel.shop.wallet.d;
import com.coffeemeetsbagel.shop.wallet.l;
import com.coffeemeetsbagel.store.PurchaseSource;
import e6.a;
import e6.b;
import java.util.Arrays;

public class o extends u<MainShopComponentView, d.a, k> {

    /* renamed from: f  reason: collision with root package name */
    private final PurchaseSource f36463f;

    /* renamed from: g  reason: collision with root package name */
    private p0 f36464g;

    /* renamed from: h  reason: collision with root package name */
    private l f36465h;

    o(MainShopComponentView mainShopComponentView, d.a aVar, k kVar, PurchaseSource purchaseSource) {
        super(mainShopComponentView, aVar, kVar);
        this.f36463f = purchaseSource;
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        p0 p0Var = this.f36464g;
        if (p0Var != null) {
            b(p0Var);
            this.f36464g = null;
        }
        l lVar = this.f36465h;
        if (lVar != null) {
            b(lVar);
            this.f36465h = null;
        }
    }

    /* access modifiers changed from: package-private */
    public a m() {
        this.f36464g = new h((h.a) e()).b((ViewGroup) l(), this.f36463f);
        this.f36465h = new com.coffeemeetsbagel.shop.wallet.d((d.a) e()).b((ViewGroup) l());
        a(this.f36464g);
        a(this.f36465h);
        return new a(Arrays.asList(new b[]{this.f36464g, this.f36465h}));
    }
}

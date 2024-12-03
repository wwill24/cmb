package com.coffeemeetsbagel.shop.shop;

import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import java.util.function.Predicate;
import lb.e;

public final /* synthetic */ class e0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShopViewType f36531a;

    public /* synthetic */ e0(ShopViewType shopViewType) {
        this.f36531a = shopViewType;
    }

    public final boolean test(Object obj) {
        return o0.C(this.f36531a, (e) obj);
    }
}

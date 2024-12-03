package com.coffeemeetsbagel.shop.wallet;

import com.coffeemeetsbagel.models.Price;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ShopWalletInteractor$didBecomeActive$1 extends Lambda implements Function1<Map<String, Price>, List<? extends Price>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShopWalletInteractor$didBecomeActive$1 f36636a = new ShopWalletInteractor$didBecomeActive$1();

    ShopWalletInteractor$didBecomeActive$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Price> invoke(Map<String, Price> map) {
        j.g(map, "it");
        return CollectionsKt___CollectionsKt.x0(map.values());
    }
}

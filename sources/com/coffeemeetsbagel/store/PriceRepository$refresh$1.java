package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.Price;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class PriceRepository$refresh$1 extends Lambda implements Function1<Map<String, ? extends Price>, f> {
    final /* synthetic */ PriceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PriceRepository$refresh$1(PriceRepository priceRepository) {
        super(1);
        this.this$0 = priceRepository;
    }

    /* renamed from: a */
    public final f invoke(Map<String, Price> map) {
        j.g(map, "map");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            Price price = (Price) next.getValue();
            price.setName((String) next.getKey());
            arrayList.add(price);
        }
        return this.this$0.p(arrayList, map);
    }
}

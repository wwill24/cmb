package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.Price;
import com.jakewharton.rxrelay2.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PriceRepository$getFromDb$2 extends Lambda implements Function1<List<? extends Price>, Unit> {
    final /* synthetic */ PriceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PriceRepository$getFromDb$2(PriceRepository priceRepository) {
        super(1);
        this.this$0 = priceRepository;
    }

    public final void a(List<Price> list) {
        b<Map<String, Price>> m10 = this.this$0.m();
        j.f(list, "priceList");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(list, 10)), 16));
        for (T next : list) {
            linkedHashMap.put(((Price) next).getName(), next);
        }
        m10.accept(linkedHashMap);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

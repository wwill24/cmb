package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.entities.PriceEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PriceRepository$getFromDb$1 extends Lambda implements Function1<List<? extends PriceEntity>, List<? extends Price>> {

    /* renamed from: a  reason: collision with root package name */
    public static final PriceRepository$getFromDb$1 f36714a = new PriceRepository$getFromDb$1();

    PriceRepository$getFromDb$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Price> invoke(List<PriceEntity> list) {
        j.g(list, "it");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (PriceEntity priceEntity : list) {
            arrayList.add(new Price(priceEntity.getBeans(), priceEntity.getFreeItemCount(), priceEntity.isUnlimited(), priceEntity.getName(), priceEntity.getImageUrl(), priceEntity.getTintColor(), (String) null, 64, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }
}

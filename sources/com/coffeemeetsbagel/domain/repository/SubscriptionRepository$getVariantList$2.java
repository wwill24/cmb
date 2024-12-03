package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import com.coffeemeetsbagel.store.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.d;

final class SubscriptionRepository$getVariantList$2 extends Lambda implements Function1<List<? extends Pair<? extends SubscriptionEntity, ? extends RewardPrice>>, List<? extends d>> {
    final /* synthetic */ String $bundleId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getVariantList$2(String str) {
        super(1);
        this.$bundleId = str;
    }

    /* renamed from: a */
    public final List<d> invoke(List<Pair<SubscriptionEntity, RewardPrice>> list) {
        j.g(list, "entityAndPriceList");
        String str = this.$bundleId;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Pair pair : list) {
            arrayList.add(w0.f37004a.b(str, (SubscriptionEntity) pair.c(), (RewardPrice) pair.d()));
        }
        return arrayList;
    }
}

package com.coffeemeetsbagel.experiment;

import com.coffeemeetsbagel.features.models.FeatureFlag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FeatureFlagRepository$fetchFFsFromRemote$1 extends Lambda implements Function1<Map<String, ? extends Boolean>, List<? extends FeatureFlag>> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$fetchFFsFromRemote$1(FeatureFlagRepository featureFlagRepository) {
        super(1);
        this.this$0 = featureFlagRepository;
    }

    /* renamed from: a */
    public final List<FeatureFlag> invoke(Map<String, Boolean> map) {
        j.g(map, "map");
        FeatureFlagRepository featureFlagRepository = this.this$0;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new FeatureFlag((String) next.getKey(), ((Boolean) next.getValue()).booleanValue(), (Boolean) featureFlagRepository.f12637i.get(next.getKey())));
        }
        return CollectionsKt___CollectionsKt.x0(arrayList);
    }
}

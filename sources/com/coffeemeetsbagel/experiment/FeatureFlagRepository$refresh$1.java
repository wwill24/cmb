package com.coffeemeetsbagel.experiment;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class FeatureFlagRepository$refresh$1 extends Lambda implements Function1<Map<String, ? extends Boolean>, f> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$refresh$1(FeatureFlagRepository featureFlagRepository) {
        super(1);
        this.this$0 = featureFlagRepository;
    }

    /* renamed from: a */
    public final f invoke(Map<String, Boolean> map) {
        j.g(map, "map");
        return this.this$0.M(map);
    }
}

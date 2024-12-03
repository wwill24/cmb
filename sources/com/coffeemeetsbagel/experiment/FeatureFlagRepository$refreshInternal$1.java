package com.coffeemeetsbagel.experiment;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

final class FeatureFlagRepository$refreshInternal$1 extends Lambda implements Function1<Map<String, ? extends Boolean>, f> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$refreshInternal$1(FeatureFlagRepository featureFlagRepository) {
        super(1);
        this.this$0 = featureFlagRepository;
    }

    /* access modifiers changed from: private */
    public static final void d(FeatureFlagRepository featureFlagRepository) {
        j.g(featureFlagRepository, "this$0");
        featureFlagRepository.w().edit().putLong("last_feature_sync", System.currentTimeMillis()).commit();
    }

    /* renamed from: c */
    public final f invoke(Map<String, Boolean> map) {
        j.g(map, "map");
        return a.w(new q(this.this$0)).b(this.this$0.M(map));
    }
}

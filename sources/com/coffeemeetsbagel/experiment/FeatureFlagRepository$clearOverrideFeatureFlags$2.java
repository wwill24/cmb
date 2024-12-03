package com.coffeemeetsbagel.experiment;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FeatureFlagRepository$clearOverrideFeatureFlags$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$clearOverrideFeatureFlags$2(FeatureFlagRepository featureFlagRepository) {
        super(1);
        this.this$0 = featureFlagRepository;
    }

    public final void a(Boolean bool) {
        j.f(bool, "success");
        if (bool.booleanValue()) {
            this.this$0.f12637i.clear();
        } else {
            a.f40771d.c(this.this$0.f12632d, "failed to clear ff override", new IllegalStateException("failed to clear ff override"));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}

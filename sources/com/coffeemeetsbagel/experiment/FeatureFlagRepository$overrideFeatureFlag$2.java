package com.coffeemeetsbagel.experiment;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FeatureFlagRepository$overrideFeatureFlag$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ boolean $value;
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$overrideFeatureFlag$2(FeatureFlagRepository featureFlagRepository, String str, boolean z10) {
        super(1);
        this.this$0 = featureFlagRepository;
        this.$key = str;
        this.$value = z10;
    }

    public final void a(Boolean bool) {
        j.f(bool, "success");
        if (bool.booleanValue()) {
            this.this$0.f12637i.put(this.$key, Boolean.valueOf(this.$value));
            return;
        }
        String str = "failed to set override for " + this.$key;
        a.f40771d.c(this.this$0.f12632d, str, new IllegalStateException(str));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}

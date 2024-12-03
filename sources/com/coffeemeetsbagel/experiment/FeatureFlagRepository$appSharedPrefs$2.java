package com.coffeemeetsbagel.experiment;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class FeatureFlagRepository$appSharedPrefs$2 extends Lambda implements Function0<SharedPreferences> {
    final /* synthetic */ FeatureFlagRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeatureFlagRepository$appSharedPrefs$2(FeatureFlagRepository featureFlagRepository) {
        super(0);
        this.this$0 = featureFlagRepository;
    }

    /* renamed from: a */
    public final SharedPreferences invoke() {
        return this.this$0.f12630b.B("CMB_SHARED_PREFS");
    }
}

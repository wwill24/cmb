package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class DistanceMatchPreferenceInteractor$didBecomeActive$2 extends Lambda implements Function1<String, b0<? extends Object>> {
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$didBecomeActive$2(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
    }

    /* renamed from: a */
    public final b0<? extends Object> invoke(String str) {
        j.g(str, "it");
        if (!this.this$0.h2().a("ProfileMigration.Enabled.Android")) {
            return this.this$0.m2();
        }
        DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor = this.this$0;
        return distanceMatchPreferenceInteractor.o2(((s) distanceMatchPreferenceInteractor.f7875e).l());
    }
}

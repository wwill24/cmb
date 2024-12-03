package com.coffeemeetsbagel.new_user_experience.match_prefs.gender;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class GenderMatchPreferenceInteractor$didBecomeActive$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GenderMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderMatchPreferenceInteractor$didBecomeActive$2(GenderMatchPreferenceInteractor genderMatchPreferenceInteractor) {
        super(1);
        this.this$0 = genderMatchPreferenceInteractor;
    }

    public final void a(String str) {
        this.this$0.Q1();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

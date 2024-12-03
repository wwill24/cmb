package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import com.coffeemeetsbagel.models.Resource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ReligionMatchPreferenceInteractor$didBecomeActive$3 extends Lambda implements Function1<Resource, Unit> {
    final /* synthetic */ ReligionMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionMatchPreferenceInteractor$didBecomeActive$3(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor) {
        super(1);
        this.this$0 = religionMatchPreferenceInteractor;
    }

    public final void a(Resource resource) {
        this.this$0.S1().g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Resource) obj);
        return Unit.f32013a;
    }
}

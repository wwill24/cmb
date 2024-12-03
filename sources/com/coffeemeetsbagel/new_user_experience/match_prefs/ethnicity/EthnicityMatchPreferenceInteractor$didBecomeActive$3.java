package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import com.coffeemeetsbagel.models.Resource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class EthnicityMatchPreferenceInteractor$didBecomeActive$3 extends Lambda implements Function1<Resource, Unit> {
    final /* synthetic */ EthnicityMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityMatchPreferenceInteractor$didBecomeActive$3(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor) {
        super(1);
        this.this$0 = ethnicityMatchPreferenceInteractor;
    }

    public final void a(Resource resource) {
        this.this$0.S1().g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Resource) obj);
        return Unit.f32013a;
    }
}

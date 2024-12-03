package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ReligionMatchPreferenceInteractor$didBecomeActive$4 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ReligionMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionMatchPreferenceInteractor$didBecomeActive$4(ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor) {
        super(1);
        this.this$0 = religionMatchPreferenceInteractor;
    }

    public final void a(String str) {
        a.C0491a aVar = a.f40771d;
        l T1 = this.this$0.T1();
        aVar.a("MatchPrefs", "Next tap start - Religion - " + T1);
        List<Resource> k10 = ((k) this.this$0.f7875e).k();
        if (!k10.isEmpty()) {
            this.this$0.X1(k10);
        } else {
            this.this$0.Y1(k10);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

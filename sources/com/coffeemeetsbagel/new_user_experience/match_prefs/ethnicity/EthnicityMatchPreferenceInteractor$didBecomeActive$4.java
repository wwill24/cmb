package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import com.coffeemeetsbagel.models.Resource;
import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class EthnicityMatchPreferenceInteractor$didBecomeActive$4 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ EthnicityMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityMatchPreferenceInteractor$didBecomeActive$4(EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor) {
        super(1);
        this.this$0 = ethnicityMatchPreferenceInteractor;
    }

    public final void a(String str) {
        a.f40771d.a("MatchPrefs", "Next tap start - Ethnicity");
        List<Resource> j10 = ((k) this.this$0.f7875e).j();
        if (!j10.isEmpty()) {
            this.this$0.X1(j10);
        } else {
            this.this$0.Y1(j10);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

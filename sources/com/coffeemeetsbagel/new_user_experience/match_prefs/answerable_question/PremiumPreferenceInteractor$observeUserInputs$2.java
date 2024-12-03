package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.models.dto.Question;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PremiumPreferenceInteractor$observeUserInputs$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$observeUserInputs$2(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(String str) {
        a.f40771d.a("MatchPrefs", "Next tap start - Premium/ Dynamic");
        if (this.this$0.f35235z) {
            Question U1 = this.this$0.f35232w;
            if (U1 != null) {
                this.this$0.E2(U1);
                return;
            }
            return;
        }
        Question U12 = this.this$0.f35232w;
        if (U12 != null) {
            this.this$0.o2().onSuccess(U12.getLabel());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.models.dto.Option;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PremiumPreferenceInteractor$observeUserInputs$1 extends Lambda implements Function1<Option, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$observeUserInputs$1(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(Option option) {
        this.this$0.o2().g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Option) obj);
        return Unit.f32013a;
    }
}

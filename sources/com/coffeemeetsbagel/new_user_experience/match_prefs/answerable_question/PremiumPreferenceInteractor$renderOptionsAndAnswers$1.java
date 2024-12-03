package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$renderOptionsAndAnswers$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ QuestionWAnswers $questionWithAnswers;
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$renderOptionsAndAnswers$1(PremiumPreferenceInteractor premiumPreferenceInteractor, QuestionWAnswers questionWAnswers) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
        this.$questionWithAnswers = questionWAnswers;
    }

    public final void a(Boolean bool) {
        boolean z10 = true;
        this.this$0.f35235z = !bool.booleanValue();
        if (this.this$0.m2(this.$questionWithAnswers.e()) != DealbreakerVariant.VARIANT_B) {
            z10 = false;
        }
        QuestionWAnswers questionWAnswers = this.$questionWithAnswers;
        j.f(bool, "locked");
        ((PremiumPreferencePresenter) this.this$0.f7875e).m(questionWAnswers, bool.booleanValue(), z10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}

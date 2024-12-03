package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import ja.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class PremiumPreferenceInteractor$didBecomeActive$2 extends Lambda implements Function1<Pair<? extends b, ? extends Boolean>, a<? extends QuestionWAnswers>> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$didBecomeActive$2(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    /* renamed from: a */
    public final a<? extends QuestionWAnswers> invoke(Pair<b, Boolean> pair) {
        j.g(pair, "pair");
        return this.this$0.r2().M(pair.c().u(), this.this$0.f35221f);
    }
}

package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import b6.p;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

final class PremiumPreferenceInteractor$didBecomeActive$3 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$didBecomeActive$3(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        this.this$0.f35232w = questionWAnswers.e();
        PremiumPreferenceInteractor premiumPreferenceInteractor = this.this$0;
        j.f(questionWAnswers, MamElements.MamResultExtension.ELEMENT);
        PremiumPreferenceInteractor.A2(premiumPreferenceInteractor, questionWAnswers, (Boolean) null, false, 2, (Object) null);
        p X1 = this.this$0.f7875e;
        j.f(X1, "presenter");
        PremiumPreferencePresenter.z((PremiumPreferencePresenter) X1, this.this$0.m2(questionWAnswers.e()), (Integer) null, 2, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}

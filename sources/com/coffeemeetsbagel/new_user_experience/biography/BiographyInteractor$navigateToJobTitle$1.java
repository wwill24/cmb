package com.coffeemeetsbagel.new_user_experience.biography;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$navigateToJobTitle$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ boolean $goingForwards;
    final /* synthetic */ String $leanPlumOccupationHint;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToJobTitle$1(BiographyInteractor biographyInteractor, String str, boolean z10) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$leanPlumOccupationHint = str;
        this.$goingForwards = z10;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        String str;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer != null) {
            str = answer.getTextValue();
        } else {
            str = null;
        }
        ((BiographyPresenter) this.this$0.f7875e).O(str, this.$leanPlumOccupationHint, this.$goingForwards);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}

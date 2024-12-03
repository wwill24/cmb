package com.coffeemeetsbagel.today_view.card.actioncards;

import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetFirstEligibleActionCardUseCase$getPeriodicQuestionsEligibility$1 extends Lambda implements Function1<List<? extends QuestionWAnswers>, Pair<? extends ActionCard, ? extends Boolean>> {
    final /* synthetic */ ActionCard $actionCard;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetFirstEligibleActionCardUseCase$getPeriodicQuestionsEligibility$1(ActionCard actionCard) {
        super(1);
        this.$actionCard = actionCard;
    }

    /* renamed from: a */
    public final Pair<ActionCard, Boolean> invoke(List<QuestionWAnswers> list) {
        j.g(list, "it");
        return new Pair<>(this.$actionCard, Boolean.valueOf(!list.isEmpty()));
    }
}

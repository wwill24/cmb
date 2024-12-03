package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PromptSelectionInteractor$didBecomeActive$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$didBecomeActive$1(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        this.this$0.T1().b(questionWAnswers.e().getId());
        j.f(questionWAnswers, "questionWAnswers");
        ((y) this.this$0.B1()).m(questionWAnswers);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}

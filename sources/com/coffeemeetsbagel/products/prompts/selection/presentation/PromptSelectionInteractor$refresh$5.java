package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PromptSelectionInteractor$refresh$5 extends Lambda implements Function1<List<? extends QuestionWAnswers>, Unit> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$refresh$5(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    public final void a(List<QuestionWAnswers> list) {
        PromptSelectionInteractor promptSelectionInteractor = this.this$0;
        j.f(list, "state");
        promptSelectionInteractor.X1(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

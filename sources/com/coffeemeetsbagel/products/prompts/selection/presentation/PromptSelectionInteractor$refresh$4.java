package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import qj.p;

final class PromptSelectionInteractor$refresh$4 extends Lambda implements Function1<p<List<? extends QuestionWAnswers>>, Unit> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$refresh$4(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    public final void a(p<List<QuestionWAnswers>> pVar) {
        this.this$0.f2(false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((p) obj);
        return Unit.f32013a;
    }
}

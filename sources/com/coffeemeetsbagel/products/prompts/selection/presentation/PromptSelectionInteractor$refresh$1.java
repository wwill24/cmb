package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class PromptSelectionInteractor$refresh$1 extends Lambda implements Function1<String, a<? extends ab.a>> {
    final /* synthetic */ PromptSelectionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromptSelectionInteractor$refresh$1(PromptSelectionInteractor promptSelectionInteractor) {
        super(1);
        this.this$0 = promptSelectionInteractor;
    }

    /* renamed from: a */
    public final a<? extends ab.a> invoke(String str) {
        j.g(str, "userProfileId");
        return this.this$0.U1().a(str, QuestionGroupType.PROMPTS, false);
    }
}

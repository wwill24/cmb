package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class DeletePromptAnswerUseCase$invoke$1 extends Lambda implements Function1<String, f> {
    final /* synthetic */ String $questionId;
    final /* synthetic */ DeletePromptAnswerUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeletePromptAnswerUseCase$invoke$1(DeletePromptAnswerUseCase deletePromptAnswerUseCase, String str) {
        super(1);
        this.this$0 = deletePromptAnswerUseCase;
        this.$questionId = str;
    }

    /* renamed from: a */
    public final f invoke(String str) {
        j.g(str, "id");
        return this.this$0.f36203b.v(QuestionGroupType.PROMPTS.getQuestionGroupApiString(), this.$questionId, str);
    }
}

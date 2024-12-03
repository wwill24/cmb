package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.responses.ResponsePeriodicQuestions;
import com.coffeemeetsbagel.qna.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import qj.y;

final class QuestionRepository$getQuestions$1 extends Lambda implements Function1<ResponsePeriodicQuestions, b0<? extends ResponsePeriodicQuestions>> {
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$getQuestions$1(QuestionRepository questionRepository) {
        super(1);
        this.this$0 = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final void d(QuestionRepository questionRepository, ResponsePeriodicQuestions responsePeriodicQuestions, y yVar) {
        j.g(questionRepository, "this$0");
        j.g(responsePeriodicQuestions, "$response");
        j.g(yVar, "emitter");
        try {
            questionRepository.f36238b.f(r.b(responsePeriodicQuestions.getData()));
            yVar.onSuccess(responsePeriodicQuestions);
        } catch (Exception e10) {
            yVar.onError(e10);
        }
    }

    /* renamed from: c */
    public final b0<? extends ResponsePeriodicQuestions> invoke(ResponsePeriodicQuestions responsePeriodicQuestions) {
        j.g(responsePeriodicQuestions, "response");
        return w.k(new q(this.this$0, responsePeriodicQuestions));
    }
}

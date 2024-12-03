package com.coffeemeetsbagel.qna.data;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class QuestionRepository$markQuestionSkipped$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$markQuestionSkipped$1(QuestionRepository questionRepository) {
        super(1);
        this.this$0 = questionRepository;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String s10 = this.this$0.f36242f;
        j.f(th2, "it");
        aVar.c(s10, "Can't skip.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

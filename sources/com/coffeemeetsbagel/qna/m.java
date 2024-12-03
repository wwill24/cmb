package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class m implements d<GetTextAnswersUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<QuestionRepository> f36300a;

    public m(a<QuestionRepository> aVar) {
        this.f36300a = aVar;
    }

    public static m a(a<QuestionRepository> aVar) {
        return new m(aVar);
    }

    public static GetTextAnswersUseCase c(QuestionRepository questionRepository) {
        return new GetTextAnswersUseCase(questionRepository);
    }

    /* renamed from: b */
    public GetTextAnswersUseCase get() {
        return c(this.f36300a.get());
    }
}

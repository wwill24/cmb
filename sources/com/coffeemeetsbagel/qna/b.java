package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class b implements d<DeletePromptAnswerUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36229a;

    /* renamed from: b  reason: collision with root package name */
    private final a<QuestionRepository> f36230b;

    public b(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        this.f36229a = aVar;
        this.f36230b = aVar2;
    }

    public static b a(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        return new b(aVar, aVar2);
    }

    public static DeletePromptAnswerUseCase c(UserRepository userRepository, QuestionRepository questionRepository) {
        return new DeletePromptAnswerUseCase(userRepository, questionRepository);
    }

    /* renamed from: b */
    public DeletePromptAnswerUseCase get() {
        return c(this.f36229a.get(), this.f36230b.get());
    }
}

package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class b0 implements d<SaveAnswerUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36231a;

    /* renamed from: b  reason: collision with root package name */
    private final a<QuestionRepository> f36232b;

    public b0(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        this.f36231a = aVar;
        this.f36232b = aVar2;
    }

    public static b0 a(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        return new b0(aVar, aVar2);
    }

    public static SaveAnswerUseCase c(UserRepository userRepository, QuestionRepository questionRepository) {
        return new SaveAnswerUseCase(userRepository, questionRepository);
    }

    /* renamed from: b */
    public SaveAnswerUseCase get() {
        return c(this.f36231a.get(), this.f36232b.get());
    }
}

package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class p implements d<GetUserMCQUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36303a;

    /* renamed from: b  reason: collision with root package name */
    private final a<QuestionRepository> f36304b;

    public p(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        this.f36303a = aVar;
        this.f36304b = aVar2;
    }

    public static p a(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        return new p(aVar, aVar2);
    }

    public static GetUserMCQUseCase c(UserRepository userRepository, QuestionRepository questionRepository) {
        return new GetUserMCQUseCase(userRepository, questionRepository);
    }

    /* renamed from: b */
    public GetUserMCQUseCase get() {
        return c(this.f36303a.get(), this.f36304b.get());
    }
}

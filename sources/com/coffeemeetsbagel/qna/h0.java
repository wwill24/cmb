package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class h0 implements d<UpdateLocationUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36294a;

    /* renamed from: b  reason: collision with root package name */
    private final a<QuestionRepository> f36295b;

    public h0(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        this.f36294a = aVar;
        this.f36295b = aVar2;
    }

    public static h0 a(a<UserRepository> aVar, a<QuestionRepository> aVar2) {
        return new h0(aVar, aVar2);
    }

    public static UpdateLocationUseCase c(UserRepository userRepository, QuestionRepository questionRepository) {
        return new UpdateLocationUseCase(userRepository, questionRepository);
    }

    /* renamed from: b */
    public UpdateLocationUseCase get() {
        return c(this.f36294a.get(), this.f36295b.get());
    }
}

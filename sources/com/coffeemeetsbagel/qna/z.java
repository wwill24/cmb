package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class z implements d<QuestionGroupRefreshUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<FeatureFlagRepository> f36352a;

    /* renamed from: b  reason: collision with root package name */
    private final a<UserRepository> f36353b;

    /* renamed from: c  reason: collision with root package name */
    private final a<QuestionRepository> f36354c;

    public z(a<FeatureFlagRepository> aVar, a<UserRepository> aVar2, a<QuestionRepository> aVar3) {
        this.f36352a = aVar;
        this.f36353b = aVar2;
        this.f36354c = aVar3;
    }

    public static z a(a<FeatureFlagRepository> aVar, a<UserRepository> aVar2, a<QuestionRepository> aVar3) {
        return new z(aVar, aVar2, aVar3);
    }

    public static QuestionGroupRefreshUseCase c(FeatureFlagRepository featureFlagRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        return new QuestionGroupRefreshUseCase(featureFlagRepository, userRepository, questionRepository);
    }

    /* renamed from: b */
    public QuestionGroupRefreshUseCase get() {
        return c(this.f36352a.get(), this.f36353b.get(), this.f36354c.get());
    }
}

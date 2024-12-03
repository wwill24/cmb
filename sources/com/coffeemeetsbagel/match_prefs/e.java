package com.coffeemeetsbagel.match_prefs;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class e implements d<GetMatchPreferencesUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f34587a;

    /* renamed from: b  reason: collision with root package name */
    private final a<QuestionRepository> f34588b;

    /* renamed from: c  reason: collision with root package name */
    private final a<FeatureFlagRepository> f34589c;

    /* renamed from: d  reason: collision with root package name */
    private final a<m> f34590d;

    public e(a<UserRepository> aVar, a<QuestionRepository> aVar2, a<FeatureFlagRepository> aVar3, a<m> aVar4) {
        this.f34587a = aVar;
        this.f34588b = aVar2;
        this.f34589c = aVar3;
        this.f34590d = aVar4;
    }

    public static e a(a<UserRepository> aVar, a<QuestionRepository> aVar2, a<FeatureFlagRepository> aVar3, a<m> aVar4) {
        return new e(aVar, aVar2, aVar3, aVar4);
    }

    public static GetMatchPreferencesUseCase c(UserRepository userRepository, QuestionRepository questionRepository, FeatureFlagRepository featureFlagRepository, m mVar) {
        return new GetMatchPreferencesUseCase(userRepository, questionRepository, featureFlagRepository, mVar);
    }

    /* renamed from: b */
    public GetMatchPreferencesUseCase get() {
        return c(this.f34587a.get(), this.f34588b.get(), this.f34589c.get(), this.f34590d.get());
    }
}

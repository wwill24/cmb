package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class u implements d<LoadAgePreferenceUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f35204a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f35205b;

    /* renamed from: c  reason: collision with root package name */
    private final a<QuestionRepository> f35206c;

    /* renamed from: d  reason: collision with root package name */
    private final a<s9.a> f35207d;

    public u(a<UserRepository> aVar, a<ProfileRepositoryV2> aVar2, a<QuestionRepository> aVar3, a<s9.a> aVar4) {
        this.f35204a = aVar;
        this.f35205b = aVar2;
        this.f35206c = aVar3;
        this.f35207d = aVar4;
    }

    public static u a(a<UserRepository> aVar, a<ProfileRepositoryV2> aVar2, a<QuestionRepository> aVar3, a<s9.a> aVar4) {
        return new u(aVar, aVar2, aVar3, aVar4);
    }

    public static LoadAgePreferenceUseCase c(UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, QuestionRepository questionRepository, s9.a aVar) {
        return new LoadAgePreferenceUseCase(userRepository, profileRepositoryV2, questionRepository, aVar);
    }

    /* renamed from: b */
    public LoadAgePreferenceUseCase get() {
        return c(this.f35204a.get(), this.f35205b.get(), this.f35206c.get(), this.f35207d.get());
    }
}

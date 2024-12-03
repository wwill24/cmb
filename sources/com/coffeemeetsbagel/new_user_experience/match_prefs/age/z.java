package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class z implements d<SaveAgePreferenceUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<s9.a> f35213a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileManager> f35214b;

    /* renamed from: c  reason: collision with root package name */
    private final a<UserRepository> f35215c;

    /* renamed from: d  reason: collision with root package name */
    private final a<QuestionRepository> f35216d;

    public z(a<s9.a> aVar, a<ProfileManager> aVar2, a<UserRepository> aVar3, a<QuestionRepository> aVar4) {
        this.f35213a = aVar;
        this.f35214b = aVar2;
        this.f35215c = aVar3;
        this.f35216d = aVar4;
    }

    public static z a(a<s9.a> aVar, a<ProfileManager> aVar2, a<UserRepository> aVar3, a<QuestionRepository> aVar4) {
        return new z(aVar, aVar2, aVar3, aVar4);
    }

    public static SaveAgePreferenceUseCase c(s9.a aVar, ProfileManager profileManager, UserRepository userRepository, QuestionRepository questionRepository) {
        return new SaveAgePreferenceUseCase(aVar, profileManager, userRepository, questionRepository);
    }

    /* renamed from: b */
    public SaveAgePreferenceUseCase get() {
        return c(this.f35213a.get(), this.f35214b.get(), this.f35215c.get(), this.f35216d.get());
    }
}

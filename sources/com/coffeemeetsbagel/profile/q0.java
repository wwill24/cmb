package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class q0 implements d<SaveProfilesLocalUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f36135a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PhotoRepository> f36136b;

    /* renamed from: c  reason: collision with root package name */
    private final a<QuestionRepository> f36137c;

    public q0(a<ProfileRepositoryV2> aVar, a<PhotoRepository> aVar2, a<QuestionRepository> aVar3) {
        this.f36135a = aVar;
        this.f36136b = aVar2;
        this.f36137c = aVar3;
    }

    public static q0 a(a<ProfileRepositoryV2> aVar, a<PhotoRepository> aVar2, a<QuestionRepository> aVar3) {
        return new q0(aVar, aVar2, aVar3);
    }

    public static SaveProfilesLocalUseCase c(ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository) {
        return new SaveProfilesLocalUseCase(profileRepositoryV2, photoRepository, questionRepository);
    }

    /* renamed from: b */
    public SaveProfilesLocalUseCase get() {
        return c(this.f36135a.get(), this.f36136b.get(), this.f36137c.get());
    }
}

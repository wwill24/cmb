package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.d;
import fk.a;

public final class l0 implements d<RefreshMyProfileUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36118a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f36119b;

    /* renamed from: c  reason: collision with root package name */
    private final a<PhotoRepository> f36120c;

    /* renamed from: d  reason: collision with root package name */
    private final a<QuestionRepository> f36121d;

    /* renamed from: e  reason: collision with root package name */
    private final a<m> f36122e;

    public l0(a<UserRepository> aVar, a<ProfileRepositoryV2> aVar2, a<PhotoRepository> aVar3, a<QuestionRepository> aVar4, a<m> aVar5) {
        this.f36118a = aVar;
        this.f36119b = aVar2;
        this.f36120c = aVar3;
        this.f36121d = aVar4;
        this.f36122e = aVar5;
    }

    public static l0 a(a<UserRepository> aVar, a<ProfileRepositoryV2> aVar2, a<PhotoRepository> aVar3, a<QuestionRepository> aVar4, a<m> aVar5) {
        return new l0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static RefreshMyProfileUseCase c(UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository, m mVar) {
        return new RefreshMyProfileUseCase(userRepository, profileRepositoryV2, photoRepository, questionRepository, mVar);
    }

    /* renamed from: b */
    public RefreshMyProfileUseCase get() {
        return c(this.f36118a.get(), this.f36119b.get(), this.f36120c.get(), this.f36121d.get(), this.f36122e.get());
    }
}

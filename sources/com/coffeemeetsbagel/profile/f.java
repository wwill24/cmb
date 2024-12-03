package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import fj.d;
import fk.a;

public final class f implements d<GetMyOwnProfileTmpUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f36085a;

    /* renamed from: b  reason: collision with root package name */
    private final a<UserRepository> f36086b;

    /* renamed from: c  reason: collision with root package name */
    private final a<PhotoRepository> f36087c;

    /* renamed from: d  reason: collision with root package name */
    private final a<m> f36088d;

    public f(a<ProfileRepositoryV2> aVar, a<UserRepository> aVar2, a<PhotoRepository> aVar3, a<m> aVar4) {
        this.f36085a = aVar;
        this.f36086b = aVar2;
        this.f36087c = aVar3;
        this.f36088d = aVar4;
    }

    public static f a(a<ProfileRepositoryV2> aVar, a<UserRepository> aVar2, a<PhotoRepository> aVar3, a<m> aVar4) {
        return new f(aVar, aVar2, aVar3, aVar4);
    }

    public static GetMyOwnProfileTmpUseCase c(ProfileRepositoryV2 profileRepositoryV2, UserRepository userRepository, PhotoRepository photoRepository, m mVar) {
        return new GetMyOwnProfileTmpUseCase(profileRepositoryV2, userRepository, photoRepository, mVar);
    }

    /* renamed from: b */
    public GetMyOwnProfileTmpUseCase get() {
        return c(this.f36085a.get(), this.f36086b.get(), this.f36087c.get(), this.f36088d.get());
    }
}

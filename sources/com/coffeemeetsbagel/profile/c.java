package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import fj.d;
import fk.a;

public final class c implements d<GetMyOwnProfileLocalUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f36078a;

    /* renamed from: b  reason: collision with root package name */
    private final a<UserRepository> f36079b;

    public c(a<ProfileRepositoryV2> aVar, a<UserRepository> aVar2) {
        this.f36078a = aVar;
        this.f36079b = aVar2;
    }

    public static c a(a<ProfileRepositoryV2> aVar, a<UserRepository> aVar2) {
        return new c(aVar, aVar2);
    }

    public static GetMyOwnProfileLocalUseCase c(ProfileRepositoryV2 profileRepositoryV2, UserRepository userRepository) {
        return new GetMyOwnProfileLocalUseCase(profileRepositoryV2, userRepository);
    }

    /* renamed from: b */
    public GetMyOwnProfileLocalUseCase get() {
        return c(this.f36078a.get(), this.f36079b.get());
    }
}

package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import fj.d;
import fk.a;

public final class h implements d<GetProfileAvatarUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PhotoRepository> f36093a;

    public h(a<PhotoRepository> aVar) {
        this.f36093a = aVar;
    }

    public static h a(a<PhotoRepository> aVar) {
        return new h(aVar);
    }

    public static GetProfileAvatarUseCase c(PhotoRepository photoRepository) {
        return new GetProfileAvatarUseCase(photoRepository);
    }

    /* renamed from: b */
    public GetProfileAvatarUseCase get() {
        return c(this.f36093a.get());
    }
}

package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import fj.d;
import fk.a;

public final class f implements d<GetMyPhotosUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f34743a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PhotoRepository> f34744b;

    public f(a<UserRepository> aVar, a<PhotoRepository> aVar2) {
        this.f34743a = aVar;
        this.f34744b = aVar2;
    }

    public static f a(a<UserRepository> aVar, a<PhotoRepository> aVar2) {
        return new f(aVar, aVar2);
    }

    public static GetMyPhotosUseCase c(UserRepository userRepository, PhotoRepository photoRepository) {
        return new GetMyPhotosUseCase(userRepository, photoRepository);
    }

    /* renamed from: b */
    public GetMyPhotosUseCase get() {
        return c(this.f34743a.get(), this.f34744b.get());
    }
}

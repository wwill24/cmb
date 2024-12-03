package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import fj.d;
import fk.a;

public final class c implements d<DeleteMyPhotoUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f34739a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PhotoRepository> f34740b;

    public c(a<UserRepository> aVar, a<PhotoRepository> aVar2) {
        this.f34739a = aVar;
        this.f34740b = aVar2;
    }

    public static c a(a<UserRepository> aVar, a<PhotoRepository> aVar2) {
        return new c(aVar, aVar2);
    }

    public static DeleteMyPhotoUseCase c(UserRepository userRepository, PhotoRepository photoRepository) {
        return new DeleteMyPhotoUseCase(userRepository, photoRepository);
    }

    /* renamed from: b */
    public DeleteMyPhotoUseCase get() {
        return c(this.f34739a.get(), this.f34740b.get());
    }
}

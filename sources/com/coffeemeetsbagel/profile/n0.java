package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import fj.d;
import fk.a;

public final class n0 implements d<SaveMyProfileLocalUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36128a;

    /* renamed from: b  reason: collision with root package name */
    private final a<m> f36129b;

    public n0(a<UserRepository> aVar, a<m> aVar2) {
        this.f36128a = aVar;
        this.f36129b = aVar2;
    }

    public static n0 a(a<UserRepository> aVar, a<m> aVar2) {
        return new n0(aVar, aVar2);
    }

    public static SaveMyProfileLocalUseCase c(UserRepository userRepository, m mVar) {
        return new SaveMyProfileLocalUseCase(userRepository, mVar);
    }

    /* renamed from: b */
    public SaveMyProfileLocalUseCase get() {
        return c(this.f36128a.get(), this.f36129b.get());
    }
}

package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import fj.d;
import fk.a;

public final class s0 implements d<r0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<UserRepository> f36141a;

    public s0(a<UserRepository> aVar) {
        this.f36141a = aVar;
    }

    public static s0 a(a<UserRepository> aVar) {
        return new s0(aVar);
    }

    public static r0 c(UserRepository userRepository) {
        return new r0(userRepository);
    }

    /* renamed from: b */
    public r0 get() {
        return c(this.f36141a.get());
    }
}

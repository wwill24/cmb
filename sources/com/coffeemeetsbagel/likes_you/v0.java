package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import fj.d;
import fk.a;
import x4.r;

public final class v0 implements d<u0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<r> f34327a;

    /* renamed from: b  reason: collision with root package name */
    private final a<LikesYouMatchRepository> f34328b;

    public v0(a<r> aVar, a<LikesYouMatchRepository> aVar2) {
        this.f34327a = aVar;
        this.f34328b = aVar2;
    }

    public static v0 a(a<r> aVar, a<LikesYouMatchRepository> aVar2) {
        return new v0(aVar, aVar2);
    }

    public static u0 c(r rVar, LikesYouMatchRepository likesYouMatchRepository) {
        return new u0(rVar, likesYouMatchRepository);
    }

    /* renamed from: b */
    public u0 get() {
        return c(this.f34327a.get(), this.f34328b.get());
    }
}

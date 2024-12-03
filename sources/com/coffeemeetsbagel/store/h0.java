package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import fj.d;
import fk.a;
import u6.j;

public final class h0 implements d<PriceRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<i0> f36809a;

    /* renamed from: b  reason: collision with root package name */
    private final a<j> f36810b;

    /* renamed from: c  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f36811c;

    public h0(a<i0> aVar, a<j> aVar2, a<AuthenticationScopeProvider> aVar3) {
        this.f36809a = aVar;
        this.f36810b = aVar2;
        this.f36811c = aVar3;
    }

    public static h0 a(a<i0> aVar, a<j> aVar2, a<AuthenticationScopeProvider> aVar3) {
        return new h0(aVar, aVar2, aVar3);
    }

    public static PriceRepository c(i0 i0Var, j jVar, AuthenticationScopeProvider authenticationScopeProvider) {
        return new PriceRepository(i0Var, jVar, authenticationScopeProvider);
    }

    /* renamed from: b */
    public PriceRepository get() {
        return c(this.f36809a.get(), this.f36810b.get(), this.f36811c.get());
    }
}

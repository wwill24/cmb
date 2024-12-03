package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import fj.d;
import fj.g;
import fk.a;
import t8.k;

public final class n0 implements d<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f11322a;

    /* renamed from: b  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11323b;

    public n0(a<c7.d> aVar, a<AuthenticationScopeProvider> aVar2) {
        this.f11322a = aVar;
        this.f11323b = aVar2;
    }

    public static n0 a(a<c7.d> aVar, a<AuthenticationScopeProvider> aVar2) {
        return new n0(aVar, aVar2);
    }

    public static k c(c7.d dVar, AuthenticationScopeProvider authenticationScopeProvider) {
        return (k) g.e(c.L(dVar, authenticationScopeProvider));
    }

    /* renamed from: b */
    public k get() {
        return c(this.f11322a.get(), this.f11323b.get());
    }
}

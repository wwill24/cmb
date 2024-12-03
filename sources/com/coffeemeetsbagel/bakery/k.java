package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import fj.d;
import fj.g;

public final class k implements d<AuthenticationScopeProvider> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f11235a = new k();
    }

    public static AuthenticationScopeProvider a() {
        return (AuthenticationScopeProvider) g.e(c.h());
    }

    public static k b() {
        return a.f11235a;
    }

    /* renamed from: c */
    public AuthenticationScopeProvider get() {
        return a();
    }
}

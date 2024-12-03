package com.coffeemeetsbagel.components;

import com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent;
import gk.f;
import hi.a;
import hi.b;
import kotlin.jvm.internal.j;
import qj.q;

public final class AuthenticationScopeProvider implements b<AuthenticationEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<AuthenticationEvent> f11543a;

    /* renamed from: b  reason: collision with root package name */
    private final f f11544b = b.b(AuthenticationScopeProvider$function$2.f11545a);

    public AuthenticationScopeProvider() {
        com.jakewharton.rxrelay2.b<AuthenticationEvent> D0 = com.jakewharton.rxrelay2.b.D0(AuthenticationEvent.PRE_AUTHENTICATED);
        j.f(D0, "createDefault(\n        A…t.PRE_AUTHENTICATED\n    )");
        this.f11543a = D0;
    }

    private final a<AuthenticationEvent> c() {
        return (a) this.f11544b.getValue();
    }

    public final void a() {
        AuthenticationEvent E0 = this.f11543a.E0();
        AuthenticationEvent authenticationEvent = AuthenticationEvent.AUTHENTICATED;
        if (E0 != authenticationEvent) {
            this.f11543a.accept(authenticationEvent);
        }
    }

    public a<AuthenticationEvent> a1() {
        return c();
    }

    public final void b() {
        AuthenticationEvent E0 = this.f11543a.E0();
        AuthenticationEvent authenticationEvent = AuthenticationEvent.LOGGED_OUT;
        if (E0 != authenticationEvent) {
            this.f11543a.accept(authenticationEvent);
        }
    }

    /* renamed from: d */
    public AuthenticationEvent x0() {
        return this.f11543a.E0();
    }

    public q<AuthenticationEvent> x() {
        q<AuthenticationEvent> P = this.f11543a.P();
        j.f(P, "relay.hide()");
        return P;
    }
}

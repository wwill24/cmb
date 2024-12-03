package com.coffeemeetsbagel.bakery;

import android.content.Context;
import c9.i;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import d7.g;
import fj.d;
import fk.a;
import hb.c;
import u6.l;

public final class u0 implements d<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c> f11378a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f11379b;

    /* renamed from: c  reason: collision with root package name */
    private final a<g> f11380c;

    /* renamed from: d  reason: collision with root package name */
    private final a<l> f11381d;

    /* renamed from: e  reason: collision with root package name */
    private final a<ma.i> f11382e;

    /* renamed from: f  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11383f;

    public u0(a<c> aVar, a<Context> aVar2, a<g> aVar3, a<l> aVar4, a<ma.i> aVar5, a<AuthenticationScopeProvider> aVar6) {
        this.f11378a = aVar;
        this.f11379b = aVar2;
        this.f11380c = aVar3;
        this.f11381d = aVar4;
        this.f11382e = aVar5;
        this.f11383f = aVar6;
    }

    public static u0 a(a<c> aVar, a<Context> aVar2, a<g> aVar3, a<l> aVar4, a<ma.i> aVar5, a<AuthenticationScopeProvider> aVar6) {
        return new u0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static i c(c cVar, Context context, g gVar, l lVar, ma.i iVar, AuthenticationScopeProvider authenticationScopeProvider) {
        return (i) fj.g.e(c.S(cVar, context, gVar, lVar, iVar, authenticationScopeProvider));
    }

    /* renamed from: b */
    public i get() {
        return c(this.f11378a.get(), this.f11379b.get(), this.f11380c.get(), this.f11381d.get(), this.f11382e.get(), this.f11383f.get());
    }
}

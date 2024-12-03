package com.coffeemeetsbagel.bakery;

import android.net.ConnectivityManager;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import d7.g;
import f6.f2;
import fj.d;
import fk.a;
import k7.s;
import l8.h;
import r7.f;
import u6.e;

public final class q implements d<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11351a;

    /* renamed from: b  reason: collision with root package name */
    private final a<f2> f11352b;

    /* renamed from: c  reason: collision with root package name */
    private final a<g> f11353c;

    /* renamed from: d  reason: collision with root package name */
    private final a<ProfileManager> f11354d;

    /* renamed from: e  reason: collision with root package name */
    private final a<a7.a> f11355e;

    /* renamed from: f  reason: collision with root package name */
    private final a<com.coffeemeetsbagel.feature.bagel.s> f11356f;

    /* renamed from: g  reason: collision with root package name */
    private final a<ConnectivityManager> f11357g;

    /* renamed from: h  reason: collision with root package name */
    private final a<h> f11358h;

    /* renamed from: i  reason: collision with root package name */
    private final a<f> f11359i;

    /* renamed from: j  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11360j;

    /* renamed from: k  reason: collision with root package name */
    private final a<e> f11361k;

    public q(a<Bakery> aVar, a<f2> aVar2, a<g> aVar3, a<ProfileManager> aVar4, a<a7.a> aVar5, a<com.coffeemeetsbagel.feature.bagel.s> aVar6, a<ConnectivityManager> aVar7, a<h> aVar8, a<f> aVar9, a<AuthenticationScopeProvider> aVar10, a<e> aVar11) {
        this.f11351a = aVar;
        this.f11352b = aVar2;
        this.f11353c = aVar3;
        this.f11354d = aVar4;
        this.f11355e = aVar5;
        this.f11356f = aVar6;
        this.f11357g = aVar7;
        this.f11358h = aVar8;
        this.f11359i = aVar9;
        this.f11360j = aVar10;
        this.f11361k = aVar11;
    }

    public static s a(Bakery bakery, f2 f2Var, g gVar, ProfileManager profileManager, a7.a aVar, com.coffeemeetsbagel.feature.bagel.s sVar, ConnectivityManager connectivityManager, h hVar, f fVar, AuthenticationScopeProvider authenticationScopeProvider, e eVar) {
        return (s) fj.g.e(c.n(bakery, f2Var, gVar, profileManager, aVar, sVar, connectivityManager, hVar, fVar, authenticationScopeProvider, eVar));
    }

    public static q b(a<Bakery> aVar, a<f2> aVar2, a<g> aVar3, a<ProfileManager> aVar4, a<a7.a> aVar5, a<com.coffeemeetsbagel.feature.bagel.s> aVar6, a<ConnectivityManager> aVar7, a<h> aVar8, a<f> aVar9, a<AuthenticationScopeProvider> aVar10, a<e> aVar11) {
        return new q(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11);
    }

    /* renamed from: c */
    public s get() {
        return a(this.f11351a.get(), this.f11352b.get(), this.f11353c.get(), this.f11354d.get(), this.f11355e.get(), this.f11356f.get(), this.f11357g.get(), this.f11358h.get(), this.f11359i.get(), this.f11360j.get(), this.f11361k.get());
    }
}

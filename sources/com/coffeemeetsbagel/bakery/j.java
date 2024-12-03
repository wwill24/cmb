package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.experiment.t;
import d7.g;
import d7.l;
import fj.d;
import fk.a;
import hb.c;

public final class j implements d<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11222a;

    /* renamed from: b  reason: collision with root package name */
    private final a<bb.a> f11223b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f11224c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c7.d> f11225d;

    /* renamed from: e  reason: collision with root package name */
    private final a<b7.c> f11226e;

    /* renamed from: f  reason: collision with root package name */
    private final a<t> f11227f;

    /* renamed from: g  reason: collision with root package name */
    private final a<l> f11228g;

    /* renamed from: h  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11229h;

    /* renamed from: i  reason: collision with root package name */
    private final a<CmbDatabase> f11230i;

    /* renamed from: j  reason: collision with root package name */
    private final a<r> f11231j;

    public j(a<Bakery> aVar, a<bb.a> aVar2, a<c> aVar3, a<c7.d> aVar4, a<b7.c> aVar5, a<t> aVar6, a<l> aVar7, a<AuthenticationScopeProvider> aVar8, a<CmbDatabase> aVar9, a<r> aVar10) {
        this.f11222a = aVar;
        this.f11223b = aVar2;
        this.f11224c = aVar3;
        this.f11225d = aVar4;
        this.f11226e = aVar5;
        this.f11227f = aVar6;
        this.f11228g = aVar7;
        this.f11229h = aVar8;
        this.f11230i = aVar9;
        this.f11231j = aVar10;
    }

    public static g a(Bakery bakery, bb.a aVar, c cVar, c7.d dVar, b7.c cVar2, t tVar, l lVar, AuthenticationScopeProvider authenticationScopeProvider, CmbDatabase cmbDatabase, r rVar) {
        return (g) fj.g.e(c.g(bakery, aVar, cVar, dVar, cVar2, tVar, lVar, authenticationScopeProvider, cmbDatabase, rVar));
    }

    public static j b(a<Bakery> aVar, a<bb.a> aVar2, a<c> aVar3, a<c7.d> aVar4, a<b7.c> aVar5, a<t> aVar6, a<l> aVar7, a<AuthenticationScopeProvider> aVar8, a<CmbDatabase> aVar9, a<r> aVar10) {
        return new j(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10);
    }

    /* renamed from: c */
    public g get() {
        return a(this.f11222a.get(), this.f11223b.get(), this.f11224c.get(), this.f11225d.get(), this.f11226e.get(), this.f11227f.get(), this.f11228g.get(), this.f11229h.get(), this.f11230i.get(), this.f11231j.get());
    }
}

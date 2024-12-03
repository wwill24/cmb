package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import fj.g;
import wb.c;
import y6.a;

public final class d implements fj.d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<AuthenticationScopeProvider> f11076a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<UpgradeContract.Manager> f11077b;

    /* renamed from: c  reason: collision with root package name */
    private final fk.a<com.coffeemeetsbagel.database.room_mappers.a> f11078c;

    /* renamed from: d  reason: collision with root package name */
    private final fk.a<h> f11079d;

    /* renamed from: e  reason: collision with root package name */
    private final fk.a<a7.a> f11080e;

    /* renamed from: f  reason: collision with root package name */
    private final fk.a<c7.d> f11081f;

    /* renamed from: g  reason: collision with root package name */
    private final fk.a<c> f11082g;

    public d(fk.a<AuthenticationScopeProvider> aVar, fk.a<UpgradeContract.Manager> aVar2, fk.a<com.coffeemeetsbagel.database.room_mappers.a> aVar3, fk.a<h> aVar4, fk.a<a7.a> aVar5, fk.a<c7.d> aVar6, fk.a<c> aVar7) {
        this.f11076a = aVar;
        this.f11077b = aVar2;
        this.f11078c = aVar3;
        this.f11079d = aVar4;
        this.f11080e = aVar5;
        this.f11081f = aVar6;
        this.f11082g = aVar7;
    }

    public static a a(AuthenticationScopeProvider authenticationScopeProvider, UpgradeContract.Manager manager, com.coffeemeetsbagel.database.room_mappers.a aVar, h hVar, a7.a aVar2, c7.d dVar, c cVar) {
        return (a) g.e(c.a(authenticationScopeProvider, manager, aVar, hVar, aVar2, dVar, cVar));
    }

    public static d b(fk.a<AuthenticationScopeProvider> aVar, fk.a<UpgradeContract.Manager> aVar2, fk.a<com.coffeemeetsbagel.database.room_mappers.a> aVar3, fk.a<h> aVar4, fk.a<a7.a> aVar5, fk.a<c7.d> aVar6, fk.a<c> aVar7) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11076a.get(), this.f11077b.get(), this.f11078c.get(), this.f11079d.get(), this.f11080e.get(), this.f11081f.get(), this.f11082g.get());
    }
}

package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import d7.g;
import fj.d;
import fk.a;

public final class z implements d<v7.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PhotoRepository> f11396a;

    /* renamed from: b  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f11397b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y7.a> f11398c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c7.d> f11399d;

    /* renamed from: e  reason: collision with root package name */
    private final a<PurchaseManager> f11400e;

    /* renamed from: f  reason: collision with root package name */
    private final a<t7.a> f11401f;

    /* renamed from: g  reason: collision with root package name */
    private final a<g> f11402g;

    /* renamed from: h  reason: collision with root package name */
    private final a<y6.a> f11403h;

    /* renamed from: i  reason: collision with root package name */
    private final a<CmbDatabase> f11404i;

    /* renamed from: j  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11405j;

    /* renamed from: k  reason: collision with root package name */
    private final a<QuestionRepository> f11406k;

    public z(a<PhotoRepository> aVar, a<ProfileRepositoryV2> aVar2, a<y7.a> aVar3, a<c7.d> aVar4, a<PurchaseManager> aVar5, a<t7.a> aVar6, a<g> aVar7, a<y6.a> aVar8, a<CmbDatabase> aVar9, a<AuthenticationScopeProvider> aVar10, a<QuestionRepository> aVar11) {
        this.f11396a = aVar;
        this.f11397b = aVar2;
        this.f11398c = aVar3;
        this.f11399d = aVar4;
        this.f11400e = aVar5;
        this.f11401f = aVar6;
        this.f11402g = aVar7;
        this.f11403h = aVar8;
        this.f11404i = aVar9;
        this.f11405j = aVar10;
        this.f11406k = aVar11;
    }

    public static z a(a<PhotoRepository> aVar, a<ProfileRepositoryV2> aVar2, a<y7.a> aVar3, a<c7.d> aVar4, a<PurchaseManager> aVar5, a<t7.a> aVar6, a<g> aVar7, a<y6.a> aVar8, a<CmbDatabase> aVar9, a<AuthenticationScopeProvider> aVar10, a<QuestionRepository> aVar11) {
        return new z(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11);
    }

    public static v7.d b(PhotoRepository photoRepository, ProfileRepositoryV2 profileRepositoryV2, y7.a aVar, c7.d dVar, PurchaseManager purchaseManager, t7.a aVar2, g gVar, y6.a aVar3, CmbDatabase cmbDatabase, AuthenticationScopeProvider authenticationScopeProvider, QuestionRepository questionRepository) {
        return (v7.d) fj.g.e(c.w(photoRepository, profileRepositoryV2, aVar, dVar, purchaseManager, aVar2, gVar, aVar3, cmbDatabase, authenticationScopeProvider, questionRepository));
    }

    /* renamed from: c */
    public v7.d get() {
        return b(this.f11396a.get(), this.f11397b.get(), this.f11398c.get(), this.f11399d.get(), this.f11400e.get(), this.f11401f.get(), this.f11402g.get(), this.f11403h.get(), this.f11404i.get(), this.f11405j.get(), this.f11406k.get());
    }
}

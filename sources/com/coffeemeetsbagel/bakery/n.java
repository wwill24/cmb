package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.match.l;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.match.w;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import d7.g;
import fj.d;
import fk.a;
import hb.c;

public final class n implements d<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11309a;

    /* renamed from: b  reason: collision with root package name */
    private final a<PhotoRepository> f11310b;

    /* renamed from: c  reason: collision with root package name */
    private final a<ProfileRepositoryV2> f11311c;

    /* renamed from: d  reason: collision with root package name */
    private final a<PurchaseManager> f11312d;

    /* renamed from: e  reason: collision with root package name */
    private final a<l> f11313e;

    /* renamed from: f  reason: collision with root package name */
    private final a<ProfileManager> f11314f;

    /* renamed from: g  reason: collision with root package name */
    private final a<g> f11315g;

    /* renamed from: h  reason: collision with root package name */
    private final a<c> f11316h;

    /* renamed from: i  reason: collision with root package name */
    private final a<w> f11317i;

    /* renamed from: j  reason: collision with root package name */
    private final a<h7.a> f11318j;

    /* renamed from: k  reason: collision with root package name */
    private final a<j7.a> f11319k;

    /* renamed from: l  reason: collision with root package name */
    private final a<SaveProfilesLocalUseCase> f11320l;

    /* renamed from: m  reason: collision with root package name */
    private final a<u> f11321m;

    public n(a<AuthenticationScopeProvider> aVar, a<PhotoRepository> aVar2, a<ProfileRepositoryV2> aVar3, a<PurchaseManager> aVar4, a<l> aVar5, a<ProfileManager> aVar6, a<g> aVar7, a<c> aVar8, a<w> aVar9, a<h7.a> aVar10, a<j7.a> aVar11, a<SaveProfilesLocalUseCase> aVar12, a<u> aVar13) {
        this.f11309a = aVar;
        this.f11310b = aVar2;
        this.f11311c = aVar3;
        this.f11312d = aVar4;
        this.f11313e = aVar5;
        this.f11314f = aVar6;
        this.f11315g = aVar7;
        this.f11316h = aVar8;
        this.f11317i = aVar9;
        this.f11318j = aVar10;
        this.f11319k = aVar11;
        this.f11320l = aVar12;
        this.f11321m = aVar13;
    }

    public static s a(AuthenticationScopeProvider authenticationScopeProvider, PhotoRepository photoRepository, ProfileRepositoryV2 profileRepositoryV2, PurchaseManager purchaseManager, l lVar, ProfileManager profileManager, g gVar, c cVar, w wVar, h7.a aVar, j7.a aVar2, SaveProfilesLocalUseCase saveProfilesLocalUseCase, u uVar) {
        return (s) fj.g.e(c.k(authenticationScopeProvider, photoRepository, profileRepositoryV2, purchaseManager, lVar, profileManager, gVar, cVar, wVar, aVar, aVar2, saveProfilesLocalUseCase, uVar));
    }

    public static n b(a<AuthenticationScopeProvider> aVar, a<PhotoRepository> aVar2, a<ProfileRepositoryV2> aVar3, a<PurchaseManager> aVar4, a<l> aVar5, a<ProfileManager> aVar6, a<g> aVar7, a<c> aVar8, a<w> aVar9, a<h7.a> aVar10, a<j7.a> aVar11, a<SaveProfilesLocalUseCase> aVar12, a<u> aVar13) {
        return new n(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13);
    }

    /* renamed from: c */
    public s get() {
        return a(this.f11309a.get(), this.f11310b.get(), this.f11311c.get(), this.f11312d.get(), this.f11313e.get(), this.f11314f.get(), this.f11315g.get(), this.f11316h.get(), this.f11317i.get(), this.f11318j.get(), this.f11319k.get(), this.f11320l.get(), this.f11321m.get());
    }
}

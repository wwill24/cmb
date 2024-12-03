package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileTmpUseCase;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetTextAnswersUseCase;
import d7.g;
import fj.d;
import fk.a;
import hb.c;

public final class p0 implements d<ProfileManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11334a;

    /* renamed from: b  reason: collision with root package name */
    private final a<y7.a> f11335b;

    /* renamed from: c  reason: collision with root package name */
    private final a<g> f11336c;

    /* renamed from: d  reason: collision with root package name */
    private final a<t7.a> f11337d;

    /* renamed from: e  reason: collision with root package name */
    private final a<c> f11338e;

    /* renamed from: f  reason: collision with root package name */
    private final a<e7.d> f11339f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Bakery> f11340g;

    /* renamed from: h  reason: collision with root package name */
    private final a<ma.g> f11341h;

    /* renamed from: i  reason: collision with root package name */
    private final a<UserRepository> f11342i;

    /* renamed from: j  reason: collision with root package name */
    private final a<PhotoRepository> f11343j;

    /* renamed from: k  reason: collision with root package name */
    private final a<l5.c> f11344k;

    /* renamed from: l  reason: collision with root package name */
    private final a<GetTextAnswersUseCase> f11345l;

    /* renamed from: m  reason: collision with root package name */
    private final a<GetMyOwnProfileTmpUseCase> f11346m;

    /* renamed from: n  reason: collision with root package name */
    private final a<SaveProfilesLocalUseCase> f11347n;

    /* renamed from: o  reason: collision with root package name */
    private final a<SaveMyProfileLocalUseCase> f11348o;

    /* renamed from: p  reason: collision with root package name */
    private final a<RefreshMyProfileUseCase> f11349p;

    /* renamed from: q  reason: collision with root package name */
    private final a<r0> f11350q;

    public p0(a<AuthenticationScopeProvider> aVar, a<y7.a> aVar2, a<g> aVar3, a<t7.a> aVar4, a<c> aVar5, a<e7.d> aVar6, a<Bakery> aVar7, a<ma.g> aVar8, a<UserRepository> aVar9, a<PhotoRepository> aVar10, a<l5.c> aVar11, a<GetTextAnswersUseCase> aVar12, a<GetMyOwnProfileTmpUseCase> aVar13, a<SaveProfilesLocalUseCase> aVar14, a<SaveMyProfileLocalUseCase> aVar15, a<RefreshMyProfileUseCase> aVar16, a<r0> aVar17) {
        this.f11334a = aVar;
        this.f11335b = aVar2;
        this.f11336c = aVar3;
        this.f11337d = aVar4;
        this.f11338e = aVar5;
        this.f11339f = aVar6;
        this.f11340g = aVar7;
        this.f11341h = aVar8;
        this.f11342i = aVar9;
        this.f11343j = aVar10;
        this.f11344k = aVar11;
        this.f11345l = aVar12;
        this.f11346m = aVar13;
        this.f11347n = aVar14;
        this.f11348o = aVar15;
        this.f11349p = aVar16;
        this.f11350q = aVar17;
    }

    public static p0 a(a<AuthenticationScopeProvider> aVar, a<y7.a> aVar2, a<g> aVar3, a<t7.a> aVar4, a<c> aVar5, a<e7.d> aVar6, a<Bakery> aVar7, a<ma.g> aVar8, a<UserRepository> aVar9, a<PhotoRepository> aVar10, a<l5.c> aVar11, a<GetTextAnswersUseCase> aVar12, a<GetMyOwnProfileTmpUseCase> aVar13, a<SaveProfilesLocalUseCase> aVar14, a<SaveMyProfileLocalUseCase> aVar15, a<RefreshMyProfileUseCase> aVar16, a<r0> aVar17) {
        return new p0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17);
    }

    public static ProfileManager c(AuthenticationScopeProvider authenticationScopeProvider, y7.a aVar, g gVar, t7.a aVar2, c cVar, e7.d dVar, Bakery bakery, ma.g gVar2, UserRepository userRepository, PhotoRepository photoRepository, l5.c cVar2, GetTextAnswersUseCase getTextAnswersUseCase, GetMyOwnProfileTmpUseCase getMyOwnProfileTmpUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, SaveMyProfileLocalUseCase saveMyProfileLocalUseCase, RefreshMyProfileUseCase refreshMyProfileUseCase, r0 r0Var) {
        return (ProfileManager) fj.g.e(c.N(authenticationScopeProvider, aVar, gVar, aVar2, cVar, dVar, bakery, gVar2, userRepository, photoRepository, cVar2, getTextAnswersUseCase, getMyOwnProfileTmpUseCase, saveProfilesLocalUseCase, saveMyProfileLocalUseCase, refreshMyProfileUseCase, r0Var));
    }

    /* renamed from: b */
    public ProfileManager get() {
        return c(this.f11334a.get(), this.f11335b.get(), this.f11336c.get(), this.f11337d.get(), this.f11338e.get(), this.f11339f.get(), this.f11340g.get(), this.f11341h.get(), this.f11342i.get(), this.f11343j.get(), this.f11344k.get(), this.f11345l.get(), this.f11346m.get(), this.f11347n.get(), this.f11348o.get(), this.f11349p.get(), this.f11350q.get());
    }
}

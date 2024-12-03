package com.coffeemeetsbagel.discoverV2;

import a6.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.store.alc.d;
import kotlin.jvm.internal.j;
import l8.h;
import wb.c;

public final class k extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private PurchaseManager f12298i;

    /* renamed from: j  reason: collision with root package name */
    private ProfileManager f12299j;

    /* renamed from: k  reason: collision with root package name */
    private d f12300k;

    /* renamed from: l  reason: collision with root package name */
    private final c f12301l;

    /* renamed from: m  reason: collision with root package name */
    private v7.d f12302m;

    /* renamed from: n  reason: collision with root package name */
    private a f12303n;

    /* renamed from: o  reason: collision with root package name */
    private final UserRepository f12304o;

    /* renamed from: p  reason: collision with root package name */
    private b7.c f12305p;

    /* renamed from: q  reason: collision with root package name */
    private z f12306q;

    /* renamed from: r  reason: collision with root package name */
    private a7.a f12307r;

    /* renamed from: s  reason: collision with root package name */
    private t7.a f12308s;

    /* renamed from: t  reason: collision with root package name */
    private ProfileRepositoryV2 f12309t;

    /* renamed from: u  reason: collision with root package name */
    private r f12310u;

    /* renamed from: v  reason: collision with root package name */
    private m1 f12311v;

    /* renamed from: w  reason: collision with root package name */
    private h f12312w;

    public k(PurchaseManager purchaseManager, ProfileManager profileManager, d dVar, c cVar, v7.d dVar2, a aVar, UserRepository userRepository, b7.c cVar2, z zVar, a7.a aVar2, t7.a aVar3, ProfileRepositoryV2 profileRepositoryV2, r rVar, m1 m1Var, h hVar) {
        PurchaseManager purchaseManager2 = purchaseManager;
        ProfileManager profileManager2 = profileManager;
        d dVar3 = dVar;
        c cVar3 = cVar;
        v7.d dVar4 = dVar2;
        a aVar4 = aVar;
        UserRepository userRepository2 = userRepository;
        b7.c cVar4 = cVar2;
        z zVar2 = zVar;
        a7.a aVar5 = aVar2;
        t7.a aVar6 = aVar3;
        ProfileRepositoryV2 profileRepositoryV22 = profileRepositoryV2;
        r rVar2 = rVar;
        m1 m1Var2 = m1Var;
        h hVar2 = hVar;
        j.g(purchaseManager2, "purchaseManager");
        j.g(profileManager2, "profileManager");
        j.g(dVar3, "purchaseItemUseCase");
        j.g(cVar3, "getActiveSubscriptionUseCase");
        j.g(dVar4, "discoverManager");
        j.g(aVar4, "coachmarkManager");
        j.g(userRepository2, "userRepository");
        j.g(cVar4, "analyticsTrackingManager");
        j.g(zVar2, "matchAnalytics");
        j.g(aVar5, "analyticsManager");
        j.g(aVar6, "databaseManager");
        j.g(profileRepositoryV22, "profileRepositoryV2");
        j.g(rVar2, "featureManager");
        j.g(m1Var2, "managerSync");
        j.g(hVar2, "mongooseManager");
        this.f12298i = purchaseManager2;
        this.f12299j = profileManager2;
        this.f12300k = dVar3;
        this.f12301l = cVar3;
        this.f12302m = dVar4;
        this.f12303n = aVar4;
        this.f12304o = userRepository2;
        this.f12305p = cVar4;
        this.f12306q = zVar2;
        this.f12307r = aVar5;
        this.f12308s = aVar6;
        this.f12309t = profileRepositoryV22;
        this.f12310u = rVar2;
        this.f12311v = m1Var2;
        this.f12312w = hVar2;
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        PurchaseManager purchaseManager = this.f12298i;
        ProfileManager profileManager = this.f12299j;
        d dVar = this.f12300k;
        c cVar = this.f12301l;
        v7.d dVar2 = this.f12302m;
        a aVar2 = this.f12303n;
        UserRepository userRepository = this.f12304o;
        b7.c cVar2 = this.f12305p;
        z zVar = this.f12306q;
        a7.a aVar3 = this.f12307r;
        t7.a aVar4 = this.f12308s;
        ProfileRepositoryV2 profileRepositoryV2 = this.f12309t;
        r rVar = this.f12310u;
        return new DiscoverViewModel(purchaseManager, profileManager, dVar, cVar, dVar2, aVar2, userRepository, cVar2, zVar, aVar3, aVar4, profileRepositoryV2, rVar, this.f12311v, this.f12312w);
    }
}

package com.coffeemeetsbagel.bakery;

import c9.i;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.discover.DiscoverMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.sync.SyncBillingUseCase;
import com.coffeemeetsbagel.feature.sync.SyncSubscriptionHistoryUseCase;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.QuestionGroupRefreshUseCase;
import com.coffeemeetsbagel.store.PriceRepository;
import d7.g;
import d7.l;
import fj.d;
import fk.a;
import hb.c;

public final class k0 implements d<m1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<DiscoverMatchRepository> f11236a;

    /* renamed from: b  reason: collision with root package name */
    private final a<RefreshMyProfileUseCase> f11237b;

    /* renamed from: c  reason: collision with root package name */
    private final a<PriceRepository> f11238c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c> f11239d;

    /* renamed from: e  reason: collision with root package name */
    private final a<g> f11240e;

    /* renamed from: f  reason: collision with root package name */
    private final a<s> f11241f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Bakery> f11242g;

    /* renamed from: h  reason: collision with root package name */
    private final a<UpgradeContract.Manager> f11243h;

    /* renamed from: i  reason: collision with root package name */
    private final a<r> f11244i;

    /* renamed from: j  reason: collision with root package name */
    private final a<FeatureFlagRepository> f11245j;

    /* renamed from: k  reason: collision with root package name */
    private final a<t> f11246k;

    /* renamed from: l  reason: collision with root package name */
    private final a<i> f11247l;

    /* renamed from: m  reason: collision with root package name */
    private final a<h1> f11248m;

    /* renamed from: n  reason: collision with root package name */
    private final a<ProfileManager> f11249n;

    /* renamed from: o  reason: collision with root package name */
    private final a<l> f11250o;

    /* renamed from: p  reason: collision with root package name */
    private final a<UserRepository> f11251p;

    /* renamed from: q  reason: collision with root package name */
    private final a<SubscriptionRepository> f11252q;

    /* renamed from: r  reason: collision with root package name */
    private final a<u0> f11253r;

    /* renamed from: s  reason: collision with root package name */
    private final a<QuestionGroupRefreshUseCase> f11254s;

    /* renamed from: t  reason: collision with root package name */
    private final a<SyncBillingUseCase> f11255t;

    /* renamed from: u  reason: collision with root package name */
    private final a<SyncSubscriptionHistoryUseCase> f11256u;

    /* renamed from: v  reason: collision with root package name */
    private final a<SaveProfilesLocalUseCase> f11257v;

    /* renamed from: w  reason: collision with root package name */
    private final a<AuthenticationScopeProvider> f11258w;

    /* renamed from: x  reason: collision with root package name */
    private final a<SuggestedRepository> f11259x;

    public k0(a<DiscoverMatchRepository> aVar, a<RefreshMyProfileUseCase> aVar2, a<PriceRepository> aVar3, a<c> aVar4, a<g> aVar5, a<s> aVar6, a<Bakery> aVar7, a<UpgradeContract.Manager> aVar8, a<r> aVar9, a<FeatureFlagRepository> aVar10, a<t> aVar11, a<i> aVar12, a<h1> aVar13, a<ProfileManager> aVar14, a<l> aVar15, a<UserRepository> aVar16, a<SubscriptionRepository> aVar17, a<u0> aVar18, a<QuestionGroupRefreshUseCase> aVar19, a<SyncBillingUseCase> aVar20, a<SyncSubscriptionHistoryUseCase> aVar21, a<SaveProfilesLocalUseCase> aVar22, a<AuthenticationScopeProvider> aVar23, a<SuggestedRepository> aVar24) {
        this.f11236a = aVar;
        this.f11237b = aVar2;
        this.f11238c = aVar3;
        this.f11239d = aVar4;
        this.f11240e = aVar5;
        this.f11241f = aVar6;
        this.f11242g = aVar7;
        this.f11243h = aVar8;
        this.f11244i = aVar9;
        this.f11245j = aVar10;
        this.f11246k = aVar11;
        this.f11247l = aVar12;
        this.f11248m = aVar13;
        this.f11249n = aVar14;
        this.f11250o = aVar15;
        this.f11251p = aVar16;
        this.f11252q = aVar17;
        this.f11253r = aVar18;
        this.f11254s = aVar19;
        this.f11255t = aVar20;
        this.f11256u = aVar21;
        this.f11257v = aVar22;
        this.f11258w = aVar23;
        this.f11259x = aVar24;
    }

    public static k0 a(a<DiscoverMatchRepository> aVar, a<RefreshMyProfileUseCase> aVar2, a<PriceRepository> aVar3, a<c> aVar4, a<g> aVar5, a<s> aVar6, a<Bakery> aVar7, a<UpgradeContract.Manager> aVar8, a<r> aVar9, a<FeatureFlagRepository> aVar10, a<t> aVar11, a<i> aVar12, a<h1> aVar13, a<ProfileManager> aVar14, a<l> aVar15, a<UserRepository> aVar16, a<SubscriptionRepository> aVar17, a<u0> aVar18, a<QuestionGroupRefreshUseCase> aVar19, a<SyncBillingUseCase> aVar20, a<SyncSubscriptionHistoryUseCase> aVar21, a<SaveProfilesLocalUseCase> aVar22, a<AuthenticationScopeProvider> aVar23, a<SuggestedRepository> aVar24) {
        return new k0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20, aVar21, aVar22, aVar23, aVar24);
    }

    public static m1 c(DiscoverMatchRepository discoverMatchRepository, RefreshMyProfileUseCase refreshMyProfileUseCase, PriceRepository priceRepository, c cVar, g gVar, s sVar, Bakery bakery, UpgradeContract.Manager manager, r rVar, FeatureFlagRepository featureFlagRepository, t tVar, i iVar, h1 h1Var, ProfileManager profileManager, l lVar, UserRepository userRepository, SubscriptionRepository subscriptionRepository, u0 u0Var, QuestionGroupRefreshUseCase questionGroupRefreshUseCase, SyncBillingUseCase syncBillingUseCase, SyncSubscriptionHistoryUseCase syncSubscriptionHistoryUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, AuthenticationScopeProvider authenticationScopeProvider, SuggestedRepository suggestedRepository) {
        return (m1) fj.g.e(c.I(discoverMatchRepository, refreshMyProfileUseCase, priceRepository, cVar, gVar, sVar, bakery, manager, rVar, featureFlagRepository, tVar, iVar, h1Var, profileManager, lVar, userRepository, subscriptionRepository, u0Var, questionGroupRefreshUseCase, syncBillingUseCase, syncSubscriptionHistoryUseCase, saveProfilesLocalUseCase, authenticationScopeProvider, suggestedRepository));
    }

    /* renamed from: b */
    public m1 get() {
        return c(this.f11236a.get(), this.f11237b.get(), this.f11238c.get(), this.f11239d.get(), this.f11240e.get(), this.f11241f.get(), this.f11242g.get(), this.f11243h.get(), this.f11244i.get(), this.f11245j.get(), this.f11246k.get(), this.f11247l.get(), this.f11248m.get(), this.f11249n.get(), this.f11250o.get(), this.f11251p.get(), this.f11252q.get(), this.f11253r.get(), this.f11254s.get(), this.f11255t.get(), this.f11256u.get(), this.f11257v.get(), this.f11258w.get(), this.f11259x.get());
    }
}

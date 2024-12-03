package com.coffeemeetsbagel.bakery;

import a7.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import c7.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.discover.DiscoverMatchRepository;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.authentication.api.AuthenticationApi;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.chatlist.GetBagelUseCase;
import com.coffeemeetsbagel.feature.discover.api.DiscoverApi;
import com.coffeemeetsbagel.feature.firebase.FirebaseAnalyticsImpl;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseApi;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.feature.sync.SyncBillingUseCase;
import com.coffeemeetsbagel.feature.sync.SyncSubscriptionHistoryUseCase;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.match.w;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.profile.GetMyOwnProfileTmpUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetTextAnswersUseCase;
import com.coffeemeetsbagel.qna.QuestionGroupRefreshUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.stickers.StickerRepository;
import com.coffeemeetsbagel.store.PriceRepository;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.identity.IdentityApiRequest;
import d7.l;
import f6.a2;
import f6.f2;
import h5.i;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import lc.g;
import t8.j;
import t8.k;
import u6.e;
import u6.m;
import u6.n;
import z9.f;

public class c {

    class a implements y7.a {
        a() {
        }

        public boolean a(EventType eventType) {
            return i.b(eventType);
        }

        public boolean b(EventType eventType, Bundle bundle) {
            return i.c(eventType, bundle);
        }

        public void c(f fVar, EventType... eventTypeArr) {
            i.a(fVar, eventTypeArr);
        }

        public void d(f fVar, EventType... eventTypeArr) {
            i.d(fVar, eventTypeArr);
        }
    }

    class b implements p7.a {
        b() {
        }
    }

    /* renamed from: com.coffeemeetsbagel.bakery.c$c  reason: collision with other inner class name */
    class C0126c implements UpgradeContract.Manager {
        C0126c() {
        }

        public void addUpgradeListener(UpgradeContract.Manager.UpgradeListener upgradeListener) {
            i1.b(upgradeListener);
        }

        public void removeUpgradeListener(UpgradeContract.Manager.UpgradeListener upgradeListener) {
            i1.h(upgradeListener);
        }
    }

    static GetBagelUseCase A(f7.a aVar, ProfileRepositoryV2 profileRepositoryV2, f2 f2Var, e eVar) {
        return new GetBagelUseCase(aVar, f2.f(), eVar, profileRepositoryV2);
    }

    @SuppressLint({"MParticleInitialization"})
    private static void B(Bakery bakery) {
        MParticle.Environment environment;
        MParticle.LogLevel logLevel;
        IdentityApiRequest build = IdentityApiRequest.withEmptyUser().build();
        if (g.b()) {
            environment = MParticle.Environment.Production;
        } else {
            environment = MParticle.Environment.Development;
        }
        if (g.b()) {
            logLevel = MParticle.LogLevel.NONE;
        } else {
            logLevel = MParticle.LogLevel.DEBUG;
        }
        MParticle.start(MParticleOptions.builder(bakery).credentials(bakery.getString(R.string.mparticle_key), bakery.getString(R.string.mparticle_secret)).logLevel(logLevel).identify(build).environment(environment).attributionListener(new g5.a(bakery)).build());
    }

    static com.coffeemeetsbagel.feature.instagram.c C(d dVar, hb.c cVar) {
        return new com.coffeemeetsbagel.feature.instagram.c(new c8.a(dVar), cVar);
    }

    static l D() {
        return new l();
    }

    static q8.a E(Bakery bakery, h8.a aVar) {
        B(bakery);
        return new q8.l(aVar);
    }

    static h1 F(Bakery bakery) {
        h1.h(bakery);
        return h1.g();
    }

    static a7.a G(FirebaseContract.Analytics analytics, q8.a aVar, hb.c cVar, SubscriptionRepository subscriptionRepository, UserRepository userRepository, AuthenticationScopeProvider authenticationScopeProvider, ProfileRepositoryV2 profileRepositoryV2) {
        return new h(analytics, aVar, cVar, subscriptionRepository, userRepository, authenticationScopeProvider, profileRepositoryV2);
    }

    static y8.a H(a7.a aVar) {
        return new ManagerNotifications();
    }

    static m1 I(DiscoverMatchRepository discoverMatchRepository, RefreshMyProfileUseCase refreshMyProfileUseCase, PriceRepository priceRepository, hb.c cVar, d7.g gVar, s sVar, Bakery bakery, UpgradeContract.Manager manager, r rVar, FeatureFlagRepository featureFlagRepository, t tVar, c9.i iVar, h1 h1Var, ProfileManager profileManager, l lVar, UserRepository userRepository, SubscriptionRepository subscriptionRepository, u0 u0Var, QuestionGroupRefreshUseCase questionGroupRefreshUseCase, SyncBillingUseCase syncBillingUseCase, SyncSubscriptionHistoryUseCase syncSubscriptionHistoryUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, AuthenticationScopeProvider authenticationScopeProvider, SuggestedRepository suggestedRepository) {
        l lVar2 = lVar;
        u0 u0Var2 = u0Var;
        return new m1(bakery, discoverMatchRepository, refreshMyProfileUseCase, priceRepository, rVar, featureFlagRepository, tVar, sVar, gVar, iVar, Executors.newSingleThreadExecutor(), a2.m(bakery, cVar), cVar, h1Var, lVar2, u0Var2, profileManager, userRepository, subscriptionRepository, questionGroupRefreshUseCase, syncBillingUseCase, syncSubscriptionHistoryUseCase, saveProfilesLocalUseCase, authenticationScopeProvider, suggestedRepository);
    }

    static p9.d J(p9.c cVar) {
        return new p9.a(cVar);
    }

    static r7.f K(Context context) {
        return new r7.f(context);
    }

    static k L(d dVar, AuthenticationScopeProvider authenticationScopeProvider) {
        return new j(dVar, authenticationScopeProvider);
    }

    static t8.l M(PhotoRepository photoRepository, f2 f2Var, y7.a aVar, d7.g gVar, ProfileManager profileManager, k kVar) {
        return new t8.c(photoRepository, aVar, kVar, profileManager);
    }

    static ProfileManager N(AuthenticationScopeProvider authenticationScopeProvider, y7.a aVar, d7.g gVar, t7.a aVar2, hb.c cVar, e7.d dVar, Bakery bakery, ma.g gVar2, UserRepository userRepository, PhotoRepository photoRepository, l5.c cVar2, GetTextAnswersUseCase getTextAnswersUseCase, GetMyOwnProfileTmpUseCase getMyOwnProfileTmpUseCase, SaveProfilesLocalUseCase saveProfilesLocalUseCase, SaveMyProfileLocalUseCase saveMyProfileLocalUseCase, RefreshMyProfileUseCase refreshMyProfileUseCase, r0 r0Var) {
        return new ProfileManager(authenticationScopeProvider, aVar, gVar, aVar2, cVar, dVar, bakery, gVar2, userRepository, photoRepository, cVar2, getTextAnswersUseCase, getMyOwnProfileTmpUseCase, saveProfilesLocalUseCase, saveMyProfileLocalUseCase, refreshMyProfileUseCase, r0Var);
    }

    static PurchaseManager O(PriceRepository priceRepository, ProfileManager profileManager, a7.a aVar, PurchaseApi purchaseApi, AuthenticationScopeProvider authenticationScopeProvider) {
        return new PurchaseManager(priceRepository, profileManager, aVar, purchaseApi, authenticationScopeProvider);
    }

    static t P(y7.a aVar, a7.a aVar2) {
        return new a9.d(FirebaseRemoteConfig.getInstance(), aVar, aVar2);
    }

    static b9.a Q(y7.a aVar, a6.a aVar2) {
        return new b9.c(aVar, aVar2);
    }

    static Resources R(Bakery bakery) {
        return bakery.getResources();
    }

    static c9.i S(hb.c cVar, Context context, d7.g gVar, u6.l lVar, ma.i iVar, AuthenticationScopeProvider authenticationScopeProvider) {
        return new c9.i(cVar, context, gVar, lVar, iVar, authenticationScopeProvider);
    }

    static d T(hb.c cVar, j7.a aVar) {
        return new d9.d(new mc.a(), cVar, aVar);
    }

    static ga.b U() {
        return new h9.b(new h9.a("-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsS5lj7yxf75gstqf3ci2\n4gpzs/2vBk2RhkwjsFvBFgms8koWjAvadSsU5oKA4ynTzsJ8YjIn3rqt2WWDg7pG\nOXiZHDWBbZsLv2PlPYjmsjHRVWtyGiGpOB/+D0qa3zEmh79VofkTYsEYNUKlGvbb\ndF43P3yP+UPGDhLA2gAvyOIP8DdmIAgiAN942bwPY7evPyXCOveraoUyEq0B0lLv\nJGWtlD6C/52JH9+OCOhV0lHmrJEXDIsovyjb5O4TSxUCAb/m0BlFk0KhpkTz31/D\nJi84diJVXoyxcKrNGIyPwz6eYQfmxC/tzxCCT9iJ5XXG4wdsw/ogaNhcTEX86fR0\nzQIDAQAB\n-----END PUBLIC KEY-----", (String) null));
    }

    static g9.a V(Bakery bakery) {
        String str;
        try {
            str = bakery.getPackageManager().getPackageInfo(bakery.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            fa.a.i(e10);
            str = null;
        }
        return new g9.a(TimeZone.getDefault(), new u7.a(), Build.VERSION.RELEASE, str, Build.BRAND, Build.MODEL);
    }

    static ga.j W(Bakery bakery, g9.a aVar, hb.c cVar, ga.b bVar) {
        return new ga.j(bakery, aVar, cVar, bVar, g.c());
    }

    static cb.a X() {
        return new z9.a();
    }

    static hb.c Y(Bakery bakery) {
        return new hb.b(bakery);
    }

    static l9.e Z() {
        return new l9.e();
    }

    static y6.a a(AuthenticationScopeProvider authenticationScopeProvider, UpgradeContract.Manager manager, com.coffeemeetsbagel.database.room_mappers.a aVar, com.coffeemeetsbagel.database.daos.h hVar, a7.a aVar2, d dVar, wb.c cVar) {
        return new y6.l(authenticationScopeProvider, aVar, hVar, aVar2, dVar, cVar);
    }

    static StickerRepository a0(com.coffeemeetsbagel.stickers.d dVar, n nVar, hb.c cVar) {
        return new StickerRepository(dVar, nVar, cVar, 13778);
    }

    static com.coffeemeetsbagel.database.room_mappers.a b(CmbDatabase cmbDatabase) {
        return new com.coffeemeetsbagel.database.room_mappers.a(cmbDatabase);
    }

    static p9.c b0(d dVar) {
        return new p9.b(dVar);
    }

    static b7.b c(d dVar) {
        return new b7.a(dVar);
    }

    static UpgradeContract.Manager c0() {
        return new C0126c();
    }

    static b7.c d(r rVar, b7.b bVar) {
        return new b7.d(rVar, bVar);
    }

    static i5.a e() {
        return new i5.a();
    }

    static Context f(Bakery bakery) {
        return bakery;
    }

    static d7.g g(Bakery bakery, bb.a aVar, hb.c cVar, d dVar, b7.c cVar2, t tVar, l lVar, AuthenticationScopeProvider authenticationScopeProvider, CmbDatabase cmbDatabase, r rVar) {
        Bakery bakery2 = bakery;
        bb.a aVar2 = aVar;
        d dVar2 = dVar;
        t tVar2 = tVar;
        return new d7.g(cVar, new AuthenticationApi(aVar, bakery, dVar, tVar), cVar2, lVar, authenticationScopeProvider, cmbDatabase, rVar);
    }

    static AuthenticationScopeProvider h() {
        return new AuthenticationScopeProvider();
    }

    static e7.d i(a7.a aVar, Context context, hb.c cVar) {
        return new e7.d(aVar, context, cVar, Build.MANUFACTURER);
    }

    static com.coffeemeetsbagel.match.l j(f7.a aVar, t7.a aVar2, e eVar) {
        return new f7.c(aVar2, aVar, eVar);
    }

    static s k(AuthenticationScopeProvider authenticationScopeProvider, PhotoRepository photoRepository, ProfileRepositoryV2 profileRepositoryV2, PurchaseManager purchaseManager, com.coffeemeetsbagel.match.l lVar, ProfileManager profileManager, d7.g gVar, hb.c cVar, w wVar, h7.a aVar, j7.a aVar2, SaveProfilesLocalUseCase saveProfilesLocalUseCase, u uVar) {
        return new s(authenticationScopeProvider, photoRepository, profileRepositoryV2, purchaseManager, lVar, profileManager, gVar, wVar, aVar, cVar, aVar2, saveProfilesLocalUseCase, uVar);
    }

    static h7.a l(m mVar, nc.b bVar) {
        return new h7.a(mVar, 3, bVar);
    }

    static j7.a m(hb.c cVar, h1 h1Var) {
        return new j7.a(cVar, h1Var);
    }

    static k7.s n(Bakery bakery, f2 f2Var, d7.g gVar, ProfileManager profileManager, a7.a aVar, s sVar, ConnectivityManager connectivityManager, l8.h hVar, r7.f fVar, AuthenticationScopeProvider authenticationScopeProvider, e eVar) {
        return new k7.s(bakery, f2Var, gVar, profileManager, aVar, sVar, connectivityManager, hVar, fVar, authenticationScopeProvider, eVar);
    }

    static o7.a o(h1 h1Var, hb.c cVar) {
        return new o7.a(h1Var, cVar);
    }

    static tb.a p(Bakery bakery) {
        return new tb.a(bakery);
    }

    static tb.b q(tb.a aVar, Bakery bakery) {
        return new tb.b(bakery, aVar);
    }

    static p7.a r() {
        return new b();
    }

    static a6.a s(ProfileManager profileManager) {
        return new q7.a(profileManager);
    }

    static ConnectivityManager t(Bakery bakery) {
        return (ConnectivityManager) bakery.getSystemService("connectivity");
    }

    static lc.k u() {
        return new lc.k();
    }

    static nc.b v() {
        return new u7.a();
    }

    static v7.d w(PhotoRepository photoRepository, ProfileRepositoryV2 profileRepositoryV2, y7.a aVar, d dVar, PurchaseManager purchaseManager, t7.a aVar2, d7.g gVar, y6.a aVar3, CmbDatabase cmbDatabase, AuthenticationScopeProvider authenticationScopeProvider, QuestionRepository questionRepository) {
        return new v7.u(profileRepositoryV2, aVar, new DiscoverApi(dVar), new n9.b(), photoRepository, purchaseManager, aVar2, gVar, aVar3, cmbDatabase, authenticationScopeProvider, questionRepository);
    }

    static y7.a x() {
        return new a();
    }

    static h8.a y() {
        return new h5.l();
    }

    static FirebaseContract.Analytics z(Bakery bakery) {
        return new FirebaseAnalyticsImpl(FirebaseAnalytics.getInstance(bakery));
    }
}

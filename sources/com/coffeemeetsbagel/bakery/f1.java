package com.coffeemeetsbagel.bakery;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.b;
import com.coffeemeetsbagel.boost.BoostAnalytics;
import com.coffeemeetsbagel.boost.BoostDialogFragment;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.discover.DiscoverMatchRepository;
import com.coffeemeetsbagel.discoverV2.DiscoverFragment;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SkuDetailsRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.domain.repository.h0;
import com.coffeemeetsbagel.domain.repository.h3;
import com.coffeemeetsbagel.domain.repository.t2;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.chatlist.GetBagelConnectionUseCase;
import com.coffeemeetsbagel.feature.chatlist.GetBagelUseCase;
import com.coffeemeetsbagel.feature.discover.search.DiscoverFilterActivity;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.feature.logout.BannedActivity;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.religion.ReligionFragment;
import com.coffeemeetsbagel.feature.purchase.PurchaseApi;
import com.coffeemeetsbagel.feature.purchase.PurchaseApi_Factory;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.feature.sync.SyncBillingUseCase;
import com.coffeemeetsbagel.feature.sync.SyncSubscriptionHistoryUseCase;
import com.coffeemeetsbagel.feature.sync.v;
import com.coffeemeetsbagel.fragments.ContactUsFragment;
import com.coffeemeetsbagel.fragments.FragmentMyProfileDetails;
import com.coffeemeetsbagel.fragments.FragmentProfileEdit;
import com.coffeemeetsbagel.fragments.e5;
import com.coffeemeetsbagel.fragments.f5;
import com.coffeemeetsbagel.fragments.k4;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import com.coffeemeetsbagel.likes_you.h;
import com.coffeemeetsbagel.likes_you.m0;
import com.coffeemeetsbagel.likes_you.n0;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.limelight.LikesYouFragment;
import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.match.b0;
import com.coffeemeetsbagel.match.c0;
import com.coffeemeetsbagel.match.d0;
import com.coffeemeetsbagel.match.e0;
import com.coffeemeetsbagel.match.l;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.match.w;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.match_prefs.dealbreaker.DealBreakerSheetFragment;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.my_profile.DeleteMyPhotoUseCase;
import com.coffeemeetsbagel.my_profile.GetMyPhotosUseCase;
import com.coffeemeetsbagel.new_user_experience.OnboardingComponentActivity;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.phone_login.PhoneCodeActivity;
import com.coffeemeetsbagel.phone_login.country_code_picker.CountryCodePickerFragment;
import com.coffeemeetsbagel.phone_login.phone_number_input.PhoneInputFragment;
import com.coffeemeetsbagel.phone_login.verification_code.VerificationCodeFragment;
import com.coffeemeetsbagel.products.overflow_menu.OverFlowMenuAnalytics;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileTmpUseCase;
import com.coffeemeetsbagel.profile.GetProfileAvatarUseCase;
import com.coffeemeetsbagel.profile.LoadLocationUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.RefreshMyProfileUseCase;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.profile.l0;
import com.coffeemeetsbagel.profile.q0;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.profile.s0;
import com.coffeemeetsbagel.profile_me.MeProfileFragment;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.GetTextAnswersUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.QuestionGroupRefreshUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.UpdateLocationUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.data.SchoolRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.settings.SettingsActivity;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.stickers.StickerRepository;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PriceRepository;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.i0;
import com.coffeemeetsbagel.store.t0;
import com.coffeemeetsbagel.suggested_history.GetHistoryBagelUseCase;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import com.coffeemeetsbagel.whatsnew.ActivityWhatsNew;
import f6.b2;
import f6.c2;
import f6.d2;
import f6.f2;
import f6.x1;
import f6.y1;
import f8.y;
import ga.j;
import h5.a1;
import h5.b1;
import h5.c1;
import h5.d1;
import h5.e1;
import h5.f0;
import h5.g0;
import h5.j0;
import h5.k0;
import h5.o0;
import h5.p0;
import h5.v0;
import h5.w0;
import h5.x0;
import h5.y0;
import h5.z0;
import l8.j1;
import l8.k1;
import l8.l1;
import l8.o2;
import ma.g;
import ma.i;
import n5.h1;
import u6.e;
import u6.f;
import u6.k;
import u6.m;
import u6.n;
import u6.o;
import u6.p;
import u6.q;
import wb.c;
import x4.r;
import za.d;

public final class f1 {

    private static final class a implements b {
        private fk.a<c> A0;
        private fk.a<f> A1;
        private fk.a<p7.a> A2;
        private fk.a<u6.b> B;
        private fk.a<SkuDetailsRepository> B0;
        private fk.a<a0> B1;
        private fk.a<b9.a> B2;
        private fk.a<u6.c> C;
        private fk.a<com.coffeemeetsbagel.discover.f> C0;
        private fk.a<ma.a> C1;
        private fk.a<g9.a> C2;
        private fk.a<p> D;
        private fk.a<DiscoverMatchRepository> D0;
        private fk.a<u6.a> D1;
        private fk.a<j> D2;
        private fk.a<o> E;
        private fk.a<f7.a> E0;
        private fk.a<ActionCardRepository> E1;
        private fk.a<o7.a> E2;
        private fk.a<g> F;
        private fk.a<e> F0;
        private fk.a<GetFirstEligibleActionCardUseCase> F1;
        private fk.a<q> G;
        private fk.a<l> G0;
        private fk.a<l9.e> G1;
        private fk.a<d> H;
        private fk.a<nc.b> H0;
        private fk.a<l5.a> H1;
        private fk.a<s9.a> I;
        private fk.a<w> I0;
        private fk.a<BagelRepository> I1;
        private fk.a<UserRepository> J;
        private fk.a<m> J0;
        private fk.a<UpdateBagelLocalUseCase> J1;
        private fk.a<SubscriptionRepository> K;
        private fk.a<h7.a> K0;
        private fk.a<PurchaseRepository<Bagel>> K1;
        private fk.a<k> L;
        private fk.a<u> L0;
        private fk.a<com.coffeemeetsbagel.store.alc.b> L1;
        private fk.a<ProfileRepositoryV2> M;
        private fk.a<s> M0;
        private fk.a<com.coffeemeetsbagel.instant_like.d> M1;
        private fk.a<a7.a> N;
        private fk.a<UpgradeContract.Manager> N0;
        private fk.a<com.coffeemeetsbagel.qna.j> N1;
        private fk.a<y7.a> O;
        private fk.a<u6.l> O0;
        private fk.a<DeletePromptAnswerUseCase> O1;
        private fk.a<com.coffeemeetsbagel.feature.instagram.c> P;
        private fk.a<i> P0;
        private fk.a<com.coffeemeetsbagel.match.d> P1;
        private fk.a<p9.c> Q;
        private fk.a<c9.i> Q0;
        private fk.a<x> Q1;
        private fk.a<p9.d> R;
        private fk.a<r> R0;
        private fk.a<wb.a> R1;
        private fk.a<Resources> S;
        private fk.a<u6.g> S0;
        private fk.a<com.coffeemeetsbagel.qna.e> S1;
        private fk.a<bb.a> T;
        private fk.a<b0> T0;
        private fk.a<com.coffeemeetsbagel.qna.g> T1;
        private fk.a<b7.b> U;
        private fk.a<za.a> U0;
        private fk.a<z> U1;
        private fk.a<b7.c> V;
        private fk.a<ma.e> V0;
        private fk.a<SaveAnswerUseCase> V1;
        private fk.a<t> W;
        private fk.a<com.coffeemeetsbagel.likes_you.b> W0;
        private fk.a<c9.a> W1;
        private fk.a<d7.l> X;
        private fk.a<h> X0;
        private fk.a<GetBagelUseCase> X1;
        private fk.a<d7.g> Y;
        private fk.a<com.coffeemeetsbagel.likes_you.m> Y0;
        private fk.a<PurchaseRepository<Boolean>> Y1;
        private fk.a<f2> Z;
        private fk.a<com.coffeemeetsbagel.likes_you.f> Z0;
        private fk.a<com.coffeemeetsbagel.store.alc.d> Z1;

        /* renamed from: a  reason: collision with root package name */
        private final Bakery f11094a;

        /* renamed from: a0  reason: collision with root package name */
        private fk.a<t7.a> f11095a0;

        /* renamed from: a1  reason: collision with root package name */
        private fk.a<LikesYouMatchRepository> f11096a1;

        /* renamed from: a2  reason: collision with root package name */
        private fk.a<GetLastPassedBagelUseCase> f11097a2;

        /* renamed from: b  reason: collision with root package name */
        private final a f11098b;

        /* renamed from: b0  reason: collision with root package name */
        private fk.a<e7.d> f11099b0;

        /* renamed from: b1  reason: collision with root package name */
        private fk.a<u0> f11100b1;

        /* renamed from: b2  reason: collision with root package name */
        private fk.a<t8.k> f11101b2;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<Bakery> f11102c;

        /* renamed from: c0  reason: collision with root package name */
        private fk.a<u6.i> f11103c0;

        /* renamed from: c1  reason: collision with root package name */
        private fk.a<QuestionGroupRefreshUseCase> f11104c1;

        /* renamed from: c2  reason: collision with root package name */
        private fk.a<t8.l> f11105c2;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<hb.c> f11106d;

        /* renamed from: d0  reason: collision with root package name */
        private fk.a<PhotoRepository> f11107d0;

        /* renamed from: d1  reason: collision with root package name */
        private fk.a<ma.c> f11108d1;

        /* renamed from: d2  reason: collision with root package name */
        private fk.a<GetUserMCQUseCase> f11109d2;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<h1> f11110e;

        /* renamed from: e0  reason: collision with root package name */
        private fk.a<u6.d> f11111e0;

        /* renamed from: e1  reason: collision with root package name */
        private fk.a<SyncBillingUseCase> f11112e1;

        /* renamed from: e2  reason: collision with root package name */
        private fk.a<GetMatchPreferencesUseCase> f11113e2;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<j7.a> f11114f;

        /* renamed from: f0  reason: collision with root package name */
        private fk.a<cb.a> f11115f0;

        /* renamed from: f1  reason: collision with root package name */
        private fk.a<SyncSubscriptionHistoryUseCase> f11116f1;

        /* renamed from: f2  reason: collision with root package name */
        private fk.a<eb.a> f11117f2;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<c7.d> f11118g;

        /* renamed from: g0  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.domain.repository.m> f11119g0;

        /* renamed from: g1  reason: collision with root package name */
        private fk.a<ma.k> f11120g1;

        /* renamed from: g2  reason: collision with root package name */
        private fk.a<SchoolRepository> f11121g2;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.experiment.s> f11122h;

        /* renamed from: h0  reason: collision with root package name */
        private fk.a<l5.c> f11123h0;

        /* renamed from: h1  reason: collision with root package name */
        private fk.a<yb.c> f11124h1;

        /* renamed from: h2  reason: collision with root package name */
        private fk.a<GetSingleSchoolsUseCase> f11125h2;

        /* renamed from: i0  reason: collision with root package name */
        private fk.a<ma.f> f11126i0;

        /* renamed from: i1  reason: collision with root package name */
        private fk.a<SuggestedRepository> f11127i1;

        /* renamed from: i2  reason: collision with root package name */
        private fk.a<LoadAgePreferenceUseCase> f11128i2;

        /* renamed from: j  reason: collision with root package name */
        private fk.a<FeatureFlagRepository> f11129j;

        /* renamed from: j0  reason: collision with root package name */
        private fk.a<ma.b> f11130j0;

        /* renamed from: j1  reason: collision with root package name */
        private fk.a<m1> f11131j1;

        /* renamed from: j2  reason: collision with root package name */
        private fk.a<SaveAgePreferenceUseCase> f11132j2;

        /* renamed from: k  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.experiment.r> f11133k;

        /* renamed from: k0  reason: collision with root package name */
        private fk.a<za.e> f11134k0;

        /* renamed from: k1  reason: collision with root package name */
        private fk.a<lc.k> f11135k1;

        /* renamed from: k2  reason: collision with root package name */
        private fk.a<wb.e> f11136k2;

        /* renamed from: l  reason: collision with root package name */
        private fk.a<FirebaseContract.Analytics> f11137l;

        /* renamed from: l0  reason: collision with root package name */
        private fk.a<ma.h> f11138l0;

        /* renamed from: l1  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.database.room_mappers.a> f11139l1;

        /* renamed from: l2  reason: collision with root package name */
        private fk.a<GetHistoryBagelUseCase> f11140l2;

        /* renamed from: m  reason: collision with root package name */
        private fk.a<h8.a> f11141m;

        /* renamed from: m0  reason: collision with root package name */
        private fk.a<QuestionRepository> f11142m0;

        /* renamed from: m1  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.database.daos.h> f11143m1;

        /* renamed from: m2  reason: collision with root package name */
        private fk.a<GetProfileAvatarUseCase> f11144m2;

        /* renamed from: n  reason: collision with root package name */
        private fk.a<q8.a> f11145n;

        /* renamed from: n0  reason: collision with root package name */
        private fk.a<GetTextAnswersUseCase> f11146n0;

        /* renamed from: n1  reason: collision with root package name */
        private fk.a<y6.a> f11147n1;

        /* renamed from: n2  reason: collision with root package name */
        private fk.a<y8.a> f11148n2;

        /* renamed from: o0  reason: collision with root package name */
        private fk.a<GetMyOwnProfileTmpUseCase> f11149o0;

        /* renamed from: o1  reason: collision with root package name */
        private fk.a<v7.d> f11150o1;

        /* renamed from: o2  reason: collision with root package name */
        private fk.a<sa.a> f11151o2;

        /* renamed from: p  reason: collision with root package name */
        private fk.a<Context> f11152p;

        /* renamed from: p0  reason: collision with root package name */
        private fk.a<SaveProfilesLocalUseCase> f11153p0;

        /* renamed from: p1  reason: collision with root package name */
        private fk.a<ConnectivityManager> f11154p1;

        /* renamed from: p2  reason: collision with root package name */
        private fk.a<p5.b> f11155p2;

        /* renamed from: q  reason: collision with root package name */
        private fk.a<CmbBillingClient> f11156q;

        /* renamed from: q0  reason: collision with root package name */
        private fk.a<SaveMyProfileLocalUseCase> f11157q0;

        /* renamed from: q1  reason: collision with root package name */
        private fk.a<u6.h> f11158q1;

        /* renamed from: q2  reason: collision with root package name */
        private fk.a<com.coffeemeetsbagel.stickers.d> f11159q2;

        /* renamed from: r0  reason: collision with root package name */
        private fk.a<RefreshMyProfileUseCase> f11160r0;

        /* renamed from: r1  reason: collision with root package name */
        private fk.a<n8.s> f11161r1;

        /* renamed from: r2  reason: collision with root package name */
        private fk.a<n> f11162r2;

        /* renamed from: s0  reason: collision with root package name */
        private fk.a<r0> f11163s0;

        /* renamed from: s1  reason: collision with root package name */
        private fk.a<l8.e> f11164s1;

        /* renamed from: s2  reason: collision with root package name */
        private fk.a<StickerRepository> f11165s2;

        /* renamed from: t  reason: collision with root package name */
        private fk.a<ma.j> f11166t;

        /* renamed from: t0  reason: collision with root package name */
        private fk.a<ProfileManager> f11167t0;

        /* renamed from: t1  reason: collision with root package name */
        private fk.a<o2> f11168t1;

        /* renamed from: t2  reason: collision with root package name */
        private fk.a<UpdateLocationUseCase> f11169t2;

        /* renamed from: u0  reason: collision with root package name */
        private fk.a<i0> f11170u0;

        /* renamed from: u1  reason: collision with root package name */
        private fk.a<r7.f> f11171u1;

        /* renamed from: u2  reason: collision with root package name */
        private fk.a<m5.a> f11172u2;

        /* renamed from: v0  reason: collision with root package name */
        private fk.a<u6.j> f11173v0;

        /* renamed from: v1  reason: collision with root package name */
        private fk.a<i5.a> f11174v1;

        /* renamed from: v2  reason: collision with root package name */
        private fk.a<GetBagelConnectionUseCase> f11175v2;

        /* renamed from: w  reason: collision with root package name */
        private fk.a<tb.a> f11176w;

        /* renamed from: w0  reason: collision with root package name */
        private fk.a<PriceRepository> f11177w0;

        /* renamed from: w1  reason: collision with root package name */
        private fk.a<l8.h> f11178w1;

        /* renamed from: w2  reason: collision with root package name */
        private fk.a<GetMyPhotosUseCase> f11179w2;

        /* renamed from: x  reason: collision with root package name */
        private fk.a<tb.b> f11180x;

        /* renamed from: x0  reason: collision with root package name */
        private fk.a<PurchaseApi> f11181x0;

        /* renamed from: x1  reason: collision with root package name */
        private fk.a<k7.s> f11182x1;

        /* renamed from: x2  reason: collision with root package name */
        private fk.a<DeleteMyPhotoUseCase> f11183x2;

        /* renamed from: y  reason: collision with root package name */
        private fk.a<x1> f11184y;

        /* renamed from: y0  reason: collision with root package name */
        private fk.a<PurchaseManager> f11185y0;

        /* renamed from: y1  reason: collision with root package name */
        private fk.a<a6.a> f11186y1;

        /* renamed from: y2  reason: collision with root package name */
        private fk.a<ga.b> f11187y2;

        /* renamed from: z  reason: collision with root package name */
        private fk.a<CmbDatabase> f11188z;

        /* renamed from: z0  reason: collision with root package name */
        private fk.a<GetMyOwnProfileLocalUseCase> f11189z0;

        /* renamed from: z1  reason: collision with root package name */
        private fk.a<n0> f11190z1;

        /* renamed from: z2  reason: collision with root package name */
        private fk.a<BoostAnalytics> f11191z2;

        private a(c cVar, com.coffeemeetsbagel.experiment.a aVar, Bakery bakery) {
            this.f11098b = this;
            this.f11094a = bakery;
            k2(cVar, aVar, bakery);
            l2(cVar, aVar, bakery);
        }

        private EducationFragment A2(EducationFragment educationFragment) {
            com.coffeemeetsbagel.feature.profile_completion_helper.education.e.a(educationFragment, f2());
            return educationFragment;
        }

        private EthnicityFragment B2(EthnicityFragment ethnicityFragment) {
            com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.b.a(ethnicityFragment, this.f11129j.get());
            com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.b.b(ethnicityFragment, g2());
            return ethnicityFragment;
        }

        private g8.l C2(g8.l lVar) {
            g8.m.b(lVar, this.f11169t2.get());
            g8.m.a(lVar, W2());
            return lVar;
        }

        private f8.n D2(f8.n nVar) {
            f8.o.b(nVar, this.f11179w2.get());
            f8.o.a(nVar, this.f11183x2.get());
            return nVar;
        }

        private FragmentMyProfileDetails E2(FragmentMyProfileDetails fragmentMyProfileDetails) {
            k4.a(fragmentMyProfileDetails, this.f11133k.get());
            k4.f(fragmentMyProfileDetails, this.f11109d2.get());
            k4.b(fragmentMyProfileDetails, this.S1.get());
            k4.c(fragmentMyProfileDetails, this.N1.get());
            k4.g(fragmentMyProfileDetails, this.V1.get());
            k4.d(fragmentMyProfileDetails, this.W1.get());
            k4.e(fragmentMyProfileDetails, this.f11125h2.get());
            k4.i(fragmentMyProfileDetails, this.f11153p0.get());
            k4.h(fragmentMyProfileDetails, this.f11157q0.get());
            return fragmentMyProfileDetails;
        }

        private f8.x F2(f8.x xVar) {
            y.a(xVar, this.W1.get());
            y.b(xVar, this.f11125h2.get());
            return xVar;
        }

        private e5 G2(e5 e5Var) {
            f5.b(e5Var, this.f11153p0.get());
            f5.a(e5Var, this.f11186y1.get());
            return e5Var;
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a H2(com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a aVar) {
            com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.b.a(aVar, j2());
            return aVar;
        }

        private LikesYouFragment I2(LikesYouFragment likesYouFragment) {
            com.coffeemeetsbagel.limelight.g.a(likesYouFragment, this.f11129j.get());
            com.coffeemeetsbagel.limelight.g.c(likesYouFragment, V2());
            com.coffeemeetsbagel.limelight.g.b(likesYouFragment, this.W.get());
            return likesYouFragment;
        }

        private MatchPreferencesFragment J2(MatchPreferencesFragment matchPreferencesFragment) {
            com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.k.b(matchPreferencesFragment, X2());
            com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.k.a(matchPreferencesFragment, this.f11129j.get());
            return matchPreferencesFragment;
        }

        private MeProfileFragment K2(MeProfileFragment meProfileFragment) {
            com.coffeemeetsbagel.profile_me.l.a(meProfileFragment, this.N.get());
            com.coffeemeetsbagel.profile_me.l.b(meProfileFragment, this.f11133k.get());
            com.coffeemeetsbagel.profile_me.l.c(meProfileFragment, Y2());
            return meProfileFragment;
        }

        private MongooseSyncJobService L2(MongooseSyncJobService mongooseSyncJobService) {
            com.coffeemeetsbagel.feature.mongoose.sync.a.e(mongooseSyncJobService, this.f11106d.get());
            com.coffeemeetsbagel.feature.mongoose.sync.a.f(mongooseSyncJobService, this.f11168t1.get());
            com.coffeemeetsbagel.feature.mongoose.sync.a.c(mongooseSyncJobService, this.f11161r1.get());
            com.coffeemeetsbagel.feature.mongoose.sync.a.a(mongooseSyncJobService, this.N.get());
            com.coffeemeetsbagel.feature.mongoose.sync.a.d(mongooseSyncJobService, this.f11178w1.get());
            com.coffeemeetsbagel.feature.mongoose.sync.a.b(mongooseSyncJobService, this.f11174v1.get());
            return mongooseSyncJobService;
        }

        private NotificationWorkManagerWorker M2(NotificationWorkManagerWorker notificationWorkManagerWorker) {
            com.coffeemeetsbagel.feature.notifications.a.a(notificationWorkManagerWorker, this.f11137l.get());
            com.coffeemeetsbagel.feature.notifications.a.c(notificationWorkManagerWorker, this.W.get());
            com.coffeemeetsbagel.feature.notifications.a.b(notificationWorkManagerWorker, this.f11144m2.get());
            return notificationWorkManagerWorker;
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a N2(com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a aVar) {
            com.coffeemeetsbagel.feature.profile_completion_helper.occupation.b.a(aVar, Z2());
            return aVar;
        }

        private OnboardingComponentActivity O2(OnboardingComponentActivity onboardingComponentActivity) {
            com.coffeemeetsbagel.new_user_experience.m.a(onboardingComponentActivity, this.N.get());
            com.coffeemeetsbagel.new_user_experience.m.b(onboardingComponentActivity, this.f11106d.get());
            return onboardingComponentActivity;
        }

        private PhoneCodeActivity P2(PhoneCodeActivity phoneCodeActivity) {
            com.coffeemeetsbagel.phone_login.a.c(phoneCodeActivity, b3());
            com.coffeemeetsbagel.phone_login.a.b(phoneCodeActivity, this.f11167t0.get());
            com.coffeemeetsbagel.phone_login.a.a(phoneCodeActivity, this.N.get());
            return phoneCodeActivity;
        }

        private PhoneInputFragment Q2(PhoneInputFragment phoneInputFragment) {
            com.coffeemeetsbagel.phone_login.phone_number_input.i.a(phoneInputFragment, this.N.get());
            return phoneInputFragment;
        }

        private ProfileCompletionHelperActivity R2(ProfileCompletionHelperActivity profileCompletionHelperActivity) {
            com.coffeemeetsbagel.feature.profile_completion_helper.c.a(profileCompletionHelperActivity, c3());
            return profileCompletionHelperActivity;
        }

        private ReligionFragment S2(ReligionFragment religionFragment) {
            com.coffeemeetsbagel.feature.profile_completion_helper.religion.b.a(religionFragment, this.f11129j.get());
            com.coffeemeetsbagel.feature.profile_completion_helper.religion.b.b(religionFragment, d3());
            return religionFragment;
        }

        private SettingsActivity T2(SettingsActivity settingsActivity) {
            com.coffeemeetsbagel.settings.d.b(settingsActivity, e3());
            com.coffeemeetsbagel.settings.d.a(settingsActivity, this.f11129j.get());
            return settingsActivity;
        }

        private VerificationCodeFragment U2(VerificationCodeFragment verificationCodeFragment) {
            com.coffeemeetsbagel.phone_login.verification_code.h.b(verificationCodeFragment, this.Y.get());
            com.coffeemeetsbagel.phone_login.verification_code.h.a(verificationCodeFragment, this.N.get());
            com.coffeemeetsbagel.phone_login.verification_code.h.c(verificationCodeFragment, this.W.get());
            return verificationCodeFragment;
        }

        private m0 V2() {
            return new m0(this.N.get(), this.f11186y1.get(), this.H1.get(), this.T.get(), this.f11096a1.get(), this.f11129j.get());
        }

        private LoadLocationUseCase W2() {
            return new LoadLocationUseCase(e(), this.f11142m0.get(), this.I.get(), this.f11167t0.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.l X2() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.l(this.f11113e2.get(), this.f11186y1.get(), this.V1.get());
        }

        private com.coffeemeetsbagel.profile_me.m Y2() {
            return new com.coffeemeetsbagel.profile_me.m(this.f11185y0.get(), this.N.get(), this.f11189z0.get(), this.A0.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.occupation.c Z2() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.occupation.c(e(), i2(), this.V1.get());
        }

        private com.coffeemeetsbagel.feature.logout.m a2() {
            return new com.coffeemeetsbagel.feature.logout.m(this.f11106d.get());
        }

        private OverFlowMenuAnalytics a3() {
            return new OverFlowMenuAnalytics(this.N.get());
        }

        private com.coffeemeetsbagel.boost.i b2() {
            return new com.coffeemeetsbagel.boost.i(this.f11185y0.get(), this.f11167t0.get(), this.Z1.get(), this.K.get());
        }

        private com.coffeemeetsbagel.phone_login.b b3() {
            return new com.coffeemeetsbagel.phone_login.b(this.f11118g.get(), this.f11187y2.get(), this.W.get());
        }

        private p5.a c2() {
            return new p5.a(this.f11106d.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.e c3() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.e(this.f11189z0.get(), this.N1.get(), this.f11186y1.get());
        }

        private com.coffeemeetsbagel.match_prefs.dealbreaker.d d2() {
            return new com.coffeemeetsbagel.match_prefs.dealbreaker.d(this.f11186y1.get(), this.f11142m0.get(), e());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.religion.f d3() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.religion.f(e(), i2(), this.V1.get());
        }

        private com.coffeemeetsbagel.discoverV2.k e2() {
            return new com.coffeemeetsbagel.discoverV2.k(this.f11185y0.get(), this.f11167t0.get(), this.Z1.get(), this.A0.get(), this.f11150o1.get(), this.f11186y1.get(), e(), this.V.get(), this.U1.get(), this.N.get(), this.f11095a0.get(), this.M.get(), this.f11133k.get(), this.f11131j1.get(), this.f11178w1.get());
        }

        private com.coffeemeetsbagel.settings.e e3() {
            return new com.coffeemeetsbagel.settings.e(this.f11189z0.get(), this.f11163s0.get(), this.f11129j.get(), i2(), this.V1.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.education.k f2() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.education.k(e(), this.f11125h2.get(), this.f11142m0.get(), this.V1.get());
        }

        private com.coffeemeetsbagel.whatsnew.f f3() {
            return new com.coffeemeetsbagel.whatsnew.f(this.N.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.f g2() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.f(e(), i2(), this.V1.get());
        }

        private ma.d h2() {
            return x4.h.a(this.f11118g.get());
        }

        private com.coffeemeetsbagel.qna.i i2() {
            return new com.coffeemeetsbagel.qna.i(this.f11142m0.get());
        }

        private com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.c j2() {
            return new com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.c(e(), this.N1.get(), this.V1.get());
        }

        private void k2(c cVar, com.coffeemeetsbagel.experiment.a aVar, Bakery bakery) {
            com.coffeemeetsbagel.experiment.a aVar2 = aVar;
            fj.d a10 = fj.e.a(bakery);
            this.f11102c = a10;
            this.f11106d = fj.c.a(a1.a(a10));
            fk.a<h1> a11 = fj.c.a(h0.a(this.f11102c));
            this.f11110e = a11;
            fk.a<j7.a> a12 = fj.c.a(p.b(this.f11106d, a11));
            this.f11114f = a12;
            fk.a<c7.d> a13 = fj.c.a(v0.a(this.f11106d, a12));
            this.f11118g = a13;
            fk.a<com.coffeemeetsbagel.experiment.s> a14 = fj.c.a(com.coffeemeetsbagel.experiment.e.a(aVar2, a13));
            this.f11122h = a14;
            fk.a<FeatureFlagRepository> a15 = fj.c.a(com.coffeemeetsbagel.experiment.b.a(aVar2, a14, this.f11106d, this.f11114f));
            this.f11129j = a15;
            this.f11133k = fj.c.a(com.coffeemeetsbagel.experiment.c.a(aVar2, this.f11102c, a15));
            this.f11137l = fj.c.a(c0.a(this.f11102c));
            fk.a<h8.a> a16 = fj.c.a(b0.a());
            this.f11141m = a16;
            this.f11145n = fj.c.a(g0.a(this.f11102c, a16));
            fk.a<Context> a17 = fj.c.a(i.b(this.f11102c));
            this.f11152p = a17;
            this.f11156q = fj.c.a(t0.b(a17));
            this.f11166t = fj.c.a(x4.o.a(this.f11118g));
            fk.a<tb.a> a18 = fj.c.a(s.b(this.f11102c));
            this.f11176w = a18;
            fk.a<tb.b> a19 = fj.c.a(t.b(a18, this.f11102c));
            this.f11180x = a19;
            y1 a20 = y1.a(this.f11152p, a19);
            this.f11184y = a20;
            fk.a<CmbDatabase> a21 = fj.c.a(k0.b(this.f11102c, a20));
            this.f11188z = a21;
            this.B = fj.c.a(f0.b(a21));
            this.C = fj.c.a(h5.i0.b(this.f11188z));
            this.D = fj.c.a(c1.a(this.f11188z));
            this.E = fj.c.a(b1.a(this.f11188z));
            this.F = fj.c.a(x4.k.a(this.f11118g));
            this.G = fj.c.a(h5.f1.a(this.f11188z));
            this.H = fj.c.a(x0.a(this.f11188z));
            fk.a<s9.a> a22 = fj.c.a(com.coffeemeetsbagel.experiment.d.a(aVar2, this.f11133k));
            this.I = a22;
            h3 a23 = h3.a(this.F, this.G, this.H, a22);
            this.J = a23;
            this.K = fj.c.a(com.coffeemeetsbagel.domain.repository.y1.a(this.f11156q, this.f11166t, this.B, this.C, this.D, this.E, a23, this.f11106d));
            fk.a<k> a24 = fj.c.a(v0.a(this.f11188z));
            this.L = a24;
            this.M = fj.c.a(com.coffeemeetsbagel.profile.w.a(a24));
            this.N = fj.c.a(i0.a(this.f11137l, this.f11145n, this.f11106d, this.K, this.J, k.b(), this.M));
            this.O = fj.c.a(a0.a());
            this.P = fj.c.a(e0.a(this.f11118g, this.f11106d));
            fk.a<p9.c> a25 = fj.c.a(d1.a(this.f11118g));
            this.Q = a25;
            this.R = fj.c.a(l0.a(a25));
            fk.a<Resources> a26 = fj.c.a(t0.a(this.f11102c));
            this.S = a26;
            this.T = fj.c.a(bb.b.a(a26));
            fk.a<b7.b> a27 = fj.c.a(f.b(this.f11118g));
            this.U = a27;
            this.V = fj.c.a(g.b(this.f11133k, a27));
            this.W = fj.c.a(r0.a(this.O, this.N));
            fk.a<d7.l> a28 = fj.c.a(f0.a());
            this.X = a28;
            this.Y = fj.c.a(j.b(this.f11102c, this.T, this.f11106d, this.f11118g, this.V, this.W, a28, k.b(), this.f11188z, this.f11133k));
            fk.a<f2> a29 = fj.c.a(d2.a());
            this.Z = a29;
            this.f11095a0 = fj.c.a(c2.a(a29));
            this.f11099b0 = fj.c.a(l.b(this.N, this.f11152p, this.f11106d));
            fk.a<u6.i> a30 = fj.c.a(h5.t0.a(this.f11188z));
            this.f11103c0 = a30;
            this.f11107d0 = fj.c.a(h0.a(a30));
            this.f11111e0 = fj.c.a(j0.b(this.f11188z));
            fk.a<cb.a> a31 = fj.c.a(z0.a());
            this.f11115f0 = a31;
            fk.a<com.coffeemeetsbagel.domain.repository.m> a32 = fj.c.a(com.coffeemeetsbagel.domain.repository.n.a(this.f11111e0, a31));
            this.f11119g0 = a32;
            this.f11123h0 = fj.c.a(l5.d.a(a32));
            this.f11126i0 = fj.c.a(x4.j.a(this.f11118g));
            this.f11130j0 = fj.c.a(x4.d.b(this.f11118g));
            this.f11134k0 = fj.c.a(w0.a(this.f11188z));
            fk.a<ma.h> a33 = fj.c.a(x4.l.a(this.f11118g));
            this.f11138l0 = a33;
            fk.a<QuestionRepository> a34 = fj.c.a(com.coffeemeetsbagel.qna.data.s.a(this.f11126i0, this.H, this.f11130j0, this.f11134k0, a33));
            this.f11142m0 = a34;
            this.f11146n0 = fj.c.a(com.coffeemeetsbagel.qna.m.a(a34));
            this.f11149o0 = fj.c.a(com.coffeemeetsbagel.profile.f.a(this.M, this.J, this.f11107d0, this.f11119g0));
            this.f11153p0 = fj.c.a(q0.a(this.M, this.f11107d0, this.f11142m0));
            this.f11157q0 = fj.c.a(com.coffeemeetsbagel.profile.n0.a(this.J, this.f11119g0));
            this.f11160r0 = l0.a(this.J, this.M, this.f11107d0, this.f11142m0, this.f11119g0);
            this.f11163s0 = fj.c.a(s0.a(this.J));
            this.f11167t0 = fj.c.a(p0.a(k.b(), this.O, this.Y, this.f11095a0, this.f11106d, this.f11099b0, this.f11102c, this.F, this.J, this.f11107d0, this.f11123h0, this.f11146n0, this.f11149o0, this.f11153p0, this.f11157q0, this.f11160r0, this.f11163s0));
            this.f11170u0 = fj.c.a(com.coffeemeetsbagel.store.u0.a(this.f11118g));
            fk.a<u6.j> a35 = fj.c.a(h5.u0.a(this.f11188z));
            this.f11173v0 = a35;
            this.f11177w0 = fj.c.a(com.coffeemeetsbagel.store.h0.a(this.f11170u0, a35, k.b()));
            fk.a<PurchaseApi> a36 = fj.c.a(PurchaseApi_Factory.create(this.f11118g));
            this.f11181x0 = a36;
            this.f11185y0 = fj.c.a(q0.a(this.f11177w0, this.f11167t0, this.N, a36, k.b()));
            this.f11189z0 = fj.c.a(com.coffeemeetsbagel.profile.c.a(this.M, this.J));
            this.A0 = fj.c.a(wb.d.a(this.K));
            this.B0 = fj.c.a(com.coffeemeetsbagel.domain.repository.r0.a(this.f11156q, this.J, this.f11106d));
            fk.a<com.coffeemeetsbagel.discover.f> a37 = fj.c.a(x4.g.a(this.f11118g));
            this.C0 = a37;
            this.D0 = fj.c.a(com.coffeemeetsbagel.discover.d.a(a37, this.f11095a0, this.f11106d));
            this.E0 = fj.c.a(f7.b.a());
            h5.l0 b10 = h5.l0.b(this.f11188z);
            this.F0 = b10;
            this.G0 = fj.c.a(m.b(this.E0, this.f11095a0, b10));
            fk.a<nc.b> a38 = fj.c.a(y.a());
            this.H0 = a38;
            this.I0 = fj.c.a(d0.b(this.f11106d, a38));
            z0 a39 = z0.a(this.f11188z);
            this.J0 = a39;
            this.K0 = fj.c.a(o.b(a39, this.H0));
            this.L0 = fj.c.a(x4.e.b(this.f11118g));
            this.M0 = fj.c.a(n.b(k.b(), this.f11107d0, this.M, this.f11185y0, this.G0, this.f11167t0, this.Y, this.f11106d, this.I0, this.K0, this.f11114f, this.f11153p0, this.L0));
            this.N0 = fj.c.a(e1.a());
            this.O0 = fj.c.a(y0.a(this.f11188z));
            fk.a<i> a40 = fj.c.a(x4.m.a(this.f11118g));
            this.P0 = a40;
            this.Q0 = fj.c.a(u0.a(this.f11106d, this.f11152p, this.Y, this.O0, a40, k.b()));
            this.R0 = fj.c.a(e1.a(this.f11188z));
            this.S0 = fj.c.a(h5.r0.a(this.f11188z));
            this.T0 = fj.c.a(e0.a());
            this.U0 = fj.c.a(h5.h0.b(this.f11188z));
            this.V0 = fj.c.a(x4.i.a(this.f11118g));
            this.W0 = fj.c.a(h5.m0.a(this.f11188z));
            this.X0 = fj.c.a(o0.a(this.f11188z));
            this.Y0 = fj.c.a(p0.a(this.f11188z));
            fk.a<com.coffeemeetsbagel.likes_you.f> a41 = fj.c.a(h5.n0.a(this.f11188z));
            this.Z0 = a41;
            fk.a<LikesYouMatchRepository> a42 = fj.c.a(com.coffeemeetsbagel.domain.repository.z.a(this.S0, this.L0, this.f11115f0, this.L, this.f11103c0, this.T0, this.U0, this.V0, this.W0, this.X0, this.Y0, a41));
            this.f11096a1 = a42;
            this.f11100b1 = fj.c.a(com.coffeemeetsbagel.likes_you.v0.a(this.R0, a42));
            this.f11104c1 = fj.c.a(com.coffeemeetsbagel.qna.z.a(this.f11129j, this.J, this.f11142m0));
            fk.a<ma.c> a43 = fj.c.a(x4.f.b(this.f11118g));
            this.f11108d1 = a43;
            this.f11112e1 = fj.c.a(com.coffeemeetsbagel.feature.sync.p.a(this.B0, this.f11156q, a43, this.K, this.N, this.f11129j));
        }

        private void l2(c cVar, com.coffeemeetsbagel.experiment.a aVar, Bakery bakery) {
            this.f11116f1 = fj.c.a(v.a(this.f11156q, this.J));
            this.f11120g1 = fj.c.a(x4.p.a(this.f11118g));
            fk.a<yb.c> a10 = fj.c.a(d1.a(this.f11188z));
            this.f11124h1 = a10;
            this.f11127i1 = fj.c.a(t2.a(this.f11120g1, a10, this.f11106d, this.M, this.f11107d0, this.f11142m0, this.G0));
            this.f11131j1 = fj.c.a(k0.a(this.D0, this.f11160r0, this.f11177w0, this.f11106d, this.Y, this.M0, this.f11102c, this.N0, this.f11133k, this.f11129j, this.W, this.Q0, this.f11110e, this.f11167t0, this.X, this.J, this.K, this.f11100b1, this.f11104c1, this.f11112e1, this.f11116f1, this.f11153p0, k.b(), this.f11127i1));
            this.f11135k1 = fj.c.a(x.b());
            this.f11139l1 = e.b(this.f11188z);
            this.f11143m1 = fj.c.a(g0.b(this.f11188z));
            fk.a<y6.a> a11 = fj.c.a(d.b(k.b(), this.N0, this.f11139l1, this.f11143m1, this.N, this.f11118g, this.A0));
            this.f11147n1 = a11;
            this.f11150o1 = fj.c.a(z.a(this.f11107d0, this.M, this.O, this.f11118g, this.f11185y0, this.f11095a0, this.Y, a11, this.f11188z, k.b(), this.f11142m0));
            this.f11154p1 = fj.c.a(w.b(this.f11102c));
            fk.a<u6.h> a12 = fj.c.a(h5.s0.a(this.f11188z));
            this.f11158q1 = a12;
            this.f11161r1 = fj.c.a(j1.a(this.f11095a0, this.X, a12, this.F0));
            l8.f a13 = l8.f.a(this.f11167t0);
            this.f11164s1 = a13;
            this.f11168t1 = fj.c.a(l1.a(this.N, this.f11118g, this.f11106d, a13));
            this.f11171u1 = fj.c.a(m0.a(this.f11152p));
            fk.a<i5.a> a14 = fj.c.a(h.b());
            this.f11174v1 = a14;
            fk.a<l8.h> a15 = fj.c.a(k1.a(this.M, this.M0, this.f11152p, this.f11161r1, this.Y, this.f11106d, this.f11167t0, this.f11168t1, this.X, this.f11171u1, a14, this.N, this.f11133k));
            this.f11178w1 = a15;
            this.f11182x1 = fj.c.a(q.b(this.f11102c, this.Z, this.Y, this.f11167t0, this.N, this.M0, this.f11154p1, a15, this.f11171u1, k.b(), this.F0));
            this.f11186y1 = fj.c.a(v.b(this.f11167t0));
            this.f11190z1 = fj.c.a(com.coffeemeetsbagel.likes_you.o0.a(this.f11152p));
            fk.a<f> a16 = fj.c.a(h5.q0.a(this.f11188z));
            this.A1 = a16;
            this.B1 = fj.c.a(com.coffeemeetsbagel.domain.repository.b0.a(a16));
            this.C1 = fj.c.a(x4.c.b(this.f11118g));
            fk.a<u6.a> a17 = fj.c.a(h5.e0.b(this.f11188z));
            this.D1 = a17;
            fk.a<ActionCardRepository> a18 = fj.c.a(com.coffeemeetsbagel.domain.repository.e.a(this.C1, a17, this.f11106d));
            this.E1 = a18;
            this.F1 = fj.c.a(com.coffeemeetsbagel.today_view.card.actioncards.i0.a(a18, this.f11186y1, this.f11142m0, this.f11167t0, this.f11185y0, this.f11106d, this.A0, this.f11133k));
            this.G1 = fj.c.a(b1.a());
            this.H1 = fj.c.a(l5.b.a(this.f11119g0));
            fk.a<BagelRepository> a19 = fj.c.a(com.coffeemeetsbagel.match.t.a(this.G0, this.L0));
            this.I1 = a19;
            this.J1 = fj.c.a(com.coffeemeetsbagel.feature.bagel.b0.a(this.f11147n1, a19, this.M));
            fk.a<PurchaseRepository<Bagel>> a20 = fj.c.a(com.coffeemeetsbagel.store.alc.h.a(this.f11118g));
            this.K1 = a20;
            this.L1 = fj.c.a(com.coffeemeetsbagel.store.alc.c.a(a20));
            this.M1 = fj.c.a(com.coffeemeetsbagel.instant_like.e.a(this.N));
            this.N1 = fj.c.a(com.coffeemeetsbagel.qna.k.a(this.f11142m0));
            this.O1 = fj.c.a(com.coffeemeetsbagel.qna.b.a(this.J, this.f11142m0));
            this.P1 = fj.c.a(com.coffeemeetsbagel.match.e.a(this.I1, this.I0));
            this.Q1 = fj.c.a(com.coffeemeetsbagel.match.y.a(this.I1));
            this.R1 = fj.c.a(wb.b.a(this.K));
            this.S1 = fj.c.a(com.coffeemeetsbagel.qna.f.a(this.f11142m0));
            this.T1 = fj.c.a(com.coffeemeetsbagel.qna.h.a(this.f11142m0));
            this.U1 = fj.c.a(com.coffeemeetsbagel.match.a0.a(this.N));
            this.V1 = fj.c.a(com.coffeemeetsbagel.qna.b0.a(this.J, this.f11142m0));
            this.W1 = fj.c.a(c9.b.a(this.O0));
            this.X1 = fj.c.a(d0.a(this.E0, this.M, this.Z, this.F0));
            fk.a<PurchaseRepository<Boolean>> a21 = fj.c.a(com.coffeemeetsbagel.store.alc.h.a(this.f11118g));
            this.Y1 = a21;
            this.Z1 = fj.c.a(com.coffeemeetsbagel.store.alc.e.a(a21));
            this.f11097a2 = fj.c.a(com.coffeemeetsbagel.feature.bagel.v.a(this.I1, this.M));
            fk.a<t8.k> a22 = fj.c.a(n0.a(this.f11118g, k.b()));
            this.f11101b2 = a22;
            this.f11105c2 = fj.c.a(o0.a(this.f11107d0, this.Z, this.O, this.Y, this.f11167t0, a22));
            this.f11109d2 = fj.c.a(com.coffeemeetsbagel.qna.p.a(this.J, this.f11142m0));
            this.f11113e2 = fj.c.a(com.coffeemeetsbagel.match_prefs.e.a(this.J, this.f11142m0, this.f11129j, this.f11119g0));
            fk.a<eb.a> a23 = fj.c.a(db.b.a(this.f11188z));
            this.f11117f2 = a23;
            fk.a<SchoolRepository> a24 = fj.c.a(com.coffeemeetsbagel.school.data.i.a(this.f11106d, this.S, a23));
            this.f11121g2 = a24;
            this.f11125h2 = fj.c.a(fb.b.a(a24));
            this.f11128i2 = fj.c.a(com.coffeemeetsbagel.new_user_experience.match_prefs.age.u.a(this.J, this.M, this.f11142m0, this.I));
            this.f11132j2 = fj.c.a(com.coffeemeetsbagel.new_user_experience.match_prefs.age.z.a(this.I, this.f11167t0, this.J, this.f11142m0));
            this.f11136k2 = fj.c.a(wb.f.a(this.K));
            this.f11140l2 = fj.c.a(com.coffeemeetsbagel.suggested_history.i.a(this.I1, this.M));
            this.f11144m2 = fj.c.a(com.coffeemeetsbagel.profile.h.a(this.f11107d0));
            this.f11148n2 = fj.c.a(j0.a(this.N));
            fk.a<sa.a> a25 = fj.c.a(sa.b.a(this.f11161r1));
            this.f11151o2 = a25;
            this.f11155p2 = fj.c.a(p5.c.a(a25));
            this.f11159q2 = fj.c.a(x4.n.a(this.f11118g));
            fk.a<n> a26 = fj.c.a(a1.a(this.f11188z));
            this.f11162r2 = a26;
            this.f11165s2 = fj.c.a(c1.a(this.f11159q2, a26, this.f11106d));
            this.f11169t2 = fj.c.a(com.coffeemeetsbagel.qna.h0.a(this.J, this.f11142m0));
            fk.a<m5.a> a27 = fj.c.a(m5.b.a(this.E0, this.f11158q1));
            this.f11172u2 = a27;
            this.f11175v2 = fj.c.a(com.coffeemeetsbagel.feature.chatlist.v0.a(a27, this.K, this.f11096a1, this.F0, this.M, this.f11129j));
            this.f11179w2 = fj.c.a(com.coffeemeetsbagel.my_profile.f.a(this.J, this.f11107d0));
            this.f11183x2 = fj.c.a(com.coffeemeetsbagel.my_profile.c.a(this.J, this.f11107d0));
            this.f11187y2 = fj.c.a(w0.a());
            this.f11191z2 = fj.c.a(com.coffeemeetsbagel.boost.a.a(this.N));
            this.A2 = fj.c.a(u.b());
            this.B2 = fj.c.a(s0.a(this.O, this.f11186y1));
            fk.a<g9.a> a28 = fj.c.a(x0.a(this.f11102c));
            this.C2 = a28;
            this.D2 = fj.c.a(y0.a(this.f11102c, a28, this.f11106d, this.f11187y2));
            this.E2 = fj.c.a(r.b(this.f11110e, this.f11106d));
        }

        private ActivityLikePassFlow m2(ActivityLikePassFlow activityLikePassFlow) {
            com.coffeemeetsbagel.feature.likepassflow.a.b(activityLikePassFlow, this.f11153p0.get());
            com.coffeemeetsbagel.feature.likepassflow.a.a(activityLikePassFlow, this.f11186y1.get());
            return activityLikePassFlow;
        }

        private ActivitySettings n2(ActivitySettings activitySettings) {
            com.coffeemeetsbagel.activities.x.a(activitySettings, this.N.get());
            return activitySettings;
        }

        private ActivityWhatsNew o2(ActivityWhatsNew activityWhatsNew) {
            com.coffeemeetsbagel.whatsnew.a.a(activityWhatsNew, f3());
            return activityWhatsNew;
        }

        private BagelProfileComponentActivity p2(BagelProfileComponentActivity bagelProfileComponentActivity) {
            com.coffeemeetsbagel.bagel_profile.f.a(bagelProfileComponentActivity, a3());
            com.coffeemeetsbagel.bagel_profile.f.c(bagelProfileComponentActivity, this.W.get());
            com.coffeemeetsbagel.bagel_profile.f.b(bagelProfileComponentActivity, this.f11167t0.get());
            return bagelProfileComponentActivity;
        }

        private BannedActivity q2(BannedActivity bannedActivity) {
            com.coffeemeetsbagel.feature.logout.k.a(bannedActivity, a2());
            return bannedActivity;
        }

        private com.coffeemeetsbagel.fragments.i0 r2(com.coffeemeetsbagel.fragments.i0 i0Var) {
            com.coffeemeetsbagel.fragments.n0.b(i0Var, this.A0.get());
            com.coffeemeetsbagel.fragments.n0.a(i0Var, i2());
            com.coffeemeetsbagel.fragments.n0.c(i0Var, this.V1.get());
            return i0Var;
        }

        private BoostDialogFragment s2(BoostDialogFragment boostDialogFragment) {
            com.coffeemeetsbagel.boost.f.a(boostDialogFragment, this.N.get());
            com.coffeemeetsbagel.boost.f.b(boostDialogFragment, this.f11137l.get());
            com.coffeemeetsbagel.boost.f.c(boostDialogFragment, this.f11191z2.get());
            com.coffeemeetsbagel.boost.f.d(boostDialogFragment, b2());
            return boostDialogFragment;
        }

        private h1 t2(h1 h1Var) {
            n5.j1.e(h1Var, this.f11161r1.get());
            n5.j1.f(h1Var, this.f11178w1.get());
            n5.j1.g(h1Var, this.f11148n2.get());
            n5.j1.b(h1Var, this.f11155p2.get());
            n5.j1.d(h1Var, this.A0.get());
            n5.j1.c(h1Var, this.W1.get());
            n5.j1.a(h1Var, this.M0.get());
            n5.j1.h(h1Var, this.f11165s2.get());
            n5.j1.i(h1Var, c2());
            return h1Var;
        }

        private com.coffeemeetsbagel.feature.chatlist.g0 u2(com.coffeemeetsbagel.feature.chatlist.g0 g0Var) {
            com.coffeemeetsbagel.feature.chatlist.k0.b(g0Var, this.X1.get());
            com.coffeemeetsbagel.feature.chatlist.k0.a(g0Var, this.f11175v2.get());
            com.coffeemeetsbagel.feature.chatlist.k0.c(g0Var, this.f11185y0.get());
            return g0Var;
        }

        private ContactUsFragment v2(ContactUsFragment contactUsFragment) {
            com.coffeemeetsbagel.fragments.o0.a(contactUsFragment, h2());
            return contactUsFragment;
        }

        private CountryCodePickerFragment w2(CountryCodePickerFragment countryCodePickerFragment) {
            com.coffeemeetsbagel.phone_login.country_code_picker.e.a(countryCodePickerFragment, this.N.get());
            return countryCodePickerFragment;
        }

        private DealBreakerSheetFragment x2(DealBreakerSheetFragment dealBreakerSheetFragment) {
            com.coffeemeetsbagel.match_prefs.dealbreaker.c.a(dealBreakerSheetFragment, d2());
            return dealBreakerSheetFragment;
        }

        private DiscoverFilterActivity y2(DiscoverFilterActivity discoverFilterActivity) {
            com.coffeemeetsbagel.feature.discover.search.a.a(discoverFilterActivity, this.W1.get());
            return discoverFilterActivity;
        }

        private DiscoverFragment z2(DiscoverFragment discoverFragment) {
            com.coffeemeetsbagel.discoverV2.d.b(discoverFragment, this.M0.get());
            com.coffeemeetsbagel.discoverV2.d.e(discoverFragment, this.I.get());
            com.coffeemeetsbagel.discoverV2.d.h(discoverFragment, this.f11185y0.get());
            com.coffeemeetsbagel.discoverV2.d.g(discoverFragment, this.f11167t0.get());
            com.coffeemeetsbagel.discoverV2.d.d(discoverFragment, this.f11186y1.get());
            com.coffeemeetsbagel.discoverV2.d.l(discoverFragment, e2());
            com.coffeemeetsbagel.discoverV2.d.j(discoverFragment, this.K.get());
            com.coffeemeetsbagel.discoverV2.d.c(discoverFragment, g());
            com.coffeemeetsbagel.discoverV2.d.a(discoverFragment, this.N.get());
            com.coffeemeetsbagel.discoverV2.d.k(discoverFragment, e());
            com.coffeemeetsbagel.discoverV2.d.i(discoverFragment, this.f11115f0.get());
            com.coffeemeetsbagel.discoverV2.d.f(discoverFragment, this.f11189z0.get());
            return discoverFragment;
        }

        public ProfileRepository A() {
            return new ProfileRepository(this.L.get(), this.F.get(), this.f11103c0.get());
        }

        public ProfileRepositoryV2 A0() {
            return this.M.get();
        }

        public com.coffeemeetsbagel.qna.j A1() {
            return this.N1.get();
        }

        public t B() {
            return this.W.get();
        }

        public GetLastPassedBagelUseCase B0() {
            return this.f11097a2.get();
        }

        public void B1(OnboardingComponentActivity onboardingComponentActivity) {
            O2(onboardingComponentActivity);
        }

        public UserRepository C() {
            return e();
        }

        public com.coffeemeetsbagel.store.alc.d C0() {
            return this.Z1.get();
        }

        public CmbDatabase C1() {
            return this.f11188z.get();
        }

        public SaveAnswerUseCase D() {
            return this.V1.get();
        }

        public wb.e D0() {
            return this.f11136k2.get();
        }

        public void D1(DiscoverFilterActivity discoverFilterActivity) {
            y2(discoverFilterActivity);
        }

        public d7.g E() {
            return this.Y.get();
        }

        public GetHistoryBagelUseCase E0() {
            return this.f11140l2.get();
        }

        public void E1(CountryCodePickerFragment countryCodePickerFragment) {
            w2(countryCodePickerFragment);
        }

        public z F() {
            return this.U1.get();
        }

        public com.coffeemeetsbagel.match.d F0() {
            return this.P1.get();
        }

        public h8.a F1() {
            return this.f11141m.get();
        }

        public v7.d G() {
            return this.f11150o1.get();
        }

        public com.coffeemeetsbagel.match.d G0() {
            return this.P1.get();
        }

        public a7.a G1() {
            return this.N.get();
        }

        public hb.c H() {
            return this.f11106d.get();
        }

        public l9.e H0() {
            return this.G1.get();
        }

        public e7.d H1() {
            return this.f11099b0.get();
        }

        public c9.a I() {
            return this.W1.get();
        }

        public BuyBeansUseCase I0() {
            return new BuyBeansUseCase(this.B0.get(), this.f11167t0.get(), this.f11131j1.get(), this.f11108d1.get(), this.N.get());
        }

        public n0 I1() {
            return this.f11190z1.get();
        }

        public x J() {
            return this.Q1.get();
        }

        public GetPlayAvailabilityUseCase J0() {
            return new GetPlayAvailabilityUseCase(this.B0.get(), this.f11156q.get());
        }

        public void J1(BoostDialogFragment boostDialogFragment) {
            s2(boostDialogFragment);
        }

        public b7.c K() {
            return this.V.get();
        }

        public FeatureFlagRepository K0() {
            return this.f11129j.get();
        }

        public void K1(BannedActivity bannedActivity) {
            q2(bannedActivity);
        }

        public a0 L() {
            return this.B1.get();
        }

        public com.coffeemeetsbagel.store.alc.b L0() {
            return this.L1.get();
        }

        public void L1(MatchPreferencesFragment matchPreferencesFragment) {
            J2(matchPreferencesFragment);
        }

        public UpdateBagelLocalUseCase M() {
            return this.J1.get();
        }

        public com.coffeemeetsbagel.qna.j M0() {
            return this.N1.get();
        }

        public void M1(ActivitySettings activitySettings) {
            n2(activitySettings);
        }

        public a6.a N() {
            return this.f11186y1.get();
        }

        public GetSingleSchoolsUseCase N0() {
            return this.f11125h2.get();
        }

        public void N1(ContactUsFragment contactUsFragment) {
            v2(contactUsFragment);
        }

        public com.coffeemeetsbagel.qna.e O() {
            return this.S1.get();
        }

        public com.coffeemeetsbagel.qna.j O0() {
            return this.N1.get();
        }

        public GetMyOwnProfileLocalUseCase O1() {
            return this.f11189z0.get();
        }

        public SubscriptionRepository P() {
            return this.K.get();
        }

        public t8.l P0() {
            return this.f11105c2.get();
        }

        public void P1(DealBreakerSheetFragment dealBreakerSheetFragment) {
            x2(dealBreakerSheetFragment);
        }

        public t7.a Q() {
            return this.f11095a0.get();
        }

        public f2 Q0() {
            return this.Z.get();
        }

        public void Q1(SettingsActivity settingsActivity) {
            T2(settingsActivity);
        }

        public a7.a R() {
            return this.N.get();
        }

        public com.coffeemeetsbagel.qna.j R0() {
            return this.N1.get();
        }

        public void R1(BagelProfileComponentActivity bagelProfileComponentActivity) {
            p2(bagelProfileComponentActivity);
        }

        public a7.a S() {
            return this.N.get();
        }

        public void S0(DiscoverFragment discoverFragment) {
            z2(discoverFragment);
        }

        public void S1(ActivityWhatsNew activityWhatsNew) {
            o2(activityWhatsNew);
        }

        public a7.a T() {
            return this.N.get();
        }

        public y7.a T0() {
            return this.O.get();
        }

        public void T1(EthnicityFragment ethnicityFragment) {
            B2(ethnicityFragment);
        }

        public com.coffeemeetsbagel.feature.instagram.c U() {
            return this.P.get();
        }

        public void U0(g8.l lVar) {
            C2(lVar);
        }

        public b9.a U1() {
            return this.B2.get();
        }

        public ProfileManager V() {
            return this.f11167t0.get();
        }

        public void V0(com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a aVar) {
            N2(aVar);
        }

        public UpgradeContract.Manager V1() {
            return this.N0.get();
        }

        public m1 W() {
            return this.f11131j1.get();
        }

        public void W0(com.coffeemeetsbagel.fragments.i0 i0Var) {
            r2(i0Var);
        }

        public void W1(MeProfileFragment meProfileFragment) {
            K2(meProfileFragment);
        }

        public SaveAgePreferenceUseCase X() {
            return this.f11132j2.get();
        }

        public void X0(ProfileCompletionHelperActivity profileCompletionHelperActivity) {
            R2(profileCompletionHelperActivity);
        }

        public d7.l X1() {
            return this.X.get();
        }

        public com.coffeemeetsbagel.qna.e Y() {
            return this.S1.get();
        }

        public void Y0(EducationFragment educationFragment) {
            A2(educationFragment);
        }

        public void Y1(com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a aVar) {
            H2(aVar);
        }

        public SubscriptionRepository Z() {
            return this.K.get();
        }

        public void Z0(f8.x xVar) {
            F2(xVar);
        }

        public o7.a Z1() {
            return this.E2.get();
        }

        public FirebaseContract.Analytics a0() {
            return this.f11137l.get();
        }

        public k7.s a1() {
            return this.f11182x1.get();
        }

        public LoadAgePreferenceUseCase b0() {
            return this.f11128i2.get();
        }

        public q8.a b1() {
            return this.f11145n.get();
        }

        public a7.a c() {
            return this.N.get();
        }

        public g c0() {
            return this.F.get();
        }

        public void c1(e5 e5Var) {
            G2(e5Var);
        }

        public com.coffeemeetsbagel.qna.j d0() {
            return this.N1.get();
        }

        public void d1(FragmentProfileEdit fragmentProfileEdit) {
        }

        public UserRepository e() {
            return new UserRepository(this.F.get(), this.G.get(), this.H.get(), this.I.get());
        }

        public QuestionRepository e0() {
            return this.f11142m0.get();
        }

        public void e1(PhoneInputFragment phoneInputFragment) {
            Q2(phoneInputFragment);
        }

        public cb.a f() {
            return this.f11115f0.get();
        }

        public com.coffeemeetsbagel.qna.j f0() {
            return this.N1.get();
        }

        public Context f1() {
            return this.f11152p.get();
        }

        public BuySubscriptionUseCase g() {
            return new BuySubscriptionUseCase(this.K.get(), this.N.get(), this.f11108d1.get());
        }

        public GetFirstEligibleActionCardUseCase g0() {
            return this.F1.get();
        }

        public void g1(FragmentMyProfileDetails fragmentMyProfileDetails) {
            E2(fragmentMyProfileDetails);
        }

        public GetMyOwnProfileLocalUseCase h() {
            return this.f11189z0.get();
        }

        public SubscriptionRepository h0() {
            return this.K.get();
        }

        public void h1(ActivityLikePassFlow activityLikePassFlow) {
            m2(activityLikePassFlow);
        }

        public bb.a i() {
            return this.T.get();
        }

        public m1 i0() {
            return this.f11131j1.get();
        }

        public c7.d i1() {
            return this.f11118g.get();
        }

        public l5.a j0() {
            return this.H1.get();
        }

        public void j1(ReligionFragment religionFragment) {
            S2(religionFragment);
        }

        public QuestionRepository k() {
            return this.f11142m0.get();
        }

        public x k0() {
            return this.Q1.get();
        }

        public void k1(f8.n nVar) {
            D2(nVar);
        }

        public com.coffeemeetsbagel.store.alc.b l0() {
            return this.L1.get();
        }

        public d7.g l1() {
            return this.Y.get();
        }

        public SubscriptionRepository m() {
            return this.K.get();
        }

        public ActionCardRepository m0() {
            return this.E1.get();
        }

        public u0 m1() {
            return this.f11100b1.get();
        }

        public n8.s n() {
            return this.f11161r1.get();
        }

        public l5.a n0() {
            return this.H1.get();
        }

        public c n1() {
            return this.A0.get();
        }

        public DeletePromptAnswerUseCase o() {
            return this.O1.get();
        }

        public SaveProfilesLocalUseCase o0() {
            return this.f11153p0.get();
        }

        public void o1(LikesYouFragment likesYouFragment) {
            I2(likesYouFragment);
        }

        public GetMatchPreferencesUseCase p0() {
            return this.f11113e2.get();
        }

        public t8.l p1() {
            return this.f11105c2.get();
        }

        public com.coffeemeetsbagel.qna.g q() {
            return this.T1.get();
        }

        public lc.k q0() {
            return this.f11135k1.get();
        }

        public void q1(h1 h1Var) {
            t2(h1Var);
        }

        public c r() {
            return this.A0.get();
        }

        public p9.d r0() {
            return this.R.get();
        }

        public i5.a r1() {
            return this.f11174v1.get();
        }

        public y6.a s() {
            return this.f11147n1.get();
        }

        public GetUserMCQUseCase s0() {
            return this.f11109d2.get();
        }

        public ProfileManager s1() {
            return this.f11167t0.get();
        }

        public l8.h t() {
            return this.f11178w1.get();
        }

        public LikesYouMatchRepository t0() {
            return this.f11096a1.get();
        }

        public ConnectivityManager t1() {
            return this.f11154p1.get();
        }

        public bb.a u() {
            return this.T.get();
        }

        public z u0() {
            return this.U1.get();
        }

        public void u1(PhoneCodeActivity phoneCodeActivity) {
            P2(phoneCodeActivity);
        }

        public GetGroupOptionsRemainingUseCase v() {
            return new GetGroupOptionsRemainingUseCase(this.f11142m0.get());
        }

        public r0 v0() {
            return this.f11163s0.get();
        }

        public void v1(com.coffeemeetsbagel.feature.chatlist.g0 g0Var) {
            u2(g0Var);
        }

        public LoadProfileUseCase w() {
            return new LoadProfileUseCase(e(), this.M.get(), this.f11142m0.get(), this.I.get(), this.O0.get());
        }

        public com.coffeemeetsbagel.instant_like.d w0() {
            return this.M1.get();
        }

        public void w1(VerificationCodeFragment verificationCodeFragment) {
            U2(verificationCodeFragment);
        }

        public a6.a x() {
            return this.f11186y1.get();
        }

        public FirebaseContract.Analytics x0() {
            return this.f11137l.get();
        }

        public j x1() {
            return this.D2.get();
        }

        public GetActivityReportUseCase y() {
            return new GetActivityReportUseCase(this.K.get(), this.f11143m1.get(), this.f11147n1.get());
        }

        public hb.c y0() {
            return this.f11106d.get();
        }

        public void y1(MongooseSyncJobService mongooseSyncJobService) {
            L2(mongooseSyncJobService);
        }

        public SaveAnswerUseCase z() {
            return this.V1.get();
        }

        public SuggestedRepository z0() {
            return this.f11127i1.get();
        }

        public void z1(NotificationWorkManagerWorker notificationWorkManagerWorker) {
            M2(notificationWorkManagerWorker);
        }

        public com.coffeemeetsbagel.experiment.r b() {
            return this.f11133k.get();
        }

        public ProfileManager d() {
            return this.f11167t0.get();
        }

        public PurchaseManager j() {
            return this.f11185y0.get();
        }

        public s l() {
            return this.M0.get();
        }

        public c9.i p() {
            return this.Q0.get();
        }
    }

    private static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private Bakery f11192a;

        /* renamed from: b  reason: collision with root package name */
        private c f11193b;

        private b() {
        }

        public b build() {
            fj.g.a(this.f11192a, Bakery.class);
            if (this.f11193b == null) {
                this.f11193b = new c();
            }
            return new a(this.f11193b, new com.coffeemeetsbagel.experiment.a(), this.f11192a);
        }

        /* renamed from: h */
        public b d(Bakery bakery) {
            this.f11192a = (Bakery) fj.g.b(bakery);
            return this;
        }

        @Deprecated
        /* renamed from: i */
        public b b(c0 c0Var) {
            fj.g.b(c0Var);
            return this;
        }

        @Deprecated
        /* renamed from: j */
        public b g(x4.b bVar) {
            fj.g.b(bVar);
            return this;
        }

        @Deprecated
        /* renamed from: k */
        public b f(h5.d0 d0Var) {
            fj.g.b(d0Var);
            return this;
        }

        @Deprecated
        /* renamed from: l */
        public b a(db.a aVar) {
            fj.g.b(aVar);
            return this;
        }

        @Deprecated
        /* renamed from: m */
        public b e(b2 b2Var) {
            fj.g.b(b2Var);
            return this;
        }

        @Deprecated
        /* renamed from: n */
        public b c(com.coffeemeetsbagel.store.s0 s0Var) {
            fj.g.b(s0Var);
            return this;
        }
    }

    public static b.a a() {
        return new b();
    }
}

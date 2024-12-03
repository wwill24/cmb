package com.coffeemeetsbagel.bakery;

import android.content.Context;
import android.net.ConnectivityManager;
import c9.i;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.activities.main.b;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bagel_profile.h;
import com.coffeemeetsbagel.boost.BoostDialogFragment;
import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.deactivate.r;
import com.coffeemeetsbagel.deeplink.DeepLinkActivity;
import com.coffeemeetsbagel.discoverV2.DiscoverFragment;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.chatlist.g0;
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
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.fragments.ContactUsFragment;
import com.coffeemeetsbagel.fragments.FragmentMyProfileDetails;
import com.coffeemeetsbagel.fragments.FragmentProfileEdit;
import com.coffeemeetsbagel.fragments.e5;
import com.coffeemeetsbagel.fragments.i0;
import com.coffeemeetsbagel.likes_you.u0;
import com.coffeemeetsbagel.limelight.LikesYouFragment;
import com.coffeemeetsbagel.limelight.profile_activity.r0;
import com.coffeemeetsbagel.match.c0;
import com.coffeemeetsbagel.match_prefs.dealbreaker.DealBreakerSheetFragment;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.new_user_experience.OnboardingComponentActivity;
import com.coffeemeetsbagel.new_user_experience.o;
import com.coffeemeetsbagel.phone_login.PhoneCodeActivity;
import com.coffeemeetsbagel.phone_login.country_code_picker.CountryCodePickerFragment;
import com.coffeemeetsbagel.phone_login.phone_number_input.PhoneInputFragment;
import com.coffeemeetsbagel.phone_login.verification_code.VerificationCodeFragment;
import com.coffeemeetsbagel.preferences.p;
import com.coffeemeetsbagel.products.prompts.editor.presentation.m;
import com.coffeemeetsbagel.profile_me.MeProfileFragment;
import com.coffeemeetsbagel.services.ProfileUpdateJobIntentService;
import com.coffeemeetsbagel.settings.SettingsActivity;
import com.coffeemeetsbagel.store.s0;
import com.coffeemeetsbagel.suggested_history.q;
import com.coffeemeetsbagel.whatsnew.ActivityWhatsNew;
import com.coffemeetsbagel.hide_report.f;
import d7.g;
import d7.l;
import f6.b2;
import f6.f2;
import f8.n;
import f8.x;
import ga.j;
import h5.d0;
import k7.s;
import n5.h1;
import o5.e;
import q9.c;
import x8.d;
import y4.k1;

public interface b extends c, ib.c, ProfileUpdateJobIntentService.a, DeepLinkActivity.b, k1, e, d, b.C0124b, l.c, h, o, p, com.coffeemeetsbagel.products.prompts.selection.presentation.o, m, com.coffeemeetsbagel.products.my_answers.presentation.h, r0, r, com.coffeemeetsbagel.store.premium_upsell.o, f, q {

    public interface a {
        a a(db.a aVar);

        a b(c0 c0Var);

        b build();

        a c(s0 s0Var);

        a d(Bakery bakery);

        a e(b2 b2Var);

        a f(d0 d0Var);

        a g(x4.b bVar);
    }

    ProfileRepository A();

    t B();

    void B1(OnboardingComponentActivity onboardingComponentActivity);

    CmbDatabase C1();

    void D1(DiscoverFilterActivity discoverFilterActivity);

    g E();

    void E1(CountryCodePickerFragment countryCodePickerFragment);

    h8.a F1();

    v7.d G();

    hb.c H();

    e7.d H1();

    void J1(BoostDialogFragment boostDialogFragment);

    b7.c K();

    void K1(BannedActivity bannedActivity);

    void L1(MatchPreferencesFragment matchPreferencesFragment);

    void M1(ActivitySettings activitySettings);

    void N1(ContactUsFragment contactUsFragment);

    void P1(DealBreakerSheetFragment dealBreakerSheetFragment);

    t7.a Q();

    f2 Q0();

    void Q1(SettingsActivity settingsActivity);

    a7.a R();

    void R1(BagelProfileComponentActivity bagelProfileComponentActivity);

    void S0(DiscoverFragment discoverFragment);

    void S1(ActivityWhatsNew activityWhatsNew);

    y7.a T0();

    void T1(EthnicityFragment ethnicityFragment);

    com.coffeemeetsbagel.feature.instagram.c U();

    void U0(g8.l lVar);

    b9.a U1();

    void V0(com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a aVar);

    UpgradeContract.Manager V1();

    void W0(i0 i0Var);

    void W1(MeProfileFragment meProfileFragment);

    void X0(ProfileCompletionHelperActivity profileCompletionHelperActivity);

    l X1();

    void Y0(EducationFragment educationFragment);

    void Y1(com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a aVar);

    void Z0(x xVar);

    o7.a Z1();

    FirebaseContract.Analytics a0();

    s a1();

    com.coffeemeetsbagel.experiment.r b();

    q8.a b1();

    void c1(e5 e5Var);

    ProfileManager d();

    void d1(FragmentProfileEdit fragmentProfileEdit);

    void e1(PhoneInputFragment phoneInputFragment);

    Context f1();

    void g1(FragmentMyProfileDetails fragmentMyProfileDetails);

    void h1(ActivityLikePassFlow activityLikePassFlow);

    m1 i0();

    c7.d i1();

    PurchaseManager j();

    void j1(ReligionFragment religionFragment);

    void k1(n nVar);

    com.coffeemeetsbagel.feature.bagel.s l();

    u0 m1();

    void o1(LikesYouFragment likesYouFragment);

    i p();

    t8.l p1();

    void q1(h1 h1Var);

    i5.a r1();

    l8.h t();

    ConnectivityManager t1();

    void u1(PhoneCodeActivity phoneCodeActivity);

    void v1(g0 g0Var);

    void w1(VerificationCodeFragment verificationCodeFragment);

    a6.a x();

    j x1();

    void y1(MongooseSyncJobService mongooseSyncJobService);

    void z1(NotificationWorkManagerWorker notificationWorkManagerWorker);
}

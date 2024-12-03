package com.coffeemeetsbagel.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.q0;
import androidx.fragment.app.FragmentManager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.dialogs.DialogFullscreenSingleButton;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.logout.BannedActivity;
import com.coffeemeetsbagel.fragments.g1;
import com.coffeemeetsbagel.fragments.l1;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.UpgradeAvailability;
import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.new_user_experience.OnboardingComponentActivity;
import com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig;
import com.coffeemeetsbagel.token.g;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mparticle.kits.AppsFlyerKit;
import d7.c;
import h8.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lc.l;
import org.jivesoftware.smackx.mam.element.MamElements;
import r7.h;
import z9.f;

public class ActivityLogin extends r7.a implements f, UpgradeContract.Manager.UpgradeListener, t.a {
    /* access modifiers changed from: private */
    public h8.b B;
    private boolean C;
    private boolean D;
    private tj.a E;

    /* renamed from: b  reason: collision with root package name */
    h f10840b;

    /* renamed from: c  reason: collision with root package name */
    private l1 f10841c;

    /* renamed from: d  reason: collision with root package name */
    private g1 f10842d;

    /* renamed from: e  reason: collision with root package name */
    private FragmentManager f10843e;

    /* renamed from: f  reason: collision with root package name */
    private a7.a f10844f;

    /* renamed from: g  reason: collision with root package name */
    private jc.b<Void> f10845g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Dialog f10846h;

    /* renamed from: j  reason: collision with root package name */
    private Dialog f10847j;

    /* renamed from: k  reason: collision with root package name */
    private String f10848k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<ModelDeeplinkData> f10849l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f10850m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10851n = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f10852p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10853q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10854t;

    /* renamed from: w  reason: collision with root package name */
    private View f10855w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10856x;

    /* renamed from: y  reason: collision with root package name */
    private Runnable f10857y;

    /* renamed from: z  reason: collision with root package name */
    private Handler f10858z;

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("ActivityLogin", "Failed PUT-ting #referralcode (in signup_referral_code): " + ActivityLogin.this.f10852p);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("successfully PUT #referralcode (in signup_referral_code): ");
            sb2.append(ActivityLogin.this.f10852p);
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            NetworkProfile j10 = ActivityLogin.this.u0().j();
            if (!ActivityLogin.this.V0().isLoggedIn() || j10 == null || cmbErrorCode.getErrorCode() == 401) {
                ActivityLogin.this.n1(cmbErrorCode);
            } else {
                ActivityLogin.this.m1(j10);
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#login status=");
            sb2.append(successStatus);
            NetworkProfile j10 = ActivityLogin.this.u0().j();
            if (j10 == null) {
                ActivityLogin.this.n1(new CmbErrorCode("onReceiveSuccess is call but profile is null"));
                return;
            }
            ActivityLogin.this.V0().h(j10.getId());
            ActivityLogin.this.m1(j10);
        }
    }

    class c implements c.a {
        c() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Unit f() {
            return null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Unit g() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("mailto:contact@coffeemeetsbagel.com"));
            ActivityLogin.this.startActivity(intent);
            return null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h() {
            lc.c.h(ActivityLogin.this.f10840b);
        }

        public void a(CmbErrorCode cmbErrorCode) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#login errorStatus=");
            sb2.append(cmbErrorCode.getErrorMessage());
            ActivityLogin.this.U0("succeeded");
            ActivityLogin.this.f10850m = false;
            LoginManager.getInstance().logOut();
            int errorCode = cmbErrorCode.getErrorCode();
            String errorMessage = cmbErrorCode.getErrorMessage();
            if (errorCode == 3) {
                ActivityLogin.this.B1();
            } else if (errorCode == 401 && cmbErrorCode.getBannedReason() != BannedReason.NONE) {
                ActivityLogin.this.u1(cmbErrorCode.getBannedReason(), cmbErrorCode.getVerificationStatus());
            } else if (errorCode == 4 || errorCode == 401) {
                DialogPrimarySecondaryVertical.f12065a.b(ActivityLogin.this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, ActivityLogin.this.getString(R.string.app_displayed_name), errorMessage, ActivityLogin.this.getString(R.string.close_dls), new o(), ActivityLogin.this.getString(R.string.contact_us), new p(this), (Function0<Unit>) null);
            }
            if (ActivityLogin.this.y0()) {
                ActivityLogin.this.f10840b = new h(ActivityLogin.this);
                ActivityLogin.this.f10840b.show();
                ActivityLogin.this.z1();
            }
            fa.a.i(new Exception("Automatic Logout from onLoginFailure"));
            ActivityLogin.this.V0().l(ActivityLogin.this, new q(this), AnalyticsConstants$Logout.AUTOMATIC, "onLoginFailure");
        }

        public void b(UpgradeAvailability upgradeAvailability, String str) {
            ActivityLogin.this.p1();
            ActivityLogin.this.E1();
            int i10 = d.f10862a[upgradeAvailability.ordinal()];
            if (i10 == 1) {
                ActivityLogin.this.f10846h.show();
            } else if (i10 != 2) {
                ActivityLogin.this.S0();
            } else {
                ActivityLogin.this.softUpgradeDetected();
            }
            ActivityLogin.this.B.K(str);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10862a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10863b;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10863b = r0
                r1 = 1
                com.coffeemeetsbagel.models.enums.EventType r2 = com.coffeemeetsbagel.models.enums.EventType.REMOTE_CONFIG_UPDATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.coffeemeetsbagel.models.enums.UpgradeAvailability[] r0 = com.coffeemeetsbagel.models.enums.UpgradeAvailability.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10862a = r0
                com.coffeemeetsbagel.models.enums.UpgradeAvailability r2 = com.coffeemeetsbagel.models.enums.UpgradeAvailability.UPGRADE_MANDATORY     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f10862a     // Catch:{ NoSuchFieldError -> 0x002e }
                com.coffeemeetsbagel.models.enums.UpgradeAvailability r1 = com.coffeemeetsbagel.models.enums.UpgradeAvailability.UPGRADE_SUGGESTED     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.activities.ActivityLogin.d.<clinit>():void");
        }
    }

    private void A1() {
        if (!isFinishing()) {
            try {
                if (!(this.f10842d == null || this.f10843e.j0("FragmentLoading") == null)) {
                    this.f10843e.p().r(this.f10842d).j();
                }
                if (this.f10841c == null) {
                    this.f10841c = X0();
                }
                Bundle bundle = new Bundle();
                if (r1()) {
                    bundle.putBoolean(Extra.DEEP_LINK_TO_PHONE_LOGIN, true);
                    setIntent(new Intent());
                } else {
                    bundle.putBoolean(Extra.DEEP_LINK_TO_PHONE_LOGIN, false);
                }
                this.f10841c.setArguments(bundle);
                if (this.f10843e.j0("FragmentLogin") == null) {
                    this.f10843e.p().t(16908290, this.f10841c, "FragmentLogin").i();
                }
                this.f10843e.p().y(this.f10841c).j();
            } catch (IllegalStateException e10) {
                fa.a.i(e10);
            }
        }
    }

    private void C1() {
        D1(new int[0]);
    }

    private void D1(int[] iArr) {
        this.f10848k = null;
        Intent intent = new Intent(this, OnboardingComponentActivity.class);
        intent.setFlags(67108864);
        if (iArr != null && iArr.length > 0) {
            intent.putExtra("PAGES", iArr);
        }
        lc.a.c(this, intent);
        q1();
        finish();
    }

    /* access modifiers changed from: private */
    public void E1() {
        new g(new com.coffeemeetsbagel.token.a(Bakery.w().K()), Bakery.w().M().a(), FirebaseMessaging.getInstance(), Bakery.w().g()).start();
    }

    /* access modifiers changed from: private */
    public void S0() {
        if (!V0().isLoggedIn()) {
            z1();
        } else if (CollectionUtils.isEmpty((List) this.f10849l)) {
            E1();
            o1();
        } else {
            W0();
        }
    }

    private void T0(boolean z10) {
        String str;
        if (s0().a("FasterAppStart.Android.Enabled.Android")) {
            str = "SyncTrace_Refactor_2022";
        } else {
            str = "SyncTrace";
        }
        com.coffeemeetsbagel.bakery.g1.a(str, "Successful", String.valueOf(z10));
        com.coffeemeetsbagel.bakery.g1.d(str);
    }

    private void W0() {
        Class<ChatActivity> cls = ChatActivity.class;
        Class<ActivityMain> cls2 = ActivityMain.class;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#redeem data = ");
        sb2.append(this.f10849l);
        int size = this.f10849l.size();
        for (int i10 = 0; i10 < size; i10++) {
            ModelDeeplinkData modelDeeplinkData = this.f10849l.get(i10);
            if (!modelDeeplinkData.isRedeemDataComplete()) {
                fa.a.f("ActivityLogin", "ModelDeeplinkData is not complete");
                if (i10 == size - 1) {
                    o1();
                }
            } else if (ModelDeeplinkData.VALUE_PAGE_REDEEM_BAGEL.equals(modelDeeplinkData.getPage())) {
                if (u0().j() == null) {
                    Bakery.w().M().f("has_pending_redeem", true);
                    String b10 = j6.a.b(modelDeeplinkData);
                    if (Bakery.w().M().r("pending_redeem") != null) {
                        String r10 = Bakery.w().M().r("pending_redeem");
                        if (r10.startsWith("[")) {
                            r10 = r10.substring(1, r10.length() - 1);
                        }
                        Bakery.w().M().w("pending_redeem", "[" + r10 + AppsFlyerKit.COMMA + b10 + "]");
                    } else {
                        hb.c M = Bakery.w().M();
                        M.w("pending_redeem", "[" + b10 + "]");
                    }
                    if (i10 == size - 1) {
                        o1();
                    }
                } else {
                    this.f10848k = ModelDeeplinkData.VALUE_PAGE_TODAY;
                    o1();
                }
            } else if (ModelDeeplinkData.VALUE_PAGE_CONNECTION.equals(modelDeeplinkData.getPage())) {
                q0 j10 = q0.j(this);
                j10.i(cls);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Connection Bagel id: ");
                sb3.append(modelDeeplinkData.getBagelId());
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), cls);
                intent.putExtra(Extra.BAGEL_ID, modelDeeplinkData.getBagelId());
                intent.setAction(ModelDeeplinkData.VALUE_PAGE_CONNECTION);
                j10.b(intent);
                j10.o();
                if (i10 == size - 1) {
                    finish();
                }
            } else if (ModelDeeplinkData.VALUE_PAGE_CHAT.equals(modelDeeplinkData.getPage()) || ModelDeeplinkData.VALUE_PAGE_CHATS.equals(modelDeeplinkData.getPage())) {
                Intent intent2 = new Intent();
                intent2.setClass(getApplicationContext(), cls2);
                intent2.putExtra("deeplink_page_to_redirect_to", modelDeeplinkData.getPage());
                q0 j11 = q0.j(this);
                j11.i(cls2);
                j11.b(intent2);
                j11.o();
                if (i10 == size - 1) {
                    finish();
                }
            } else if (ModelDeeplinkData.VALUE_DISCOVER_FILTERS.equals(modelDeeplinkData.getPage())) {
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(), cls2);
                intent3.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_DISCOVER_FILTERS);
                q0 j12 = q0.j(this);
                j12.i(cls2);
                j12.b(intent3);
                j12.o();
                if (i10 == size - 1) {
                    finish();
                }
            } else if (ModelDeeplinkData.VALUE_VIDEO_FEED.endsWith(modelDeeplinkData.getPage())) {
                Intent intent4 = new Intent();
                intent4.setClass(getApplicationContext(), cls2);
                intent4.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_VIDEO_FEED);
                q0 j13 = q0.j(this);
                j13.i(cls2);
                j13.b(intent4);
                j13.o();
                if (i10 == size - 1) {
                    finish();
                }
            } else {
                this.f10848k = modelDeeplinkData.getPage();
                if (i10 == size - 1) {
                    o1();
                }
            }
        }
    }

    private l1 X0() {
        Intent intent = getIntent();
        boolean z10 = false;
        if (intent != null) {
            z10 = intent.getBooleanExtra(Extra.IS_ACCOUNT_DELETED, false);
        }
        return l1.H0(z10);
    }

    private void Y0() {
        OutageModeActivity.I0(this);
        finishAndRemoveTask();
    }

    private boolean Z0() {
        if (Build.VERSION.SDK_INT < 33 || androidx.core.content.a.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != -1 || !s1()) {
            return false;
        }
        return true;
    }

    private boolean b1() {
        String stringExtra = getIntent().getStringExtra(Extra.BANNED_REASON);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isUserBanned(): intent reason=");
        sb2.append(stringExtra);
        BannedReason fromApiKey = BannedReason.Companion.fromApiKey(stringExtra);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\t: reason=");
        sb3.append(fromApiKey.name());
        if (fromApiKey != BannedReason.NONE) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1(DialogInterface dialogInterface) {
        this.f10847j.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1() {
        Dialog dialog = this.f10847j;
        if (dialog == null) {
            Dialog w12 = w1();
            this.f10847j = w12;
            w12.setOnDismissListener(new i(this));
        } else if (!dialog.isShowing() && !this.C) {
            this.C = true;
            this.f10847j.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e1(DialogInterface dialogInterface) {
        this.f10846h.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(Activity activity, Intent intent) {
        lc.a.c(activity, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit g1() {
        l.c(this);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit h1() {
        l.c(this);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(Task task) {
        A1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit j1() {
        S0();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1() {
        if (!this.D) {
            x1(new k(this));
            this.D = true;
        }
    }

    /* access modifiers changed from: private */
    public void m1(@NonNull NetworkProfile networkProfile) {
        this.f10850m = false;
        HashMap hashMap = new HashMap();
        if (this.f10854t) {
            hashMap.put(FirebaseAnalytics.Param.METHOD, "deep link");
        } else {
            hashMap.put(FirebaseAnalytics.Param.METHOD, "direct");
        }
        hashMap.put("is badged", String.valueOf(Bakery.w().M().p("APP_BADGE_SHOWN")));
        this.f10844f.j("App Launch", hashMap);
        if (!isFinishing() && !this.f10853q) {
            if (Profile.getCurrentProfile() != null) {
                this.f10844f.a(networkProfile);
                if (!networkProfile.isOnHold()) {
                    this.f10844f.c("On Hold By User", "false");
                }
                U0("succeeded");
            } else if (TextUtils.isEmpty(networkProfile.getPhone())) {
                fa.a.i(new IllegalStateException("No Facebook profile or phone number, but sync is done."));
            }
            if (networkProfile.isMissingBasicInfo() || !Bakery.w().G().b()) {
                C1();
            } else if (Z0()) {
                D1(new int[]{OnboardingNavigationConfig.Pages.NOTIFICATION_JUSTIFICATION.ordinal()});
            } else {
                t1();
                T0(true);
            }
        }
        this.B.R();
    }

    /* access modifiers changed from: private */
    public void n1(@NonNull CmbErrorCode cmbErrorCode) {
        fa.a.f("ActivityLogin", "onSyncFatalError=" + cmbErrorCode.getErrorMessage());
        U0("succeeded");
        fa.a.i(new Exception("Automatic Logout from onSyncFatalError - " + cmbErrorCode.getErrorMessage()));
        d7.c V0 = V0();
        AnalyticsConstants$Logout analyticsConstants$Logout = AnalyticsConstants$Logout.AUTOMATIC;
        V0.c(this, analyticsConstants$Logout, "Sync Fatal Error: " + cmbErrorCode.getErrorMessage());
        sb.a.i(this.f10855w, R.string.error_login);
        z1();
        this.f10850m = false;
        T0(false);
    }

    private void o1() {
        String str;
        if (s0().a("FasterAppStart.Android.Enabled.Android")) {
            str = "SyncTrace_Refactor_2022";
        } else {
            str = "SyncTrace";
        }
        com.coffeemeetsbagel.bakery.g1.c(str);
        com.coffeemeetsbagel.bakery.g1.b(str, u0().j());
        com.coffeemeetsbagel.bakery.g1.a(str, "Incremental", String.valueOf(this.f10851n));
        this.B.z();
        Bakery.w().D().a(this.f10845g, true, true);
    }

    /* access modifiers changed from: private */
    public void p1() {
        if (!TextUtils.isEmpty(this.f10852p)) {
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.updateSignupReferralCode(this.f10852p);
            Bakery.w().G().p(new a(), modelProfileUpdateDelta, true);
        }
    }

    private void q1() {
        try {
            if (this.f10843e.j0("FragmentLogin") != null) {
                this.f10843e.p().r(this.f10841c).j();
            }
        } catch (Exception e10) {
            fa.a.i(e10);
        }
    }

    private boolean r1() {
        Uri data = getIntent().getData();
        if (data == null || !data.getScheme().equals(ModelDeeplinkData.CMB_AUTHORITY) || !data.getHost().equals(FirebaseAnalytics.Event.LOGIN) || !data.getLastPathSegment().equals("phone")) {
            return false;
        }
        return true;
    }

    private boolean s1() {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS") || !Bakery.w().M().n("KEY_REQUESTED_PUSH_PERMISSION", false)) {
            return true;
        }
        return false;
    }

    private void t1() {
        com.coffeemeetsbagel.bakery.g1.c("activity_main_launch");
        Intent intent = new Intent(this, ActivityMain.class);
        intent.putExtra(Extra.COLD_START, true);
        intent.setFlags(67108864);
        String str = this.f10848k;
        if (str != null) {
            intent.putExtra("deeplink_page_to_redirect_to", str);
            this.f10848k = null;
        }
        n nVar = new n(this, this, intent);
        this.f10857y = nVar;
        if (this.f10856x) {
            nVar.run();
            return;
        }
        Handler handler = new Handler();
        this.f10858z = handler;
        handler.postDelayed(this.f10857y, 2000);
    }

    private void v1() {
        BannedReason fromApiKey = BannedReason.Companion.fromApiKey(getIntent().getStringExtra(Extra.BANNED_REASON));
        VerificationStatus fromApiKey2 = VerificationStatus.Companion.fromApiKey(getIntent().getStringExtra(Extra.VERIFICATION_STATUS));
        if (getIntent().hasExtra(Extra.VERIFICATION_REFERENCE_ID)) {
            fromApiKey2.setReferenceId(getIntent().getStringExtra(Extra.VERIFICATION_REFERENCE_ID));
        }
        u1(fromApiKey, fromApiKey2);
    }

    private Dialog w1() {
        return new DialogFullscreenSingleButton(this, R.drawable.cmb_logo, t9.a.hardUpgradeTitle, t9.a.hardUpgradeText, t9.a.hardUpgradeButton, DialogFullscreenSingleButton.PrimaryCtaStyle.NORMAL, new j(this));
    }

    private void x1(Function0<Unit> function0) {
        DialogPrimarySecondaryVertical.f12065a.b(this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.cmb_logo), t9.a.softUpgradeTitle, t9.a.softUpgradeText, t9.a.softUpgradePrimaryButton, new m(this), t9.a.softUpgradeSecondaryButton, (Function0<Unit>) null, function0);
    }

    public void B1() {
        if (!isFinishing()) {
            OutageModeActivity.I0(this);
        }
    }

    public void I() {
        if (v0().n()) {
            Y0();
        }
    }

    public void R0() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null && TextUtils.isEmpty(V0().e())) {
            z1();
        } else if (currentAccessToken == null || !currentAccessToken.isExpired()) {
            okhttp3.l g10 = V0().g();
            if (g10 != null && g10.f() > System.currentTimeMillis()) {
                this.B.d("launching");
                S0();
            } else if (currentAccessToken != null) {
                this.B.d("authenticating");
                l1();
            } else {
                z1();
            }
        } else {
            z1();
        }
    }

    public void U0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(MamElements.MamResultExtension.ELEMENT, str);
        this.f10844f.j("Facebook Authentication", hashMap);
    }

    public d7.c V0() {
        return Bakery.w().g();
    }

    public void hardUpgradeDetected() {
        runOnUiThread(new g(this));
    }

    public void l1() {
        y1();
        if (!this.f10850m) {
            this.f10850m = true;
            V0().d(h5.l.j(), new c());
        }
    }

    public void n0(EventType eventType, Bundle bundle) {
        if (d.f10863b[eventType.ordinal()] == 1 && !this.f10856x) {
            this.f10856x = true;
            Handler handler = this.f10858z;
            if (handler != null) {
                handler.removeCallbacks(this.f10857y);
                this.f10857y.run();
            }
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onActivityResult: requestCode=");
        sb2.append(i10);
        sb2.append(" resultCode=");
        sb2.append(i11);
        if (i10 == 9307) {
            getIntent().removeExtra(Extra.BANNED_REASON);
            getIntent().removeExtra(Extra.VERIFICATION_REFERENCE_ID);
            getIntent().removeExtra(Extra.VERIFICATION_STATUS);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (v0().n()) {
            Y0();
            return;
        }
        this.f10855w = getWindow().getDecorView().findViewById(16908290);
        this.f10843e = getSupportFragmentManager();
        this.f10844f = k0();
        e eVar = new e(p0(), this.f10844f, Bakery.w().A(), Bakery.w().E(), q0());
        this.B = eVar;
        eVar.start();
        if (bundle == null) {
            this.f10841c = X0();
            this.f10842d = new g1();
            if (!V0().isLoggedIn()) {
                com.coffeemeetsbagel.bakery.g1.a("user_landed", "login_status", "unauthenticated");
                com.coffeemeetsbagel.bakery.g1.d("user_landed");
                z1();
                Bakery.w().h().a();
            } else {
                com.coffeemeetsbagel.bakery.g1.a("user_landed", "login_status", "authenticated");
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                String str = "false";
                if (currentAccessToken != null && !currentAccessToken.isExpired()) {
                    str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("has valid token", str);
                this.f10844f.trackEvent("Facebook Token Check", hashMap);
                String k10 = h5.l.k();
                if (!TextUtils.isEmpty(k10)) {
                    if (System.currentTimeMillis() < DateUtils.getMillisFromUtc(k10).longValue()) {
                        V0().i(h5.l.j());
                    }
                }
                this.f10851n = true;
                y1();
            }
        } else {
            this.f10841c = (l1) this.f10843e.j0("FragmentLogin");
            this.f10842d = (g1) this.f10843e.j0("FragmentLoading");
        }
        this.f10849l = new ArrayList<>();
        r0().c(this, EventType.REMOTE_CONFIG_UPDATED);
        w0().addUpgradeListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10849l = null;
        Handler handler = this.f10858z;
        if (handler != null) {
            handler.removeCallbacks(this.f10857y);
            this.f10858z = null;
        }
        if (this.f10857y != null) {
            this.f10857y = null;
        }
        r0().d(this, new EventType[0]);
        w0().removeUpgradeListener(this);
        h8.b bVar = this.B;
        if (bVar != null) {
            bVar.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (b1()) {
            v1();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f10853q = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!isFinishing()) {
            AppEventsLogger.activateApp(getApplication());
            this.f10853q = false;
            this.f10845g = new b();
            Dialog w12 = w1();
            this.f10846h = w12;
            w12.setOnDismissListener(new h(this));
            if (b1()) {
                v1();
            } else {
                R0();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.E = new tj.a();
        v0().e(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        v0().k(this);
        this.E.dispose();
        this.E = null;
    }

    public void softUpgradeDetected() {
        runOnUiThread(new f(this));
    }

    public void u1(BannedReason bannedReason, VerificationStatus verificationStatus) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showBannedActivity(): bannedReason=");
        sb2.append(bannedReason.name());
        sb2.append(" verificationStatus=");
        sb2.append(verificationStatus.name());
        BannedActivity.f13061h.a(this, bannedReason, verificationStatus);
    }

    public void y1() {
        this.B.M();
        try {
            if (!(this.f10841c == null || this.f10843e.j0("FragmentLogin") == null)) {
                this.f10843e.p().r(this.f10841c).j();
            }
            if (this.f10842d == null) {
                this.f10842d = new g1();
            }
            if (this.f10843e.j0("FragmentLoading") == null) {
                this.f10843e.p().t(16908290, this.f10842d, "FragmentLoading").i();
            }
            this.f10843e.p().y(this.f10842d).j();
        } catch (IllegalStateException e10) {
            fa.a.i(e10);
        }
    }

    public void z1() {
        FirebaseRemoteConfig.getInstance().fetchAndActivate().addOnCompleteListener(new l(this));
    }
}

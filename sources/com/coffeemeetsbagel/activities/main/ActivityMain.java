package com.coffeemeetsbagel.activities.main;

import a5.c;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b9.a;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.activities.OutageModeActivity;
import com.coffeemeetsbagel.activities.main.active_fragment.ActiveFragment;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.boost.BoostDialogFragment;
import com.coffeemeetsbagel.boost.BoostReportDialog;
import com.coffeemeetsbagel.boost.g;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.cmbbottomnav.behavior.AHBottomNavigationBehavior;
import com.coffeemeetsbagel.cmbbottomnav.component.CmbBottomNavView;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.data.CmbContentProvider;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.discover.e;
import com.coffeemeetsbagel.discoverV2.DiscoverFragment;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.exception.CmbSpecialException;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.feature.chatlist.g0;
import com.coffeemeetsbagel.feature.education.EducationActivity;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.like_pass.view.MatchActionType;
import com.coffeemeetsbagel.likes_you.n0;
import com.coffeemeetsbagel.limelight.LikesYouDialogUseCase;
import com.coffeemeetsbagel.limelight.LikesYouFragment;
import com.coffeemeetsbagel.limelight.dialog.d;
import com.coffeemeetsbagel.limelight.dialog.k;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.EmptyBodyObject;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.SubscriptionState;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.responses.ResponseBoostReport;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.preferences.MatchPreferencesComponentActivity;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.profile_me.MeProfileFragment;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.subscription_dialog.dialog.w;
import com.coffeemeetsbagel.suggested_history.SuggestedHistoryScreenComponentActivity;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.util.RequestCode;
import com.coffeemeetsbagel.utils.model.Optional;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.coffeemeetsbagel.whatsnew.ActivityWhatsNew;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.balloon.Balloon;
import com.uber.autodispose.p;
import f6.f2;
import h5.i;
import j5.h;
import j5.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import n8.s;
import o9.f;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.JSONException;
import v7.d;
import w5.a;
import w5.l;
import w9.b;
import y4.a0;
import y4.a1;
import y4.c0;
import y4.d0;
import y4.e0;
import y4.f0;
import y4.h0;
import y4.i0;
import y4.j0;
import y4.k0;
import y4.l0;
import y4.m;
import y4.m0;
import y4.n;
import y4.o;
import y4.o0;
import y4.p0;
import y4.q;
import y4.q0;
import y4.r;
import y4.r0;
import y4.s0;
import y4.t0;
import y4.u;
import y4.u0;
import y4.v;
import y4.y;
import y4.z;

public class ActivityMain extends h implements t.a, j.b, a.C0090a, f.a {
    private NetworkProfile B;
    public TabLayout C;
    private boolean D;
    private String E;
    private boolean F;
    private View G;
    private boolean H;
    private boolean I;
    private LinearLayout J;
    private CoordinatorLayout K;
    private View L;
    private ImageView M;
    private z8.a N;
    private k9.a O;
    private boolean P = true;
    private i8.a Q;
    private long R;
    protected a1 S;
    private cc.a T;
    private long U;
    private int V;
    private l W;
    private com.coffeemeetsbagel.like_pass.view.b X;
    private f Y;
    z4.a Z;

    /* renamed from: a0  reason: collision with root package name */
    x5.a f10891a0;

    /* renamed from: b0  reason: collision with root package name */
    y5.a f10892b0;

    /* renamed from: c0  reason: collision with root package name */
    y5.b f10893c0;

    /* renamed from: d0  reason: collision with root package name */
    s f10894d0;

    /* renamed from: e0  reason: collision with root package name */
    t7.a f10895e0;

    /* renamed from: f0  reason: collision with root package name */
    hb.c f10896f0;

    /* renamed from: g0  reason: collision with root package name */
    n0 f10897g0;

    /* renamed from: h0  reason: collision with root package name */
    d f10898h0;

    /* renamed from: i0  reason: collision with root package name */
    SubscriptionRepository f10899i0;

    /* renamed from: j0  reason: collision with root package name */
    GetSubscriptionBundlesUseCase f10900j0;

    /* renamed from: k0  reason: collision with root package name */
    s9.a f10901k0;

    /* renamed from: l0  reason: collision with root package name */
    a7.a f10902l0;

    /* renamed from: m0  reason: collision with root package name */
    f2 f10903m0;

    /* renamed from: n0  reason: collision with root package name */
    SaveProfilesLocalUseCase f10904n0;

    /* renamed from: o0  reason: collision with root package name */
    LikesYouDialogUseCase f10905o0;

    /* renamed from: p0  reason: collision with root package name */
    private int f10906p0 = -1;

    /* renamed from: q0  reason: collision with root package name */
    private k f10907q0;

    /* renamed from: r0  reason: collision with root package name */
    private b0 f10908r0;

    /* renamed from: s0  reason: collision with root package name */
    private w f10909s0;

    /* renamed from: t0  reason: collision with root package name */
    private final Map<String, Fragment> f10910t0 = new HashMap();

    /* renamed from: u0  reason: collision with root package name */
    private final Map<String, Integer> f10911u0 = new HashMap();

    /* renamed from: v0  reason: collision with root package name */
    private boolean f10912v0 = false;

    /* renamed from: w  reason: collision with root package name */
    private final c6.b f10913w = new c6.b();

    /* renamed from: w0  reason: collision with root package name */
    private tj.b f10914w0 = null;

    /* renamed from: x  reason: collision with root package name */
    private r7.h f10915x;

    /* renamed from: y  reason: collision with root package name */
    private String f10916y;

    /* renamed from: z  reason: collision with root package name */
    private String f10917z;

    class a implements g {
        a() {
        }

        public void a() {
        }

        public void b() {
        }

        public void onSuccess() {
            ActivityMain.this.R4();
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            ActivityMain.this.G2();
            sb.a.i(ActivityMain.this.getWindow().getDecorView().findViewById(R.id.main_coordinator_layout), R.string.error_network);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            ActivityMain.this.G2();
            ActivityMain.this.S0().w();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10920a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10921b;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00bf */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10921b = r0
                r1 = 1
                com.coffeemeetsbagel.models.enums.EventType r2 = com.coffeemeetsbagel.models.enums.EventType.SYNC_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10921b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r3 = com.coffeemeetsbagel.models.enums.EventType.CONNECTION_ADDED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f10921b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.models.enums.EventType r4 = com.coffeemeetsbagel.models.enums.EventType.GO_TO_EDIT_PHOTOS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f10921b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.models.enums.EventType r5 = com.coffeemeetsbagel.models.enums.EventType.ACCOUNT_ON_HOLD_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.CONNECTION_DETAILS_UPDATED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.PROFILE_SAVED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.PROFILE_UPDATE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7 = 7
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.BEANS_UPDATED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r7 = 8
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.FILTERS_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r7 = 9
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.UPDATE_SHOP_BADGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r7 = 10
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.SUGGESTED_BAGEL_PASSED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r7 = 11
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r5 = f10921b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.coffeemeetsbagel.models.enums.EventType r6 = com.coffeemeetsbagel.models.enums.EventType.SUGGESTED_BAGEL_LIKED     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r7 = 12
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                com.coffeemeetsbagel.models.entities.SubscriptionState[] r5 = com.coffeemeetsbagel.models.entities.SubscriptionState.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f10920a = r5
                com.coffeemeetsbagel.models.entities.SubscriptionState r6 = com.coffeemeetsbagel.models.entities.SubscriptionState.ON_HOLD     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r1 = f10920a     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.coffeemeetsbagel.models.entities.SubscriptionState r5 = com.coffeemeetsbagel.models.entities.SubscriptionState.CANCELLED     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = f10920a     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.coffeemeetsbagel.models.entities.SubscriptionState r1 = com.coffeemeetsbagel.models.entities.SubscriptionState.RECOVERED     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = f10920a     // Catch:{ NoSuchFieldError -> 0x00bf }
                com.coffeemeetsbagel.models.entities.SubscriptionState r1 = com.coffeemeetsbagel.models.entities.SubscriptionState.RESTARTED     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                int[] r0 = f10920a     // Catch:{ NoSuchFieldError -> 0x00c9 }
                com.coffeemeetsbagel.models.entities.SubscriptionState r1 = com.coffeemeetsbagel.models.entities.SubscriptionState.DEFAULT     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.activities.main.ActivityMain.c.<clinit>():void");
        }
    }

    private void A2(FragmentManager fragmentManager, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
            Bakery.w().z().k(getIntent());
            NetworkProfile j10 = d1().j();
            this.B = j10;
            if ((j10 != null && R0().getProfileId() != null) || l1()) {
                this.H = false;
            } else {
                return;
            }
        } else {
            this.H = true;
            this.B = (NetworkProfile) bundle.getSerializable("KEY_PROFILE");
            this.f10916y = bundle.getString("KEY_FRAGMENT_TAG");
            this.f10906p0 = bundle.getInt("KEY_SELECTED_TAB_ID");
            if (TextUtils.isEmpty(this.f10916y)) {
                fa.a.i(new CmbSpecialException("mCurrentlyVisibleFragmentTag is NULL"));
            }
        }
        androidx.fragment.app.b0 p10 = fragmentManager.p();
        for (String next : I2()) {
            Fragment s02 = fragmentManager.s0(bundle, next);
            if (s02 == null) {
                p10.c(R.id.fragmentContainer, M2(next), next);
            } else {
                this.f10910t0.put(next, s02);
            }
        }
        if (!p10.q()) {
            p10.l();
        }
        T2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A3(View view) {
        this.N.a();
    }

    private void A4() {
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            ((p) cmbToolbar.U().g(com.uber.autodispose.a.a(this))).c(new s0(this));
            ((p) this.f15597h.T().g(com.uber.autodispose.a.a(this))).c(new t0(this));
            ((p) this.f15597h.G().g(com.uber.autodispose.a.a(this))).c(new u0(this));
            ((p) this.f15597h.S().g(com.uber.autodispose.a.a(this))).c(new y4.b(this));
            ((p) this.f15597h.W().g(com.uber.autodispose.a.a(this))).c(new y4.c(this));
            S3();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B3(x xVar) throws Exception {
        g0 g0Var = (g0) M2("ChatListFragment");
        if ("ChatListFragment".equals(this.f10916y) && g0Var.V1()) {
            return;
        }
        if (this.f10901k0.a("ProfileBottomNav.Enabled.Android")) {
            if (X0().a("Rewind.Enabled.Android")) {
                O2();
                return;
            }
            SuggestedHistoryScreenComponentActivity.f37109m.a(this);
            overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
        } else if ("MeProfileFragment".equals(this.f10916y)) {
            ((MeProfileFragment) M2("MeProfileFragment")).h1();
        } else {
            d4();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean B4(com.coffeemeetsbagel.models.Price r6, org.json.b r7) {
        /*
            r5 = this;
            int r0 = r7.length()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = r6.getName()
            r2 = 0
            boolean r3 = r7.has(r0)     // Catch:{ JSONException -> 0x0018 }
            if (r3 == 0) goto L_0x0036
            int r7 = r7.getInt(r0)     // Catch:{ JSONException -> 0x0018 }
            goto L_0x0037
        L_0x0018:
            r7 = move-exception
            org.json.JSONException r0 = new org.json.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "#walletPresenter json exception when getting itemCount from map "
            r3.append(r4)
            java.lang.String r7 = r7.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.<init>((java.lang.String) r7)
            fa.a.i(r0)
        L_0x0036:
            r7 = r2
        L_0x0037:
            int r6 = r6.getFreeItemCount()
            if (r7 >= r6) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.activities.main.ActivityMain.B4(com.coffeemeetsbagel.models.Price, org.json.b):boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C3(x xVar) throws Exception {
        Intent intent = new Intent(this, ShopComponentActivity.class);
        intent.putExtra(Extra.SHOULD_SHOW_SHOP_BADGE, this.D);
        lc.a.c(this, intent);
        this.Q.G();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D3(x xVar) throws Exception {
        SuggestedHistoryScreenComponentActivity.f37109m.a(this);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E3(x xVar) throws Exception {
        O2();
    }

    private void E4() {
        if (this.f10908r0 == null) {
            b0 b0Var = new b0(this, R.string.cant_show_bagel_title, R.string.cant_show_bagel_body, R.string.got_it);
            this.f10908r0 = b0Var;
            ((p) b0Var.a().m0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y4.x(this));
        }
        this.f10908r0.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F3(x xVar) throws Exception {
        LeanPlumPaintedDoorDefinitions.PaintedDoor L2 = L2(J2());
        if (L2.c() && L2 != LeanPlumPaintedDoorDefinitions.PaintedDoor.UNDEFINED) {
            P0().d(L2.b(LeanPlumPaintedDoorDefinitions.DoorVariable.TRIGGER_EVENT));
        }
    }

    private void F4(String str) {
        G4(str, (ProfileCategory) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G3(x xVar) throws Exception {
        this.f10908r0.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H3() {
        lc.c.a(this);
    }

    private List<String> I2() {
        return Arrays.asList(new String[]{"ChatListFragment", "MeProfileFragment", "TodayViewFragment", "LikesYouFragment", "DiscoverFeedFragment"});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I3(View view) {
        startActivity(MatchPreferencesComponentActivity.f35786j.a(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit J3(Bitmap bitmap) {
        v2(new BitmapDrawable(getApplicationContext().getResources(), bitmap), true);
        return null;
    }

    private void J4(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("tag=");
        sb2.append(str);
        if ((str != null && !str.equals(this.f10916y)) || z10) {
            if ("TodayViewFragment".equals(str)) {
                this.Z.a(ActiveFragment.TODAY);
            } else if ("ChatListFragment".equals(str)) {
                this.Z.a(ActiveFragment.CHAT_LIST);
            } else if ("DiscoverFeedFragment".equals(str)) {
                this.Z.a(ActiveFragment.DISCOVER);
            } else if ("LikesYouFragment".equals(str)) {
                this.Z.a(ActiveFragment.LIMELIGHT);
            } else if ("MeProfileFragment".equals(str)) {
                this.Z.a(ActiveFragment.ME_PROFILE);
            }
            if (!this.f10910t0.containsKey(str)) {
                fa.a.i(new CmbSpecialException("fragmentToShow is null, tag=" + str));
                return;
            }
            o4(str);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Fragment j02 = supportFragmentManager.j0(this.f10916y);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("fragmentCurrentlyShown=");
            sb3.append(j02);
            if (!TextUtils.equals(this.f10916y, str)) {
                this.f10917z = this.f10916y;
            }
            this.f10916y = str;
            Fragment M2 = M2(str);
            boolean z11 = M2 instanceof j5.w;
            if (z11) {
                s4((j5.w) M2);
            }
            b5(str);
            if (j02 == null || M2 != j02 || z10) {
                if (j02 != null) {
                    supportFragmentManager.p().p(j02).j();
                }
                a5(str);
                androidx.fragment.app.b0 p10 = supportFragmentManager.p();
                if (!TextUtils.equals(str, "MeProfileFragment") || this.f10901k0.a("ProfileBottomNav.Enabled.Android")) {
                    p10.u(R.anim.fade_in, R.anim.fade_out);
                } else {
                    p10.u(R.anim.slide_in_from_right, R.anim.slide_out_to_right);
                }
                p10.y(M2).j();
                p4(str);
                new Handler().postDelayed(new r0(this), 400);
                if ((M2 instanceof bc.a) && this.F && !Bakery.w().M().y()) {
                    this.F = false;
                    Bakery.w().M().m();
                    return;
                }
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Already showing ");
            sb4.append(j02);
            if (z11) {
                ((j5.w) M2).Q0();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit K3() {
        lc.l.c(this);
        return null;
    }

    private void K4(int i10) {
        U4(i10, 6000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit L3() {
        return null;
    }

    private void L4() {
        if (!U0().a("history_in_suggested_toolbar")) {
            if (DateUtils.getNumberOfDaysRegisteredFromToday(this.B.getRegisteredDate()) > 0) {
                u2();
                this.f10896f0.b("key_last_time_history_tooltip_shown", DateUtils.getCurrentTimestamp());
                U0().b("history_in_suggested_toolbar");
            }
        } else if (!U0().a("history_in_suggested_toolbar_2x") && this.f10896f0.t("key_last_time_history_tooltip_shown") < DateUtils.getTimestampForLastNoon()) {
            u2();
            U0().b("history_in_suggested_toolbar_2x");
        }
    }

    private Fragment M2(String str) {
        Fragment fragment = this.f10910t0.get(str);
        if (fragment == null) {
            int i10 = -1;
            if (TextUtils.equals(str, "ChatListFragment")) {
                fragment = new g0();
                i10 = NavStateManager.NavState.CHAT.b();
            } else if (TextUtils.equals(str, "TodayViewFragment")) {
                fragment = new bc.a();
                i10 = NavStateManager.NavState.SUGGESTED.b();
            } else if (TextUtils.equals(str, "MeProfileFragment")) {
                fragment = new MeProfileFragment();
                i10 = NavStateManager.NavState.ME_PROFILE.b();
            } else if (TextUtils.equals(str, "LikesYouFragment")) {
                fragment = new LikesYouFragment();
                i10 = NavStateManager.NavState.LIKES_YOU.b();
            } else if (TextUtils.equals(str, "DiscoverFeedFragment")) {
                if (Bakery.w().s().a("Discover.MVVM")) {
                    fragment = new DiscoverFragment();
                } else {
                    fragment = new o6.b();
                }
                i10 = NavStateManager.NavState.DISCOVER.b();
            }
            if (fragment != null) {
                this.f10910t0.put(str, fragment);
            }
            if (i10 > 0) {
                this.f10911u0.put(str, Integer.valueOf(i10));
            }
        }
        return fragment;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit N3(PurchaseSource purchaseSource) {
        PremiumUpsellComponentActivity.f36846j.b(this, purchaseSource);
        return null;
    }

    private void N4(boolean z10) {
        if (z10) {
            this.f15597h.Z(true);
            this.f15597h.setMatchPrefsClickListener(new r(this));
            this.f15597h.N();
            return;
        }
        this.f15597h.Z(false);
        this.f15597h.Y();
    }

    private void O2() {
        if (this.f10912v0) {
            bc.a aVar = (bc.a) M2("TodayViewFragment");
            if (aVar != null) {
                aVar.J0();
                return;
            }
            return;
        }
        DialogPrimarySecondaryVertical.f12065a.b(this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.rewind_no_pass), getString(R.string.no_pass_to_rewind_title), getString(R.string.no_pass_to_rewind_description), getString(R.string.got_it), new y4.n0(), (String) null, (Function0<Unit>) null, (Function0<Unit>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O3(SubscriptionBenefitAttribution subscriptionBenefitAttribution, PurchaseSource purchaseSource, Pair pair) throws Exception {
        boolean z10;
        ResponseBoostReport responseBoostReport = (ResponseBoostReport) pair.c();
        h1().w("has_shown_boost_success", this.B.getBoostReportId());
        HashMap hashMap = new HashMap();
        if (responseBoostReport.getLikedCount() > 0) {
            String valueOf = String.valueOf(responseBoostReport.getLikedCount());
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "like");
            hashMap.put("like amount", valueOf);
        } else {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "shown");
            hashMap.put("shown amount", responseBoostReport.getSeenPercent() + "%");
        }
        P0().trackEvent("Boost Success Popup", hashMap);
        GetSubscriptionBundlesUseCase.a aVar = (GetSubscriptionBundlesUseCase.a) pair.d();
        if (!aVar.b().d() || aVar.b().c().b().stream().noneMatch(new n(subscriptionBenefitAttribution))) {
            z10 = true;
        } else {
            z10 = false;
        }
        BoostReportDialog boostReportDialog = new BoostReportDialog();
        if (z10) {
            boostReportDialog.b(this, new o(this, purchaseSource));
        } else {
            boostReportDialog.a(this);
        }
        x2();
    }

    private void O4(Class cls) {
        lc.a.d(this, new Intent(this, cls), RequestCode.OVERFLOW_ACTIVITY);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P3(Throwable th2) throws Exception {
        fa.a.g("ActivityMain", "Failed to get boost report ", th2);
        h1().remove("has_shown_boost_success");
    }

    private void P4(boolean z10, String str) {
        if (z10) {
            int dimension = (int) getApplicationContext().getResources().getDimension(R.dimen.tooltip_avatar_size);
            String str2 = str;
            com.coffeemeetsbagel.image_loader.b.f13967a.b(getApplicationContext(), str2, (ImageView) null, Integer.valueOf(R.drawable.icon_photo_placement_s), (Integer) null, new ImageLoaderContract.b(dimension, dimension), Arrays.asList(new w9.b[]{b.a.f18329a, b.f.f18336a, b.c.f18331a}), Collections.emptyMap(), (Function0<Unit>) null, new q0(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        } else if (!U0().a("suggested_rewind_ftue_tooltip")) {
            v2((Drawable) null, false);
        }
        U0().b("suggested_rewind_ftue_tooltip");
    }

    private boolean Q2() {
        long currentTimestamp = DateUtils.getCurrentTimestamp();
        if (currentTimestamp - this.R <= 500) {
            return false;
        }
        this.R = currentTimestamp;
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q3(x5.b bVar, int i10, Optional optional) throws Exception {
        if (!this.f10901k0.a("SPWV2.Show.Android") || !optional.d() || !((vb.a) optional.c()).h(BenefitKeys.UNLIMITED_SUGGESTED_VIEWS)) {
            bVar.d(String.valueOf(i10));
            bVar.e(true);
        } else if (this.f10901k0.a("SPWV2Badge.Show.Android")) {
            bVar.d(getString(R.string.infinity));
            bVar.e(true);
        } else {
            bVar.d((String) null);
            bVar.e(false);
        }
        this.f10891a0.d();
    }

    private void Q4(List<Price> list) {
        org.json.b l42 = l4();
        boolean z10 = false;
        boolean z11 = false;
        for (Price next : list) {
            if (!z11 && this.O.a(next) && next.getFreeItemCount() > 0) {
                z11 = B4(next, l42);
            }
        }
        if (this.B == null || !d1().q(this.B)) {
            z10 = z11;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(Extra.SHOULD_SHOW_SHOP_BADGE, z10);
        i.c(EventType.UPDATE_SHOP_BADGE, bundle);
    }

    private boolean R2() {
        boolean z10;
        SQLiteDatabase readableDatabase = f2.f().getReadableDatabase();
        Cursor d10 = CmbContentProvider.d(readableDatabase);
        Cursor a10 = e.f12177a.a(readableDatabase, String.valueOf(System.currentTimeMillis()));
        if (d10.getCount() != 0 || a10.getCount() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        d10.close();
        a10.close();
        return z10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R3() {
        NetworkProfile j10 = Bakery.w().G().j();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null && j10 != null) {
            cmbToolbar.setBeanCount(String.valueOf(j10.getBeans()));
        }
    }

    /* access modifiers changed from: private */
    public void R4() {
        NetworkProfile networkProfile = this.B;
        if (networkProfile != null && networkProfile.hasActiveBoost()) {
            U4(R.string.youre_being_boosted, 6000);
        }
    }

    private boolean S2() {
        if (this.f10896f0.a().getLong("LAST_SEEN_DISCOVER", 0) > DateUtils.getTimestampForLastNoon()) {
            return true;
        }
        return false;
    }

    private void S3() {
        ((p) d1().m().m0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y4.s(this));
    }

    private void T2() {
        androidx.fragment.app.b0 p10 = getSupportFragmentManager().p();
        for (String str : I2()) {
            Fragment fragment = this.f10910t0.get(str);
            if (fragment != null) {
                p10.p(fragment);
            }
        }
        p10.j();
    }

    private void T3(AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        U3(false, analyticsConstants$Logout, strArr);
    }

    private void U3(boolean z10, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr) {
        j();
        R0().b(this, z10, new y4.d(this), analyticsConstants$Logout, strArr);
    }

    private void V3() {
        this.f10902l0.f("Chats");
        I4("ChatListFragment");
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            this.f15597h.P();
        }
        W2();
        C4();
        V2();
        this.f15597h.setDisplayHomeAsUp(false);
        N4(false);
        f5(false, true);
        g4();
    }

    private void V4(SubscriptionState subscriptionState) {
        int i10 = c.f10920a[subscriptionState.ordinal()];
        if (i10 == 1) {
            DialogPrimarySecondaryVertical.f12065a.a(this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.action_required), R.string.subscription_on_hold_title, R.string.subscription_on_hold_description, R.string.update_my_payment, new y4.p(this), Integer.valueOf(R.string.not_now), new q(), (Function0<Unit>) null);
            this.f10896f0.c("last_shown_subscription_state", SubscriptionState.ON_HOLD.getApiKey());
        } else if (i10 == 2) {
            z1(R.string.subscription_cancelled);
            this.f10896f0.c("last_shown_subscription_state", SubscriptionState.CANCELLED.getApiKey());
        } else if (i10 == 3) {
            z1(R.string.subscription_recovered);
            this.f10896f0.c("last_shown_subscription_state", SubscriptionState.RECOVERED.getApiKey());
        } else if (i10 == 4) {
            z1(R.string.subscription_restarted);
            this.f10896f0.c("last_shown_subscription_state", SubscriptionState.RESTARTED.getApiKey());
        } else if (i10 == 5) {
            this.f10896f0.c("last_shown_subscription_state", SubscriptionState.DEFAULT.getApiKey());
        }
    }

    private void W2() {
        LinearLayout linearLayout = this.J;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void W3() {
        if (Q2()) {
            F2();
            ((bc.a) M2("TodayViewFragment")).E0();
        }
    }

    private void W4() {
        NetworkProfile networkProfile = this.B;
        if (networkProfile != null && !networkProfile.hasActiveBoost() && !TextUtils.isEmpty(this.B.getBoostReportId())) {
            if (TextUtils.isEmpty(h1().r("has_shown_boost_success")) || !this.B.getBoostReportId().equals(h1().r("has_shown_boost_success"))) {
                PurchaseSource purchaseSource = new PurchaseSource("boost report modal", "boost report modal");
                SubscriptionBenefitAttribution a10 = SubscriptionBenefitAttribution.f36723a.a(purchaseSource);
                ((com.uber.autodispose.t) ck.b.f24947a.a(this.T.b(this.B.getBoostReportId()), this.f10900j0.l(a10.c()).L()).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new y4.g(this, a10, purchaseSource), new y4.h(this));
            }
        }
    }

    private void Y2() {
        k4();
    }

    private void Y3() {
        if (Q2()) {
            F2();
            ((bc.a) M2("TodayViewFragment")).F0();
        }
    }

    private void Z3() {
        if (Q2()) {
            F2();
            bc.a aVar = (bc.a) M2("TodayViewFragment");
            if (aVar != null) {
                aVar.G0();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a3(ResponseGeneric responseGeneric) throws Exception {
        if (responseGeneric.isSuccessful()) {
            h1().remove("has_shown_boost_success");
            d1().f();
        }
    }

    private void a4() {
        if (Q2()) {
            F2();
            ((bc.a) M2("TodayViewFragment")).H0();
        }
    }

    private void a5(String str) {
        Fragment M2 = M2(str);
        if (M2 instanceof bc.a) {
            ((bc.a) M2).M0();
        } else if (M2 instanceof g0) {
            ((g0) M2).W1();
        } else if (M2 instanceof MeProfileFragment) {
            ((MeProfileFragment) M2).j1();
        } else if (M2 instanceof LikesYouFragment) {
            ((LikesYouFragment) M2).O0();
        } else if (M2 instanceof DiscoverFragment) {
            ((DiscoverFragment) M2).C1();
        } else if (M2 instanceof o6.b) {
            ((o6.b) M2).E0();
        } else {
            fa.a.f("ActivityMain", "Can't unselect " + str);
        }
        Integer num = this.f10911u0.get(str);
        if (num != null) {
            this.f10892b0.b(num);
            return;
        }
        fa.a.f("ActivityMain", "Can't set the resource for " + str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit b3() {
        return null;
    }

    private void b4() {
        I4("LikesYouFragment");
        C4();
        V2();
        W2();
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            this.f15597h.P();
        }
        this.f15597h.setDisplayHomeAsUp(false);
        N4(false);
        f5(false, true);
        g4();
    }

    private void b5(String str) {
        boolean equals = "DiscoverFeedFragment".equals(this.f10916y);
        boolean equals2 = "TodayViewFragment".equals(this.f10916y);
        boolean equals3 = "DiscoverFeedFragment".equals(str);
        boolean equals4 = "TodayViewFragment".equals(str);
        boolean equals5 = "MeProfileFragment".equals(str);
        boolean equals6 = "MeProfileFragment".equals(this.f10916y);
        if (equals) {
            if (!equals3) {
                Fragment M2 = M2("DiscoverFeedFragment");
                if (M2 instanceof o6.b) {
                    ((o6.b) M2).F0();
                } else if (M2 instanceof DiscoverFragment) {
                    ((DiscoverFragment) M2).D1();
                }
            }
        } else if (equals2) {
            if (!equals4) {
                ((bc.a) M2("TodayViewFragment")).N0();
            }
        } else if (equals6 && !equals5) {
            ((MeProfileFragment) M2("MeProfileFragment")).u1();
        }
        if (equals2 && !equals4) {
            this.Q.h();
            this.J.setVisibility(8);
            n4();
            CmbToolbar cmbToolbar = this.f15597h;
            if (cmbToolbar != null) {
                cmbToolbar.R();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c3(x xVar) throws Exception {
        m4();
    }

    private void c4() {
        if (Q2()) {
            F2();
            bc.a aVar = (bc.a) M2("TodayViewFragment");
            if (aVar != null) {
                aVar.I0();
            }
        }
        if (this.f10901k0.a("SuggestedHistory.Android.Show.Android") && !this.f10901k0.a("Rewind.Enabled.Android")) {
            L4();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d3(Optional optional) throws Exception {
        if (optional.d()) {
            switch (((Integer) optional.c()).intValue()) {
                case R.id.bottom_nav_item_badge_profile /*2131296442*/:
                case R.id.bottom_nav_item_profile /*2131296448*/:
                    d4();
                    return;
                case R.id.bottom_nav_item_bagels /*2131296444*/:
                    f4();
                    return;
                case R.id.bottom_nav_item_chat /*2131296445*/:
                    V3();
                    return;
                case R.id.bottom_nav_item_discover /*2131296446*/:
                    X3();
                    return;
                case R.id.bottom_nav_item_limelight /*2131296447*/:
                    b4();
                    return;
                default:
                    fa.a.g("ActivityMain", "", new IllegalArgumentException("unknown nav item" + optional.c()));
                    return;
            }
        }
    }

    private void d5() {
        runOnUiThread(new y4.j(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e3(DialogInterface dialogInterface) {
    }

    private void e4() {
        if (Q2()) {
            F2();
            bc.a aVar = (bc.a) M2("TodayViewFragment");
            if (aVar != null) {
                aVar.L0();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f3(Map map) throws Exception {
        Q4(new ArrayList(map.values()));
    }

    private void f5(boolean z10, boolean z11) {
        if (this.f15597h != null) {
            if (z11) {
                if (X0().a("ProfileBottomNav.Enabled.Android")) {
                    this.f15597h.P();
                    return;
                }
                this.f15597h.Q();
                this.f15597h.O();
            } else if (X0().a("ProfileBottomNav.Enabled.Android")) {
                this.f15597h.O();
                this.f15597h.Q();
                if (X0().a("Rewind.Enabled.Android")) {
                    this.f15597h.setLeftIcon(androidx.core.content.res.h.e(getResources(), R.drawable.rewind, (Resources.Theme) null));
                    this.f15597h.H(z10);
                } else if (X0().a("SuggestedHistory.Android.Show.Android")) {
                    this.f15597h.setLeftIcon(androidx.core.content.res.h.e(getResources(), R.drawable.ic_menu_item_history, (Resources.Theme) null));
                }
                this.f15597h.b0();
            } else if (X0().a("Rewind.Enabled.Android")) {
                this.f15597h.O();
                this.f15597h.c0(z10);
            } else if (X0().a("SuggestedHistory.Android.Show.Android")) {
                this.f15597h.a0();
                this.f15597h.Q();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g3(Optional optional) throws Exception {
        int i10;
        SubscriptionState subscriptionState;
        boolean z10;
        if (optional.d()) {
            i10 = R.layout.history_tooltip_sub;
        } else {
            i10 = R.layout.history_tooltip_non_sub;
        }
        this.V = i10;
        SubscriptionState fromApiKey = SubscriptionState.Companion.fromApiKey(Integer.valueOf(this.f10896f0.l("last_shown_subscription_state")));
        if (optional.d()) {
            subscriptionState = ((vb.a) optional.c()).f();
        } else {
            subscriptionState = SubscriptionState.DEFAULT;
        }
        if (fromApiKey != subscriptionState) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (subscriptionState != SubscriptionState.DEFAULT) {
                HashMap hashMap = new HashMap();
                hashMap.put("state", subscriptionState.name());
                P0().trackEvent("Subscription State Shown", hashMap);
            }
            V4(subscriptionState);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h3(String str) {
        Bagel D2 = S0().D(str);
        if (D2 != null) {
            Intent K1 = ChatActivity.K1(this, D2);
            K1.putExtra("NAVIGATE_TO_CHAT_LIST", true);
            lc.a.c(this, K1);
            return;
        }
        r4();
        V3();
    }

    private void h4() {
        Class<ShopComponentActivity> cls = ShopComponentActivity.class;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("redirectToDeeplinkDestination: ");
        sb2.append(this.E);
        if (!TextUtils.isEmpty(this.E)) {
            String str = this.E;
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -2065507977:
                    if (str.equals(ModelDeeplinkData.VALUE_EDIT_PROFILE)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1818876942:
                    if (str.equals(ModelDeeplinkData.VALUE_DISCOVER_FILTERS)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1396198907:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_BASICS)) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -1340241962:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_MEMBERSHIP)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case -989034367:
                    if (str.equals("photos")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case -537483219:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_WHO_YOU_WANT)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case -309425751:
                    if (str.equals("profile")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case -290756696:
                    if (str.equals("education")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 3480:
                    if (str.equals("me")) {
                        c10 = 8;
                        break;
                    }
                    break;
                case 114717:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_TEN)) {
                        c10 = 9;
                        break;
                    }
                    break;
                case 3052376:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_CHAT)) {
                        c10 = 10;
                        break;
                    }
                    break;
                case 3560248:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_TIPS)) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 93922211:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_BOOST)) {
                        c10 = 12;
                        break;
                    }
                    break;
                case 94623771:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_CHATS)) {
                        c10 = 13;
                        break;
                    }
                    break;
                case 106930864:
                    if (str.equals("prefs")) {
                        c10 = 14;
                        break;
                    }
                    break;
                case 110534465:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_TODAY)) {
                        c10 = 15;
                        break;
                    }
                    break;
                case 273184745:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_DISCOVER)) {
                        c10 = 16;
                        break;
                    }
                    break;
                case 315730723:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_SUGGESTED)) {
                        c10 = 17;
                        break;
                    }
                    break;
                case 663509362:
                    if (str.equals(ModelDeeplinkData.VALUE_EDIT_DATING)) {
                        c10 = 18;
                        break;
                    }
                    break;
                case 926934164:
                    if (str.equals("history")) {
                        c10 = 19;
                        break;
                    }
                    break;
                case 1100650276:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_REWARDS)) {
                        c10 = 20;
                        break;
                    }
                    break;
                case 1103701731:
                    if (str.equals(ModelDeeplinkData.VALUE_LIKES_YOU)) {
                        c10 = 21;
                        break;
                    }
                    break;
                case 1322423974:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_BEAN_SHOP)) {
                        c10 = 22;
                        break;
                    }
                    break;
                case 1434631203:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_SETTINGS)) {
                        c10 = 23;
                        break;
                    }
                    break;
                case 1960030858:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_INVITES)) {
                        c10 = 24;
                        break;
                    }
                    break;
                case 1971885608:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_SEEMORE)) {
                        c10 = 25;
                        break;
                    }
                    break;
                case 1989861112:
                    if (str.equals(ModelDeeplinkData.VALUE_PAGE_PREFERENCES)) {
                        c10 = 26;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    F4("FRAGMENT_INDEX_DETAILS");
                    return;
                case 1:
                    B2();
                    return;
                case 2:
                    F4("FRAGMENT_INDEX_DETAILS");
                    return;
                case 3:
                case 23:
                    O4(ActivitySettings.class);
                    return;
                case 4:
                    F4("FRAGMENT_INDEX_PHOTOS");
                    return;
                case 5:
                case 14:
                case 26:
                    startActivity(MatchPreferencesComponentActivity.f35786j.a(this));
                    return;
                case 6:
                    Intent intent = new Intent(this, BagelProfileComponentActivity.class);
                    intent.putExtra("profile", Bakery.w().G().j());
                    startActivity(intent);
                    return;
                case 7:
                    O4(EducationActivity.class);
                    return;
                case 8:
                    String stringExtra = getIntent().getStringExtra(Extra.DEEP_LINK_ME_SEGMENT);
                    getIntent().removeExtra(Extra.DEEP_LINK_ME_SEGMENT);
                    E2(stringExtra);
                    return;
                case 9:
                case 16:
                case 25:
                    X3();
                    return;
                case 10:
                    String stringExtra2 = getIntent().getStringExtra(Extra.DEEP_LINK_CHAT_TO_LOAD);
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        getIntent().removeExtra(Extra.DEEP_LINK_CHAT_TO_LOAD);
                        S0().i(new m(this, stringExtra2));
                        return;
                    }
                    r4();
                    V3();
                    return;
                case 11:
                    X4();
                    return;
                case 12:
                    a aVar = new a();
                    if (e1().getPrice(PurchaseType.BOOST) != null) {
                        BoostDialogFragment.f11414q.a(aVar).show(getSupportFragmentManager(), "BoostDialogFragment");
                        return;
                    }
                    return;
                case 13:
                    if (getIntent().hasExtra(Extra.CHAT_LOAD_ERROR) && getIntent().getBooleanExtra(Extra.CHAT_LOAD_ERROR, false)) {
                        E4();
                    }
                    r4();
                    V3();
                    return;
                case 15:
                case 17:
                    f4();
                    return;
                case 18:
                    G4("FRAGMENT_INDEX_DETAILS", ProfileCategory.DATING_STYLE);
                    return;
                case 19:
                    SuggestedHistoryScreenComponentActivity.f37109m.a(this);
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                    return;
                case 20:
                    O4(cls);
                    return;
                case 21:
                    D2();
                    return;
                case 22:
                    O4(cls);
                    return;
                case 24:
                    C2("today's bagel");
                    return;
                default:
                    return;
            }
        }
    }

    private void h5(boolean z10) {
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            x5.b b10 = this.f10891a0.b(R.id.bottom_nav_item_badge_profile);
            if (b10 != null) {
                b10.e(z10);
                this.f10891a0.d();
                return;
            }
            return;
        }
        b5.e.k(this, d1(), this.f15597h, z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit i3(LeanPlumPaintedDoorDefinitions.PaintedDoor paintedDoor, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not load the icon for ");
        sb2.append(paintedDoor);
        sb2.append(": ");
        sb2.append(str);
        this.f15597h.e0(false, "");
        return null;
    }

    private void i4() {
        Intent intent = getIntent();
        boolean z10 = false;
        if (intent != null) {
            if (intent.getBooleanExtra("is_from_chat_push", false)) {
                r4();
                this.I = true;
                intent.removeExtra("is_from_chat_push");
            }
            if (intent.getBooleanExtra("is_from_onboarding", false)) {
                z10 = true;
            }
        }
        if (!this.H && !this.I) {
            if (S0().H().booleanValue() || (R2() && !z10)) {
                this.f10892b0.b(Integer.valueOf(R.id.bottom_nav_item_discover));
                q4(R.string.discover);
            } else {
                this.f10892b0.b(Integer.valueOf(R.id.bottom_nav_item_bagels));
                q4(R.string.suggested);
            }
            this.I = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit j3(String str, LeanPlumPaintedDoorDefinitions.PaintedDoor paintedDoor, Bitmap bitmap) {
        this.f15597h.e0(true, str);
        LeanPlumPaintedDoorDefinitions.DoorVariable doorVariable = LeanPlumPaintedDoorDefinitions.DoorVariable.VIEWED_EVENT;
        if (TextUtils.isEmpty(paintedDoor.b(doorVariable))) {
            return null;
        }
        P0().d(paintedDoor.b(doorVariable));
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k3(Optional optional) throws Exception {
        if (!optional.d() || !((vb.a) optional.c()).h(BenefitKeys.UNLIMITED_SUGGESTED_VIEWS)) {
            this.f15597h.setTitle(getString(R.string.suggested));
        } else {
            this.f15597h.setTitle(getString(R.string.suggested_unlimited));
        }
    }

    private void k4() {
        S0().s();
    }

    private org.json.b l4() {
        String r10 = Bakery.w().M().r("last_seen_price_state");
        if (r10 == null) {
            return new org.json.b();
        }
        try {
            return new org.json.b(r10);
        } catch (JSONException e10) {
            fa.a.i(new JSONException("#walletPresenter json exception " + e10.getMessage()));
            return new org.json.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m3(x xVar) throws Exception {
        a4();
    }

    private void m4() {
        boolean z10;
        boolean z11 = true;
        if (d1().j() == null || !d1().j().hasActiveBoost()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!d1().h() && !z10) {
            z11 = false;
        }
        h5(z11);
    }

    private void n4() {
        ((AppBarLayout.e) V0().getLayoutParams()).g(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o3(x xVar) throws Exception {
        c4();
    }

    private void o4(String str) {
        if (TextUtils.equals(str, "ChatListFragment")) {
            q4(R.string.chats);
        } else if (TextUtils.equals(str, "TodayViewFragment")) {
            q4(R.string.suggested);
        } else if (TextUtils.equals(str, "LikesYouFragment")) {
            q4(R.string.limelight);
        } else if (TextUtils.equals(str, "MeProfileFragment")) {
            q4(R.string.f18840me);
        } else if (TextUtils.equals(str, "DiscoverFeedFragment")) {
            q4(R.string.discover);
        } else {
            fa.a.f("ActivityMain", "Can't find the title for " + str);
        }
    }

    private void p4(String str) {
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null && cmbToolbar.getPaintedDoor() != null) {
            LeanPlumPaintedDoorDefinitions.PaintedDoor L2 = L2(str);
            if (!L2.c() || L2 == LeanPlumPaintedDoorDefinitions.PaintedDoor.UNDEFINED) {
                this.f15597h.e0(false, "");
                return;
            }
            ImageLoaderContract.b bVar = new ImageLoaderContract.b(L2.a(LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_WIDTH), L2.a(LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_HEIGHT));
            String b10 = L2.b(LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_URL);
            String b11 = L2.b(LeanPlumPaintedDoorDefinitions.DoorVariable.ACCESSIBILITY_LABEL);
            L2.b(LeanPlumPaintedDoorDefinitions.DoorVariable.TRIGGER_EVENT);
            com.coffeemeetsbagel.image_loader.b.f13967a.b(this, b10, this.f15597h.getPaintedDoor(), (Integer) null, (Integer) null, bVar, Collections.emptyList(), Collections.emptyMap(), new y4.t(this, L2, b10), new u(this, b11, L2), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, ImageLoaderContract.MemoryConfig.NO_STORE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q3(x xVar) throws Exception {
        W3();
    }

    private void q4(int i10) {
        if (this.f15597h != null) {
            tj.b bVar = this.f10914w0;
            if (bVar != null) {
                bVar.dispose();
                this.f10914w0 = null;
            }
            if (!this.f10901k0.a("SPWV2.Show.Android") || i10 != R.string.suggested) {
                this.f15597h.setTitle(getString(i10));
            } else {
                this.f10914w0 = ((com.uber.autodispose.n) this.f10899i0.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new v(this));
            }
        }
    }

    private void r4() {
        this.f10892b0.b(Integer.valueOf(R.id.bottom_nav_item_chat));
        q4(R.string.chats);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s3(x xVar) throws Exception {
        Z3();
    }

    private void s4(j5.w wVar) {
        j1().setOnClickListener(new y(wVar));
    }

    private void t4() {
        ((p) this.X.b(MatchActionType.LIKE).g(com.uber.autodispose.a.a(this))).b(new a0(this), new d0());
        ((p) this.X.b(MatchActionType.PASS).g(com.uber.autodispose.a.a(this))).b(new e0(this), new f0());
        this.X.setCommentButtonImageResource(R.drawable.comment_overall);
        ((p) this.X.b(MatchActionType.COMMENT).g(com.uber.autodispose.a.a(this))).b(new y4.g0(this), new i0());
        ((p) this.X.b(MatchActionType.INSTANT_LIKE).g(com.uber.autodispose.a.a(this))).b(new j0(this), new k0());
        ((p) this.X.b(MatchActionType.FLOWER).g(com.uber.autodispose.a.a(this))).b(new l0(this), new m0());
        ((p) this.X.b(MatchActionType.SEND_FLOWER).g(com.uber.autodispose.a.a(this))).b(new y4.b0(this), new c0());
    }

    private void u2() {
        Balloon.a l12 = new Balloon.a(this).r1(R.dimen.baseline_3x).l1(this.V);
        com.coffeemeetsbagel.view.e.b(l12, this, getResources());
        l12.a().C0(this.f15597h.getHistoryIcon());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u3(x xVar) throws Exception {
        Y3();
    }

    private void u4() {
        ImageView imageView = (ImageView) findViewById(R.id.image_gradient);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        imageView.setVisibility(8);
        ((CoordinatorLayout.f) layoutParams).o(new AHBottomNavigationBehavior(true, (int) getResources().getDimension(R.dimen.bottom_nav_height)));
        imageView.setLayoutParams(layoutParams);
        v4();
    }

    private void v2(Drawable drawable, boolean z10) {
        View view;
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            view = this.f15597h.getLeftIcon();
        } else {
            view = this.f15597h.getRewindIcon();
        }
        Balloon.a aVar = new Balloon.a(this);
        if (z10) {
            aVar.D1(true).E1(R.string.suggested_rewind_rising_balloon).h1(drawable);
        } else {
            aVar.D1(true).E1(R.string.suggested_rewind_balloon);
        }
        com.coffeemeetsbagel.view.e.b(aVar, this, getResources());
        aVar.a().C0(view);
    }

    private void v4() {
        if (this.W == null) {
            l b10 = new w5.a((a.c) this.S.A0()).b(this.K);
            this.W = b10;
            b6.r.a(b10);
            this.K.addView((CmbBottomNavView) this.W.l());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new x5.b(getString(R.string.suggested), getResources().getDrawable(R.drawable.tab_suggested), R.id.bottom_nav_item_bagels, (String) null, false));
            arrayList.add(this.f10897g0);
            arrayList.add(new x5.b(getString(R.string.discover), getResources().getDrawable(R.drawable.tab_discover), R.id.bottom_nav_item_discover, (String) null, false));
            arrayList.add(new x5.b(getString(R.string.chats), getResources().getDrawable(R.drawable.tab_chat), R.id.bottom_nav_item_chat, (String) null, false));
            if (X0().a("ProfileBottomNav.Enabled.Android")) {
                arrayList.add(new x5.b(getString(R.string.f18840me), getResources().getDrawable(R.drawable.ic_bottombar_profile), R.id.bottom_nav_item_badge_profile, (String) null, false));
            }
            this.f10891a0.c(arrayList);
            int i10 = this.f10906p0;
            if (-1 != i10) {
                this.f10892b0.b(Integer.valueOf(i10));
            }
        }
    }

    private long w2(Long l10) {
        long j10;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = DateUtils.getTimestampForNextNoon();
        }
        return j10 + 3000;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w3(x xVar) throws Exception {
        e4();
    }

    private void w4() {
        if (this.f10901k0.a("NewControl.Existing.Enabled.Android") && !TextUtils.isEmpty(com.coffeemeetsbagel.whatsnew.e.whatsNewCoachMark) && com.coffeemeetsbagel.whatsnew.e.b().size() > 0 && !U0().a(com.coffeemeetsbagel.whatsnew.e.whatsNewCoachMark)) {
            ActivityWhatsNew.f37610f.a(this);
            U0().b(com.coffeemeetsbagel.whatsnew.e.whatsNewCoachMark);
        }
    }

    private void x2() {
        ((com.uber.autodispose.t) this.T.a(this.B.getBoostReportId(), new EmptyBodyObject()).K(dk.a.c()).E(sj.a.a()).I(new oc.e(5)).g(com.uber.autodispose.a.a(this))).c(new z(this));
    }

    private void x4() {
        ((p) new a5.c((c.a) this.S.A0()).e().s().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y4.k(this));
    }

    private void y2(Intent intent) {
        boolean z10;
        if (intent.getAction() == null && intent.getDataString() != null && TextUtils.equals(intent.getData().getScheme(), ModelDeeplinkData.CMB_AUTHORITY)) {
            intent.setAction("android.intent.action.VIEW");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkIntentAndSetRedirect: action=");
        sb2.append(intent.getAction());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("checkIntentAndSetRedirect: data=");
        sb3.append(intent.getDataString());
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            if (intent.getData() == null) {
                this.E = null;
                return;
            }
            Uri data = getIntent().getData();
            String lastPathSegment = data.getLastPathSegment();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("checkIntentAndSetRedirect: lastPathSegment=");
            sb4.append(lastPathSegment);
            boolean z11 = true;
            if (!data.getScheme().equals(ModelDeeplinkData.CMB_AUTHORITY) || !data.getHost().equals(ModelDeeplinkData.VALUE_PAGE_CHAT) || TextUtils.isEmpty(lastPathSegment)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!data.getScheme().equals(ModelDeeplinkData.CMB_AUTHORITY) || !data.getHost().equals("me") || TextUtils.isEmpty(lastPathSegment)) {
                z11 = false;
            }
            if (z10) {
                this.E = data.getHost();
                intent.putExtra(Extra.DEEP_LINK_CHAT_TO_LOAD, lastPathSegment);
            } else if (z11) {
                this.E = data.getHost();
                intent.putExtra(Extra.DEEP_LINK_ME_SEGMENT, lastPathSegment);
            } else if (!TextUtils.isEmpty(lastPathSegment)) {
                this.E = lastPathSegment;
            } else if (!TextUtils.isEmpty(data.getHost())) {
                this.E = data.getHost();
            } else {
                this.E = null;
            }
            intent.setAction((String) null);
        } else if (intent.hasExtra("deeplink_page_to_redirect_to")) {
            String stringExtra = intent.getStringExtra("deeplink_page_to_redirect_to");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Redirect to page: ");
            sb5.append(stringExtra);
            intent.removeExtra("deeplink_page_to_redirect_to");
            this.E = stringExtra;
        } else {
            this.E = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y3(ra.a aVar) throws Exception {
        this.J.removeAllViews();
        this.X = ((ca.g) aVar.a(x.a())).a(this.J);
        t4();
        if (d1().j() != null && d1().j().hasPrioritizedLikes()) {
            this.X.setLikeButtonImageResource(R.drawable.priority_like_button);
        }
        this.J.addView(this.X.getView());
        bc.a aVar2 = (bc.a) M2("TodayViewFragment");
        if (aVar2 != null) {
            aVar2.D0();
        }
    }

    private void y4() {
        if (X0().a("RealTimeLY.Enabled.Android")) {
            ((com.uber.autodispose.t) this.f10905o0.e().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y4.i(this));
            return;
        }
        if (this.f10907q0 == null) {
            this.f10907q0 = new com.coffeemeetsbagel.limelight.dialog.d((d.c) this.S.A0()).b(this.K, Collections.emptyList(), "", "", false, false);
        }
        b6.r.a(this.f10907q0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z3(LikesYouDialogUseCase.a aVar) throws Exception {
        String str;
        int c10 = aVar.c();
        List<String> a10 = aVar.a();
        if (!aVar.b()) {
            return;
        }
        if (aVar.d()) {
            k b10 = new com.coffeemeetsbagel.limelight.dialog.d((d.c) this.S.A0()).b(this.K, a10, getString(R.string.first_like_dialog_title), getString(R.string.first_like_dialog_description), true, true);
            this.f10907q0 = b10;
            b6.r.a(b10);
            U0().b("first_like_dialog");
            return;
        }
        if (c10 > 99) {
            str = getString(R.string.multiple_likes_dialog_title, new Object[]{"99+"});
        } else {
            str = getString(R.string.multiple_likes_dialog_title, new Object[]{Integer.toString(c10)});
        }
        k b11 = new com.coffeemeetsbagel.limelight.dialog.d((d.c) this.S.A0()).b(this.K, a10, str, getString(R.string.multiple_likes_dialog_description), false, true);
        this.f10907q0 = b11;
        b6.r.a(b11);
        this.f10896f0.b("key_last_time_multiple_likes_dialog_shown", DateUtils.getCurrentTimestamp());
    }

    private void z4() {
        this.M.setOnClickListener(new y4.f(this));
    }

    public void B2() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Extra.ROUTE_TO_DISCOVER_FILTERS, true);
        M2("DiscoverFeedFragment").setArguments(bundle);
        X3();
    }

    public void C2(String str) {
        h5.m.i(this, str);
    }

    public void C4() {
        l lVar = this.W;
        if (lVar != null) {
            ((CmbBottomNavView) lVar.l()).C();
        }
    }

    public void D2() {
        b4();
    }

    public void D4() {
        this.L.setVisibility(0);
    }

    public void E2(String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("BUY_BOOST", TextUtils.equals(str, ModelDeeplinkData.VALUE_PAGE_BOOST));
        bundle.putBoolean("GO_TIPS", TextUtils.equals(str, ModelDeeplinkData.VALUE_PAGE_TIPS));
        M2("MeProfileFragment").setArguments(bundle);
        d4();
    }

    public void F2() {
        com.coffeemeetsbagel.like_pass.view.b bVar = this.X;
        if (bVar != null) {
            bVar.setIsEnabled(Boolean.FALSE);
            this.P = false;
        }
    }

    public void G2() {
        lc.c.h(this.f10915x);
    }

    public void G4(String str, ProfileCategory profileCategory) {
        lc.a.d(this, ActivityProfileEdit.Y1(this, str, profileCategory, false), RequestCode.PROFILE_EDIT);
    }

    public void H2() {
        com.coffeemeetsbagel.like_pass.view.b bVar = this.X;
        if (bVar != null) {
            bVar.setIsEnabled(Boolean.TRUE);
            this.P = true;
        }
    }

    public void H4(List<MatchActionType> list, Boolean bool, Long l10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showFABs ");
        sb2.append(Arrays.toString(list.toArray()));
        if (d1().j() == null) {
            fa.a.g("ActivityMain", "", new IllegalStateException("could not update FABs because current user profile is null"));
            return;
        }
        if (!"TodayViewFragment".equals(this.f10916y) || this.J == null) {
            this.J.setVisibility(8);
        } else if (d1().j().isOnHold()) {
            this.J.setVisibility(8);
            this.Q.A();
        } else if (bool.booleanValue() || this.P) {
            this.J.setVisibility(0);
            com.coffeemeetsbagel.like_pass.view.b bVar = this.X;
            if (bVar != null) {
                bVar.a(list, l10);
            }
            H2();
        } else {
            this.J.setVisibility(0);
            F2();
        }
        this.Q.Q();
    }

    public void I() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onRemoteConfigRefreshed(): outageMode=");
        sb2.append(f1().n());
        if (f1().n()) {
            OutageModeActivity.I0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void I4(String str) {
        J4(str, false);
    }

    public String J2() {
        return this.f10916y;
    }

    public a1 K2() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public LeanPlumPaintedDoorDefinitions.PaintedDoor L2(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("ChatListFragment")) {
                return LeanPlumPaintedDoorDefinitions.PaintedDoor.CHAT_LIST;
            }
            if (str.equals("LikesYouFragment")) {
                return LeanPlumPaintedDoorDefinitions.PaintedDoor.LIKES_YOU;
            }
            if (str.equals("DiscoverFeedFragment")) {
                return LeanPlumPaintedDoorDefinitions.PaintedDoor.DISCOVER;
            }
            if (str.equals("TodayViewFragment")) {
                return LeanPlumPaintedDoorDefinitions.PaintedDoor.SUGGESTED;
            }
            if (str.equals("MeProfileFragment")) {
                return LeanPlumPaintedDoorDefinitions.PaintedDoor.PROFILE_ME;
            }
        }
        return LeanPlumPaintedDoorDefinitions.PaintedDoor.UNDEFINED;
    }

    public void M4(boolean z10) {
        if (X0().a("ProfileMigration.Enabled.Android")) {
            lc.a.d(this, new Intent(this, ProfileCompletionHelperActivity.class), 2000);
            return;
        }
        Intent intent = new Intent(this, ActivityLikePassFlow.class);
        intent.putExtra("EXTRA_IS_LIKE_FLOW_FIRST", z10);
        lc.a.d(this, intent, 2000);
        this.Q.e();
    }

    public void N2() {
        this.J.setVisibility(8);
        this.Q.A();
    }

    /* access modifiers changed from: protected */
    public Fragment O0() {
        return null;
    }

    public void P2(boolean z10) {
        this.f10912v0 = z10;
        f5(z10, false);
    }

    public void S4(int i10) {
        sb.a.g(this.G, i10);
    }

    public void T4(String str) {
        sb.a.j(this.G, str);
    }

    public void U2() {
        l lVar = this.W;
        if (lVar != null) {
            ((CmbBottomNavView) lVar.l()).B();
        }
    }

    public void U4(int i10, int i11) {
        sb.a.l(this.G, i10, i11);
    }

    public void V2() {
        this.L.setVisibility(8);
    }

    public void X2() {
        View findViewById = findViewById(R.id.tabLayout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void X3() {
        this.f10902l0.f("Give & Take");
        this.f10902l0.trackEvent("Discover Viewed", new HashMap());
        I4("DiscoverFeedFragment");
        C4();
        D4();
        W2();
        f5(false, true);
        this.f15597h.setDisplayHomeAsUp(false);
        N4(false);
        z2();
        g4();
    }

    public void X4() {
        CmbLinks.Companion.launchTips(this);
    }

    public void Y4() {
        Z4((Long) null);
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public void Z2() {
        this.S.B0(this);
        ((p) this.f10894d0.i0().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y4.e(this));
    }

    public void Z4(Long l10) {
        CmbToolbar cmbToolbar;
        long w22 = w2(l10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startTimerIfNeeded() timestamp=");
        sb2.append(w22);
        if (!(this.U == w22 || this.f15597h == null)) {
            f fVar = this.Y;
            if (fVar != null) {
                fVar.c();
                this.Y.quit();
            }
            f fVar2 = new f(this);
            this.Y = fVar2;
            fVar2.start();
            this.Y.g(w22);
            this.U = w22;
        }
        if ("TodayViewFragment".equals(this.f10916y) && (cmbToolbar = this.f15597h) != null) {
            cmbToolbar.d0();
        }
    }

    public int b1() {
        return R.layout.activity_main;
    }

    public void c5(int i10) {
        x5.b b10 = this.f10891a0.b(R.id.bottom_nav_item_bagels);
        if (b10 == null) {
            return;
        }
        if (i10 <= 0) {
            b10.d((String) null);
            b10.e(false);
            this.f10891a0.d();
        } else if (this.f10901k0.a("SPWV2.Show.Android") || this.f10901k0.a("SuggestedPaywall.Show.Android")) {
            ((com.uber.autodispose.t) this.f10899i0.T().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new o0(this, b10, i10));
        } else {
            b10.d(String.valueOf(i10));
            b10.e(true);
            this.f10891a0.d();
        }
    }

    public void d4() {
        HashMap hashMap = new HashMap();
        hashMap.put("profile_me", String.valueOf(!d1().h()));
        this.f10902l0.trackEvent("Nav Bar - Profile Icon Tapped", hashMap);
        I4("MeProfileFragment");
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            this.f15597h.P();
            this.f15597h.setDisplayHomeAsUp(false);
        } else {
            U2();
            this.f15597h.setDisplayHomeAsUp(true);
        }
        V2();
        W2();
        g4();
    }

    public void e5(int i10) {
        String str;
        x5.b b10 = this.f10891a0.b(R.id.bottom_nav_item_chat);
        if (b10 != null) {
            if (i10 > 0) {
                if (i10 > 99) {
                    str = getApplicationContext().getResources().getQuantityString(R.plurals.many_chats, 99, new Object[]{99});
                } else {
                    str = String.valueOf(i10);
                }
                b10.d(str);
                b10.e(true);
            } else {
                b10.d((String) null);
                b10.e(false);
            }
            this.f10891a0.d();
        }
    }

    public void f4() {
        this.f10902l0.f("Today's Bagel");
        I4("TodayViewFragment");
        this.f15597h.setDisplayHomeAsUp(false);
        f5(this.f10912v0, false);
        N4(true);
        C4();
        this.Q.T();
        if (d1().j() == null || d1().j().isOnHold()) {
            g4();
        } else {
            Y4();
        }
    }

    public void g0() {
        this.U = 0;
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setSubtitle("0");
            j();
        }
        this.f10898h0.d();
        Bakery.w().D().b(new b(), false);
    }

    public void g4() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("quitAndHideTimer() thread=");
        sb2.append(this.Y);
        f fVar = this.Y;
        if (fVar != null) {
            fVar.c();
            this.Y.quit();
            this.Y = null;
        }
        this.U = 0;
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.R();
        }
    }

    public void g5(String str) {
        x5.b b10;
        boolean z10;
        x5.a aVar = this.f10891a0;
        if (aVar != null && (b10 = aVar.b(R.id.bottom_nav_item_limelight)) != null) {
            b10.d(str);
            if (str != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            b10.e(z10);
            this.f10891a0.d();
        }
    }

    public void i5(int i10) {
        x5.b b10;
        x5.a aVar = this.f10891a0;
        if (aVar != null && (b10 = aVar.b(R.id.bottom_nav_item_discover)) != null) {
            String str = null;
            if (this.f10901k0.a("LikesYouHardPaywall.Show.Android") || this.f10901k0.a("LYDF.Milestone4.Show.Android")) {
                if (!S2()) {
                    str = " ";
                }
                b10.d(str);
                b10.e(!S2());
            } else if (i10 > 0) {
                b10.d(String.valueOf(i10));
                b10.e(true);
            } else {
                b10.d((String) null);
                b10.e(false);
            }
            this.f10891a0.d();
        }
    }

    public void j() {
        r7.h hVar = this.f10915x;
        if (hVar != null && !hVar.isShowing() && !isFinishing()) {
            try {
                this.f10915x.show();
            } catch (WindowManager.BadTokenException e10) {
                fa.a.i(e10);
            }
        }
    }

    public void j4() {
        if (this.f10891a0 != null && S0().x()) {
            new b(getResources(), this.f10891a0).execute(new Void[0]);
        }
    }

    public void l0(long j10) {
        String str;
        if (this.f15597h != null) {
            int round = Math.round((float) (j10 / 1000));
            if (round > 0) {
                str = DateUtils.getCountdownTimerFromSeconds(round);
            } else {
                str = getString(R.string.timer_zero);
            }
            if ("TodayViewFragment".equals(this.f10916y)) {
                this.f15597h.setSubtitle(str);
            }
        }
    }

    public boolean l1() {
        if (Bakery.w().M().r("SELF_USER_PROFILE_ID") != null) {
            NetworkProfile j10 = d1().j();
            this.B = j10;
            if (j10 != null && R0().getProfileId() != null) {
                return true;
            }
            fa.a.f("ActivityMain", "Failed to load data in spite of the shared pref manager having a user id. WEIRD. ");
            fa.a.f("ActivityMain", "Current user ID is < 0! logging out in order to re-load user ID.");
            fa.a.i(new Exception("Automatic Logout from handleNoLoggedInId after retry"));
            AnalyticsConstants$Logout analyticsConstants$Logout = AnalyticsConstants$Logout.AUTOMATIC;
            T3(analyticsConstants$Logout, "mProfile = " + this.B + " profileId = " + R0().getProfileId());
            return false;
        }
        fa.a.f("ActivityMain", "The shared pref manager has no user id. All hope is lost.");
        fa.a.f("ActivityMain", "Current user ID is < 0! logging out in order to re-load user ID.");
        fa.a.i(new Exception("Automatic Logout from handleNoLoggedInId"));
        T3(AnalyticsConstants$Logout.AUTOMATIC, "Share pref has no user id");
        return false;
    }

    public void n0(EventType eventType, Bundle bundle) {
        switch (c.f10921b[eventType.ordinal()]) {
            case 1:
                k4();
                m4();
                Q4(new ArrayList(e1().priceCache().i().iterator().next().values()));
                supportInvalidateOptionsMenu();
                return;
            case 2:
                k4();
                return;
            case 3:
                F4("FRAGMENT_INDEX_PHOTOS");
                return;
            case 4:
                if (d1().j() != null) {
                    if (d1().j().isOnHold()) {
                        this.J.setVisibility(8);
                        this.Q.A();
                    }
                    this.B = d1().j();
                    supportInvalidateOptionsMenu();
                    return;
                }
                return;
            case 5:
                j4();
                return;
            case 6:
            case 7:
                m4();
                return;
            case 8:
            case 9:
                d5();
                return;
            case 10:
                this.D = bundle.getBoolean(Extra.SHOULD_SHOW_SHOP_BADGE, false);
                supportInvalidateOptionsMenu();
                return;
            case 11:
                if (X0().a("Rewind.Enabled.Android")) {
                    this.f10912v0 = true;
                    f5(true, false);
                    P4(bundle.getBoolean(Extra.IS_RISING_BAGEL, false), bundle.getString("image_url", ""));
                    return;
                }
                return;
            case 12:
                if (X0().a("Rewind.Enabled.Android")) {
                    this.f10912v0 = false;
                    f5(false, false);
                    return;
                }
                return;
            default:
                super.n0(eventType, bundle);
                return;
        }
    }

    public void o0() {
        if (!CollectionUtils.isEmpty((List) S0().A())) {
            j4();
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        h5.l.h().onActivityResult(i10, i11, intent);
        this.f10913w.b(new c6.a(i10, i11, intent));
        if (i10 != 1003) {
            if (i10 != 2000) {
                if (i10 != 5400) {
                    if (i10 != 6600) {
                        if (i10 != 7002) {
                            if (i10 != 9000) {
                                if (!(i10 == 9279 || i10 == 9281)) {
                                    if (i10 != 9292) {
                                        if (i10 == 435345) {
                                            return;
                                        }
                                        if (i10 != 3000) {
                                            if (i10 == 3001) {
                                                if (i11 == 2) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putBoolean(Extra.WAS_PROFILED_EDITED, true);
                                                    i.c(EventType.PROFILE_SAVED, bundle);
                                                    i.b(EventType.PROFILE_UPDATE);
                                                }
                                                if (i11 == -1 && intent.getBooleanExtra(Extra.FROM_PREFERENCES, false)) {
                                                    z1(R.string.preferences_saved);
                                                    return;
                                                }
                                                return;
                                            } else if (!(i10 == 6500 || i10 == 6501)) {
                                                switch (i10) {
                                                    case 9304:
                                                        break;
                                                    case RequestCode.MATCH_PREFERENCES /*9305*/:
                                                        U4(R.string.likes_you_edit_prefs_snackbar, 11000);
                                                        return;
                                                    case RequestCode.DISPLAY_MATCH /*9306*/:
                                                        if (i11 == 70) {
                                                            S4(R.string.generic_error2);
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("Unknown request code");
                                                        sb2.append(i10);
                                                        return;
                                                }
                                            }
                                        } else if (i11 == 47) {
                                            U3(intent.getBooleanExtra(Extra.IS_ACCOUNT_DELETED, false), AnalyticsConstants$Logout.USER_INITIATED, new String[0]);
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (i11 == 67) {
                                        K4(u9.d.f18027a.a(intent));
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                if (i11 == 50) {
                                    j4();
                                    K4(u9.d.f18027a.a(intent));
                                    return;
                                }
                                return;
                            }
                            z1(R.string.discover_like_referral_redemption);
                            return;
                        } else if (i11 == -1) {
                            this.B = d1().j();
                            return;
                        } else {
                            return;
                        }
                    }
                } else if (i11 == -1) {
                    i.c(EventType.BEAN_TRANSACTION_FOR_FEATURE_UNLOCK_COMPLETE, intent.getExtras());
                    return;
                } else {
                    return;
                }
            } else if (i11 == 704) {
                fa.a.i(new Exception("Automatic Logout from onActivityResult onboarding"));
                T3(AnalyticsConstants$Logout.AUTOMATIC, "No Profile from onboarding");
                return;
            } else {
                i.b(EventType.PROFILE_SAVED);
                if (i11 == -1) {
                    Intent intent2 = new Intent(this, BagelProfileComponentActivity.class);
                    intent2.putExtra("source", "my profile");
                    intent2.putExtra("profile", Bakery.w().G().j());
                    startActivity(intent2);
                    return;
                }
                return;
            }
        }
        c1().i(this, i10, i11, intent);
    }

    public void onBackPressed() {
        Fragment j02 = getSupportFragmentManager().j0(this.f10916y);
        if ((j02 instanceof b6.e) && ((b6.e) j02).B0()) {
            return;
        }
        if ("ChatListFragment".equals(this.f10916y) && ((g0) M2("ChatListFragment")).V1()) {
            return;
        }
        if ("MeProfileFragment".equals(this.f10916y) && !this.f10901k0.a("ProfileBottomNav.Enabled.Android")) {
            this.f10892b0.b(this.f10911u0.get(this.f10917z));
        } else if ("TodayViewFragment".equals(this.f10916y)) {
            finishAffinity();
        } else if (!k1()) {
            f4();
            this.f10892b0.b(Integer.valueOf(R.id.bottom_nav_item_bagels));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        a1 a1Var = (a1) supportFragmentManager.j0("MainDependencyFragment");
        this.S = a1Var;
        if (a1Var == null) {
            this.S = new a1();
            supportFragmentManager.p().e(this.S, "MainDependencyFragment").i();
        }
        this.K = (CoordinatorLayout) findViewById(R.id.main_coordinator_layout);
        this.G = findViewById(R.id.snackbar_container);
        this.M = (ImageView) findViewById(R.id.remote_action_icon);
        this.N = new z8.b(P0());
        this.O = new k9.b(X0());
        this.J = (LinearLayout) findViewById(R.id.fab_container);
        View findViewById = findViewById(R.id.bottom_gradient);
        this.L = findViewById;
        findViewById.setVisibility(0);
        z4();
        if (X0().a("ProfileBottomNav.Enabled.Android")) {
            f5(false, false);
        } else {
            b5.e.k(this, d1(), this.f15597h, false);
        }
        d5();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.C = tabLayout;
        tabLayout.setVisibility(8);
        i8.b bVar = new i8.b(Q0(), S0(), P0(), h1.g(), h1());
        this.Q = bVar;
        bVar.start();
        A2(supportFragmentManager, bundle);
        this.f10915x = new r7.h(this);
        S0().r(this);
        EventType eventType = EventType.SYNC_COMPLETE;
        i.a(this, eventType, EventType.GO_TO_EDIT_PHOTOS, EventType.ACCOUNT_ON_HOLD_STATE_CHANGED, EventType.CONNECTION_DETAILS_UPDATED, EventType.CONNECTION_ADDED, EventType.PROFILE_SAVED, EventType.PROFILE_UPDATE, EventType.BEANS_UPDATED, EventType.UPDATE_SHOP_BADGE, EventType.FILTERS_STATE_CHANGED, eventType, EventType.SUGGESTED_BAGEL_PASSED, EventType.SUGGESTED_BAGEL_LIKED);
        g1().b(this);
        Y2();
        this.T = (cc.a) Bakery.w().K().c(cc.a.class);
        R4();
        y2(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        i.d(this, new EventType[0]);
        S0().F(this);
        g1().a(this);
        this.Q.stop();
        l lVar = this.W;
        if (lVar != null) {
            b6.r.b(lVar);
        }
        this.W = null;
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onNewIntent(");
        sb2.append(intent);
        sb2.append(")");
        setIntent(intent);
        y2(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        bc.a aVar = (bc.a) M2("TodayViewFragment");
        if (aVar != null) {
            aVar.N0();
        }
        lc.c.i(this.f10915x);
        Bakery.w().G().a();
        g4();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onResume: ");
        sb2.append(this.E);
        if (this.E != null) {
            h4();
            this.E = null;
        } else {
            i4();
        }
        Bakery.w().z().i("Activity Main Resumed");
        AppEventsLogger.activateApp(getApplication());
        if (R0().getProfileId() == null) {
            l1();
            return;
        }
        ((p) this.f10893c0.a().m0(dk.a.c()).a0(sj.a.a()).s().g(com.uber.autodispose.a.a(this))).c(new y4.a(this));
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0) {
            GooglePlayServicesUtil.getErrorDialog(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this), this, 0, new y4.l()).show();
        }
        String stringExtra = intent.getStringExtra(Extra.MESSAGE_TO_SHOW);
        if (!TextUtils.isEmpty(stringExtra)) {
            T4(stringExtra);
        }
        intent.removeExtra(Extra.MESSAGE_TO_SHOW);
        j4();
        if (!TextUtils.equals(this.f10916y, "MeProfileFragment")) {
            m4();
        }
        Bakery.w().G().a();
        ((p) e1().priceCache().g(com.uber.autodispose.a.a(this))).c(new y4.w(this));
        x4();
        g1.b("user_landed", d1().j());
        g1.d("user_landed");
        g1.b("activity_main_launch", d1().j());
        g1.d("activity_main_launch");
        W4();
        Y4();
        SubscriptionRepository subscriptionRepository = this.f10899i0;
        if (subscriptionRepository != null) {
            ((com.uber.autodispose.t) subscriptionRepository.T().L().K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h0(this), new p0());
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("KEY_PROFILE", this.B);
        bundle.putString("KEY_FRAGMENT_TAG", this.f10916y);
        bundle.putInt("KEY_SELECTED_TAB_ID", ((Integer) this.f10893c0.a().h().f(Integer.valueOf(R.id.bottom_nav_item_bagels))).intValue());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        for (String next : I2()) {
            Fragment M2 = M2(next);
            if (n1(M2)) {
                supportFragmentManager.i1(bundle, next, M2);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        l lVar = this.W;
        if (lVar == null) {
            u4();
        } else if (((CmbBottomNavView) lVar.l()).getParent() == null) {
            C4();
            V2();
        }
        if (!TextUtils.isEmpty(this.f10916y)) {
            J4(this.f10916y, true);
        }
        this.Q.p();
        A4();
        y4();
        w4();
        I();
        f1().e(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        w wVar = this.f10909s0;
        if (wVar != null) {
            b6.r.b(wVar);
            this.f10909s0 = null;
        }
        k kVar = this.f10907q0;
        if (kVar != null) {
            b6.r.b(kVar);
            this.f10907q0 = null;
        }
        f1().k(this);
    }

    public c6.b t2() {
        return this.f10913w;
    }

    public void u() {
        supportInvalidateOptionsMenu();
    }

    public boolean x1() {
        return false;
    }

    public void z1(int i10) {
        sb.a.i(this.G, i10);
    }

    public void z2() {
        x5.a aVar;
        x5.b b10;
        this.f10896f0.a().edit().putLong("LAST_SEEN_DISCOVER", System.currentTimeMillis()).apply();
        if ((this.f10901k0.a("LikesYouHardPaywall.Show.Android") || this.f10901k0.a("LYDF.Milestone4.Show.Android")) && (aVar = this.f10891a0) != null && (b10 = aVar.b(R.id.bottom_nav_item_discover)) != null) {
            if (this.f10901k0.a("LikesYouHardPaywall.Show.Android") || this.f10901k0.a("LYDF.Milestone4.Show.Android")) {
                b10.d((String) null);
                b10.e(false);
            }
            this.f10891a0.d();
        }
    }
}

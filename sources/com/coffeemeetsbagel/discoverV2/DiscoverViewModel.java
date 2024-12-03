package com.coffeemeetsbagel.discoverV2;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.Model;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import fa.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import v7.a;
import v7.d;

public final class DiscoverViewModel extends f0 {
    /* access modifiers changed from: private */
    public final t<ProgressDialogViewState> A;
    /* access modifiers changed from: private */
    public final r<UpsellViewState> B;
    /* access modifiers changed from: private */
    public final t<FilterStateViewState> C;
    /* access modifiers changed from: private */
    public final t<Triple<ActionState, GiveTakeBase, PurchaseType>> D;
    private final t<List<GiveTakeBase>> E;
    /* access modifiers changed from: private */
    public final t<Triple<DialogViewState, GiveTake, PurchaseType>> F;
    /* access modifiers changed from: private */
    public final t<Pair<GiveTakeBase, Bagel>> G;
    /* access modifiers changed from: private */
    public final t<Boolean> H;
    /* access modifiers changed from: private */
    public final t<Integer> I;
    private final LiveData<ProgressDialogViewState> J;
    private final LiveData<FilterStateViewState> K;
    private final r<UpsellViewState> L;
    private final LiveData<Triple<ActionState, GiveTakeBase, PurchaseType>> M;
    private final LiveData<List<GiveTakeBase>> N;
    private final LiveData<Triple<DialogViewState, GiveTake, PurchaseType>> O;
    private final LiveData<Integer> P;
    private final LiveData<Pair<GiveTakeBase, Bagel>> Q;
    private final t<Integer> R;
    private final b S;
    private tj.b T;

    /* renamed from: d  reason: collision with root package name */
    private PurchaseManager f12212d;

    /* renamed from: e  reason: collision with root package name */
    private ProfileManager f12213e;

    /* renamed from: f  reason: collision with root package name */
    private com.coffeemeetsbagel.store.alc.d f12214f;

    /* renamed from: g  reason: collision with root package name */
    private final wb.c f12215g;

    /* renamed from: h  reason: collision with root package name */
    private v7.d f12216h;

    /* renamed from: i  reason: collision with root package name */
    private a6.a f12217i;

    /* renamed from: j  reason: collision with root package name */
    private final UserRepository f12218j;

    /* renamed from: k  reason: collision with root package name */
    private b7.c f12219k;

    /* renamed from: l  reason: collision with root package name */
    private z f12220l;

    /* renamed from: m  reason: collision with root package name */
    private a7.a f12221m;

    /* renamed from: n  reason: collision with root package name */
    private t7.a f12222n;

    /* renamed from: o  reason: collision with root package name */
    private ProfileRepositoryV2 f12223o;

    /* renamed from: p  reason: collision with root package name */
    private com.coffeemeetsbagel.experiment.r f12224p;

    /* renamed from: q  reason: collision with root package name */
    private m1 f12225q;

    /* renamed from: r  reason: collision with root package name */
    private l8.h f12226r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final String f12227s = "DiscoverFeedViewModel";
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final HashSet<String> f12228t = new HashSet<>();

    /* renamed from: u  reason: collision with root package name */
    private GiveTake f12229u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public AutoPurchase f12230v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Price f12231w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Price f12232x;

    /* renamed from: y  reason: collision with root package name */
    private String f12233y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public final t<Boolean> f12234z;

    public enum ActionState {
        LIKED,
        CONNECTED,
        FLOWER_SENT,
        OUT_OF_BEANS,
        LIST_CHANGED
    }

    public enum DialogViewState {
        PREMIUM,
        UNPAUSE,
        GONE
    }

    public enum FilterStateViewState {
        ON,
        OFF
    }

    public enum ProgressDialogViewState {
        GONE,
        VISIBLE
    }

    public enum UpsellViewState {
        ENABLED_FREE_TRIAL,
        ENABLED,
        DISABLED,
        CLOSED_BY_USER
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12256a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.store.alc.PurchaseType[] r0 = com.coffeemeetsbagel.store.alc.PurchaseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.store.alc.PurchaseType r1 = com.coffeemeetsbagel.store.alc.PurchaseType.PAID_LIKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.store.alc.PurchaseType r1 = com.coffeemeetsbagel.store.alc.PurchaseType.DISCOVER_LIKES     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f12256a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverViewModel.a.<clinit>():void");
        }
    }

    public static final class b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12257a;

        b(DiscoverViewModel discoverViewModel) {
            this.f12257a = discoverViewModel;
        }

        public void I0() {
            fa.a.f40771d.a(this.f12257a.f12227s, "onFlowerCountUpdated()");
            Price price = this.f12257a.b0().getPrice(PurchaseType.PAID_LIKE);
            if (price != null) {
                this.f12257a.f12232x = price;
                this.f12257a.I.m(Integer.valueOf(price.getFreeItemCount()));
            }
        }

        public void M0() {
            fa.a.f40771d.a(this.f12257a.f12227s, "onGiveTakeUpdated()");
            DiscoverViewModel.y0(this.f12257a, ActionState.LIST_CHANGED, (GiveTakeBase) null, (PurchaseType) null, 6, (Object) null);
        }

        public void h0() {
            boolean z10;
            List<GiveTakeBase> list;
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f12257a.f12227s;
            Object f10 = this.f12257a.C.f();
            aVar.a(m10, "onGiveTakeItemsCached(): filterState " + f10);
            if (this.f12257a.C.f() == FilterStateViewState.ON) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                list = this.f12257a.P().s();
            } else {
                list = this.f12257a.P().p();
            }
            if (!z10) {
                NetworkProfile j10 = this.f12257a.Y().j();
                j.d(j10);
                if (j10.isOnHold() && list.isEmpty()) {
                    this.f12257a.h0();
                }
            }
            DiscoverViewModel discoverViewModel = this.f12257a;
            j.f(list, "currentGiveTakes");
            discoverViewModel.E0(list);
            this.f12257a.H0(ProgressDialogViewState.GONE);
        }

        public void o1() {
            this.f12257a.H0(ProgressDialogViewState.GONE);
        }
    }

    public static final class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTakeBase f12259b;

        c(DiscoverViewModel discoverViewModel, GiveTakeBase giveTakeBase) {
            this.f12258a = discoverViewModel;
            this.f12259b = giveTakeBase;
        }

        public void a(String str, int i10) {
            j.g(str, "errorMessage");
            fa.a.f40771d.b(this.f12258a.f12227s, "Could not mark #givetake as shown!");
            this.f12258a.f12228t.remove(((GiveTake) this.f12259b).getProfileId());
        }

        public void b(ResponseGeneric responseGeneric) {
            String str;
            j.g(responseGeneric, "response");
            if (this.f12258a.P().m(this.f12259b)) {
                str = "infinite scroll";
            } else {
                str = "givetake";
            }
            DiscoverViewModel discoverViewModel = this.f12258a;
            String profileId = ((GiveTake) this.f12259b).getProfileId();
            j.f(profileId, "item.profileId");
            discoverViewModel.O0(str, profileId);
        }
    }

    public static final class d implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTakeBase f12261b;

        d(DiscoverViewModel discoverViewModel, GiveTakeBase giveTakeBase) {
            this.f12260a = discoverViewModel;
            this.f12261b = giveTakeBase;
        }

        public void a(String str, int i10) {
            j.g(str, "errorMessage");
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f12260a.f12227s;
            aVar.b(m10, "Could not mark rising #givetake as shown: " + str);
            this.f12260a.f12228t.remove(((RisingGiveTake) this.f12261b).getProfileId());
        }

        public void b(ResponseGeneric responseGeneric) {
            j.g(responseGeneric, "response");
            DiscoverViewModel discoverViewModel = this.f12260a;
            String profileId = ((RisingGiveTake) this.f12261b).getProfileId();
            j.f(profileId, "item.profileId");
            discoverViewModel.O0("rising give take", profileId);
        }
    }

    public static final class e implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PurchaseType f12263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12264b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GiveTake f12265c;

        e(PurchaseType purchaseType, DiscoverViewModel discoverViewModel, GiveTake giveTake) {
            this.f12263a = purchaseType;
            this.f12264b = discoverViewModel;
            this.f12265c = giveTake;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            j.g(cmbErrorCode, "cmbErrorCode");
            this.f12264b.J0(R.string.error_reactivation);
            this.f12264b.H0(ProgressDialogViewState.GONE);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            j.g(successStatus, "status1");
            PurchaseType purchaseType = this.f12263a;
            if (purchaseType == PurchaseType.PAID_LIKE) {
                this.f12264b.o0(this.f12265c, false);
            } else if (purchaseType == PurchaseType.DISCOVER_LIKES) {
                this.f12264b.v0(this.f12265c);
            }
            this.f12264b.H0(ProgressDialogViewState.GONE);
        }
    }

    static final class f implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f12266a;

        f(Function1 function1) {
            j.g(function1, "function");
            this.f12266a = function1;
        }

        public final gk.c<?> a() {
            return this.f12266a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f12266a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof kotlin.jvm.internal.f)) {
                return false;
            }
            return j.b(a(), ((kotlin.jvm.internal.f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class g implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel$sendLike$callbackSyncAfterConnect$1 f12268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f12269c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RisingGiveTake f12270d;

        g(DiscoverViewModel discoverViewModel, DiscoverViewModel$sendLike$callbackSyncAfterConnect$1 discoverViewModel$sendLike$callbackSyncAfterConnect$1, String str, RisingGiveTake risingGiveTake) {
            this.f12267a = discoverViewModel;
            this.f12268b = discoverViewModel$sendLike$callbackSyncAfterConnect$1;
            this.f12269c = str;
            this.f12270d = risingGiveTake;
        }

        public void a(String str, int i10) {
            j.g(str, "errorMessage");
            this.f12267a.J0(R.string.error_sending_discover_like);
            this.f12267a.H0(ProgressDialogViewState.GONE);
        }

        public void b(ResponseGeneric responseGeneric) {
            j.g(responseGeneric, "response");
            this.f12267a.T().b(this.f12268b, false);
            DiscoverViewModel discoverViewModel = this.f12267a;
            String str = this.f12269c;
            j.f(str, "profileId");
            discoverViewModel.Q0("discover_rising_give_take", "like", "connected", str, "liked");
            this.f12267a.H0(ProgressDialogViewState.GONE);
            DiscoverViewModel.y0(this.f12267a, ActionState.CONNECTED, this.f12270d, (PurchaseType) null, 4, (Object) null);
        }
    }

    public static final class h implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTake f12272b;

        h(DiscoverViewModel discoverViewModel, GiveTake giveTake) {
            this.f12271a = discoverViewModel;
            this.f12272b = giveTake;
        }

        public void onFailure() {
            fa.a.f40771d.b(this.f12271a.f12227s, "Unable to refresh prices");
        }

        public void onSuccess() {
            DiscoverViewModel discoverViewModel = this.f12271a;
            discoverViewModel.f12231w = discoverViewModel.b0().getPrice(PurchaseType.DISCOVER_LIKES);
            DiscoverViewModel discoverViewModel2 = this.f12271a;
            discoverViewModel2.f12232x = discoverViewModel2.b0().getPrice(PurchaseType.PAID_LIKE);
            this.f12271a.o0(this.f12272b, false);
            this.f12271a.f12230v = null;
        }
    }

    public static final class i implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12273a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f12274b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GiveTake f12275c;

        i(DiscoverViewModel discoverViewModel, long j10, GiveTake giveTake) {
            this.f12273a = discoverViewModel;
            this.f12274b = j10;
            this.f12275c = giveTake;
        }

        public void a(String str) {
            j.g(str, "errorMessage");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f12273a.L().g()) {
                this.f12273a.L().a("take purchase", currentTimeMillis - this.f12274b, StreamManagement.Failed.ELEMENT);
            }
            if (j.b(str, "NO_MORE_FREE_TAKES")) {
                this.f12273a.J0(R.string.error_free_discover_like_expired);
                return;
            }
            this.f12273a.J0(R.string.error_sending_discover_like);
            this.f12273a.H0(ProgressDialogViewState.GONE);
        }

        public void onSuccess() {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f12273a.L().g()) {
                this.f12273a.L().a("take purchase", currentTimeMillis - this.f12274b, "succeeded");
            }
            if (this.f12273a.P().m(this.f12275c)) {
                str = "discover_infinite_scroll";
            } else if (this.f12273a.P().l(this.f12275c)) {
                str = "discover_search_item";
            } else {
                str = ModelDeeplinkData.VALUE_PAGE_DISCOVER;
            }
            String str2 = str;
            DiscoverViewModel discoverViewModel = this.f12273a;
            String profileId = this.f12275c.getProfileId();
            j.f(profileId, "giveTake.profileId");
            discoverViewModel.Q0(str2, "like", "not connected", profileId, "none");
            this.f12273a.H0(ProgressDialogViewState.GONE);
            this.f12273a.J0(R.string.discover_like_sent);
            DiscoverViewModel.y0(this.f12273a, ActionState.LIKED, this.f12275c, (PurchaseType) null, 4, (Object) null);
        }
    }

    public DiscoverViewModel(PurchaseManager purchaseManager, ProfileManager profileManager, com.coffeemeetsbagel.store.alc.d dVar, wb.c cVar, v7.d dVar2, a6.a aVar, UserRepository userRepository, b7.c cVar2, z zVar, a7.a aVar2, t7.a aVar3, ProfileRepositoryV2 profileRepositoryV2, com.coffeemeetsbagel.experiment.r rVar, m1 m1Var, l8.h hVar) {
        PurchaseManager purchaseManager2 = purchaseManager;
        ProfileManager profileManager2 = profileManager;
        com.coffeemeetsbagel.store.alc.d dVar3 = dVar;
        wb.c cVar3 = cVar;
        v7.d dVar4 = dVar2;
        a6.a aVar4 = aVar;
        UserRepository userRepository2 = userRepository;
        b7.c cVar4 = cVar2;
        z zVar2 = zVar;
        a7.a aVar5 = aVar2;
        t7.a aVar6 = aVar3;
        ProfileRepositoryV2 profileRepositoryV22 = profileRepositoryV2;
        com.coffeemeetsbagel.experiment.r rVar2 = rVar;
        m1 m1Var2 = m1Var;
        l8.h hVar2 = hVar;
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
        this.f12212d = purchaseManager2;
        this.f12213e = profileManager2;
        this.f12214f = dVar3;
        this.f12215g = cVar3;
        this.f12216h = dVar4;
        this.f12217i = aVar4;
        this.f12218j = userRepository2;
        this.f12219k = cVar4;
        this.f12220l = zVar2;
        this.f12221m = aVar5;
        this.f12222n = aVar6;
        this.f12223o = profileRepositoryV22;
        this.f12224p = rVar2;
        this.f12225q = m1Var2;
        this.f12226r = hVar2;
        Boolean bool = Boolean.FALSE;
        this.f12234z = new t<>(bool);
        t<ProgressDialogViewState> tVar = new t<>(ProgressDialogViewState.GONE);
        this.A = tVar;
        r<UpsellViewState> rVar3 = new r<>();
        this.B = rVar3;
        t<FilterStateViewState> tVar2 = new t<>();
        this.C = tVar2;
        t<Triple<ActionState, GiveTakeBase, PurchaseType>> tVar3 = new t<>();
        this.D = tVar3;
        t<List<GiveTakeBase>> tVar4 = new t<>();
        this.E = tVar4;
        t<Triple<DialogViewState, GiveTake, PurchaseType>> tVar5 = new t<>();
        this.F = tVar5;
        t<Pair<GiveTakeBase, Bagel>> tVar6 = new t<>();
        this.G = tVar6;
        this.H = new t<>(bool);
        t<Integer> tVar7 = new t<>(0);
        this.I = tVar7;
        this.J = tVar;
        this.K = tVar2;
        this.L = rVar3;
        this.M = tVar3;
        this.N = tVar4;
        this.O = tVar5;
        this.P = tVar7;
        this.Q = tVar6;
        this.R = new t<>(-1);
        A0(this, DialogViewState.GONE, (GiveTake) null, (PurchaseType) null, 6, (Object) null);
        this.S = new b(this);
    }

    static /* synthetic */ void A0(DiscoverViewModel discoverViewModel, DialogViewState dialogViewState, GiveTake giveTake, PurchaseType purchaseType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            giveTake = null;
        }
        if ((i10 & 4) != 0) {
            purchaseType = null;
        }
        discoverViewModel.z0(dialogViewState, giveTake, purchaseType);
    }

    /* access modifiers changed from: private */
    public final void B0(boolean z10) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setEligibleTrialState$1(this, z10, (kotlin.coroutines.c<? super DiscoverViewModel$setEligibleTrialState$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void C0(FilterStateViewState filterStateViewState) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setFilterState$1(this, filterStateViewState, (kotlin.coroutines.c<? super DiscoverViewModel$setFilterState$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void D0(int i10) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setFlowerCount$1(this, i10, (kotlin.coroutines.c<? super DiscoverViewModel$setFlowerCount$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void E0(List<? extends GiveTakeBase> list) {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12227s;
        int size = list.size();
        aVar.a(str, "setGiveTakes: " + size);
        this.E.m(list);
    }

    /* access modifiers changed from: private */
    public final void F0(boolean z10) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setHasSubscription$1(this, z10, (kotlin.coroutines.c<? super DiscoverViewModel$setHasSubscription$1>) null), 3, (Object) null);
    }

    private final void K0(GiveTake giveTake, PurchaseType purchaseType) {
        if (g0()) {
            x0(ActionState.OUT_OF_BEANS, giveTake, purchaseType);
        } else {
            z0(DialogViewState.PREMIUM, giveTake, purchaseType);
        }
    }

    /* access modifiers changed from: private */
    public final void L0() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12227s;
        GiveTake giveTake = this.f12229u;
        aVar.a(str, "subscriptionPurchased(): autoPurchaseGiveTake=" + giveTake);
        y0(this, ActionState.LIST_CHANGED, (GiveTakeBase) null, (PurchaseType) null, 6, (Object) null);
        GiveTake giveTake2 = this.f12229u;
        if (giveTake2 != null) {
            j.e(giveTake2, "null cannot be cast to non-null type com.coffeemeetsbagel.models.GiveTake");
            this.f12229u = null;
            AutoPurchase autoPurchase = this.f12230v;
            if (autoPurchase != null) {
                j.d(autoPurchase);
                int i10 = a.f12256a[autoPurchase.getPurchaseType().ordinal()];
                if (i10 == 1) {
                    this.f12212d.refreshPricesFromApi(new h(this, giveTake2));
                } else if (i10 == 2) {
                    M0(giveTake2);
                    this.f12230v = null;
                }
            }
        }
    }

    private final void M0(GiveTake giveTake) {
        H0(ProgressDialogViewState.VISIBLE);
        this.f12216h.h(this.f12231w, giveTake, new i(this, System.currentTimeMillis(), giveTake));
    }

    /* access modifiers changed from: private */
    public final void N0(String str, boolean z10, long j10) {
        String str2;
        if (z10) {
            str2 = "succeeded";
        } else {
            str2 = StreamManagement.Failed.ELEMENT;
        }
        if (this.f12219k.g()) {
            this.f12219k.a("take purchase", j10, str2);
        }
        PurchaseType purchaseType = PurchaseType.PAID_LIKE;
        this.f12221m.trackEvent(AFInAppEventType.SPENT_CREDIT, h0.l(gk.h.a(AFInAppEventParameterName.CONTENT_ID, purchaseType.a()), gk.h.a(AFInAppEventParameterName.PRICE, str)));
        this.f12221m.trackEvent("Purchased Item", h0.l(gk.h.a("item", purchaseType.a()), gk.h.a("beans", str), gk.h.a(FirebaseAnalytics.Param.QUANTITY, AppEventsConstants.EVENT_PARAM_VALUE_YES), gk.h.a(MamElements.MamResultExtension.ELEMENT, str2)));
    }

    /* access modifiers changed from: private */
    public final void O0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("bagel_profile_id", str2);
        this.f12221m.trackEvent("Discover Card Seen", hashMap);
    }

    /* access modifiers changed from: private */
    public final void Q0(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (j.b(str4, this.f12233y)) {
            this.f12233y = null;
            str6 = "discover detail";
        } else {
            str6 = str;
        }
        z zVar = this.f12220l;
        j.d(zVar);
        zVar.b(str6, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("is_subscriber", String.valueOf(g0()));
        hashMap.put("action", str2);
        hashMap.put("source", str);
        hashMap.put("connection state", str3);
        hashMap.put("bagel_profile_id", str4);
        hashMap.put("pair_action", str5);
        this.f12221m.j("Bagel Action", hashMap);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState e0() {
        /*
            r6 = this;
            fa.a$a r0 = fa.a.f40771d
            java.lang.String r1 = r6.f12227s
            java.lang.String r2 = "getUpsellState()"
            r0.a(r1, r2)
            androidx.lifecycle.r<com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState> r0 = r6.B
            java.lang.Object r0 = r0.f()
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r1 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.CLOSED_BY_USER
            if (r0 != r1) goto L_0x0014
            return r1
        L_0x0014:
            com.coffeemeetsbagel.experiment.r r0 = r6.f12224p
            java.lang.String r1 = "OnePaidLike.Enabled.Android"
            boolean r0 = r0.a(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.coffeemeetsbagel.models.Price r0 = r6.f12232x
            if (r0 == 0) goto L_0x0031
            int r0 = r0.getFreeItemCount()
            goto L_0x0032
        L_0x0028:
            com.coffeemeetsbagel.models.Price r0 = r6.f12231w
            if (r0 == 0) goto L_0x0031
            int r0 = r0.getFreeItemCount()
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            androidx.lifecycle.t<com.coffeemeetsbagel.discoverV2.DiscoverViewModel$FilterStateViewState> r2 = r6.C
            java.lang.Object r2 = r2.f()
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$FilterStateViewState r3 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.FilterStateViewState.ON
            r4 = 1
            if (r2 != r3) goto L_0x003f
            r2 = r4
            goto L_0x0040
        L_0x003f:
            r2 = r1
        L_0x0040:
            androidx.lifecycle.t<java.util.List<com.coffeemeetsbagel.models.interfaces.GiveTakeBase>> r3 = r6.E
            java.lang.Object r3 = r3.f()
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x004f
            boolean r3 = r3.isEmpty()
            goto L_0x0050
        L_0x004f:
            r3 = r4
        L_0x0050:
            boolean r5 = r6.g0()
            if (r5 != 0) goto L_0x005d
            if (r2 != 0) goto L_0x005d
            if (r0 > 0) goto L_0x005d
            if (r3 != 0) goto L_0x005d
            r1 = r4
        L_0x005d:
            if (r1 == 0) goto L_0x0073
            androidx.lifecycle.t<java.lang.Boolean> r0 = r6.H
            java.lang.Object r0 = r0.f()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.j.b(r0, r1)
            if (r0 == 0) goto L_0x0070
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.ENABLED_FREE_TRIAL
            goto L_0x0075
        L_0x0070:
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.ENABLED
            goto L_0x0075
        L_0x0073:
            com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState r0 = com.coffeemeetsbagel.discoverV2.DiscoverViewModel.UpsellViewState.DISABLED
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.discoverV2.DiscoverViewModel.e0():com.coffeemeetsbagel.discoverV2.DiscoverViewModel$UpsellViewState");
    }

    private final void j0(boolean z10) {
        if (z10) {
            this.B.p(this.H, new f(new DiscoverViewModel$observeUpsellConditions$1(this)));
            this.B.p(this.f12234z, new f(new DiscoverViewModel$observeUpsellConditions$2(this)));
            this.B.p(this.C, new f(new DiscoverViewModel$observeUpsellConditions$3(this)));
            this.B.p(this.E, new f(new DiscoverViewModel$observeUpsellConditions$4(this)));
            return;
        }
        this.B.q(this.H);
        this.B.q(this.f12234z);
        this.B.q(this.C);
        this.B.q(this.E);
    }

    @SuppressLint({"CheckResult"})
    private final void p0(int i10, GiveTake giveTake, boolean z10) {
        String str;
        fa.a.f40771d.a(this.f12227s, "sendFlowers: " + giveTake.getProfile().getLocation() + " - " + giveTake.getId());
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        if (this.f12216h.c()) {
            str = giveTake.getId();
        } else {
            str = null;
        }
        if (!this.f12216h.c()) {
            str2 = giveTake.getId();
        }
        this.f12214f.a("PaidLike", i10, 1, str2, str, PurchaseRepository.PurchaseRequestSource.DISCOVER).q(new e(new DiscoverViewModel$sendFlowers$1(this))).r(new f(new DiscoverViewModel$sendFlowers$2(this))).s(new g(this)).E(sj.a.a()).b(new h(new DiscoverViewModel$sendFlowers$4(currentTimeMillis, z10, this, giveTake, i10)), new i(new DiscoverViewModel$sendFlowers$5(currentTimeMillis, this, i10)));
    }

    /* access modifiers changed from: private */
    public static final void q0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void s0(DiscoverViewModel discoverViewModel) {
        j.g(discoverViewModel, "this$0");
        discoverViewModel.H0(ProgressDialogViewState.GONE);
    }

    /* access modifiers changed from: private */
    public static final void t0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u0(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void x0(ActionState actionState, GiveTakeBase giveTakeBase, PurchaseType purchaseType) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setActionState$1(this, actionState, giveTakeBase, purchaseType, (kotlin.coroutines.c<? super DiscoverViewModel$setActionState$1>) null), 3, (Object) null);
    }

    static /* synthetic */ void y0(DiscoverViewModel discoverViewModel, ActionState actionState, GiveTakeBase giveTakeBase, PurchaseType purchaseType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            giveTakeBase = null;
        }
        if ((i10 & 4) != 0) {
            purchaseType = null;
        }
        discoverViewModel.x0(actionState, giveTakeBase, purchaseType);
    }

    private final void z0(DialogViewState dialogViewState, GiveTake giveTake, PurchaseType purchaseType) {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setDialogState$1(this, dialogViewState, giveTake, purchaseType, (kotlin.coroutines.c<? super DiscoverViewModel$setDialogState$1>) null), 3, (Object) null);
    }

    public final void G0(String str) {
        this.f12233y = str;
    }

    public final void H0(ProgressDialogViewState progressDialogViewState) {
        j.g(progressDialogViewState, "state");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12227s;
        aVar.a(str, "setProgressState: " + progressDialogViewState);
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setProgressState$1(this, progressDialogViewState, (kotlin.coroutines.c<? super DiscoverViewModel$setProgressState$1>) null), 3, (Object) null);
    }

    public final void I0() {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new DiscoverViewModel$setUpsellClosed$1(this, (kotlin.coroutines.c<? super DiscoverViewModel$setUpsellClosed$1>) null), 3, (Object) null);
        j0(false);
    }

    public final void J() {
        fa.a.f40771d.a(this.f12227s, "didBecomeActive()");
        j0(true);
        s1 unused = j.d(g0.a(this), x0.b(), (CoroutineStart) null, new DiscoverViewModel$didBecomeActive$1(this, (kotlin.coroutines.c<? super DiscoverViewModel$didBecomeActive$1>) null), 2, (Object) null);
        this.f12216h.i(this.S);
        if (this.N.f() != null) {
            List<GiveTakeBase> f10 = this.N.f();
            j.d(f10);
            if (!f10.isEmpty()) {
                return;
            }
        }
        this.f12216h.e();
    }

    public final void J0(int i10) {
        this.R.m(Integer.valueOf(i10));
    }

    public final LiveData<Triple<ActionState, GiveTakeBase, PurchaseType>> K() {
        return this.M;
    }

    public final b7.c L() {
        return this.f12219k;
    }

    public final LiveData<Pair<GiveTakeBase, Bagel>> M() {
        return this.Q;
    }

    public final t7.a N() {
        return this.f12222n;
    }

    public final Price O() {
        return this.f12231w;
    }

    public final v7.d P() {
        return this.f12216h;
    }

    public final void P0(Price price, boolean z10) {
        String str;
        j.g(price, FirebaseAnalytics.Param.PRICE);
        HashMap hashMap = new HashMap();
        if (!j.b(price.getName(), "PaidLike")) {
            str = "profile take";
        } else if (z10) {
            str = "discover_profile_detail_paidlike";
        } else {
            str = "discover_paidlike";
        }
        hashMap.put("source", str);
        hashMap.put("Destination Flow", "Bean Shop Flow");
        this.f12221m.trackEvent("Not Enough Beans Viewed", hashMap);
    }

    public final LiveData<FilterStateViewState> Q() {
        return this.K;
    }

    public final wb.c R() {
        return this.f12215g;
    }

    public final void R0() {
        fa.a.f40771d.a(this.f12227s, "willResignActive()");
        tj.b bVar = this.T;
        if (bVar != null) {
            bVar.dispose();
        }
        this.T = null;
        j0(false);
        this.f12216h.t(this.S);
        this.G.m(null);
        this.F.m(null);
        this.R.m(-1);
        this.D.m(null);
    }

    public final LiveData<List<GiveTakeBase>> S() {
        return this.N;
    }

    public final m1 T() {
        return this.f12225q;
    }

    public final l8.h U() {
        return this.f12226r;
    }

    public final LiveData<Integer> V() {
        return this.P;
    }

    public final Price W() {
        return this.f12232x;
    }

    public final LiveData<Triple<DialogViewState, GiveTake, PurchaseType>> X() {
        return this.O;
    }

    public final ProfileManager Y() {
        return this.f12213e;
    }

    public final ProfileRepositoryV2 Z() {
        return this.f12223o;
    }

    public final LiveData<ProgressDialogViewState> a0() {
        return this.J;
    }

    public final PurchaseManager b0() {
        return this.f12212d;
    }

    public final t<Integer> c0() {
        return this.R;
    }

    public final r<UpsellViewState> d0() {
        return this.L;
    }

    public final UserRepository f0() {
        return this.f12218j;
    }

    public final boolean g0() {
        Boolean f10 = this.f12234z.f();
        if (f10 == null) {
            return false;
        }
        return f10.booleanValue();
    }

    public final void h0() {
        if (this.C.f() == FilterStateViewState.OFF) {
            H0(ProgressDialogViewState.VISIBLE);
            this.f12216h.r();
        }
    }

    public final void i0(int i10) {
        int i11;
        List f10 = this.E.f();
        if (f10 != null) {
            i11 = f10.size();
        } else {
            i11 = -1;
        }
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12227s;
        aVar.a(str, "markItemAsSeen: " + i10 + " of " + i11);
        if (i10 < i11) {
            List<GiveTakeBase> f11 = this.E.f();
            j.d(f11);
            GiveTakeBase giveTakeBase = (GiveTakeBase) f11.get(i10);
            if (this.f12228t.contains(giveTakeBase.getProfileId())) {
                return;
            }
            if (giveTakeBase instanceof GiveTake) {
                GiveTake giveTake = (GiveTake) giveTakeBase;
                if (!giveTake.isShown()) {
                    this.f12228t.add(giveTake.getProfileId());
                    this.f12216h.markGiveTakeAsSeen(giveTake.getProfileId(), new c(this, giveTakeBase));
                }
            } else if (giveTakeBase instanceof RisingGiveTake) {
                RisingGiveTake risingGiveTake = (RisingGiveTake) giveTakeBase;
                if (!risingGiveTake.isShown()) {
                    this.f12228t.add(risingGiveTake.getProfileId());
                    this.f12216h.markRisingGiveTakeAsSeen(risingGiveTake.getProfileId(), new d(this, giveTakeBase));
                    risingGiveTake.setShown(true);
                    this.f12222n.i("rising_give_take", (Model) giveTakeBase);
                }
            }
        }
    }

    public final void k0(c6.a aVar) {
        GiveTake giveTake;
        j.g(aVar, "activityResult");
        if (lc.b.c(aVar) && (giveTake = this.f12229u) != null) {
            j.e(giveTake, "null cannot be cast to non-null type com.coffeemeetsbagel.models.GiveTake");
            this.f12229u = null;
            AutoPurchase autoPurchase = this.f12230v;
            if (autoPurchase != null) {
                j.d(autoPurchase);
                int i10 = a.f12256a[autoPurchase.getPurchaseType().ordinal()];
                if (i10 == 1) {
                    o0(giveTake, false);
                    this.f12230v = null;
                } else if (i10 != 2) {
                    a.C0491a aVar2 = fa.a.f40771d;
                    String str = this.f12227s;
                    AutoPurchase autoPurchase2 = this.f12230v;
                    j.d(autoPurchase2);
                    PurchaseType purchaseType = autoPurchase2.getPurchaseType();
                    aVar2.a(str, "Unsupported purchase type in Discover " + purchaseType);
                } else {
                    M0(giveTake);
                    this.f12230v = null;
                }
            }
        }
    }

    public final void l0(GiveTake giveTake, PurchaseType purchaseType) {
        j.g(giveTake, "giveTake");
        j.g(purchaseType, "purchaseType");
        e eVar = new e(purchaseType, this, giveTake);
        H0(ProgressDialogViewState.VISIBLE);
        this.f12213e.d(eVar);
    }

    public final void m0() {
        FilterStateViewState filterStateViewState;
        if (this.f12216h.c()) {
            filterStateViewState = FilterStateViewState.ON;
        } else {
            filterStateViewState = FilterStateViewState.OFF;
        }
        C0(filterStateViewState);
        ArrayList arrayList = new ArrayList();
        if (this.C.f() == FilterStateViewState.ON) {
            List<GiveTakeBase> s10 = this.f12216h.s();
            j.f(s10, "discoverManager.filterResultsWithRisingGiveTakes");
            arrayList.addAll(s10);
        } else {
            List<GiveTakeBase> p10 = this.f12216h.p();
            j.f(p10, "discoverManager.giveTake…veTakeBasesInfiniteScroll");
            arrayList.addAll(p10);
        }
        E0(arrayList);
    }

    public final void n0() {
        C0(FilterStateViewState.OFF);
        this.f12216h.g();
        this.f12216h.e();
    }

    public final void o0(GiveTake giveTake, boolean z10) {
        j.g(giveTake, "giveTake");
        NetworkProfile j10 = this.f12213e.j();
        j.d(j10);
        if (j10.isOnHold()) {
            z0(DialogViewState.UNPAUSE, giveTake, PurchaseType.PAID_LIKE);
            return;
        }
        NetworkProfile j11 = this.f12213e.j();
        j.d(j11);
        long beans = j11.getBeans();
        Price price = this.f12232x;
        j.d(price);
        int beanCost = price.getBeanCost(1);
        if (beans >= ((long) beanCost)) {
            p0(beanCost, giveTake, z10);
            return;
        }
        this.f12229u = giveTake;
        PurchaseType purchaseType = PurchaseType.PAID_LIKE;
        String id2 = giveTake.getId();
        j.f(id2, "giveTake.id");
        this.f12230v = new AutoPurchase(purchaseType, 1, price, beanCost, id2);
        K0(giveTake, purchaseType);
    }

    public final void v0(GiveTake giveTake) {
        j.g(giveTake, "giveTake");
        PurchaseManager purchaseManager = this.f12212d;
        PurchaseType purchaseType = PurchaseType.DISCOVER_LIKES;
        this.f12231w = purchaseManager.getPrice(purchaseType);
        this.f12232x = this.f12212d.getPrice(PurchaseType.PAID_LIKE);
        NetworkProfile j10 = this.f12213e.j();
        j.d(j10);
        if (j10.isOnHold()) {
            z0(DialogViewState.UNPAUSE, giveTake, purchaseType);
            return;
        }
        Price price = this.f12231w;
        j.d(price);
        boolean z10 = true;
        int beanCost = price.getBeanCost(1);
        if (beanCost != 0) {
            z10 = false;
        }
        NetworkProfile j11 = this.f12213e.j();
        j.d(j11);
        long beans = j11.getBeans();
        if (z10 || beans >= ((long) beanCost)) {
            M0(giveTake);
            return;
        }
        this.f12229u = giveTake;
        Price price2 = this.f12231w;
        j.d(price2);
        String id2 = giveTake.getId();
        j.f(id2, "giveTake.id");
        this.f12230v = new AutoPurchase(purchaseType, 1, price2, beanCost, id2);
        K0(giveTake, purchaseType);
    }

    public final void w0(RisingGiveTake risingGiveTake) {
        j.g(risingGiveTake, "risingGiveTake");
        String profileId = risingGiveTake.getProfileId();
        DiscoverViewModel$sendLike$callbackSyncAfterConnect$1 discoverViewModel$sendLike$callbackSyncAfterConnect$1 = new DiscoverViewModel$sendLike$callbackSyncAfterConnect$1(this, profileId, risingGiveTake);
        H0(ProgressDialogViewState.VISIBLE);
        this.f12216h.k(risingGiveTake, new g(this, discoverViewModel$sendLike$callbackSyncAfterConnect$1, profileId, risingGiveTake));
    }
}

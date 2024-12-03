package com.coffeemeetsbagel.today_view.today_bagel;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.like_pass.view.MatchActionType;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.subscription_dialog.dialog.y;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_bagel.a1;
import com.facebook.share.internal.ShareConstants;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import fa.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import qj.b0;
import qj.q;
import wk.l;

public final class SuggestedMatchContainerInteractor extends s<a1, n0> implements a1.a {
    public static final a T = new a((DefaultConstructorMarker) null);
    static final /* synthetic */ l<Object>[] U = {kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(SuggestedMatchContainerInteractor.class, "numberOfFlowers", "getNumberOfFlowers()I", 0))};
    public l5.a B;
    public com.coffeemeetsbagel.instant_like.d C;
    public y5.b D;
    public com.coffeemeetsbagel.match.d E;
    public z F;
    public SubscriptionRepository G;
    public com.coffeemeetsbagel.store.alc.b H;
    public UpdateBagelLocalUseCase I;
    public com.coffeemeetsbagel.store.alc.a J;
    public a6.a K;
    public com.coffeemeetsbagel.store.alc.a L;
    public SuggestedRepository M;
    public GetLastPassedBagelUseCase N;
    private final e O = new e(this);
    /* access modifiers changed from: private */
    public final com.jakewharton.rxrelay2.b<Boolean> P;
    private AutoPurchase Q;
    private MatchContract R;
    private final tk.d S;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Bagel f37389f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37390g;

    /* renamed from: h  reason: collision with root package name */
    public com.coffeemeetsbagel.match.j f37391h;

    /* renamed from: j  reason: collision with root package name */
    public a7.a f37392j;

    /* renamed from: k  reason: collision with root package name */
    public k0 f37393k;

    /* renamed from: l  reason: collision with root package name */
    public ProfileContract$Manager f37394l;

    /* renamed from: m  reason: collision with root package name */
    public hb.c f37395m;

    /* renamed from: n  reason: collision with root package name */
    public s9.a f37396n;

    /* renamed from: p  reason: collision with root package name */
    public e.a f37397p;

    /* renamed from: q  reason: collision with root package name */
    public t f37398q;

    /* renamed from: t  reason: collision with root package name */
    public FirebaseContract.Analytics f37399t;

    /* renamed from: w  reason: collision with root package name */
    public ActivityMain f37400w;

    /* renamed from: x  reason: collision with root package name */
    public l8.h f37401x;

    /* renamed from: y  reason: collision with root package name */
    public a0 f37402y;

    /* renamed from: z  reason: collision with root package name */
    public l9.e f37403z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37404a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37405b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        static {
            /*
                com.coffeemeetsbagel.store.alc.PurchaseType[] r0 = com.coffeemeetsbagel.store.alc.PurchaseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.store.alc.PurchaseType r2 = com.coffeemeetsbagel.store.alc.PurchaseType.PAID_LIKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.store.alc.PurchaseType r3 = com.coffeemeetsbagel.store.alc.PurchaseType.SKIP_THE_LINE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f37404a = r0
                com.coffeemeetsbagel.models.Bagel$STAMP[] r0 = com.coffeemeetsbagel.models.Bagel.STAMP.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.Bagel$STAMP r3 = com.coffeemeetsbagel.models.Bagel.STAMP.LIKED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.coffeemeetsbagel.models.Bagel$STAMP r1 = com.coffeemeetsbagel.models.Bagel.STAMP.PASSED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                f37405b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor.b.<clinit>():void");
        }
    }

    public static final class c implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37406a;

        c(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37406a = suggestedMatchContainerInteractor;
        }

        public void a(Bagel bagel) {
            kotlin.jvm.internal.j.g(bagel, "responseBagel");
            this.f37406a.u3(bagel);
        }

        public void onError(String str) {
            ((a1) this.f37406a.f7875e).A();
            this.f37406a.T2().z1(R.string.error_connecting_auto_retry);
            this.f37406a.o3();
        }
    }

    public static final class d implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37407a;

        d(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37407a = suggestedMatchContainerInteractor;
        }

        public void a(Bagel bagel) {
            kotlin.jvm.internal.j.g(bagel, "responseBagel");
            a.C0491a aVar = fa.a.f40771d;
            String id2 = this.f37407a.f37389f.getId();
            aVar.a("SuggestedMatchContainerInteractor", "Bagel PASS action successful on bagel " + id2);
            this.f37407a.l4("pass");
        }

        public void onError(String str) {
            a.C0491a aVar = fa.a.f40771d;
            String id2 = this.f37407a.f37389f.getId();
            aVar.b("SuggestedMatchContainerInteractor", "Bagel PASS action failed on bagel " + id2);
        }
    }

    public static final class e implements MatchViewInteractor.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37408a;

        e(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37408a = suggestedMatchContainerInteractor;
        }

        public void b(String str) {
            kotlin.jvm.internal.j.g(str, "comment");
            this.f37408a.b(str);
        }

        public void c() {
            this.f37408a.c();
        }

        public void d() {
            this.f37408a.F3();
        }

        public void e() {
            this.f37408a.z3();
        }

        public void f(Bagel.STAMP stamp) {
            kotlin.jvm.internal.j.g(stamp, "stamp");
            this.f37408a.S(stamp);
        }
    }

    public static final class f implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37409a;

        f(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37409a = suggestedMatchContainerInteractor;
        }

        public void onFailure() {
            fa.a.f40771d.b("SuggestedMatchContainerInteractor", "Unable to refresh prices");
        }

        public void onSuccess() {
            this.f37409a.e4();
        }
    }

    public static final class g implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37411a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Price f37412b;

        g(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, Price price) {
            this.f37411a = suggestedMatchContainerInteractor;
            this.f37412b = price;
        }

        public void a() {
        }

        public void d() {
            this.f37411a.b4();
        }

        public void e() {
            SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = this.f37411a;
            Price price = this.f37412b;
            kotlin.jvm.internal.j.d(price);
            suggestedMatchContainerInteractor.X3(price);
        }
    }

    public static final class h implements y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37413a;

        h(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37413a = suggestedMatchContainerInteractor;
        }

        public void onCancel() {
        }

        public void onFailure() {
            fa.a.f40771d.b("SuggestedMatchContainerInteractor", "Failed to purchase subscription");
        }

        public void onSuccess() {
            this.f37413a.k4();
        }
    }

    public static final class i implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Price f37415b;

        i(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor, Price price) {
            this.f37414a = suggestedMatchContainerInteractor;
            this.f37415b = price;
        }

        public void a() {
            ((n0) this.f37414a.B1()).C(new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_SUGGESTED, "skip the line"));
        }

        public void d() {
            this.f37414a.m3();
        }

        public void e() {
            SuggestedMatchContainerInteractor suggestedMatchContainerInteractor = this.f37414a;
            Price price = this.f37415b;
            kotlin.jvm.internal.j.d(price);
            suggestedMatchContainerInteractor.X3(price);
        }
    }

    public static final class j implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedMatchContainerInteractor f37416a;

        j(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            this.f37416a = suggestedMatchContainerInteractor;
        }

        public void onFailure() {
            fa.a.f40771d.b("SuggestedMatchContainerInteractor", "Unable to refresh prices");
        }

        public void onSuccess() {
            this.f37416a.W3();
        }
    }

    public SuggestedMatchContainerInteractor(Bagel bagel, boolean z10) {
        kotlin.jvm.internal.j.g(bagel, Extra.BAGEL);
        this.f37389f = bagel;
        this.f37390g = z10;
        com.jakewharton.rxrelay2.b<Boolean> D0 = com.jakewharton.rxrelay2.b.D0(Boolean.FALSE);
        kotlin.jvm.internal.j.f(D0, "createDefault(false)");
        this.P = D0;
        this.S = tk.a.f33872a.a();
    }

    /* access modifiers changed from: private */
    public static final void D2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void E2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void F2(String str) {
        ((n) Z2().a(str).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new g0(new SuggestedMatchContainerInteractor$fetchAndRenderMatchContext$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void G2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void H2() {
        ((com.uber.autodispose.t) k3().T().L().v(new o(new SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$1(this))).v(new p(new SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$2(this))).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new q(new SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$3(this)), new r(SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$4.f37410a));
    }

    private final void H3(int i10) {
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        ((com.uber.autodispose.t) f3().a("PaidLike", (long) i10, 1, id2, PurchaseRepository.PurchaseRequestSource.SUGGESTED).q(new j0(new SuggestedMatchContainerInteractor$purchaseFlowers$1(this))).v(new k0(new SuggestedMatchContainerInteractor$purchaseFlowers$2(this))).r(new l0(new SuggestedMatchContainerInteractor$purchaseFlowers$3(this))).s(new j(this)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new k(new SuggestedMatchContainerInteractor$purchaseFlowers$5(this, i10)), new l(new SuggestedMatchContainerInteractor$purchaseFlowers$6(this, i10)));
    }

    /* access modifiers changed from: private */
    public static final b0 I2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void I3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 J2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 J3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L3(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(suggestedMatchContainerInteractor, "this$0");
        ((a1) suggestedMatchContainerInteractor.f7875e).A();
    }

    /* access modifiers changed from: private */
    public final void M2(boolean z10) {
        if (!V2().a("SuggestedPaywall.Show.Android") || !z10) {
            if (this.f37390g) {
                c3().a(false);
            }
            Q2().w();
        } else {
            H2();
        }
        h5.i.b(EventType.SUGGESTED_BAGEL_LIKED);
    }

    /* access modifiers changed from: private */
    public static final void M3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void N3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void O3(int i10, int i11) {
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        ((com.uber.autodispose.t) com.coffeemeetsbagel.store.alc.b.b(f3(), "Woo", (long) i11, i10, id2, (PurchaseRepository.PurchaseRequestSource) null, 16, (Object) null).q(new s(new SuggestedMatchContainerInteractor$purchaseSkipTheLine$1(this))).v(new u(new SuggestedMatchContainerInteractor$purchaseSkipTheLine$2(this))).r(new v(new SuggestedMatchContainerInteractor$purchaseSkipTheLine$3(this))).s(new w(this)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new x(new SuggestedMatchContainerInteractor$purchaseSkipTheLine$5(this, i10, i11)), new y(new SuggestedMatchContainerInteractor$purchaseSkipTheLine$6(this, i10, i11)));
    }

    /* access modifiers changed from: private */
    public static final void P3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 Q3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void S3(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        kotlin.jvm.internal.j.g(suggestedMatchContainerInteractor, "this$0");
        ((a1) suggestedMatchContainerInteractor.f7875e).B(Boolean.TRUE);
        ((a1) suggestedMatchContainerInteractor.f7875e).A();
        suggestedMatchContainerInteractor.M2(false);
    }

    /* access modifiers changed from: private */
    public static final void T3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final List<MatchActionType> U2(boolean z10) {
        boolean a10 = V2().a("OnePaidLike.Enabled.Android");
        if (z10) {
            if (a10) {
                return q.m(MatchActionType.PASS, MatchActionType.FLOWER, MatchActionType.LIKE);
            }
            return q.m(MatchActionType.PASS, MatchActionType.LIKE);
        } else if (a10) {
            return q.m(MatchActionType.PASS, MatchActionType.FLOWER, MatchActionType.LIKE);
        } else if (V2().a("InstantLikeNewUsers.Android.Show.Android")) {
            return q.m(MatchActionType.PASS, MatchActionType.INSTANT_LIKE, MatchActionType.LIKE);
        } else {
            return q.m(MatchActionType.PASS, MatchActionType.LIKE, MatchActionType.COMMENT);
        }
    }

    /* access modifiers changed from: private */
    public static final void U3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void V3() {
        Bagel bagel = this.f37389f;
        e eVar = this.O;
        q<Boolean> P2 = this.P.P();
        kotlin.jvm.internal.j.f(P2, "matchIsSeen.hide()");
        ((n0) B1()).D(bagel, eVar, P2);
    }

    /* access modifiers changed from: private */
    public final void W3() {
        AutoPurchase autoPurchase = this.Q;
        kotlin.jvm.internal.j.d(autoPurchase);
        int i10 = b.f37404a[autoPurchase.getPurchaseType().ordinal()];
        if (i10 == 1) {
            Price price = g3().getPrice(PurchaseType.PAID_LIKE);
            kotlin.jvm.internal.j.d(price);
            X3(price);
        } else if (i10 != 2) {
            a.C0491a aVar = fa.a.f40771d;
            AutoPurchase autoPurchase2 = this.Q;
            kotlin.jvm.internal.j.d(autoPurchase2);
            PurchaseType purchaseType = autoPurchase2.getPurchaseType();
            aVar.a("SuggestedMatchContainerInteractor", "Unsupported purchase type " + purchaseType);
        } else {
            AutoPurchase autoPurchase3 = this.Q;
            kotlin.jvm.internal.j.d(autoPurchase3);
            int expectedPrice = autoPurchase3.getExpectedPrice();
            AutoPurchase autoPurchase4 = this.Q;
            kotlin.jvm.internal.j.d(autoPurchase4);
            v(new d(expectedPrice, autoPurchase4.getItemCount()));
        }
        this.Q = null;
    }

    /* access modifiers changed from: private */
    public final void X3(Price price) {
        String str;
        NetworkProfile j10 = d3().j();
        if (j10 == null) {
            fa.a.f40771d.c("SuggestedMatchContainerInteractor", "My own profile is null", new Throwable("profileManager.myOwnProfile is null"));
            return;
        }
        int beans = (int) j10.getBeans();
        int beanCost = price.getBeanCost(1);
        if (beans >= beanCost) {
            H3(beanCost);
            return;
        }
        MatchContract matchContract = this.R;
        if (matchContract == null || (str = matchContract.getId()) == null) {
            str = this.f37389f.getId();
        }
        String str2 = str;
        PurchaseType purchaseType = PurchaseType.PAID_LIKE;
        Price price2 = g3().getPrice(purchaseType);
        kotlin.jvm.internal.j.d(price2);
        int beans2 = price.getBeans();
        kotlin.jvm.internal.j.f(str2, "matchId");
        this.Q = new AutoPurchase(purchaseType, 1, price2, beans2, str2);
        b4();
        h4(price);
    }

    private final void Y3() {
        Q2().b((j.a) null, this.f37389f, "SuggestedMatchContainerInteractor");
    }

    /* access modifiers changed from: private */
    public final void Z3(int i10) {
        this.S.setValue(this, U[0], Integer.valueOf(i10));
    }

    private final boolean a4() {
        NetworkProfile j10 = d3().j();
        boolean b10 = j3().b(this.f37389f.getRisingBagelCount(), h3(), d3());
        boolean isEmpty = TextUtils.isEmpty(this.f37389f.getLikeComment());
        if (b10 && isEmpty) {
            kotlin.jvm.internal.j.d(j10);
            if (!j10.hasPrioritizedLikes()) {
                return true;
            }
        }
        return false;
    }

    private final int b3() {
        return ((Number) this.S.getValue(this, U[0])).intValue();
    }

    /* access modifiers changed from: private */
    public final void b4() {
        MatchContract matchContract = this.R;
        boolean z10 = true;
        if (matchContract != null) {
            z10 = matchContract.isRising();
        } else if (this.f37389f.getPairAction() != 1) {
            z10 = false;
        }
        b6.q B1 = B1();
        kotlin.jvm.internal.j.f(B1, "router");
        n0.G((n0) B1, U2(z10), (Long) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void c4(boolean z10, Price price) {
        String str;
        if (kotlin.jvm.internal.j.b(price.getName(), "PaidLike")) {
            str = "flower";
        } else {
            str = "skip the line";
        }
        h hVar = new h(this);
        PurchaseSource purchaseSource = new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_SUGGESTED, str);
        if (!z10) {
            ((n0) B1()).C(purchaseSource);
        } else if (kotlin.jvm.internal.j.b(price.getName(), "PaidLike")) {
            ((n0) B1()).N(purchaseSource, PurchaseType.PAID_LIKE, price, hVar);
        } else {
            ((n0) B1()).N(purchaseSource, PurchaseType.SKIP_THE_LINE, price, hVar);
        }
    }

    /* access modifiers changed from: private */
    public final void e4() {
        GenderType genderType;
        boolean z10;
        if (kotlin.jvm.internal.j.b(this.f37389f.getProfile().getGender(), NetworkProfile.MALE)) {
            genderType = GenderType.MALE;
        } else {
            genderType = GenderType.FEMALE;
        }
        if (V2().a("OnePaidLike.Enabled.Android")) {
            Price price = g3().getPrice(PurchaseType.PAID_LIKE);
            ((com.uber.autodispose.t) k3().T().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h0(new SuggestedMatchContainerInteractor$showSkipTheLineDialog$1(this, price, new i(this, price))), new i0(SuggestedMatchContainerInteractor$showSkipTheLineDialog$2.f37418a));
            return;
        }
        Price price2 = g3().getPrice(PurchaseType.WOO);
        if (price2 != null) {
            z10 = price2.isUnlimited();
        } else {
            z10 = false;
        }
        P p10 = this.f7875e;
        kotlin.jvm.internal.j.d(p10);
        ((a1) p10).T(this.f37389f.getRisingBagelCount(), genderType, Boolean.valueOf(z10), b3());
    }

    /* access modifiers changed from: private */
    public static final void f4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void h4(Price price) {
        ((com.uber.autodispose.t) k3().T().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new z(new SuggestedMatchContainerInteractor$startOutOfBeansFlow$1(this, price)), new a0(SuggestedMatchContainerInteractor$startOutOfBeansFlow$2.f37419a));
    }

    /* access modifiers changed from: private */
    public static final void i4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void j4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void k4() {
        g3().refreshPricesFromApi(new j(this));
    }

    /* access modifiers changed from: private */
    public final void l4(String str) {
        Y2().b(ModelDeeplinkData.VALUE_PAGE_SUGGESTED, str);
        ((com.uber.autodispose.t) k3().T().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new m(new SuggestedMatchContainerInteractor$trackBagelAction$1(this, str)), new n(SuggestedMatchContainerInteractor$trackBagelAction$2.f37420a));
    }

    /* access modifiers changed from: private */
    public final void m3() {
        l4("like");
        this.f37389f.setAction(1);
        if (this.f37389f.getPairAction() == 1) {
            ((n0) B1()).E();
            p3();
            return;
        }
        Y3();
        ((n0) B1()).K();
    }

    /* access modifiers changed from: private */
    public static final void m4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void n3(Bagel bagel) {
        a3().l();
        Q2().l(this.f37389f, bagel);
        Q2().z(this.f37389f.getConnectionDetails(), this.f37389f);
        h5.i.b(EventType.SUGGESTED_BAGEL_LIKED);
        ((a1) this.f7875e).N();
    }

    /* access modifiers changed from: private */
    public static final void n4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void o3() {
        M2(false);
    }

    private final void o4(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Dialog Version", "go to chats");
        hashMap.put("Dialog Result", str);
        P2().trackEvent("Connections Dialog", hashMap);
    }

    private final void p4(boolean z10, boolean z11) {
        String str;
        Pair[] pairArr = new Pair[3];
        if (z10) {
            str = "hide";
        } else {
            str = "report";
        }
        pairArr[0] = gk.h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        pairArr[1] = gk.h.a(Extra.IS_CONNECTED, String.valueOf(z11));
        pairArr[2] = gk.h.a("block_source", "suggested_profile");
        P2().trackEvent("Block Confirmation Modal CTA Tapped", h0.l(pairArr));
    }

    /* access modifiers changed from: private */
    public final void q4() {
        P2().trackEvent("Not Enough Beans Viewed", h0.l(gk.h.a("Destination Flow", "Bean Shop Flow"), gk.h.a("source", "suggested_paidlike")));
    }

    /* access modifiers changed from: private */
    public static final b0 r3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 s3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void t3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void v3(Bagel bagel) {
        if (bagel.getAction() != 0) {
            fa.a.f40771d.a("SuggestedMatchContainerInteractor", "bagel is already checked");
            this.P.accept(Boolean.TRUE);
            return;
        }
        ((com.uber.autodispose.t) N2().d(bagel, BagelAction.CHECK).g(com.uber.autodispose.a.a(this))).b(new e0(new SuggestedMatchContainerInteractor$markBagelAsSeenV2$1(this)), new f0(SuggestedMatchContainerInteractor$markBagelAsSeenV2$2.f37417a));
    }

    /* access modifiers changed from: private */
    public static final void w3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void x3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void y3(c6.a aVar) {
        int b10 = aVar.b();
        if (b10 != 5400) {
            if (b10 != 9279) {
                if (b10 == 9296) {
                    Q2().w();
                    return;
                } else if (b10 != 9304) {
                    if (b10 == 435345 && aVar.c() == -1 && b3() > 0) {
                        ((a1) this.f7875e).B(Boolean.FALSE);
                        g3().refreshPricesFromApi(new f(this));
                        return;
                    }
                    return;
                }
            }
            if (aVar.c() == 50) {
                c3().i();
                Q2().w();
                ((n0) B1()).O(u9.d.f18027a.b(aVar));
            }
        } else if (lc.b.c(aVar)) {
            ((a1) this.f7875e).z();
            if (this.Q != null) {
                W3();
            }
        }
    }

    public final void A3() {
        String str;
        a1 a1Var = (a1) this.f7875e;
        FragmentManager supportFragmentManager = T2().getSupportFragmentManager();
        List<NetworkPhoto> photos = this.f37389f.getProfile().getPhotos();
        kotlin.jvm.internal.j.f(photos, "bagel.profile.photos");
        if (!(!photos.isEmpty()) || this.f37389f.getProfile().getPhotos().get(0) == null) {
            str = "";
        } else {
            str = this.f37389f.getProfile().getPhotos().get(0).getUrl();
        }
        a1Var.M(supportFragmentManager, str);
    }

    public final void B0() {
        Price price = g3().getPrice(PurchaseType.PAID_LIKE);
        kotlin.jvm.internal.j.d(price);
        X3(price);
        b4();
    }

    public final void B3() {
        Price price = g3().getPrice(PurchaseType.PAID_LIKE);
        if (!S2().a("suggested_send_flowers_ftue")) {
            S2().b("suggested_send_flowers_ftue");
            g gVar = new g(this, price);
            P p10 = this.f7875e;
            kotlin.jvm.internal.j.d(p10);
            ((a1) p10).R(gVar, price, new SuggestedMatchContainerInteractor$onFlowerButtonClicked$1(this));
            return;
        }
        List m10 = q.m(MatchActionType.PASS, MatchActionType.SEND_FLOWER, MatchActionType.LIKE);
        kotlin.jvm.internal.j.d(price);
        ((n0) B1()).F(m10, Long.valueOf((long) price.getBeanCost(1)));
    }

    public final void C3() {
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "matchId");
        ((n0) B1()).I(id2, false);
    }

    public final void D3() {
        ((n0) B1()).J();
        Q2().w();
    }

    public final void E3(boolean z10) {
        if (z10) {
            m3();
        }
        Q2().w();
    }

    public final void F3() {
        p4(false, this.f37389f.isConnected());
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        String profileId = this.f37389f.getProfileId();
        kotlin.jvm.internal.j.f(profileId, "bagel.profileId");
        ((n0) B1()).B(id2, profileId, this.f37389f.isConnected(), false);
    }

    public void G3(boolean z10) {
        fa.a.f40771d.a("SuggestedMatchContainerInteractor", "onUpsellCancelled");
        if (z10) {
            m3();
            ((n0) B1()).O(R.string.skip_the_line_dismissed_snackbar);
            return;
        }
        M2(false);
    }

    public final com.coffeemeetsbagel.match.d N2() {
        com.coffeemeetsbagel.match.d dVar = this.E;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("actionOnBagelUseCase");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.a O2() {
        com.coffeemeetsbagel.store.alc.a aVar = this.L;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("alcAnalytics");
        return null;
    }

    public final a7.a P2() {
        a7.a aVar = this.f37392j;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final com.coffeemeetsbagel.match.j Q2() {
        com.coffeemeetsbagel.match.j jVar = this.f37391h;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final y5.b R2() {
        y5.b bVar = this.D;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("bottomNavStateStream");
        return null;
    }

    public final void S(Bagel.STAMP stamp) {
        kotlin.jvm.internal.j.g(stamp, "stampAction");
        int i10 = b.f37405b[stamp.ordinal()];
        if (i10 == 1) {
            M2(true);
        } else if (i10 == 2) {
            q3();
        }
    }

    public final a6.a S2() {
        a6.a aVar = this.K;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("coachmarkManager");
        return null;
    }

    public final ActivityMain T2() {
        ActivityMain activityMain = this.f37400w;
        if (activityMain != null) {
            return activityMain;
        }
        kotlin.jvm.internal.j.y("componentActivity");
        return null;
    }

    public final s9.a V2() {
        s9.a aVar = this.f37396n;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public void W0() {
        Q2().w();
    }

    public final FirebaseContract.Analytics W2() {
        FirebaseContract.Analytics analytics = this.f37399t;
        if (analytics != null) {
            return analytics;
        }
        kotlin.jvm.internal.j.y("firebaseAnalytics");
        return null;
    }

    public final com.coffeemeetsbagel.instant_like.d X2() {
        com.coffeemeetsbagel.instant_like.d dVar = this.C;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("instantLikeAnalytics");
        return null;
    }

    public final z Y2() {
        z zVar = this.F;
        if (zVar != null) {
            return zVar;
        }
        kotlin.jvm.internal.j.y("matchAnalytics");
        return null;
    }

    public final com.coffeemeetsbagel.domain.repository.a0 Z2() {
        com.coffeemeetsbagel.domain.repository.a0 a0Var = this.f37402y;
        if (a0Var != null) {
            return a0Var;
        }
        kotlin.jvm.internal.j.y("matchRepository");
        return null;
    }

    public final void a0() {
        a.C0491a aVar = fa.a.f40771d;
        String profileId = this.f37389f.getProfileId();
        aVar.a("SuggestedMatchContainerInteractor", "MatchAction: PASS on profile " + profileId);
        ((n0) B1()).M();
    }

    public final l8.h a3() {
        l8.h hVar = this.f37401x;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.j.y("mongooseManager");
        return null;
    }

    public void b(String str) {
        kotlin.jvm.internal.j.g(str, "comment");
        if (!TextUtils.isEmpty(str)) {
            this.f37389f.setLikeComment(str);
        }
        ((a1) this.f7875e).u();
        y();
    }

    public void b1() {
        o4("redirected");
        ((n0) B1()).z(this.f37389f);
    }

    public void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "Overall Profile");
        if (!TextUtils.isEmpty(this.f37389f.getLikeComment())) {
            hashMap.put("action", "Comment");
        } else if (this.f37389f.getAction() == 1) {
            hashMap.put("action", "like");
        } else {
            hashMap.put("action", "Dismiss");
            d4();
        }
        P2().trackEvent("Like Comment Popup", hashMap);
    }

    public final e.a c3() {
        e.a aVar = this.f37397p;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("parentListener");
        return null;
    }

    public final ProfileContract$Manager d3() {
        ProfileContract$Manager profileContract$Manager = this.f37394l;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final void d4() {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("SuggestedMatchContainerInteractor", "showLikePassButtons - " + this);
        b4();
    }

    public final com.coffeemeetsbagel.store.alc.a e3() {
        com.coffeemeetsbagel.store.alc.a aVar = this.J;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("purchaseAnalytics");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.b f3() {
        com.coffeemeetsbagel.store.alc.b bVar = this.H;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("purchaseItemUseCase");
        return null;
    }

    public final k0 g3() {
        k0 k0Var = this.f37393k;
        if (k0Var != null) {
            return k0Var;
        }
        kotlin.jvm.internal.j.y("purchaseManager");
        return null;
    }

    public final void h() {
        fa.a.f40771d.a("SuggestedMatchContainerInteractor", "onInstantLikeCancelled");
        b4();
    }

    public final t h3() {
        t tVar = this.f37398q;
        if (tVar != null) {
            return tVar;
        }
        kotlin.jvm.internal.j.y("remoteConfigManager");
        return null;
    }

    public void i() {
        AutoPurchase autoPurchase = this.Q;
        kotlin.jvm.internal.j.d(autoPurchase);
        PurchaseType purchaseType = autoPurchase.getPurchaseType();
        AutoPurchase autoPurchase2 = this.Q;
        kotlin.jvm.internal.j.d(autoPurchase2);
        int itemCount = autoPurchase2.getItemCount();
        AutoPurchase autoPurchase3 = this.Q;
        kotlin.jvm.internal.j.d(autoPurchase3);
        Price price = autoPurchase3.getPrice();
        AutoPurchase autoPurchase4 = this.Q;
        kotlin.jvm.internal.j.d(autoPurchase4);
        ((n0) B1()).y(purchaseType, itemCount, price, autoPurchase4.getExpectedPrice());
    }

    public void i0(String str) {
        kotlin.jvm.internal.j.g(str, "matchId");
        ((n0) B1()).I(str, true);
    }

    public final UpdateBagelLocalUseCase i3() {
        UpdateBagelLocalUseCase updateBagelLocalUseCase = this.I;
        if (updateBagelLocalUseCase != null) {
            return updateBagelLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveBagelUseCase");
        return null;
    }

    public void j(int i10) {
        Z3(i10);
        ((n0) B1()).C(new PurchaseSource("Skip the Line", "skip the line"));
    }

    public final l9.e j3() {
        l9.e eVar = this.f37403z;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.j.y("skipTheLineManager");
        return null;
    }

    public final SubscriptionRepository k3() {
        SubscriptionRepository subscriptionRepository = this.G;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        kotlin.jvm.internal.j.y("subscriptionRepository");
        return null;
    }

    public final SuggestedRepository l3() {
        SuggestedRepository suggestedRepository = this.M;
        if (suggestedRepository != null) {
            return suggestedRepository;
        }
        kotlin.jvm.internal.j.y("suggestedRepository");
        return null;
    }

    public /* bridge */ /* synthetic */ void p1(Boolean bool) {
        G3(bool.booleanValue());
    }

    public final void p3() {
        ((a1) this.f7875e).Q();
        Q2().b(new c(this), this.f37389f, "SuggestedMatchContainerInteractor");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q3() {
        /*
            r4 = this;
            com.coffeemeetsbagel.models.Bagel r0 = r4.f37389f
            r1 = 2
            r0.setAction(r1)
            com.coffeemeetsbagel.match.j r0 = r4.Q2()
            com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$d r1 = new com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$d
            r1.<init>(r4)
            com.coffeemeetsbagel.models.Bagel r2 = r4.f37389f
            java.lang.String r3 = "SuggestedMatchContainerInteractor"
            r0.b(r1, r2, r3)
            boolean r0 = r4.f37390g
            r1 = 0
            if (r0 == 0) goto L_0x0022
            com.coffeemeetsbagel.today_view.main.e$a r0 = r4.c3()
            r0.b(r1)
        L_0x0022:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.coffeemeetsbagel.models.Bagel r2 = r4.f37389f
            int r2 = r2.getPairAction()
            r3 = 1
            if (r2 != r3) goto L_0x0031
            r1 = r3
        L_0x0031:
            java.lang.String r2 = "is_rising_bagel"
            r0.putBoolean(r2, r1)
            com.coffeemeetsbagel.models.Bagel r1 = r4.f37389f
            com.coffeemeetsbagel.models.NetworkProfile r1 = r1.getProfile()
            java.util.List r1 = r1.getPhotos()
            if (r1 == 0) goto L_0x0054
            java.lang.String r2 = "photos"
            kotlin.jvm.internal.j.f(r1, r2)
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.P(r1)
            com.coffeemeetsbagel.models.NetworkPhoto r1 = (com.coffeemeetsbagel.models.NetworkPhoto) r1
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = r1.getUrl()
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            if (r1 != 0) goto L_0x005a
            java.lang.String r1 = ""
            goto L_0x005f
        L_0x005a:
            java.lang.String r2 = "bagel.profile.photos?.firstOrNull()?.url ?: \"\""
            kotlin.jvm.internal.j.f(r1, r2)
        L_0x005f:
            java.lang.String r2 = "image_url"
            r0.putString(r2, r1)
            com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.SUGGESTED_BAGEL_PASSED
            h5.i.c(r1, r0)
            s9.a r0 = r4.V2()
            java.lang.String r1 = "SuggestedPaywall.Show.Android"
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L_0x00bd
            com.coffeemeetsbagel.domain.repository.SubscriptionRepository r0 = r4.k3()
            qj.h r0 = r0.T()
            qj.w r0 = r0.L()
            com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$2 r1 = new com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$2
            r1.<init>(r4)
            com.coffeemeetsbagel.today_view.today_bagel.b0 r2 = new com.coffeemeetsbagel.today_view.today_bagel.b0
            r2.<init>(r1)
            qj.w r0 = r0.v(r2)
            com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$3 r1 = new com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$3
            r1.<init>(r4)
            com.coffeemeetsbagel.today_view.today_bagel.c0 r2 = new com.coffeemeetsbagel.today_view.today_bagel.c0
            r2.<init>(r1)
            qj.w r0 = r0.v(r2)
            qj.v r1 = sj.a.a()
            qj.w r0 = r0.E(r1)
            com.uber.autodispose.d r1 = com.uber.autodispose.a.a(r4)
            java.lang.Object r0 = r0.g(r1)
            com.uber.autodispose.t r0 = (com.uber.autodispose.t) r0
            com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$4 r1 = new com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor$handlePassAction$4
            r1.<init>(r4)
            com.coffeemeetsbagel.today_view.today_bagel.d0 r2 = new com.coffeemeetsbagel.today_view.today_bagel.d0
            r2.<init>(r1)
            r0.c(r2)
            goto L_0x00c4
        L_0x00bd:
            com.coffeemeetsbagel.match.j r0 = r4.Q2()
            r0.w()
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.today_view.today_bagel.SuggestedMatchContainerInteractor.q3():void");
    }

    public void u1() {
        o4("no chat sent");
        Q2().w();
    }

    public final void u3(Bagel bagel) {
        boolean z10;
        kotlin.jvm.internal.j.g(bagel, "responseBagel");
        ((a1) this.f7875e).A();
        String coupleId = bagel.getCoupleId();
        if (coupleId == null || coupleId.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            T2().z1(R.string.error_connecting_auto_retry);
            o3();
            return;
        }
        n3(bagel);
    }

    public void v(d dVar) {
        String str;
        kotlin.jvm.internal.j.g(dVar, "skipTheLineConfirmation");
        fa.a.f40771d.a("SuggestedMatchContainerInteractor", "skipTheLineConfirmed");
        NetworkProfile j10 = d3().j();
        if (j10 != null) {
            if (((int) j10.getBeans()) >= dVar.a()) {
                O3(dVar.b(), dVar.a());
                return;
            }
            MatchContract matchContract = this.R;
            if (matchContract == null || (str = matchContract.getId()) == null) {
                str = this.f37389f.getId();
            }
            String str2 = str;
            PurchaseType purchaseType = PurchaseType.SKIP_THE_LINE;
            int b10 = dVar.b();
            Price price = g3().getPrice(PurchaseType.WOO);
            kotlin.jvm.internal.j.d(price);
            int a10 = dVar.a();
            kotlin.jvm.internal.j.f(str2, "matchId");
            this.Q = new AutoPurchase(purchaseType, b10, price, a10, str2);
            ((a1) this.f7875e).P();
        }
    }

    public final void y() {
        boolean a42 = a4();
        boolean a10 = V2().a("InstantLikeNewUsers.Android.Show.Android");
        boolean z10 = true;
        if (this.f37389f.getPairAction() != 1) {
            z10 = false;
        }
        if (!a42 || z10) {
            m3();
        } else if (a10) {
            ((a1) this.f7875e).O(this.f37389f.getId());
            X2().h();
        } else {
            e4();
        }
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        Z3(0);
        ((p) R2().a().g(com.uber.autodispose.a.a(this))).c(new i(new SuggestedMatchContainerInteractor$didBecomeActive$1(this)));
        ((p) T2().t2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new t(new SuggestedMatchContainerInteractor$didBecomeActive$2(this)));
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        F2(id2);
        V3();
    }

    public final void z3() {
        p4(true, this.f37389f.isConnected());
        String id2 = this.f37389f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        String profileId = this.f37389f.getProfileId();
        kotlin.jvm.internal.j.f(profileId, "bagel.profileId");
        ((n0) B1()).B(id2, profileId, this.f37389f.isConnected(), true);
    }
}

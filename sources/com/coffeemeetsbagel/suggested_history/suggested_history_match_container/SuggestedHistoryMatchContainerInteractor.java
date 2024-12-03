package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import b6.s;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match.d;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.share.internal.ShareConstants;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l8.h;
import qj.b0;
import qj.q;
import wb.c;

public final class SuggestedHistoryMatchContainerInteractor extends s<h0, SuggestedHistoryMatchContainerRouter> implements i0 {
    public static final a E = new a((DefaultConstructorMarker) null);
    public ProfileContract$Manager B;
    public com.coffeemeetsbagel.store.alc.a C;
    private AutoPurchase D;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Bagel f37173f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final d f37174g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f37175h = "SuggestedHistoryMatchContainerInteractor";

    /* renamed from: j  reason: collision with root package name */
    public z f37176j;

    /* renamed from: k  reason: collision with root package name */
    public d f37177k;

    /* renamed from: l  reason: collision with root package name */
    public h f37178l;

    /* renamed from: m  reason: collision with root package name */
    public j f37179m;

    /* renamed from: n  reason: collision with root package name */
    public s9.a f37180n;

    /* renamed from: p  reason: collision with root package name */
    public c f37181p;

    /* renamed from: q  reason: collision with root package name */
    public a7.a f37182q;

    /* renamed from: t  reason: collision with root package name */
    public c6.b f37183t;

    /* renamed from: w  reason: collision with root package name */
    public a6.a f37184w;

    /* renamed from: x  reason: collision with root package name */
    public com.coffeemeetsbagel.store.alc.b f37185x;

    /* renamed from: y  reason: collision with root package name */
    public UpdateBagelLocalUseCase f37186y;

    /* renamed from: z  reason: collision with root package name */
    public k0 f37187z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements MatchViewInteractor.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedHistoryMatchContainerInteractor f37188a;

        b(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
            this.f37188a = suggestedHistoryMatchContainerInteractor;
        }

        public void b(String str) {
            kotlin.jvm.internal.j.g(str, "comment");
        }

        public void c() {
        }

        public void d() {
            SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor = this.f37188a;
            suggestedHistoryMatchContainerInteractor.S2(true, suggestedHistoryMatchContainerInteractor.f37173f.isConnected());
            String id2 = this.f37188a.f37173f.getId();
            kotlin.jvm.internal.j.f(id2, "bagel.id");
            String profileId = this.f37188a.f37173f.getProfileId();
            kotlin.jvm.internal.j.f(profileId, "bagel.profileId");
            ((SuggestedHistoryMatchContainerRouter) this.f37188a.B1()).q(id2, profileId, this.f37188a.f37173f.isConnected(), false);
        }

        public void e() {
            SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor = this.f37188a;
            suggestedHistoryMatchContainerInteractor.S2(true, suggestedHistoryMatchContainerInteractor.f37173f.isConnected());
            String id2 = this.f37188a.f37173f.getId();
            kotlin.jvm.internal.j.f(id2, "bagel.id");
            String profileId = this.f37188a.f37173f.getProfileId();
            kotlin.jvm.internal.j.f(profileId, "bagel.profileId");
            ((SuggestedHistoryMatchContainerRouter) this.f37188a.B1()).q(id2, profileId, this.f37188a.f37173f.isConnected(), true);
        }

        public void f(Bagel.STAMP stamp) {
            kotlin.jvm.internal.j.g(stamp, "stamp");
        }
    }

    public SuggestedHistoryMatchContainerInteractor(Bagel bagel, d dVar) {
        kotlin.jvm.internal.j.g(bagel, Extra.BAGEL);
        kotlin.jvm.internal.j.g(dVar, "parentListener");
        this.f37173f = bagel;
        this.f37174g = dVar;
    }

    /* access modifiers changed from: private */
    public static final void A2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void B2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void C2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
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

    /* access modifiers changed from: private */
    public static final void F2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void G2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void H2(int i10) {
        String id2 = this.f37173f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        ((t) t2().a("PaidLike", (long) i10, 1, id2, PurchaseRepository.PurchaseRequestSource.SUGGESTED).v(new n(new SuggestedHistoryMatchContainerInteractor$purchaseFlowers$1(this))).r(new o(new SuggestedHistoryMatchContainerInteractor$purchaseFlowers$2(this))).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new p(new SuggestedHistoryMatchContainerInteractor$purchaseFlowers$3(this, i10)), new q(new SuggestedHistoryMatchContainerInteractor$purchaseFlowers$4(this, i10)));
    }

    /* access modifiers changed from: private */
    public static final b0 I2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void J2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void M2() {
        boolean z10;
        MatchIdAttribution matchIdAttribution;
        b bVar = new b(this);
        if (this.f37173f.getPairAction() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f37173f.getPurchaseAttributionValue() != null) {
            String id2 = this.f37173f.getId();
            kotlin.jvm.internal.j.f(id2, "bagel.id");
            String profileId = this.f37173f.getProfileId();
            kotlin.jvm.internal.j.f(profileId, "bagel.profileId");
            matchIdAttribution = new MatchIdAttribution(id2, profileId, this.f37173f.getPurchaseAttributionValue());
        } else {
            matchIdAttribution = null;
        }
        String profileId2 = this.f37173f.getProfileId();
        kotlin.jvm.internal.j.f(profileId2, "bagel.profileId");
        q V = q.V(Boolean.TRUE);
        kotlin.jvm.internal.j.f(V, "just(true)");
        ((SuggestedHistoryMatchContainerRouter) B1()).v(profileId2, bVar, V, this.f37173f.getAction(), this.f37173f.isConnected(), z10, this.f37173f.getPairLikeComment(), matchIdAttribution);
    }

    private final void N2() {
        NetworkProfile j10 = s2().j();
        if (j10 != null) {
            long beans = j10.getBeans();
            AutoPurchase autoPurchase = this.D;
            kotlin.jvm.internal.j.d(autoPurchase);
            if (beans < ((long) autoPurchase.getExpectedPrice())) {
                T2();
                ((h0) this.f7875e).K();
                return;
            }
            AutoPurchase autoPurchase2 = this.D;
            kotlin.jvm.internal.j.d(autoPurchase2);
            if (autoPurchase2.getPurchaseType() == PurchaseType.PAID_LIKE) {
                B0();
                this.D = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void O2() {
        if (!o2().a("history_in_suggested_rewind_tooltip")) {
            ((SuggestedHistoryMatchContainerRouter) B1()).m();
            o2().b("history_in_suggested_rewind_tooltip");
        }
    }

    /* access modifiers changed from: private */
    public final void P2(String str) {
        w2().b("suggested_history", str);
        ((t) q2().a().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new s(new SuggestedHistoryMatchContainerInteractor$trackBagelAction$1(this, str)), new t(SuggestedHistoryMatchContainerInteractor$trackBagelAction$2.f37189a));
    }

    /* access modifiers changed from: private */
    public static final void Q2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void S2(boolean z10, boolean z11) {
        String str;
        Pair[] pairArr = new Pair[3];
        if (z10) {
            str = "hide";
        } else {
            str = "report";
        }
        pairArr[0] = gk.h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        pairArr[1] = gk.h.a(Extra.IS_CONNECTED, String.valueOf(z11));
        pairArr[2] = gk.h.a("block_source", "suggested_history_profile");
        m2().trackEvent("Block Confirmation Modal CTA Tapped", h0.l(pairArr));
    }

    private final void T2() {
        m2().trackEvent("Not Enough Beans Viewed", h0.l(gk.h.a("Destination Flow", "Bean Shop Flow"), gk.h.a("source", "suggested_history_paidlike")));
    }

    /* access modifiers changed from: private */
    public static final void g2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void i2() {
        ((n) q2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new r(new SuggestedHistoryMatchContainerInteractor$getActiveSubscriptionForTooltip$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void j2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void x2(Bagel bagel) {
        r2().l();
        n2().l(this.f37173f, bagel);
        n2().z(this.f37173f.getConnectionDetails(), this.f37173f);
        ((SuggestedHistoryMatchContainerRouter) B1()).r();
        ((SuggestedHistoryMatchContainerRouter) B1()).s(this.f37174g, bagel);
    }

    /* access modifiers changed from: private */
    public final Bagel y2(Bagel bagel) {
        bagel.setProfile(this.f37173f.getProfile());
        bagel.setProfileId(this.f37173f.getProfileId());
        bagel.setLastUpdated(this.f37173f.getLastUpdated());
        return bagel;
    }

    /* access modifiers changed from: private */
    public final void z2(c6.a aVar) {
        int b10 = aVar.b();
        if (b10 != 5400) {
            if ((b10 == 9279 || b10 == 9304) && aVar.c() == 50) {
                ((SuggestedHistoryMatchContainerRouter) B1()).n();
                ((SuggestedHistoryMatchContainerRouter) B1()).w(u9.d.f18027a.b(aVar));
            }
        } else if (lc.b.c(aVar)) {
            ((h0) this.f7875e).C();
            if (this.D != null) {
                N2();
            }
        }
    }

    public void B0() {
        NetworkProfile j10 = s2().j();
        k0 u22 = u2();
        PurchaseType purchaseType = PurchaseType.PAID_LIKE;
        Price price = u22.getPrice(purchaseType);
        if (j10 == null) {
            fa.a.f40771d.c("SuggestedHistoryMatchContainerInteractor", "My own profile is null", new Throwable("profileManager.myOwnProfile is null"));
            return;
        }
        int beans = (int) j10.getBeans();
        kotlin.jvm.internal.j.d(price);
        int beanCost = price.getBeanCost(1);
        if (beans >= beanCost) {
            H2(beanCost);
            return;
        }
        Price price2 = u2().getPrice(purchaseType);
        kotlin.jvm.internal.j.d(price2);
        int beans2 = price.getBeans();
        String id2 = this.f37173f.getId();
        kotlin.jvm.internal.j.f(id2, "bagel.id");
        this.D = new AutoPurchase(purchaseType, 1, price2, beans2, id2);
        T2();
        ((h0) this.f7875e).K();
    }

    public void J() {
        ((t) q2().a().K(Optional.a()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new j(new SuggestedHistoryMatchContainerInteractor$onRewindClicked$1(this)));
    }

    public void a0() {
        P2("pass");
        ((t) h2().d(this.f37173f, BagelAction.PASS).q(new k(new SuggestedHistoryMatchContainerInteractor$onPassClicked$1(this))).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new l(new SuggestedHistoryMatchContainerInteractor$onPassClicked$2(this)), new m(new SuggestedHistoryMatchContainerInteractor$onPassClicked$3(this)));
    }

    public final d h2() {
        d dVar = this.f37177k;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("actionOnBagelUseCase");
        return null;
    }

    public void i() {
        AutoPurchase autoPurchase = this.D;
        kotlin.jvm.internal.j.d(autoPurchase);
        PurchaseType purchaseType = autoPurchase.getPurchaseType();
        AutoPurchase autoPurchase2 = this.D;
        kotlin.jvm.internal.j.d(autoPurchase2);
        int itemCount = autoPurchase2.getItemCount();
        AutoPurchase autoPurchase3 = this.D;
        kotlin.jvm.internal.j.d(autoPurchase3);
        Price price = autoPurchase3.getPrice();
        AutoPurchase autoPurchase4 = this.D;
        kotlin.jvm.internal.j.d(autoPurchase4);
        ((SuggestedHistoryMatchContainerRouter) B1()).p(purchaseType, itemCount, price, autoPurchase4.getExpectedPrice());
    }

    public final c6.b k2() {
        c6.b bVar = this.f37183t;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("activityResultStream");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.a l2() {
        com.coffeemeetsbagel.store.alc.a aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("alcAnalytics");
        return null;
    }

    public final a7.a m2() {
        a7.a aVar = this.f37182q;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final j n2() {
        j jVar = this.f37179m;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final a6.a o2() {
        a6.a aVar = this.f37184w;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("coachmarkManager");
        return null;
    }

    public void p() {
        Price price = u2().getPrice(PurchaseType.PAID_LIKE);
        kotlin.jvm.internal.j.d(price);
        ((h0) this.f7875e).N(price);
    }

    public final s9.a p2() {
        s9.a aVar = this.f37180n;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final c q2() {
        c cVar = this.f37181p;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("getActiveSubscriptionUseCase");
        return null;
    }

    public final h r2() {
        h hVar = this.f37178l;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.j.y("mongooseManager");
        return null;
    }

    public final ProfileContract$Manager s2() {
        ProfileContract$Manager profileContract$Manager = this.B;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.b t2() {
        com.coffeemeetsbagel.store.alc.b bVar = this.f37185x;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("purchaseItemForBagelUseCase");
        return null;
    }

    public final k0 u2() {
        k0 k0Var = this.f37187z;
        if (k0Var != null) {
            return k0Var;
        }
        kotlin.jvm.internal.j.y("purchaseManager");
        return null;
    }

    public final UpdateBagelLocalUseCase v2() {
        UpdateBagelLocalUseCase updateBagelLocalUseCase = this.f37186y;
        if (updateBagelLocalUseCase != null) {
            return updateBagelLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveBagelUseCase");
        return null;
    }

    public final z w2() {
        z zVar = this.f37176j;
        if (zVar != null) {
            return zVar;
        }
        kotlin.jvm.internal.j.y("tracker");
        return null;
    }

    public void y() {
        P2("like");
        ((t) h2().d(this.f37173f, BagelAction.LIKE).q(new u(new SuggestedHistoryMatchContainerInteractor$onLikeClicked$1(this))).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new v(new SuggestedHistoryMatchContainerInteractor$onLikeClicked$2(this)), new i(new SuggestedHistoryMatchContainerInteractor$onLikeClicked$3(this)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        boolean z10;
        super.y1();
        M2();
        ((p) k2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new SuggestedHistoryMatchContainerInteractor$didBecomeActive$1(this)));
        if (this.f37173f.getAction() == BagelAction.PASS.getId()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((h0) this.f7875e).M();
            i2();
            return;
        }
        ((h0) this.f7875e).E();
        if (p2().a("OnePaidLike.Enabled.Android") && this.f37173f.getPairAction() != 1) {
            ((h0) this.f7875e).D();
        }
    }
}

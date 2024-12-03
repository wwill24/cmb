package com.coffeemeetsbagel.today_view.card.actioncards;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.requests.BoostPurchaseRequest;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.ActionCardBody;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.dto.ActionCard;
import com.coffeemeetsbagel.models.responses.ResponseBagel;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.ActionCardPresenter;
import com.coffeemeetsbagel.today_view.main.e;
import com.facebook.appevents.AppEventsConstants;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import fa.a;
import hb.c;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import qj.b0;
import qj.h;
import qj.q;

public final class ActionCardInteractor extends s<ActionCardPresenter, a0> implements ActionCardPresenter.a {
    public static final a I = new a((DefaultConstructorMarker) null);
    public bb.a B;
    public cb.a C;
    public c6.b D;
    public SaveProfilesLocalUseCase E;
    public s9.a F;
    /* access modifiers changed from: private */
    public ActionCard G;
    /* access modifiers changed from: private */
    public final String H;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37229f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37230g;

    /* renamed from: h  reason: collision with root package name */
    private final q<Boolean> f37231h;

    /* renamed from: j  reason: collision with root package name */
    public ActionCardRepository f37232j;

    /* renamed from: k  reason: collision with root package name */
    public a7.a f37233k;

    /* renamed from: l  reason: collision with root package name */
    public c f37234l;

    /* renamed from: m  reason: collision with root package name */
    public k0 f37235m;

    /* renamed from: n  reason: collision with root package name */
    public ProfileContract$Manager f37236n;

    /* renamed from: p  reason: collision with root package name */
    public b7.c f37237p;

    /* renamed from: q  reason: collision with root package name */
    public h<Unit> f37238q;

    /* renamed from: t  reason: collision with root package name */
    public e.a f37239t;

    /* renamed from: w  reason: collision with root package name */
    public j f37240w;

    /* renamed from: x  reason: collision with root package name */
    public t7.a f37241x;

    /* renamed from: y  reason: collision with root package name */
    public GetFirstEligibleActionCardUseCase f37242y;

    /* renamed from: z  reason: collision with root package name */
    public a f37243z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements k0.b<Object, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActionCardInteractor f37244a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f37245b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Integer f37246c;

        b(ActionCardInteractor actionCardInteractor, long j10, Integer num) {
            this.f37244a = actionCardInteractor;
            this.f37245b = j10;
            this.f37246c = num;
        }

        public void a(Throwable th2) {
            kotlin.jvm.internal.j.g(th2, "throwable");
            if (this.f37244a.m2().g() && this.f37245b > 0) {
                this.f37244a.m2().a("boost purchase", System.currentTimeMillis() - this.f37245b, StreamManagement.Failed.ELEMENT);
            }
            ((ActionCardPresenter) this.f37244a.f7875e).v();
            ((ActionCardPresenter) this.f37244a.f7875e).G();
        }

        public void b(Object obj) {
            kotlin.jvm.internal.j.g(obj, "response");
            this.f37244a.C2(this.f37245b, this.f37246c.intValue());
        }
    }

    public ActionCardInteractor(boolean z10, boolean z11, q<Boolean> qVar) {
        kotlin.jvm.internal.j.g(qVar, "isVisible");
        this.f37229f = z10;
        this.f37230g = z11;
        this.f37231h = qVar;
        String simpleName = ActionCardInteractor.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "this::class.java.simpleName");
        this.H = simpleName;
    }

    private final void A2(ActionCard actionCard) {
        Unit unit;
        k0 t22 = t2();
        PurchaseType purchaseType = PurchaseType.BONUS_BAGEL;
        Price price = t22.getPrice(purchaseType);
        if (price != null) {
            Y2(actionCard, price);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            fa.a.f40771d.a(this.H, "No price currently available, disabling CTA.");
            ((ActionCardPresenter) this.f7875e).A(actionCard, actionCard.getActionText(), (String) null);
            ((ActionCardPresenter) this.f7875e).o();
        }
        H2(purchaseType);
        h2(actionCard, purchaseType);
    }

    private final void B2(ActionCard actionCard) {
        Unit unit;
        PurchaseType purchaseType = PurchaseType.BOOST;
        H2(purchaseType);
        Price price = t2().getPrice(purchaseType);
        if (price != null) {
            NetworkProfile j10 = s2().j();
            kotlin.jvm.internal.j.d(j10);
            if (j10.hasActiveBoost()) {
                ((ActionCardPresenter) this.f7875e).y(actionCard);
            } else {
                Y2(actionCard, price);
            }
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            fa.a.f40771d.a(this.H, "Race condition; boost price cannot be null given eligibility check succeeded");
        }
    }

    /* access modifiers changed from: private */
    public final void C2(long j10, int i10) {
        ActionCardPresenter actionCardPresenter = (ActionCardPresenter) this.f7875e;
        ActionCard actionCard = this.G;
        if (actionCard == null) {
            kotlin.jvm.internal.j.y("actionCardToBeDisplayed");
            actionCard = null;
        }
        actionCardPresenter.y(actionCard);
        if (m2().g() && j10 > 0) {
            m2().a("boost purchase", System.currentTimeMillis() - j10, "succeeded");
        }
        l2().f("Boost Purchased Popup");
        l2().d("Boost Purchased");
        ((ActionCardPresenter) this.f7875e).v();
        ((ActionCardPresenter) this.f7875e).B();
        b3(i10);
    }

    /* access modifiers changed from: private */
    public final void D2(ActionCard actionCard) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String action = actionCard.getAction();
        if (kotlin.jvm.internal.j.b(action, ActionType.LIKE_PASS_FLOW.b())) {
            ((p) this.f37231h.B(new h(ActionCardInteractor$handleSuccess$1.f37247a)).g(com.uber.autodispose.a.a(this))).b(new n(new ActionCardInteractor$handleSuccess$2(this)), new o(new ActionCardInteractor$handleSuccess$3(this)));
        } else if (kotlin.jvm.internal.j.b(action, ActionType.PERIODIC_QUESTIONS.b())) {
            ((a0) B1()).v();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.PURCHASE_BOOST.b())) {
            B2(actionCard);
        } else if (kotlin.jvm.internal.j.b(action, ActionType.PURCHASE_BONUS_BAGEL.b())) {
            A2(actionCard);
        } else {
            boolean z15 = true;
            if (kotlin.jvm.internal.j.b(action, ActionType.SUGGEST_PAYWALL_INVENTORY.b())) {
                z10 = true;
            } else {
                z10 = kotlin.jvm.internal.j.b(action, ActionType.SUGGEST_PAYWALL_UPSELL.b());
            }
            if (z10) {
                z11 = true;
            } else {
                z11 = kotlin.jvm.internal.j.b(action, ActionType.BAGEL_PREFS.b());
            }
            if (z11) {
                z12 = true;
            } else {
                z12 = kotlin.jvm.internal.j.b(action, ActionType.INVITE_FRIENDS.b());
            }
            if (z12) {
                z13 = true;
            } else {
                z13 = kotlin.jvm.internal.j.b(action, ActionType.DISCOVER_SEARCH.b());
            }
            if (z13) {
                z14 = true;
            } else {
                z14 = kotlin.jvm.internal.j.b(action, ActionType.DISCOVER.b());
            }
            if (!z14) {
                z15 = kotlin.jvm.internal.j.b(action, ActionType.LIMELIGHT.b());
            }
            if (z15) {
                ((ActionCardPresenter) this.f7875e).w(actionCard);
            } else {
                ((a0) B1()).u();
            }
        }
        a3(actionCard);
    }

    /* access modifiers changed from: private */
    public static final boolean E2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
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

    /* access modifiers changed from: private */
    public static final void I2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void J2(String str) {
        ((t) j2().o(new ActionCardBody(str)).E(v2().a()).g(com.uber.autodispose.a.a(this))).e(new q(new ActionCardInteractor$postActionCardShown$1(this)));
    }

    /* access modifiers changed from: private */
    public static final void K2(Function2 function2, Object obj, Object obj2) {
        kotlin.jvm.internal.j.g(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    private final void L2() {
        ((t) q2().r().q(new j(new ActionCardInteractor$processNextActionCard$1(this))).s(new k(this)).E(v2().a()).g(com.uber.autodispose.a.a(this))).b(new l(new ActionCardInteractor$processNextActionCard$3(this)), new m(new ActionCardInteractor$processNextActionCard$4(this)));
    }

    /* access modifiers changed from: private */
    public static final void M2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void N2(ActionCardInteractor actionCardInteractor) {
        kotlin.jvm.internal.j.g(actionCardInteractor, "this$0");
        actionCardInteractor.X2(false);
    }

    /* access modifiers changed from: private */
    public static final void O2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void Q2() {
        Long l10;
        Price price = t2().getPrice(PurchaseType.BONUS_BAGEL);
        if (price != null) {
            l10 = Long.valueOf((long) price.getBeanCost(1));
        } else {
            l10 = null;
        }
        if (l10 != null) {
            NetworkProfile j10 = s2().j();
            kotlin.jvm.internal.j.d(j10);
            if (j10.getBeans() >= l10.longValue()) {
                ((ActionCardPresenter) this.f7875e).F();
                s sVar = new s(this);
                n2().h(l10.longValue(), new t(this, sVar), sVar);
                return;
            }
        }
        ((ActionCardPresenter) this.f7875e).D();
    }

    /* access modifiers changed from: private */
    public static final void R2(ActionCardInteractor actionCardInteractor, Throwable th2) {
        kotlin.jvm.internal.j.g(actionCardInteractor, "this$0");
        a.C0491a aVar = fa.a.f40771d;
        String str = actionCardInteractor.H;
        kotlin.jvm.internal.j.f(th2, "throwable");
        aVar.c(str, "bonus bagel error", th2);
        ((ActionCardPresenter) actionCardInteractor.f7875e).v();
        ((ActionCardPresenter) actionCardInteractor.f7875e).G();
    }

    /* access modifiers changed from: private */
    public static final void S2(ActionCardInteractor actionCardInteractor, j.d dVar, ResponseBagel responseBagel) {
        kotlin.jvm.internal.j.g(actionCardInteractor, "this$0");
        kotlin.jvm.internal.j.g(dVar, "$errorListener");
        actionCardInteractor.j2().n();
        Bagel result = responseBagel.getResult();
        ((t) actionCardInteractor.u2().e(p.e(result.getProfile())).v(new u(new ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$1(result, actionCardInteractor))).E(actionCardInteractor.v2().a()).g(com.uber.autodispose.a.a(actionCardInteractor))).e(new v(new ActionCardInteractor$purchaseBonusBagel$bonusBagelListener$1$2(actionCardInteractor, dVar)));
    }

    /* access modifiers changed from: private */
    public static final b0 T2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void U2(Function2 function2, Object obj, Object obj2) {
        kotlin.jvm.internal.j.g(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public final void V2() {
        Integer num;
        Price price = t2().getPrice(PurchaseType.BOOST);
        if (price != null) {
            num = Integer.valueOf(price.getBeanCost(1));
        } else {
            num = null;
        }
        if (num != null) {
            NetworkProfile j10 = s2().j();
            kotlin.jvm.internal.j.d(j10);
            if (j10.getBeans() >= ((long) num.intValue())) {
                ((ActionCardPresenter) this.f7875e).F();
                long currentTimeMillis = System.currentTimeMillis();
                t2().buyCmbItem(new BoostPurchaseRequest(price, 1), new b(this, currentTimeMillis, num), false);
                return;
            }
        }
        ((ActionCardPresenter) this.f7875e).D();
    }

    private final Map<String, String> W2(ActionCard actionCard) {
        return h0.l(gk.h.a("source", "end of suggested action card"), gk.h.a("action", actionCard.getAction()), gk.h.a("action_text", actionCard.getActionText()), gk.h.a("header_text", actionCard.getHeaderText()), gk.h.a("id", actionCard.getId()), gk.h.a("image_url", actionCard.getImageUrl()), gk.h.a("message_text", actionCard.getMessageText()));
    }

    /* access modifiers changed from: private */
    public final void X2(boolean z10) {
        ((ActionCardPresenter) this.f7875e).E(z10);
    }

    /* access modifiers changed from: private */
    public final void Y2(ActionCard actionCard, Price price) {
        String str;
        String actionText = actionCard.getActionText();
        if (StringsKt__StringsKt.O(actionText, "{beans}", false, 2, (Object) null)) {
            int beans = price.getBeans();
            int freeItemCount = price.getFreeItemCount();
            if (beans == 0 || freeItemCount > 0) {
                str = x2().a(R.string.free_caps, new Object[0]);
            } else {
                str = beans + " ";
            }
            String str2 = str;
            String D2 = r.D(actionText, "{beans}", str2, false, 4, (Object) null);
            if (beans <= 0 || freeItemCount != 0) {
                ((ActionCardPresenter) this.f7875e).A(actionCard, D2, (String) null);
            } else {
                ((ActionCardPresenter) this.f7875e).A(actionCard, D2, str2);
            }
        } else {
            ((ActionCardPresenter) this.f7875e).w(actionCard);
        }
    }

    private final void Z2(ActionCard actionCard) {
        l2().trackEvent("Action Card Tapped", W2(actionCard));
    }

    private final void b3(int i10) {
        l2().trackEvent("Boost State", h0.l(gk.h.a("taps", AppEventsConstants.EVENT_PARAM_VALUE_YES), gk.h.a("expected cost", String.valueOf(i10))));
    }

    /* access modifiers changed from: private */
    public static final void g2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void H2(PurchaseType purchaseType) {
        kotlin.jvm.internal.j.g(purchaseType, "purchaseType");
        ((n) r2().a0(v2().a()).g(com.uber.autodispose.a.a(this))).c(new p(new ActionCardInteractor$observeOutOfBeansClicks$1(this, purchaseType)));
    }

    public final void a3(ActionCard actionCard) {
        kotlin.jvm.internal.j.g(actionCard, "actionCard");
        if (!w2().p("action_card_shown")) {
            J2(actionCard.getId());
            w2().f("action_card_shown", true);
        }
        l2().trackEvent("Action Card Viewed", W2(actionCard));
    }

    public final void c3(boolean z10, boolean z11) {
        String str;
        String str2;
        w2().c("num_times_like_pass_flow_shown", w2().l("num_times_like_pass_flow_shown") + 1);
        Pair[] pairArr = new Pair[3];
        if (z10) {
            str = "Like Flow";
        } else {
            str = "Pass Flow";
        }
        pairArr[0] = gk.h.a("source", str);
        pairArr[1] = gk.h.a("screen", "Get Started Dialog");
        if (z11) {
            str2 = "Complete";
        } else {
            str2 = "View";
        }
        pairArr[2] = gk.h.a("state", str2);
        l2().j("Onboarding", h0.l(pairArr));
    }

    public final void h2(ActionCard actionCard, PurchaseType purchaseType) {
        kotlin.jvm.internal.j.g(actionCard, "actionCard");
        kotlin.jvm.internal.j.g(purchaseType, "purchaseType");
        ((p) t2().priceCache().a0(v2().a()).g(com.uber.autodispose.a.a(this))).c(new r(new ActionCardInteractor$disableCtaWhenUnpurchaseable$1(purchaseType, this, actionCard)));
    }

    public final ActionCardRepository j2() {
        ActionCardRepository actionCardRepository = this.f37232j;
        if (actionCardRepository != null) {
            return actionCardRepository;
        }
        kotlin.jvm.internal.j.y("actionCardRepository");
        return null;
    }

    public void k() {
        ActionCard actionCard = this.G;
        ActionCard actionCard2 = null;
        if (actionCard == null) {
            kotlin.jvm.internal.j.y("actionCardToBeDisplayed");
            actionCard = null;
        }
        Z2(actionCard);
        ActionCard actionCard3 = this.G;
        if (actionCard3 == null) {
            kotlin.jvm.internal.j.y("actionCardToBeDisplayed");
            actionCard3 = null;
        }
        String action = actionCard3.getAction();
        if (kotlin.jvm.internal.j.b(action, ActionType.BAGEL_PREFS.b())) {
            ((a0) B1()).y();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.DISCOVER.b())) {
            ((a0) B1()).n();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.DISCOVER_SEARCH.b())) {
            ((a0) B1()).o();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.INVITE_FRIENDS.b())) {
            ((a0) B1()).p();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.LIMELIGHT.b())) {
            ((a0) B1()).s();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.PURCHASE_BOOST.b())) {
            V2();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.PURCHASE_BONUS_BAGEL.b())) {
            Q2();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.SUGGEST_PAYWALL_INVENTORY.b())) {
            w2().f("SUGGEST_UNLIMITED_NO_INVENTORY_2", true);
            L2();
        } else if (kotlin.jvm.internal.j.b(action, ActionType.SUGGEST_PAYWALL_UPSELL.b())) {
            j2().n();
            ((a0) B1()).t(new PurchaseSource("suggested out of bagels", "suggested out of bagels"));
        } else {
            ActionCard actionCard4 = this.G;
            if (actionCard4 == null) {
                kotlin.jvm.internal.j.y("actionCardToBeDisplayed");
            } else {
                actionCard2 = actionCard4;
            }
            fa.a.f40771d.c(this.H, "There's no handling for this.", new IllegalStateException("Unexpected action: " + actionCard2.getAction() + " for standard Action Card UI template"));
        }
    }

    public final c6.b k2() {
        c6.b bVar = this.D;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("activityResultStream");
        return null;
    }

    public final a7.a l2() {
        a7.a aVar = this.f37233k;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final b7.c m2() {
        b7.c cVar = this.f37237p;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("analyticsTrackingManager");
        return null;
    }

    public final j n2() {
        j jVar = this.f37240w;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final t7.a o2() {
        t7.a aVar = this.f37241x;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("databaseManager");
        return null;
    }

    public final s9.a p2() {
        s9.a aVar = this.F;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final GetFirstEligibleActionCardUseCase q2() {
        GetFirstEligibleActionCardUseCase getFirstEligibleActionCardUseCase = this.f37242y;
        if (getFirstEligibleActionCardUseCase != null) {
            return getFirstEligibleActionCardUseCase;
        }
        kotlin.jvm.internal.j.y("getActionUseCase");
        return null;
    }

    public final h<Unit> r2() {
        h<Unit> hVar = this.f37238q;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.j.y("getBeansClicks");
        return null;
    }

    public final ProfileContract$Manager s2() {
        ProfileContract$Manager profileContract$Manager = this.f37236n;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final k0 t2() {
        k0 k0Var = this.f37235m;
        if (k0Var != null) {
            return k0Var;
        }
        kotlin.jvm.internal.j.y("purchaseManager");
        return null;
    }

    public final SaveProfilesLocalUseCase u2() {
        SaveProfilesLocalUseCase saveProfilesLocalUseCase = this.E;
        if (saveProfilesLocalUseCase != null) {
            return saveProfilesLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveProfilesLocalUseCase");
        return null;
    }

    public final cb.a v2() {
        cb.a aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("schedulerProvider");
        return null;
    }

    public final c w2() {
        c cVar = this.f37234l;
        if (cVar != null) {
            return cVar;
        }
        kotlin.jvm.internal.j.y("sharedPrefsManager");
        return null;
    }

    public final bb.a x2() {
        bb.a aVar = this.B;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("stringProvider");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        L2();
        ((p) k2().a().g(com.uber.autodispose.a.a(this))).c(new i(new ActionCardInteractor$didBecomeActive$1(this)));
    }

    public final e.a y2() {
        e.a aVar = this.f37239t;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("todayViewMainListener");
        return null;
    }

    public final a z2() {
        a aVar = this.f37243z;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("tracker");
        return null;
    }
}

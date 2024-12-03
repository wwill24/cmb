package com.coffeemeetsbagel.shop.shop;

import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.instagram.a;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.google_play.BillingUserCancelled;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import com.coffeemeetsbagel.shop.shop.o0;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.PurchaseFailureException;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.utils.model.Optional;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import java.util.HashMap;
import java.util.List;
import lc.k;
import p9.d;

public class z extends s<o0, p0> implements o0.a {
    SubscriptionRepository B;
    t C;
    private final PurchaseSource D;

    /* renamed from: f  reason: collision with root package name */
    a7.a f36579f;

    /* renamed from: g  reason: collision with root package name */
    jb.c f36580g;

    /* renamed from: h  reason: collision with root package name */
    b6.d f36581h;

    /* renamed from: j  reason: collision with root package name */
    k f36582j;

    /* renamed from: k  reason: collision with root package name */
    ProfileManager f36583k;

    /* renamed from: l  reason: collision with root package name */
    PurchaseManager f36584l;

    /* renamed from: m  reason: collision with root package name */
    p9.d f36585m;

    /* renamed from: n  reason: collision with root package name */
    com.coffeemeetsbagel.feature.instagram.c f36586n;

    /* renamed from: p  reason: collision with root package name */
    UserRepository f36587p;

    /* renamed from: q  reason: collision with root package name */
    GetPlayAvailabilityUseCase f36588q;

    /* renamed from: t  reason: collision with root package name */
    wb.c f36589t;

    /* renamed from: w  reason: collision with root package name */
    GetSubscriptionBundlesUseCase f36590w;

    /* renamed from: x  reason: collision with root package name */
    BuyBeansUseCase f36591x;

    /* renamed from: y  reason: collision with root package name */
    BuySubscriptionUseCase f36592y;

    /* renamed from: z  reason: collision with root package name */
    s9.a f36593z;

    class a implements d.a {
        a() {
        }

        public void a(ResponseSocialMedia responseSocialMedia) {
            z.this.c2(responseSocialMedia);
        }

        public void onFailure() {
            ((o0) z.this.f7875e).e0();
        }
    }

    class b implements d.a {
        b() {
        }

        public void a(ResponseSocialMedia responseSocialMedia) {
            z.this.c2(responseSocialMedia);
        }

        public void onFailure() {
            ((o0) z.this.f7875e).e0();
        }
    }

    class c implements a.C0137a {
        c() {
        }

        public void a() {
            ((o0) z.this.f7875e).e0();
        }

        public void b(ResponseSocialMedia responseSocialMedia) {
            HashMap hashMap = new HashMap();
            int beansEarned = responseSocialMedia.getBeansEarned();
            hashMap.put("beans", String.valueOf(beansEarned));
            hashMap.put(FirebaseAnalytics.Param.METHOD, "instagram follow");
            z.this.f36583k.t0(beansEarned, (v8.a) null);
            if (beansEarned == 0) {
                ((o0) z.this.f7875e).U();
            } else {
                ((o0) z.this.f7875e).f0(beansEarned);
            }
            z.this.f36579f.j("Beans Earned", hashMap);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36597a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f36598b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase$BillingAvailabilityStatus[] r0 = com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase.BillingAvailabilityStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36598b = r0
                r1 = 1
                com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase$BillingAvailabilityStatus r2 = com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase.BillingAvailabilityStatus.PLAY_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f36598b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase$BillingAvailabilityStatus r3 = com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase.BillingAvailabilityStatus.SKU_DETAILS_UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f36598b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase$BillingAvailabilityStatus r4 = com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase.BillingAvailabilityStatus.AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.coffeemeetsbagel.models.enums.RewardType[] r3 = com.coffeemeetsbagel.models.enums.RewardType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f36597a = r3
                com.coffeemeetsbagel.models.enums.RewardType r4 = com.coffeemeetsbagel.models.enums.RewardType.FOLLOW_TWITTER     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f36597a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.coffeemeetsbagel.models.enums.RewardType r3 = com.coffeemeetsbagel.models.enums.RewardType.TWEET     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f36597a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.coffeemeetsbagel.models.enums.RewardType r1 = com.coffeemeetsbagel.models.enums.RewardType.FOLLOW_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f36597a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.coffeemeetsbagel.models.enums.RewardType r1 = com.coffeemeetsbagel.models.enums.RewardType.INVITE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.shop.shop.z.d.<clinit>():void");
        }
    }

    public z(PurchaseSource purchaseSource) {
        this.D = purchaseSource;
    }

    private void A2() {
        ((n) this.f36590w.l("").a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new t(this), new u());
    }

    /* access modifiers changed from: private */
    public void c2(ResponseSocialMedia responseSocialMedia) {
        HashMap hashMap = new HashMap();
        int beansEarned = responseSocialMedia.getBeansEarned();
        hashMap.put("beans", String.valueOf(beansEarned));
        if (responseSocialMedia.getRewardType() == RewardType.FOLLOW_TWITTER) {
            hashMap.put(FirebaseAnalytics.Param.METHOD, "twitter follow");
            if (beansEarned == 0) {
                ((o0) this.f7875e).V();
            } else {
                ((o0) this.f7875e).f0(beansEarned);
            }
        } else if (responseSocialMedia.getRewardType() == RewardType.TWEET) {
            hashMap.put(FirebaseAnalytics.Param.METHOD, "tweet");
            if (beansEarned == 0) {
                ((o0) this.f7875e).W();
            } else {
                ((o0) this.f7875e).f0(beansEarned);
            }
        }
        this.f36583k.t0(beansEarned, (v8.a) null);
        this.f36579f.j("Beans Earned", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d2(GetPlayAvailabilityUseCase.BillingAvailabilityStatus billingAvailabilityStatus) throws Exception {
        int i10 = d.f36598b[billingAvailabilityStatus.ordinal()];
        if (i10 == 1) {
            ((o0) this.f7875e).X();
            ((o0) this.f7875e).h0();
            fa.a.g("ShopShopInteractor", "Failed to show shop details.", new Exception("Google Play is not installed."));
        } else if (i10 == 2) {
            ((o0) this.f7875e).Y();
            ((o0) this.f7875e).h0();
            fa.a.g("ShopShopInteractor", "Failed to show shop details.", new Exception("No details for subscription SKUs."));
        } else if (i10 == 3) {
            z2();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e2(tj.b bVar) throws Exception {
        ((o0) this.f7875e).a0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f2() throws Exception {
        ((o0) this.f7875e).B();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g2(String str, Integer num) throws Exception {
        if (num.intValue() > 0) {
            ((o0) this.f7875e).c0(str, num.intValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h2(Throwable th2) throws Exception {
        if (th2 instanceof PurchaseFailureException) {
            ((o0) this.f7875e).b0(((PurchaseFailureException) th2).a());
        }
        this.f36579f.d("Sale Beans Purchase Failed");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i2() throws Exception {
        ((o0) this.f7875e).B();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(tj.b bVar) throws Exception {
        ((o0) this.f7875e).a0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k2() throws Exception {
        ((o0) this.f7875e).i0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l2(Throwable th2) throws Exception {
        if (!(th2 instanceof BillingUserCancelled)) {
            ((o0) this.f7875e).b0(PurchaseFailureType.GENERIC);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m2(c6.a aVar) throws Exception {
        if (aVar.b() == 435345 && aVar.c() == 242) {
            this.f36579f.d("Upsell Error Dialog Shown");
            ((p0) B1()).x();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2(Optional optional) throws Exception {
        if (optional.d()) {
            PurchaseSource purchaseSource = new PurchaseSource("bean shop", "bean shop");
            String str = (String) optional.c();
            if (str.contains("subscription")) {
                ((o0) this.f7875e).a0();
                t2(str, purchaseSource);
                return;
            }
            r2(str, purchaseSource);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2(androidx.core.util.d dVar) throws Exception {
        Integer num = (Integer) dVar.f4736b;
        if (num != null) {
            u2(num.intValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2(GetSubscriptionBundlesUseCase.a aVar) throws Exception {
        x2(aVar.b().g(), aVar.c());
    }

    private void r2(String str, PurchaseSource purchaseSource) {
        ((com.uber.autodispose.t) this.f36591x.n(str, this.f36581h, purchaseSource).E(sj.a.a()).q(new m(this)).s(new n(this)).g(com.uber.autodispose.a.a(this))).b(new o(this, str), new p(this));
    }

    /* access modifiers changed from: private */
    public void s2(c6.a aVar) {
        int b10 = aVar.b();
        if (b10 == 6800) {
            this.f36586n.i(new c());
        } else if (b10 == 7000) {
            this.f36585m.b(new b());
        } else if (b10 == 7001) {
            this.f36585m.d(new a());
        }
    }

    private void t2(String str, PurchaseSource purchaseSource) {
        ((m) this.f36592y.l(str, this.f36581h, purchaseSource, false).z(sj.a.a()).u(new w(this)).t(new x(this)).j(com.uber.autodispose.a.a(this))).f(new y(this), new l(this));
    }

    private void u2(int i10) {
        PurchaseType purchaseType = (PurchaseType) this.f36581h.getIntent().getSerializableExtra(Extra.PURCHASE_TYPE);
        int i11 = 0;
        int intExtra = this.f36581h.getIntent().getIntExtra(Extra.EXPECTED_PRICE, 0);
        Price price = (Price) this.f36581h.getIntent().getSerializableExtra(Extra.PRICE);
        int intExtra2 = this.f36581h.getIntent().getIntExtra(Extra.ITEM_COUNT, 1);
        NetworkProfile j10 = this.f36583k.j();
        if (j10 != null) {
            i11 = (int) j10.getBeans();
        }
        if (purchaseType != null) {
            if (price == null) {
                price = this.f36584l.getPrice(purchaseType);
            }
            Price price2 = price;
            if (price2 != null) {
                int beanCost = price2.getBeanCost(intExtra2);
                if (i10 <= 0) {
                    return;
                }
                if (i11 >= beanCost) {
                    ((p0) B1()).q(i10, purchaseType, price2, intExtra2, intExtra);
                } else if (this.f36581h != null) {
                    ((o0) this.f7875e).g0(i10);
                }
            } else {
                this.f36582j.a(new NullPointerException("FragmentShop price is null while resumeUnlockingFeatureIfOneWasStartedAndHasSufficientBeans"));
                ((o0) this.f7875e).Z();
            }
        }
    }

    private void v2() {
        ((p) this.f36581h.F0().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new v(this));
    }

    private void w2() {
        ((p) this.f36580g.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new r(this));
    }

    private void x2(vb.a aVar, List<vb.c> list) {
        boolean z10;
        if (list.size() >= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        ((o0) this.f7875e).A();
        ((p0) B1()).r();
        ((p0) B1()).s();
        if (z10) {
            ((o0) this.f7875e).Q();
            ((o0) this.f7875e).T(((p0) B1()).w());
        } else {
            if (aVar == null) {
                ((o0) this.f7875e).R(((p0) B1()).v());
            } else {
                ((o0) this.f7875e).P(((p0) B1()).u());
            }
            ((o0) this.f7875e).Q();
        }
        ((o0) this.f7875e).S(this.C.r());
        ((o0) this.f7875e).h0();
    }

    private void y2() {
        ((p) this.f36583k.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s(this));
    }

    public void T0() {
        ((p0) B1()).y(new PurchaseSource("bean shop", "bean shop"));
    }

    public void f0(String str) {
        PurchaseSource purchaseSource = this.D;
        if (purchaseSource == null) {
            purchaseSource = new PurchaseSource("bean shop", "bean shop");
        }
        r2(str, purchaseSource);
    }

    public void j1() {
        ((p0) B1()).t();
    }

    public void q1(RewardType rewardType) {
        int i10 = d.f36597a[rewardType.ordinal()];
        if (i10 == 1) {
            ((p0) B1()).o();
        } else if (i10 == 2) {
            ((p0) B1()).z();
        } else if (i10 != 3) {
            ((p0) B1()).p();
        } else {
            ((p0) B1()).n();
        }
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((com.uber.autodispose.t) this.f36588q.e().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(this));
    }

    public void z2() {
        w2();
        v2();
        y2();
        A2();
        ((p) this.f36581h.F0().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new q(this));
    }
}

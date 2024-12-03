package r6;

import android.os.Bundle;
import b6.s;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.profile.o;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.utils.model.Optional;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import j5.x;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import kotlin.Pair;
import lc.k;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import s6.m;
import v7.a;
import v7.d;

public class u extends s<f0, g0> implements w {
    a6.a B;
    com.coffeemeetsbagel.store.alc.d C;
    private List<GiveTakeBase> D;
    /* access modifiers changed from: private */
    public HashSet<String> E;
    /* access modifiers changed from: private */
    public GiveTake F;
    private Integer G;
    /* access modifiers changed from: private */
    public AutoPurchase H;
    private boolean I;
    private String J;

    /* renamed from: f  reason: collision with root package name */
    v7.d f17330f;

    /* renamed from: g  reason: collision with root package name */
    ActivityMain f17331g;

    /* renamed from: h  reason: collision with root package name */
    t7.a f17332h;

    /* renamed from: j  reason: collision with root package name */
    k0 f17333j;

    /* renamed from: k  reason: collision with root package name */
    j f17334k;

    /* renamed from: l  reason: collision with root package name */
    ProfileContract$Manager f17335l;

    /* renamed from: m  reason: collision with root package name */
    b7.c f17336m;

    /* renamed from: n  reason: collision with root package name */
    a7.a f17337n;

    /* renamed from: p  reason: collision with root package name */
    m1 f17338p;

    /* renamed from: q  reason: collision with root package name */
    k f17339q;

    /* renamed from: t  reason: collision with root package name */
    m.b f17340t;

    /* renamed from: w  reason: collision with root package name */
    l8.h f17341w;

    /* renamed from: x  reason: collision with root package name */
    wb.c f17342x;

    /* renamed from: y  reason: collision with root package name */
    ProfileRepositoryV2 f17343y;

    /* renamed from: z  reason: collision with root package name */
    z f17344z;

    class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GiveTake f17345a;

        a(GiveTake giveTake) {
            this.f17345a = giveTake;
        }

        public void a(String str, int i10) {
            fa.a.f("DiscoverFeedListInteractor", "Could not mark #givetake as shown!");
            u.this.E.remove(this.f17345a.getProfileId());
        }

        public void b(ResponseGeneric responseGeneric) {
            String str;
            if (u.this.f17330f.m(this.f17345a)) {
                str = "infinite scroll";
            } else {
                str = "givetake";
            }
            u.this.O2(str, this.f17345a.getProfileId());
        }
    }

    class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RisingGiveTake f17347a;

        b(RisingGiveTake risingGiveTake) {
            this.f17347a = risingGiveTake;
        }

        public void a(String str, int i10) {
            fa.a.f("DiscoverFeedListInteractor", "Could not mark rising #givetake as shown: " + str);
            u.this.E.remove(this.f17347a.getProfileId());
        }

        public void b(ResponseGeneric responseGeneric) {
            u.this.O2("rising give take", this.f17347a.getProfileId());
        }
    }

    class c implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GiveTake f17349a;

        c(GiveTake giveTake) {
            this.f17349a = giveTake;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            ((f0) u.this.f7875e).t();
            u.this.J2(R.string.error_reactivation);
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            ((f0) u.this.f7875e).t();
            u.this.f17335l.j().setOnHold(false);
            u.this.F = this.f17349a;
            u.this.G2();
        }
    }

    class d implements a0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Price f17351a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTake f17352b;

        d(Price price, GiveTake giveTake) {
            this.f17351a = price;
            this.f17352b = giveTake;
        }

        public void a() {
        }

        public void d() {
        }

        public void e() {
            u.this.B2(this.f17351a, this.f17352b);
        }
    }

    class e implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17354a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RisingGiveTake f17355b;

        e(String str, RisingGiveTake risingGiveTake) {
            this.f17354a = str;
            this.f17355b = risingGiveTake;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ NetworkPhoto d(Photo photo) {
            return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
        }

        public void b(CmbErrorCode cmbErrorCode) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("errorCode=");
            sb2.append(cmbErrorCode.getErrorMessage());
            ((f0) u.this.f7875e).t();
        }

        /* renamed from: e */
        public void a(Void voidR, SuccessStatus successStatus) {
            String str;
            Bagel bagel = (Bagel) u.this.f17332h.a(Extra.BAGEL, h6.b.c(), Extra.PROFILE_ID, this.f17354a);
            if (bagel == null) {
                String str2 = "No bagel was received/created as a result of connecting with a rising giveTake and syncing.Used profile id " + this.f17354a;
                fa.a.f("DiscoverFeedListInteractor", str2);
                u.this.f17339q.a(new IllegalArgumentException(str2));
                u.this.J2(R.string.error_sending_discover_like);
                ((f0) u.this.f7875e).t();
                return;
            }
            u.this.f17341w.l();
            Pair h10 = u.this.f17343y.n(this.f17354a).h();
            NetworkProfile a10 = o.f36130a.a((l) h10.c());
            a10.setPhotos((List) ((List) h10.d()).stream().map(new v()).collect(Collectors.toList()));
            bagel.setProfile(a10);
            String userFirstName = this.f17355b.getProfile().getUserFirstName();
            if (this.f17355b.getProfile().isFemale()) {
                str = ((f0) u.this.f7875e).v(userFirstName);
            } else {
                str = ((f0) u.this.f7875e).w(userFirstName);
            }
            ((f0) u.this.f7875e).t();
            ((f0) u.this.f7875e).T(bagel, str);
        }
    }

    class f implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.b f17357a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17358b;

        f(jc.b bVar, String str) {
            this.f17357a = bVar;
            this.f17358b = str;
        }

        public void a(String str, int i10) {
            u.this.J2(R.string.error_sending_discover_like);
            ((f0) u.this.f7875e).t();
        }

        public void b(ResponseGeneric responseGeneric) {
            u.this.E2();
            u.this.f17338p.b(this.f17357a, false);
            u.this.P2("discover_rising_give_take", "like", "connected", this.f17358b, "liked");
        }
    }

    class g implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f17360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GiveTake f17361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17362c;

        class a implements jc.b<Void> {
            a() {
            }

            public void b(CmbErrorCode cmbErrorCode) {
                ((f0) u.this.f7875e).t();
                u.this.J2(R.string.error_reactivation);
            }

            /* renamed from: c */
            public void a(Void voidR, SuccessStatus successStatus) {
                u.this.f17335l.j().setOnHold(false);
            }
        }

        g(long j10, GiveTake giveTake, boolean z10) {
            this.f17360a = j10;
            this.f17361b = giveTake;
            this.f17362c = z10;
        }

        public void a(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (u.this.f17336m.g()) {
                u.this.f17336m.a("take purchase", currentTimeMillis - this.f17360a, StreamManagement.Failed.ELEMENT);
            }
            if (str == null || !str.equals("NO_MORE_FREE_TAKES")) {
                u.this.J2(R.string.error_sending_discover_like);
                ((f0) u.this.f7875e).t();
                return;
            }
            u.this.J2(R.string.error_free_discover_like_expired);
        }

        public void onSuccess() {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (u.this.f17336m.g()) {
                u.this.f17336m.a("take purchase", currentTimeMillis - this.f17360a, "succeeded");
            }
            if (u.this.f17330f.m(this.f17361b)) {
                str = "discover_infinite_scroll";
            } else if (u.this.f17330f.l(this.f17361b)) {
                str = "discover_search_item";
            } else {
                str = ModelDeeplinkData.VALUE_PAGE_DISCOVER;
            }
            u.this.P2(str, "like", "not connected", this.f17361b.getProfileId(), "none");
            ((f0) u.this.f7875e).t();
            u.this.J2(R.string.discover_like_sent);
            u.this.I2();
            if (this.f17362c) {
                u.this.f17335l.d(new a());
            }
        }
    }

    class h implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GiveTake f17365a;

        h(GiveTake giveTake) {
            this.f17365a = giveTake;
        }

        public void onFailure() {
            fa.a.f("DiscoverFeedListInteractor", "Unable to refresh prices");
        }

        public void onSuccess() {
            u.this.B2(u.this.f17333j.getPrice(PurchaseType.PAID_LIKE), this.f17365a);
            u.this.H = null;
        }
    }

    static /* synthetic */ class i {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17367a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.store.alc.PurchaseType[] r0 = com.coffeemeetsbagel.store.alc.PurchaseType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17367a = r0
                com.coffeemeetsbagel.store.alc.PurchaseType r1 = com.coffeemeetsbagel.store.alc.PurchaseType.PAID_LIKE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17367a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.store.alc.PurchaseType r1 = com.coffeemeetsbagel.store.alc.PurchaseType.DISCOVER_LIKES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r6.u.i.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void B2(Price price, GiveTake giveTake) {
        int beans = (int) this.f17335l.j().getBeans();
        int beanCost = price.getBeanCost(1);
        if (beans >= beanCost) {
            D2(beanCost, giveTake);
            return;
        }
        this.F = giveTake;
        this.H = new AutoPurchase(PurchaseType.PAID_LIKE, 1, price, beanCost, giveTake.getId());
        K2(price);
    }

    private void D2(int i10, GiveTake giveTake) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        if (this.f17330f.c()) {
            str = giveTake.getId();
        } else {
            str = null;
        }
        if (!this.f17330f.c()) {
            str2 = giveTake.getId();
        }
        ((t) this.C.a("PaidLike", i10, 1, str2, str, PurchaseRepository.PurchaseRequestSource.DISCOVER).q(new q(this)).r(new r(this)).s(new s(this)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new t(this, currentTimeMillis, giveTake, i10), new k(this, currentTimeMillis, i10));
    }

    /* access modifiers changed from: private */
    public void E2() {
        Integer num = this.G;
        if (num != null) {
            ((f0) this.f7875e).U(num.intValue());
            this.G = null;
        }
    }

    private void F2() {
        Integer num = this.G;
        if (num != null) {
            ((f0) this.f7875e).V(num.intValue());
            this.G = null;
        }
    }

    /* access modifiers changed from: private */
    public void G2() {
        H2(false, (Price) null);
    }

    /* access modifiers changed from: private */
    public void I2() {
        Integer num = this.G;
        if (num != null) {
            ((f0) this.f7875e).X(num.intValue());
            this.G = null;
        }
    }

    private void L2() {
        ((f0) this.f7875e).Q();
        GiveTake giveTake = this.F;
        if (giveTake != null) {
            this.F = null;
            AutoPurchase autoPurchase = this.H;
            if (autoPurchase != null) {
                int i10 = i.f17367a[autoPurchase.getPurchaseType().ordinal()];
                if (i10 == 1) {
                    this.f17333j.refreshPricesFromApi(new h(giveTake));
                } else if (i10 == 2) {
                    M2(this.f17335l.j().isOnHold(), this.f17333j.getPrice(PurchaseType.DISCOVER_LIKES), giveTake);
                    this.H = null;
                }
            }
        }
    }

    private void N2(String str, boolean z10, long j10) {
        String str2;
        if (z10) {
            str2 = "succeeded";
        } else {
            str2 = StreamManagement.Failed.ELEMENT;
        }
        String str3 = str2;
        if (this.f17336m.g()) {
            this.f17336m.a("take purchase", j10, str3);
        }
        PurchaseType purchaseType = PurchaseType.PAID_LIKE;
        this.f17337n.trackEvent(AFInAppEventType.SPENT_CREDIT, h.a(new Map.Entry[]{new AbstractMap.SimpleEntry(AFInAppEventParameterName.CONTENT_ID, purchaseType.a()), new AbstractMap.SimpleEntry(AFInAppEventParameterName.PRICE, str)}));
        this.f17337n.trackEvent("Purchased Item", h.a(new Map.Entry[]{new AbstractMap.SimpleEntry("item", purchaseType.a()), new AbstractMap.SimpleEntry("beans", str), new AbstractMap.SimpleEntry(FirebaseAnalytics.Param.QUANTITY, String.valueOf(1)), new AbstractMap.SimpleEntry(MamElements.MamResultExtension.ELEMENT, str3)}));
    }

    /* access modifiers changed from: private */
    public void O2(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("bagel_profile_id", str2);
        this.f17337n.trackEvent("Discover Card Seen", hashMap);
    }

    /* access modifiers changed from: private */
    public void P2(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (Objects.equals(str4, this.J)) {
            this.J = null;
            str6 = "discover detail";
        } else {
            str6 = str;
        }
        this.f17344z.b(str6, str2);
        ((t) this.f17342x.a().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new m(this, str2, str, str3, str4, str5));
    }

    private void Q2() {
        List<GiveTakeBase> list = this.D;
        if (list != null) {
            int i10 = 0;
            for (GiveTakeBase next : list) {
                if ((next instanceof RisingGiveTake) && !((RisingGiveTake) next).isShown()) {
                    i10++;
                }
            }
            this.f17331g.i5(i10);
        }
    }

    private boolean m2(List<GiveTakeBase> list) {
        List<GiveTakeBase> list2 = this.D;
        if (list2 == null || list2.size() != list.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!(list.get(i10) instanceof RisingGiveTake) || !(this.D.get(i10) instanceof RisingGiveTake)) {
                if (!(list.get(i10) instanceof GiveTake) || !(this.D.get(i10) instanceof GiveTake) || !list.get(i10).equals(this.D.get(i10))) {
                    return false;
                }
            } else if (!list.get(i10).equals(this.D.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2(x xVar) throws Exception {
        C2(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2(Optional optional) throws Exception {
        L2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2(tj.b bVar) throws Exception {
        ((f0) this.f7875e).a0(R.string.sending_paid_like);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q2(Boolean bool) throws Exception {
        this.f17335l.f();
        this.f17335l.e(new Bundle(), (v8.a) null);
        this.f17333j.refreshPricesFromApi((k0.a) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r2() throws Exception {
        ((f0) this.f7875e).t();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s2(long j10, GiveTake giveTake, int i10, Boolean bool) throws Exception {
        String str;
        long currentTimeMillis = System.currentTimeMillis() - j10;
        if (this.I) {
            this.I = false;
            str = "discover_profile_detail";
        } else if (this.f17330f.m(giveTake)) {
            str = "discover_infinite_scroll";
        } else if (this.f17330f.l(giveTake)) {
            str = "discover_search_item";
        } else {
            str = ModelDeeplinkData.VALUE_PAGE_DISCOVER;
        }
        P2(str, "paidlike", "not connected", giveTake.getProfileId(), "none");
        giveTake.setIsTaken(true);
        this.f17330f.q();
        this.f17330f.f(giveTake);
        J2(R.string.send_flowers_success_message);
        F2();
        N2(String.valueOf(i10), true, currentTimeMillis);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t2(long j10, int i10, Throwable th2) throws Exception {
        long currentTimeMillis = System.currentTimeMillis() - j10;
        J2(R.string.send_flowers_error_message);
        fa.a.g("DiscoverFeedListInteractor", "Unable to purchase flowers", th2);
        N2(String.valueOf(i10), false, currentTimeMillis);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u2(Price price, Optional optional) throws Exception {
        if (optional.d()) {
            ((f0) this.f7875e).Y(price);
        } else {
            H2(true, price);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v2(String str, String str2, String str3, String str4, String str5, Optional optional) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("is_subscriber", String.valueOf(optional.d()));
        hashMap.put("action", str);
        hashMap.put("source", str2);
        hashMap.put("connection state", str3);
        hashMap.put("bagel_profile_id", str4);
        hashMap.put("pair_action", str5);
        this.f17337n.j("Bagel Action", hashMap);
    }

    /* access modifiers changed from: private */
    public void w2(c6.a aVar) {
        GiveTake giveTake;
        int b10 = aVar.b();
        if (b10 != 5400) {
            if (b10 == 9280) {
                C2(true);
            } else if (b10 == 9292) {
                Integer b11 = lc.b.b(aVar);
                Integer a10 = lc.b.a(aVar);
                if (a10 != null && this.D.size() > a10.intValue()) {
                    this.J = this.D.get(a10.intValue()).getProfileId();
                }
                if (!(a10 == null || b11 == null)) {
                    ((f0) this.f7875e).S(a10.intValue(), b11.intValue());
                }
                if (a10 != null && aVar.c() == 64) {
                    t0(a10.intValue());
                }
                if (a10 != null && aVar.c() == 68) {
                    this.I = true;
                    A(a10.intValue());
                }
            }
        } else if (lc.b.c(aVar) && (giveTake = this.F) != null) {
            this.F = null;
            AutoPurchase autoPurchase = this.H;
            if (autoPurchase != null) {
                int i10 = i.f17367a[autoPurchase.getPurchaseType().ordinal()];
                if (i10 == 1) {
                    B2(this.H.getPrice(), giveTake);
                    this.H = null;
                } else if (i10 == 2) {
                    M2(this.f17335l.j().isOnHold(), this.f17333j.getPrice(PurchaseType.DISCOVER_LIKES), giveTake);
                    this.H = null;
                }
            }
        }
    }

    private void x2(GiveTake giveTake) {
        Price price = this.f17333j.getPrice(PurchaseType.PAID_LIKE);
        if (price == null) {
            fa.a.g("DiscoverFeedListInteractor", "No price data for flower fetched", new IllegalStateException("Could not fetch price flower"));
            return;
        }
        int beanCost = price.getBeanCost(1);
        ((f0) this.f7875e).N(new d(price, giveTake), (long) beanCost);
    }

    private void y2(GiveTake giveTake) {
        String str;
        int i10;
        int i11;
        Price price = this.f17333j.getPrice(PurchaseType.DISCOVER_LIKES);
        if (giveTake.isLiked()) {
            fa.a.f("DiscoverFeedListInteractor", "GiveTake already taken");
        } else if (price == null) {
            fa.a.f("DiscoverFeedListInteractor", "No price data for take fetched");
            this.f17339q.a(new IllegalArgumentException("Could not fetch price take"));
        } else {
            boolean z10 = true;
            if (price.getBeanCost(1) != 0) {
                z10 = false;
            }
            if (!z10) {
                str = ((f0) this.f7875e).B(price);
            } else if (!this.f17334k.m().booleanValue()) {
                str = ((f0) this.f7875e).z();
            } else if (price.isUnlimited()) {
                str = ((f0) this.f7875e).C();
            } else {
                str = ((f0) this.f7875e).D(price);
            }
            if (this.f17335l.j().isOnHold()) {
                str = ((f0) this.f7875e).A();
                i11 = R.string.paused_account_discover_like_pop_up_cta;
                i10 = R.string.paused_account_discover_like_pop_up_title;
            } else {
                i11 = R.string.continue_lc;
                i10 = R.string.discover_like;
            }
            ((f0) this.f7875e).O(i10, str, i11, giveTake);
        }
    }

    private void z2(RisingGiveTake risingGiveTake) {
        String profileId = risingGiveTake.getProfileId();
        e eVar = new e(profileId, risingGiveTake);
        ((f0) this.f7875e).Z();
        this.f17330f.k(risingGiveTake, new f(eVar, profileId));
    }

    public void A(int i10) {
        if (this.D != null) {
            this.G = Integer.valueOf(i10);
            boolean a10 = this.B.a("discover_send_flowers_ftue");
            GiveTakeBase giveTakeBase = this.D.get(i10);
            if (giveTakeBase instanceof GiveTake) {
                if (!a10) {
                    x2((GiveTake) giveTakeBase);
                    this.B.b("discover_send_flowers_ftue");
                    return;
                }
                B2(this.f17333j.getPrice(PurchaseType.PAID_LIKE), (GiveTake) giveTakeBase);
            } else if (giveTakeBase instanceof RisingGiveTake) {
                z2((RisingGiveTake) giveTakeBase);
            }
        }
    }

    public void A2() {
        F(0);
    }

    public void C(GiveTake giveTake) {
        boolean z10;
        ((f0) this.f7875e).u();
        k0 k0Var = this.f17333j;
        PurchaseType purchaseType = PurchaseType.DISCOVER_LIKES;
        Price price = k0Var.getPrice(purchaseType);
        int beanCost = price.getBeanCost(1);
        if (beanCost == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int beans = (int) this.f17335l.j().getBeans();
        if (z10 || beans >= price.getBeanCost(1)) {
            M2(this.f17335l.j().isOnHold(), price, giveTake);
            return;
        }
        this.F = giveTake;
        this.H = new AutoPurchase(purchaseType, 1, price, beanCost, giveTake.getId());
        K2(price);
    }

    /* access modifiers changed from: package-private */
    public void C2(boolean z10) {
        if (!z10) {
            ((f0) this.f7875e).I();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f17330f.c()) {
            arrayList.addAll(this.f17330f.s());
        } else {
            arrayList.addAll(this.f17330f.p());
        }
        if (arrayList.isEmpty()) {
            this.f17340t.c();
        } else if (!m2(arrayList)) {
            this.D = arrayList;
            ((f0) this.f7875e).W(arrayList, z10);
            Q2();
        } else {
            ((f0) this.f7875e).Q();
        }
        this.f17340t.b();
    }

    public void F(int i10) {
        List<GiveTakeBase> list = this.D;
        if (list != null && i10 < list.size()) {
            GiveTakeBase giveTakeBase = this.D.get(i10);
            if (this.E.contains(giveTakeBase.getProfileId())) {
                return;
            }
            if (giveTakeBase instanceof GiveTake) {
                GiveTake giveTake = (GiveTake) giveTakeBase;
                if (!giveTake.isShown()) {
                    this.E.add(giveTake.getProfileId());
                    this.f17330f.markGiveTakeAsSeen(giveTake.getProfileId(), new a(giveTake));
                }
            } else if (giveTakeBase instanceof RisingGiveTake) {
                RisingGiveTake risingGiveTake = (RisingGiveTake) giveTakeBase;
                if (!risingGiveTake.isShown()) {
                    this.E.add(risingGiveTake.getProfileId());
                    this.f17330f.markRisingGiveTakeAsSeen(risingGiveTake.getProfileId(), new b(risingGiveTake));
                    risingGiveTake.setShown(true);
                    this.f17332h.i("rising_give_take", risingGiveTake);
                    Q2();
                }
            }
        }
    }

    public void H2(boolean z10, Price price) {
        String str;
        String str2;
        if (this.f17330f.c()) {
            str = "discover_filter";
        } else {
            str = ModelDeeplinkData.VALUE_PAGE_DISCOVER;
        }
        if (price == null || !price.getName().equals("PaidLike")) {
            str2 = "profile take";
        } else {
            str2 = "flower";
        }
        PurchaseSource purchaseSource = new PurchaseSource(str, str2);
        if (!z10) {
            ((g0) B1()).m(purchaseSource);
        } else if (price.getName().equals("PaidLike")) {
            ((g0) B1()).p(purchaseSource, PurchaseType.PAID_LIKE, price);
        } else {
            ((g0) B1()).p(purchaseSource, PurchaseType.DISCOVER_LIKES, price);
        }
    }

    /* access modifiers changed from: package-private */
    public void J2(int i10) {
        this.f17331g.z1(i10);
    }

    /* access modifiers changed from: package-private */
    public void K2(Price price) {
        ((t) this.f17342x.a().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l(this, price));
    }

    /* access modifiers changed from: package-private */
    public void M2(boolean z10, Price price, GiveTake giveTake) {
        ((f0) this.f7875e).a0(R.string.liking_bagel);
        this.f17330f.h(price, giveTake, new g(System.currentTimeMillis(), giveTake, z10));
    }

    public void V(Price price) {
        ((g0) B1()).q(price, ShopComponentActivity.class);
    }

    public void c0(Price price) {
        String str;
        HashMap hashMap = new HashMap();
        if (!price.getName().equals("PaidLike")) {
            str = "profile take";
        } else if (this.I) {
            str = "discover_profile_detail_paidlike";
        } else {
            str = "discover_paidlike";
        }
        hashMap.put("source", str);
        hashMap.put("Destination Flow", "Bean Shop Flow");
        this.f17337n.trackEvent("Not Enough Beans Viewed", hashMap);
    }

    public void d1(NetworkProfile networkProfile, int i10, boolean z10, Integer num) {
        String str;
        boolean z11;
        boolean z12;
        if (this.f17330f.c()) {
            str = "discover_search_item";
        } else if (z10) {
            str = "rising_give_take";
        } else {
            str = "give_take";
        }
        String str2 = str;
        GiveTakeBase giveTakeBase = this.D.get(i10);
        ((f0) this.f7875e).H(i10);
        g0 g0Var = (g0) B1();
        if (giveTakeBase instanceof GiveTake) {
            z12 = ((GiveTake) giveTakeBase).isLiked();
        } else if (((RisingGiveTake) giveTakeBase).getAction() == 1) {
            z11 = true;
            g0Var.o(networkProfile, i10, z10, z11, num, str2);
        } else {
            z12 = false;
        }
        z11 = z12;
        g0Var.o(networkProfile, i10, z10, z11, num, str2);
    }

    public void i1(GiveTake giveTake) {
        this.f17335l.d(new c(giveTake));
    }

    public void r() {
        this.f17330f.r();
    }

    public void s1(Bagel bagel) {
        ((g0) B1()).n(bagel);
    }

    public void t0(int i10) {
        if (this.D != null) {
            this.G = Integer.valueOf(i10);
            GiveTakeBase giveTakeBase = this.D.get(i10);
            if (giveTakeBase instanceof GiveTake) {
                y2((GiveTake) giveTakeBase);
            } else if (giveTakeBase instanceof RisingGiveTake) {
                z2((RisingGiveTake) giveTakeBase);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        this.E = new HashSet<>();
        ((p) this.f17331g.t2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new n(this));
        ((p) this.f17340t.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new o(this));
        ((n) this.f17342x.a().v().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new p(this));
    }
}

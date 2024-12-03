package com.coffeemeetsbagel.instant_like;

import b6.s;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.purchase.AutoPurchase;
import com.coffeemeetsbagel.instant_like.InstantLikeBottomSheetPresenter;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.a;
import com.coffeemeetsbagel.store.k0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qj.b0;
import qj.w;
import r5.b;

public final class InstantLikeBottomSheetInteractor extends s<InstantLikeBottomSheetPresenter, InstantLikeBottomSheetRouter> implements InstantLikeBottomSheetPresenter.c, b.C0201b {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final y f13985f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f13986g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f13987h;

    /* renamed from: j  reason: collision with root package name */
    public k0 f13988j;

    /* renamed from: k  reason: collision with root package name */
    public ProfileContract$Manager f13989k;

    /* renamed from: l  reason: collision with root package name */
    public a f13990l;

    /* renamed from: m  reason: collision with root package name */
    public UpdateBagelLocalUseCase f13991m;

    /* renamed from: n  reason: collision with root package name */
    public j f13992n;

    /* renamed from: p  reason: collision with root package name */
    public com.coffeemeetsbagel.store.alc.b f13993p;

    /* renamed from: q  reason: collision with root package name */
    public c6.b f13994q;

    /* renamed from: t  reason: collision with root package name */
    public d f13995t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final String f13996w = InstantLikeBottomSheetInteractor.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Boolean f13997x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13998y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public AutoPurchase f13999z;

    public InstantLikeBottomSheetInteractor(y yVar, String str, boolean z10) {
        kotlin.jvm.internal.j.g(yVar, "listener");
        kotlin.jvm.internal.j.g(str, "matchId");
        this.f13985f = yVar;
        this.f13986g = str;
        this.f13987h = z10;
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
    public static final b0 C2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    private final void D2() {
        Unit unit;
        AutoPurchase autoPurchase = this.f13999z;
        if (autoPurchase != null) {
            w2(autoPurchase.getMatchId(), autoPurchase.getExpectedPrice(), InstantLikePaymentType.BEANS);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            a.C0491a aVar = fa.a.f40771d;
            String str = this.f13996w;
            kotlin.jvm.internal.j.f(str, "tag");
            aVar.c(str, "", new IllegalStateException("ongoing purchase is null, can't resume purchase"));
        }
    }

    /* access modifiers changed from: private */
    public static final void d2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final w<Long> i2() {
        w<Long> A = w.A(new o(this));
        kotlin.jvm.internal.j.f(A, "fromCallable {\n         …Profile!!.beans\n        }");
        return A;
    }

    /* access modifiers changed from: private */
    public static final Long j2(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        kotlin.jvm.internal.j.g(instantLikeBottomSheetInteractor, "this$0");
        NetworkProfile j10 = instantLikeBottomSheetInteractor.m2().j();
        kotlin.jvm.internal.j.d(j10);
        return Long.valueOf(j10.getBeans());
    }

    private final w<Price> k2() {
        w<Price> A = w.A(new n(this));
        kotlin.jvm.internal.j.f(A, "fromCallable {\n         …INSTANT_LIKE)!!\n        }");
        return A;
    }

    /* access modifiers changed from: private */
    public static final Price l2(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        kotlin.jvm.internal.j.g(instantLikeBottomSheetInteractor, "this$0");
        Price price = instantLikeBottomSheetInteractor.p2().getPrice(PurchaseType.INSTANT_LIKE);
        kotlin.jvm.internal.j.d(price);
        return price;
    }

    /* access modifiers changed from: private */
    public final void s2() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f13996w;
        kotlin.jvm.internal.j.f(str, "tag");
        aVar.a(str, "handleInstantLikeSuccess");
        this.f13987h = false;
        ((InstantLikeBottomSheetRouter) B1()).o();
        this.f13985f.c();
    }

    /* access modifiers changed from: private */
    public final void u2(c6.a aVar) {
        if (aVar.b() == 5400 && -1 == aVar.c()) {
            ((InstantLikeBottomSheetRouter) B1()).r();
            if (this.f13999z != null) {
                D2();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void v2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void w2(String str, int i10, InstantLikePaymentType instantLikePaymentType) {
        ((t) com.coffeemeetsbagel.store.alc.b.b(o2(), "InstantLike", (long) i10, 1, str, (PurchaseRepository.PurchaseRequestSource) null, 16, (Object) null).q(new p(new InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$1(this))).v(new q(new InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$2(this))).r(new r(new InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$3(this))).E(sj.a.a()).s(new s(this)).g(com.uber.autodispose.a.a(this))).b(new t(new InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$5(this, i10, instantLikePaymentType)), new j(new InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$6(this, i10, instantLikePaymentType)));
    }

    /* access modifiers changed from: private */
    public static final void x2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y2(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        kotlin.jvm.internal.j.g(instantLikeBottomSheetInteractor, "this$0");
        instantLikeBottomSheetInteractor.f13998y = true;
        ((InstantLikeBottomSheetPresenter) instantLikeBottomSheetInteractor.f7875e).v(false);
    }

    /* access modifiers changed from: private */
    public static final void z2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final c6.b g2() {
        c6.b bVar = this.f13994q;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("activityResultStream");
        return null;
    }

    public void h() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f13996w;
        kotlin.jvm.internal.j.f(str, "tag");
        aVar.a(str, "onInstantLikeCancelled");
        ((InstantLikeBottomSheetRouter) B1()).o();
    }

    public final j h2() {
        j jVar = this.f13992n;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public void k1(Price price, String str, String str2) {
        kotlin.jvm.internal.j.g(price, FirebaseAnalytics.Param.PRICE);
        kotlin.jvm.internal.j.g(str, "matchId");
        kotlin.jvm.internal.j.g(str2, "comment");
        if (price.getFreeItemCount() > 0) {
            w2(str, price.getBeans(), InstantLikePaymentType.GRANT);
        } else {
            ((t) i2().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new InstantLikeBottomSheetInteractor$onInstantLikeInitiated$1(price, this, str)));
        }
    }

    public void l1() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f13996w;
        kotlin.jvm.internal.j.f(str, "tag");
        aVar.a(str, "onBottomSheetDismissed");
        if (this.f13997x == null) {
            String str2 = this.f13996w;
            kotlin.jvm.internal.j.f(str2, "tag");
            aVar.c(str2, "", new IllegalStateException("hasSufficientFunds has not been set"));
        }
        r2().b(this.f13987h, this.f13997x);
        if (this.f13987h) {
            this.f13985f.b();
        } else {
            this.f13985f.h();
        }
    }

    public final ProfileContract$Manager m2() {
        ProfileContract$Manager profileContract$Manager = this.f13989k;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.a n2() {
        com.coffeemeetsbagel.store.alc.a aVar = this.f13990l;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("purchaseAnalytics");
        return null;
    }

    public final com.coffeemeetsbagel.store.alc.b o2() {
        com.coffeemeetsbagel.store.alc.b bVar = this.f13993p;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("purchaseItemForBagelUseCase");
        return null;
    }

    public final k0 p2() {
        k0 k0Var = this.f13988j;
        if (k0Var != null) {
            return k0Var;
        }
        kotlin.jvm.internal.j.y("purchaseManager");
        return null;
    }

    public final UpdateBagelLocalUseCase q2() {
        UpdateBagelLocalUseCase updateBagelLocalUseCase = this.f13991m;
        if (updateBagelLocalUseCase != null) {
            return updateBagelLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveBagelUseCase");
        return null;
    }

    public final d r2() {
        d dVar = this.f13995t;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("tracker");
        return null;
    }

    public final void t2() {
        r2().e();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((p) g2().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i(new InstantLikeBottomSheetInteractor$didBecomeActive$1(this)));
        ((t) ck.b.f24947a.a(k2(), i2()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new l(new InstantLikeBottomSheetInteractor$didBecomeActive$2(this)), new m(new InstantLikeBottomSheetInteractor$didBecomeActive$3(this)));
    }
}

package com.coffeemeetsbagel.subscription_dialog.dialog;

import androidx.appcompat.app.c;
import b6.s;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.google_play.BillingUserCancelled;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.PurchaseFailureException;
import com.coffeemeetsbagel.store.PurchaseFailureType;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.subscription_dialog.dialog.v;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.n;
import com.facebook.internal.ServerProtocol;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import io.reactivex.BackpressureStrategy;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import s9.a;
import vb.d;

public final class SubscriptionDialogInteractor extends s<v, w> {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final y f37029f;

    /* renamed from: g  reason: collision with root package name */
    public BuySubscriptionUseCase f37030g;

    /* renamed from: h  reason: collision with root package name */
    public SubscriptionRepository f37031h;

    /* renamed from: j  reason: collision with root package name */
    public c f37032j;

    /* renamed from: k  reason: collision with root package name */
    public a f37033k;

    /* renamed from: l  reason: collision with root package name */
    public UserRepository f37034l;

    /* renamed from: m  reason: collision with root package name */
    public n f37035m;

    /* renamed from: n  reason: collision with root package name */
    public a7.a f37036n;

    /* renamed from: p  reason: collision with root package name */
    public GetMyOwnProfileLocalUseCase f37037p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public d f37038q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final String f37039t;

    /* renamed from: w  reason: collision with root package name */
    private final HashMap<String, String> f37040w = new HashMap<>();

    public SubscriptionDialogInteractor(y yVar) {
        this.f37029f = yVar;
        String simpleName = SubscriptionDialogInteractor.class.getSimpleName();
        j.f(simpleName, "this::class.java.simpleName");
        this.f37039t = simpleName;
    }

    private final void V1() {
        ((t) c2().c().L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new l(new SubscriptionDialogInteractor$celebrate$1(this)), new m(new SubscriptionDialogInteractor$celebrate$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void W1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Y1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void f2(Throwable th2) {
        ((v) this.f7875e).o();
        if (th2 instanceof BillingUserCancelled) {
            ((w) B1()).o(PurchaseFailureType.USER_CANCEL);
            y yVar = this.f37029f;
            if (yVar != null) {
                yVar.onCancel();
            }
        } else if (th2 instanceof PurchaseFailureException) {
            ((w) B1()).o(((PurchaseFailureException) th2).a());
            y yVar2 = this.f37029f;
            if (yVar2 != null) {
                yVar2.onFailure();
            }
        } else {
            ((w) B1()).o(PurchaseFailureType.GENERIC);
            y yVar3 = this.f37029f;
            if (yVar3 != null) {
                yVar3.onFailure();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g2() {
        ((v) this.f7875e).o();
        V1();
        y yVar = this.f37029f;
        if (yVar != null) {
            yVar.onSuccess();
        }
        ((m) d2().C0(true).F(dk.a.c()).j(com.uber.autodispose.a.a(this))).d();
    }

    private final v.a h2(PurchaseSource purchaseSource, boolean z10, PurchaseType purchaseType, Price price) {
        return new SubscriptionDialogInteractor$setupPresenterListener$1(this, purchaseSource, z10, purchaseType, price);
    }

    /* access modifiers changed from: private */
    public static final void j2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void l2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void m2() {
        a2().trackEvent("Purchase Subscription Prompt Viewed", this.f37040w);
    }

    private final void n2(PurchaseSource purchaseSource, PurchaseType purchaseType, boolean z10) {
        String str;
        this.f37040w.put("screen source", purchaseSource.c());
        this.f37040w.put("feature source", purchaseSource.a());
        HashMap<String, String> hashMap = this.f37040w;
        if (z10) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        hashMap.put("From OOB Flow", str);
    }

    public final c Z1() {
        c cVar = this.f37032j;
        if (cVar != null) {
            return cVar;
        }
        j.y("activity");
        return null;
    }

    public final a7.a a2() {
        a7.a aVar = this.f37036n;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final BuySubscriptionUseCase b2() {
        BuySubscriptionUseCase buySubscriptionUseCase = this.f37030g;
        if (buySubscriptionUseCase != null) {
            return buySubscriptionUseCase;
        }
        j.y("buySubscriptionUseCase");
        return null;
    }

    public final GetMyOwnProfileLocalUseCase c2() {
        GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase = this.f37037p;
        if (getMyOwnProfileLocalUseCase != null) {
            return getMyOwnProfileLocalUseCase;
        }
        j.y("getMyOwnProfileUseCase");
        return null;
    }

    public final SubscriptionRepository d2() {
        SubscriptionRepository subscriptionRepository = this.f37031h;
        if (subscriptionRepository != null) {
            return subscriptionRepository;
        }
        j.y("subscriptionRepository");
        return null;
    }

    public final n e2() {
        n nVar = this.f37035m;
        if (nVar != null) {
            return nVar;
        }
        j.y("variantsRelay");
        return null;
    }

    public final void i2(SubscriptionBenefitAttribution subscriptionBenefitAttribution, PurchaseSource purchaseSource, PurchaseType purchaseType, boolean z10, Price price) {
        j.g(subscriptionBenefitAttribution, "topBenefit");
        j.g(purchaseSource, "purchaseSource");
        if (((v) this.f7875e).p()) {
            fa.a.f40771d.a(this.f37039t, "Dialog was already showing.");
            return;
        }
        n2(purchaseSource, purchaseType, z10);
        v.a h22 = h2(purchaseSource, z10, purchaseType, price);
        ((w) B1()).m(((x) ((v) this.f7875e).g()).getBenefitsContainer(), subscriptionBenefitAttribution);
        if (z10) {
            ((v) this.f7875e).A();
        }
        ((p) e2().e().m0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i(new SubscriptionDialogInteractor$showDialog$1(this)));
        ((w) B1()).n(((x) ((v) this.f7875e).g()).getVariantsContainer());
        ((t) e2().d().v0(BackpressureStrategy.DROP).a0(sj.a.a()).L().g(com.uber.autodispose.a.a(this))).b(new j(new SubscriptionDialogInteractor$showDialog$2(this, h22)), new k(new SubscriptionDialogInteractor$showDialog$3(this)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((p) e2().f().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new SubscriptionDialogInteractor$didBecomeActive$1(this)));
    }
}

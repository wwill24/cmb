package com.coffeemeetsbagel.store;

import android.app.Activity;
import android.os.Bundle;
import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SkuDetailsRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.BeansPurchaseRequest;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.transport.SuccessStatus;
import fa.a;
import gk.h;
import jc.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.c;
import qj.b0;
import qj.w;
import retrofit2.r;

public final class BuyBeansUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SkuDetailsRepository f36673a;

    /* renamed from: b  reason: collision with root package name */
    private final ProfileManager f36674b;

    /* renamed from: c  reason: collision with root package name */
    private final m1 f36675c;

    /* renamed from: d  reason: collision with root package name */
    private final c f36676d;

    /* renamed from: e  reason: collision with root package name */
    private final a7.a f36677e;

    /* renamed from: f  reason: collision with root package name */
    private final String f36678f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TrackingStep f36679g = TrackingStep.PURCHASE_PROCESS_STARTED;

    private enum TrackingStep {
        PURCHASE_PROCESS_STARTED("started"),
        GOOGLE_PLAY_TRIGGERED("google play triggered"),
        GOOGLE_PLAY_CANCELLED("google play cancelled"),
        SENDING_RECEIPT("sending receipt"),
        SENDING_CONSUME("consuming"),
        CONSUME_SUCCESS("consume success");
        
        private final String trackingString;

        private TrackingStep(String str) {
            this.trackingString = str;
        }

        public final String b() {
            return this.trackingString;
        }
    }

    public static final class a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BuyBeansUseCase f36687a;

        a(BuyBeansUseCase buyBeansUseCase) {
            this.f36687a = buyBeansUseCase;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f36687a.m();
            aVar.b(m10, "Sync failure: " + cmbErrorCode + ".");
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            fa.a.f40771d.a(this.f36687a.m(), "Sync complete.");
        }
    }

    public BuyBeansUseCase(SkuDetailsRepository skuDetailsRepository, ProfileManager profileManager, m1 m1Var, c cVar, a7.a aVar) {
        j.g(skuDetailsRepository, "skuDetailsRepository");
        j.g(profileManager, "profileManager");
        j.g(m1Var, "syncManager");
        j.g(cVar, "beansService");
        j.g(aVar, "analyticsManager");
        this.f36673a = skuDetailsRepository;
        this.f36674b = profileManager;
        this.f36675c = m1Var;
        this.f36676d = cVar;
        this.f36677e = aVar;
        String simpleName = BuyBeansUseCase.class.getSimpleName();
        j.f(simpleName, "BuyBeansUseCase::class.java.simpleName");
        this.f36678f = simpleName;
    }

    /* access modifiers changed from: private */
    public static final b0 o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 p(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void t(BuyBeansUseCase buyBeansUseCase, String str) {
        j.g(buyBeansUseCase, "this$0");
        j.g(str, "$productSku");
        a.C0491a aVar = fa.a.f40771d;
        String str2 = buyBeansUseCase.f36678f;
        aVar.a(str2, "Completed purchase " + str + ".");
        buyBeansUseCase.v(str);
    }

    /* access modifiers changed from: private */
    public final void u(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(Extra.BEANS_EARNED, i10);
        this.f36674b.e(bundle, (v8.a) null);
        this.f36675c.b(new a(this), false);
    }

    private final void v(String str) {
        this.f36677e.trackEvent("Android ALC Purchase Flow", h0.k(h.a("sku", str), h.a("completed step", this.f36679g.b())));
    }

    /* access modifiers changed from: private */
    public final w<Pair<Integer, Purchase>> w(Purchase purchase) {
        w<Pair<Integer, Purchase>> D = w.A(new i(purchase, this)).D(new j(new BuyBeansUseCase$uploadPurchaseToCmb$2(purchase)));
        j.f(D, "purchase: com.android.bi…      }\n                }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final r x(Purchase purchase, BuyBeansUseCase buyBeansUseCase) {
        j.g(purchase, "$purchase");
        j.g(buyBeansUseCase, "this$0");
        return buyBeansUseCase.f36676d.a(new BeansPurchaseRequest(purchase.a(), purchase.e())).f();
    }

    /* access modifiers changed from: private */
    public static final Pair y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    public final String m() {
        return this.f36678f;
    }

    public final w<Integer> n(String str, Activity activity, PurchaseSource purchaseSource) {
        j.g(str, "productSku");
        j.g(activity, "activity");
        j.g(purchaseSource, "source");
        this.f36679g = TrackingStep.GOOGLE_PLAY_TRIGGERED;
        w<R> o10 = this.f36673a.m(activity, str).v(new c(new BuyBeansUseCase$invoke$1(this))).v(new d(new BuyBeansUseCase$invoke$2(this))).r(new e(new BuyBeansUseCase$invoke$3(this))).K(dk.a.c()).q(new f(new BuyBeansUseCase$invoke$4(this, str))).p(new g(new BuyBeansUseCase$invoke$5(this, str, purchaseSource))).o(new h(this, str));
        j.f(o10, "operator fun invoke(\n   …tSku)\n            }\n    }");
        return o10;
    }
}

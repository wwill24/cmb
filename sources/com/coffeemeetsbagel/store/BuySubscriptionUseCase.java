package com.coffeemeetsbagel.store;

import a7.a;
import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.models.BeansPurchaseRequest;
import com.coffeemeetsbagel.models.responses.ResponseBeansVerification;
import fa.a;
import gk.h;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.c;
import qj.b0;
import qj.f;
import qj.w;
import qj.y;
import retrofit2.r;

public final class BuySubscriptionUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SubscriptionRepository f36688a;

    /* renamed from: b  reason: collision with root package name */
    private final a f36689b;

    /* renamed from: c  reason: collision with root package name */
    private final c f36690c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36691d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TrackingStep f36692e = TrackingStep.SUBSCRIPTION_PROCESS_STARTED;

    private enum TrackingStep {
        SUBSCRIPTION_PROCESS_STARTED("started"),
        GOOGLE_PLAY_TRIGGERED("google play triggered"),
        GOOGLE_PLAY_CANCELLED("google play cancelled"),
        SENDING_RECEIPT("sending receipt"),
        SENDING_ACKNOWLEDGEMENT("acknowledging"),
        ACKNOWLEDGEMENT_SUCCESS("acknowledgement success");
        
        private final String trackingString;

        private TrackingStep(String str) {
            this.trackingString = str;
        }

        public final String b() {
            return this.trackingString;
        }
    }

    public BuySubscriptionUseCase(SubscriptionRepository subscriptionRepository, a aVar, c cVar) {
        j.g(subscriptionRepository, "subscriptionRepository");
        j.g(aVar, "analyticsManager");
        j.g(cVar, "beansService");
        this.f36688a = subscriptionRepository;
        this.f36689b = aVar;
        this.f36690c = cVar;
        String simpleName = BuySubscriptionUseCase.class.getSimpleName();
        j.f(simpleName, "BuySubscriptionUseCase::class.java.simpleName");
        this.f36691d = simpleName;
    }

    /* access modifiers changed from: private */
    public static final b0 m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p(BuySubscriptionUseCase buySubscriptionUseCase, String str, PurchaseSource purchaseSource, boolean z10) {
        j.g(buySubscriptionUseCase, "this$0");
        j.g(str, "$productSku");
        j.g(purchaseSource, "$source");
        buySubscriptionUseCase.f36692e = TrackingStep.ACKNOWLEDGEMENT_SUCCESS;
        a.C0491a aVar = fa.a.f40771d;
        String str2 = buySubscriptionUseCase.f36691d;
        aVar.a(str2, "Completed subscription process: " + str + ".");
        buySubscriptionUseCase.t(purchaseSource, str, z10);
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r(BuySubscriptionUseCase buySubscriptionUseCase, String str) {
        j.g(buySubscriptionUseCase, "this$0");
        j.g(str, "$productSku");
        buySubscriptionUseCase.s(str);
    }

    private final void s(String str) {
        this.f36689b.trackEvent("Android Subscription Flow", h0.k(h.a("sku", str), h.a("completed step", this.f36692e.b())));
    }

    private final void t(PurchaseSource purchaseSource, String str, boolean z10) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("sku", str);
        if (z10) {
            str2 = "New Subscription Flow";
        } else {
            str2 = "Bean Shop Flow";
        }
        hashMap.put("Destination Flow", str2);
        String c10 = purchaseSource.c();
        j.f(c10, "source.screenSource");
        hashMap.put("screen source", c10);
        String a10 = purchaseSource.a();
        j.f(a10, "source.featureSource");
        hashMap.put("feature source", a10);
        this.f36689b.trackEvent("Subscription Purchased", hashMap);
    }

    /* access modifiers changed from: private */
    public final w<Purchase> u(Purchase purchase) {
        this.f36692e = TrackingStep.SENDING_RECEIPT;
        w<Purchase> k10 = w.k(new q(purchase, this));
        j.f(k10, "create { emitter ->\n    …)\n            }\n        }");
        return k10;
    }

    /* access modifiers changed from: private */
    public static final void v(Purchase purchase, BuySubscriptionUseCase buySubscriptionUseCase, y yVar) {
        j.g(purchase, "$purchase");
        j.g(buySubscriptionUseCase, "this$0");
        j.g(yVar, "emitter");
        r<ResponseBeansVerification> f10 = buySubscriptionUseCase.f36690c.a(new BeansPurchaseRequest(purchase.a(), purchase.e())).f();
        if (f10.g()) {
            yVar.onSuccess(purchase);
            return;
        }
        int b10 = f10.b();
        String h10 = f10.h();
        yVar.onError(new Throwable("Failed to upload subscription: [" + b10 + "] " + h10));
    }

    public final String k() {
        return this.f36691d;
    }

    public final qj.a l(String str, Activity activity, PurchaseSource purchaseSource, boolean z10) {
        j.g(str, "productSku");
        j.g(activity, "activity");
        j.g(purchaseSource, "source");
        this.f36692e = TrackingStep.GOOGLE_PLAY_TRIGGERED;
        qj.a p10 = this.f36688a.y0(activity, str).v(new k(new BuySubscriptionUseCase$invoke$1(this))).w(new l(new BuySubscriptionUseCase$invoke$2(this))).F(dk.a.c()).t(new m(new BuySubscriptionUseCase$invoke$3(this, str))).q(new n(this, str, purchaseSource, z10)).r(new o(new BuySubscriptionUseCase$invoke$5(this))).p(new p(this, str));
        j.f(p10, "operator fun invoke(\n   …sku = productSku) }\n    }");
        return p10;
    }
}

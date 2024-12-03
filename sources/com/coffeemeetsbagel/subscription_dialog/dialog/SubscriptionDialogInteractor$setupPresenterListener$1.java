package com.coffeemeetsbagel.subscription_dialog.dialog;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.subscription_dialog.dialog.v;
import com.uber.autodispose.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import sj.a;
import tj.b;
import vb.d;

public final class SubscriptionDialogInteractor$setupPresenterListener$1 implements v.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SubscriptionDialogInteractor f37041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PurchaseSource f37042b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f37043c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ PurchaseType f37044d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Price f37045e;

    SubscriptionDialogInteractor$setupPresenterListener$1(SubscriptionDialogInteractor subscriptionDialogInteractor, PurchaseSource purchaseSource, boolean z10, PurchaseType purchaseType, Price price) {
        this.f37041a = subscriptionDialogInteractor;
        this.f37042b = purchaseSource;
        this.f37043c = z10;
        this.f37044d = purchaseType;
        this.f37045e = price;
    }

    /* access modifiers changed from: private */
    public static final void g(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        j.g(subscriptionDialogInteractor, "this$0");
        subscriptionDialogInteractor.g2();
    }

    /* access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public void a() {
        y N1 = this.f37041a.f37029f;
        if (N1 != null) {
            N1.onCancel();
        }
    }

    public void b() {
        b bVar;
        d O1 = this.f37041a.f37038q;
        if (O1 != null) {
            SubscriptionDialogInteractor subscriptionDialogInteractor = this.f37041a;
            bVar = ((m) subscriptionDialogInteractor.b2().l(O1.h(), subscriptionDialogInteractor.Z1(), this.f37042b, this.f37043c).z(a.a()).j(com.uber.autodispose.a.a(subscriptionDialogInteractor))).f(new n(subscriptionDialogInteractor), new o(new SubscriptionDialogInteractor$setupPresenterListener$1$onSubscribeClicked$1$2(subscriptionDialogInteractor)));
        } else {
            bVar = null;
        }
        if (bVar == null) {
            fa.a.f40771d.b(this.f37041a.f37039t, "Error: no variant selected, but CTA clicked.");
        }
    }

    public void c() {
        if (!(this.f37044d == null || this.f37045e == null)) {
            ((v) this.f37041a.f7875e).o();
            ((w) this.f37041a.B1()).p(this.f37044d, this.f37045e);
        }
        y N1 = this.f37041a.f37029f;
        if (N1 != null) {
            N1.onCancel();
        }
    }

    public void d() {
        ((v) this.f37041a.f7875e).o();
        y N1 = this.f37041a.f37029f;
        if (N1 != null) {
            N1.onCancel();
        }
    }

    public void m() {
        ((w) this.f37041a.B1()).q();
    }
}

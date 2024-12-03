package com.coffeemeetsbagel.google_play;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.i;
import com.android.billingclient.api.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.q;
import qj.s;

final class CmbBillingClient$purchase$1 extends Lambda implements Function1<i, Purchase> {
    final /* synthetic */ o $productDetails;
    final /* synthetic */ CmbBillingClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CmbBillingClient$purchase$1(CmbBillingClient cmbBillingClient, o oVar) {
        super(1);
        this.this$0 = cmbBillingClient;
        this.$productDetails = oVar;
    }

    /* access modifiers changed from: private */
    public static final s e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (s) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* renamed from: d */
    public final Purchase invoke(i iVar) {
        j.g(iVar, "it");
        q D = this.this$0.f13911e.D(new u(AnonymousClass1.f13918a));
        final o oVar = this.$productDetails;
        return (Purchase) D.B(new v(new Function1<Purchase, Boolean>() {
            /* renamed from: a */
            public final Boolean invoke(Purchase purchase) {
                j.g(purchase, "purchase");
                boolean z10 = true;
                if (purchase.c() != 1 || !purchase.b().contains(oVar.b())) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        })).h();
    }
}

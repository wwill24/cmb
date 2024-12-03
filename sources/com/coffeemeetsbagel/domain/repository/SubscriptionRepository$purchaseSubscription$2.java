package com.coffeemeetsbagel.domain.repository;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.o;
import com.coffeemeetsbagel.google_play.BillingError;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import fa.a;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import vb.a;

final class SubscriptionRepository$purchaseSubscription$2 extends Lambda implements Function1<Triple<? extends o, ? extends Optional<a>, ? extends Optional<String>>, b0<? extends Purchase>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$purchaseSubscription$2(SubscriptionRepository subscriptionRepository, Activity activity) {
        super(1);
        this.this$0 = subscriptionRepository;
        this.$activity = activity;
    }

    /* renamed from: a */
    public final b0<? extends Purchase> invoke(Triple<o, ? extends Optional<a>, ? extends Optional<String>> triple) {
        boolean z10;
        j.g(triple, "triple");
        String str = (String) ((Optional) triple.c()).f("");
        if (((Optional) triple.b()).d()) {
            j.f(str, SDKConstants.PARAM_PURCHASE_TOKEN);
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return w.t(new BillingError("Previous Purchase Token is empty - cannot upgrade subscription"));
            }
        }
        a.C0491a aVar = fa.a.f40771d;
        String J = this.this$0.f12436j;
        aVar.a(J, "purchaseSubscription: token=" + str);
        CmbBillingClient D = this.this$0.f12427a;
        Activity activity = this.$activity;
        o a10 = triple.a();
        j.f(a10, "triple.first");
        j.f(str, SDKConstants.PARAM_PURCHASE_TOKEN);
        return D.M(activity, a10, str, this.this$0.S());
    }
}

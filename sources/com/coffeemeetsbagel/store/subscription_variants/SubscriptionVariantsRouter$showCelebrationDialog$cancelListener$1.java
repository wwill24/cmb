package com.coffeemeetsbagel.store.subscription_variants;

import android.content.Intent;
import com.coffeemeetsbagel.store.subscription_variants.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SubscriptionVariantsRouter$showCelebrationDialog$cancelListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SubscriptionVariantsRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionVariantsRouter$showCelebrationDialog$cancelListener$1(SubscriptionVariantsRouter subscriptionVariantsRouter) {
        super(0);
        this.this$0 = subscriptionVariantsRouter;
    }

    public final void invoke() {
        ((d.b) this.this$0.e()).i().setResult(-1, new Intent());
        ((d.b) this.this$0.e()).i().finish();
    }
}

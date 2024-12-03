package com.coffeemeetsbagel.subscription_dialog.dialog;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.d;

final class SubscriptionDialogInteractor$didBecomeActive$1 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$didBecomeActive$1(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
    }

    public final void a(d dVar) {
        this.this$0.f37038q = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((d) obj);
        return Unit.f32013a;
    }
}

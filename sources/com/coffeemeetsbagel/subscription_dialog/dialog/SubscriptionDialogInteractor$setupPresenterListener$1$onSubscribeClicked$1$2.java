package com.coffeemeetsbagel.subscription_dialog.dialog;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionDialogInteractor$setupPresenterListener$1$onSubscribeClicked$1$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$setupPresenterListener$1$onSubscribeClicked$1$2(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
    }

    public final void a(Throwable th2) {
        SubscriptionDialogInteractor subscriptionDialogInteractor = this.this$0;
        j.f(th2, "throwable");
        subscriptionDialogInteractor.f2(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

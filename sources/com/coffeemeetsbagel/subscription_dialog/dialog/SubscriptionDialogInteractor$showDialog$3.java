package com.coffeemeetsbagel.subscription_dialog.dialog;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionDialogInteractor$showDialog$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$showDialog$3(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String Q1 = this.this$0.f37039t;
        j.f(th2, "throwable");
        aVar.c(Q1, "Error loading subscription data.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

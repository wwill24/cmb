package com.coffeemeetsbagel.subscription_dialog.dialog;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SubscriptionDialogInteractor$celebrate$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$celebrate$2(SubscriptionDialogInteractor subscriptionDialogInteractor) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
    }

    public final void a(Throwable th2) {
        a.f40771d.c(this.this$0.f37039t, "Could not read profile from local cache, could not show celebration dialog", new IllegalStateException("Could not read profile from local cache, could not show celebration dialog"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

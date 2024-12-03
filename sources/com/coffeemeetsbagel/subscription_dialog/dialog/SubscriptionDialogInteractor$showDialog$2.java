package com.coffeemeetsbagel.subscription_dialog.dialog;

import com.coffeemeetsbagel.subscription_dialog.dialog.v;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vb.d;

final class SubscriptionDialogInteractor$showDialog$2 extends Lambda implements Function1<List<? extends d>, Unit> {
    final /* synthetic */ v.a $presenterListener;
    final /* synthetic */ SubscriptionDialogInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionDialogInteractor$showDialog$2(SubscriptionDialogInteractor subscriptionDialogInteractor, v.a aVar) {
        super(1);
        this.this$0 = subscriptionDialogInteractor;
        this.$presenterListener = aVar;
    }

    public final void a(List<d> list) {
        ((v) this.this$0.f7875e).r(this.$presenterListener);
        this.this$0.m2();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

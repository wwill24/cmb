package com.coffeemeetsbagel.boost;

import com.coffeemeetsbagel.models.Price;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BoostDialogFragment$onCreate$2 extends Lambda implements Function1<Price, Unit> {
    final /* synthetic */ BoostDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$onCreate$2(BoostDialogFragment boostDialogFragment) {
        super(1);
        this.this$0 = boostDialogFragment;
    }

    public final void a(Price price) {
        a.C0491a aVar = a.f40771d;
        String J0 = this.this$0.f11415b;
        aVar.a(J0, "price changed: " + price);
        if (price == null) {
            aVar.b(this.this$0.f11415b, "User isn't eligible to purchase Boost. We shouldn't be here.");
            this.this$0.dismiss();
            return;
        }
        this.this$0.l1();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Price) obj);
        return Unit.f32013a;
    }
}

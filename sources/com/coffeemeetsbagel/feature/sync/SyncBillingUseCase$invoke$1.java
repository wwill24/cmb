package com.coffeemeetsbagel.feature.sync;

import com.coffeemeetsbagel.bakery.g1;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class SyncBillingUseCase$invoke$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ SyncBillingUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncBillingUseCase$invoke$1(SyncBillingUseCase syncBillingUseCase) {
        super(1);
        this.this$0 = syncBillingUseCase;
    }

    public final void a(b bVar) {
        a.f40771d.a(this.this$0.f13412g, "Starting billing sync.");
        g1.c("billing_sync");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}

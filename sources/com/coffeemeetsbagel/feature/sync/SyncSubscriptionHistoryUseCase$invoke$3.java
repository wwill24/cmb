package com.coffeemeetsbagel.feature.sync;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SyncSubscriptionHistoryUseCase$invoke$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SyncSubscriptionHistoryUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncSubscriptionHistoryUseCase$invoke$3(SyncSubscriptionHistoryUseCase syncSubscriptionHistoryUseCase) {
        super(1);
        this.this$0 = syncSubscriptionHistoryUseCase;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String d10 = this.this$0.f13417c;
        j.f(th2, "throwable");
        aVar.c(d10, "Failed to update subscription history.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

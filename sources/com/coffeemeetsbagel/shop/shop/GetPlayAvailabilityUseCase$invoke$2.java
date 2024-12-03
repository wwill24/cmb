package com.coffeemeetsbagel.shop.shop;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetPlayAvailabilityUseCase$invoke$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ GetPlayAvailabilityUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetPlayAvailabilityUseCase$invoke$2(GetPlayAvailabilityUseCase getPlayAvailabilityUseCase) {
        super(1);
        this.this$0 = getPlayAvailabilityUseCase;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String d10 = this.this$0.f36482a;
        j.f(d10, "tag");
        j.f(th2, "throwable");
        aVar.c(d10, "Timed out waiting on Google Play.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

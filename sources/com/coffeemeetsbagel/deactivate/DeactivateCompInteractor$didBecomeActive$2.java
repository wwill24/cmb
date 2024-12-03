package com.coffeemeetsbagel.deactivate;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DeactivateCompInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ DeactivateCompInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompInteractor$didBecomeActive$2(DeactivateCompInteractor deactivateCompInteractor) {
        super(1);
        this.this$0 = deactivateCompInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String M1 = this.this$0.f11995x;
        j.f(th2, "it");
        aVar.c(M1, "failed to get user or sub status", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

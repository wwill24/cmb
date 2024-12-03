package com.coffeemeetsbagel.new_user_experience.gender;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ GenderInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInteractor$didBecomeActive$2(GenderInteractor genderInteractor) {
        super(1);
        this.this$0 = genderInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String S1 = this.this$0.f34981f;
        j.f(th2, "throwable");
        aVar.c(S1, "Error loading gender question.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

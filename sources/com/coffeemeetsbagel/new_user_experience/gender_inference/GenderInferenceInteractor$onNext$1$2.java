package com.coffeemeetsbagel.new_user_experience.gender_inference;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInferenceInteractor$onNext$1$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ GenderInferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenderInferenceInteractor$onNext$1$2(GenderInferenceInteractor genderInferenceInteractor) {
        super(1);
        this.this$0 = genderInferenceInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String d22 = this.this$0.d2();
        j.f(th2, "throwable");
        aVar.c(d22, "Failed to update gender.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

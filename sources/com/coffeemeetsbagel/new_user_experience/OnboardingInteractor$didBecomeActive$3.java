package com.coffeemeetsbagel.new_user_experience;

import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class OnboardingInteractor$didBecomeActive$3 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ OnboardingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$didBecomeActive$3(OnboardingInteractor onboardingInteractor) {
        super(1);
        this.this$0 = onboardingInteractor;
    }

    public final void a(x xVar) {
        j.g(xVar, "it");
        this.this$0.d2();
        ((v) this.this$0.B1()).s();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}

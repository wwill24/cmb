package com.coffeemeetsbagel.new_user_experience;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class OnboardingInteractor$didBecomeActive$5 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ OnboardingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$didBecomeActive$5(OnboardingInteractor onboardingInteractor) {
        super(1);
        this.this$0 = onboardingInteractor;
    }

    public final void a(a aVar) {
        OnboardingInteractor onboardingInteractor = this.this$0;
        j.f(aVar, "activityResult");
        onboardingInteractor.Y1(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}

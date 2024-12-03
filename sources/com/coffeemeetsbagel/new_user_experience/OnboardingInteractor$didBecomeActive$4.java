package com.coffeemeetsbagel.new_user_experience;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class OnboardingInteractor$didBecomeActive$4 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ OnboardingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$didBecomeActive$4(OnboardingInteractor onboardingInteractor) {
        super(1);
        this.this$0 = onboardingInteractor;
    }

    public final void a(String str) {
        j.g(str, "message");
        ((v) this.this$0.B1()).u(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

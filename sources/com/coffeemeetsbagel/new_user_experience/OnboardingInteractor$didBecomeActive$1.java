package com.coffeemeetsbagel.new_user_experience;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class OnboardingInteractor$didBecomeActive$1 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ OnboardingInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingInteractor$didBecomeActive$1(OnboardingInteractor onboardingInteractor) {
        super(1);
        this.this$0 = onboardingInteractor;
    }

    public final void a(Map<String, String> map) {
        j.g(map, "trackingMap");
        this.this$0.f2(map);
        if (!((v) this.this$0.B1()).q()) {
            ((v) this.this$0.B1()).p();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Map) obj);
        return Unit.f32013a;
    }
}

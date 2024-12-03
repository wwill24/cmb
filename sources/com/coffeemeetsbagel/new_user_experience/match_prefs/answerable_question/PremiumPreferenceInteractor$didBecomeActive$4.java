package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$didBecomeActive$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$didBecomeActive$4(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(Throwable th2) {
        j.f(th2, "it");
        a.f40771d.c(this.this$0.f35233x, "Failed to display Question#" + this.this$0.f35221f, th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

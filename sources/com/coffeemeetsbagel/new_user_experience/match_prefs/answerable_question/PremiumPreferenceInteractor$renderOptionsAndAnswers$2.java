package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$renderOptionsAndAnswers$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$renderOptionsAndAnswers$2(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String Z1 = this.this$0.f35233x;
        j.f(th2, "error");
        aVar.c(Z1, "Failed to display dynamic questions.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

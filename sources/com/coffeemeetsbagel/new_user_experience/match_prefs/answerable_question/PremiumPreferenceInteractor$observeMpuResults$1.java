package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import c6.a;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PremiumPreferenceInteractor$observeMpuResults$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ PremiumPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferenceInteractor$observeMpuResults$1(PremiumPreferenceInteractor premiumPreferenceInteractor) {
        super(1);
        this.this$0 = premiumPreferenceInteractor;
    }

    public final void a(a aVar) {
        if (aVar.b() != 435345) {
            a.C0491a aVar2 = fa.a.f40771d;
            String Z1 = this.this$0.f35233x;
            int b10 = aVar.b();
            aVar2.a(Z1, "Unhandled request code " + b10);
        } else if (aVar.c() == 242) {
            ((w) this.this$0.B1()).n();
            this.this$0.i2().d("Upsell Error Dialog Shown");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((c6.a) obj);
        return Unit.f32013a;
    }
}

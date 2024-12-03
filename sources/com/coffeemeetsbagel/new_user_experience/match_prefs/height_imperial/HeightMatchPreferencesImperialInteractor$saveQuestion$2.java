package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class HeightMatchPreferencesImperialInteractor$saveQuestion$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HeightMatchPreferencesImperialInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightMatchPreferencesImperialInteractor$saveQuestion$2(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
        super(1);
        this.this$0 = heightMatchPreferencesImperialInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String M1 = this.this$0.f35391n;
        j.f(M1, "tag");
        j.f(th2, "throwable");
        aVar.c(M1, "Failed to update height preference. ", th2);
        this.this$0.R1().onError(((m) this.this$0.f7875e).n());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

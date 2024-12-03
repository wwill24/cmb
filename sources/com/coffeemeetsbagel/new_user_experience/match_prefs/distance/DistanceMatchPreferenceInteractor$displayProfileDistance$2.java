package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DistanceMatchPreferenceInteractor$displayProfileDistance$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$displayProfileDistance$2(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String R1 = this.this$0.f35295n;
        j.f(th2, "error");
        aVar.c(R1, "Failed to display distance match preference.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

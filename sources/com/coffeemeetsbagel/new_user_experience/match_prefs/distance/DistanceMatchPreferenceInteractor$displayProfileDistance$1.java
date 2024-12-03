package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import b6.p;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import ja.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DistanceMatchPreferenceInteractor$displayProfileDistance$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$displayProfileDistance$1(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
    }

    public final void a(b bVar) {
        int i10;
        p Q1 = this.this$0.f7875e;
        j.f(Q1, "presenter");
        s sVar = (s) Q1;
        if (bVar.x()) {
            i10 = bVar.q().k();
        } else {
            i10 = bVar.q().l();
        }
        s.q(sVar, Integer.valueOf(i10), bVar.x(), false, (DealbreakerVariant) null, bVar.x(), 12, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}

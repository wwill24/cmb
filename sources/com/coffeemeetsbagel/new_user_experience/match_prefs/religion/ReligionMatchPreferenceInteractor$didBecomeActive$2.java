package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ReligionMatchPreferenceInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final ReligionMatchPreferenceInteractor$didBecomeActive$2 f35464a = new ReligionMatchPreferenceInteractor$didBecomeActive$2();

    ReligionMatchPreferenceInteractor$didBecomeActive$2() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "throwable");
        aVar.c("MatchPrefs", "Unable to fetch resources", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class EthnicityMatchPreferenceInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final EthnicityMatchPreferenceInteractor$didBecomeActive$2 f35337a = new EthnicityMatchPreferenceInteractor$didBecomeActive$2();

    EthnicityMatchPreferenceInteractor$didBecomeActive$2() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "throwable");
        aVar.c("MatchPrefs - Ethnicity", "Unable to fetch resource", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

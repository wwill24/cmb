package com.coffeemeetsbagel.match_view;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$didBecomeActive$4 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final MatchViewInteractor$didBecomeActive$4 f34640a = new MatchViewInteractor$didBecomeActive$4();

    MatchViewInteractor$didBecomeActive$4() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "throwable");
        aVar.c("MatchViewInteractor", "Failed to load Prompts CTA.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

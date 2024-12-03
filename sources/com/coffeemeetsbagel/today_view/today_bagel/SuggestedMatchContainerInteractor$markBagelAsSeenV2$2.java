package com.coffeemeetsbagel.today_view.today_bagel;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$markBagelAsSeenV2$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final SuggestedMatchContainerInteractor$markBagelAsSeenV2$2 f37417a = new SuggestedMatchContainerInteractor$markBagelAsSeenV2$2();

    SuggestedMatchContainerInteractor$markBagelAsSeenV2$2() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "it");
        aVar.c("SuggestedMatchContainerInteractor", "failed to action on bagel: check", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

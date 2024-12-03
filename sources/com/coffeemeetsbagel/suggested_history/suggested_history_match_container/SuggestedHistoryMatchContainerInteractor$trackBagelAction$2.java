package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedHistoryMatchContainerInteractor$trackBagelAction$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final SuggestedHistoryMatchContainerInteractor$trackBagelAction$2 f37189a = new SuggestedHistoryMatchContainerInteractor$trackBagelAction$2();

    SuggestedHistoryMatchContainerInteractor$trackBagelAction$2() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "it");
        aVar.c("SuggestedHistoryMatchContainerInteractor", "Unable to fetch active subscription", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

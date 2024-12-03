package com.coffeemeetsbagel.today_view.today_bagel;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$4 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$4 f37410a = new SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$4();

    SuggestedMatchContainerInteractor$finalizeFreeLikeActionAndRefresh$4() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "error");
        aVar.c("SuggestedMatchContainerInteractor", "Unable to fetch active subscription", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

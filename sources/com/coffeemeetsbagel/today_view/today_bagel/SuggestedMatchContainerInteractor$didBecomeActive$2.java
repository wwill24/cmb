package com.coffeemeetsbagel.today_view.today_bagel;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedMatchContainerInteractor$didBecomeActive$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ SuggestedMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedMatchContainerInteractor$didBecomeActive$2(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
        super(1);
        this.this$0 = suggestedMatchContainerInteractor;
    }

    public final void a(a aVar) {
        j.g(aVar, "activityResult");
        this.this$0.y3(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.new_user_experience.biography;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BiographyInteractor$goForward$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$goForward$2(BiographyInteractor biographyInteractor) {
        super(1);
        this.this$0 = biographyInteractor;
    }

    public final void a(Throwable th2) {
        ((BiographyPresenter) this.this$0.f7875e).B();
        this.this$0.F2().onError(((BiographyPresenter) this.this$0.f7875e).A());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

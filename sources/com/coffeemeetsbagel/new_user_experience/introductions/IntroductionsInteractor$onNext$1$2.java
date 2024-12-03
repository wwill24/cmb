package com.coffeemeetsbagel.new_user_experience.introductions;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class IntroductionsInteractor$onNext$1$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ IntroductionsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntroductionsInteractor$onNext$1$2(IntroductionsInteractor introductionsInteractor) {
        super(1);
        this.this$0 = introductionsInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String simpleName = IntroductionsInteractor.class.getSimpleName();
        j.f(simpleName, "IntroductionsInteractor::class.java.simpleName");
        j.f(th2, "throwable");
        aVar.c(simpleName, "Failed to save name.", th2);
        this.this$0.R1().onError(((IntroductionsPresenter) this.this$0.f7875e).z());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

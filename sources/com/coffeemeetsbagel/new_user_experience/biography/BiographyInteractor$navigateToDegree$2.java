package com.coffeemeetsbagel.new_user_experience.biography;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$navigateToDegree$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$navigateToDegree$2(BiographyInteractor biographyInteractor) {
        super(1);
        this.this$0 = biographyInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String v22 = this.this$0.f34810f;
        j.f(th2, "it");
        aVar.c(v22, "Failed to load degrees.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

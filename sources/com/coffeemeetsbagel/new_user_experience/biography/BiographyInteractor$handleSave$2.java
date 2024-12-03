package com.coffeemeetsbagel.new_user_experience.biography;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BiographyInteractor$handleSave$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ String $source;
    final /* synthetic */ BiographyInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BiographyInteractor$handleSave$2(BiographyInteractor biographyInteractor, String str) {
        super(1);
        this.this$0 = biographyInteractor;
        this.$source = str;
    }

    public final void a(Throwable th2) {
        this.this$0.F2().onError(((BiographyPresenter) this.this$0.f7875e).A());
        j.f(th2, "error");
        a.f40771d.c(this.this$0.f34810f, "Failed to save " + this.$source + " to /answers.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

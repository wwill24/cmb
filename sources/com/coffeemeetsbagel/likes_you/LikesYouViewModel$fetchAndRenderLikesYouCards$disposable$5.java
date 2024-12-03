package com.coffeemeetsbagel.likes_you;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$fetchAndRenderLikesYouCards$disposable$5(LikesYouViewModel likesYouViewModel) {
        super(1);
        this.this$0 = likesYouViewModel;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String I = this.this$0.f34140u;
        j.f(th2, "throwable");
        aVar.c(I, "Problem loading data", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

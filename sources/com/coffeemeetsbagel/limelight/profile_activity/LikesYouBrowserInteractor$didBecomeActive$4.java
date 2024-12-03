package com.coffeemeetsbagel.limelight.profile_activity;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouBrowserInteractor$didBecomeActive$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ LikesYouBrowserInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouBrowserInteractor$didBecomeActive$4(LikesYouBrowserInteractor likesYouBrowserInteractor) {
        super(1);
        this.this$0 = likesYouBrowserInteractor;
    }

    public final void a(Throwable th2) {
        j.f(th2, "it");
        a.f40771d.c("LikesYouProfileContainerInteractor", "failed to fetch cards for group '" + this.this$0.f34392f + "'", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.limelight.profile_activity;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchContainerInteractor$trackAction$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$trackAction$2(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(1);
        this.this$0 = likesYouMatchContainerInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String e22 = this.this$0.f34405k;
        j.f(e22, "tag");
        j.f(th2, "it");
        aVar.c(e22, "Unable to fetch subscriptions", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

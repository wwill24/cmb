package com.coffeemeetsbagel.limelight.profile_activity;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouMatchContainerInteractor$didBecomeActive$3 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$didBecomeActive$3(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(1);
        this.this$0 = likesYouMatchContainerInteractor;
    }

    public final void a(a aVar) {
        j.g(aVar, "activityResult");
        this.this$0.t2(aVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}

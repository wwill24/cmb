package com.coffeemeetsbagel.limelight.profile_activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class LikesYouMatchContainerInteractor$sendPass$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ LikesYouMatchContainerInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouMatchContainerInteractor$sendPass$1(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
        super(1);
        this.this$0 = likesYouMatchContainerInteractor;
    }

    public final void a(b bVar) {
        ((LikesYouProfilePresenter) this.this$0.f7875e).I();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}

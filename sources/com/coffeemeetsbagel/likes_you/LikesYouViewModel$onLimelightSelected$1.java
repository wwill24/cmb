package com.coffeemeetsbagel.likes_you;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LikesYouViewModel$onLimelightSelected$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$onLimelightSelected$1(LikesYouViewModel likesYouViewModel) {
        super(1);
        this.this$0 = likesYouViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f32013a;
    }

    public final void invoke(boolean z10) {
        if (!z10) {
            this.this$0.W().d(Boolean.TRUE);
        }
    }
}

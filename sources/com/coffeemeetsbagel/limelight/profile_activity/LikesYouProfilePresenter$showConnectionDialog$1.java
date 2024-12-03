package com.coffeemeetsbagel.limelight.profile_activity;

import j5.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class LikesYouProfilePresenter$showConnectionDialog$1 extends Lambda implements Function1<x, Unit> {
    final /* synthetic */ String $bagelId;
    final /* synthetic */ LikesYouProfilePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouProfilePresenter$showConnectionDialog$1(LikesYouProfilePresenter likesYouProfilePresenter, String str) {
        super(1);
        this.this$0 = likesYouProfilePresenter;
        this.$bagelId = str;
    }

    public final void a(x xVar) {
        this.this$0.z();
        this.this$0.f34424e.I2(this.$bagelId);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((x) obj);
        return Unit.f32013a;
    }
}

package com.coffeemeetsbagel.like_pass.view;

import ba.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LikePassButtonsCenterDLSView$instantLikeButton$2 extends Lambda implements Function0<InstantLikeFab> {
    final /* synthetic */ LikePassButtonsCenterDLSView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikePassButtonsCenterDLSView$instantLikeButton$2(LikePassButtonsCenterDLSView likePassButtonsCenterDLSView) {
        super(0);
        this.this$0 = likePassButtonsCenterDLSView;
    }

    /* renamed from: a */
    public final InstantLikeFab invoke() {
        return (InstantLikeFab) this.this$0.findViewById(d.button_instant_like);
    }
}

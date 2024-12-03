package com.coffeemeetsbagel.like_pass.view;

import ba.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LikePassButtonsCenterDLSView$sendFlowerButton$2 extends Lambda implements Function0<CustomFabLikeButton> {
    final /* synthetic */ LikePassButtonsCenterDLSView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikePassButtonsCenterDLSView$sendFlowerButton$2(LikePassButtonsCenterDLSView likePassButtonsCenterDLSView) {
        super(0);
        this.this$0 = likePassButtonsCenterDLSView;
    }

    /* renamed from: a */
    public final CustomFabLikeButton invoke() {
        return (CustomFabLikeButton) this.this$0.findViewById(d.button_send_flower);
    }
}

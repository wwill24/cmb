package com.coffeemeetsbagel.like_pass.view;

import ba.d;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class LikePassButtonsCenterDLSView$priceText$2 extends Lambda implements Function0<CmbTextView> {
    final /* synthetic */ LikePassButtonsCenterDLSView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikePassButtonsCenterDLSView$priceText$2(LikePassButtonsCenterDLSView likePassButtonsCenterDLSView) {
        super(0);
        this.this$0 = likePassButtonsCenterDLSView;
    }

    /* renamed from: a */
    public final CmbTextView invoke() {
        return (CmbTextView) this.this$0.findViewById(d.price_text);
    }
}

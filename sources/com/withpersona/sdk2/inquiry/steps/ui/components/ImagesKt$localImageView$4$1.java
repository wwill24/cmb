package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.view.ViewGroup;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.f;

final class ImagesKt$localImageView$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $defaultLocalImageHeight;
    final /* synthetic */ f $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$localImageView$4$1(f fVar, int i10) {
        super(0);
        this.$this_apply = fVar;
        this.$defaultLocalImageHeight = i10;
    }

    public final void invoke() {
        ImageView imageView = this.$this_apply.f33913b;
        j.f(imageView, "imageView");
        int i10 = this.$defaultLocalImageHeight;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i10;
            imageView.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}

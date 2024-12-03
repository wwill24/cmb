package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.widget.ImageView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.f;

final class ImagesKt$remoteImageFromBundledResource$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.RemoteImage $component;
    final /* synthetic */ int $resourceId;
    final /* synthetic */ f $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$remoteImageFromBundledResource$2$1(f fVar, UiComponent.RemoteImage remoteImage, int i10) {
        super(0);
        this.$this_apply = fVar;
        this.$component = remoteImage;
        this.$resourceId = i10;
    }

    public final void invoke() {
        ImageView imageView = this.$this_apply.f33913b;
        j.f(imageView, "imageView");
        ImageStylingKt.c(imageView, this.$component);
        this.$this_apply.f33913b.setImageResource(this.$resourceId);
        this.$this_apply.f33913b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.$this_apply.f33913b.setAdjustViewBounds(true);
    }
}

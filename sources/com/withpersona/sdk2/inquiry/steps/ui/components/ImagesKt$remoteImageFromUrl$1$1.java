package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.widget.ImageView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.f;

final class ImagesKt$remoteImageFromUrl$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.RemoteImage $component;
    final /* synthetic */ f $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$remoteImageFromUrl$1$1(f fVar, UiComponent.RemoteImage remoteImage) {
        super(0);
        this.$this_apply = fVar;
        this.$component = remoteImage;
    }

    public final void invoke() {
        ImageView imageView = this.$this_apply.f33913b;
        j.f(imageView, "imageView");
        ImageStylingKt.c(imageView, this.$component);
        String h10 = this.$component.z().h();
        ImageView imageView2 = this.$this_apply.f33913b;
        j.f(imageView2, "imageView");
        ImagesKt.f(imageView2, h10);
    }
}

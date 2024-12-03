package com.withpersona.sdk2.inquiry.steps.ui.components;

import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.e;

final class ImagesKt$remoteImageFromUrl$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.RemoteImage $component;
    final /* synthetic */ e $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$remoteImageFromUrl$2$1(e eVar, UiComponent.RemoteImage remoteImage) {
        super(0);
        this.$this_apply = eVar;
        this.$component = remoteImage;
    }

    public final void invoke() {
        ThemeableLottieAnimationView themeableLottieAnimationView = this.$this_apply.f33911b;
        j.f(themeableLottieAnimationView, "lottieView");
        ImageStylingKt.c(themeableLottieAnimationView, this.$component);
        this.$this_apply.f33911b.setRepeatMode(1);
        this.$this_apply.f33911b.setRepeatCount(-1);
        this.$this_apply.f33911b.y();
    }
}

package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.widget.ImageView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vi.f;

final class ImagesKt$imagePreview$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.CombinedStepImagePreview $component;
    final /* synthetic */ f $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagesKt$imagePreview$1$1(f fVar, UiComponent.CombinedStepImagePreview combinedStepImagePreview) {
        super(0);
        this.$this_apply = fVar;
        this.$component = combinedStepImagePreview;
    }

    public final void invoke() {
        ImageView imageView = this.$this_apply.f33913b;
        j.f(imageView, "this.imageView");
        ImageStylingKt.a(imageView, this.$component.D());
    }
}

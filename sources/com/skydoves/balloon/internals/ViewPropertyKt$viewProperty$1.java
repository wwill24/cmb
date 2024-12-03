package com.skydoves.balloon.internals;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ViewPropertyKt$viewProperty$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $this_viewProperty;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewPropertyKt$viewProperty$1(View view) {
        super(0);
        this.$this_viewProperty = view;
    }

    public final void invoke() {
        this.$this_viewProperty.invalidate();
    }
}

package com.withpersona.sdk2.inquiry.ui;

import android.graphics.Bitmap;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class UiScreenRunner$updateRendering$16$1$1 extends Lambda implements Function2<Boolean, Bitmap, Unit> {
    final /* synthetic */ UiComponent $component;
    final /* synthetic */ UiScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$updateRendering$16$1$1(UiScreenRunner uiScreenRunner, UiComponent uiComponent) {
        super(2);
        this.this$0 = uiScreenRunner;
        this.$component = uiComponent;
    }

    public final void a(boolean z10, Bitmap bitmap) {
        this.this$0.f29311b.f29596h.getBackButton().setEnabled(true);
        this.this$0.f29311b.f29596h.setImportantForAccessibility(1);
        this.this$0.f29311b.f29599l.setImportantForAccessibility(1);
        if (!z10) {
            ((UiComponent.ESignature) this.$component).h().c(bitmap);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(((Boolean) obj).booleanValue(), (Bitmap) obj2);
        return Unit.f32013a;
    }
}

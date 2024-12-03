package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.l;
import yi.b;
import zi.a;

final class UiScreenRunner$updateRendering$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiWorkflow.c.a $rendering;
    final /* synthetic */ View $view;
    final /* synthetic */ UiScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$updateRendering$6(View view, UiWorkflow.c.a aVar, UiScreenRunner uiScreenRunner) {
        super(0);
        this.$view = view;
        this.$rendering = aVar;
        this.this$0 = uiScreenRunner;
    }

    public final void invoke() {
        UiComponent.SubmitButton submitButton;
        if (a.f34000a.b(this.$view) && (submitButton = (UiComponent.SubmitButton) b.a(this.$rendering.f(), l.b(UiComponent.SubmitButton.class))) != null) {
            this.this$0.f29317h.invoke(submitButton);
        }
    }
}

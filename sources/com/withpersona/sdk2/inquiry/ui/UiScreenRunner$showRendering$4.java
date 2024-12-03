package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class UiScreenRunner$showRendering$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiWorkflow.c.a $rendering;
    final /* synthetic */ UiScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$showRendering$4(UiScreenRunner uiScreenRunner, UiWorkflow.c.a aVar) {
        super(0);
        this.this$0 = uiScreenRunner;
        this.$rendering = aVar;
    }

    public final void invoke() {
        if (!this.this$0.f29313d.f() && !this.this$0.f29314e.k()) {
            if (this.$rendering.b()) {
                this.$rendering.i().invoke();
            } else {
                this.$rendering.j().invoke();
            }
        }
    }
}

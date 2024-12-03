package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class UiScreenRunner$showRendering$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiWorkflow.c.a $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$showRendering$2(UiWorkflow.c.a aVar) {
        super(0);
        this.$rendering = aVar;
    }

    public final void invoke() {
        this.$rendering.i().invoke();
    }
}

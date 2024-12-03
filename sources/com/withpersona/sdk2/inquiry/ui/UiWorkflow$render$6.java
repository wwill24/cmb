package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class UiWorkflow$render$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a $context;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$6(h<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b, ? extends UiWorkflow.c>.a aVar, UiWorkflow uiWorkflow) {
        super(0);
        this.$context = aVar;
        this.this$0 = uiWorkflow;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f29374a, 1, (Object) null));
    }
}

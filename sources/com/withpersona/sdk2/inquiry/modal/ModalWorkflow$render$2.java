package com.withpersona.sdk2.inquiry.modal;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.modal.ModalWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ModalWorkflow$render$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<PropsT, ModalWorkflow.ModalState, OutputT, Object>.a $context;
    final /* synthetic */ ModalWorkflow<PropsT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalWorkflow$render$2(h<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT, ? extends Object>.a aVar, ModalWorkflow<PropsT, OutputT, RenderingT> modalWorkflow) {
        super(0);
        this.$context = aVar;
        this.this$0 = modalWorkflow;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f27006a, 1, (Object) null));
    }
}

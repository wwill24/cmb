package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InquiryWorkflow$wrapSandboxFabScreen$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output, Object>.a $context;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$wrapSandboxFabScreen$1(InquiryWorkflow inquiryWorkflow, h<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output, ? extends Object>.a aVar) {
        super(0);
        this.this$0 = inquiryWorkflow;
        this.$context = aVar;
    }

    public final void invoke() {
        this.this$0.f26240i.d();
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f26272a, 1, (Object) null));
    }
}

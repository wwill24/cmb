package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InquiryInitializingRunner$showRendering$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InquiryWorkflow.b.a $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryInitializingRunner$showRendering$3(InquiryWorkflow.b.a aVar) {
        super(0);
        this.$rendering = aVar;
    }

    public final void invoke() {
        this.$rendering.a().invoke();
    }
}

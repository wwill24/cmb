package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InquiryWorkflow$wrapSandboxFabScreen$2 extends Lambda implements Function0<SandboxFlags.ForcedStatus> {
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$wrapSandboxFabScreen$2(InquiryWorkflow inquiryWorkflow) {
        super(0);
        this.this$0 = inquiryWorkflow;
    }

    /* renamed from: a */
    public final SandboxFlags.ForcedStatus invoke() {
        return this.this$0.f26240i.a();
    }
}

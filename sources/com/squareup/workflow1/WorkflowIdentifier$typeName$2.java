package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ok.a;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
final class WorkflowIdentifier$typeName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ WorkflowIdentifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkflowIdentifier$typeName$2(WorkflowIdentifier workflowIdentifier) {
        super(0);
        this.this$0 = workflowIdentifier;
    }

    /* renamed from: a */
    public final String invoke() {
        return this.this$0.f23066a instanceof c ? a.a((c) this.this$0.f23066a).getName() : this.this$0.f23066a.toString();
    }
}

package com.withpersona.sdk2.inquiry.document;

import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DocumentReviewRunner$showRendering$1$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DocumentWorkflow.d.b $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentReviewRunner$showRendering$1$5(DocumentWorkflow.d.b bVar) {
        super(0);
        this.$rendering = bVar;
    }

    public final void invoke() {
        this.$rendering.j().invoke();
    }
}

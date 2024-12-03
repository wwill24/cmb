package com.withpersona.sdk2.inquiry.document;

import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DocumentLoadingRunner$showRendering$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DocumentWorkflow.d.a $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentLoadingRunner$showRendering$1$1(DocumentWorkflow.d.a aVar) {
        super(0);
        this.$rendering = aVar;
    }

    public final void invoke() {
        this.$rendering.a().invoke();
    }
}

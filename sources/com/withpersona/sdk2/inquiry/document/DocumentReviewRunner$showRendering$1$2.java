package com.withpersona.sdk2.inquiry.document;

import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentReviewRunner$showRendering$1$2 extends Lambda implements Function1<DocumentFile, Unit> {
    final /* synthetic */ DocumentWorkflow.d.b $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentReviewRunner$showRendering$1$2(DocumentWorkflow.d.b bVar) {
        super(1);
        this.$rendering = bVar;
    }

    public final void a(DocumentFile documentFile) {
        j.g(documentFile, "it");
        if (documentFile instanceof DocumentFile.Remote) {
            this.$rendering.l().invoke(documentFile);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((DocumentFile) obj);
        return Unit.f32013a;
    }
}

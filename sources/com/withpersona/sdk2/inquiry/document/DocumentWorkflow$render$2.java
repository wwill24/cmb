package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$2 extends Lambda implements Function1<DocumentLoadWorker.b, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentWorkflow.State $renderState;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$2(DocumentWorkflow documentWorkflow, DocumentWorkflow.State state) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$renderState = state;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentLoadWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof DocumentLoadWorker.b.C0306b) {
            DocumentWorkflow documentWorkflow = this.this$0;
            final DocumentWorkflow.State state = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(DocumentWorkflow.State.ReviewCaptures.k((DocumentWorkflow.State.ReviewCaptures) state, ((DocumentLoadWorker.b.C0306b) bVar).a(), (String) null, (DocumentWorkflow.State.CaptureState) null, DocumentWorkflow.State.UploadState.ReadyToSubmit, (DocumentFile) null, false, false, (String) null, 214, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof DocumentLoadWorker.b.a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new DocumentWorkflow.c.C0301c(((DocumentLoadWorker.b.a) bVar).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

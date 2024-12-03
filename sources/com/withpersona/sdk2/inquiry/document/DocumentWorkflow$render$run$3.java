package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$run$3 extends Lambda implements Function1<DocumentCreateWorker.b, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$3(DocumentWorkflow documentWorkflow) {
        super(1);
        this.this$0 = documentWorkflow;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentCreateWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof DocumentCreateWorker.b.C0303b) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(DocumentWorkflow.State.e((DocumentWorkflow.State) cVar.c(), DocumentWorkflow.State.UploadState.ReadyToSubmit, ((DocumentCreateWorker.b.C0303b) bVar).a(), (List) null, (DocumentFile) null, 12, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (bVar instanceof DocumentCreateWorker.b.a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (!((DocumentCreateWorker.b.a) bVar).a().isRecoverable()) {
                        cVar.d(new DocumentWorkflow.c.C0301c(((DocumentCreateWorker.b.a) bVar).a()));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }
}

package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$run$2 extends Lambda implements Function1<DocumentsSelectWorker.a, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentWorkflow.b $renderProps;
    final /* synthetic */ DocumentWorkflow.State $renderState;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$2(DocumentWorkflow documentWorkflow, DocumentWorkflow.b bVar, DocumentWorkflow.State state) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$renderProps = bVar;
        this.$renderState = state;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentsSelectWorker.a aVar) {
        j.g(aVar, "it");
        if (aVar instanceof DocumentsSelectWorker.a.c) {
            DocumentWorkflow documentWorkflow = this.this$0;
            final DocumentWorkflow.b bVar = this.$renderProps;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new DocumentWorkflow.State.ReviewCaptures(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.h0(((DocumentWorkflow.State) cVar.c()).h(), h.c(((DocumentsSelectWorker.a.c) aVar).a())), bVar.d()), ((DocumentWorkflow.State) cVar.c()).g(), (DocumentWorkflow.State.CaptureState) null, DocumentWorkflow.State.UploadState.UploadFiles, (DocumentFile) null, false, false, (String) null, 244, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (aVar instanceof DocumentsSelectWorker.a.b) {
            final DocumentWorkflow documentWorkflow2 = this.this$0;
            final DocumentWorkflow.b bVar2 = this.$renderProps;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow2, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new DocumentWorkflow.State.ReviewCaptures(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.h0(((DocumentWorkflow.State) cVar.c()).h(), h.c(((DocumentsSelectWorker.a.b) aVar).a())), bVar2.d()), ((DocumentWorkflow.State) cVar.c()).g(), (DocumentWorkflow.State.CaptureState) null, DocumentWorkflow.State.UploadState.UploadFiles, (DocumentFile) null, false, false, documentWorkflow2.f25007b.getString(n.pi2_document_error_unable_to_add_file), 116, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(aVar, DocumentsSelectWorker.a.C0321a.f26944a)) {
            DocumentWorkflow documentWorkflow3 = this.this$0;
            final DocumentWorkflow.State state = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow3, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(state.a(DocumentWorkflow.State.CaptureState.None));
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

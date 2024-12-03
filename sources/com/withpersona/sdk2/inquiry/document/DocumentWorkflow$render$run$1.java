package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentCameraWorker;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$run$1 extends Lambda implements Function1<DocumentCameraWorker.a, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentWorkflow.b $renderProps;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$1(DocumentWorkflow documentWorkflow, DocumentWorkflow.b bVar) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$renderProps = bVar;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentCameraWorker.a aVar) {
        j.g(aVar, "it");
        if (aVar instanceof DocumentCameraWorker.a.b) {
            DocumentWorkflow documentWorkflow = this.this$0;
            final DocumentWorkflow.b bVar = this.$renderProps;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new DocumentWorkflow.State.ReviewCaptures(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.i0(((DocumentWorkflow.State) cVar.c()).h(), new DocumentFile.Local(((DocumentCameraWorker.a.b) aVar).a(), CaptureMethod.MANUAL, 0, 4, (DefaultConstructorMarker) null)), bVar.d()), ((DocumentWorkflow.State) cVar.c()).g(), (DocumentWorkflow.State.CaptureState) null, DocumentWorkflow.State.UploadState.UploadFiles, (DocumentFile) null, false, false, (String) null, 244, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(aVar, DocumentCameraWorker.a.C0299a.f24961a)) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass2.f25127a, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

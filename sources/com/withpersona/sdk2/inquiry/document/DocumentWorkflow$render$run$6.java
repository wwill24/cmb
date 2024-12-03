package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$run$6 extends Lambda implements Function1<DocumentFileDeleteWorker.b, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentFile.Remote $fileToDelete;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$6(DocumentWorkflow documentWorkflow, DocumentFile.Remote remote) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$fileToDelete = remote;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentFileDeleteWorker.b bVar) {
        j.g(bVar, "response");
        DocumentWorkflow documentWorkflow = this.this$0;
        final DocumentFile.Remote remote = this.$fileToDelete;
        return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
            public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                DocumentWorkflow.State.ReviewCaptures reviewCaptures;
                DocumentWorkflow.State.UploadState uploadState;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof DocumentWorkflow.State.ReviewCaptures) {
                    reviewCaptures = (DocumentWorkflow.State.ReviewCaptures) c10;
                } else {
                    reviewCaptures = null;
                }
                DocumentWorkflow.State.ReviewCaptures reviewCaptures2 = reviewCaptures;
                if (reviewCaptures2 != null) {
                    List f02 = CollectionsKt___CollectionsKt.f0(reviewCaptures2.h(), remote);
                    boolean z10 = false;
                    if (!(f02 instanceof Collection) || !f02.isEmpty()) {
                        Iterator it = f02.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((DocumentFile) it.next()) instanceof DocumentFile.Local) {
                                    z10 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (z10) {
                        uploadState = DocumentWorkflow.State.UploadState.UploadFiles;
                    } else {
                        uploadState = DocumentWorkflow.State.UploadState.ReadyToSubmit;
                    }
                    DocumentWorkflow.State.UploadState uploadState2 = uploadState;
                    DocumentFileDeleteWorker.b bVar = bVar;
                    if (bVar instanceof DocumentFileDeleteWorker.b.C0304b) {
                        cVar.e(DocumentWorkflow.State.ReviewCaptures.k(reviewCaptures2, f02, (String) null, (DocumentWorkflow.State.CaptureState) null, uploadState2, (DocumentFile) null, false, false, (String) null, 230, (Object) null));
                    } else if (bVar instanceof DocumentFileDeleteWorker.b.a) {
                        cVar.d(new DocumentWorkflow.c.C0301c(((DocumentFileDeleteWorker.b.a) bVar).a()));
                    }
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}

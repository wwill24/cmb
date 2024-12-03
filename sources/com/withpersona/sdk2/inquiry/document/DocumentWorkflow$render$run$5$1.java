package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$run$5$1 extends Lambda implements Function1<DocumentFileUploadWorker.b, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentFile.Local $document;
    final /* synthetic */ DocumentWorkflow.State $renderState;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$run$5$1(DocumentWorkflow documentWorkflow, DocumentFile.Local local, DocumentWorkflow.State state) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$document = local;
        this.$renderState = state;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final DocumentFileUploadWorker.b bVar) {
        j.g(bVar, "response");
        if (bVar instanceof DocumentFileUploadWorker.b.d) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    DocumentWorkflow.State.UploadState uploadState;
                    j.g(cVar, "$this$action");
                    List<DocumentFile> h10 = ((DocumentWorkflow.State) cVar.c()).h();
                    DocumentFileUploadWorker.b bVar = bVar;
                    ArrayList arrayList = new ArrayList(r.t(h10, 10));
                    for (Object obj : h10) {
                        DocumentFileUploadWorker.b.d dVar = (DocumentFileUploadWorker.b.d) bVar;
                        if (j.b(obj, dVar.b())) {
                            obj = dVar.a();
                        }
                        arrayList.add(obj);
                    }
                    boolean z10 = false;
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
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
                    cVar.e(DocumentWorkflow.State.e((DocumentWorkflow.State) cVar.c(), uploadState, (String) null, arrayList, (DocumentFile) null, 10, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (bVar instanceof DocumentFileUploadWorker.b.c) {
            DocumentWorkflow documentWorkflow = this.this$0;
            final DocumentFile.Local local = this.$document;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    List<DocumentFile> h10 = ((DocumentWorkflow.State) cVar.c()).h();
                    DocumentFile.Local local = local;
                    DocumentFileUploadWorker.b bVar = bVar;
                    ArrayList arrayList = new ArrayList(r.t(h10, 10));
                    for (Object obj : h10) {
                        if ((obj instanceof DocumentFile.Local) && j.b(obj, local)) {
                            obj = DocumentFile.Local.c((DocumentFile.Local) obj, (String) null, (CaptureMethod) null, ((DocumentFileUploadWorker.b.c) bVar).a(), 3, (Object) null);
                        }
                        arrayList.add(obj);
                    }
                    cVar.e(DocumentWorkflow.State.e((DocumentWorkflow.State) cVar.c(), ((DocumentWorkflow.State) cVar.c()).i(), (String) null, arrayList, (DocumentFile) null, 10, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof DocumentFileUploadWorker.b.a) {
            final DocumentWorkflow documentWorkflow2 = this.this$0;
            final DocumentFile.Local local2 = this.$document;
            final DocumentWorkflow.State state = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(documentWorkflow2, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    DocumentWorkflow.State.UploadState uploadState;
                    j.g(cVar, "$this$action");
                    List f02 = CollectionsKt___CollectionsKt.f0(((DocumentWorkflow.State) cVar.c()).h(), local2);
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
                    cVar.e(new DocumentWorkflow.State.ReviewCaptures(f02, state.g(), DocumentWorkflow.State.CaptureState.None, uploadState, (DocumentFile) null, false, false, h.d(((DocumentFileUploadWorker.b.a) bVar).a(), documentWorkflow2.f25007b), 80, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof DocumentFileUploadWorker.b.C0305b) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {
                public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new DocumentWorkflow.c.C0301c(((DocumentFileUploadWorker.b.C0305b) bVar).a()));
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

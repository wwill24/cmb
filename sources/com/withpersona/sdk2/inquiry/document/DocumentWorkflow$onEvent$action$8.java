package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$onEvent$action$8 extends Lambda implements Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit> {
    final /* synthetic */ DocumentWorkflow.a $event;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$onEvent$action$8(DocumentWorkflow.a aVar) {
        super(1);
        this.$event = aVar;
    }

    public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
        j.g(cVar, "$this$action");
        if (cVar.c() instanceof DocumentWorkflow.State.ReviewCaptures) {
            cVar.e(DocumentWorkflow.State.e((DocumentWorkflow.State) cVar.c(), DocumentWorkflow.State.UploadState.DeleteFiles, (String) null, (List) null, ((DocumentWorkflow.a.f) this.$event).a(), 6, (Object) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

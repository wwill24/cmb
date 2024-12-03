package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class DocumentWorkflow$onEvent$action$9 extends Lambda implements Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final DocumentWorkflow$onEvent$action$9 f25124a = new DocumentWorkflow$onEvent$action$9();

    DocumentWorkflow$onEvent$action$9() {
        super(1);
    }

    public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
        j.g(cVar, "$this$action");
        DocumentWorkflow.State state = (DocumentWorkflow.State) cVar.c();
        if (state instanceof DocumentWorkflow.State.ReviewCaptures) {
            cVar.e(DocumentWorkflow.State.ReviewCaptures.k((DocumentWorkflow.State.ReviewCaptures) state, (List) null, (String) null, (DocumentWorkflow.State.CaptureState) null, (DocumentWorkflow.State.UploadState) null, (DocumentFile) null, false, false, (String) null, Opcodes.LAND, (Object) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

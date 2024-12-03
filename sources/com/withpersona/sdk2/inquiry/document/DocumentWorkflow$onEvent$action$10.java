package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$onEvent$action$10 extends Lambda implements Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final DocumentWorkflow$onEvent$action$10 f25117a = new DocumentWorkflow$onEvent$action$10();

    DocumentWorkflow$onEvent$action$10() {
        super(1);
    }

    public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
        j.g(cVar, "$this$action");
        cVar.e(new DocumentWorkflow.State.UploadDocument(((DocumentWorkflow.State) cVar.c()).h(), ((DocumentWorkflow.State) cVar.c()).g(), DocumentWorkflow.State.UploadState.ReadyToSubmit, (String) null, 8, (DefaultConstructorMarker) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

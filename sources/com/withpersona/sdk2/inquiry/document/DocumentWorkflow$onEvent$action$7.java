package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$onEvent$action$7 extends Lambda implements Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final DocumentWorkflow$onEvent$action$7 f25123a = new DocumentWorkflow$onEvent$action$7();

    DocumentWorkflow$onEvent$action$7() {
        super(1);
    }

    public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
        j.g(cVar, "$this$action");
        cVar.e(((DocumentWorkflow.State) cVar.c()).c(false));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

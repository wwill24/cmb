package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflowUtilsKt$goBack$1 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final GovernmentIdWorkflowUtilsKt$goBack$1 f25648a = new GovernmentIdWorkflowUtilsKt$goBack$1();

    GovernmentIdWorkflowUtilsKt$goBack$1() {
        super(1);
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        j.g(cVar, "$this$action");
        GovernmentIdState f10 = ((GovernmentIdState) cVar.c()).f();
        if (f10 != null) {
            f10.k(true);
            cVar.e(f10);
        } else if (((GovernmentIdWorkflow.a) cVar.b()).a()) {
            cVar.d(GovernmentIdWorkflow.b.a.f25632a);
        } else {
            cVar.d(GovernmentIdWorkflow.b.C0310b.f25633a);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

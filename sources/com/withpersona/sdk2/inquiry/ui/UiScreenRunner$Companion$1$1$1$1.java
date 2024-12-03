package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

/* synthetic */ class UiScreenRunner$Companion$1$1$1$1 extends FunctionReferenceImpl implements Function2<UiWorkflow.c.a, p, Unit> {
    UiScreenRunner$Companion$1$1$1$1(Object obj) {
        super(2, obj, UiScreenRunner.class, "showRendering", "showRendering(Lcom/withpersona/sdk2/inquiry/ui/UiWorkflow$Screen$EntryScreen;Lcom/squareup/workflow1/ui/ViewEnvironment;)V", 0);
    }

    public final void c(UiWorkflow.c.a aVar, p pVar) {
        j.g(aVar, "p0");
        j.g(pVar, "p1");
        ((UiScreenRunner) this.receiver).a(aVar, pVar);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        c((UiWorkflow.c.a) obj, (p) obj2);
        return Unit.f32013a;
    }
}

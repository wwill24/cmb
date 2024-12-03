package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a $context;
    final /* synthetic */ UiWorkflow.a $renderProps;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$5(h<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b, ? extends UiWorkflow.c>.a aVar, UiWorkflow uiWorkflow, UiWorkflow.a aVar2) {
        super(0);
        this.$context = aVar;
        this.this$0 = uiWorkflow;
        this.$renderProps = aVar2;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        UiWorkflow uiWorkflow = this.this$0;
        final UiWorkflow.a aVar = this.$renderProps;
        c10.d(Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
            public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.d(aVar.d() ? UiWorkflow.b.c.f29350a : UiWorkflow.b.C0333b.f29349a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}

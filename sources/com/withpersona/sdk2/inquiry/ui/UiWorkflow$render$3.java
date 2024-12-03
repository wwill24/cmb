package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$3 extends Lambda implements Function2<UiComponent, Map<String, ? extends ComponentParam>, Unit> {
    final /* synthetic */ h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a $context;
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$3(h<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b, ? extends UiWorkflow.c>.a aVar, UiWorkflow uiWorkflow, UiState uiState) {
        super(2);
        this.$context = aVar;
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
    }

    public final void a(final UiComponent uiComponent, final Map<String, ? extends ComponentParam> map) {
        j.g(uiComponent, "uiComponent");
        j.g(map, "componentParams");
        f c10 = this.$context.c();
        UiWorkflow uiWorkflow = this.this$0;
        final UiState uiState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
            public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(new UiState.Submitting(((UiState.Displaying) uiState).getComponents(), map, ((UiState.Displaying) uiState).d(), ((UiState.Displaying) uiState).e(), uiComponent, ((UiState.Displaying) uiState).b()));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((UiComponent) obj, (Map) obj2);
        return Unit.f32013a;
    }
}

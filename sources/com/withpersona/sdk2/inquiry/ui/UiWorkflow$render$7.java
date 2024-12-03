package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$7 extends Lambda implements Function2<UiComponent.InputAddress, String, Unit> {
    final /* synthetic */ h<UiWorkflow.a, UiState, UiWorkflow.b, UiWorkflow.c>.a $context;
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$7(h<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b, ? extends UiWorkflow.c>.a aVar, UiWorkflow uiWorkflow, UiState uiState) {
        super(2);
        this.$context = aVar;
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
    }

    public final void a(final UiComponent.InputAddress inputAddress, final String str) {
        j.g(inputAddress, "component");
        j.g(str, "addressId");
        f c10 = this.$context.c();
        final UiWorkflow uiWorkflow = this.this$0;
        final UiState uiState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
            public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                UiState uiState = uiState;
                UiWorkflow uiWorkflow = uiWorkflow;
                List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                UiComponent.InputAddress inputAddress = inputAddress;
                cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, inputAddress, inputAddress.R(str).O(Boolean.TRUE)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((UiComponent.InputAddress) obj, (String) obj2);
        return Unit.f32013a;
    }
}

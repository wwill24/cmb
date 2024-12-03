package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressDetailsWorker;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$1$2$1 extends Lambda implements Function1<UiAddressDetailsWorker.b, l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>> {
    final /* synthetic */ UiComponent.InputAddress $it;
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$1$2$1(UiWorkflow uiWorkflow, UiState uiState, UiComponent.InputAddress inputAddress) {
        super(1);
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
        this.$it = inputAddress;
    }

    /* renamed from: a */
    public final l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final UiAddressDetailsWorker.b bVar) {
        j.g(bVar, "response");
        if (bVar instanceof UiAddressDetailsWorker.b.C0335b) {
            final UiWorkflow uiWorkflow = this.this$0;
            final UiState uiState = this.$renderState;
            final UiComponent.InputAddress inputAddress = this.$it;
            return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    UiState uiState = uiState;
                    UiState.Displaying displaying = (UiState.Displaying) uiState;
                    UiWorkflow uiWorkflow = uiWorkflow;
                    List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                    UiComponent.InputAddress inputAddress = inputAddress;
                    UiComponent.InputAddress u10 = inputAddress.u(((UiAddressDetailsWorker.b.C0335b) bVar).a().e());
                    String f10 = ((UiAddressDetailsWorker.b.C0335b) bVar).a().f();
                    if (f10 == null) {
                        f10 = "";
                    }
                    cVar.e(UiState.Displaying.c(displaying, uiWorkflow.m(components, inputAddress, u10.i(f10).m(((UiAddressDetailsWorker.b.C0335b) bVar).a().b()).x(((UiAddressDetailsWorker.b.C0335b) bVar).a().g()).s(((UiAddressDetailsWorker.b.C0335b) bVar).a().d()).R((String) null).O(Boolean.FALSE)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiAddressDetailsWorker.b.a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new UiWorkflow.b.d("Couldn't load address.", ((UiAddressDetailsWorker.b.a) bVar).a()));
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

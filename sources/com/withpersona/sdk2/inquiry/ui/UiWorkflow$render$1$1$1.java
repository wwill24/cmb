package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$1$1$1 extends Lambda implements Function1<UiAddressAutocompleteWorker.b, l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>> {
    final /* synthetic */ UiComponent.InputAddress $it;
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$1$1$1(UiWorkflow uiWorkflow, UiState uiState, UiComponent.InputAddress inputAddress) {
        super(1);
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
        this.$it = inputAddress;
    }

    /* renamed from: a */
    public final l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final UiAddressAutocompleteWorker.b bVar) {
        j.g(bVar, "response");
        final UiWorkflow uiWorkflow = this.this$0;
        final UiState uiState = this.$renderState;
        final UiComponent.InputAddress inputAddress = this.$it;
        return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
            public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                final UiAddressAutocompleteWorker.b bVar = bVar;
                if (bVar instanceof UiAddressAutocompleteWorker.b.C0334b) {
                    UiState uiState = uiState;
                    UiWorkflow uiWorkflow = uiWorkflow;
                    List<UiComponent> components = ((UiState.Displaying) uiState).getComponents();
                    UiComponent.InputAddress inputAddress = inputAddress;
                    cVar.e(UiState.Displaying.c((UiState.Displaying) uiState, uiWorkflow.m(components, inputAddress, inputAddress.Q(((UiAddressAutocompleteWorker.b.C0334b) bVar).a()).P((String) null)), (String) null, (List) null, (StepStyles$UiStepStyle) null, (String) null, 30, (Object) null));
                } else if (bVar instanceof UiAddressAutocompleteWorker.b.a) {
                    l unused = Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                        public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                            j.g(cVar, "$this$action");
                            cVar.d(new UiWorkflow.b.d("Failed to get address suggestions.", ((UiAddressAutocompleteWorker.b.a) bVar).a()));
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((l.c) obj);
                            return Unit.f32013a;
                        }
                    }, 1, (Object) null);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}

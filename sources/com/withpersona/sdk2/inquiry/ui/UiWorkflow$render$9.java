package com.withpersona.sdk2.inquiry.ui;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.ui.UiState;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$9 extends Lambda implements Function1<UiTransitionWorker.b, l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>> {
    final /* synthetic */ UiState $renderState;
    final /* synthetic */ UiWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiWorkflow$render$9(UiWorkflow uiWorkflow, UiState uiState) {
        super(1);
        this.this$0 = uiWorkflow;
        this.$renderState = uiState;
    }

    /* renamed from: a */
    public final l<UiWorkflow.a, UiState, UiWorkflow.b> invoke(final UiTransitionWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof UiTransitionWorker.b.a) {
            UiWorkflow uiWorkflow = this.this$0;
            final UiState uiState = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(uiWorkflow, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new UiState.Displaying(((UiState.Submitting) uiState).getComponents(), ((UiState.Submitting) uiState).d(), ((UiTransitionWorker.b.a) bVar).a(), ((UiState.Submitting) uiState).b(), (String) null, 16, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiTransitionWorker.b.C0336b) {
            final UiWorkflow uiWorkflow2 = this.this$0;
            final UiState uiState2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(uiWorkflow2, (String) null, new Function1<l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c, Unit>() {
                public final void a(l<? super UiWorkflow.a, UiState, ? extends UiWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (((UiTransitionWorker.b.C0336b) bVar).a().isRecoverable()) {
                        cVar.e(new UiState.Displaying(((UiState.Submitting) uiState2).getComponents(), ((UiState.Submitting) uiState2).d(), (List) null, ((UiState.Submitting) uiState2).b(), uiWorkflow2.f29336a.getString(j.pi2_network_connection_error), 4, (DefaultConstructorMarker) null));
                    } else {
                        cVar.d(new UiWorkflow.b.d(((UiTransitionWorker.b.C0336b) bVar).b(), ((UiTransitionWorker.b.C0336b) bVar).a()));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiTransitionWorker.b.c) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass3.f29375a, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

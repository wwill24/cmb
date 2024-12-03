package com.withpersona.sdk2.inquiry.modal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.modal.ModalWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ModalWorkflow$render$currentScreen$1 extends Lambda implements Function1<OutputT, l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>> {
    final /* synthetic */ ModalWorkflow<PropsT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalWorkflow$render$currentScreen$1(ModalWorkflow<PropsT, OutputT, RenderingT> modalWorkflow) {
        super(1);
        this.this$0 = modalWorkflow;
    }

    /* renamed from: a */
    public final l<PropsT, ModalWorkflow.ModalState, OutputT> invoke(final OutputT outputt) {
        j.g(outputt, "output");
        if (outputt instanceof a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c, Unit>() {
                public final void a(l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c cVar) {
                    j.g(cVar, "$this$action");
                    OutputT outputt = outputt;
                    cVar.e(new ModalWorkflow.ModalState.ShowingModal(outputt, ((a) outputt).b(), ((a) outputt).getTitle(), ((a) outputt).getMessage(), ((a) outputt).c(), ((a) outputt).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c, Unit>() {
            public final void a(l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.d(outputt);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}

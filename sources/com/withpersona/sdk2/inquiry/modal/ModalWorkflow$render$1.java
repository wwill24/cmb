package com.withpersona.sdk2.inquiry.modal;

import android.os.Parcelable;
import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.modal.ModalWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ModalWorkflow$render$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<PropsT, ModalWorkflow.ModalState, OutputT, Object>.a $context;
    final /* synthetic */ ModalWorkflow.ModalState $renderState;
    final /* synthetic */ ModalWorkflow<PropsT, OutputT, RenderingT> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalWorkflow$render$1(h<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT, ? extends Object>.a aVar, ModalWorkflow<PropsT, OutputT, RenderingT> modalWorkflow, ModalWorkflow.ModalState modalState) {
        super(0);
        this.$context = aVar;
        this.this$0 = modalWorkflow;
        this.$renderState = modalState;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        ModalWorkflow<PropsT, OutputT, RenderingT> modalWorkflow = this.this$0;
        final ModalWorkflow.ModalState modalState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(modalWorkflow, (String) null, new Function1<l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c, Unit>() {
            public final void a(l<? super PropsT, ModalWorkflow.ModalState, ? extends OutputT>.c cVar) {
                j.g(cVar, "$this$action");
                Parcelable d10 = ((ModalWorkflow.ModalState.ShowingModal) modalState).d();
                j.e(d10, "null cannot be cast to non-null type OutputT of com.withpersona.sdk2.inquiry.modal.ModalWorkflow");
                cVar.d(d10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}

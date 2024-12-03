package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderCreateInquirySession$1 extends Lambda implements Function1<CreateInquirySessionWorker.b, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.CreateInquirySession $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderCreateInquirySession$1(InquiryWorkflow inquiryWorkflow, InquiryState.CreateInquirySession createInquirySession) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = createInquirySession;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final CreateInquirySessionWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof CreateInquirySessionWorker.b.C0313b) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.CreateInquirySession createInquirySession = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new InquiryState.ShowLoadingSpinner(((CreateInquirySessionWorker.b.C0313b) bVar).a(), (TransitionStatus) null, createInquirySession.c(), (StepStyle) null, true, 2, (DefaultConstructorMarker) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof CreateInquirySessionWorker.b.a) {
            InquiryWorkflow inquiryWorkflow2 = this.this$0;
            final InquiryState.CreateInquirySession createInquirySession2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow2, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new InquiryWorkflow.Output.Error(createInquirySession2.d(), "There was a problem reaching the server.", ((CreateInquirySessionWorker.b.a) bVar).a()));
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

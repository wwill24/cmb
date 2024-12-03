package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderCreateInquiryFromTemplate$1 extends Lambda implements Function1<CreateInquiryWorker.b, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.CreateInquiryFromTemplate $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderCreateInquiryFromTemplate$1(InquiryWorkflow inquiryWorkflow, InquiryState.CreateInquiryFromTemplate createInquiryFromTemplate) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = createInquiryFromTemplate;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final CreateInquiryWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof CreateInquiryWorker.b.C0314b) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(new InquiryState.CreateInquirySession(((CreateInquiryWorker.b.C0314b) bVar).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (bVar instanceof CreateInquiryWorker.b.a) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.CreateInquiryFromTemplate createInquiryFromTemplate = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    String d10 = createInquiryFromTemplate.d();
                    String b10 = ((CreateInquiryWorker.b.a) bVar).b();
                    if (b10 == null) {
                        b10 = "There was a problem reaching the server.";
                    }
                    cVar.d(new InquiryWorkflow.Output.Error(d10, b10, ((CreateInquiryWorker.b.a) bVar).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }
}

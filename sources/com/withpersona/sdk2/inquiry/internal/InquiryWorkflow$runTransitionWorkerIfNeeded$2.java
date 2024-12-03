package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.TransitionBackWorker;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$runTransitionWorkerIfNeeded$2 extends Lambda implements Function1<TransitionBackWorker.b, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState $renderState;
    final /* synthetic */ String $sessionToken;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$runTransitionWorkerIfNeeded$2(InquiryWorkflow inquiryWorkflow, InquiryState inquiryState, String str) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = inquiryState;
        this.$sessionToken = str;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final TransitionBackWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof TransitionBackWorker.b.C0316b) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    ((TransitionBackWorker.b.C0316b) bVar).a().h(true);
                    cVar.e(((TransitionBackWorker.b.C0316b) bVar).a());
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (bVar instanceof TransitionBackWorker.b.a) {
            final InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState inquiryState = this.$renderState;
            final String str = this.$sessionToken;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (inquiryWorkflow.l(((TransitionBackWorker.b.a) bVar).a())) {
                        InquiryState inquiryState = inquiryState;
                        if (inquiryState instanceof r) {
                            cVar.e(inquiryWorkflow.u((r) inquiryState));
                            return;
                        }
                    }
                    cVar.d(new InquiryWorkflow.Output.Error(str, "There was a problem reaching the server.", ((TransitionBackWorker.b.a) bVar).a()));
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

package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$runTransitionWorkerIfNeeded$1 extends Lambda implements Function1<CheckInquiryWorker.c, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ String $sessionToken;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$runTransitionWorkerIfNeeded$1(InquiryWorkflow inquiryWorkflow, String str) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$sessionToken = str;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final CheckInquiryWorker.c cVar) {
        j.g(cVar, "it");
        if (cVar instanceof CheckInquiryWorker.c.C0312c) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(((CheckInquiryWorker.c.C0312c) cVar).a());
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (cVar instanceof CheckInquiryWorker.c.a) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    String c10 = ((CheckInquiryWorker.c.a) cVar).a().c();
                    String j10 = ((CheckInquiryWorker.c.a) cVar).a().j();
                    j.d(j10);
                    cVar.d(new InquiryWorkflow.Output.Complete(c10, j10, ((CheckInquiryWorker.c.a) cVar).a().i()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        }
        if (cVar instanceof CheckInquiryWorker.c.b) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final String str = this.$sessionToken;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new InquiryWorkflow.Output.Error(str, "There was a problem reaching the server.", ((CheckInquiryWorker.c.b) cVar).a()));
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

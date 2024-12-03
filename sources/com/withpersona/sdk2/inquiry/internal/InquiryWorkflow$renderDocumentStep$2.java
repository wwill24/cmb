package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentPages;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderDocumentStep$2 extends Lambda implements Function1<DocumentWorkflow.c, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.DocumentStepRunning $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderDocumentStep$2(InquiryWorkflow inquiryWorkflow, InquiryState.DocumentStepRunning documentStepRunning) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = documentStepRunning;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final DocumentWorkflow.c cVar) {
        j.g(cVar, "it");
        if (j.b(cVar, DocumentWorkflow.c.b.f25084a)) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.DocumentStepRunning documentStepRunning = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    j.g(cVar, "$this$action");
                    String c10 = documentStepRunning.c();
                    String d10 = documentStepRunning.d();
                    StepStyles$DocumentStepStyle n10 = documentStepRunning.b();
                    NextStep.CancelDialog a10 = documentStepRunning.a();
                    if (a10 != null) {
                        str = a10.e();
                    } else {
                        str = null;
                    }
                    NextStep.CancelDialog a11 = documentStepRunning.a();
                    if (a11 != null) {
                        str2 = a11.d();
                    } else {
                        str2 = null;
                    }
                    NextStep.CancelDialog a12 = documentStepRunning.a();
                    if (a12 != null) {
                        str3 = a12.a();
                    } else {
                        str3 = null;
                    }
                    NextStep.CancelDialog a13 = documentStepRunning.a();
                    if (a13 != null) {
                        str4 = a13.c();
                    } else {
                        str4 = null;
                    }
                    cVar.d(new InquiryWorkflow.Output.Cancel(c10, d10, n10, str, str2, str3, str4));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(cVar, DocumentWorkflow.c.a.f25083a)) {
            InquiryWorkflow inquiryWorkflow2 = this.this$0;
            final InquiryState.DocumentStepRunning documentStepRunning2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow2, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(InquiryState.DocumentStepRunning.j(documentStepRunning2, (String) null, (String) null, TransitionStatus.TransitioningBack, (StepStyles$DocumentStepStyle) null, (NextStep.CancelDialog) null, (NextStep.Document) null, (String) null, (DocumentPages) null, (String) null, 507, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (cVar instanceof DocumentWorkflow.c.C0301c) {
            final InquiryWorkflow inquiryWorkflow3 = this.this$0;
            final InquiryState.DocumentStepRunning documentStepRunning3 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow3, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (inquiryWorkflow3.l(((DocumentWorkflow.c.C0301c) cVar).a())) {
                        cVar.e(inquiryWorkflow3.u(documentStepRunning3));
                    } else {
                        cVar.d(new InquiryWorkflow.Output.Error(documentStepRunning3.d(), "There was a problem reaching the server.", ((DocumentWorkflow.c.C0301c) cVar).a()));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(cVar, DocumentWorkflow.c.d.f25086a)) {
            InquiryWorkflow inquiryWorkflow4 = this.this$0;
            final InquiryState.DocumentStepRunning documentStepRunning4 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow4, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(InquiryState.DocumentStepRunning.j(documentStepRunning4, (String) null, (String) null, TransitionStatus.CheckingForNextState, (StepStyles$DocumentStepStyle) null, (NextStep.CancelDialog) null, (NextStep.Document) null, (String) null, (DocumentPages) null, (String) null, 507, (Object) null));
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

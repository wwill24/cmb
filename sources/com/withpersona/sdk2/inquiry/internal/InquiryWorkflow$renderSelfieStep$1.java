package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderSelfieStep$1 extends Lambda implements Function1<SelfieWorkflow.c, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.SelfieStepRunning $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderSelfieStep$1(InquiryWorkflow inquiryWorkflow, InquiryState.SelfieStepRunning selfieStepRunning) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = selfieStepRunning;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final SelfieWorkflow.c cVar) {
        j.g(cVar, "it");
        if (j.b(cVar, SelfieWorkflow.c.b.f27370a)) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.SelfieStepRunning selfieStepRunning = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    j.g(cVar, "$this$action");
                    String c10 = selfieStepRunning.c();
                    String d10 = selfieStepRunning.d();
                    StepStyles$SelfieStepStyle s10 = selfieStepRunning.b();
                    NextStep.CancelDialog a10 = selfieStepRunning.a();
                    if (a10 != null) {
                        str = a10.e();
                    } else {
                        str = null;
                    }
                    NextStep.CancelDialog a11 = selfieStepRunning.a();
                    if (a11 != null) {
                        str2 = a11.d();
                    } else {
                        str2 = null;
                    }
                    NextStep.CancelDialog a12 = selfieStepRunning.a();
                    if (a12 != null) {
                        str3 = a12.a();
                    } else {
                        str3 = null;
                    }
                    NextStep.CancelDialog a13 = selfieStepRunning.a();
                    if (a13 != null) {
                        str4 = a13.c();
                    } else {
                        str4 = null;
                    }
                    cVar.d(new InquiryWorkflow.Output.Cancel(c10, d10, s10, str, str2, str3, str4));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(cVar, SelfieWorkflow.c.d.f27372a)) {
            InquiryWorkflow inquiryWorkflow2 = this.this$0;
            final InquiryState.SelfieStepRunning selfieStepRunning2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow2, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.SelfieStepRunning.j(selfieStepRunning2, (String) null, (String) null, TransitionStatus.CheckingForNextState, (StepStyles$SelfieStepStyle) null, (NextStep.CancelDialog) null, false, (String) null, (String) null, false, false, (String) null, false, (NextStep.Selfie.Localizations) null, (List) null, 16379, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(cVar, SelfieWorkflow.c.a.f27369a)) {
            InquiryWorkflow inquiryWorkflow3 = this.this$0;
            final InquiryState.SelfieStepRunning selfieStepRunning3 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow3, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.SelfieStepRunning.j(selfieStepRunning3, (String) null, (String) null, TransitionStatus.TransitioningBack, (StepStyles$SelfieStepStyle) null, (NextStep.CancelDialog) null, false, (String) null, (String) null, false, false, (String) null, false, (NextStep.Selfie.Localizations) null, (List) null, 16379, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (cVar instanceof SelfieWorkflow.c.C0329c) {
            final InquiryWorkflow inquiryWorkflow4 = this.this$0;
            final InquiryState.SelfieStepRunning selfieStepRunning4 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow4, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (inquiryWorkflow4.l(((SelfieWorkflow.c.C0329c) cVar).a())) {
                        cVar.e(inquiryWorkflow4.u(selfieStepRunning4));
                    } else {
                        cVar.d(new InquiryWorkflow.Output.Error(selfieStepRunning4.d(), h.a(((SelfieWorkflow.c.C0329c) cVar).a()), ((SelfieWorkflow.c.C0329c) cVar).a()));
                    }
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

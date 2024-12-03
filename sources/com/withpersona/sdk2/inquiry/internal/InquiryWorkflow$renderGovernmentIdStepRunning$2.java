package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderGovernmentIdStepRunning$2 extends Lambda implements Function1<GovernmentIdWorkflow.b, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.GovernmentIdStepRunning $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderGovernmentIdStepRunning$2(InquiryWorkflow inquiryWorkflow, InquiryState.GovernmentIdStepRunning governmentIdStepRunning) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = governmentIdStepRunning;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final GovernmentIdWorkflow.b bVar) {
        j.g(bVar, "it");
        if (j.b(bVar, GovernmentIdWorkflow.b.C0310b.f25633a)) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.GovernmentIdStepRunning governmentIdStepRunning = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    j.g(cVar, "$this$action");
                    String c10 = governmentIdStepRunning.c();
                    String d10 = governmentIdStepRunning.d();
                    StepStyles$GovernmentIdStepStyle D = governmentIdStepRunning.b();
                    NextStep.CancelDialog a10 = governmentIdStepRunning.a();
                    if (a10 != null) {
                        str = a10.e();
                    } else {
                        str = null;
                    }
                    NextStep.CancelDialog a11 = governmentIdStepRunning.a();
                    if (a11 != null) {
                        str2 = a11.d();
                    } else {
                        str2 = null;
                    }
                    NextStep.CancelDialog a12 = governmentIdStepRunning.a();
                    if (a12 != null) {
                        str3 = a12.a();
                    } else {
                        str3 = null;
                    }
                    NextStep.CancelDialog a13 = governmentIdStepRunning.a();
                    if (a13 != null) {
                        str4 = a13.c();
                    } else {
                        str4 = null;
                    }
                    cVar.d(new InquiryWorkflow.Output.Cancel(c10, d10, D, str, str2, str3, str4));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof GovernmentIdWorkflow.b.c) {
            final InquiryWorkflow inquiryWorkflow2 = this.this$0;
            final InquiryState.GovernmentIdStepRunning governmentIdStepRunning2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow2, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (inquiryWorkflow2.l(((GovernmentIdWorkflow.b.c) bVar).a())) {
                        cVar.e(inquiryWorkflow2.u(governmentIdStepRunning2));
                    } else {
                        cVar.d(new InquiryWorkflow.Output.Error(governmentIdStepRunning2.d(), h.a(((GovernmentIdWorkflow.b.c) bVar).a()), ((GovernmentIdWorkflow.b.c) bVar).a()));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(bVar, GovernmentIdWorkflow.b.d.f25635a)) {
            InquiryWorkflow inquiryWorkflow3 = this.this$0;
            final InquiryState.GovernmentIdStepRunning governmentIdStepRunning3 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow3, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.GovernmentIdStepRunning.j(governmentIdStepRunning3, (String) null, (String) null, TransitionStatus.CheckingForNextState, (StepStyles$GovernmentIdStepStyle) null, (NextStep.CancelDialog) null, (String) null, (List) null, (String) null, (String) null, false, false, (NextStep.GovernmentId.Localizations) null, (List) null, (List) null, 0, 0, (String) null, (String) null, (GovernmentIdPages) null, (PassportNfcConfig) null, false, (List) null, 4194299, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(bVar, GovernmentIdWorkflow.b.a.f25632a)) {
            InquiryWorkflow inquiryWorkflow4 = this.this$0;
            final InquiryState.GovernmentIdStepRunning governmentIdStepRunning4 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow4, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.GovernmentIdStepRunning.j(governmentIdStepRunning4, (String) null, (String) null, TransitionStatus.TransitioningBack, (StepStyles$GovernmentIdStepStyle) null, (NextStep.CancelDialog) null, (String) null, (List) null, (String) null, (String) null, false, false, (NextStep.GovernmentId.Localizations) null, (List) null, (List) null, 0, 0, (String) null, (String) null, (GovernmentIdPages) null, (PassportNfcConfig) null, false, (List) null, 4194299, (Object) null));
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

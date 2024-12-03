package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$renderUiStep$1 extends Lambda implements Function1<UiWorkflow.b, l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>> {
    final /* synthetic */ InquiryState.UiStepRunning $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$renderUiStep$1(InquiryWorkflow inquiryWorkflow, InquiryState.UiStepRunning uiStepRunning) {
        super(1);
        this.this$0 = inquiryWorkflow;
        this.$renderState = uiStepRunning;
    }

    /* renamed from: a */
    public final l<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output> invoke(final UiWorkflow.b bVar) {
        j.g(bVar, "it");
        if (j.b(bVar, UiWorkflow.b.C0333b.f29349a)) {
            InquiryWorkflow inquiryWorkflow = this.this$0;
            final InquiryState.UiStepRunning uiStepRunning = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    j.g(cVar, "$this$action");
                    String c10 = uiStepRunning.c();
                    String d10 = uiStepRunning.d();
                    StepStyles$UiStepStyle b10 = uiStepRunning.b();
                    NextStep.CancelDialog a10 = uiStepRunning.a();
                    if (a10 != null) {
                        str = a10.e();
                    } else {
                        str = null;
                    }
                    NextStep.CancelDialog a11 = uiStepRunning.a();
                    if (a11 != null) {
                        str2 = a11.d();
                    } else {
                        str2 = null;
                    }
                    NextStep.CancelDialog a12 = uiStepRunning.a();
                    if (a12 != null) {
                        str3 = a12.a();
                    } else {
                        str3 = null;
                    }
                    NextStep.CancelDialog a13 = uiStepRunning.a();
                    if (a13 != null) {
                        str4 = a13.c();
                    } else {
                        str4 = null;
                    }
                    cVar.d(new InquiryWorkflow.Output.Cancel(c10, d10, b10, str, str2, str3, str4));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiWorkflow.b.d) {
            final InquiryWorkflow inquiryWorkflow2 = this.this$0;
            final InquiryState.UiStepRunning uiStepRunning2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow2, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    if (inquiryWorkflow2.l(((UiWorkflow.b.d) bVar).a())) {
                        cVar.e(inquiryWorkflow2.u(uiStepRunning2));
                        return;
                    }
                    String d10 = uiStepRunning2.d();
                    String b10 = ((UiWorkflow.b.d) bVar).b();
                    if (b10 == null) {
                        b10 = "There was a problem reaching the server.";
                    }
                    cVar.d(new InquiryWorkflow.Output.Error(d10, b10, ((UiWorkflow.b.d) bVar).a()));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiWorkflow.b.e) {
            InquiryWorkflow inquiryWorkflow3 = this.this$0;
            final InquiryState.UiStepRunning uiStepRunning3 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow3, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.UiStepRunning.j(uiStepRunning3, (String) null, (String) null, TransitionStatus.CheckingForNextState, (StepStyles$UiStepStyle) null, (NextStep.CancelDialog) null, (String) null, (String) null, (List) null, false, false, false, (Map) null, (String) null, 8187, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiWorkflow.b.a) {
            InquiryWorkflow inquiryWorkflow4 = this.this$0;
            final InquiryState.UiStepRunning uiStepRunning4 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow4, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    cVar2.e(InquiryState.UiStepRunning.j(uiStepRunning4, (String) null, (String) null, TransitionStatus.TransitioningBack, (StepStyles$UiStepStyle) null, (NextStep.CancelDialog) null, (String) null, (String) null, (List) null, false, false, false, (Map) null, (String) null, 8187, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof UiWorkflow.b.c) {
            InquiryWorkflow inquiryWorkflow5 = this.this$0;
            final InquiryState.UiStepRunning uiStepRunning5 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(inquiryWorkflow5, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
                public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                    j.g(cVar, "$this$action");
                    String c10 = uiStepRunning5.c();
                    String p10 = uiStepRunning5.p();
                    j.d(p10);
                    cVar.d(new InquiryWorkflow.Output.Complete(c10, p10, uiStepRunning5.n()));
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

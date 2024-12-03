package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class InquiryWorkflow$render$backAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<InquiryWorkflow.a, InquiryState, InquiryWorkflow.Output, Object>.a $context;
    final /* synthetic */ InquiryState $renderState;
    final /* synthetic */ InquiryWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryWorkflow$render$backAction$1(h<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output, ? extends Object>.a aVar, InquiryWorkflow inquiryWorkflow, InquiryState inquiryState) {
        super(0);
        this.$context = aVar;
        this.this$0 = inquiryWorkflow;
        this.$renderState = inquiryState;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        InquiryWorkflow inquiryWorkflow = this.this$0;
        final InquiryState inquiryState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(inquiryWorkflow, (String) null, new Function1<l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c, Unit>() {
            public final void a(l<? super InquiryWorkflow.a, InquiryState, ? extends InquiryWorkflow.Output>.c cVar) {
                String str;
                String str2;
                String str3;
                String str4;
                j.g(cVar, "$this$action");
                String c10 = inquiryState.c();
                String d10 = inquiryState.d();
                StepStyle b10 = inquiryState.b();
                NextStep.CancelDialog a10 = inquiryState.a();
                if (a10 != null) {
                    str = a10.e();
                } else {
                    str = null;
                }
                NextStep.CancelDialog a11 = inquiryState.a();
                if (a11 != null) {
                    str2 = a11.d();
                } else {
                    str2 = null;
                }
                NextStep.CancelDialog a12 = inquiryState.a();
                if (a12 != null) {
                    str3 = a12.a();
                } else {
                    str3 = null;
                }
                NextStep.CancelDialog a13 = inquiryState.a();
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
        }, 1, (Object) null));
    }
}

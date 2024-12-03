package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PassportNfcRenderer$renderMrzScan$1 extends Lambda implements Function1<AnalyzeMrzWorker.b, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.MrzScan $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderMrzScan$1(GovernmentIdState.MrzScan mrzScan, GovernmentIdWorkflow.a aVar) {
        super(1);
        this.$renderState = mrzScan;
        this.$renderProps = aVar;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final AnalyzeMrzWorker.b bVar) {
        j.g(bVar, "it");
        final GovernmentIdState.MrzScan mrzScan = this.$renderState;
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        return Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                if (cVar.c() instanceof GovernmentIdState.MrzScan) {
                    cVar.e(PassportNfcRenderer.c(mrzScan, aVar, bVar.a()));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}

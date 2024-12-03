package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PassportNfcRenderer$renderMrzScan$6 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.MrzScan $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderMrzScan$6(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdState.MrzScan mrzScan, GovernmentIdWorkflow.a aVar2) {
        super(1);
        this.$context = aVar;
        this.$renderState = mrzScan;
        this.$renderProps = aVar2;
    }

    public final void a(Throwable th2) {
        j.g(th2, "it");
        f c10 = this.$context.c();
        final GovernmentIdState.MrzScan mrzScan = this.$renderState;
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        c10.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(PassportNfcRenderer.d(mrzScan, aVar, (PassportNfcKeys) null, 4, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}

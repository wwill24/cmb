package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PassportNfcRenderer$renderMrzScan$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderMrzScan$4(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar) {
        super(0);
        this.$context = aVar;
    }

    public final void invoke() {
        this.$context.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass1.f25960a, 1, (Object) null));
    }
}

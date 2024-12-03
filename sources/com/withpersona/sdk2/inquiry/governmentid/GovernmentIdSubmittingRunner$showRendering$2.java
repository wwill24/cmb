package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdSubmittingRunner$showRendering$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.b $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdSubmittingRunner$showRendering$2(GovernmentIdWorkflow.Screen.b bVar) {
        super(0);
        this.$rendering = bVar;
    }

    public final void invoke() {
        this.$rendering.c().invoke();
    }
}

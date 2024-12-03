package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdInstructionsRunner$showRendering$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.InstructionsScreen $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdInstructionsRunner$showRendering$4(GovernmentIdWorkflow.Screen.InstructionsScreen instructionsScreen) {
        super(0);
        this.$rendering = instructionsScreen;
    }

    public final void invoke() {
        this.$rendering.h().invoke();
    }
}

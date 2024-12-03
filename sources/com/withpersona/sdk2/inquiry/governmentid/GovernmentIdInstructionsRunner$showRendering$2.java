package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdInstructionsRunner$showRendering$2 extends Lambda implements Function1<IdConfig, Unit> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.InstructionsScreen $rendering;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdInstructionsRunner$showRendering$2(GovernmentIdWorkflow.Screen.InstructionsScreen instructionsScreen) {
        super(1);
        this.$rendering = instructionsScreen;
    }

    public final void a(IdConfig idConfig) {
        j.g(idConfig, "idClass");
        this.$rendering.k().invoke(idConfig);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((IdConfig) obj);
        return Unit.f32013a;
    }
}

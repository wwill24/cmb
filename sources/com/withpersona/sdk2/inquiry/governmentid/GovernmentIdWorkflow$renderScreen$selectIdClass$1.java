package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class GovernmentIdWorkflow$renderScreen$selectIdClass$1 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {
    final /* synthetic */ boolean $addCurrentState;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ IdConfig $selectedId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$selectIdClass$1(GovernmentIdState governmentIdState, boolean z10, IdConfig idConfig) {
        super(1);
        this.$renderState = governmentIdState;
        this.$addCurrentState = z10;
        this.$selectedId = idConfig;
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        j.g(cVar, "$this$action");
        cVar.e(GovernmentIdState.ShowInstructions.m((GovernmentIdState.ShowInstructions) this.$renderState, (IdPart) null, (List) null, (List) null, GovernmentIdWorkflowUtilsKt.b(cVar, this.$addCurrentState), 0, this.$selectedId, true, (String) null, Opcodes.DCMPL, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

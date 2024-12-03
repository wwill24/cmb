package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$selectIdClass$3 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {
    final /* synthetic */ boolean $addCurrentState;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$selectIdClass$3(boolean z10, GovernmentIdWorkflow.a aVar) {
        super(1);
        this.$addCurrentState = z10;
        this.$renderProps = aVar;
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        GovernmentIdState.ShowInstructions showInstructions;
        j.g(cVar, "$this$action");
        Object c10 = cVar.c();
        if (c10 instanceof GovernmentIdState.ShowInstructions) {
            showInstructions = (GovernmentIdState.ShowInstructions) c10;
        } else {
            showInstructions = null;
        }
        if (showInstructions != null) {
            cVar.e(new GovernmentIdState.PassportNfcError((IdPart) null, (List) null, showInstructions.i(), showInstructions.h(), GovernmentIdWorkflowUtilsKt.b(cVar, this.$addCurrentState), this.$renderProps.n().d(), 3, (DefaultConstructorMarker) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

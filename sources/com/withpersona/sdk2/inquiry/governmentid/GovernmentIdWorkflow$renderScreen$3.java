package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$3 extends Lambda implements Function1<DocumentSelectWorker.a, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ IdPart.SideIdPart $currentPart;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$3(GovernmentIdWorkflow governmentIdWorkflow, IdPart.SideIdPart sideIdPart, GovernmentIdState governmentIdState) {
        super(1);
        this.this$0 = governmentIdWorkflow;
        this.$currentPart = sideIdPart;
        this.$renderState = governmentIdState;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(DocumentSelectWorker.a aVar) {
        j.g(aVar, "it");
        if (aVar instanceof DocumentSelectWorker.a.b) {
            DocumentSelectWorker.a.b bVar = (DocumentSelectWorker.a.b) aVar;
            return GovernmentIdWorkflow.A(this.this$0, this.$currentPart, this.$renderState, bVar.a(), bVar.b());
        } else if (j.b(aVar, DocumentSelectWorker.a.C0320a.f26932a)) {
            GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
            final GovernmentIdState governmentIdState = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.e(GovernmentIdState.ChooseCaptureMethod.m((GovernmentIdState.ChooseCaptureMethod) governmentIdState, (IdPart.SideIdPart) null, (List) null, (List) null, 0, (IdConfig) null, false, (GovernmentIdState) null, (String) null, 223, (Object) null));
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

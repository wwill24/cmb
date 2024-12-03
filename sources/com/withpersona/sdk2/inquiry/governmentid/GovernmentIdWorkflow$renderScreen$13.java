package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class GovernmentIdWorkflow$renderScreen$13 extends Lambda implements Function1<Hint, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$13(GovernmentIdWorkflow governmentIdWorkflow) {
        super(1);
        this.this$0 = governmentIdWorkflow;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final Hint hint) {
        return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.CountdownToCapture countdownToCapture;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.CountdownToCapture) {
                    countdownToCapture = (GovernmentIdState.CountdownToCapture) c10;
                } else {
                    countdownToCapture = null;
                }
                GovernmentIdState.CountdownToCapture countdownToCapture2 = countdownToCapture;
                if (countdownToCapture2 != null) {
                    cVar.e(GovernmentIdState.CountdownToCapture.m(countdownToCapture2, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentId) null, (List) null, 0, (GovernmentIdState) null, hint, Opcodes.LAND, (Object) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}

package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
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

final class GovernmentIdWorkflow$renderScreen$screen$8 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$screen$8(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow) {
        super(1);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
    }

    public final void a(final Throwable th2) {
        j.g(th2, "error");
        this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.WaitForAutocapture waitForAutocapture;
                l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                j.g(cVar2, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.WaitForAutocapture) {
                    waitForAutocapture = (GovernmentIdState.WaitForAutocapture) c10;
                } else {
                    waitForAutocapture = null;
                }
                GovernmentIdState.WaitForAutocapture waitForAutocapture2 = waitForAutocapture;
                if (waitForAutocapture2 != null) {
                    cVar2.e(GovernmentIdState.WaitForAutocapture.m(waitForAutocapture2, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled, (List) null, 0, th2, (GovernmentIdState) null, false, false, (Hint) null, 1975, (Object) null));
                }
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

package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$9 extends Lambda implements Function1<GovernmentIdAnalyzeWorker.b, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$9(GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState) {
        super(1);
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final GovernmentIdAnalyzeWorker.b bVar) {
        j.g(bVar, "it");
        if (bVar instanceof GovernmentIdAnalyzeWorker.b.C0308b) {
            GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
            final GovernmentIdState governmentIdState = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    GovernmentIdState.WaitForAutocapture waitForAutocapture;
                    j.g(cVar, "$this$action");
                    Object c10 = cVar.c();
                    if (c10 instanceof GovernmentIdState.WaitForAutocapture) {
                        waitForAutocapture = (GovernmentIdState.WaitForAutocapture) c10;
                    } else {
                        waitForAutocapture = null;
                    }
                    if (waitForAutocapture != null) {
                        cVar.e(new GovernmentIdState.CountdownToCapture(((GovernmentIdState.WaitForAutocapture) governmentIdState).p(), ((GovernmentIdState) cVar.c()).j(), ((GovernmentIdState.WaitForAutocapture) governmentIdState).s(), ((GovernmentIdAnalyzeWorker.b.C0308b) bVar).a(), waitForAutocapture.i(), waitForAutocapture.h(), GovernmentIdWorkflowUtilsKt.b(cVar, false), waitForAutocapture.r()));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(bVar, GovernmentIdAnalyzeWorker.b.a.f25347a)) {
            GovernmentIdWorkflow governmentIdWorkflow2 = this.this$0;
            final GovernmentIdState governmentIdState2 = this.$renderState;
            return Workflows__StatefulWorkflowKt.d(governmentIdWorkflow2, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    if (((GovernmentIdState.WaitForAutocapture) governmentIdState2).t() == GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Hidden) {
                        cVar2.e(GovernmentIdState.WaitForAutocapture.m((GovernmentIdState.WaitForAutocapture) governmentIdState2, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled, (List) null, 0, (Throwable) null, (GovernmentIdState) null, false, false, (Hint) null, 2039, (Object) null));
                    }
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

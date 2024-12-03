package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$16 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$16(GovernmentIdState governmentIdState, GovernmentIdWorkflow.a aVar, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2, GovernmentIdWorkflow governmentIdWorkflow) {
        super(1);
        this.$renderState = governmentIdState;
        this.$renderProps = aVar;
        this.$context = aVar2;
        this.this$0 = governmentIdWorkflow;
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        j.g(list2, "absolutePaths");
        GovernmentId q10 = ((GovernmentIdState.CountdownToCapture) this.$renderState).q();
        List<Frame> U1 = ((GovernmentIdState.CountdownToCapture) this.$renderState).q().U1();
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        for (String frame : list) {
            arrayList.add(new Frame(frame, (String) null, 2, (DefaultConstructorMarker) null));
        }
        final GovernmentId y10 = q10.y(CollectionsKt___CollectionsKt.h0(U1, arrayList));
        if (this.$renderProps.u().b()) {
            GovernmentIdState governmentIdState = this.$renderState;
            GovernmentIdWorkflowUtilsKt.i(governmentIdState, this.$context, this.$renderProps, y10, ((GovernmentIdState.CountdownToCapture) governmentIdState).p(), false, (List) null, 0, 192, (Object) null);
        } else if (this.$renderProps.q()) {
            GovernmentIdState governmentIdState2 = this.$renderState;
            GovernmentIdWorkflowUtilsKt.i(governmentIdState2, this.$context, this.$renderProps, ((GovernmentIdState.CountdownToCapture) governmentIdState2).q(), ((GovernmentIdState.CountdownToCapture) this.$renderState).p(), false, (List) null, 0, 192, (Object) null);
        } else {
            f c10 = this.$context.c();
            GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
            final GovernmentIdState governmentIdState3 = this.$renderState;
            c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    GovernmentIdState.CountdownToCapture countdownToCapture;
                    j.g(cVar, "$this$action");
                    Object c10 = cVar.c();
                    if (c10 instanceof GovernmentIdState.CountdownToCapture) {
                        countdownToCapture = (GovernmentIdState.CountdownToCapture) c10;
                    } else {
                        countdownToCapture = null;
                    }
                    if (countdownToCapture != null) {
                        cVar.e(new GovernmentIdState.ReviewCapturedImage(((GovernmentIdState.CountdownToCapture) governmentIdState3).n(), ((GovernmentIdState) cVar.c()).j(), ((GovernmentIdState.CountdownToCapture) governmentIdState3).p(), y10, countdownToCapture.i(), countdownToCapture.h(), GovernmentIdWorkflowUtilsKt.b(cVar, false), (String) null, 128, (DefaultConstructorMarker) null));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

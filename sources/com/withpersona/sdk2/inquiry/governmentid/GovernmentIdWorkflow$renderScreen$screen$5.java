package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$screen$5 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$screen$5(GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState, GovernmentIdWorkflow.a aVar, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar2) {
        super(1);
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
        this.$renderProps = aVar;
        this.$context = aVar2;
    }

    public final void a(List<String> list) {
        List<String> list2 = list;
        j.g(list2, "absolutePaths");
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        for (String frame : list) {
            arrayList.add(new Frame(frame, (String) null, 2, (DefaultConstructorMarker) null));
        }
        final GovernmentId.GovernmentIdImage governmentIdImage = new GovernmentId.GovernmentIdImage(arrayList, this.this$0.E(((GovernmentIdState.WaitForAutocapture) this.$renderState).p().a()), ((GovernmentIdState.WaitForAutocapture) this.$renderState).s().g1(), GovernmentId.CaptureMethod.f25319b, (RawExtraction) null, (GovernmentIdDetails) null, 48, (DefaultConstructorMarker) null);
        if (this.$renderProps.u().b()) {
            GovernmentIdState governmentIdState = this.$renderState;
            GovernmentIdWorkflowUtilsKt.i(governmentIdState, this.$context, this.$renderProps, governmentIdImage, ((GovernmentIdState.WaitForAutocapture) governmentIdState).s(), false, (List) null, 0, 224, (Object) null);
            return;
        }
        f c10 = this.$context.c();
        GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState2 = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
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
                    cVar.e(new GovernmentIdState.ReviewCapturedImage(((GovernmentIdState.WaitForAutocapture) governmentIdState2).p(), ((GovernmentIdState) cVar.c()).j(), ((GovernmentIdState.WaitForAutocapture) governmentIdState2).s(), governmentIdImage, waitForAutocapture.i(), waitForAutocapture.h(), GovernmentIdWorkflowUtilsKt.b(cVar, false), (String) null, 128, (DefaultConstructorMarker) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}

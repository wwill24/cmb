package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$20 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdState $renderState;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$20(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow governmentIdWorkflow, GovernmentIdState governmentIdState) {
        super(0);
        this.$context = aVar;
        this.this$0 = governmentIdWorkflow;
        this.$renderState = governmentIdState;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
        final GovernmentIdState governmentIdState = this.$renderState;
        c10.d(Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.ReviewCapturedImage reviewCapturedImage;
                l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                j.g(cVar2, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.ReviewCapturedImage) {
                    reviewCapturedImage = (GovernmentIdState.ReviewCapturedImage) c10;
                } else {
                    reviewCapturedImage = null;
                }
                if (reviewCapturedImage != null) {
                    GovernmentIdState.WaitForAutocapture waitForAutocapture = r3;
                    GovernmentIdState.WaitForAutocapture waitForAutocapture2 = new GovernmentIdState.WaitForAutocapture(((GovernmentIdState.ReviewCapturedImage) governmentIdState).n(), ((GovernmentIdState) cVar.c()).j(), ((GovernmentIdState.ReviewCapturedImage) governmentIdState).o(), GovernmentIdWorkflowUtilsKt.e((GovernmentIdWorkflow.a) cVar.b(), ((GovernmentIdState.ReviewCapturedImage) governmentIdState).n().a()), reviewCapturedImage.i(), reviewCapturedImage.h(), (Throwable) null, GovernmentIdWorkflowUtilsKt.b(cVar2, false), false, false, (Hint) null, 1856, (DefaultConstructorMarker) null);
                    GovernmentIdState.WaitForAutocapture waitForAutocapture3 = waitForAutocapture;
                    waitForAutocapture3.k(true);
                    cVar2.e(waitForAutocapture3);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}

package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$onFileSelected$1 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ GovernmentId.GovernmentIdImage $idForReview;
    final /* synthetic */ GovernmentIdState $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$onFileSelected$1(GovernmentIdState governmentIdState, GovernmentId.GovernmentIdImage governmentIdImage, String str) {
        super(1);
        this.$renderState = governmentIdState;
        this.$idForReview = governmentIdImage;
        this.$fileName = str;
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        GovernmentIdState.ChooseCaptureMethod chooseCaptureMethod;
        l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
        j.g(cVar2, "$this$action");
        Object c10 = cVar.c();
        if (c10 instanceof GovernmentIdState.ChooseCaptureMethod) {
            chooseCaptureMethod = (GovernmentIdState.ChooseCaptureMethod) c10;
        } else {
            chooseCaptureMethod = null;
        }
        if (chooseCaptureMethod != null) {
            cVar2.e(new GovernmentIdState.ReviewSelectedImage(((GovernmentIdState.ChooseCaptureMethod) this.$renderState).o(), this.$renderState.j(), ((GovernmentIdState.ChooseCaptureMethod) this.$renderState).p(), this.$idForReview, this.$fileName, chooseCaptureMethod.i(), chooseCaptureMethod.h(), GovernmentIdWorkflowUtilsKt.c(cVar2, false, 1, (Object) null), (String) null, 256, (DefaultConstructorMarker) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

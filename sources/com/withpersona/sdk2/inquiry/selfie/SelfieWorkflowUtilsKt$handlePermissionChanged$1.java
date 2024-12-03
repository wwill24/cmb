package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.Permission;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflowUtilsKt$handlePermissionChanged$1 extends Lambda implements Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit> {
    final /* synthetic */ List<Permission> $missingPermissions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflowUtilsKt$handlePermissionChanged$1(List<? extends Permission> list) {
        super(1);
        this.$missingPermissions = list;
    }

    public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
        j.g(cVar, "$this$action");
        SelfieState selfieState = (SelfieState) cVar.c();
        if (selfieState instanceof SelfieState.WaitForCameraFeed) {
            cVar.e(((SelfieState.WaitForCameraFeed) selfieState).h(!this.$missingPermissions.contains(Permission.Camera), !this.$missingPermissions.contains(Permission.RecordAudio)));
            return;
        }
        t.a((SelfieState) cVar.c());
        cVar.e(new SelfieState.WaitForCameraFeed(false, false, 3, (DefaultConstructorMarker) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

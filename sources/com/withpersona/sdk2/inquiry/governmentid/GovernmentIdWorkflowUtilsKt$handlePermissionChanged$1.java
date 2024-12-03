package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import com.withpersona.sdk2.inquiry.permissions.Permission;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflowUtilsKt$handlePermissionChanged$1 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {
    final /* synthetic */ List<Permission> $missingPermissions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflowUtilsKt$handlePermissionChanged$1(List<? extends Permission> list) {
        super(1);
        this.$missingPermissions = list;
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
        j.g(cVar2, "$this$action");
        GovernmentIdState governmentIdState = (GovernmentIdState) cVar.c();
        if (governmentIdState instanceof GovernmentIdState.WaitForAutocapture) {
            cVar2.e(GovernmentIdState.WaitForAutocapture.m((GovernmentIdState.WaitForAutocapture) governmentIdState, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture) null, (List) null, 0, (Throwable) null, (GovernmentIdState) null, this.$missingPermissions.contains(Permission.Camera), this.$missingPermissions.contains(Permission.RecordAudio), (Hint) null, 1279, (Object) null));
            return;
        }
        ((GovernmentIdState) cVar.c()).e();
        cVar2.e(new GovernmentIdState.ShowInstructions((IdPart) null, (List) null, (List) null, (GovernmentIdState) null, 0, (IdConfig) null, false, (String) null, 255, (DefaultConstructorMarker) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}

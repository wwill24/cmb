package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.permissions.Permission;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.permissions.b;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ti.a;

public final class GovernmentIdWorkflowUtilsKt {
    public static final void a(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar) {
        j.g(aVar, "<this>");
        aVar.c().d(Workflows__WorkflowActionKt.c((String) null, GovernmentIdWorkflowUtilsKt$cancel$1.f25642a, 1, (Object) null));
    }

    public static final GovernmentIdState b(l<?, GovernmentIdState, ?>.c cVar, boolean z10) {
        j.g(cVar, "<this>");
        if (z10) {
            return (GovernmentIdState) cVar.c();
        }
        return ((GovernmentIdState) cVar.c()).f();
    }

    public static /* synthetic */ GovernmentIdState c(l.c cVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return b(cVar, z10);
    }

    public static final Function1<Throwable, Unit> d(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar) {
        j.g(aVar, "<this>");
        return new GovernmentIdWorkflowUtilsKt$getCameraErrorHandler$1(aVar);
    }

    public static final GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture e(GovernmentIdWorkflow.a aVar, IdConfig.Side side) {
        j.g(aVar, "renderProps");
        j.g(side, "currentSide");
        if (side == IdConfig.Side.PassportSignature) {
            return GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled;
        }
        if (j.b(aVar.c(), "US") || side != IdConfig.Side.Back) {
            return GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Hidden;
        }
        return GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled;
    }

    public static final void f(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar) {
        j.g(aVar, "<this>");
        aVar.c().d(Workflows__WorkflowActionKt.c((String) null, GovernmentIdWorkflowUtilsKt$goBack$1.f25648a, 1, (Object) null));
    }

    public static final void g(Context context, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "renderContext");
        j.g(aVar2, "renderProps");
        List p10 = q.p(Permission.Camera);
        if (aVar2.u().b()) {
            p10.add(Permission.RecordAudio);
        }
        List<Permission> a10 = b.a(context, p10);
        if (!a10.isEmpty()) {
            aVar.c().d(Workflows__WorkflowActionKt.c((String) null, new GovernmentIdWorkflowUtilsKt$handlePermissionChanged$1(a10), 1, (Object) null));
        }
    }

    public static final void h(GovernmentIdState governmentIdState, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2, GovernmentId governmentId, IdConfig idConfig, boolean z10, List<? extends IdPart> list, int i10) {
        j.g(governmentIdState, "renderState");
        h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar3 = aVar;
        j.g(aVar, "renderContext");
        j.g(aVar2, "renderProps");
        j.g(idConfig, "id");
        List<? extends IdPart> list2 = list;
        j.g(list2, "parts");
        aVar.c().d(Workflows__WorkflowActionKt.c((String) null, new GovernmentIdWorkflowUtilsKt$moveToNextStep$1(governmentIdState, governmentId, i10, list2, aVar2, z10, idConfig), 1, (Object) null));
    }

    public static /* synthetic */ void i(GovernmentIdState governmentIdState, h.a aVar, GovernmentIdWorkflow.a aVar2, GovernmentId governmentId, IdConfig idConfig, boolean z10, List list, int i10, int i11, Object obj) {
        boolean z11;
        List<IdPart> list2;
        int i12;
        int i13 = i11;
        if ((i13 & 32) != 0) {
            z11 = true;
        } else {
            z11 = z10;
        }
        if ((i13 & 64) != 0) {
            list2 = governmentIdState.i();
        } else {
            list2 = list;
        }
        if ((i13 & 128) != 0) {
            i12 = governmentIdState.h();
        } else {
            i12 = i10;
        }
        h(governmentIdState, aVar, aVar2, governmentId, idConfig, z11, list2, i12);
    }

    public static final com.withpersona.sdk2.inquiry.modal.b<Object, Object> j(Object obj, Context context, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2, boolean z10, PermissionRequestWorkflow permissionRequestWorkflow) {
        Context context2 = context;
        h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar3 = aVar;
        Object obj2 = obj;
        j.g(obj, "<this>");
        j.g(context2, IdentityHttpResponse.CONTEXT);
        j.g(aVar3, "renderContext");
        j.g(aVar2, "renderProps");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        Permission permission = Permission.RecordAudio;
        String R = aVar2.r().R();
        if (R == null) {
            R = "";
        }
        String str = R;
        String Q = aVar2.r().Q();
        if (Q == null) {
            Q = context2.getString(o0.pi2_selfie_mic_permission_rationale);
            j.f(Q, "context.getString(R.stri…mic_permission_rationale)");
        }
        String str2 = Q;
        String string = context2.getString(o0.pi2_selfie_mic_permission_denied_rationale, new Object[]{a.b(context)});
        j.f(string, "context.getString(\n     …etApplicationName()\n    )");
        return b.d(obj, aVar, z10, permission, str, str2, string, aVar2.r().O(), aVar2.r().P(), permissionRequestWorkflow, aVar2.s(), "video_capture_mic_permission_request", new GovernmentIdWorkflowUtilsKt$withRequestAudioPermissionsIfNeeded$1(aVar3));
    }

    public static final com.withpersona.sdk2.inquiry.modal.b<Object, Object> k(Object obj, Context context, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2, boolean z10, PermissionRequestWorkflow permissionRequestWorkflow) {
        Context context2 = context;
        h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar3 = aVar;
        j.g(obj, "<this>");
        j.g(context2, IdentityHttpResponse.CONTEXT);
        j.g(aVar3, "renderContext");
        j.g(aVar2, "renderProps");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        Permission permission = Permission.Camera;
        String l10 = aVar2.r().l();
        if (l10 == null) {
            l10 = "";
        }
        String str = l10;
        String k10 = aVar2.r().k();
        if (k10 == null) {
            k10 = context2.getString(o0.pi2_governmentid_camera_permission_rationale);
            j.f(k10, "context.getString(R.stri…era_permission_rationale)");
        }
        String str2 = k10;
        String string = context2.getString(o0.pi2_governmentid_camera_permission_denied_rationale, new Object[]{a.b(context)});
        j.f(string, "context.getString(\n     …etApplicationName()\n    )");
        return b.e(obj, aVar, z10, permission, str, str2, string, aVar2.r().i(), aVar2.r().j(), permissionRequestWorkflow, aVar2.s(), (String) null, new GovernmentIdWorkflowUtilsKt$withRequestCameraPermissionsIfNeeded$1(aVar3), 1024, (Object) null);
    }
}

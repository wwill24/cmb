package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.permissions.Permission;
import com.withpersona.sdk2.inquiry.permissions.b;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class SelfieWorkflowUtilsKt {
    public static final Function1<Throwable, Unit> a(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar) {
        j.g(aVar, "<this>");
        return new SelfieWorkflowUtilsKt$getCameraErrorHandler$1(aVar);
    }

    public static final void b(Context context, h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar, SelfieWorkflow.b bVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "renderContext");
        j.g(bVar, "renderProps");
        List p10 = q.p(Permission.Camera);
        if (bVar.t().b()) {
            p10.add(Permission.RecordAudio);
        }
        List<Permission> a10 = b.a(context, p10);
        if (!a10.isEmpty()) {
            aVar.c().d(Workflows__WorkflowActionKt.c((String) null, new SelfieWorkflowUtilsKt$handlePermissionChanged$1(a10), 1, (Object) null));
        }
    }
}

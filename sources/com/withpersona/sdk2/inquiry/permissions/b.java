package com.withpersona.sdk2.inquiry.permissions;

import android.content.Context;
import androidx.core.content.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.modal.c;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class b {
    public static final List<Permission> a(Context context, List<? extends Permission> list) {
        j.g(context, "<this>");
        j.g(list, "permissions");
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (!b(context, (Permission) next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static final boolean b(Context context, Permission permission) {
        j.g(context, "<this>");
        j.g(permission, "permission");
        return a.checkSelfPermission(context, a.a(permission)) == 0;
    }

    public static final com.withpersona.sdk2.inquiry.modal.b<Object, Object> c(Object obj) {
        j.g(obj, "<this>");
        return new com.withpersona.sdk2.inquiry.modal.b<>(obj, q.j(), "PermissionFlowModal");
    }

    public static final <PropsT, StateT, OutputT, RenderingT> com.withpersona.sdk2.inquiry.modal.b<Object, Object> d(Object obj, h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>.a aVar, boolean z10, Permission permission, String str, String str2, String str3, String str4, String str5, PermissionRequestWorkflow permissionRequestWorkflow, StepStyle stepStyle, String str6, Function1<? super PermissionRequestWorkflow.b, ? extends l<? super PropsT, StateT, ? extends OutputT>> function1) {
        com.withpersona.sdk2.inquiry.modal.b<Object, Object> a10;
        Object obj2 = obj;
        h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>.a aVar2 = aVar;
        PermissionRequestWorkflow permissionRequestWorkflow2 = permissionRequestWorkflow;
        String str7 = str6;
        Function1<? super PermissionRequestWorkflow.b, ? extends l<? super PropsT, StateT, ? extends OutputT>> function12 = function1;
        j.g(obj, "<this>");
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        j.g(permission, "permission");
        j.g(str, "title");
        j.g(str2, "rationale");
        j.g(str3, "rationaleWhenPermanentlyDenied");
        j.g(permissionRequestWorkflow2, "permissionRequestWorkflow");
        j.g(str7, SDKConstants.PARAM_KEY);
        j.g(function12, "handler");
        if (!z10) {
            return c(obj);
        }
        Object b10 = aVar.b(permissionRequestWorkflow2, new PermissionRequestWorkflow.c(permission, str, str2, str3, str4, str5, stepStyle), str7, function12);
        if (b10 == null || (a10 = c.a(b10, obj, "PermissionFlowModal")) == null) {
            return c(obj);
        }
        return a10;
    }

    public static /* synthetic */ com.withpersona.sdk2.inquiry.modal.b e(Object obj, h.a aVar, boolean z10, Permission permission, String str, String str2, String str3, String str4, String str5, PermissionRequestWorkflow permissionRequestWorkflow, StepStyle stepStyle, String str6, Function1 function1, int i10, Object obj2) {
        return d(obj, aVar, z10, permission, str, str2, str3, str4, str5, permissionRequestWorkflow, stepStyle, (i10 & 1024) != 0 ? "" : str6, function1);
    }
}

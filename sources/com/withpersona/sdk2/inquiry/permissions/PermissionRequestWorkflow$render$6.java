package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PermissionRequestWorkflow$render$6 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow.c $renderProps;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$6(h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar, PermissionRequestWorkflow permissionRequestWorkflow, PermissionRequestWorkflow.c cVar) {
        super(1);
        this.$context = aVar;
        this.this$0 = permissionRequestWorkflow;
        this.$renderProps = cVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f32013a;
    }

    public final void invoke(final boolean z10) {
        f c10 = this.$context.c();
        final PermissionRequestWorkflow permissionRequestWorkflow = this.this$0;
        final PermissionRequestWorkflow.c cVar = this.$renderProps;
        final h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a aVar = this.$context;
        c10.d(Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
            public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                if (z10) {
                    permissionRequestWorkflow.k(cVar, new PermissionState(cVar.b(), PermissionResult.PermissionRejected));
                } else {
                    aVar.c().d(Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow, (String) null, AnonymousClass1.f27139a, 1, (Object) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}

package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PermissionRequestWorkflow$render$5 extends Lambda implements Function1<PermissionRequestWorker.b, l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow.c $renderProps;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$5(PermissionRequestWorkflow permissionRequestWorkflow, PermissionRequestWorkflow.c cVar, h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar) {
        super(1);
        this.this$0 = permissionRequestWorkflow;
        this.$renderProps = cVar;
        this.$context = aVar;
    }

    /* renamed from: a */
    public final l<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b> invoke(PermissionRequestWorker.b bVar) {
        j.g(bVar, "it");
        if (j.b(bVar, PermissionRequestWorker.b.C0322b.f27116a)) {
            final PermissionRequestWorkflow permissionRequestWorkflow = this.this$0;
            final PermissionRequestWorkflow.c cVar = this.$renderProps;
            return Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
                public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    permissionRequestWorkflow.k(cVar, new PermissionState(cVar.b(), PermissionResult.PermissionGranted));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (j.b(bVar, PermissionRequestWorker.b.a.f27115a)) {
            final PermissionRequestWorkflow permissionRequestWorkflow2 = this.this$0;
            final h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a aVar = this.$context;
            return Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow2, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
                public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    aVar.c().d(Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow2, (String) null, AnonymousClass1.f27138a, 1, (Object) null));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

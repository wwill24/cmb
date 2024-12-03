package com.withpersona.sdk2.inquiry.permissions;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow$render$1", f = "PermissionRequestWorkflow.kt", l = {}, m = "invokeSuspend")
final class PermissionRequestWorkflow$render$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ h<PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, Object>.a $context;
    final /* synthetic */ PermissionRequestWorkflow.c $renderProps;
    int label;
    final /* synthetic */ PermissionRequestWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionRequestWorkflow$render$1(PermissionRequestWorkflow permissionRequestWorkflow, PermissionRequestWorkflow.c cVar, h<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b, ? extends Object>.a aVar, c<? super PermissionRequestWorkflow$render$1> cVar2) {
        super(2, cVar2);
        this.this$0 = permissionRequestWorkflow;
        this.$renderProps = cVar;
        this.$context = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PermissionRequestWorkflow$render$1(this.this$0, this.$renderProps, this.$context, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((PermissionRequestWorkflow$render$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            if (b.b(this.this$0.f27119a, this.$renderProps.b())) {
                f c10 = this.$context.c();
                final PermissionRequestWorkflow permissionRequestWorkflow = this.this$0;
                final PermissionRequestWorkflow.c cVar = this.$renderProps;
                c10.d(Workflows__StatefulWorkflowKt.d(permissionRequestWorkflow, (String) null, new Function1<l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, ? extends PermissionRequestWorkflow.b>.c, Unit>() {
                    public final void a(l<? super PermissionRequestWorkflow.c, PermissionRequestWorkflow.PermissionRequestState, PermissionRequestWorkflow.b>.c cVar) {
                        j.g(cVar, "$this$action");
                        permissionRequestWorkflow.k(cVar, new PermissionState(cVar.b(), PermissionResult.PermissionGranted));
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((l.c) obj);
                        return Unit.f32013a;
                    }
                }, 1, (Object) null));
            } else {
                this.$context.c().d(Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass2.f27136a, 1, (Object) null));
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

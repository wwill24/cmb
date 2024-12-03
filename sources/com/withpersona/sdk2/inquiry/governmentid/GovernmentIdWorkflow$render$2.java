package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import com.withpersona.sdk2.camera.CameraHelper;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$render$2", f = "GovernmentIdWorkflow.kt", l = {104}, m = "invokeSuspend")
final class GovernmentIdWorkflow$render$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$render$2(GovernmentIdWorkflow governmentIdWorkflow, c<? super GovernmentIdWorkflow$render$2> cVar) {
        super(2, cVar);
        this.this$0 = governmentIdWorkflow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new GovernmentIdWorkflow$render$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((GovernmentIdWorkflow$render$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            CameraHelper cameraHelper = CameraHelper.f14106a;
            Context i11 = this.this$0.f25506a;
            this.label = 1;
            if (cameraHelper.a(i11, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}

package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import com.withpersona.sdk2.camera.CameraHelper;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$render$1", f = "SelfieWorkflow.kt", l = {98}, m = "invokeSuspend")
final class SelfieWorkflow$render$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ SelfieWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflow$render$1(SelfieWorkflow selfieWorkflow, c<? super SelfieWorkflow$render$1> cVar) {
        super(2, cVar);
        this.this$0 = selfieWorkflow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SelfieWorkflow$render$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SelfieWorkflow$render$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            CameraHelper cameraHelper = CameraHelper.f14106a;
            Context h10 = this.this$0.f27275a;
            this.label = 1;
            if (cameraHelper.a(h10, this) == d10) {
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

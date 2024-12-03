package com.withpersona.sdk2.camera.camera2;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$start$1$surfaceCreated$1$1", f = "Camera2Manager.kt", l = {189}, m = "invokeSuspend")
final class Camera2Manager$start$1$surfaceCreated$1$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$start$1$surfaceCreated$1$1(Camera2Manager camera2Manager, c<? super Camera2Manager$start$1$surfaceCreated$1$1> cVar) {
        super(2, cVar);
        this.this$0 = camera2Manager;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Camera2Manager$start$1$surfaceCreated$1$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((Camera2Manager$start$1$surfaceCreated$1$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Camera2Manager camera2Manager = this.this$0;
            this.label = 1;
            if (Camera2Manager.M(camera2Manager, this) == d10) {
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

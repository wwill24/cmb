package com.withpersona.sdk2.camera;

import com.withpersona.sdk2.camera.n;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.c;
import pk.n;

@d(c = "com.withpersona.sdk2.camera.CameraControllerKt$completeWhenClosed$1", f = "CameraController.kt", l = {84}, m = "invokeSuspend")
final class CameraControllerKt$completeWhenClosed$1 extends SuspendLambda implements n<c<? super n>, n, kotlin.coroutines.c<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    CameraControllerKt$completeWhenClosed$1(kotlin.coroutines.c<? super CameraControllerKt$completeWhenClosed$1> cVar) {
        super(3, cVar);
    }

    /* renamed from: i */
    public final Object l(c<? super n> cVar, n nVar, kotlin.coroutines.c<? super Boolean> cVar2) {
        CameraControllerKt$completeWhenClosed$1 cameraControllerKt$completeWhenClosed$1 = new CameraControllerKt$completeWhenClosed$1(cVar2);
        cameraControllerKt$completeWhenClosed$1.L$0 = cVar;
        cameraControllerKt$completeWhenClosed$1.L$1 = nVar;
        return cameraControllerKt$completeWhenClosed$1.invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        n nVar;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            n nVar2 = (n) this.L$1;
            this.L$0 = nVar2;
            this.label = 1;
            if (((c) this.L$0).c(nVar2, this) == d10) {
                return d10;
            }
            nVar = nVar2;
        } else if (i10 == 1) {
            nVar = (n) this.L$0;
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return a.a(!(nVar instanceof n.a));
    }
}

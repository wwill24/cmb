package com.withpersona.sdk2.camera.camera2;

import gk.g;
import java.io.File;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.x0;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2", f = "Camera2Manager.kt", l = {311}, m = "invokeSuspend")
final class Camera2Manager$requestImageCapture$2 extends SuspendLambda implements Function2<k0, c<? super Result<? extends File>>, Object> {
    int label;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$requestImageCapture$2(Camera2Manager camera2Manager, c<? super Camera2Manager$requestImageCapture$2> cVar) {
        super(2, cVar);
        this.this$0 = camera2Manager;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Camera2Manager$requestImageCapture$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Result<? extends File>> cVar) {
        return ((Camera2Manager$requestImageCapture$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            if (!this.this$0.f14278q) {
                this.this$0.f14280s.setValue(null);
                this.this$0.f14278q = true;
                CoroutineDispatcher b10 = x0.b();
                Camera2Manager$requestImageCapture$2$imageResult$1 camera2Manager$requestImageCapture$2$imageResult$1 = new Camera2Manager$requestImageCapture$2$imageResult$1(this.this$0, (c<? super Camera2Manager$requestImageCapture$2$imageResult$1>) null);
                this.label = 1;
                obj = h.g(b10, camera2Manager$requestImageCapture$2$imageResult$1, this);
                if (obj == d10) {
                    return d10;
                }
            } else {
                Result.a aVar = Result.f32010a;
                return Result.a(Result.b(g.a(new RuntimeException("Image capture already requested."))));
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object j10 = ((Result) obj).j();
        this.this$0.f14278q = false;
        return Result.a(j10);
    }
}

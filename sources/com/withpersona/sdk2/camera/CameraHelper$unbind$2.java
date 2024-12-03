package com.withpersona.sdk2.camera;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.lifecycle.e;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.CameraHelper$unbind$2", f = "CameraHelper.kt", l = {}, m = "invokeSuspend")
final class CameraHelper$unbind$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ e $cameraProvider;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraHelper$unbind$2(e eVar, c<? super CameraHelper$unbind$2> cVar) {
        super(2, cVar);
        this.$cameraProvider = eVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraHelper$unbind$2(this.$cameraProvider, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraHelper$unbind$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            try {
                this.$cameraProvider.m();
            } catch (ImageCaptureException unused2) {
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

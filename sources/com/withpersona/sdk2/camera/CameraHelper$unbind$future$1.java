package com.withpersona.sdk2.camera;

import android.content.Context;
import androidx.camera.lifecycle.e;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import zf.a;

@d(c = "com.withpersona.sdk2.camera.CameraHelper$unbind$future$1", f = "CameraHelper.kt", l = {}, m = "invokeSuspend")
final class CameraHelper$unbind$future$1 extends SuspendLambda implements Function2<k0, c<? super a<e>>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraHelper$unbind$future$1(Context context, c<? super CameraHelper$unbind$future$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraHelper$unbind$future$1(this.$context, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super a<e>> cVar) {
        return ((CameraHelper$unbind$future$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return e.f(this.$context);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

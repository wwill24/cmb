package com.withpersona.sdk2.camera.camera2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Controller", f = "Camera2Controller.kt", l = {79}, m = "takePicture-IoAF18A")
final class Camera2Controller$takePicture$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Camera2Controller this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Controller$takePicture$1(Camera2Controller camera2Controller, c<? super Camera2Controller$takePicture$1> cVar) {
        super(cVar);
        this.this$0 = camera2Controller;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object h10 = this.this$0.h(this);
        return h10 == b.d() ? h10 : Result.a(h10);
    }
}

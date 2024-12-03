package com.withpersona.sdk2.camera;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.CameraXController", f = "CameraXController.kt", l = {52}, m = "takePicture-IoAF18A")
final class CameraXController$takePicture$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraXController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraXController$takePicture$1(CameraXController cameraXController, c<? super CameraXController$takePicture$1> cVar) {
        super(cVar);
        this.this$0 = cameraXController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object h10 = this.this$0.h(this);
        return h10 == b.d() ? h10 : Result.a(h10);
    }
}

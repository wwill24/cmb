package com.withpersona.sdk2.camera;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.CameraXController", f = "CameraXController.kt", l = {58}, m = "stopVideo-IoAF18A")
final class CameraXController$stopVideo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraXController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraXController$stopVideo$1(CameraXController cameraXController, c<? super CameraXController$stopVideo$1> cVar) {
        super(cVar);
        this.this$0 = cameraXController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object g10 = this.this$0.g(this);
        return g10 == b.d() ? g10 : Result.a(g10);
    }
}

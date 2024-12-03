package com.withpersona.sdk2.camera.camera2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager", f = "Camera2Manager.kt", l = {301}, m = "requestImageCapture-IoAF18A")
final class Camera2Manager$requestImageCapture$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$requestImageCapture$1(Camera2Manager camera2Manager, c<? super Camera2Manager$requestImageCapture$1> cVar) {
        super(cVar);
        this.this$0 = camera2Manager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object I = this.this$0.I(this);
        return I == b.d() ? I : Result.a(I);
    }
}

package com.withpersona.sdk2.camera.camera2;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager", f = "Camera2Manager.kt", l = {275}, m = "startVideo")
final class Camera2Manager$startVideo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$startVideo$1(Camera2Manager camera2Manager, c<? super Camera2Manager$startVideo$1> cVar) {
        super(cVar);
        this.this$0 = camera2Manager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.N(this);
    }
}

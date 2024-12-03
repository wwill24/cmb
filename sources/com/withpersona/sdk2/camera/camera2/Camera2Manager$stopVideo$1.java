package com.withpersona.sdk2.camera.camera2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager", f = "Camera2Manager.kt", l = {292}, m = "stopVideo-IoAF18A")
final class Camera2Manager$stopVideo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$stopVideo$1(Camera2Manager camera2Manager, c<? super Camera2Manager$stopVideo$1> cVar) {
        super(cVar);
        this.this$0 = camera2Manager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object O = this.this$0.O(this);
        return O == b.d() ? O : Result.a(O);
    }
}

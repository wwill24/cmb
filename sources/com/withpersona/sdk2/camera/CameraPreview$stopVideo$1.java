package com.withpersona.sdk2.camera;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.CameraPreview", f = "CameraPreview.kt", l = {208}, m = "stopVideo-IoAF18A")
final class CameraPreview$stopVideo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraPreview this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraPreview$stopVideo$1(CameraPreview cameraPreview, c<? super CameraPreview$stopVideo$1> cVar) {
        super(cVar);
        this.this$0 = cameraPreview;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object j10 = this.this$0.j(this);
        return j10 == b.d() ? j10 : Result.a(j10);
    }
}

package com.withpersona.sdk2.camera;

import android.content.Context;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.CameraPreview", f = "CameraPreview.kt", l = {175}, m = "takePicture-gIAlu-s")
final class CameraPreview$takePicture$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraPreview this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraPreview$takePicture$1(CameraPreview cameraPreview, c<? super CameraPreview$takePicture$1> cVar) {
        super(cVar);
        this.this$0 = cameraPreview;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object k10 = this.this$0.k((Context) null, this);
        return k10 == b.d() ? k10 : Result.a(k10);
    }
}

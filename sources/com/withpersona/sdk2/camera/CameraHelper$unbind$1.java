package com.withpersona.sdk2.camera;

import android.content.Context;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.CameraHelper", f = "CameraHelper.kt", l = {13, 16, 20}, m = "unbind")
final class CameraHelper$unbind$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraHelper$unbind$1(CameraHelper cameraHelper, c<? super CameraHelper$unbind$1> cVar) {
        super(cVar);
        this.this$0 = cameraHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((Context) null, this);
    }
}

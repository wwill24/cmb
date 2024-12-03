package com.withpersona.sdk2.camera.camera2;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager", f = "Camera2Manager.kt", l = {156}, m = "start$initializeCameraAndSetState")
final class Camera2Manager$start$initializeCameraAndSetState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    Camera2Manager$start$initializeCameraAndSetState$1(c<? super Camera2Manager$start$initializeCameraAndSetState$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Camera2Manager.M((Camera2Manager) null, this);
    }
}

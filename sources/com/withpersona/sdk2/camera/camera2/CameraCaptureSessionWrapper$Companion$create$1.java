package com.withpersona.sdk2.camera.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion", f = "CameraCaptureSessionWrapper.kt", l = {42}, m = "create")
final class CameraCaptureSessionWrapper$Companion$create$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraCaptureSessionWrapper.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraCaptureSessionWrapper$Companion$create$1(CameraCaptureSessionWrapper.Companion companion, c<? super CameraCaptureSessionWrapper$Companion$create$1> cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((f) null, (CameraCharacteristics) null, (List<? extends Surface>) null, (CameraDevice) null, (Handler) null, this);
    }
}

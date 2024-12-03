package com.withpersona.sdk2.camera.camera2;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$initializeCamera$2", f = "Camera2Manager.kt", l = {217, 233, 255}, m = "invokeSuspend")
final class Camera2Manager$initializeCamera$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ Camera2Manager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$initializeCamera$2(Camera2Manager camera2Manager, c<? super Camera2Manager$initializeCamera$2> cVar) {
        super(2, cVar);
        this.this$0 = camera2Manager;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Camera2Manager$initializeCamera$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((Camera2Manager$initializeCamera$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r13.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r5) goto L_0x002b
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            gk.g.b(r14)
            goto L_0x012e
        L_0x0017:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001f:
            java.lang.Object r1 = r13.L$0
            android.hardware.camera2.CameraDevice r1 = (android.hardware.camera2.CameraDevice) r1
            gk.g.b(r14)     // Catch:{ Exception -> 0x0028 }
            goto L_0x00c4
        L_0x0028:
            r10 = r1
            goto L_0x00cf
        L_0x002b:
            java.lang.Object r1 = r13.L$0
            com.withpersona.sdk2.camera.camera2.Camera2Manager r1 = (com.withpersona.sdk2.camera.camera2.Camera2Manager) r1
            gk.g.b(r14)
            goto L_0x005f
        L_0x0033:
            gk.g.b(r14)
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            android.hardware.camera2.CameraDevice r14 = r14.f14272k
            if (r14 != 0) goto L_0x0064
            com.withpersona.sdk2.camera.camera2.Camera2Manager r1 = r13.this$0
            android.hardware.camera2.CameraManager r14 = r1.f14268g
            com.withpersona.sdk2.camera.camera2.Camera2Manager r6 = r13.this$0
            com.withpersona.sdk2.camera.camera2.f r6 = r6.f14263b
            java.lang.String r6 = r6.b()
            com.withpersona.sdk2.camera.camera2.Camera2Manager r7 = r13.this$0
            android.os.Handler r7 = r7.f14274m
            r13.L$0 = r1
            r13.label = r5
            java.lang.Object r14 = r1.G(r14, r6, r7, r13)
            if (r14 != r0) goto L_0x005f
            return r0
        L_0x005f:
            android.hardware.camera2.CameraDevice r14 = (android.hardware.camera2.CameraDevice) r14
            r1.f14272k = r14
        L_0x0064:
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            android.hardware.camera2.CameraDevice r1 = r14.f14272k
            if (r1 == 0) goto L_0x013b
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper r14 = r14.f14271j
            r14.l()
            android.view.Surface[] r14 = new android.view.Surface[r3]
            com.withpersona.sdk2.camera.camera2.Camera2Manager r6 = r13.this$0
            com.withpersona.sdk2.camera.camera2.Camera2PreviewView r6 = r6.B()
            android.view.SurfaceHolder r6 = r6.getHolder()
            android.view.Surface r6 = r6.getSurface()
            r14[r2] = r6
            com.withpersona.sdk2.camera.camera2.Camera2Manager r6 = r13.this$0
            com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper r6 = r6.f14271j
            android.view.Surface r6 = r6.h()
            r14[r5] = r6
            com.withpersona.sdk2.camera.camera2.Camera2Manager r6 = r13.this$0
            android.media.ImageReader r6 = r6.f14286y
            android.view.Surface r6 = r6.getSurface()
            r14[r4] = r6
            java.util.List r9 = kotlin.collections.q.m(r14)
            com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion r6 = com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper.f14300j     // Catch:{ Exception -> 0x0028 }
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0     // Catch:{ Exception -> 0x0028 }
            com.withpersona.sdk2.camera.camera2.f r7 = r14.f14263b     // Catch:{ Exception -> 0x0028 }
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0     // Catch:{ Exception -> 0x0028 }
            android.hardware.camera2.CameraCharacteristics r8 = r14.f14269h     // Catch:{ Exception -> 0x0028 }
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0     // Catch:{ Exception -> 0x0028 }
            android.os.Handler r11 = r14.f14274m     // Catch:{ Exception -> 0x0028 }
            r13.L$0 = r1     // Catch:{ Exception -> 0x0028 }
            r13.label = r4     // Catch:{ Exception -> 0x0028 }
            r10 = r1
            r12 = r13
            java.lang.Object r14 = r6.a(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0028 }
            if (r14 != r0) goto L_0x00c4
            return r0
        L_0x00c4:
            com.withpersona.sdk2.camera.camera2.Camera2Manager r6 = r13.this$0     // Catch:{ Exception -> 0x0028 }
            r7 = r14
            com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r7 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper) r7     // Catch:{ Exception -> 0x0028 }
            r6.f14275n = r7     // Catch:{ Exception -> 0x0028 }
            com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r14 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper) r14     // Catch:{ Exception -> 0x0028 }
            goto L_0x0135
        L_0x00cf:
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            r1 = 1065353216(0x3f800000, float:1.0)
            r14.f14285x = r1
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            android.media.ImageReader r1 = r14.E()
            r14.f14286y = r1
            android.view.Surface[] r14 = new android.view.Surface[r3]
            com.withpersona.sdk2.camera.camera2.Camera2Manager r1 = r13.this$0
            com.withpersona.sdk2.camera.camera2.Camera2PreviewView r1 = r1.B()
            android.view.SurfaceHolder r1 = r1.getHolder()
            android.view.Surface r1 = r1.getSurface()
            r14[r2] = r1
            com.withpersona.sdk2.camera.camera2.Camera2Manager r1 = r13.this$0
            com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper r1 = r1.f14271j
            android.view.Surface r1 = r1.h()
            r14[r5] = r1
            com.withpersona.sdk2.camera.camera2.Camera2Manager r1 = r13.this$0
            android.media.ImageReader r1 = r1.f14286y
            android.view.Surface r1 = r1.getSurface()
            r14[r4] = r1
            java.util.List r9 = kotlin.collections.q.m(r14)
            com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion r6 = com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper.f14300j
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            com.withpersona.sdk2.camera.camera2.f r7 = r14.f14263b
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            android.hardware.camera2.CameraCharacteristics r8 = r14.f14269h
            com.withpersona.sdk2.camera.camera2.Camera2Manager r14 = r13.this$0
            android.os.Handler r11 = r14.f14274m
            r14 = 0
            r13.L$0 = r14
            r13.label = r3
            r12 = r13
            java.lang.Object r14 = r6.a(r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x012e
            return r0
        L_0x012e:
            com.withpersona.sdk2.camera.camera2.Camera2Manager r0 = r13.this$0
            com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r14 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper) r14
            r0.f14275n = r14
        L_0x0135:
            r14.l()
            kotlin.Unit r14 = kotlin.Unit.f32013a
            return r14
        L_0x013b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unable to open camera"
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager$initializeCamera$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

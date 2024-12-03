package com.withpersona.sdk2.camera;

public final class CameraHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final CameraHelper f14106a = new CameraHelper();

    private CameraHelper() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.withpersona.sdk2.camera.CameraHelper$unbind$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.withpersona.sdk2.camera.CameraHelper$unbind$1 r0 = (com.withpersona.sdk2.camera.CameraHelper$unbind$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.CameraHelper$unbind$1 r0 = new com.withpersona.sdk2.camera.CameraHelper$unbind$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r6) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            gk.g.b(r9)
            goto L_0x0082
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            gk.g.b(r9)
            goto L_0x006e
        L_0x003c:
            gk.g.b(r9)
            goto L_0x0055
        L_0x0040:
            gk.g.b(r9)
            kotlinx.coroutines.c2 r9 = kotlinx.coroutines.x0.c()
            com.withpersona.sdk2.camera.CameraHelper$unbind$future$1 r2 = new com.withpersona.sdk2.camera.CameraHelper$unbind$future$1
            r2.<init>(r8, r3)
            r0.label = r6
            java.lang.Object r9 = kotlinx.coroutines.h.g(r9, r2, r0)
            if (r9 != r1) goto L_0x0055
            return r1
        L_0x0055:
            java.lang.String r8 = "context: Context) {\n    …etInstance(context)\n    }"
            kotlin.jvm.internal.j.f(r9, r8)
            zf.a r9 = (zf.a) r9
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.x0.b()
            com.withpersona.sdk2.camera.CameraHelper$unbind$cameraProvider$1 r2 = new com.withpersona.sdk2.camera.CameraHelper$unbind$cameraProvider$1
            r2.<init>(r9)
            r0.label = r5
            java.lang.Object r9 = kotlinx.coroutines.InterruptibleKt.b(r8, r2, r0)
            if (r9 != r1) goto L_0x006e
            return r1
        L_0x006e:
            androidx.camera.lifecycle.e r9 = (androidx.camera.lifecycle.e) r9
            kotlinx.coroutines.c2 r8 = kotlinx.coroutines.x0.c()
            com.withpersona.sdk2.camera.CameraHelper$unbind$2 r2 = new com.withpersona.sdk2.camera.CameraHelper$unbind$2
            r2.<init>(r9, r3)
            r0.label = r4
            java.lang.Object r8 = kotlinx.coroutines.h.g(r8, r2, r0)
            if (r8 != r1) goto L_0x0082
            return r1
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.CameraHelper.a(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }
}

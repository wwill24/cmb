package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$9", f = "CameraScreenRunner.kt", l = {292}, m = "invokeSuspend")
final class CameraScreenRunner$showRendering$1$9 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen $rendering;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$9(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, CameraScreenRunner cameraScreenRunner, c<? super CameraScreenRunner$showRendering$1$9> cVar) {
        super(2, cVar);
        this.$rendering = cameraScreen;
        this.this$0 = cameraScreenRunner;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$showRendering$1$9(this.$rendering, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$showRendering$1$9) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            int r1 = r10.I$1
            int r3 = r10.I$0
            java.lang.Object r4 = r10.L$2
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.lang.Object r5 = r10.L$1
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r10.L$0
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r6 = (com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner) r6
            gk.g.b(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.j()
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            goto L_0x006b
        L_0x002c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0034:
            gk.g.b(r11)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r11 = r10.$rendering
            int r11 = r11.B()
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r1 = r10.this$0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r11)
            r4 = 0
            r6 = r1
            r1 = r4
            r4 = r3
            r3 = r11
            r11 = r10
        L_0x004a:
            if (r1 >= r3) goto L_0x0086
            com.withpersona.sdk2.camera.g r5 = r6.f25278c
            r11.L$0 = r6
            r11.L$1 = r4
            r11.L$2 = r4
            r11.I$0 = r3
            r11.I$1 = r1
            r11.label = r2
            java.lang.Object r5 = r5.h(r11)
            if (r5 != r0) goto L_0x0063
            return r0
        L_0x0063:
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r11
            r11 = r5
            r5 = r6
        L_0x006b:
            java.lang.Throwable r8 = kotlin.Result.e(r11)
            if (r8 != 0) goto L_0x0078
            java.io.File r11 = (java.io.File) r11
            java.lang.String r11 = r11.getAbsolutePath()
            goto L_0x0079
        L_0x0078:
            r11 = 0
        L_0x0079:
            r5.add(r11)
            int r11 = r3 + 1
            r3 = r4
            r4 = r6
            r6 = r7
            r9 = r1
            r1 = r11
            r11 = r0
            r0 = r9
            goto L_0x004a
        L_0x0086:
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r0 = r11.this$0
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$9$1 r1 = new com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$9$1
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r11 = r11.$rendering
            r1.<init>(r11, r4)
            r0.B(r1)
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

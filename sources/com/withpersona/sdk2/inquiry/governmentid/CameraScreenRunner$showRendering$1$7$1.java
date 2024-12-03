package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$7$1", f = "CameraScreenRunner.kt", l = {268}, m = "invokeSuspend")
final class CameraScreenRunner$showRendering$1$7$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen $rendering;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$7$1(GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, CameraScreenRunner cameraScreenRunner, c<? super CameraScreenRunner$showRendering$1$7$1> cVar) {
        super(2, cVar);
        this.$rendering = cameraScreen;
        this.this$0 = cameraScreenRunner;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$showRendering$1$7$1(this.$rendering, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$showRendering$1$7$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            int r1 = r11.I$1
            int r3 = r11.I$0
            java.lang.Object r4 = r11.L$3
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.lang.Object r5 = r11.L$2
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r11.L$1
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r6 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen) r6
            java.lang.Object r7 = r11.L$0
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r7 = (com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner) r7
            gk.g.b(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.j()
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r11
            goto L_0x0075
        L_0x0031:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0039:
            gk.g.b(r12)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r12 = r11.$rendering
            int r12 = r12.B()
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r1 = r11.this$0
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r3 = r11.$rendering
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r12)
            r5 = 0
            r7 = r1
            r6 = r3
            r1 = r5
            r3 = r12
            r12 = r11
        L_0x0051:
            if (r1 >= r3) goto L_0x0099
            com.withpersona.sdk2.camera.g r5 = r7.f25278c
            r12.L$0 = r7
            r12.L$1 = r6
            r12.L$2 = r4
            r12.L$3 = r4
            r12.I$0 = r3
            r12.I$1 = r1
            r12.label = r2
            java.lang.Object r5 = r5.h(r12)
            if (r5 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            r12 = r5
            r5 = r6
        L_0x0075:
            java.lang.Throwable r9 = kotlin.Result.e(r12)
            if (r9 != 0) goto L_0x008f
            java.io.File r12 = (java.io.File) r12
            java.lang.String r12 = r12.getAbsolutePath()
            r5.add(r12)
            int r12 = r3 + 1
            r3 = r4
            r4 = r6
            r6 = r7
            r7 = r8
            r10 = r1
            r1 = r12
            r12 = r0
            r0 = r10
            goto L_0x0051
        L_0x008f:
            kotlin.jvm.functions.Function1 r12 = r7.x()
            r12.invoke(r9)
            kotlin.Unit r12 = kotlin.Unit.f32013a
            return r12
        L_0x0099:
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner r0 = r12.this$0
            com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$7$1$1 r1 = new com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$7$1$1
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen r12 = r12.$rendering
            r1.<init>(r12, r4)
            r0.B(r1)
            kotlin.Unit r12 = kotlin.Unit.f32013a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$7$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

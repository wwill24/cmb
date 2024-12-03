package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.camera.NoActiveRecordingError;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import gk.g;
import java.io.File;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.CameraScreenRunner$showRendering$1$12", f = "CameraScreenRunner.kt", l = {328}, m = "invokeSuspend")
final class CameraScreenRunner$showRendering$1$12 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen $rendering;
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$12(CameraScreenRunner cameraScreenRunner, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen, c<? super CameraScreenRunner$showRendering$1$12> cVar) {
        super(2, cVar);
        this.this$0 = cameraScreenRunner;
        this.$rendering = cameraScreen;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$showRendering$1$12(this.this$0, this.$rendering, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$showRendering$1$12) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            com.withpersona.sdk2.camera.g m10 = this.this$0.f25278c;
            this.label = 1;
            obj2 = m10.g(this);
            if (obj2 == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
            obj2 = ((Result) obj).j();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen = this.$rendering;
        if (Result.h(obj2)) {
            cameraScreen.z().invoke((File) obj2);
        }
        GovernmentIdWorkflow.Screen.CameraScreen cameraScreen2 = this.$rendering;
        Throwable e10 = Result.e(obj2);
        if (e10 != null && !(e10 instanceof NoActiveRecordingError)) {
            cameraScreen2.w().invoke(e10);
        }
        return Unit.f32013a;
    }
}

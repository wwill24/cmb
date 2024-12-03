package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import gk.g;
import java.io.File;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$showRendering$1$takePhoto$1", f = "CameraScreenRunner.kt", l = {232}, m = "invokeSuspend")
final class CameraScreenRunner$showRendering$1$takePhoto$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a $mode;
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$takePhoto$1(CameraScreenRunner cameraScreenRunner, SelfieWorkflow.Screen.CameraScreen.a aVar, c<? super CameraScreenRunner$showRendering$1$takePhoto$1> cVar) {
        super(2, cVar);
        this.this$0 = cameraScreenRunner;
        this.$mode = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$showRendering$1$takePhoto$1(this.this$0, this.$mode, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$showRendering$1$takePhoto$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            com.withpersona.sdk2.camera.g f10 = this.this$0.f27166c;
            this.label = 1;
            obj2 = f10.h(this);
            if (obj2 == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
            obj2 = ((Result) obj).j();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SelfieWorkflow.Screen.CameraScreen.a aVar = this.$mode;
        if (Result.h(obj2)) {
            Function1<String, Unit> c10 = ((SelfieWorkflow.Screen.CameraScreen.a.d) aVar).c();
            String absolutePath = ((File) obj2).getAbsolutePath();
            j.f(absolutePath, "it.absolutePath");
            c10.invoke(absolutePath);
        }
        return Unit.f32013a;
    }
}

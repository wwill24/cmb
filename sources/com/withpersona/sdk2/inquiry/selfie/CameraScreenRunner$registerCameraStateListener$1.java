package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.camera.CameraControllerKt;
import com.withpersona.sdk2.camera.RecordingInterrupted;
import com.withpersona.sdk2.camera.UnsupportedDevice;
import com.withpersona.sdk2.camera.n;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$registerCameraStateListener$1", f = "CameraScreenRunner.kt", l = {107}, m = "invokeSuspend")
final class CameraScreenRunner$registerCameraStateListener$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    static final class a<T> implements kotlinx.coroutines.flow.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CameraScreenRunner f27174a;

        a(CameraScreenRunner cameraScreenRunner) {
            this.f27174a = cameraScreenRunner;
        }

        /* renamed from: a */
        public final Object c(n nVar, c<? super Unit> cVar) {
            Function1 g10;
            if (j.b(nVar, n.b.f14368a)) {
                Function1 g11 = this.f27174a.f27168e;
                if (g11 != null) {
                    g11.invoke(new UnsupportedDevice());
                }
            } else if ((nVar instanceof n.a) && ((n.a) nVar).a() && (g10 = this.f27174a.f27168e) != null) {
                g10.invoke(new RecordingInterrupted());
            }
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$registerCameraStateListener$1(CameraScreenRunner cameraScreenRunner, c<? super CameraScreenRunner$registerCameraStateListener$1> cVar) {
        super(2, cVar);
        this.this$0 = cameraScreenRunner;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$registerCameraStateListener$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$registerCameraStateListener$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b<n> a10 = CameraControllerKt.a(this.this$0.f27166c.c());
            a aVar = new a(this.this$0);
            this.label = 1;
            if (a10.a(aVar, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}

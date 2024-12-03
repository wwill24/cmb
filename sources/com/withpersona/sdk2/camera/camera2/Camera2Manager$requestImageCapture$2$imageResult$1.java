package com.withpersona.sdk2.camera.camera2;

import gk.g;
import java.io.File;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2$imageResult$1", f = "Camera2Manager.kt", l = {312}, m = "invokeSuspend")
final class Camera2Manager$requestImageCapture$2$imageResult$1 extends SuspendLambda implements Function2<k0, c<? super Result<? extends File>>, Object> {
    int label;
    final /* synthetic */ Camera2Manager this$0;

    @d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2$imageResult$1$1", f = "Camera2Manager.kt", l = {315}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2$imageResult$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Result<? extends File>>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(camera2Manager, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Result<? extends File>> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                b s10 = kotlinx.coroutines.flow.d.s(camera2Manager.f14280s);
                this.label = 1;
                obj = kotlinx.coroutines.flow.d.t(s10, this);
                if (obj == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                g.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$requestImageCapture$2$imageResult$1(Camera2Manager camera2Manager, c<? super Camera2Manager$requestImageCapture$2$imageResult$1> cVar) {
        super(2, cVar);
        this.this$0 = camera2Manager;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Camera2Manager$requestImageCapture$2$imageResult$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Result<? extends File>> cVar) {
        return ((Camera2Manager$requestImageCapture$2$imageResult$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            CoroutineContext G = this.this$0.f14266e.G();
            final Camera2Manager camera2Manager = this.this$0;
            AnonymousClass1 r12 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = h.g(G, r12, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

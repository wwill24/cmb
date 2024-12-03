package com.withpersona.sdk2.camera.camera2;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

final class Camera2Manager$start$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Camera2Manager this$0;

    @d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$start$2$1", f = "Camera2Manager.kt", l = {198}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.camera.camera2.Camera2Manager$start$2$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(camera2Manager, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                Camera2Manager camera2Manager = camera2Manager;
                this.label = 1;
                if (Camera2Manager.M(camera2Manager, this) == d10) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Manager$start$2(Camera2Manager camera2Manager) {
        super(0);
        this.this$0 = camera2Manager;
    }

    public final void invoke() {
        if (this.this$0.f14279r) {
            k0 g10 = this.this$0.f14266e;
            final Camera2Manager camera2Manager = this.this$0;
            s1 unused = j.d(g10, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }
}

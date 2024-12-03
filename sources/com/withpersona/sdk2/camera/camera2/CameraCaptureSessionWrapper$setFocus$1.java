package com.withpersona.sdk2.camera.camera2;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.x0;

@d(c = "com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$setFocus$1", f = "CameraCaptureSessionWrapper.kt", l = {157, 159}, m = "invokeSuspend")
final class CameraCaptureSessionWrapper$setFocus$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    int label;
    final /* synthetic */ CameraCaptureSessionWrapper this$0;

    @d(c = "com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$setFocus$1$1", f = "CameraCaptureSessionWrapper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$setFocus$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(cameraCaptureSessionWrapper, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                cameraCaptureSessionWrapper.d();
                cameraCaptureSessionWrapper.l();
                return Unit.f32013a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraCaptureSessionWrapper$setFocus$1(long j10, CameraCaptureSessionWrapper cameraCaptureSessionWrapper, c<? super CameraCaptureSessionWrapper$setFocus$1> cVar) {
        super(2, cVar);
        this.$duration = j10;
        this.this$0 = cameraCaptureSessionWrapper;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraCaptureSessionWrapper$setFocus$1(this.$duration, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraCaptureSessionWrapper$setFocus$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            long j10 = this.$duration;
            this.label = 1;
            if (s0.a(j10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else if (i10 == 2) {
            g.b(obj);
            return Unit.f32013a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c2 c10 = x0.c();
        final CameraCaptureSessionWrapper cameraCaptureSessionWrapper = this.this$0;
        AnonymousClass1 r12 = new AnonymousClass1((c<? super AnonymousClass1>) null);
        this.label = 2;
        if (h.g(c10, r12, this) == d10) {
            return d10;
        }
        return Unit.f32013a;
    }
}

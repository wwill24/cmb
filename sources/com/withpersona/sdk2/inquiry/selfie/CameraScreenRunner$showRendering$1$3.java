package com.withpersona.sdk2.inquiry.selfie;

import androidx.lifecycle.g;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

@d(c = "com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$showRendering$1$3", f = "CameraScreenRunner.kt", l = {185}, m = "invokeSuspend")
final class CameraScreenRunner$showRendering$1$3 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ g $lifecycleScope;
    final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a $mode;
    int label;
    final /* synthetic */ CameraScreenRunner this$0;

    @d(c = "com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$showRendering$1$3$1", f = "CameraScreenRunner.kt", l = {190, 192}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$showRendering$1$3$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(aVar, cameraScreenRunner2, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0024
                if (r1 == r3) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                gk.g.b(r7)
                kotlin.Result r7 = (kotlin.Result) r7
                java.lang.Object r7 = r7.j()
                goto L_0x0047
            L_0x0018:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0020:
                gk.g.b(r7)
                goto L_0x0038
            L_0x0024:
                gk.g.b(r7)
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a r7 = r5
                com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow$Screen$CameraScreen$a$b r7 = (com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow.Screen.CameraScreen.a.b) r7
                long r4 = r7.c()
                r6.label = r3
                java.lang.Object r7 = kotlinx.coroutines.s0.a(r4, r6)
                if (r7 != r0) goto L_0x0038
                return r0
            L_0x0038:
                com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner r7 = r6
                com.withpersona.sdk2.camera.g r7 = r7.f27166c
                r6.label = r2
                java.lang.Object r7 = r7.g(r6)
                if (r7 != r0) goto L_0x0047
                return r0
            L_0x0047:
                boolean r0 = kotlin.Result.h(r7)
                if (r0 == 0) goto L_0x0052
                java.io.File r7 = (java.io.File) r7
                r7.delete()
            L_0x0052:
                com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner r7 = r6
                kotlin.jvm.functions.Function1 r7 = r7.f27168e
                if (r7 == 0) goto L_0x0062
                com.withpersona.sdk2.camera.RecordingTooLongError r0 = new com.withpersona.sdk2.camera.RecordingTooLongError
                r0.<init>()
                r7.invoke(r0)
            L_0x0062:
                kotlin.Unit r7 = kotlin.Unit.f32013a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.CameraScreenRunner$showRendering$1$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraScreenRunner$showRendering$1$3(CameraScreenRunner cameraScreenRunner, g gVar, SelfieWorkflow.Screen.CameraScreen.a aVar, c<? super CameraScreenRunner$showRendering$1$3> cVar) {
        super(2, cVar);
        this.this$0 = cameraScreenRunner;
        this.$lifecycleScope = gVar;
        this.$mode = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CameraScreenRunner$showRendering$1$3(this.this$0, this.$lifecycleScope, this.$mode, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CameraScreenRunner$showRendering$1$3) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            gk.g.b(obj);
            com.withpersona.sdk2.camera.g f10 = this.this$0.f27166c;
            this.label = 1;
            obj = f10.b(this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            gk.g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            s1 h10 = this.this$0.f27167d;
            if (h10 != null) {
                s1.a.a(h10, (CancellationException) null, 1, (Object) null);
            }
            CameraScreenRunner cameraScreenRunner = this.this$0;
            g gVar = this.$lifecycleScope;
            CoroutineDispatcher b10 = x0.b();
            final SelfieWorkflow.Screen.CameraScreen.a aVar = this.$mode;
            final CameraScreenRunner cameraScreenRunner2 = this.this$0;
            cameraScreenRunner.f27167d = j.d(gVar, b10, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 2, (Object) null);
        }
        return Unit.f32013a;
    }
}

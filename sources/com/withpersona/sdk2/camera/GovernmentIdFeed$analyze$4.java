package com.withpersona.sdk2.camera;

import androidx.camera.core.o1;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$4", f = "GovernmentIdFeed.kt", l = {108, 110}, m = "invokeSuspend")
final class GovernmentIdFeed$analyze$4 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ o1 $imageProxy;
    Object L$0;
    int label;
    final /* synthetic */ GovernmentIdFeed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdFeed$analyze$4(o1 o1Var, GovernmentIdFeed governmentIdFeed, c<? super GovernmentIdFeed$analyze$4> cVar) {
        super(2, cVar);
        this.$imageProxy = o1Var;
        this.this$0 = governmentIdFeed;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new GovernmentIdFeed$analyze$4(this.$imageProxy, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((GovernmentIdFeed$analyze$4) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        nk.a.a(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            gk.g.b(r7)
            goto L_0x0061
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            java.lang.Object r1 = r6.L$0
            java.lang.AutoCloseable r1 = (java.lang.AutoCloseable) r1
            gk.g.b(r7)     // Catch:{ all -> 0x0029 }
            kotlin.Result r7 = (kotlin.Result) r7     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r7.j()     // Catch:{ all -> 0x0029 }
            goto L_0x0049
        L_0x0029:
            r7 = move-exception
            goto L_0x0064
        L_0x002b:
            gk.g.b(r7)
            androidx.camera.core.o1 r1 = r6.$imageProxy
            com.withpersona.sdk2.camera.GovernmentIdFeed r7 = r6.this$0
            com.withpersona.sdk2.camera.s r5 = com.withpersona.sdk2.camera.ImageToAnalyzeKt.e(r1)     // Catch:{ all -> 0x0029 }
            if (r5 != 0) goto L_0x003e
            kotlin.Unit r7 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0029 }
            nk.a.a(r1, r4)
            return r7
        L_0x003e:
            r6.L$0 = r1     // Catch:{ all -> 0x0029 }
            r6.label = r3     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r7.l(r5, r6)     // Catch:{ all -> 0x0029 }
            if (r7 != r0) goto L_0x0049
            return r0
        L_0x0049:
            nk.a.a(r1, r4)
            com.withpersona.sdk2.camera.GovernmentIdFeed r1 = r6.this$0
            kotlinx.coroutines.flow.h r1 = r1.f14127a
            kotlin.Result r7 = kotlin.Result.a(r7)
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.c(r7, r6)
            if (r7 != r0) goto L_0x0061
            return r0
        L_0x0061:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        L_0x0064:
            throw r7     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            nk.a.a(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

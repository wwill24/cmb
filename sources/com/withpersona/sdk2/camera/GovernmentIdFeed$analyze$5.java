package com.withpersona.sdk2.camera;

import android.media.Image;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$5", f = "GovernmentIdFeed.kt", l = {117, 119}, m = "invokeSuspend")
final class GovernmentIdFeed$analyze$5 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Image $image;
    final /* synthetic */ int $rotationDegrees;
    Object L$0;
    int label;
    final /* synthetic */ GovernmentIdFeed this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdFeed$analyze$5(Image image, GovernmentIdFeed governmentIdFeed, int i10, c<? super GovernmentIdFeed$analyze$5> cVar) {
        super(2, cVar);
        this.$image = image;
        this.this$0 = governmentIdFeed;
        this.$rotationDegrees = i10;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new GovernmentIdFeed$analyze$5(this.$image, this.this$0, this.$rotationDegrees, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((GovernmentIdFeed$analyze$5) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        nk.a.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            gk.g.b(r6)
            goto L_0x005b
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            java.lang.AutoCloseable r1 = (java.lang.AutoCloseable) r1
            gk.g.b(r6)     // Catch:{ all -> 0x0028 }
            kotlin.Result r6 = (kotlin.Result) r6     // Catch:{ all -> 0x0028 }
            java.lang.Object r6 = r6.j()     // Catch:{ all -> 0x0028 }
            goto L_0x0042
        L_0x0028:
            r6 = move-exception
            goto L_0x005e
        L_0x002a:
            gk.g.b(r6)
            android.media.Image r1 = r5.$image
            com.withpersona.sdk2.camera.GovernmentIdFeed r6 = r5.this$0
            int r4 = r5.$rotationDegrees
            com.withpersona.sdk2.camera.s r4 = com.withpersona.sdk2.camera.ImageToAnalyzeKt.d(r1, r4)     // Catch:{ all -> 0x0028 }
            r5.L$0 = r1     // Catch:{ all -> 0x0028 }
            r5.label = r3     // Catch:{ all -> 0x0028 }
            java.lang.Object r6 = r6.l(r4, r5)     // Catch:{ all -> 0x0028 }
            if (r6 != r0) goto L_0x0042
            return r0
        L_0x0042:
            r3 = 0
            nk.a.a(r1, r3)
            com.withpersona.sdk2.camera.GovernmentIdFeed r1 = r5.this$0
            kotlinx.coroutines.flow.h r1 = r1.f14127a
            kotlin.Result r6 = kotlin.Result.a(r6)
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = r1.c(r6, r5)
            if (r6 != r0) goto L_0x005b
            return r0
        L_0x005b:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        L_0x005e:
            throw r6     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            nk.a.a(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

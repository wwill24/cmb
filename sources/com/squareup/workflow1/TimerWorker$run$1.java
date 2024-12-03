package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.squareup.workflow1.TimerWorker$run$1", f = "Worker.kt", l = {339, 340}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class TimerWorker$run$1 extends SuspendLambda implements Function2<c<? super Unit>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TimerWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimerWorker$run$1(TimerWorker timerWorker, kotlin.coroutines.c<? super TimerWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = timerWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        TimerWorker$run$1 timerWorker$run$1 = new TimerWorker$run$1(this.this$0, cVar);
        timerWorker$run$1.L$0 = obj;
        return timerWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super Unit> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((TimerWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            gk.g.b(r7)
            goto L_0x0049
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r7)
            goto L_0x003b
        L_0x0022:
            gk.g.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.squareup.workflow1.TimerWorker r7 = r6.this$0
            long r4 = r7.f23057b
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.s0.a(r4, r6)
            if (r7 != r0) goto L_0x003b
            return r0
        L_0x003b:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            r3 = 0
            r6.L$0 = r3
            r6.label = r2
            java.lang.Object r7 = r1.c(r7, r6)
            if (r7 != r0) goto L_0x0049
            return r0
        L_0x0049:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.TimerWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

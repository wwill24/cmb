package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.h;

@d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {952, 954}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlin/sequences/h;", "Lkotlinx/coroutines/s1;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<h<? super s1>, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, c<? super JobSupport$children$1> cVar) {
        super(2, cVar);
        this.this$0 = jobSupport;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, cVar);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    /* renamed from: i */
    public final Object invoke(h<? super s1> hVar, c<? super Unit> cVar) {
        return ((JobSupport$children$1) create(hVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.p r3 = (kotlinx.coroutines.internal.p) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.h r4 = (kotlin.sequences.h) r4
            gk.g.b(r8)
            r8 = r7
            goto L_0x007e
        L_0x001f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0027:
            gk.g.b(r8)
            goto L_0x0083
        L_0x002b:
            gk.g.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.h r8 = (kotlin.sequences.h) r8
            kotlinx.coroutines.JobSupport r1 = r7.this$0
            java.lang.Object r1 = r1.q0()
            boolean r4 = r1 instanceof kotlinx.coroutines.u
            if (r4 == 0) goto L_0x0049
            kotlinx.coroutines.u r1 = (kotlinx.coroutines.u) r1
            kotlinx.coroutines.v r1 = r1.f32727e
            r7.label = r3
            java.lang.Object r8 = r8.c(r1, r7)
            if (r8 != r0) goto L_0x0083
            return r0
        L_0x0049:
            boolean r3 = r1 instanceof kotlinx.coroutines.n1
            if (r3 == 0) goto L_0x0083
            kotlinx.coroutines.n1 r1 = (kotlinx.coroutines.n1) r1
            kotlinx.coroutines.d2 r1 = r1.f()
            if (r1 == 0) goto L_0x0083
            java.lang.Object r3 = r1.L()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L_0x0060:
            boolean r5 = kotlin.jvm.internal.j.b(r1, r3)
            if (r5 != 0) goto L_0x0083
            boolean r5 = r1 instanceof kotlinx.coroutines.u
            if (r5 == 0) goto L_0x007e
            r5 = r1
            kotlinx.coroutines.u r5 = (kotlinx.coroutines.u) r5
            kotlinx.coroutines.v r5 = r5.f32727e
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.c(r5, r8)
            if (r5 != r0) goto L_0x007e
            return r0
        L_0x007e:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.N()
            goto L_0x0060
        L_0x0083:
            kotlin.Unit r8 = kotlin.Unit.f32013a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import pk.n;

@d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {57, 79, 82}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"R", "T", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ b<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.c<R> $this_combineInternal;
    final /* synthetic */ n<kotlinx.coroutines.flow.c<? super R>, T[], c<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(b<? extends T>[] bVarArr, Function0<T[]> function0, n<? super kotlinx.coroutines.flow.c<? super R>, ? super T[], ? super c<? super Unit>, ? extends Object> nVar, kotlinx.coroutines.flow.c<? super R> cVar, c<? super CombineKt$combineInternal$2> cVar2) {
        super(2, cVar2);
        this.$flows = bVarArr;
        this.$arrayFactory = function0;
        this.$transform = nVar;
        this.$this_combineInternal = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, cVar);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((CombineKt$combineInternal$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec A[LOOP:1: B:26:0x00ec->B:32:0x010f, LOOP_START, PHI: r3 r10 
      PHI: (r3v3 int) = (r3v2 int), (r3v4 int) binds: [B:23:0x00e7, B:32:0x010f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:23:0x00e7, B:32:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r6) goto L_0x0052
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.d r8 = (kotlinx.coroutines.channels.d) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            gk.g.b(r24)
            r13 = r3
            r14 = r9
            r3 = r2
            r2 = r7
            r7 = r8
            r8 = r0
            goto L_0x0165
        L_0x002f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0037:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.d r8 = (kotlinx.coroutines.channels.d) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            gk.g.b(r24)
            r13 = r3
            r14 = r9
            r3 = r2
            r2 = r7
            r7 = r8
            r8 = r0
            goto L_0x00c7
        L_0x0052:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r7 = r0.L$2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.d r8 = (kotlinx.coroutines.channels.d) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            gk.g.b(r24)
            r10 = r24
            kotlinx.coroutines.channels.h r10 = (kotlinx.coroutines.channels.h) r10
            java.lang.Object r10 = r10.l()
            r15 = r9
            r9 = r0
            r22 = r7
            r7 = r2
            r2 = r22
            goto L_0x00e1
        L_0x0076:
            gk.g.b(r24)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.k0 r2 = (kotlinx.coroutines.k0) r2
            kotlinx.coroutines.flow.b<T>[] r7 = r0.$flows
            int r13 = r7.length
            if (r13 != 0) goto L_0x0085
            kotlin.Unit r1 = kotlin.Unit.f32013a
            return r1
        L_0x0085:
            java.lang.Object[] r14 = new java.lang.Object[r13]
            kotlinx.coroutines.internal.f0 r8 = kotlinx.coroutines.flow.internal.l.f32465b
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r14
            kotlin.collections.k.n(r7, r8, r9, r10, r11, r12)
            r7 = 6
            r8 = 0
            kotlinx.coroutines.channels.d r21 = kotlinx.coroutines.channels.g.b(r13, r8, r8, r7, r8)
            java.util.concurrent.atomic.AtomicInteger r12 = new java.util.concurrent.atomic.AtomicInteger
            r12.<init>(r13)
            r11 = r3
        L_0x009d:
            if (r11 >= r13) goto L_0x00c2
            r8 = 0
            r9 = 0
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r10 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.b<T>[] r7 = r0.$flows
            r20 = 0
            r15 = r10
            r16 = r7
            r17 = r11
            r18 = r12
            r19 = r21
            r15.<init>(r16, r17, r18, r19, r20)
            r15 = 3
            r16 = 0
            r7 = r2
            r11 = r15
            r15 = r12
            r12 = r16
            kotlinx.coroutines.s1 unused = kotlinx.coroutines.j.d(r7, r8, r9, r10, r11, r12)
            int r11 = r17 + 1
            r12 = r15
            goto L_0x009d
        L_0x00c2:
            byte[] r2 = new byte[r13]
            r8 = r0
            r7 = r21
        L_0x00c7:
            int r3 = r3 + r6
            byte r3 = (byte) r3
            r8.L$0 = r14
            r8.L$1 = r7
            r8.L$2 = r2
            r8.I$0 = r13
            r8.I$1 = r3
            r8.label = r6
            java.lang.Object r10 = r7.A(r8)
            if (r10 != r1) goto L_0x00dc
            return r1
        L_0x00dc:
            r9 = r8
            r15 = r14
            r8 = r7
            r7 = r3
            r3 = r13
        L_0x00e1:
            java.lang.Object r10 = kotlinx.coroutines.channels.h.f(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00ec
            kotlin.Unit r1 = kotlin.Unit.f32013a
            return r1
        L_0x00ec:
            int r11 = r10.c()
            r12 = r15[r11]
            java.lang.Object r10 = r10.d()
            r15[r11] = r10
            kotlinx.coroutines.internal.f0 r10 = kotlinx.coroutines.flow.internal.l.f32465b
            if (r12 != r10) goto L_0x00fe
            int r3 = r3 + -1
        L_0x00fe:
            byte r10 = r2[r11]
            if (r10 == r7) goto L_0x0111
            byte r10 = (byte) r7
            r2[r11] = r10
            java.lang.Object r10 = r8.z()
            java.lang.Object r10 = kotlinx.coroutines.channels.h.f(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00ec
        L_0x0111:
            if (r3 != 0) goto L_0x0168
            kotlin.jvm.functions.Function0<T[]> r10 = r9.$arrayFactory
            java.lang.Object r10 = r10.invoke()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x013a
            pk.n<kotlinx.coroutines.flow.c<? super R>, T[], kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r10 = r9.$transform
            kotlinx.coroutines.flow.c<R> r11 = r9.$this_combineInternal
            r9.L$0 = r15
            r9.L$1 = r8
            r9.L$2 = r2
            r9.I$0 = r3
            r9.I$1 = r7
            r9.label = r5
            java.lang.Object r10 = r10.l(r11, r15, r9)
            if (r10 != r1) goto L_0x0134
            return r1
        L_0x0134:
            r13 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r14 = r15
            goto L_0x00c7
        L_0x013a:
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 14
            r18 = 0
            r11 = r15
            r12 = r10
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            java.lang.Object[] unused = kotlin.collections.k.i(r11, r12, r13, r14, r15, r16, r17)
            pk.n<kotlinx.coroutines.flow.c<? super R>, T[], kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r11 = r9.$transform
            kotlinx.coroutines.flow.c<R> r12 = r9.$this_combineInternal
            r9.L$0 = r5
            r9.L$1 = r8
            r9.L$2 = r2
            r9.I$0 = r3
            r9.I$1 = r7
            r9.label = r4
            java.lang.Object r10 = r11.l(r12, r10, r9)
            if (r10 != r1) goto L_0x0169
            return r1
        L_0x0165:
            r5 = 2
            goto L_0x00c7
        L_0x0168:
            r5 = r15
        L_0x0169:
            r13 = r3
            r14 = r5
            r3 = r7
            r7 = r8
            r8 = r9
            goto L_0x0165
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

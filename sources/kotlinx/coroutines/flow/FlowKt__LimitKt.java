package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import pk.n;

@Metadata(bv = {}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001a+\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aJ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000b\u001a^\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u000120\b\u0001\u0010\u0015\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "", "count", "b", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "c", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/b;", "e", "Lkotlinx/coroutines/flow/c;", "value", "", "d", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "R", "Lkotlin/Function3;", "transform", "g", "(Lkotlinx/coroutines/flow/b;Lpk/n;)Lkotlinx/coroutines/flow/b;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__LimitKt {

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$a", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f32380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f32381b;

        public a(b bVar, int i10) {
            this.f32380a = bVar;
            this.f32381b = i10;
        }

        public Object a(c<? super T> cVar, c<? super Unit> cVar2) {
            Object a10 = this.f32380a.a(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), this.f32381b, cVar), cVar2);
            if (a10 == b.d()) {
                return a10;
            }
            return Unit.f32013a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$b", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f32382a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function2 f32383b;

        public b(b bVar, Function2 function2) {
            this.f32382a = bVar;
            this.f32383b = function2;
        }

        public Object a(c<? super T> cVar, c<? super Unit> cVar2) {
            Object a10 = this.f32382a.a(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), cVar, this.f32383b), cVar2);
            if (a10 == b.d()) {
                return a10;
            }
            return Unit.f32013a;
        }
    }

    public static final <T> b<T> b(b<? extends T> bVar, int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new a(bVar, i10);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i10).toString());
    }

    public static final <T> b<T> c(b<? extends T> bVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2) {
        return new b(bVar, function2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object d(kotlinx.coroutines.flow.c<? super T> r4, T r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x002d:
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.c r4 = (kotlinx.coroutines.flow.c) r4
            gk.g.b(r6)
            goto L_0x0043
        L_0x0035:
            gk.g.b(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.c(r5, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.d(kotlinx.coroutines.flow.c, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> b<T> e(b<? extends T> bVar, int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(bVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " should be positive").toString());
    }

    public static final <T> b<T> f(b<? extends T> bVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(bVar, function2);
    }

    public static final <T, R> b<R> g(b<? extends T> bVar, n<? super c<? super R>, ? super T, ? super c<? super Boolean>, ? extends Object> nVar) {
        return d.v(new FlowKt__LimitKt$transformWhile$1(bVar, nVar, (c<? super FlowKt__LimitKt$transformWhile$1>) null));
    }
}

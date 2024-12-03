package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import pk.n;

@d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {214, 214}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/c;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements n<c<? super R>, T, c<? super Unit>, Object> {
    final /* synthetic */ Function2<T, c<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__MergeKt$mapLatest$1(Function2<? super T, ? super c<? super R>, ? extends Object> function2, c<? super FlowKt__MergeKt$mapLatest$1> cVar) {
        super(3, cVar);
        this.$transform = function2;
    }

    /* renamed from: i */
    public final Object l(c<? super R> cVar, T t10, c<? super Unit> cVar2) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, cVar2);
        flowKt__MergeKt$mapLatest$1.L$0 = cVar;
        flowKt__MergeKt$mapLatest$1.L$1 = t10;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            gk.g.b(r6)
            goto L_0x0045
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r6)
            goto L_0x0039
        L_0x0022:
            gk.g.b(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            java.lang.Object r6 = r5.L$1
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.c<? super R>, java.lang.Object> r4 = r5.$transform
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.invoke(r6, r5)
            if (r6 != r0) goto L_0x0039
            return r0
        L_0x0039:
            r3 = 0
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = r1.c(r6, r5)
            if (r6 != r0) goto L_0x0045
            return r0
        L_0x0045:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__LimitKt$dropWhile$1$1<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f32387a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c<T> f32388b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function2<T, c<? super Boolean>, Object> f32389c;

    FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef ref$BooleanRef, c<? super T> cVar, Function2<? super T, ? super c<? super Boolean>, ? extends Object> function2) {
        this.f32387a = ref$BooleanRef;
        this.f32388b = cVar;
        this.f32389c = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(T r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r8)
            goto L_0x0088
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            gk.g.b(r8)
            goto L_0x006c
        L_0x0041:
            gk.g.b(r8)
            goto L_0x0059
        L_0x0045:
            gk.g.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f32387a
            boolean r8 = r8.element
            if (r8 == 0) goto L_0x005c
            kotlinx.coroutines.flow.c<T> r8 = r6.f32388b
            r0.label = r5
            java.lang.Object r7 = r8.c(r7, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        L_0x005c:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f32389c
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r6
        L_0x006c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x008b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f32387a
            r8.element = r5
            kotlinx.coroutines.flow.c<T> r8 = r2.f32388b
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r8.c(r7, r0)
            if (r7 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        L_0x008b:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}

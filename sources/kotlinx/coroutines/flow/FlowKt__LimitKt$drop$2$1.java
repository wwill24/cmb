package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__LimitKt$drop$2$1<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref$IntRef f32384a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f32385b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c<T> f32386c;

    FlowKt__LimitKt$drop$2$1(Ref$IntRef ref$IntRef, int i10, c<? super T> cVar) {
        this.f32384a = ref$IntRef;
        this.f32385b = i10;
        this.f32386c = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(T r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r7)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            gk.g.b(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f32384a
            int r2 = r7.element
            int r4 = r5.f32385b
            if (r2 < r4) goto L_0x004a
            kotlinx.coroutines.flow.c<T> r7 = r5.f32386c
            r0.label = r3
            java.lang.Object r6 = r7.c(r6, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        L_0x004a:
            int r2 = r2 + r3
            r7.element = r2
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}

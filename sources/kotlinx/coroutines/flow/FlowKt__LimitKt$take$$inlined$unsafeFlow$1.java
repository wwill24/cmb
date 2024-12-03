package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$take$$inlined$unsafeFlow$1", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f32372a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f32373b;

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(b bVar, int i10) {
        this.f32372a = bVar;
        this.f32373b = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlinx.coroutines.flow.c<? super T> r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.c r7 = (kotlinx.coroutines.flow.c) r7
            gk.g.b(r8)     // Catch:{ AbortFlowException -> 0x0051 }
            goto L_0x0055
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            gk.g.b(r8)
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            kotlinx.coroutines.flow.b r2 = r6.f32372a     // Catch:{ AbortFlowException -> 0x0051 }
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1 r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1     // Catch:{ AbortFlowException -> 0x0051 }
            int r5 = r6.f32373b     // Catch:{ AbortFlowException -> 0x0051 }
            r4.<init>(r8, r5, r7)     // Catch:{ AbortFlowException -> 0x0051 }
            r0.L$0 = r7     // Catch:{ AbortFlowException -> 0x0051 }
            r0.label = r3     // Catch:{ AbortFlowException -> 0x0051 }
            java.lang.Object r7 = r2.a(r4, r0)     // Catch:{ AbortFlowException -> 0x0051 }
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0051:
            r8 = move-exception
            kotlinx.coroutines.flow.internal.h.a(r8, r7)
        L_0x0055:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.c, kotlin.coroutines.c):java.lang.Object");
    }
}

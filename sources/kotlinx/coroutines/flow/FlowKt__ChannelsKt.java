package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.flow.internal.d;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\fH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"T", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/channels/q;", "channel", "", "b", "(Lkotlinx/coroutines/flow/c;Lkotlinx/coroutines/channels/q;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "consume", "c", "(Lkotlinx/coroutines/flow/c;Lkotlinx/coroutines/channels/q;ZLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/k0;", "scope", "d", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object b(c<? super T> cVar, q<? extends T> qVar, c<? super Unit> cVar2) {
        Object c10 = c(cVar, qVar, true, cVar2);
        return c10 == b.d() ? c10 : Unit.f32013a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[SYNTHETIC, Splitter:B:36:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.c<? super T> r7, kotlinx.coroutines.channels.q<? extends T> r8, boolean r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.q r8 = (kotlinx.coroutines.channels.q) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.c r9 = (kotlinx.coroutines.flow.c) r9
            gk.g.b(r10)     // Catch:{ all -> 0x0055 }
        L_0x0035:
            r6 = r9
            r9 = r7
            r7 = r6
            goto L_0x005d
        L_0x0039:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0041:
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.q r8 = (kotlinx.coroutines.channels.q) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.c r9 = (kotlinx.coroutines.flow.c) r9
            gk.g.b(r10)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.channels.h r10 = (kotlinx.coroutines.channels.h) r10     // Catch:{ all -> 0x0055 }
            java.lang.Object r10 = r10.l()     // Catch:{ all -> 0x0055 }
            goto L_0x006f
        L_0x0055:
            r9 = move-exception
            goto L_0x009c
        L_0x0057:
            gk.g.b(r10)
            kotlinx.coroutines.flow.d.r(r7)
        L_0x005d:
            r0.L$0 = r7     // Catch:{ all -> 0x0098 }
            r0.L$1 = r8     // Catch:{ all -> 0x0098 }
            r0.Z$0 = r9     // Catch:{ all -> 0x0098 }
            r0.label = r4     // Catch:{ all -> 0x0098 }
            java.lang.Object r10 = r8.A(r0)     // Catch:{ all -> 0x0098 }
            if (r10 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x006f:
            r2 = 0
            boolean r5 = kotlinx.coroutines.channels.h.i(r10)     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0085
            java.lang.Throwable r9 = kotlinx.coroutines.channels.h.e(r10)     // Catch:{ all -> 0x0055 }
            if (r9 != 0) goto L_0x0084
            if (r7 == 0) goto L_0x0081
            kotlinx.coroutines.channels.i.a(r8, r2)
        L_0x0081:
            kotlin.Unit r7 = kotlin.Unit.f32013a
            return r7
        L_0x0084:
            throw r9     // Catch:{ all -> 0x0055 }
        L_0x0085:
            java.lang.Object r10 = kotlinx.coroutines.channels.h.g(r10)     // Catch:{ all -> 0x0055 }
            r0.L$0 = r9     // Catch:{ all -> 0x0055 }
            r0.L$1 = r8     // Catch:{ all -> 0x0055 }
            r0.Z$0 = r7     // Catch:{ all -> 0x0055 }
            r0.label = r3     // Catch:{ all -> 0x0055 }
            java.lang.Object r10 = r9.c(r10, r0)     // Catch:{ all -> 0x0055 }
            if (r10 != r1) goto L_0x0035
            return r1
        L_0x0098:
            r7 = move-exception
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x009c:
            throw r9     // Catch:{ all -> 0x009d }
        L_0x009d:
            r10 = move-exception
            if (r7 == 0) goto L_0x00a3
            kotlinx.coroutines.channels.i.a(r8, r9)
        L_0x00a3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.c(kotlinx.coroutines.flow.c, kotlinx.coroutines.channels.q, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> q<T> d(b<? extends T> bVar, k0 k0Var) {
        return d.b(bVar).n(k0Var);
    }
}

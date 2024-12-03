package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001aM\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017¨\u0006\u0019"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "", "replay", "Lkotlinx/coroutines/flow/o;", "b", "(Lkotlinx/coroutines/flow/b;I)Lkotlinx/coroutines/flow/o;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/CoroutineContext;", "context", "upstream", "Lkotlinx/coroutines/flow/h;", "shared", "Lkotlinx/coroutines/flow/p;", "started", "initialValue", "Lkotlinx/coroutines/s1;", "c", "(Lkotlinx/coroutines/k0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/p;Ljava/lang/Object;)Lkotlinx/coroutines/s1;", "scope", "Lkotlinx/coroutines/flow/r;", "d", "(Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/k0;Lkotlinx/coroutines/flow/p;Ljava/lang/Object;)Lkotlinx/coroutines/flow/r;", "Lkotlinx/coroutines/flow/i;", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> r<T> a(i<T> iVar) {
        return new j(iVar, (s1) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r3 == 0) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.coroutines.flow.o<T> b(kotlinx.coroutines.flow.b<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.d$a r0 = kotlinx.coroutines.channels.d.A
            int r0 = r0.a()
            int r0 = vk.j.c(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L_0x003d
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.b r2 = r1.k()
            if (r2 == 0) goto L_0x003d
            kotlinx.coroutines.flow.o r7 = new kotlinx.coroutines.flow.o
            int r3 = r1.f32436b
            r4 = -3
            r5 = 0
            if (r3 == r4) goto L_0x0027
            r4 = -2
            if (r3 == r4) goto L_0x0027
            if (r3 == 0) goto L_0x0027
            r0 = r3
            goto L_0x0035
        L_0x0027:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f32437c
            kotlinx.coroutines.channels.BufferOverflow r6 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 != r6) goto L_0x0030
            if (r3 != 0) goto L_0x0035
            goto L_0x0034
        L_0x0030:
            if (r8 != 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = r5
        L_0x0035:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f32437c
            kotlin.coroutines.CoroutineContext r1 = r1.f32435a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L_0x003d:
            kotlinx.coroutines.flow.o r8 = new kotlinx.coroutines.flow.o
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.f32070a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.b(kotlinx.coroutines.flow.b, int):kotlinx.coroutines.flow.o");
    }

    private static final <T> s1 c(k0 k0Var, CoroutineContext coroutineContext, b<? extends T> bVar, h<T> hVar, p pVar, T t10) {
        CoroutineStart coroutineStart;
        if (j.b(pVar, p.f32480a.a())) {
            coroutineStart = CoroutineStart.DEFAULT;
        } else {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return h.c(k0Var, coroutineContext, coroutineStart, new FlowKt__ShareKt$launchSharing$1(pVar, bVar, hVar, t10, (c<? super FlowKt__ShareKt$launchSharing$1>) null));
    }

    public static final <T> r<T> d(b<? extends T> bVar, k0 k0Var, p pVar, T t10) {
        o<? extends T> b10 = b(bVar, 1);
        i a10 = s.a(t10);
        return new j(a10, c(k0Var, b10.f32479d, b10.f32476a, a10, pVar, t10));
    }
}

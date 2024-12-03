package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001ab\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2*\b\u0001\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016j\u0004\u0018\u0001`\u00182*\b\u0001\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/channels/o;", "Lkotlin/Function0;", "", "block", "a", "(Lkotlinx/coroutines/channels/o;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlinx/coroutines/channels/q;", "b", "(Lkotlinx/coroutines/k0;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/q;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "c", "(Lkotlinx/coroutines/k0;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/q;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ProduceKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: kotlin.jvm.functions.Function0<kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlinx.coroutines.channels.o<?> r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.o r4 = (kotlinx.coroutines.channels.o) r4
            gk.g.b(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x007a
        L_0x0032:
            r4 = move-exception
            goto L_0x0080
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            gk.g.b(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.s1$b r2 = kotlinx.coroutines.s1.f32618v
            kotlin.coroutines.CoroutineContext$Element r6 = r6.c(r2)
            if (r6 != r4) goto L_0x004d
            r6 = r3
            goto L_0x004e
        L_0x004d:
            r6 = 0
        L_0x004e:
            if (r6 == 0) goto L_0x0084
            r0.L$0 = r4     // Catch:{ all -> 0x0032 }
            r0.L$1 = r5     // Catch:{ all -> 0x0032 }
            r0.label = r3     // Catch:{ all -> 0x0032 }
            kotlinx.coroutines.o r6 = new kotlinx.coroutines.o     // Catch:{ all -> 0x0032 }
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)     // Catch:{ all -> 0x0032 }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x0032 }
            r6.y()     // Catch:{ all -> 0x0032 }
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch:{ all -> 0x0032 }
            r2.<init>(r6)     // Catch:{ all -> 0x0032 }
            r4.s(r2)     // Catch:{ all -> 0x0032 }
            java.lang.Object r4 = r6.v()     // Catch:{ all -> 0x0032 }
            java.lang.Object r6 = kotlin.coroutines.intrinsics.b.d()     // Catch:{ all -> 0x0032 }
            if (r4 != r6) goto L_0x0077
            kotlin.coroutines.jvm.internal.f.c(r0)     // Catch:{ all -> 0x0032 }
        L_0x0077:
            if (r4 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r5.invoke()
            kotlin.Unit r4 = kotlin.Unit.f32013a
            return r4
        L_0x0080:
            r5.invoke()
            throw r4
        L_0x0084:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(kotlinx.coroutines.channels.o, kotlin.jvm.functions.Function0, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <E> q<E> b(k0 k0Var, CoroutineContext coroutineContext, int i10, Function2<? super o<? super E>, ? super c<? super Unit>, ? extends Object> function2) {
        return c(k0Var, coroutineContext, i10, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, (Function1<? super Throwable, Unit>) null, function2);
    }

    public static final <E> q<E> c(k0 k0Var, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super o<? super E>, ? super c<? super Unit>, ? extends Object> function2) {
        n nVar = new n(CoroutineContextKt.e(k0Var, coroutineContext), g.b(i10, bufferOverflow, (Function1) null, 4, (Object) null));
        if (function1 != null) {
            nVar.y(function1);
        }
        nVar.h1(coroutineStart, nVar, function2);
        return nVar;
    }

    public static /* synthetic */ q d(k0 k0Var, CoroutineContext coroutineContext, int i10, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return b(k0Var, coroutineContext, i10, function2);
    }

    public static /* synthetic */ q e(k0 k0Var, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i11 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i11 & 16) != 0) {
            function1 = null;
        }
        return c(k0Var, coroutineContext2, i12, bufferOverflow2, coroutineStart2, function1, function2);
    }
}

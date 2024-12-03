package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.q2;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aH\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0012\u0010\f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00060\nH\u0000\"\u001a\u0010\u0012\u001a\u00020\r8\u0002X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0014\u001a\u00020\r8\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\u000f\u0012\u0004\b\u0013\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlin/coroutines/c;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "", "onCancellation", "b", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/i;", "", "d", "Lkotlinx/coroutines/internal/f0;", "a", "Lkotlinx/coroutines/internal/f0;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f32539a = new f0("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32540b = new f0("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        if (r8.j1() != false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void b(kotlin.coroutines.c<? super T> r6, java.lang.Object r7, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.i
            if (r0 == 0) goto L_0x00b6
            kotlinx.coroutines.internal.i r6 = (kotlinx.coroutines.internal.i) r6
            java.lang.Object r8 = kotlinx.coroutines.e0.b(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.f32535d
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.O(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f32537f = r8
            r6.f32728c = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.f32535d
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.E(r8, r6)
            goto L_0x00b9
        L_0x0026:
            kotlinx.coroutines.q2 r0 = kotlinx.coroutines.q2.f32598a
            kotlinx.coroutines.d1 r0 = r0.b()
            boolean r2 = r0.B0()
            if (r2 == 0) goto L_0x003b
            r6.f32537f = r8
            r6.f32728c = r1
            r0.i0(r6)
            goto L_0x00b9
        L_0x003b:
            r0.q0(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.s1$b r4 = kotlinx.coroutines.s1.f32618v     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.CoroutineContext$Element r3 = r3.c(r4)     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.s1 r3 = (kotlinx.coroutines.s1) r3     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0069
            boolean r4 = r3.a()     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.CancellationException r3 = r3.n()     // Catch:{ all -> 0x00a9 }
            r6.b(r8, r3)     // Catch:{ all -> 0x00a9 }
            kotlin.Result$a r8 = kotlin.Result.f32010a     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = gk.g.a(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch:{ all -> 0x00a9 }
            r6.resumeWith(r8)     // Catch:{ all -> 0x00a9 }
            r8 = r1
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            if (r8 != 0) goto L_0x00a2
            kotlin.coroutines.c<T> r8 = r6.f32536e     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r6.f32538g     // Catch:{ all -> 0x00a9 }
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r3)     // Catch:{ all -> 0x00a9 }
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.internal.ThreadContextKt.f32507a     // Catch:{ all -> 0x00a9 }
            if (r3 == r5) goto L_0x0081
            kotlinx.coroutines.x2 r8 = kotlinx.coroutines.CoroutineContextKt.g(r8, r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x0082
        L_0x0081:
            r8 = r2
        L_0x0082:
            kotlin.coroutines.c<T> r5 = r6.f32536e     // Catch:{ all -> 0x0095 }
            r5.resumeWith(r7)     // Catch:{ all -> 0x0095 }
            kotlin.Unit r7 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0095 }
            if (r8 == 0) goto L_0x0091
            boolean r7 = r8.j1()     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x00a2
        L_0x0091:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a2
        L_0x0095:
            r7 = move-exception
            if (r8 == 0) goto L_0x009e
            boolean r8 = r8.j1()     // Catch:{ all -> 0x00a9 }
            if (r8 == 0) goto L_0x00a1
        L_0x009e:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x00a9 }
        L_0x00a1:
            throw r7     // Catch:{ all -> 0x00a9 }
        L_0x00a2:
            boolean r7 = r0.I0()     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x00a2
            goto L_0x00ad
        L_0x00a9:
            r7 = move-exception
            r6.g(r7, r2)     // Catch:{ all -> 0x00b1 }
        L_0x00ad:
            r0.Y(r1)
            goto L_0x00b9
        L_0x00b1:
            r6 = move-exception
            r0.Y(r1)
            throw r6
        L_0x00b6:
            r6.resumeWith(r7)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j.b(kotlin.coroutines.c, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void c(c cVar, Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        b(cVar, obj, function1);
    }

    public static final boolean d(i<? super Unit> iVar) {
        Unit unit = Unit.f32013a;
        d1 b10 = q2.f32598a.b();
        if (b10.E0()) {
            return false;
        }
        if (b10.B0()) {
            iVar.f32537f = unit;
            iVar.f32728c = 1;
            b10.i0(iVar);
            return true;
        }
        b10.q0(true);
        try {
            iVar.run();
            do {
            } while (b10.I0());
        } catch (Throwable th2) {
            b10.Y(true);
            throw th2;
        }
        b10.Y(true);
        return false;
    }
}

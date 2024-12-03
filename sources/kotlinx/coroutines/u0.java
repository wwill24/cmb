package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.scheduling.g;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0019\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8 X \u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001b¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/u0;", "T", "Lkotlinx/coroutines/scheduling/g;", "Lkotlinx/coroutines/SchedulerTask;", "", "h", "()Ljava/lang/Object;", "takenState", "", "cause", "", "b", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "exception", "finallyException", "g", "", "c", "I", "resumeMode", "Lkotlin/coroutines/c;", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class u0<T> extends g {

    /* renamed from: c  reason: collision with root package name */
    public int f32728c;

    public u0(int i10) {
        this.f32728c = i10;
    }

    public void b(Object obj, Throwable th2) {
    }

    public abstract c<T> c();

    public Throwable e(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.f32285a;
        }
        return null;
    }

    public <T> T f(Object obj) {
        return obj;
    }

    public final void g(Throwable th2, Throwable th3) {
        if (th2 != null || th3 != null) {
            if (!(th2 == null || th3 == null)) {
                b.a(th2, th3);
            }
            if (th2 == null) {
                th2 = th3;
            }
            j.d(th2);
            i0.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
        }
    }

    public abstract Object h();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        if (r4.j1() != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r4.j1() != false) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.h r0 = r10.f32657b
            kotlin.coroutines.c r1 = r10.c()     // Catch:{ all -> 0x00b0 }
            kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.i) r1     // Catch:{ all -> 0x00b0 }
            kotlin.coroutines.c<T> r2 = r1.f32536e     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r1.f32538g     // Catch:{ all -> 0x00b0 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch:{ all -> 0x00b0 }
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.internal.ThreadContextKt.f32507a     // Catch:{ all -> 0x00b0 }
            r5 = 0
            if (r1 == r4) goto L_0x001e
            kotlinx.coroutines.x2 r4 = kotlinx.coroutines.CoroutineContextKt.g(r2, r3, r1)     // Catch:{ all -> 0x00b0 }
            goto L_0x001f
        L_0x001e:
            r4 = r5
        L_0x001f:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r7 = r10.h()     // Catch:{ all -> 0x00a3 }
            java.lang.Throwable r8 = r10.e(r7)     // Catch:{ all -> 0x00a3 }
            if (r8 != 0) goto L_0x003e
            int r9 = r10.f32728c     // Catch:{ all -> 0x00a3 }
            boolean r9 = kotlinx.coroutines.v0.b(r9)     // Catch:{ all -> 0x00a3 }
            if (r9 == 0) goto L_0x003e
            kotlinx.coroutines.s1$b r9 = kotlinx.coroutines.s1.f32618v     // Catch:{ all -> 0x00a3 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.c(r9)     // Catch:{ all -> 0x00a3 }
            kotlinx.coroutines.s1 r6 = (kotlinx.coroutines.s1) r6     // Catch:{ all -> 0x00a3 }
            goto L_0x003f
        L_0x003e:
            r6 = r5
        L_0x003f:
            if (r6 == 0) goto L_0x005c
            boolean r9 = r6.a()     // Catch:{ all -> 0x00a3 }
            if (r9 != 0) goto L_0x005c
            java.util.concurrent.CancellationException r6 = r6.n()     // Catch:{ all -> 0x00a3 }
            r10.b(r7, r6)     // Catch:{ all -> 0x00a3 }
            kotlin.Result$a r7 = kotlin.Result.f32010a     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = gk.g.a(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
            goto L_0x0079
        L_0x005c:
            if (r8 == 0) goto L_0x006c
            kotlin.Result$a r6 = kotlin.Result.f32010a     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = gk.g.a(r8)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
            goto L_0x0079
        L_0x006c:
            kotlin.Result$a r6 = kotlin.Result.f32010a     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = r10.f(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x00a3 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00a3 }
        L_0x0079:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x0083
            boolean r2 = r4.j1()     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x0086
        L_0x0083:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00b0 }
        L_0x0086:
            r0.a()     // Catch:{ all -> 0x0090 }
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x009b
        L_0x0090:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.f32010a
            java.lang.Object r0 = gk.g.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x009b:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.g(r5, r0)
            goto L_0x00cf
        L_0x00a3:
            r2 = move-exception
            if (r4 == 0) goto L_0x00ac
            boolean r4 = r4.j1()     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x00af
        L_0x00ac:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x00b0 }
        L_0x00af:
            throw r2     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.f32010a     // Catch:{ all -> 0x00bd }
            r0.a()     // Catch:{ all -> 0x00bd }
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00bd }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x00bd }
            goto L_0x00c8
        L_0x00bd:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.f32010a
            java.lang.Object r0 = gk.g.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x00c8:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.g(r1, r0)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.u0.run():void");
    }
}

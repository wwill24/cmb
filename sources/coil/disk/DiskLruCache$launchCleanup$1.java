package coil.disk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "coil.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class DiskLruCache$launchCleanup$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$launchCleanup$1(DiskLruCache diskLruCache, c<? super DiskLruCache$launchCleanup$1> cVar) {
        super(2, cVar);
        this.this$0 = diskLruCache;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DiskLruCache$launchCleanup$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DiskLruCache$launchCleanup$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:9|10|11|12|13|14|15|(1:17)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        coil.disk.DiskLruCache.n(r3, true);
        coil.disk.DiskLruCache.m(r3, okio.Okio.b(okio.Okio.a()));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0022=Splitter:B:14:0x0022, B:23:0x003e=Splitter:B:23:0x003e, B:12:0x001f=Splitter:B:12:0x001f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        /*
            r2 = this;
            java.lang.Object unused = kotlin.coroutines.intrinsics.b.d()
            int r0 = r2.label
            if (r0 != 0) goto L_0x0045
            gk.g.b(r3)
            coil.disk.DiskLruCache r3 = r2.this$0
            monitor-enter(r3)
            boolean r0 = r3.f8136p     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x003e
            boolean r0 = r3.f8137q     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x001a
            goto L_0x003e
        L_0x001a:
            r0 = 1
            r3.e0()     // Catch:{ IOException -> 0x001f }
            goto L_0x0022
        L_0x001f:
            r3.f8138t = r0     // Catch:{ all -> 0x0042 }
        L_0x0022:
            boolean r1 = r3.J()     // Catch:{ IOException -> 0x002c }
            if (r1 == 0) goto L_0x003a
            r3.i0()     // Catch:{ IOException -> 0x002c }
            goto L_0x003a
        L_0x002c:
            r3.f8139w = r0     // Catch:{ all -> 0x0042 }
            okio.Sink r0 = okio.Okio.a()     // Catch:{ all -> 0x0042 }
            okio.BufferedSink r0 = okio.Okio.b(r0)     // Catch:{ all -> 0x0042 }
            r3.f8134m = r0     // Catch:{ all -> 0x0042 }
        L_0x003a:
            monitor-exit(r3)
            kotlin.Unit r3 = kotlin.Unit.f32013a
            return r3
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return r0
        L_0x0042:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0045:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache$launchCleanup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

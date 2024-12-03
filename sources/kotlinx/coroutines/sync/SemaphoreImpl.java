package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\tJ\u0013\u0010\r\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/e;", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/n;", "cont", "", "e", "(Lkotlinx/coroutines/n;)Z", "g", "()Z", "f", "a", "release", "()V", "", "I", "permits", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "onCancellationRelease", "acquiredPermits", "<init>", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class SemaphoreImpl implements e {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32697c;

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f32698d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32699e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f32700f;

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f32701g;
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f32702a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f32703b;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    private volatile /* synthetic */ Object head;
    private volatile /* synthetic */ Object tail;

    static {
        Class<Object> cls = Object.class;
        Class<SemaphoreImpl> cls2 = SemaphoreImpl.class;
        f32697c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "head");
        f32698d = AtomicLongFieldUpdater.newUpdater(cls2, "deqIdx");
        f32699e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "tail");
        f32700f = AtomicLongFieldUpdater.newUpdater(cls2, "enqIdx");
        f32701g = AtomicIntegerFieldUpdater.newUpdater(cls2, "_availablePermits");
    }

    public SemaphoreImpl(int i10, int i11) {
        boolean z10;
        this.f32702a = i10;
        boolean z11 = true;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if ((i11 < 0 || i11 > i10) ? false : z11) {
                g gVar = new g(0, (g) null, 2);
                this.head = gVar;
                this.tail = gVar;
                this._availablePermits = i10 - i11;
                this.f32703b = new SemaphoreImpl$onCancellationRelease$1(this);
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
    }

    private final Object d(c<? super Unit> cVar) {
        o b10 = q.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        while (true) {
            if (!e(b10)) {
                if (f32701g.getAndDecrement(this) > 0) {
                    b10.q(Unit.f32013a, this.f32703b);
                    break;
                }
            } else {
                break;
            }
        }
        Object v10 = b10.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(kotlinx.coroutines.n<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.tail
            kotlinx.coroutines.sync.g r0 = (kotlinx.coroutines.sync.g) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f32700f
            long r1 = r1.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.sync.f.f32718f
            long r3 = (long) r3
            long r3 = r1 / r3
        L_0x0011:
            r5 = r0
        L_0x0012:
            long r6 = r5.m()
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x0026
            boolean r6 = r5.g()
            if (r6 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.lang.Object r5 = kotlinx.coroutines.internal.d0.a(r5)
            goto L_0x0038
        L_0x0026:
            java.lang.Object r6 = r5.e()
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.internal.f.f32528a
            if (r6 != r7) goto L_0x00b5
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.internal.f.f32528a
            java.lang.Object r5 = kotlinx.coroutines.internal.d0.a(r5)
        L_0x0038:
            boolean r6 = kotlinx.coroutines.internal.d0.c(r5)
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x007d
            kotlinx.coroutines.internal.c0 r6 = kotlinx.coroutines.internal.d0.b(r5)
        L_0x0044:
            java.lang.Object r9 = r14.tail
            kotlinx.coroutines.internal.c0 r9 = (kotlinx.coroutines.internal.c0) r9
            long r10 = r9.m()
            long r12 = r6.m()
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0056
        L_0x0054:
            r6 = r8
            goto L_0x0070
        L_0x0056:
            boolean r10 = r6.p()
            if (r10 != 0) goto L_0x005e
            r6 = r7
            goto L_0x0070
        L_0x005e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f32699e
            boolean r10 = androidx.concurrent.futures.a.a(r10, r14, r9, r6)
            if (r10 == 0) goto L_0x0073
            boolean r6 = r9.l()
            if (r6 == 0) goto L_0x0054
            r9.j()
            goto L_0x0054
        L_0x0070:
            if (r6 == 0) goto L_0x0011
            goto L_0x007d
        L_0x0073:
            boolean r9 = r6.l()
            if (r9 == 0) goto L_0x0044
            r6.j()
            goto L_0x0044
        L_0x007d:
            kotlinx.coroutines.internal.c0 r0 = kotlinx.coroutines.internal.d0.b(r5)
            kotlinx.coroutines.sync.g r0 = (kotlinx.coroutines.sync.g) r0
            int r3 = kotlinx.coroutines.sync.f.f32718f
            long r3 = (long) r3
            long r1 = r1 % r3
            int r1 = (int) r1
            r2 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f32719e
            boolean r2 = kotlinx.coroutines.scheduling.m.a(r3, r1, r2, r15)
            if (r2 == 0) goto L_0x009c
            kotlinx.coroutines.sync.a r2 = new kotlinx.coroutines.sync.a
            r2.<init>(r0, r1)
            r15.o(r2)
            return r8
        L_0x009c:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.sync.f.f32714b
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.sync.f.f32715c
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f32719e
            boolean r0 = kotlinx.coroutines.scheduling.m.a(r0, r1, r2, r3)
            if (r0 == 0) goto L_0x00b4
            kotlin.Unit r0 = kotlin.Unit.f32013a
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r1 = r14.f32703b
            r15.q(r0, r1)
            return r8
        L_0x00b4:
            return r7
        L_0x00b5:
            kotlinx.coroutines.internal.g r6 = (kotlinx.coroutines.internal.g) r6
            kotlinx.coroutines.internal.c0 r6 = (kotlinx.coroutines.internal.c0) r6
            if (r6 == 0) goto L_0x00be
        L_0x00bb:
            r5 = r6
            goto L_0x0012
        L_0x00be:
            long r6 = r5.m()
            r8 = 1
            long r6 = r6 + r8
            r8 = r5
            kotlinx.coroutines.sync.g r8 = (kotlinx.coroutines.sync.g) r8
            kotlinx.coroutines.sync.g r6 = kotlinx.coroutines.sync.f.j(r6, r8)
            boolean r7 = r5.k(r6)
            if (r7 == 0) goto L_0x0012
            boolean r7 = r5.g()
            if (r7 == 0) goto L_0x00bb
            r5.j()
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.e(kotlinx.coroutines.n):boolean");
    }

    private final boolean f(n<? super Unit> nVar) {
        Object B = nVar.B(Unit.f32013a, (Object) null, this.f32703b);
        if (B == null) {
            return false;
        }
        nVar.M(B);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0070, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean g() {
        /*
            r14 = this;
            java.lang.Object r0 = r14.head
            kotlinx.coroutines.sync.g r0 = (kotlinx.coroutines.sync.g) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f32698d
            long r1 = r1.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.sync.f.f32718f
            long r3 = (long) r3
            long r3 = r1 / r3
        L_0x0011:
            r5 = r0
        L_0x0012:
            long r6 = r5.m()
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x0026
            boolean r6 = r5.g()
            if (r6 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.lang.Object r5 = kotlinx.coroutines.internal.d0.a(r5)
            goto L_0x0038
        L_0x0026:
            java.lang.Object r6 = r5.e()
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.internal.f.f32528a
            if (r6 != r7) goto L_0x00d6
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.internal.f.f32528a
            java.lang.Object r5 = kotlinx.coroutines.internal.d0.a(r5)
        L_0x0038:
            boolean r6 = kotlinx.coroutines.internal.d0.c(r5)
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x007d
            kotlinx.coroutines.internal.c0 r6 = kotlinx.coroutines.internal.d0.b(r5)
        L_0x0044:
            java.lang.Object r9 = r14.head
            kotlinx.coroutines.internal.c0 r9 = (kotlinx.coroutines.internal.c0) r9
            long r10 = r9.m()
            long r12 = r6.m()
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0056
        L_0x0054:
            r6 = r8
            goto L_0x0070
        L_0x0056:
            boolean r10 = r6.p()
            if (r10 != 0) goto L_0x005e
            r6 = r7
            goto L_0x0070
        L_0x005e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f32697c
            boolean r10 = androidx.concurrent.futures.a.a(r10, r14, r9, r6)
            if (r10 == 0) goto L_0x0073
            boolean r6 = r9.l()
            if (r6 == 0) goto L_0x0054
            r9.j()
            goto L_0x0054
        L_0x0070:
            if (r6 == 0) goto L_0x0011
            goto L_0x007d
        L_0x0073:
            boolean r9 = r6.l()
            if (r9 == 0) goto L_0x0044
            r6.j()
            goto L_0x0044
        L_0x007d:
            kotlinx.coroutines.internal.c0 r0 = kotlinx.coroutines.internal.d0.b(r5)
            kotlinx.coroutines.sync.g r0 = (kotlinx.coroutines.sync.g) r0
            r0.b()
            long r5 = r0.m()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x008f
            return r7
        L_0x008f:
            int r3 = kotlinx.coroutines.sync.f.f32718f
            long r3 = (long) r3
            long r1 = r1 % r3
            int r1 = (int) r1
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.sync.f.f32714b
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f32719e
            java.lang.Object r2 = r3.getAndSet(r1, r2)
            if (r2 != 0) goto L_0x00c8
            int r2 = kotlinx.coroutines.sync.f.f32713a
        L_0x00a6:
            if (r7 >= r2) goto L_0x00b8
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f32719e
            java.lang.Object r3 = r3.get(r1)
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.sync.f.f32715c
            if (r3 != r4) goto L_0x00b5
            return r8
        L_0x00b5:
            int r7 = r7 + 1
            goto L_0x00a6
        L_0x00b8:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.sync.f.f32714b
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.sync.f.f32716d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f32719e
            boolean r0 = kotlinx.coroutines.scheduling.m.a(r0, r1, r2, r3)
            r0 = r0 ^ r8
            return r0
        L_0x00c8:
            kotlinx.coroutines.internal.f0 r0 = kotlinx.coroutines.sync.f.f32717e
            if (r2 != r0) goto L_0x00cf
            return r7
        L_0x00cf:
            kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) r2
            boolean r0 = r14.f(r2)
            return r0
        L_0x00d6:
            kotlinx.coroutines.internal.g r6 = (kotlinx.coroutines.internal.g) r6
            kotlinx.coroutines.internal.c0 r6 = (kotlinx.coroutines.internal.c0) r6
            if (r6 == 0) goto L_0x00df
        L_0x00dc:
            r5 = r6
            goto L_0x0012
        L_0x00df:
            long r6 = r5.m()
            r8 = 1
            long r6 = r6 + r8
            r8 = r5
            kotlinx.coroutines.sync.g r8 = (kotlinx.coroutines.sync.g) r8
            kotlinx.coroutines.sync.g r6 = kotlinx.coroutines.sync.f.j(r6, r8)
            boolean r7 = r5.k(r6)
            if (r7 == 0) goto L_0x0012
            boolean r7 = r5.g()
            if (r7 == 0) goto L_0x00dc
            r5.j()
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.g():boolean");
    }

    public Object a(c<? super Unit> cVar) {
        if (f32701g.getAndDecrement(this) > 0) {
            return Unit.f32013a;
        }
        Object d10 = d(cVar);
        if (d10 == b.d()) {
            return d10;
        }
        return Unit.f32013a;
    }

    public void release() {
        boolean z10;
        while (true) {
            int i10 = this._availablePermits;
            if (i10 < this.f32702a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (f32701g.compareAndSet(this, i10, i10 + 1) && (i10 >= 0 || g())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f32702a).toString());
            }
        }
    }
}

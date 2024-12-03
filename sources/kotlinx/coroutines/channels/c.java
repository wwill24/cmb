package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020&\u0012 \u0010E\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Cj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`D¢\u0006\u0004\bF\u0010GJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001dH\u0014¢\u0006\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010.\u001a\u00060*j\u0002`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0014\u00106\u001a\u00020\u001d8DX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u001d8DX\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\u001d8DX\u0004¢\u0006\u0006\u001a\u0004\b9\u00105R\u0014\u0010<\u001a\u00020\u001d8DX\u0004¢\u0006\u0006\u001a\u0004\b;\u00105R\u0014\u0010>\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u00105R\u0014\u0010B\u001a\u00020?8TX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lkotlinx/coroutines/channels/c;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "currentSize", "Lkotlinx/coroutines/internal/f0;", "j0", "(I)Lkotlinx/coroutines/internal/f0;", "element", "", "h0", "(ILjava/lang/Object;)V", "i0", "(I)V", "", "C", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/t;", "send", "h", "(Lkotlinx/coroutines/channels/t;)Ljava/lang/Object;", "b0", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/d;", "select", "c0", "(Lkotlinx/coroutines/selects/d;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/p;", "receive", "", "S", "(Lkotlinx/coroutines/channels/p;)Z", "wasClosed", "X", "(Z)V", "d", "I", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "e", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "f", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "g", "[Ljava/lang/Object;", "buffer", "head", "U", "()Z", "isBufferAlwaysEmpty", "V", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "j", "isClosedForReceive", "", "i", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class c<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final int f32322d;

    /* renamed from: e  reason: collision with root package name */
    private final BufferOverflow f32323e;

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f32324f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f32325g;

    /* renamed from: h  reason: collision with root package name */
    private int f32326h;
    private volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32327a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f32327a = iArr;
        }
    }

    public c(int i10, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.f32322d = i10;
        this.f32323e = bufferOverflow;
        if (i10 < 1 ? false : true) {
            this.f32324f = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i10, 8)];
            k.n(objArr, a.f32311a, 0, 0, 6, (Object) null);
            this.f32325g = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    private final void h0(int i10, E e10) {
        if (i10 < this.f32322d) {
            i0(i10);
            Object[] objArr = this.f32325g;
            objArr[(this.f32326h + i10) % objArr.length] = e10;
            return;
        }
        Object[] objArr2 = this.f32325g;
        int i11 = this.f32326h;
        objArr2[i11 % objArr2.length] = null;
        objArr2[(i10 + i11) % objArr2.length] = e10;
        this.f32326h = (i11 + 1) % objArr2.length;
    }

    private final void i0(int i10) {
        Object[] objArr = this.f32325g;
        if (i10 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f32322d);
            Object[] objArr2 = new Object[min];
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr3 = this.f32325g;
                objArr2[i11] = objArr3[(this.f32326h + i11) % objArr3.length];
            }
            k.m(objArr2, a.f32311a, i10, min);
            this.f32325g = objArr2;
            this.f32326h = 0;
        }
    }

    private final f0 j0(int i10) {
        if (i10 < this.f32322d) {
            this.size = i10 + 1;
            return null;
        }
        int i11 = a.f32327a[this.f32323e.ordinal()];
        if (i11 == 1) {
            return a.f32313c;
        }
        if (i11 == 2) {
            return a.f32312b;
        }
        if (i11 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public Object C(E e10) {
        r J;
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        int i10 = this.size;
        k<?> m10 = m();
        if (m10 != null) {
            reentrantLock.unlock();
            return m10;
        }
        f0 j02 = j0(i10);
        if (j02 != null) {
            reentrantLock.unlock();
            return j02;
        }
        if (i10 == 0) {
            do {
                try {
                    J = J();
                    if (J != null) {
                        if (J instanceof k) {
                            this.size = i10;
                            reentrantLock.unlock();
                            return J;
                        }
                        j.d(J);
                    }
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } while (J.y(e10, (LockFreeLinkedListNode.c) null) == null);
            this.size = i10;
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            J.j(e10);
            return J.c();
        }
        h0(i10, e10);
        f0 f0Var = a.f32312b;
        reentrantLock.unlock();
        return f0Var;
    }

    /* access modifiers changed from: protected */
    public boolean S(p<? super E> pVar) {
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        try {
            return super.S(pVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean U() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean V() {
        return this.size == 0;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void X(boolean z10) {
        Function1<E, Unit> function1 = this.f32318a;
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = this.f32325g[this.f32326h];
                if (!(function1 == null || obj == a.f32311a)) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.f32325g;
                int i12 = this.f32326h;
                objArr[i12] = a.f32311a;
                this.f32326h = (i12 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            super.X(z10);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public Object b0() {
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            if (i10 == 0) {
                Object m10 = m();
                if (m10 == null) {
                    m10 = a.f32314d;
                }
                return m10;
            }
            Object[] objArr = this.f32325g;
            int i11 = this.f32326h;
            Object obj = objArr[i11];
            t tVar = null;
            objArr[i11] = null;
            this.size = i10 - 1;
            Object obj2 = a.f32314d;
            boolean z10 = false;
            if (i10 == this.f32322d) {
                t tVar2 = null;
                while (true) {
                    t L = L();
                    if (L == null) {
                        tVar = tVar2;
                        break;
                    }
                    j.d(L);
                    if (L.a0((LockFreeLinkedListNode.c) null) != null) {
                        obj2 = L.Y();
                        z10 = true;
                        tVar = L;
                        break;
                    }
                    L.b0();
                    tVar2 = L;
                }
            }
            if (obj2 != a.f32314d && !(obj2 instanceof k)) {
                this.size = i10;
                Object[] objArr2 = this.f32325g;
                objArr2[(this.f32326h + i10) % objArr2.length] = obj2;
            }
            this.f32326h = (this.f32326h + 1) % this.f32325g.length;
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            if (z10) {
                j.d(tVar);
                tVar.X();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r7 != kotlinx.coroutines.selects.e.d()) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r8.size = r1;
        r8.f32325g[r8.f32326h] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        if ((r7 instanceof kotlinx.coroutines.channels.k) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r3 = true;
        r2 = r7;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c0(kotlinx.coroutines.selects.d<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f32324f
            r0.lock()
            int r1 = r8.size     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x0015
            kotlinx.coroutines.channels.k r9 = r8.m()     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x0011
            kotlinx.coroutines.internal.f0 r9 = kotlinx.coroutines.channels.a.f32314d     // Catch:{ all -> 0x00c4 }
        L_0x0011:
            r0.unlock()
            return r9
        L_0x0015:
            java.lang.Object[] r2 = r8.f32325g     // Catch:{ all -> 0x00c4 }
            int r3 = r8.f32326h     // Catch:{ all -> 0x00c4 }
            r4 = r2[r3]     // Catch:{ all -> 0x00c4 }
            r5 = 0
            r2[r3] = r5     // Catch:{ all -> 0x00c4 }
            int r2 = r1 + -1
            r8.size = r2     // Catch:{ all -> 0x00c4 }
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.a.f32314d     // Catch:{ all -> 0x00c4 }
            int r3 = r8.f32322d     // Catch:{ all -> 0x00c4 }
            r6 = 1
            if (r1 != r3) goto L_0x0080
        L_0x0029:
            kotlinx.coroutines.channels.AbstractChannel$g r3 = r8.Q()     // Catch:{ all -> 0x00c4 }
            java.lang.Object r7 = r9.w(r3)     // Catch:{ all -> 0x00c4 }
            if (r7 != 0) goto L_0x0043
            java.lang.Object r5 = r3.o()     // Catch:{ all -> 0x00c4 }
            kotlin.jvm.internal.j.d(r5)     // Catch:{ all -> 0x00c4 }
            r2 = r5
            kotlinx.coroutines.channels.t r2 = (kotlinx.coroutines.channels.t) r2     // Catch:{ all -> 0x00c4 }
            java.lang.Object r2 = r2.Y()     // Catch:{ all -> 0x00c4 }
            r3 = r6
            goto L_0x0081
        L_0x0043:
            kotlinx.coroutines.internal.f0 r3 = kotlinx.coroutines.channels.a.f32314d     // Catch:{ all -> 0x00c4 }
            if (r7 == r3) goto L_0x0080
            java.lang.Object r3 = kotlinx.coroutines.internal.c.f32521b     // Catch:{ all -> 0x00c4 }
            if (r7 == r3) goto L_0x0029
            java.lang.Object r2 = kotlinx.coroutines.selects.e.d()     // Catch:{ all -> 0x00c4 }
            if (r7 != r2) goto L_0x005d
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.f32325g     // Catch:{ all -> 0x00c4 }
            int r1 = r8.f32326h     // Catch:{ all -> 0x00c4 }
            r9[r1] = r4     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            return r7
        L_0x005d:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.k     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x0065
            r3 = r6
            r2 = r7
            r5 = r2
            goto L_0x0081
        L_0x0065:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r1.<init>()     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "performAtomicTrySelect(describeTryOffer) returned "
            r1.append(r2)     // Catch:{ all -> 0x00c4 }
            r1.append(r7)     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c4 }
            r9.<init>(r1)     // Catch:{ all -> 0x00c4 }
            throw r9     // Catch:{ all -> 0x00c4 }
        L_0x0080:
            r3 = 0
        L_0x0081:
            kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.channels.a.f32314d     // Catch:{ all -> 0x00c4 }
            if (r2 == r7) goto L_0x0095
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.k     // Catch:{ all -> 0x00c4 }
            if (r7 != 0) goto L_0x0095
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.f32325g     // Catch:{ all -> 0x00c4 }
            int r7 = r8.f32326h     // Catch:{ all -> 0x00c4 }
            int r7 = r7 + r1
            int r1 = r9.length     // Catch:{ all -> 0x00c4 }
            int r7 = r7 % r1
            r9[r7] = r2     // Catch:{ all -> 0x00c4 }
            goto L_0x00ab
        L_0x0095:
            boolean r9 = r9.n()     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x00ab
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.f32325g     // Catch:{ all -> 0x00c4 }
            int r1 = r8.f32326h     // Catch:{ all -> 0x00c4 }
            r9[r1] = r4     // Catch:{ all -> 0x00c4 }
            java.lang.Object r9 = kotlinx.coroutines.selects.e.d()     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            return r9
        L_0x00ab:
            int r9 = r8.f32326h     // Catch:{ all -> 0x00c4 }
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f32325g     // Catch:{ all -> 0x00c4 }
            int r1 = r1.length     // Catch:{ all -> 0x00c4 }
            int r9 = r9 % r1
            r8.f32326h = r9     // Catch:{ all -> 0x00c4 }
            kotlin.Unit r9 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            if (r3 == 0) goto L_0x00c3
            kotlin.jvm.internal.j.d(r5)
            kotlinx.coroutines.channels.t r5 = (kotlinx.coroutines.channels.t) r5
            r5.X()
        L_0x00c3:
            return r4
        L_0x00c4:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.c0(kotlinx.coroutines.selects.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object h(t tVar) {
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        try {
            return super.h(tVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "(buffer:capacity=" + this.f32322d + ",size=" + this.size + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean j() {
        ReentrantLock reentrantLock = this.f32324f;
        reentrantLock.lock();
        try {
            return super.j();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return this.size == this.f32322d && this.f32323e == BufferOverflow.SUSPEND;
    }
}

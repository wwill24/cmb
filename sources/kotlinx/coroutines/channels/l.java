package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.selects.d;
import kotlinx.coroutines.selects.e;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010+\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010)j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`*¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0014R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\r8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\r8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\r8DX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\r8DX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010(\u001a\u00020%8TX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006."}, d2 = {"Lkotlinx/coroutines/channels/l;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "h0", "C", "(Ljava/lang/Object;)Ljava/lang/Object;", "b0", "Lkotlinx/coroutines/selects/d;", "select", "c0", "", "wasClosed", "", "X", "Lkotlinx/coroutines/channels/p;", "receive", "S", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "e", "Ljava/lang/Object;", "value", "U", "()Z", "isBufferAlwaysEmpty", "V", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "", "i", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class l<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f32336d = new ReentrantLock();

    /* renamed from: e  reason: collision with root package name */
    private Object f32337e = a.f32311a;

    public l(Function1<? super E, Unit> function1) {
        super(function1);
    }

    private final UndeliveredElementException h0(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f32337e;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == a.f32311a || (function1 = this.f32318a) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, (UndeliveredElementException) null, 2, (Object) null);
        }
        this.f32337e = obj;
        return undeliveredElementException;
    }

    /* access modifiers changed from: protected */
    public Object C(E e10) {
        r J;
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            k<?> m10 = m();
            if (m10 != null) {
                return m10;
            }
            if (this.f32337e == a.f32311a) {
                do {
                    J = J();
                    if (J != null) {
                        if (J instanceof k) {
                            reentrantLock.unlock();
                            return J;
                        }
                        j.d(J);
                    }
                } while (J.y(e10, (LockFreeLinkedListNode.c) null) == null);
                Unit unit = Unit.f32013a;
                reentrantLock.unlock();
                J.j(e10);
                return J.c();
            }
            UndeliveredElementException h02 = h0(e10);
            if (h02 == null) {
                f0 f0Var = a.f32312b;
                reentrantLock.unlock();
                return f0Var;
            }
            throw h02;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public boolean S(p<? super E> pVar) {
        ReentrantLock reentrantLock = this.f32336d;
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
        boolean z10;
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            if (this.f32337e == a.f32311a) {
                z10 = true;
            } else {
                z10 = false;
            }
            return z10;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void X(boolean z10) {
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            UndeliveredElementException h02 = h0(a.f32311a);
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            super.X(z10);
            if (h02 != null) {
                throw h02;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public Object b0() {
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            Object obj = this.f32337e;
            f0 f0Var = a.f32311a;
            if (obj == f0Var) {
                Object m10 = m();
                if (m10 == null) {
                    m10 = a.f32314d;
                }
                return m10;
            }
            this.f32337e = f0Var;
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object c0(d<?> dVar) {
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            Object obj = this.f32337e;
            f0 f0Var = a.f32311a;
            if (obj == f0Var) {
                Object m10 = m();
                if (m10 == null) {
                    m10 = a.f32314d;
                }
                return m10;
            } else if (!dVar.n()) {
                Object d10 = e.d();
                reentrantLock.unlock();
                return d10;
            } else {
                Object obj2 = this.f32337e;
                this.f32337e = f0Var;
                Unit unit = Unit.f32013a;
                reentrantLock.unlock();
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public String i() {
        ReentrantLock reentrantLock = this.f32336d;
        reentrantLock.lock();
        try {
            return "(value=" + this.f32337e + PropertyUtils.MAPPED_DELIM2;
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
        return false;
    }
}

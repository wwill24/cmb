package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.z0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00010\u0002:\u0004\u0016\u0010\n\u000bB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/c;", "", "owner", "", "d", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "e", "(Ljava/lang/Object;)Z", "b", "c", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "()Z", "isLocked", "locked", "<init>", "(Z)V", "LockCont", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class MutexImpl implements c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f32690a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "Z", "", "X", "", "toString", "Lkotlinx/coroutines/n;", "g", "Lkotlinx/coroutines/n;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class LockCont extends a {

        /* renamed from: g  reason: collision with root package name */
        private final n<Unit> f32691g;

        public LockCont(Object obj, n<? super Unit> nVar) {
            super(obj);
            this.f32691g = nVar;
        }

        public void X() {
            this.f32691g.M(p.f32594a);
        }

        public boolean Z() {
            if (Y() && this.f32691g.B(Unit.f32013a, (Object) null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this)) != null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "LockCont[" + this.f32694d + ", " + this.f32691g + "] for " + MutexImpl.this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$a;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/z0;", "", "Y", "()Z", "", "dispose", "()V", "Z", "X", "", "d", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private abstract class a extends LockFreeLinkedListNode implements z0 {

        /* renamed from: f  reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f32693f = AtomicIntegerFieldUpdater.newUpdater(a.class, "isTaken");

        /* renamed from: d  reason: collision with root package name */
        public final Object f32694d;
        private volatile /* synthetic */ int isTaken = 0;

        public a(Object obj) {
            this.f32694d = obj;
        }

        public abstract void X();

        public final boolean Y() {
            return f32693f.compareAndSet(this, 0, 1);
        }

        public abstract boolean Z();

        public final void dispose() {
            S();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$b;", "Lkotlinx/coroutines/internal/p;", "", "toString", "", "owner", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b extends kotlinx.coroutines.internal.p {
        public volatile Object owner;

        public b(Object obj) {
            this.owner = obj;
        }

        public String toString() {
            return "LockedQueue[" + this.owner + PropertyUtils.INDEXED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$c;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/sync/MutexImpl;", "affected", "", "k", "failure", "", "j", "Lkotlinx/coroutines/sync/MutexImpl$b;", "b", "Lkotlinx/coroutines/sync/MutexImpl$b;", "queue", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c extends d<MutexImpl> {

        /* renamed from: b  reason: collision with root package name */
        public final b f32696b;

        public c(b bVar) {
            this.f32696b = bVar;
        }

        /* renamed from: j */
        public void d(MutexImpl mutexImpl, Object obj) {
            Object obj2;
            if (obj == null) {
                obj2 = d.f32712f;
            } else {
                obj2 = this.f32696b;
            }
            androidx.concurrent.futures.a.a(MutexImpl.f32690a, mutexImpl, this, obj2);
        }

        /* renamed from: k */
        public Object i(MutexImpl mutexImpl) {
            if (this.f32696b.X()) {
                return null;
            }
            return d.f32708b;
        }
    }

    public MutexImpl(boolean z10) {
        b bVar;
        if (z10) {
            bVar = d.f32711e;
        } else {
            bVar = d.f32712f;
        }
        this._state = bVar;
    }

    private final Object d(Object obj, kotlin.coroutines.c<? super Unit> cVar) {
        boolean z10;
        b bVar;
        o b10 = q.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        LockCont lockCont = new LockCont(obj, b10);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof b) {
                b bVar2 = (b) obj2;
                if (bVar2.f32706a != d.f32710d) {
                    androidx.concurrent.futures.a.a(f32690a, this, obj2, new b(bVar2.f32706a));
                } else {
                    if (obj == null) {
                        bVar = d.f32711e;
                    } else {
                        bVar = new b(obj);
                    }
                    if (androidx.concurrent.futures.a.a(f32690a, this, obj2, bVar)) {
                        b10.q(Unit.f32013a, new MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof b) {
                b bVar3 = (b) obj2;
                if (bVar3.owner != obj) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    bVar3.F(lockCont);
                    if (this._state == obj2 || !lockCont.Y()) {
                        q.c(b10, lockCont);
                    } else {
                        lockCont = new LockCont(obj, b10);
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof y) {
                ((y) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
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

    public boolean a() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (((b) obj).f32706a != d.f32710d) {
                    return true;
                }
                return false;
            } else if (obj instanceof b) {
                return true;
            } else {
                if (obj instanceof y) {
                    ((y) obj).c(this);
                } else {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
            }
        }
    }

    public Object b(Object obj, kotlin.coroutines.c<? super Unit> cVar) {
        if (e(obj)) {
            return Unit.f32013a;
        }
        Object d10 = d(obj, cVar);
        if (d10 == b.d()) {
            return d10;
        }
        return Unit.f32013a;
    }

    public void c(Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z10 = true;
            if (obj2 instanceof b) {
                if (obj == null) {
                    if (((b) obj2).f32706a == d.f32710d) {
                        z10 = false;
                    }
                    if (!z10) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    b bVar = (b) obj2;
                    if (bVar.f32706a != obj) {
                        z10 = false;
                    }
                    if (!z10) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar.f32706a + " but expected " + obj).toString());
                    }
                }
                if (androidx.concurrent.futures.a.a(f32690a, this, obj2, d.f32712f)) {
                    return;
                }
            } else if (obj2 instanceof y) {
                ((y) obj2).c(this);
            } else if (obj2 instanceof b) {
                if (obj != null) {
                    b bVar2 = (b) obj2;
                    if (bVar2.owner != obj) {
                        z10 = false;
                    }
                    if (!z10) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.owner + " but expected " + obj).toString());
                    }
                }
                b bVar3 = (b) obj2;
                LockFreeLinkedListNode T = bVar3.T();
                if (T == null) {
                    c cVar = new c(bVar3);
                    if (androidx.concurrent.futures.a.a(f32690a, this, obj2, cVar) && cVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) T;
                    if (aVar.Z()) {
                        Object obj3 = aVar.f32694d;
                        if (obj3 == null) {
                            obj3 = d.f32709c;
                        }
                        bVar3.owner = obj3;
                        aVar.X();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public boolean e(Object obj) {
        b bVar;
        while (true) {
            Object obj2 = this._state;
            boolean z10 = true;
            if (obj2 instanceof b) {
                if (((b) obj2).f32706a != d.f32710d) {
                    return false;
                }
                if (obj == null) {
                    bVar = d.f32711e;
                } else {
                    bVar = new b(obj);
                }
                if (androidx.concurrent.futures.a.a(f32690a, this, obj2, bVar)) {
                    return true;
                }
            } else if (obj2 instanceof b) {
                if (((b) obj2).owner == obj) {
                    z10 = false;
                }
                if (z10) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (obj2 instanceof y) {
                ((y) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                return "Mutex[" + ((b) obj).f32706a + PropertyUtils.INDEXED_DELIM2;
            } else if (obj instanceof y) {
                ((y) obj).c(this);
            } else if (obj instanceof b) {
                return "Mutex[" + ((b) obj).owner + PropertyUtils.INDEXED_DELIM2;
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }
}

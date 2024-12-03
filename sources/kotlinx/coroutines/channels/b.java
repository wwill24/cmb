package kotlinx.coroutines.channels;

import gk.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.o;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00019B)\u0012 \u0010;\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010+j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`8¢\u0006\u0004\bT\u0010/J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\t2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\"\u0010#J$\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0$2\u0006\u0010\b\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010\u0019J\u0019\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u001aH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b)\u0010*J)\u0010.\u001a\u00020\t2\u0018\u0010-\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0+j\u0002`,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\t2\u0006\u0010\u0004\u001a\u000200H\u0014¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dH\u0014¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R.\u0010;\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010+j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`88\u0004X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020<8\u0004X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020!8BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u0002058BX\u0004¢\u0006\u0006\u001a\u0004\bE\u00107R\u0014\u0010H\u001a\u00020!8$X¤\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010J\u001a\u00020!8$X¤\u0004¢\u0006\u0006\u001a\u0004\bI\u0010CR\u001a\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001a\u0010O\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010LR\u0011\u0010Q\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bP\u0010CR\u0014\u0010S\u001a\u0002058TX\u0004¢\u0006\u0006\u001a\u0004\bR\u00107\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"Lkotlinx/coroutines/channels/b;", "E", "Lkotlinx/coroutines/channels/u;", "Lkotlinx/coroutines/channels/k;", "closed", "", "q", "(Lkotlinx/coroutines/channels/k;)Ljava/lang/Throwable;", "element", "", "I", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "r", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lkotlinx/coroutines/channels/k;)V", "cause", "v", "(Ljava/lang/Throwable;)V", "p", "(Lkotlinx/coroutines/channels/k;)V", "", "g", "()I", "", "C", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/t;", "L", "()Lkotlinx/coroutines/channels/t;", "Lkotlinx/coroutines/channels/r;", "G", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/r;", "H", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/h;", "t", "send", "h", "(Lkotlinx/coroutines/channels/t;)Ljava/lang/Object;", "F", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "s", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "D", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "J", "()Lkotlinx/coroutines/channels/r;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "a", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Lkotlinx/coroutines/internal/p;", "b", "Lkotlinx/coroutines/internal/p;", "n", "()Lkotlinx/coroutines/internal/p;", "queue", "B", "()Z", "isFullImpl", "o", "queueDebugStateString", "x", "isBufferAlwaysFull", "y", "isBufferFull", "m", "()Lkotlinx/coroutines/channels/k;", "closedForSend", "l", "closedForReceive", "K", "isClosedForSend", "i", "bufferDebugString", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class b<E> implements u<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32317c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "onCloseHandler");

    /* renamed from: a  reason: collision with root package name */
    protected final Function1<E, Unit> f32318a;

    /* renamed from: b  reason: collision with root package name */
    private final p f32319b = new p();
    private volatile /* synthetic */ Object onCloseHandler = null;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/channels/b$a;", "E", "Lkotlinx/coroutines/channels/t;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "a0", "", "X", "Lkotlinx/coroutines/channels/k;", "closed", "Z", "", "toString", "d", "Ljava/lang/Object;", "element", "", "Y", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a<E> extends t {

        /* renamed from: d  reason: collision with root package name */
        public final E f32320d;

        public a(E e10) {
            this.f32320d = e10;
        }

        public void X() {
        }

        public Object Y() {
            return this.f32320d;
        }

        public void Z(k<?> kVar) {
        }

        public f0 a0(LockFreeLinkedListNode.c cVar) {
            f0 f0Var = kotlinx.coroutines.p.f32594a;
            if (cVar != null) {
                cVar.d();
            }
            return f0Var;
        }

        public String toString() {
            return "SendBuffered@" + m0.b(this) + PropertyUtils.MAPPED_DELIM + this.f32320d + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/channels/b$b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.channels.b$b  reason: collision with other inner class name */
    public static final class C0371b extends LockFreeLinkedListNode.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f32321d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0371b(LockFreeLinkedListNode lockFreeLinkedListNode, b bVar) {
            super(lockFreeLinkedListNode);
            this.f32321d = bVar;
        }

        /* renamed from: k */
        public Object i(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f32321d.y()) {
                return null;
            }
            return q.a();
        }
    }

    public b(Function1<? super E, Unit> function1) {
        this.f32318a = function1;
    }

    /* access modifiers changed from: private */
    public final boolean B() {
        return !(this.f32319b.N() instanceof r) && y();
    }

    private final Object I(E e10, c<? super Unit> cVar) {
        t tVar;
        o b10 = kotlinx.coroutines.q.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        while (true) {
            if (B()) {
                if (this.f32318a == null) {
                    tVar = new v(e10, b10);
                } else {
                    tVar = new w(e10, b10, this.f32318a);
                }
                Object h10 = h(tVar);
                if (h10 == null) {
                    kotlinx.coroutines.q.c(b10, tVar);
                    break;
                } else if (h10 instanceof k) {
                    r(b10, e10, (k) h10);
                    break;
                } else if (h10 != a.f32315e && !(h10 instanceof p)) {
                    throw new IllegalStateException(("enqueueSend returned " + h10).toString());
                }
            }
            Object C = C(e10);
            if (C == a.f32312b) {
                Result.a aVar = Result.f32010a;
                b10.resumeWith(Result.b(Unit.f32013a));
                break;
            } else if (C != a.f32313c) {
                if (C instanceof k) {
                    r(b10, e10, (k) C);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + C).toString());
                }
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

    private final int g() {
        p pVar = this.f32319b;
        int i10 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) pVar.L(); !j.b(lockFreeLinkedListNode, pVar); lockFreeLinkedListNode = lockFreeLinkedListNode.N()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i10++;
            }
        }
        return i10;
    }

    private final String o() {
        String str;
        LockFreeLinkedListNode N = this.f32319b.N();
        if (N == this.f32319b) {
            return "EmptyQueue";
        }
        if (N instanceof k) {
            str = N.toString();
        } else if (N instanceof p) {
            str = "ReceiveQueued";
        } else if (N instanceof t) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + N;
        }
        LockFreeLinkedListNode O = this.f32319b.O();
        if (O == N) {
            return str;
        }
        String str2 = str + ",queueSize=" + g();
        if (!(O instanceof k)) {
            return str2;
        }
        return str2 + ",closedForSend=" + O;
    }

    private final void p(k<?> kVar) {
        p pVar;
        Object b10 = m.b((Object) null, 1, (DefaultConstructorMarker) null);
        while (true) {
            LockFreeLinkedListNode O = kVar.O();
            if (O instanceof p) {
                pVar = (p) O;
            } else {
                pVar = null;
            }
            if (pVar == null) {
                break;
            } else if (!pVar.S()) {
                pVar.P();
            } else {
                b10 = m.c(b10, pVar);
            }
        }
        if (b10 != null) {
            if (!(b10 instanceof ArrayList)) {
                ((p) b10).Z(kVar);
            } else {
                ArrayList arrayList = (ArrayList) b10;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((p) arrayList.get(size)).Z(kVar);
                }
            }
        }
        D(kVar);
    }

    private final Throwable q(k<?> kVar) {
        p(kVar);
        return kVar.f0();
    }

    /* access modifiers changed from: private */
    public final void r(c<?> cVar, E e10, k<?> kVar) {
        UndeliveredElementException d10;
        p(kVar);
        Throwable f02 = kVar.f0();
        Function1<E, Unit> function1 = this.f32318a;
        if (function1 == null || (d10 = OnUndeliveredElementKt.d(function1, e10, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Result.a aVar = Result.f32010a;
            cVar.resumeWith(Result.b(g.a(f02)));
            return;
        }
        b.a(d10, f02);
        Result.a aVar2 = Result.f32010a;
        cVar.resumeWith(Result.b(g.a(d10)));
    }

    private final void v(Throwable th2) {
        f0 f0Var;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (f0Var = a.f32316f) && androidx.concurrent.futures.a.a(f32317c, this, obj, f0Var)) {
            ((Function1) kotlin.jvm.internal.p.d(obj, 1)).invoke(th2);
        }
    }

    /* access modifiers changed from: protected */
    public Object C(E e10) {
        r J;
        do {
            J = J();
            if (J == null) {
                return a.f32313c;
            }
        } while (J.y(e10, (LockFreeLinkedListNode.c) null) == null);
        J.j(e10);
        return J.c();
    }

    /* access modifiers changed from: protected */
    public void D(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    public boolean F(Throwable th2) {
        boolean z10;
        k kVar = new k(th2);
        p pVar = this.f32319b;
        while (true) {
            LockFreeLinkedListNode O = pVar.O();
            z10 = true;
            if (!(O instanceof k)) {
                if (O.G(kVar, pVar)) {
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            kVar = (k) this.f32319b.O();
        }
        p(kVar);
        if (z10) {
            v(th2);
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public final r<?> G(E e10) {
        LockFreeLinkedListNode O;
        p pVar = this.f32319b;
        a aVar = new a(e10);
        do {
            O = pVar.O();
            if (O instanceof r) {
                return (r) O;
            }
        } while (!O.G(aVar, pVar));
        return null;
    }

    public final Object H(E e10, c<? super Unit> cVar) {
        if (C(e10) == a.f32312b) {
            return Unit.f32013a;
        }
        Object I = I(e10, cVar);
        if (I == b.d()) {
            return I;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: protected */
    public r<E> J() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode U;
        p pVar = this.f32319b;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) pVar.L();
            if (lockFreeLinkedListNode != pVar && (lockFreeLinkedListNode instanceof r)) {
                if (((((r) lockFreeLinkedListNode) instanceof k) && !lockFreeLinkedListNode.R()) || (U = lockFreeLinkedListNode.U()) == null) {
                    break;
                }
                U.Q();
            }
        }
        lockFreeLinkedListNode = null;
        return (r) lockFreeLinkedListNode;
    }

    public final boolean K() {
        return m() != null;
    }

    /* access modifiers changed from: protected */
    public final t L() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode U;
        p pVar = this.f32319b;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) pVar.L();
            if (lockFreeLinkedListNode != pVar && (lockFreeLinkedListNode instanceof t)) {
                if (((((t) lockFreeLinkedListNode) instanceof k) && !lockFreeLinkedListNode.R()) || (U = lockFreeLinkedListNode.U()) == null) {
                    break;
                }
                U.Q();
            }
        }
        lockFreeLinkedListNode = null;
        return (t) lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    public Object h(t tVar) {
        boolean z10;
        LockFreeLinkedListNode O;
        if (x()) {
            p pVar = this.f32319b;
            do {
                O = pVar.O();
                if (O instanceof r) {
                    return O;
                }
            } while (!O.G(tVar, pVar));
            return null;
        }
        p pVar2 = this.f32319b;
        C0371b bVar = new C0371b(tVar, this);
        while (true) {
            LockFreeLinkedListNode O2 = pVar2.O();
            if (!(O2 instanceof r)) {
                int W = O2.W(tVar, pVar2, bVar);
                z10 = true;
                if (W != 1) {
                    if (W == 2) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return O2;
            }
        }
        if (!z10) {
            return a.f32315e;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "";
    }

    /* access modifiers changed from: protected */
    public final k<?> l() {
        LockFreeLinkedListNode N = this.f32319b.N();
        k<?> kVar = N instanceof k ? (k) N : null;
        if (kVar == null) {
            return null;
        }
        p(kVar);
        return kVar;
    }

    /* access modifiers changed from: protected */
    public final k<?> m() {
        LockFreeLinkedListNode O = this.f32319b.O();
        k<?> kVar = O instanceof k ? (k) O : null;
        if (kVar == null) {
            return null;
        }
        p(kVar);
        return kVar;
    }

    /* access modifiers changed from: protected */
    public final p n() {
        return this.f32319b;
    }

    public boolean offer(E e10) {
        UndeliveredElementException d10;
        try {
            return u.a.b(this, e10);
        } catch (Throwable th2) {
            Function1<E, Unit> function1 = this.f32318a;
            if (function1 == null || (d10 = OnUndeliveredElementKt.d(function1, e10, (UndeliveredElementException) null, 2, (Object) null)) == null) {
                throw th2;
            }
            b.a(d10, th2);
            throw d10;
        }
    }

    public void s(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f32317c;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == a.f32316f) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        k<?> m10 = m();
        if (m10 != null && androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, function1, a.f32316f)) {
            function1.invoke(m10.f32335d);
        }
    }

    public final Object t(E e10) {
        Object C = C(e10);
        if (C == a.f32312b) {
            return h.f32331b.c(Unit.f32013a);
        }
        if (C == a.f32313c) {
            k<?> m10 = m();
            if (m10 == null) {
                return h.f32331b.b();
            }
            return h.f32331b.a(q(m10));
        } else if (C instanceof k) {
            return h.f32331b.a(q((k) C));
        } else {
            throw new IllegalStateException(("trySend returned " + C).toString());
        }
    }

    public String toString() {
        return m0.a(this) + '@' + m0.b(this) + '{' + o() + '}' + i();
    }

    /* access modifiers changed from: protected */
    public abstract boolean x();

    /* access modifiers changed from: protected */
    public abstract boolean y();
}

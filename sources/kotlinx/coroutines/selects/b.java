package kotlinx.coroutines.selects;

import gk.g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.z0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004LMN6B\u0015\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u0004\u0018\u00010\u00142\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*JG\u0010/\u001a\u00020\b\"\u0004\b\u0001\u0010+*\b\u0012\u0004\u0012\u00028\u00010,2\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00140-H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100J8\u00104\u001a\u00020\b2\u0006\u00102\u001a\u0002012\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001403H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R(\u0010=\u001a\u0004\u0018\u00010\u00192\b\u00109\u001a\u0004\u0018\u00010\u00198B@BX\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u001cR\u001c\u0010@\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lkotlinx/coroutines/selects/b;", "R", "Lkotlinx/coroutines/internal/p;", "Lkotlinx/coroutines/selects/a;", "Lkotlinx/coroutines/selects/d;", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "e0", "()V", "a0", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "exception", "u", "(Ljava/lang/Throwable;)V", "", "c0", "()Ljava/lang/Object;", "e", "d0", "Lkotlinx/coroutines/z0;", "handle", "k", "(Lkotlinx/coroutines/z0;)V", "", "n", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "m", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/b;", "desc", "w", "(Lkotlinx/coroutines/internal/b;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Q", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function2;", "block", "z", "(Lkotlinx/coroutines/selects/c;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "Lkotlin/Function1;", "i", "(JLkotlin/jvm/functions/Function1;)V", "d", "Lkotlin/coroutines/c;", "uCont", "value", "b0", "()Lkotlinx/coroutines/z0;", "f0", "parentHandle", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "s", "()Lkotlin/coroutines/c;", "completion", "h", "isSelected", "<init>", "(Lkotlin/coroutines/c;)V", "a", "b", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class b<R> extends p implements a<R>, d<R>, kotlin.coroutines.c<R>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f32673e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32674f;
    private volatile /* synthetic */ Object _parentHandle = null;
    private volatile /* synthetic */ Object _result = e.f32686c;
    volatile /* synthetic */ Object _state = e.e();

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<R> f32675d;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/selects/b$a;", "Lkotlinx/coroutines/internal/d;", "", "k", "", "l", "failure", "j", "affected", "i", "d", "", "toString", "Lkotlinx/coroutines/selects/b;", "b", "Lkotlinx/coroutines/selects/b;", "impl", "Lkotlinx/coroutines/internal/b;", "c", "Lkotlinx/coroutines/internal/b;", "desc", "", "J", "g", "()J", "opSequence", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/internal/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a extends kotlinx.coroutines.internal.d<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final b<?> f32676b;

        /* renamed from: c  reason: collision with root package name */
        public final kotlinx.coroutines.internal.b f32677c;

        /* renamed from: d  reason: collision with root package name */
        private final long f32678d = e.f32688e.a();

        public a(b<?> bVar, kotlinx.coroutines.internal.b bVar2) {
            this.f32676b = bVar;
            this.f32677c = bVar2;
            bVar2.d(this);
        }

        private final void j(Object obj) {
            boolean z10;
            Object obj2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                obj2 = null;
            } else {
                obj2 = e.e();
            }
            if (androidx.concurrent.futures.a.a(b.f32673e, this.f32676b, this, obj2) && z10) {
                this.f32676b.a0();
            }
        }

        private final Object k() {
            b<?> bVar = this.f32676b;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof y) {
                    ((y) obj).c(this.f32676b);
                } else if (obj != e.e()) {
                    return e.d();
                } else {
                    if (androidx.concurrent.futures.a.a(b.f32673e, this.f32676b, e.e(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void l() {
            androidx.concurrent.futures.a.a(b.f32673e, this.f32676b, this, e.e());
        }

        public void d(Object obj, Object obj2) {
            j(obj2);
            this.f32677c.a(this, obj2);
        }

        public long g() {
            return this.f32678d;
        }

        public Object i(Object obj) {
            Object k10;
            if (obj == null && (k10 = k()) != null) {
                return k10;
            }
            try {
                return this.f32677c.c(this);
            } catch (Throwable th2) {
                if (obj == null) {
                    l();
                }
                throw th2;
            }
        }

        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/b$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/z0;", "d", "Lkotlinx/coroutines/z0;", "handle", "<init>", "(Lkotlinx/coroutines/z0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.selects.b$b  reason: collision with other inner class name */
    private static final class C0372b extends LockFreeLinkedListNode {

        /* renamed from: d  reason: collision with root package name */
        public final z0 f32679d;

        public C0372b(z0 z0Var) {
            this.f32679d = z0Var;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/selects/b$c;", "Lkotlinx/coroutines/internal/y;", "", "affected", "c", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c extends y {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode.c f32680a;

        public c(LockFreeLinkedListNode.c cVar) {
            this.f32680a = cVar;
        }

        public kotlinx.coroutines.internal.d<?> a() {
            return this.f32680a.a();
        }

        public Object c(Object obj) {
            Object obj2;
            if (obj != null) {
                b bVar = (b) obj;
                this.f32680a.d();
                Object e10 = this.f32680a.a().e((Object) null);
                if (e10 == null) {
                    obj2 = this.f32680a.f32503c;
                } else {
                    obj2 = e.e();
                }
                androidx.concurrent.futures.a.a(b.f32673e, bVar, this, obj2);
                return e10;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/b$d;", "Lkotlinx/coroutines/t1;", "", "cause", "", "X", "<init>", "(Lkotlinx/coroutines/selects/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class d extends t1 {
        public d() {
        }

        public void X(Throwable th2) {
            if (b.this.n()) {
                b.this.u(Y().n());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            X((Throwable) obj);
            return Unit.f32013a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f32682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1 f32683b;

        public e(b bVar, Function1 function1) {
            this.f32682a = bVar;
            this.f32683b = function1;
        }

        public final void run() {
            if (this.f32682a.n()) {
                zk.a.c(this.f32683b, this.f32682a.s());
            }
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<b> cls2 = b.class;
        f32673e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_state");
        f32674f = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_result");
    }

    public b(kotlin.coroutines.c<? super R> cVar) {
        this.f32675d = cVar;
    }

    /* access modifiers changed from: private */
    public final void a0() {
        z0 b02 = b0();
        if (b02 != null) {
            b02.dispose();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) L(); !j.b(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.N()) {
            if (lockFreeLinkedListNode instanceof C0372b) {
                ((C0372b) lockFreeLinkedListNode).f32679d.dispose();
            }
        }
    }

    private final z0 b0() {
        return (z0) this._parentHandle;
    }

    private final void e0() {
        s1 s1Var = (s1) getContext().c(s1.f32618v);
        if (s1Var != null) {
            z0 d10 = s1.a.d(s1Var, true, false, new d(), 2, (Object) null);
            f0(d10);
            if (h()) {
                d10.dispose();
            }
        }
    }

    private final void f0(z0 z0Var) {
        this._parentHandle = z0Var;
    }

    public final Object c0() {
        if (!h()) {
            e0();
        }
        Object obj = this._result;
        if (obj == e.f32686c) {
            if (androidx.concurrent.futures.a.a(f32674f, this, e.f32686c, b.d())) {
                return b.d();
            }
            obj = this._result;
        }
        if (obj == e.f32687d) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof b0)) {
            return obj;
        } else {
            throw ((b0) obj).f32285a;
        }
    }

    public final void d0(Throwable th2) {
        if (n()) {
            Result.a aVar = Result.f32010a;
            resumeWith(Result.b(g.a(th2)));
        } else if (!(th2 instanceof CancellationException)) {
            Object c02 = c0();
            if (!(c02 instanceof b0) || ((b0) c02).f32285a != th2) {
                i0.a(getContext(), th2);
            }
        }
    }

    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<R> cVar = this.f32675d;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f32675d.getContext();
    }

    public boolean h() {
        while (true) {
            Object obj = this._state;
            if (obj == e.e()) {
                return false;
            }
            if (!(obj instanceof y)) {
                return true;
            }
            ((y) obj).c(this);
        }
    }

    public void i(long j10, Function1<? super kotlin.coroutines.c<? super R>, ? extends Object> function1) {
        if (j10 > 0) {
            k(s0.b(getContext()).u(j10, new e(this, function1), getContext()));
        } else if (n()) {
            zk.b.b(function1, s());
        }
    }

    public void k(z0 z0Var) {
        C0372b bVar = new C0372b(z0Var);
        if (!h()) {
            F(bVar);
            if (!h()) {
                return;
            }
        }
        z0Var.dispose();
    }

    public Object m(LockFreeLinkedListNode.c cVar) {
        while (true) {
            Object obj = this._state;
            if (obj == e.e()) {
                if (cVar == null) {
                    if (androidx.concurrent.futures.a.a(f32673e, this, e.e(), (Object) null)) {
                        break;
                    }
                } else {
                    c cVar2 = new c(cVar);
                    if (androidx.concurrent.futures.a.a(f32673e, this, e.e(), cVar2)) {
                        Object c10 = cVar2.c(this);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
            } else if (obj instanceof y) {
                if (cVar != null) {
                    kotlinx.coroutines.internal.d<?> a10 = cVar.a();
                    if ((a10 instanceof a) && ((a) a10).f32676b == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    } else if (a10.b((y) obj)) {
                        return kotlinx.coroutines.internal.c.f32521b;
                    }
                }
                ((y) obj).c(this);
            } else if (cVar != null && obj == cVar.f32503c) {
                return kotlinx.coroutines.p.f32594a;
            } else {
                return null;
            }
        }
        a0();
        return kotlinx.coroutines.p.f32594a;
    }

    public boolean n() {
        Object m10 = m((LockFreeLinkedListNode.c) null);
        if (m10 == kotlinx.coroutines.p.f32594a) {
            return true;
        }
        if (m10 == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + m10).toString());
    }

    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this._result;
            if (obj2 == e.f32686c) {
                if (androidx.concurrent.futures.a.a(f32674f, this, e.f32686c, e0.d(obj, (Function1) null, 1, (Object) null))) {
                    return;
                }
            } else if (obj2 != b.d()) {
                throw new IllegalStateException("Already resumed");
            } else if (androidx.concurrent.futures.a.a(f32674f, this, b.d(), e.f32687d)) {
                if (Result.g(obj)) {
                    kotlin.coroutines.c<R> cVar = this.f32675d;
                    Throwable e10 = Result.e(obj);
                    j.d(e10);
                    cVar.resumeWith(Result.b(g.a(e10)));
                    return;
                }
                this.f32675d.resumeWith(obj);
                return;
            }
        }
    }

    public kotlin.coroutines.c<R> s() {
        return this;
    }

    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + PropertyUtils.MAPPED_DELIM2;
    }

    public void u(Throwable th2) {
        while (true) {
            Object obj = this._result;
            if (obj == e.f32686c) {
                if (androidx.concurrent.futures.a.a(f32674f, this, e.f32686c, new b0(th2, false, 2, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else if (obj != b.d()) {
                throw new IllegalStateException("Already resumed");
            } else if (androidx.concurrent.futures.a.a(f32674f, this, b.d(), e.f32687d)) {
                kotlin.coroutines.c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f32675d);
                Result.a aVar = Result.f32010a;
                c10.resumeWith(Result.b(g.a(th2)));
                return;
            }
        }
    }

    public Object w(kotlinx.coroutines.internal.b bVar) {
        return new a(this, bVar).c((Object) null);
    }

    public <Q> void z(c<? extends Q> cVar, Function2<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
        cVar.i(this, function2);
    }
}

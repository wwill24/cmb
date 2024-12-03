package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u00041234B\u0007¢\u0006\u0004\b0\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0015\u0010\fJ'\u0010\u0016\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010\"J\u0015\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b$\u0010 J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0015\u0010-\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010 R\u0015\u0010/\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010 ¨\u00065"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/z;", "V", "()Lkotlinx/coroutines/internal/z;", "Lkotlinx/coroutines/internal/Node;", "current", "J", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "", "K", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/y;", "op", "I", "(Lkotlinx/coroutines/internal/y;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "", "H", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "F", "G", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "condAdd", "", "W", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;)I", "S", "()Z", "U", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "P", "()V", "Q", "T", "", "toString", "()Ljava/lang/String;", "R", "isRemoved", "L", "()Ljava/lang/Object;", "N", "nextNode", "O", "prevNode", "<init>", "a", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class LockFreeLinkedListNode {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f32496a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f32497b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32498c;
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0014J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\n\u001a\u00020\bH\u0014J \u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H$J \u0010\u000f\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0014\u0010\u0014\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0015J\u001c\u0010\u0018\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u001c\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/y;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "m", "affected", "", "e", "next", "", "l", "", "f", "n", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "prepareOp", "g", "j", "k", "Lkotlinx/coroutines/internal/d;", "c", "failure", "a", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class a extends b {
        public final void a(d<?> dVar, Object obj) {
            boolean z10;
            LockFreeLinkedListNode i10;
            Object obj2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            LockFreeLinkedListNode h10 = h();
            if (h10 != null && (i10 = i()) != null) {
                if (z10) {
                    obj2 = n(h10, i10);
                } else {
                    obj2 = i10;
                }
                if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, h10, dVar, obj2) && z10) {
                    f(h10, i10);
                }
            }
        }

        public final Object c(d<?> dVar) {
            while (true) {
                LockFreeLinkedListNode m10 = m(dVar);
                if (m10 == null) {
                    return c.f32521b;
                }
                Object obj = m10._next;
                if (obj == dVar || dVar.h()) {
                    return null;
                }
                if (obj instanceof y) {
                    y yVar = (y) obj;
                    if (dVar.b(yVar)) {
                        return c.f32521b;
                    }
                    yVar.c(m10);
                } else {
                    Object e10 = e(m10);
                    if (e10 != null) {
                        return e10;
                    }
                    if (!l(m10, obj)) {
                        c cVar = new c(m10, (LockFreeLinkedListNode) obj, this);
                        if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, m10, obj, cVar)) {
                            try {
                                if (cVar.c(m10) != r.f32555a) {
                                    return null;
                                }
                            } catch (Throwable th2) {
                                androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, m10, cVar, obj);
                                throw th2;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract Object e(LockFreeLinkedListNode lockFreeLinkedListNode);

        /* access modifiers changed from: protected */
        public abstract void f(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void g(c cVar);

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode h();

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode i();

        public Object j(c cVar) {
            g(cVar);
            return null;
        }

        public void k(LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        /* access modifiers changed from: protected */
        public abstract boolean l(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj);

        /* access modifiers changed from: protected */
        public abstract LockFreeLinkedListNode m(y yVar);

        public abstract Object n(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2);
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "", "j", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "newNode", "c", "oldNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class b extends d<LockFreeLinkedListNode> {

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f32499b;

        /* renamed from: c  reason: collision with root package name */
        public LockFreeLinkedListNode f32500c;

        public b(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f32499b = lockFreeLinkedListNode;
        }

        /* renamed from: j */
        public void d(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z10;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                lockFreeLinkedListNode2 = this.f32499b;
            } else {
                lockFreeLinkedListNode2 = this.f32500c;
            }
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z10) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f32499b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f32500c;
                j.d(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.K(lockFreeLinkedListNode4);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u000e\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u0003\u001a\u00060\tj\u0002`\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u00060\tj\u0002`\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "Lkotlinx/coroutines/internal/y;", "", "affected", "c", "", "d", "", "toString", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "b", "next", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "desc", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class c extends y {

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode f32501a;

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f32502b;

        /* renamed from: c  reason: collision with root package name */
        public final a f32503c;

        public c(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
            this.f32501a = lockFreeLinkedListNode;
            this.f32502b = lockFreeLinkedListNode2;
            this.f32503c = aVar;
        }

        public d<?> a() {
            return this.f32503c.b();
        }

        public Object c(Object obj) {
            Object obj2;
            Object obj3;
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object j10 = this.f32503c.j(this);
                Object obj4 = r.f32555a;
                if (j10 == obj4) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f32502b;
                    if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.V())) {
                        this.f32503c.k(lockFreeLinkedListNode);
                        LockFreeLinkedListNode unused = lockFreeLinkedListNode2.I((y) null);
                    }
                    return obj4;
                }
                if (j10 != null) {
                    obj2 = a().e(j10);
                } else {
                    obj2 = a().f();
                }
                if (obj2 == c.f32520a) {
                    obj3 = a();
                } else if (obj2 == null) {
                    obj3 = this.f32503c.n(lockFreeLinkedListNode, this.f32502b);
                } else {
                    obj3 = this.f32502b;
                }
                androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f32496a, lockFreeLinkedListNode, this, obj3);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        public final void d() {
            this.f32503c.g(this);
        }

        public String toString() {
            return "PrepareOp(op=" + a() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u0005j\u0002`\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$d;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$a;", "Lkotlinx/coroutines/internal/y;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "m", "(Lkotlinx/coroutines/internal/y;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "l", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "prepareOp", "", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)V", "n", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "queue", "o", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class d<T> extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f32504c;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f32505d;
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f32506b;

        static {
            Class<Object> cls = Object.class;
            Class<d> cls2 = d.class;
            f32504c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_affectedNode");
            f32505d = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_originalNext");
        }

        public d(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f32506b = lockFreeLinkedListNode;
        }

        /* access modifiers changed from: protected */
        public Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.f32506b) {
                return q.b();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final void f(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            LockFreeLinkedListNode unused = lockFreeLinkedListNode2.I((y) null);
        }

        public void g(c cVar) {
            androidx.concurrent.futures.a.a(f32504c, this, (Object) null, cVar.f32501a);
            androidx.concurrent.futures.a.a(f32505d, this, (Object) null, cVar.f32502b);
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode i() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        /* access modifiers changed from: protected */
        public final boolean l(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            if (!(obj instanceof z)) {
                return false;
            }
            ((z) obj).f32572a.Q();
            return true;
        }

        /* access modifiers changed from: protected */
        public final LockFreeLinkedListNode m(y yVar) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f32506b;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (!(obj instanceof y)) {
                    return (LockFreeLinkedListNode) obj;
                }
                y yVar2 = (y) obj;
                if (yVar.b(yVar2)) {
                    return null;
                }
                yVar2.c(this.f32506b);
            }
        }

        public final Object n(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.V();
        }

        public final T o() {
            T h10 = h();
            j.d(h10);
            return h10;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<LockFreeLinkedListNode> cls2 = LockFreeLinkedListNode.class;
        f32496a = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f32497b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        f32498c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlinx.coroutines.internal.y} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (androidx.concurrent.futures.a.a(f32496a, r3, r2, ((kotlinx.coroutines.internal.z) r4).f32572a) != false) goto L_0x004b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode I(kotlinx.coroutines.internal.y r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f32497b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r7.R()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r8) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.y
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0032
            r0 = r4
            kotlinx.coroutines.internal.y r0 = (kotlinx.coroutines.internal.y) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            kotlinx.coroutines.internal.y r4 = (kotlinx.coroutines.internal.y) r4
            r4.c(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.z
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f32496a
            kotlinx.coroutines.internal.z r4 = (kotlinx.coroutines.internal.z) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.f32572a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x0007
        L_0x0052:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.I(kotlinx.coroutines.internal.y):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode J(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.R()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    /* access modifiers changed from: private */
    public final void K(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (L() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f32497b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (R()) {
            lockFreeLinkedListNode.I((y) null);
        }
    }

    /* access modifiers changed from: private */
    public final z V() {
        z zVar = (z) this._removedRef;
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        f32498c.lazySet(this, zVar2);
        return zVar2;
    }

    public final void F(LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!O().G(lockFreeLinkedListNode, this));
    }

    public final boolean G(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f32497b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f32496a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.K(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean H(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f32497b.lazySet(lockFreeLinkedListNode, this);
        f32496a.lazySet(lockFreeLinkedListNode, this);
        while (L() == this) {
            if (androidx.concurrent.futures.a.a(f32496a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.K(this);
                return true;
            }
        }
        return false;
    }

    public final Object L() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).c(this);
        }
    }

    public final LockFreeLinkedListNode N() {
        return q.c(L());
    }

    public final LockFreeLinkedListNode O() {
        LockFreeLinkedListNode I = I((y) null);
        return I == null ? J((LockFreeLinkedListNode) this._prev) : I;
    }

    public final void P() {
        ((z) L()).f32572a.Q();
    }

    public final void Q() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object L = lockFreeLinkedListNode.L();
            if (L instanceof z) {
                lockFreeLinkedListNode = ((z) L).f32572a;
            } else {
                lockFreeLinkedListNode.I((y) null);
                return;
            }
        }
    }

    public boolean R() {
        return L() instanceof z;
    }

    public boolean S() {
        return U() == null;
    }

    public final LockFreeLinkedListNode T() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) L();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.S()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.P();
        }
    }

    public final LockFreeLinkedListNode U() {
        Object L;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            L = L();
            if (L instanceof z) {
                return ((z) L).f32572a;
            }
            if (L == this) {
                return (LockFreeLinkedListNode) L;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) L;
        } while (!androidx.concurrent.futures.a.a(f32496a, this, L, lockFreeLinkedListNode.V()));
        lockFreeLinkedListNode.I((y) null);
        return null;
    }

    public final int W(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, b bVar) {
        f32497b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f32496a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        bVar.f32500c = lockFreeLinkedListNode2;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, bVar)) {
            return 0;
        }
        if (bVar.c(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + m0.b(this);
    }
}

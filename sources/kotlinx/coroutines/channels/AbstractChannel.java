package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.z0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007Q(RSTUVB)\u0012 \u0010N\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0012\u0018\u00010Lj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`M¢\u0006\u0004\bO\u0010PJ!\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0004\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002JT\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052$\u0010\u0011\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014JZ\u0010\u0016\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u0004* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017JT\u0010\u0018\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2$\u0010\u0011\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u00020\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0014J\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0014J\u0013\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u001fJ\u0016\u0010 \u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000!ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$J\u0016\u0010(\u001a\u00020\u00122\u000e\u0010'\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&J\u0019\u0010*\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u000bH\u0014J/\u00103\u001a\u00020\u00122\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\n\u00102\u001a\u0006\u0012\u0002\b\u000301H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0004J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0014J\b\u0010;\u001a\u00020\u0012H\u0014J\b\u0010<\u001a\u00020\u0012H\u0014R\u0014\u0010?\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010C\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020\u000b8DX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR \u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0F8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bJ\u0010H\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006W"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/b;", "Lkotlinx/coroutines/channels/d;", "R", "", "receiveMode", "d0", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/p;", "receive", "", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "block", "", "e0", "(Lkotlinx/coroutines/selects/d;ILkotlin/jvm/functions/Function2;)V", "value", "g0", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/d;ILjava/lang/Object;)V", "T", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;I)Z", "Lkotlinx/coroutines/n;", "cont", "f0", "b0", "c0", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "S", "Lkotlinx/coroutines/channels/h;", "A", "z", "()Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "b", "", "P", "(Ljava/lang/Throwable;)Z", "wasClosed", "X", "Lkotlinx/coroutines/internal/m;", "Lkotlinx/coroutines/channels/t;", "list", "Lkotlinx/coroutines/channels/k;", "closed", "Y", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/k;)V", "Lkotlinx/coroutines/channels/f;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$g;", "Q", "Lkotlinx/coroutines/channels/r;", "J", "a0", "Z", "U", "()Z", "isBufferAlwaysEmpty", "V", "isBufferEmpty", "j", "isClosedForReceive", "W", "isEmptyImpl", "Lkotlinx/coroutines/selects/c;", "u", "()Lkotlinx/coroutines/selects/c;", "onReceive", "w", "onReceiveCatching", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "c", "d", "e", "f", "g", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractChannel<E> extends b<E> implements d<E> {

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0013\u0010\u0007\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0005HBø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$a;", "E", "Lkotlinx/coroutines/channels/f;", "", "result", "", "b", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "next", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Ljava/lang/Object;", "getResult", "d", "(Ljava/lang/Object;)V", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a<E> implements f<E> {

        /* renamed from: a  reason: collision with root package name */
        public final AbstractChannel<E> f32291a;

        /* renamed from: b  reason: collision with root package name */
        private Object f32292b = a.f32314d;

        public a(AbstractChannel<E> abstractChannel) {
            this.f32291a = abstractChannel;
        }

        private final boolean b(Object obj) {
            if (!(obj instanceof k)) {
                return true;
            }
            k kVar = (k) obj;
            if (kVar.f32335d == null) {
                return false;
            }
            throw e0.a(kVar.e0());
        }

        private final Object c(kotlin.coroutines.c<? super Boolean> cVar) {
            Function1<Throwable, Unit> function1;
            o b10 = q.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
            d dVar = new d(this, b10);
            while (true) {
                if (this.f32291a.R(dVar)) {
                    this.f32291a.f0(b10, dVar);
                    break;
                }
                Object b02 = this.f32291a.b0();
                d(b02);
                if (b02 instanceof k) {
                    k kVar = (k) b02;
                    if (kVar.f32335d == null) {
                        Result.a aVar = Result.f32010a;
                        b10.resumeWith(Result.b(kotlin.coroutines.jvm.internal.a.a(false)));
                    } else {
                        Result.a aVar2 = Result.f32010a;
                        b10.resumeWith(Result.b(gk.g.a(kVar.e0())));
                    }
                } else if (b02 != a.f32314d) {
                    Boolean a10 = kotlin.coroutines.jvm.internal.a.a(true);
                    Function1<E, Unit> function12 = this.f32291a.f32318a;
                    if (function12 != null) {
                        function1 = OnUndeliveredElementKt.a(function12, b02, b10.getContext());
                    } else {
                        function1 = null;
                    }
                    b10.q(a10, function1);
                }
            }
            Object v10 = b10.v();
            if (v10 == b.d()) {
                kotlin.coroutines.jvm.internal.f.c(cVar);
            }
            return v10;
        }

        public Object a(kotlin.coroutines.c<? super Boolean> cVar) {
            Object obj = this.f32292b;
            f0 f0Var = a.f32314d;
            if (obj != f0Var) {
                return kotlin.coroutines.jvm.internal.a.a(b(obj));
            }
            Object b02 = this.f32291a.b0();
            this.f32292b = b02;
            if (b02 != f0Var) {
                return kotlin.coroutines.jvm.internal.a.a(b(b02));
            }
            return c(cVar);
        }

        public final void d(Object obj) {
            this.f32292b = obj;
        }

        public E next() {
            E e10 = this.f32292b;
            if (!(e10 instanceof k)) {
                E e11 = a.f32314d;
                if (e10 != e11) {
                    this.f32292b = e11;
                    return e10;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw e0.a(((k) e10).e0());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$b;", "E", "Lkotlinx/coroutines/channels/p;", "value", "", "a0", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/f0;", "", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/k;", "closed", "Z", "", "toString", "Lkotlinx/coroutines/n;", "d", "Lkotlinx/coroutines/n;", "cont", "", "e", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/n;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class b<E> extends p<E> {

        /* renamed from: d  reason: collision with root package name */
        public final n<Object> f32293d;

        /* renamed from: e  reason: collision with root package name */
        public final int f32294e;

        public b(n<Object> nVar, int i10) {
            this.f32293d = nVar;
            this.f32294e = i10;
        }

        public void Z(k<?> kVar) {
            if (this.f32294e == 1) {
                this.f32293d.resumeWith(Result.b(h.b(h.f32331b.a(kVar.f32335d))));
                return;
            }
            n<Object> nVar = this.f32293d;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(gk.g.a(kVar.e0())));
        }

        public final Object a0(E e10) {
            if (this.f32294e == 1) {
                return h.b(h.f32331b.c(e10));
            }
            return e10;
        }

        public void j(E e10) {
            this.f32293d.M(p.f32594a);
        }

        public String toString() {
            return "ReceiveElement@" + m0.b(this) + "[receiveMode=" + this.f32294e + PropertyUtils.INDEXED_DELIM2;
        }

        public f0 y(E e10, LockFreeLinkedListNode.c cVar) {
            LockFreeLinkedListNode.a aVar;
            n<Object> nVar = this.f32293d;
            Object a02 = a0(e10);
            if (cVar != null) {
                aVar = cVar.f32503c;
            } else {
                aVar = null;
            }
            if (nVar.B(a02, aVar, Y(e10)) == null) {
                return null;
            }
            if (cVar != null) {
                cVar.d();
            }
            return p.f32594a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$c;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$b;", "value", "Lkotlin/Function1;", "", "", "Y", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "f", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Lkotlinx/coroutines/n;", "", "cont", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/n;ILkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class c<E> extends b<E> {

        /* renamed from: f  reason: collision with root package name */
        public final Function1<E, Unit> f32295f;

        public c(n<Object> nVar, int i10, Function1<? super E, Unit> function1) {
            super(nVar, i10);
            this.f32295f = function1;
        }

        public Function1<Throwable, Unit> Y(E e10) {
            return OnUndeliveredElementKt.a(this.f32295f, e10, this.f32293d.getContext());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$d;", "E", "Lkotlinx/coroutines/channels/p;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/f0;", "", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/k;", "closed", "Z", "Lkotlin/Function1;", "", "Y", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel$a;", "d", "Lkotlinx/coroutines/channels/AbstractChannel$a;", "iterator", "Lkotlinx/coroutines/n;", "", "e", "Lkotlinx/coroutines/n;", "cont", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$a;Lkotlinx/coroutines/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class d<E> extends p<E> {

        /* renamed from: d  reason: collision with root package name */
        public final a<E> f32296d;

        /* renamed from: e  reason: collision with root package name */
        public final n<Boolean> f32297e;

        public d(a<E> aVar, n<? super Boolean> nVar) {
            this.f32296d = aVar;
            this.f32297e = nVar;
        }

        public Function1<Throwable, Unit> Y(E e10) {
            Function1<E, Unit> function1 = this.f32296d.f32291a.f32318a;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e10, this.f32297e.getContext());
            }
            return null;
        }

        public void Z(k<?> kVar) {
            Object obj;
            if (kVar.f32335d == null) {
                obj = n.a.b(this.f32297e, Boolean.FALSE, (Object) null, 2, (Object) null);
            } else {
                obj = this.f32297e.p(kVar.e0());
            }
            if (obj != null) {
                this.f32296d.d(kVar);
                this.f32297e.M(obj);
            }
        }

        public void j(E e10) {
            this.f32296d.d(e10);
            this.f32297e.M(p.f32594a);
        }

        public String toString() {
            return "ReceiveHasNext@" + m0.b(this);
        }

        public f0 y(E e10, LockFreeLinkedListNode.c cVar) {
            LockFreeLinkedListNode.a aVar;
            n<Boolean> nVar = this.f32297e;
            Boolean bool = Boolean.TRUE;
            if (cVar != null) {
                aVar = cVar.f32503c;
            } else {
                aVar = null;
            }
            if (nVar.B(bool, aVar, Y(e10)) == null) {
                return null;
            }
            if (cVar != null) {
                cVar.d();
            }
            return p.f32594a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012$\u0010%\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010!0 \u0012\u0006\u0010)\u001a\u00020&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00188\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR5\u0010%\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010!0 8\u0006X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0006X\u0004¢\u0006\u0006\n\u0004\b'\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$e;", "R", "E", "Lkotlinx/coroutines/channels/p;", "Lkotlinx/coroutines/z0;", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/f0;", "", "j", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/k;", "closed", "Z", "dispose", "Lkotlin/Function1;", "", "Y", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "Lkotlinx/coroutines/channels/AbstractChannel;", "d", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/selects/d;", "e", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "f", "Lkotlin/jvm/functions/Function2;", "block", "", "g", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class e<R, E> extends p<E> implements z0 {

        /* renamed from: d  reason: collision with root package name */
        public final AbstractChannel<E> f32298d;

        /* renamed from: e  reason: collision with root package name */
        public final kotlinx.coroutines.selects.d<R> f32299e;

        /* renamed from: f  reason: collision with root package name */
        public final Function2<Object, kotlin.coroutines.c<? super R>, Object> f32300f;

        /* renamed from: g  reason: collision with root package name */
        public final int f32301g;

        public e(AbstractChannel<E> abstractChannel, kotlinx.coroutines.selects.d<? super R> dVar, Function2<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2, int i10) {
            this.f32298d = abstractChannel;
            this.f32299e = dVar;
            this.f32300f = function2;
            this.f32301g = i10;
        }

        public Function1<Throwable, Unit> Y(E e10) {
            Function1<E, Unit> function1 = this.f32298d.f32318a;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e10, this.f32299e.s().getContext());
            }
            return null;
        }

        public void Z(k<?> kVar) {
            if (this.f32299e.n()) {
                int i10 = this.f32301g;
                if (i10 == 0) {
                    this.f32299e.u(kVar.e0());
                } else if (i10 == 1) {
                    zk.a.e(this.f32300f, h.b(h.f32331b.a(kVar.f32335d)), this.f32299e.s(), (Function1) null, 4, (Object) null);
                }
            }
        }

        public void dispose() {
            if (S()) {
                this.f32298d.Z();
            }
        }

        public void j(E e10) {
            E e11;
            Function2<Object, kotlin.coroutines.c<? super R>, Object> function2 = this.f32300f;
            if (this.f32301g == 1) {
                e11 = h.b(h.f32331b.c(e10));
            } else {
                e11 = e10;
            }
            zk.a.d(function2, e11, this.f32299e.s(), Y(e10));
        }

        public String toString() {
            return "ReceiveSelect@" + m0.b(this) + '[' + this.f32299e + ",receiveMode=" + this.f32301g + PropertyUtils.INDEXED_DELIM2;
        }

        public f0 y(E e10, LockFreeLinkedListNode.c cVar) {
            return (f0) this.f32299e.m(cVar);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$f;", "Lkotlinx/coroutines/e;", "", "cause", "", "a", "", "toString", "Lkotlinx/coroutines/channels/p;", "Lkotlinx/coroutines/channels/p;", "receive", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class f extends kotlinx.coroutines.e {

        /* renamed from: a  reason: collision with root package name */
        private final p<?> f32302a;

        public f(p<?> pVar) {
            this.f32302a = pVar;
        }

        public void a(Throwable th2) {
            if (this.f32302a.S()) {
                AbstractChannel.this.Z();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f32013a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f32302a + PropertyUtils.INDEXED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$g;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$d;", "Lkotlinx/coroutines/channels/t;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "", "k", "Lkotlinx/coroutines/internal/p;", "queue", "<init>", "(Lkotlinx/coroutines/internal/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    protected static final class g<E> extends LockFreeLinkedListNode.d<t> {
        public g(kotlinx.coroutines.internal.p pVar) {
            super(pVar);
        }

        /* access modifiers changed from: protected */
        public Object e(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof k) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof t)) {
                return a.f32314d;
            }
            return null;
        }

        public Object j(LockFreeLinkedListNode.c cVar) {
            f0 a02 = ((t) cVar.f32501a).a0(cVar);
            if (a02 == null) {
                return r.f32555a;
            }
            Object obj = kotlinx.coroutines.internal.c.f32521b;
            if (a02 == obj) {
                return obj;
            }
            return null;
        }

        public void k(LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((t) lockFreeLinkedListNode).b0();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$h", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$b;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class h extends LockFreeLinkedListNode.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AbstractChannel f32304d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
            super(lockFreeLinkedListNode);
            this.f32304d = abstractChannel;
        }

        /* renamed from: k */
        public Object i(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f32304d.V()) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JJ\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$i", "Lkotlinx/coroutines/selects/c;", "R", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "", "i", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class i implements kotlinx.coroutines.selects.c<E> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AbstractChannel<E> f32305a;

        i(AbstractChannel<E> abstractChannel) {
            this.f32305a = abstractChannel;
        }

        public <R> void i(kotlinx.coroutines.selects.d<? super R> dVar, Function2<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
            this.f32305a.e0(dVar, 0, function2);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JS\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$j", "Lkotlinx/coroutines/selects/c;", "Lkotlinx/coroutines/channels/h;", "R", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "", "i", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class j implements kotlinx.coroutines.selects.c<h<? extends E>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AbstractChannel<E> f32306a;

        j(AbstractChannel<E> abstractChannel) {
            this.f32306a = abstractChannel;
        }

        public <R> void i(kotlinx.coroutines.selects.d<? super R> dVar, Function2<? super h<? extends E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
            this.f32306a.e0(dVar, 1, function2);
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: private */
    public final boolean R(p<? super E> pVar) {
        boolean S = S(pVar);
        if (S) {
            a0();
        }
        return S;
    }

    private final <R> boolean T(kotlinx.coroutines.selects.d<? super R> dVar, Function2<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2, int i10) {
        e eVar = new e(this, dVar, function2, i10);
        boolean R = R(eVar);
        if (R) {
            dVar.k(eVar);
        }
        return R;
    }

    private final <R> Object d0(int i10, kotlin.coroutines.c<? super R> cVar) {
        b bVar;
        o b10 = q.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        if (this.f32318a == null) {
            bVar = new b(b10, i10);
        } else {
            bVar = new c(b10, i10, this.f32318a);
        }
        while (true) {
            if (!R(bVar)) {
                Object b02 = b0();
                if (!(b02 instanceof k)) {
                    if (b02 != a.f32314d) {
                        b10.q(bVar.a0(b02), bVar.Y(b02));
                        break;
                    }
                } else {
                    bVar.Z((k) b02);
                    break;
                }
            } else {
                f0(b10, bVar);
                break;
            }
        }
        Object v10 = b10.v();
        if (v10 == b.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v10;
    }

    /* access modifiers changed from: private */
    public final <R> void e0(kotlinx.coroutines.selects.d<? super R> dVar, int i10, Function2<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
        while (!dVar.h()) {
            if (!W()) {
                Object c02 = c0(dVar);
                if (c02 != kotlinx.coroutines.selects.e.d()) {
                    if (!(c02 == a.f32314d || c02 == kotlinx.coroutines.internal.c.f32521b)) {
                        g0(function2, dVar, i10, c02);
                    }
                } else {
                    return;
                }
            } else if (T(dVar, function2, i10)) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void f0(n<?> nVar, p<?> pVar) {
        nVar.o(new f(pVar));
    }

    private final <R> void g0(Function2<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2, kotlinx.coroutines.selects.d<? super R> dVar, int i10, Object obj) {
        Object obj2;
        boolean z10 = obj instanceof k;
        if (z10) {
            if (i10 == 0) {
                throw e0.a(((k) obj).e0());
            } else if (i10 == 1 && dVar.n()) {
                zk.b.c(function2, h.b(h.f32331b.a(((k) obj).f32335d)), dVar.s());
            }
        } else if (i10 == 1) {
            h.b bVar = h.f32331b;
            if (z10) {
                obj2 = bVar.a(((k) obj).f32335d);
            } else {
                obj2 = bVar.c(obj);
            }
            zk.b.c(function2, h.b(obj2), dVar.s());
        } else {
            zk.b.c(function2, obj, dVar.s());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object A(kotlin.coroutines.c<? super kotlinx.coroutines.channels.h<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r5)
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            gk.g.b(r5)
            java.lang.Object r5 = r4.b0()
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.a.f32314d
            if (r5 == r2) goto L_0x0052
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.k
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.f32331b
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            java.lang.Throwable r5 = r5.f32335d
            java.lang.Object r5 = r0.a(r5)
            goto L_0x0051
        L_0x004b:
            kotlinx.coroutines.channels.h$b r0 = kotlinx.coroutines.channels.h.f32331b
            java.lang.Object r5 = r0.c(r5)
        L_0x0051:
            return r5
        L_0x0052:
            r0.label = r3
            java.lang.Object r5 = r4.d0(r3, r0)
            if (r5 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlinx.coroutines.channels.h r5 = (kotlinx.coroutines.channels.h) r5
            java.lang.Object r5 = r5.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.A(kotlin.coroutines.c):java.lang.Object");
    }

    public final Object E(kotlin.coroutines.c<? super E> cVar) {
        Object b02 = b0();
        if (b02 == a.f32314d || (b02 instanceof k)) {
            return d0(0, cVar);
        }
        return b02;
    }

    /* access modifiers changed from: protected */
    public r<E> J() {
        r<E> J = super.J();
        if (J != null && !(J instanceof k)) {
            Z();
        }
        return J;
    }

    public final boolean P(Throwable th2) {
        boolean F = F(th2);
        X(F);
        return F;
    }

    /* access modifiers changed from: protected */
    public final g<E> Q() {
        return new g<>(n());
    }

    /* access modifiers changed from: protected */
    public boolean S(p<? super E> pVar) {
        int W;
        LockFreeLinkedListNode O;
        if (U()) {
            kotlinx.coroutines.internal.p n10 = n();
            do {
                O = n10.O();
                if (!(!(O instanceof t))) {
                    return false;
                }
            } while (!O.G(pVar, n10));
        } else {
            kotlinx.coroutines.internal.p n11 = n();
            h hVar = new h(pVar, this);
            do {
                LockFreeLinkedListNode O2 = n11.O();
                if (!(!(O2 instanceof t))) {
                    return false;
                }
                W = O2.W(pVar, n11, hVar);
                if (W != 1) {
                }
            } while (W != 2);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract boolean U();

    /* access modifiers changed from: protected */
    public abstract boolean V();

    /* access modifiers changed from: protected */
    public final boolean W() {
        return !(n().N() instanceof t) && V();
    }

    /* access modifiers changed from: protected */
    public void X(boolean z10) {
        k<?> m10 = m();
        if (m10 != null) {
            Object b10 = m.b((Object) null, 1, (DefaultConstructorMarker) null);
            while (true) {
                LockFreeLinkedListNode O = m10.O();
                if (O instanceof kotlinx.coroutines.internal.p) {
                    Y(b10, m10);
                    return;
                } else if (!O.S()) {
                    O.P();
                } else {
                    b10 = m.c(b10, (t) O);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* access modifiers changed from: protected */
    public void Y(Object obj, k<?> kVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((t) obj).Z(kVar);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 < size) {
                ((t) arrayList.get(size)).Z(kVar);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Z() {
    }

    /* access modifiers changed from: protected */
    public void a0() {
    }

    public final void b(CancellationException cancellationException) {
        if (!j()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(m0.a(this) + " was cancelled");
            }
            P(cancellationException);
        }
    }

    /* access modifiers changed from: protected */
    public Object b0() {
        while (true) {
            t L = L();
            if (L == null) {
                return a.f32314d;
            }
            if (L.a0((LockFreeLinkedListNode.c) null) != null) {
                L.X();
                return L.Y();
            }
            L.b0();
        }
    }

    /* access modifiers changed from: protected */
    public Object c0(kotlinx.coroutines.selects.d<?> dVar) {
        g Q = Q();
        Object w10 = dVar.w(Q);
        if (w10 != null) {
            return w10;
        }
        ((t) Q.o()).X();
        return ((t) Q.o()).Y();
    }

    public final f<E> iterator() {
        return new a(this);
    }

    public boolean j() {
        return l() != null && V();
    }

    public final kotlinx.coroutines.selects.c<E> u() {
        return new i(this);
    }

    public final kotlinx.coroutines.selects.c<h<E>> w() {
        return new j(this);
    }

    public final Object z() {
        Object b02 = b0();
        if (b02 == a.f32314d) {
            return h.f32331b.b();
        }
        if (b02 instanceof k) {
            return h.f32331b.a(((k) b02).f32335d);
        }
        return h.f32331b.c(b02);
    }
}

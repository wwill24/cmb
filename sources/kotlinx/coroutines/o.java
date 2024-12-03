package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.s1;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000e\u0012\u0006\u0010'\u001a\u00020!¢\u0006\u0004\b{\u0010|J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001c\u001a\u00020\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001f\u001a\u00020\u001e2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$JK\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020!2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b*\u0010+J9\u0010,\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020!2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0004\b,\u0010-J;\u0010/\u001a\u0004\u0018\u00010.2\b\u0010&\u001a\u0004\u0018\u00010\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u001a2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u0002012\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u0019J\u000f\u00105\u001a\u00020\u000eH\u0016¢\u0006\u0004\b5\u0010\u0019J\u000f\u00106\u001a\u00020\u0006H\u0001¢\u0006\u0004\b6\u0010\bJ\u0011\u00107\u001a\u0004\u0018\u00010\u001aH\u0010¢\u0006\u0004\b7\u00108J!\u0010:\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b<\u0010\fJ\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b?\u0010@J)\u0010A\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bA\u0010\u0012J\u0017\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\bF\u00108J \u0010I\u001a\u00020\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000GH\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ-\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00028\u00002\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\bL\u0010MJ)\u0010N\u001a\u00020\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000fH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u000eH\u0000¢\u0006\u0004\bP\u0010\u0019J#\u0010Q\u001a\u0004\u0018\u00010\u001a2\u0006\u0010K\u001a\u00028\u00002\b\u0010)\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bQ\u0010RJ9\u0010S\u001a\u0004\u0018\u00010\u001a2\u0006\u0010K\u001a\u00028\u00002\b\u0010)\u001a\u0004\u0018\u00010\u001a2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u0004\u0018\u00010\u001a2\u0006\u0010U\u001a\u00020\tH\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u001aH\u0016¢\u0006\u0004\bY\u0010JJ\u001b\u0010[\u001a\u00020\u000e*\u00020Z2\u0006\u0010K\u001a\u00028\u0000H\u0016¢\u0006\u0004\b[\u0010\\J\u001f\u0010]\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0010¢\u0006\u0004\b]\u0010^J\u001b\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0010¢\u0006\u0004\b_\u0010`J\u000f\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020aH\u0014¢\u0006\u0004\bd\u0010cR \u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000e8\u0000X\u0004¢\u0006\f\n\u0004\bQ\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010n\u001a\u00020j8\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010k\u001a\u0004\bl\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010oR\u0014\u0010r\u001a\u00020a8BX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010cR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8@X\u0004¢\u0006\u0006\u001a\u0004\bs\u00108R\u0014\u0010u\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\bR\u0014\u0010w\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bv\u0010\bR\u001c\u0010z\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0004¢\u0006\u0006\u001a\u0004\bx\u0010y\u0002\u0004\n\u0002\b\u0019¨\u0006}"}, d2 = {"Lkotlinx/coroutines/o;", "T", "Lkotlinx/coroutines/u0;", "Lkotlinx/coroutines/n;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "C", "()Z", "", "cause", "m", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "j", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Q", "O", "Lkotlinx/coroutines/z0;", "z", "()Lkotlinx/coroutines/z0;", "I", "()V", "", "state", "F", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/l;", "E", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/l;", "", "mode", "t", "(I)V", "Lkotlinx/coroutines/f2;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "N", "(Lkotlinx/coroutines/f2;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "K", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/f0;", "P", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/f0;", "", "i", "(Ljava/lang/Object;)Ljava/lang/Void;", "s", "y", "J", "h", "()Ljava/lang/Object;", "takenState", "b", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "r", "H", "(Ljava/lang/Throwable;)V", "k", "(Lkotlinx/coroutines/l;Ljava/lang/Throwable;)V", "l", "Lkotlinx/coroutines/s1;", "parent", "u", "(Lkotlinx/coroutines/s1;)Ljava/lang/Throwable;", "v", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "q", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "o", "(Lkotlin/jvm/functions/Function1;)V", "n", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "B", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "p", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "M", "Lkotlinx/coroutines/CoroutineDispatcher;", "D", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "G", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/c;", "c", "()Lkotlin/coroutines/c;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/z0;", "parentHandle", "x", "stateDebugRepresentation", "w", "a", "isActive", "A", "isCompleted", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class o<T> extends u0<T> implements n<T>, c {

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32586g = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decision");

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32587h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision = 0;
    private volatile /* synthetic */ Object _state = d.f32341a;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<T> f32588d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineContext f32589e;

    /* renamed from: f  reason: collision with root package name */
    private z0 f32590f;

    public o(kotlin.coroutines.c<? super T> cVar, int i10) {
        super(i10);
        this.f32588d = cVar;
        this.f32589e = cVar.getContext();
    }

    private final boolean C() {
        return v0.c(this.f32728c) && ((i) this.f32588d).m();
    }

    private final l E(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof l ? (l) function1 : new p1(function1);
    }

    private final void F(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void I() {
        i iVar;
        Throwable t10;
        kotlin.coroutines.c<T> cVar = this.f32588d;
        if (cVar instanceof i) {
            iVar = (i) cVar;
        } else {
            iVar = null;
        }
        if (iVar != null && (t10 = iVar.t(this)) != null) {
            n();
            r(t10);
        }
    }

    private final void K(Object obj, int i10, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof f2) {
            } else {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (rVar.c()) {
                        if (function1 != null) {
                            l(function1, rVar.f32285a);
                            return;
                        }
                        return;
                    }
                }
                i(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(f32587h, this, obj2, N((f2) obj2, obj, i10, function1, (Object) null)));
        s();
        t(i10);
    }

    static /* synthetic */ void L(o oVar, Object obj, int i10, Function1 function1, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                function1 = null;
            }
            oVar.K(obj, i10, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object N(f2 f2Var, Object obj, int i10, Function1<? super Throwable, Unit> function1, Object obj2) {
        l lVar;
        if (obj instanceof b0) {
            return obj;
        }
        if (!v0.b(i10) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(f2Var instanceof l) || (f2Var instanceof e)) && obj2 == null)) {
            return obj;
        }
        if (f2Var instanceof l) {
            lVar = (l) f2Var;
        } else {
            lVar = null;
        }
        return new a0(obj, lVar, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    private final boolean O() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f32586g.compareAndSet(this, 0, 2));
        return true;
    }

    private final f0 P(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof f2) {
            } else if (!(obj3 instanceof a0) || obj2 == null || ((a0) obj3).f32271d != obj2) {
                return null;
            } else {
                return p.f32594a;
            }
        } while (!a.a(f32587h, this, obj3, N((f2) obj3, obj, this.f32728c, function1, obj2)));
        s();
        return p.f32594a;
    }

    private final boolean Q() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f32586g.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void i(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void j(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context = getContext();
            i0.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    private final boolean m(Throwable th2) {
        if (!C()) {
            return false;
        }
        return ((i) this.f32588d).n(th2);
    }

    private final void s() {
        if (!C()) {
            n();
        }
    }

    private final void t(int i10) {
        if (!O()) {
            v0.a(this, i10);
        }
    }

    private final String x() {
        Object w10 = w();
        if (w10 instanceof f2) {
            return "Active";
        }
        if (w10 instanceof r) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    private final z0 z() {
        s1 s1Var = (s1) getContext().c(s1.f32618v);
        if (s1Var == null) {
            return null;
        }
        z0 d10 = s1.a.d(s1Var, true, false, new s(this), 2, (Object) null);
        this.f32590f = d10;
        return d10;
    }

    public boolean A() {
        return !(w() instanceof f2);
    }

    public Object B(T t10, Object obj, Function1<? super Throwable, Unit> function1) {
        return P(t10, obj, function1);
    }

    public void D(CoroutineDispatcher coroutineDispatcher, T t10) {
        i iVar;
        int i10;
        kotlin.coroutines.c<T> cVar = this.f32588d;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (cVar instanceof i) {
            iVar = (i) cVar;
        } else {
            iVar = null;
        }
        if (iVar != null) {
            coroutineDispatcher2 = iVar.f32535d;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i10 = 4;
        } else {
            i10 = this.f32728c;
        }
        L(this, t10, i10, (Function1) null, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public String G() {
        return "CancellableContinuation";
    }

    public final void H(Throwable th2) {
        if (!m(th2)) {
            r(th2);
            s();
        }
    }

    public final boolean J() {
        Object obj = this._state;
        if (!(obj instanceof a0) || ((a0) obj).f32271d == null) {
            this._decision = 0;
            this._state = d.f32341a;
            return true;
        }
        n();
        return false;
    }

    public void M(Object obj) {
        t(this.f32728c);
    }

    public boolean a() {
        return w() instanceof f2;
    }

    public void b(Object obj, Throwable th2) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof f2) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof b0)) {
                if (obj2 instanceof a0) {
                    a0 a0Var = (a0) obj2;
                    if (!a0Var.c()) {
                        if (a.a(f32587h, this, obj2, a0.b(a0Var, (Object) null, (l) null, (Function1) null, (Object) null, th2, 15, (Object) null))) {
                            a0Var.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (a.a(f32587h, this, obj2, new a0(obj2, (l) null, (Function1) null, (Object) null, th2, 14, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final kotlin.coroutines.c<T> c() {
        return this.f32588d;
    }

    public Object d(T t10, Object obj) {
        return P(t10, obj, (Function1<? super Throwable, Unit>) null);
    }

    public Throwable e(Object obj) {
        Throwable e10 = super.e(obj);
        if (e10 != null) {
            return e10;
        }
        return null;
    }

    public <T> T f(Object obj) {
        return obj instanceof a0 ? ((a0) obj).f32268a : obj;
    }

    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f32588d;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f32589e;
    }

    public Object h() {
        return w();
    }

    public final void k(l lVar, Throwable th2) {
        try {
            lVar.a(th2);
        } catch (Throwable th3) {
            CoroutineContext context = getContext();
            i0.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void l(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context = getContext();
            i0.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    public final void n() {
        z0 z0Var = this.f32590f;
        if (z0Var != null) {
            z0Var.dispose();
            this.f32590f = e2.f32353a;
        }
    }

    public void o(Function1<? super Throwable, Unit> function1) {
        l E = E(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (a.a(f32587h, this, obj, E)) {
                    return;
                }
            } else if (obj instanceof l) {
                F(function1, obj);
            } else {
                boolean z10 = obj instanceof b0;
                if (z10) {
                    b0 b0Var = (b0) obj;
                    if (!b0Var.b()) {
                        F(function1, obj);
                    }
                    if (obj instanceof r) {
                        Throwable th2 = null;
                        if (!z10) {
                            b0Var = null;
                        }
                        if (b0Var != null) {
                            th2 = b0Var.f32285a;
                        }
                        j(function1, th2);
                        return;
                    }
                    return;
                } else if (obj instanceof a0) {
                    a0 a0Var = (a0) obj;
                    if (a0Var.f32269b != null) {
                        F(function1, obj);
                    }
                    if (!(E instanceof e)) {
                        if (a0Var.c()) {
                            j(function1, a0Var.f32272e);
                            return;
                        }
                        if (a.a(f32587h, this, obj, a0.b(a0Var, (Object) null, E, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(E instanceof e)) {
                    if (a.a(f32587h, this, obj, new a0(obj, E, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Object p(Throwable th2) {
        return P(new b0(th2, false, 2, (DefaultConstructorMarker) null), (Object) null, (Function1<? super Throwable, Unit>) null);
    }

    public void q(T t10, Function1<? super Throwable, Unit> function1) {
        K(t10, this.f32728c, function1);
    }

    public boolean r(Throwable th2) {
        Object obj;
        boolean z10;
        l lVar;
        do {
            obj = this._state;
            if (!(obj instanceof f2)) {
                return false;
            }
            z10 = obj instanceof l;
        } while (!a.a(f32587h, this, obj, new r(this, th2, z10)));
        if (z10) {
            lVar = (l) obj;
        } else {
            lVar = null;
        }
        if (lVar != null) {
            k(lVar, th2);
        }
        s();
        t(this.f32728c);
        return true;
    }

    public void resumeWith(Object obj) {
        L(this, e0.c(obj, this), this.f32728c, (Function1) null, 4, (Object) null);
    }

    public String toString() {
        return G() + PropertyUtils.MAPPED_DELIM + m0.c(this.f32588d) + "){" + x() + "}@" + m0.b(this);
    }

    public Throwable u(s1 s1Var) {
        return s1Var.n();
    }

    public final Object v() {
        s1 s1Var;
        boolean C = C();
        if (Q()) {
            if (this.f32590f == null) {
                z();
            }
            if (C) {
                I();
            }
            return b.d();
        }
        if (C) {
            I();
        }
        Object w10 = w();
        if (w10 instanceof b0) {
            throw ((b0) w10).f32285a;
        } else if (!v0.b(this.f32728c) || (s1Var = (s1) getContext().c(s1.f32618v)) == null || s1Var.a()) {
            return f(w10);
        } else {
            CancellationException n10 = s1Var.n();
            b(w10, n10);
            throw n10;
        }
    }

    public final Object w() {
        return this._state;
    }

    public void y() {
        z0 z10 = z();
        if (z10 != null && A()) {
            z10.dispose();
            this.f32590f = e2.f32353a;
        }
    }
}

package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.u0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010-\u001a\u00020*\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b@\u0010AJ\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0010¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00028\u0000H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0006X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00103\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b0\u00101\u0012\u0004\b2\u0010\u000bR\u0014\u00105\u001a\u00020\u00188\u0000X\u0004¢\u0006\u0006\n\u0004\b4\u00101R\u001a\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u000fR\u0014\u0010#\u001a\u00020\"8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u001c\u0010<\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lkotlinx/coroutines/internal/i;", "T", "Lkotlinx/coroutines/u0;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/c;", "", "m", "()Z", "", "i", "()V", "s", "Lkotlinx/coroutines/o;", "j", "()Lkotlinx/coroutines/o;", "Lkotlinx/coroutines/n;", "continuation", "", "t", "(Lkotlinx/coroutines/n;)Ljava/lang/Throwable;", "cause", "n", "(Ljava/lang/Throwable;)Z", "", "h", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "takenState", "b", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "k", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "e", "Lkotlin/coroutines/c;", "f", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "_state", "g", "countOrElement", "l", "reusableCancellableContinuation", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "c", "()Lkotlin/coroutines/c;", "delegate", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class i<T> extends u0<T> implements c, kotlin.coroutines.c<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32534h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineDispatcher f32535d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f32536e;

    /* renamed from: f  reason: collision with root package name */
    public Object f32537f = j.f32539a;

    /* renamed from: g  reason: collision with root package name */
    public final Object f32538g = ThreadContextKt.b(getContext());

    public i(CoroutineDispatcher coroutineDispatcher, kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f32535d = coroutineDispatcher;
        this.f32536e = cVar;
    }

    private final o<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof o) {
            return (o) obj;
        }
        return null;
    }

    public void b(Object obj, Throwable th2) {
        if (obj instanceof c0) {
            ((c0) obj).f32289b.invoke(th2);
        }
    }

    public kotlin.coroutines.c<T> c() {
        return this;
    }

    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f32536e;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f32536e.getContext();
    }

    public Object h() {
        Object obj = this.f32537f;
        this.f32537f = j.f32539a;
        return obj;
    }

    public final void i() {
        do {
        } while (this._reusableCancellableContinuation == j.f32540b);
    }

    public final o<T> j() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = j.f32540b;
                return null;
            } else if (obj instanceof o) {
                if (a.a(f32534h, this, obj, j.f32540b)) {
                    return (o) obj;
                }
            } else if (obj != j.f32540b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void k(CoroutineContext coroutineContext, T t10) {
        this.f32537f = t10;
        this.f32728c = 1;
        this.f32535d.F(coroutineContext, this);
    }

    public final boolean m() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean n(Throwable th2) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            f0 f0Var = j.f32540b;
            if (j.b(obj, f0Var)) {
                if (a.a(f32534h, this, f0Var, th2)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f32534h, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object c10;
        CoroutineContext context2 = this.f32536e.getContext();
        Object d10 = e0.d(obj, (Function1) null, 1, (Object) null);
        if (this.f32535d.O(context2)) {
            this.f32537f = d10;
            this.f32728c = 0;
            this.f32535d.E(context2, this);
            return;
        }
        d1 b10 = q2.f32598a.b();
        if (b10.B0()) {
            this.f32537f = d10;
            this.f32728c = 0;
            b10.i0(this);
            return;
        }
        b10.q0(true);
        try {
            context = getContext();
            c10 = ThreadContextKt.c(context, this.f32538g);
            this.f32536e.resumeWith(obj);
            Unit unit = Unit.f32013a;
            ThreadContextKt.a(context, c10);
            do {
            } while (b10.I0());
        } catch (Throwable th2) {
            try {
                g(th2, (Throwable) null);
            } catch (Throwable th3) {
                b10.Y(true);
                throw th3;
            }
        }
        b10.Y(true);
    }

    public final void s() {
        i();
        o<?> l10 = l();
        if (l10 != null) {
            l10.n();
        }
    }

    public final Throwable t(n<?> nVar) {
        f0 f0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            f0Var = j.f32540b;
            if (obj != f0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(f32534h, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!a.a(f32534h, this, f0Var, nVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f32535d + ", " + m0.c(this.f32536e) + PropertyUtils.INDEXED_DELIM2;
    }
}

package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.h;
import zk.b;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0000\u001aJ\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e\u001a\u001e\u0010\u0015\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0014\u001a\n\u0010\u0016\u001a\u00020\u0010*\u00020\u0000\"\u001b\u0010\u001c\u001a\u00020\u0017*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/CoroutineContext;", "context", "j", "b", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "g", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "d", "", "message", "", "c", "h", "", "i", "(Lkotlinx/coroutines/k0;)Z", "isActive$annotations", "(Lkotlinx/coroutines/k0;)V", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class l0 {
    public static final k0 a(CoroutineContext coroutineContext) {
        if (coroutineContext.c(s1.f32618v) == null) {
            coroutineContext = coroutineContext.e0(x1.b((s1) null, 1, (Object) null));
        }
        return new h(coroutineContext);
    }

    public static final k0 b() {
        return new h(o2.b((s1) null, 1, (Object) null).e0(x0.c()));
    }

    public static final void c(k0 k0Var, String str, Throwable th2) {
        d(k0Var, i1.a(str, th2));
    }

    public static final void d(k0 k0Var, CancellationException cancellationException) {
        s1 s1Var = (s1) k0Var.G().c(s1.f32618v);
        if (s1Var != null) {
            s1Var.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + k0Var).toString());
    }

    public static /* synthetic */ void e(k0 k0Var, String str, Throwable th2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        c(k0Var, str, th2);
    }

    public static /* synthetic */ void f(k0 k0Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        d(k0Var, cancellationException);
    }

    public static final <R> Object g(Function2<? super k0, ? super c<? super R>, ? extends Object> function2, c<? super R> cVar) {
        b0 b0Var = new b0(cVar.getContext(), cVar);
        Object d10 = b.d(b0Var, b0Var, function2);
        if (d10 == b.d()) {
            f.c(cVar);
        }
        return d10;
    }

    public static final void h(k0 k0Var) {
        v1.i(k0Var.G());
    }

    public static final boolean i(k0 k0Var) {
        s1 s1Var = (s1) k0Var.G().c(s1.f32618v);
        if (s1Var != null) {
            return s1Var.a();
        }
        return true;
    }

    public static final k0 j(k0 k0Var, CoroutineContext coroutineContext) {
        return new h(k0Var.G().e0(coroutineContext));
    }
}

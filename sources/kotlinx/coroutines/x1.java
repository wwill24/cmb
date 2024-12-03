package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\u0007\u001a\u001c\u0010\u000f\u001a\u00020\u000b*\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\"\u0015\u0010\u0012\u001a\u00020\u0000*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/s1;", "parent", "Lkotlinx/coroutines/z;", "a", "Lkotlinx/coroutines/z0;", "handle", "g", "Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "c", "i", "h", "e", "j", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/s1;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/JobKt")
final /* synthetic */ class x1 {
    public static final z a(s1 s1Var) {
        return new u1(s1Var);
    }

    public static /* synthetic */ z b(s1 s1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            s1Var = null;
        }
        return v1.a(s1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        s1 s1Var = (s1) coroutineContext.c(s1.f32618v);
        if (s1Var != null) {
            s1Var.b(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        v1.c(coroutineContext, cancellationException);
    }

    public static final void e(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<s1> children;
        s1 s1Var = (s1) coroutineContext.c(s1.f32618v);
        if (s1Var != null && (children = s1Var.getChildren()) != null) {
            for (s1 b10 : children) {
                b10.b(cancellationException);
            }
        }
    }

    public static /* synthetic */ void f(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        v1.e(coroutineContext, cancellationException);
    }

    public static final z0 g(s1 s1Var, z0 z0Var) {
        return s1Var.y(new b1(z0Var));
    }

    public static final void h(CoroutineContext coroutineContext) {
        s1 s1Var = (s1) coroutineContext.c(s1.f32618v);
        if (s1Var != null) {
            v1.j(s1Var);
        }
    }

    public static final void i(s1 s1Var) {
        if (!s1Var.a()) {
            throw s1Var.n();
        }
    }

    public static final s1 j(CoroutineContext coroutineContext) {
        s1 s1Var = (s1) coroutineContext.c(s1.f32618v);
        if (s1Var != null) {
            return s1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }
}

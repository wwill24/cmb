package zk;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.z1;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aT\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\f\u001aV\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\n\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aV\u0010\u0012\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\n\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "", "b", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "c", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/c;)V", "a", "Lkotlinx/coroutines/internal/b0;", "block", "d", "(Lkotlinx/coroutines/internal/b0;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "e", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class b {
    public static final <R, T> void a(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar) {
        CoroutineContext context;
        Object c10;
        c<? super T> a10 = f.a(cVar);
        try {
            context = cVar.getContext();
            c10 = ThreadContextKt.c(context, (Object) null);
            Object invoke = ((Function2) p.d(function2, 2)).invoke(r10, a10);
            ThreadContextKt.a(context, c10);
            if (invoke != b.d()) {
                a10.resumeWith(Result.b(invoke));
            }
        } catch (Throwable th2) {
            Result.a aVar = Result.f32010a;
            a10.resumeWith(Result.b(g.a(th2)));
        }
    }

    public static final <T> void b(Function1<? super c<? super T>, ? extends Object> function1, c<? super T> cVar) {
        c<? super T> a10 = f.a(cVar);
        try {
            Object invoke = ((Function1) p.d(function1, 1)).invoke(a10);
            if (invoke != b.d()) {
                a10.resumeWith(Result.b(invoke));
            }
        } catch (Throwable th2) {
            Result.a aVar = Result.f32010a;
            a10.resumeWith(Result.b(g.a(th2)));
        }
    }

    public static final <R, T> void c(Function2<? super R, ? super c<? super T>, ? extends Object> function2, R r10, c<? super T> cVar) {
        c<? super T> a10 = f.a(cVar);
        try {
            Object invoke = ((Function2) p.d(function2, 2)).invoke(r10, a10);
            if (invoke != b.d()) {
                a10.resumeWith(Result.b(invoke));
            }
        } catch (Throwable th2) {
            Result.a aVar = Result.f32010a;
            a10.resumeWith(Result.b(g.a(th2)));
        }
    }

    public static final <T, R> Object d(b0<? super T> b0Var, R r10, Function2<? super R, ? super c<? super T>, ? extends Object> function2) {
        Object obj;
        try {
            obj = ((Function2) p.d(function2, 2)).invoke(r10, b0Var);
        } catch (Throwable th2) {
            obj = new kotlinx.coroutines.b0(th2, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == b.d()) {
            return b.d();
        }
        Object F0 = b0Var.F0(obj);
        if (F0 == z1.f32742b) {
            return b.d();
        }
        if (!(F0 instanceof kotlinx.coroutines.b0)) {
            return z1.h(F0);
        }
        throw ((kotlinx.coroutines.b0) F0).f32285a;
    }

    public static final <T, R> Object e(b0<? super T> b0Var, R r10, Function2<? super R, ? super c<? super T>, ? extends Object> function2) {
        Object obj;
        boolean z10 = false;
        try {
            obj = ((Function2) p.d(function2, 2)).invoke(r10, b0Var);
        } catch (Throwable th2) {
            obj = new kotlinx.coroutines.b0(th2, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == b.d()) {
            return b.d();
        }
        Object F0 = b0Var.F0(obj);
        if (F0 == z1.f32742b) {
            return b.d();
        }
        if (F0 instanceof kotlinx.coroutines.b0) {
            Throwable th3 = ((kotlinx.coroutines.b0) F0).f32285a;
            if (!(th3 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th3).f32266a != b0Var) {
                z10 = true;
            }
            if (z10) {
                throw th3;
            } else if (obj instanceof kotlinx.coroutines.b0) {
                throw ((kotlinx.coroutines.b0) obj).f32285a;
            }
        } else {
            obj = z1.h(F0);
        }
        return obj;
    }
}

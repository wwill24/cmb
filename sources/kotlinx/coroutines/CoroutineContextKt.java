package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0001H\u0002\u001a \u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0002\u001a(\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0013\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f*\u00020\u0011H\u0010\"\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/CoroutineContext;", "context", "e", "addedContext", "d", "", "c", "originalContext", "appendContext", "isNewCoroutine", "a", "Lkotlin/coroutines/c;", "", "oldValue", "Lkotlinx/coroutines/x2;", "g", "Lkotlin/coroutines/jvm/internal/c;", "f", "", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineContextKt {
    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z10) {
        boolean c10 = c(coroutineContext);
        boolean c11 = c(coroutineContext2);
        if (!c10 && !c11) {
            return coroutineContext.e0(coroutineContext2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f32070a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.v0(emptyCoroutineContext, new CoroutineContextKt$foldCopies$folded$1(ref$ObjectRef, z10));
        if (c11) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).v0(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.f32244a);
        }
        return coroutineContext3.e0((CoroutineContext) ref$ObjectRef.element);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.v0(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.f32245a)).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!c(coroutineContext2)) {
            return coroutineContext.e0(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(k0 k0Var, CoroutineContext coroutineContext) {
        CoroutineContext a10 = a(k0Var.G(), coroutineContext, true);
        if (a10 == x0.a() || a10.c(d.f32074s) != null) {
            return a10;
        }
        return a10.e0(x0.a());
    }

    public static final x2<?> f(c cVar) {
        while (!(cVar instanceof t0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof x2) {
                return (x2) cVar;
            }
        }
        return null;
    }

    public static final x2<?> g(kotlin.coroutines.c<?> cVar, CoroutineContext coroutineContext, Object obj) {
        boolean z10;
        if (!(cVar instanceof c)) {
            return null;
        }
        if (coroutineContext.c(y2.f32740a) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        x2<?> f10 = f((c) cVar);
        if (f10 != null) {
            f10.k1(coroutineContext, obj);
        }
        return f10;
    }
}

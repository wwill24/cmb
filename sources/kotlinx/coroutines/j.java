package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.b0;
import zk.a;
import zk.b;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aL\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aX\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aR\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "block", "Lkotlinx/coroutines/s1;", "c", "(Lkotlinx/coroutines/k0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/s1;", "T", "Lkotlinx/coroutines/p0;", "a", "(Lkotlinx/coroutines/k0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/p0;", "e", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class j {
    public static final <T> p0<T> a(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) {
        q0 q0Var;
        CoroutineContext e10 = CoroutineContextKt.e(k0Var, coroutineContext);
        if (coroutineStart.c()) {
            q0Var = new a2(e10, function2);
        } else {
            q0Var = new q0(e10, true);
        }
        q0Var.h1(coroutineStart, q0Var, function2);
        return q0Var;
    }

    public static /* synthetic */ p0 b(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final s1 c(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        a aVar;
        CoroutineContext e10 = CoroutineContextKt.e(k0Var, coroutineContext);
        if (coroutineStart.c()) {
            aVar = new b2(e10, function2);
        } else {
            aVar = new m2(e10, true);
        }
        aVar.h1(coroutineStart, aVar, function2);
        return aVar;
    }

    public static /* synthetic */ s1 d(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.c(k0Var, coroutineContext, coroutineStart, function2);
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super T>, ? extends Object> function2, c<? super T> cVar) {
        Object obj;
        CoroutineContext context = cVar.getContext();
        CoroutineContext d10 = CoroutineContextKt.d(context, coroutineContext);
        v1.i(d10);
        if (d10 == context) {
            b0 b0Var = new b0(d10, cVar);
            obj = b.d(b0Var, b0Var, function2);
        } else {
            d.b bVar = d.f32074s;
            if (kotlin.jvm.internal.j.b(d10.c(bVar), context.c(bVar))) {
                x2 x2Var = new x2(d10, cVar);
                Object c10 = ThreadContextKt.c(d10, (Object) null);
                try {
                    Object d11 = b.d(x2Var, x2Var, function2);
                    ThreadContextKt.a(d10, c10);
                    obj = d11;
                } catch (Throwable th2) {
                    ThreadContextKt.a(d10, c10);
                    throw th2;
                }
            } else {
                t0 t0Var = new t0(d10, cVar);
                a.e(function2, t0Var, t0Var, (Function1) null, 4, (Object) null);
                obj = t0Var.j1();
            }
        }
        if (obj == b.d()) {
            f.c(cVar);
        }
        return obj;
    }
}

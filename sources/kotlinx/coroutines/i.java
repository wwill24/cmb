package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aQ\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "block", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class i {
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) throws InterruptedException {
        CoroutineContext coroutineContext2;
        d1 d1Var;
        d1 d1Var2;
        Thread currentThread = Thread.currentThread();
        d dVar = (d) coroutineContext.c(d.f32074s);
        if (dVar == null) {
            d1Var = q2.f32598a.b();
            coroutineContext2 = CoroutineContextKt.e(l1.f32580a, coroutineContext.e0(d1Var));
        } else {
            d1 d1Var3 = null;
            if (dVar instanceof d1) {
                d1Var2 = (d1) dVar;
            } else {
                d1Var2 = null;
            }
            if (d1Var2 != null) {
                if (d1Var2.N0()) {
                    d1Var3 = d1Var2;
                }
                if (d1Var3 != null) {
                    d1Var = d1Var3;
                    coroutineContext2 = CoroutineContextKt.e(l1.f32580a, coroutineContext);
                }
            }
            d1Var = q2.f32598a.a();
            coroutineContext2 = CoroutineContextKt.e(l1.f32580a, coroutineContext);
        }
        f fVar = new f(coroutineContext2, currentThread, d1Var);
        fVar.h1(CoroutineStart.DEFAULT, fVar, function2);
        return fVar.i1();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i10, Object obj) throws InterruptedException {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        return h.e(coroutineContext, function2);
    }
}

package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"T", "Lkotlinx/coroutines/w;", "Lkotlin/Result;", "result", "", "c", "(Lkotlinx/coroutines/w;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/s1;", "parent", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class y {
    public static final <T> w<T> a(s1 s1Var) {
        return new x(s1Var);
    }

    public static /* synthetic */ w b(s1 s1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            s1Var = null;
        }
        return a(s1Var);
    }

    public static final <T> boolean c(w<T> wVar, Object obj) {
        Throwable e10 = Result.e(obj);
        return e10 == null ? wVar.L(obj) : wVar.J(e10);
    }
}

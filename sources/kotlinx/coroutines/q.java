package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.i;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\f\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"T", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/o;", "b", "Lkotlinx/coroutines/n;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "", "c", "Lkotlinx/coroutines/z0;", "handle", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class q {
    public static final void a(n<?> nVar, z0 z0Var) {
        nVar.o(new a1(z0Var));
    }

    public static final <T> o<T> b(c<? super T> cVar) {
        if (!(cVar instanceof i)) {
            return new o<>(cVar, 1);
        }
        o<T> j10 = ((i) cVar).j();
        if (j10 != null) {
            if (!j10.J()) {
                j10 = null;
            }
            if (j10 != null) {
                return j10;
            }
        }
        return new o<>(cVar, 2);
    }

    public static final void c(n<?> nVar, LockFreeLinkedListNode lockFreeLinkedListNode) {
        nVar.o(new h2(lockFreeLinkedListNode));
    }
}

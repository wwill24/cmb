package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.selects.c;
import kotlinx.coroutines.selects.d;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u00148PX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/x;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/selects/c;", "f", "()Ljava/lang/Object;", "v", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/d;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "", "i", "(Lkotlinx/coroutines/selects/d;Lkotlin/jvm/functions/Function2;)V", "value", "", "L", "(Ljava/lang/Object;)Z", "", "exception", "J", "n0", "()Z", "onCancelComplete", "Lkotlinx/coroutines/s1;", "parent", "<init>", "(Lkotlinx/coroutines/s1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class x<T> extends JobSupport implements w<T>, c<T> {
    public x(s1 s1Var) {
        super(true);
        w0(s1Var);
    }

    public boolean J(Throwable th2) {
        return E0(new b0(th2, false, 2, (DefaultConstructorMarker) null));
    }

    public boolean L(T t10) {
        return E0(t10);
    }

    public T f() {
        return j0();
    }

    public <R> void i(d<? super R> dVar, Function2<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2) {
        Q0(dVar, function2);
    }

    public boolean n0() {
        return true;
    }

    public Object v(kotlin.coroutines.c<? super T> cVar) {
        Object U = U(cVar);
        Object unused = b.d();
        return U;
    }
}

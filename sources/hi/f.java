package hi;

import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.h;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleNotStartedException;
import java.util.Comparator;
import qj.a;
import qj.q;
import vj.l;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Comparable<Object>> f23478a = new c();

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean c(Comparator comparator, Object obj, Object obj2) throws Exception {
        return comparator.compare(obj2, obj) >= 0;
    }

    public static <E> qj.f e(b<E> bVar) throws OutsideScopeException {
        return f(bVar, true);
    }

    public static <E> qj.f f(b<E> bVar, boolean z10) throws OutsideScopeException {
        E x02 = bVar.x0();
        a<E> a12 = bVar.a1();
        if (x02 != null) {
            try {
                return g(bVar.x(), a12.apply(x02));
            } catch (Exception e10) {
                if (!z10 || !(e10 instanceof LifecycleEndedException)) {
                    return a.v(e10);
                }
                vj.f<? super OutsideScopeException> a10 = h.a();
                if (a10 != null) {
                    try {
                        a10.accept((LifecycleEndedException) e10);
                        return a.m();
                    } catch (Exception e11) {
                        return a.v(e11);
                    }
                } else {
                    throw e10;
                }
            }
        } else {
            throw new LifecycleNotStartedException();
        }
    }

    public static <E> qj.f g(q<E> qVar, E e10) {
        Comparator<Comparable<Object>> comparator;
        if (e10 instanceof Comparable) {
            comparator = f23478a;
        } else {
            comparator = null;
        }
        return h(qVar, e10, comparator);
    }

    public static <E> qj.f h(q<E> qVar, E e10, Comparator<E> comparator) {
        l lVar;
        if (comparator != null) {
            lVar = new d(comparator, e10);
        } else {
            lVar = new e(e10);
        }
        return qVar.j0(1).o0(lVar).Q();
    }
}

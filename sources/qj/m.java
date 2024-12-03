package qj;

import bk.a;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.b;
import io.reactivex.internal.operators.maybe.c;
import io.reactivex.internal.operators.maybe.d;
import io.reactivex.internal.operators.maybe.e;
import java.util.concurrent.Callable;
import vj.l;

public abstract class m<T> implements o<T> {
    public static <T> m<T> b() {
        return a.m(b.f30310a);
    }

    public static <T> m<T> d(Callable<? extends T> callable) {
        xj.b.e(callable, "callable is null");
        return a.m(new d(callable));
    }

    public static <T> m<T> e(T t10) {
        xj.b.e(t10, "item is null");
        return a.m(new e(t10));
    }

    public final void a(n<? super T> nVar) {
        xj.b.e(nVar, "observer is null");
        n<? super Object> x10 = a.x(this, nVar);
        xj.b.e(x10, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            f(x10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            uj.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final m<T> c(l<? super T> lVar) {
        xj.b.e(lVar, "predicate is null");
        return a.m(new c(this, lVar));
    }

    /* access modifiers changed from: protected */
    public abstract void f(n<? super T> nVar);

    public final w<T> g(b0<? extends T> b0Var) {
        xj.b.e(b0Var, "other is null");
        return a.o(new MaybeSwitchIfEmptySingle(this, b0Var));
    }
}

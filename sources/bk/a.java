package bk;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import qj.d;
import qj.h;
import qj.m;
import qj.n;
import qj.q;
import qj.u;
import qj.v;
import qj.w;
import qj.z;
import rn.b;
import vj.c;
import vj.e;
import vj.f;
import vj.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile f<? super Throwable> f24902a;

    /* renamed from: b  reason: collision with root package name */
    static volatile j<? super Runnable, ? extends Runnable> f24903b;

    /* renamed from: c  reason: collision with root package name */
    static volatile j<? super Callable<v>, ? extends v> f24904c;

    /* renamed from: d  reason: collision with root package name */
    static volatile j<? super Callable<v>, ? extends v> f24905d;

    /* renamed from: e  reason: collision with root package name */
    static volatile j<? super Callable<v>, ? extends v> f24906e;

    /* renamed from: f  reason: collision with root package name */
    static volatile j<? super Callable<v>, ? extends v> f24907f;

    /* renamed from: g  reason: collision with root package name */
    static volatile j<? super v, ? extends v> f24908g;

    /* renamed from: h  reason: collision with root package name */
    static volatile j<? super v, ? extends v> f24909h;

    /* renamed from: i  reason: collision with root package name */
    static volatile j<? super v, ? extends v> f24910i;

    /* renamed from: j  reason: collision with root package name */
    static volatile j<? super h, ? extends h> f24911j;

    /* renamed from: k  reason: collision with root package name */
    static volatile j<? super q, ? extends q> f24912k;

    /* renamed from: l  reason: collision with root package name */
    static volatile j<? super zj.a, ? extends zj.a> f24913l;

    /* renamed from: m  reason: collision with root package name */
    static volatile j<? super m, ? extends m> f24914m;

    /* renamed from: n  reason: collision with root package name */
    static volatile j<? super w, ? extends w> f24915n;

    /* renamed from: o  reason: collision with root package name */
    static volatile j<? super qj.a, ? extends qj.a> f24916o;

    /* renamed from: p  reason: collision with root package name */
    static volatile c<? super h, ? super b, ? extends b> f24917p;

    /* renamed from: q  reason: collision with root package name */
    static volatile c<? super m, ? super n, ? extends n> f24918q;

    /* renamed from: r  reason: collision with root package name */
    static volatile c<? super q, ? super u, ? extends u> f24919r;

    /* renamed from: s  reason: collision with root package name */
    static volatile c<? super w, ? super z, ? extends z> f24920s;

    /* renamed from: t  reason: collision with root package name */
    static volatile c<? super qj.a, ? super d, ? extends d> f24921t;

    /* renamed from: u  reason: collision with root package name */
    static volatile e f24922u;

    /* renamed from: v  reason: collision with root package name */
    static volatile boolean f24923v;

    /* renamed from: w  reason: collision with root package name */
    static volatile boolean f24924w;

    public static <T> b<? super T> A(h<T> hVar, b<? super T> bVar) {
        c<? super h, ? super b, ? extends b> cVar = f24917p;
        if (cVar != null) {
            return (b) a(cVar, hVar, bVar);
        }
        return bVar;
    }

    public static void B(f<? super Throwable> fVar) {
        if (!f24923v) {
            f24902a = fVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void C(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t10, U u10) {
        try {
            return cVar.apply(t10, u10);
        } catch (Throwable th2) {
            throw ExceptionHelper.e(th2);
        }
    }

    static <T, R> R b(j<T, R> jVar, T t10) {
        try {
            return jVar.apply(t10);
        } catch (Throwable th2) {
            throw ExceptionHelper.e(th2);
        }
    }

    static v c(j<? super Callable<v>, ? extends v> jVar, Callable<v> callable) {
        return (v) xj.b.e(b(jVar, callable), "Scheduler Callable result can't be null");
    }

    static v d(Callable<v> callable) {
        try {
            return (v) xj.b.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th2) {
            throw ExceptionHelper.e(th2);
        }
    }

    public static v e(Callable<v> callable) {
        xj.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<v>, ? extends v> jVar = f24904c;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static v f(Callable<v> callable) {
        xj.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<v>, ? extends v> jVar = f24906e;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static v g(Callable<v> callable) {
        xj.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<v>, ? extends v> jVar = f24907f;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static v h(Callable<v> callable) {
        xj.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<v>, ? extends v> jVar = f24905d;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    static boolean i(Throwable th2) {
        if (!(th2 instanceof OnErrorNotImplementedException) && !(th2 instanceof MissingBackpressureException) && !(th2 instanceof IllegalStateException) && !(th2 instanceof NullPointerException) && !(th2 instanceof IllegalArgumentException) && !(th2 instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        return f24924w;
    }

    public static qj.a k(qj.a aVar) {
        j<? super qj.a, ? extends qj.a> jVar = f24916o;
        if (jVar != null) {
            return (qj.a) b(jVar, aVar);
        }
        return aVar;
    }

    public static <T> h<T> l(h<T> hVar) {
        j<? super h, ? extends h> jVar = f24911j;
        if (jVar != null) {
            return (h) b(jVar, hVar);
        }
        return hVar;
    }

    public static <T> m<T> m(m<T> mVar) {
        j<? super m, ? extends m> jVar = f24914m;
        if (jVar != null) {
            return (m) b(jVar, mVar);
        }
        return mVar;
    }

    public static <T> q<T> n(q<T> qVar) {
        j<? super q, ? extends q> jVar = f24912k;
        if (jVar != null) {
            return (q) b(jVar, qVar);
        }
        return qVar;
    }

    public static <T> w<T> o(w<T> wVar) {
        j<? super w, ? extends w> jVar = f24915n;
        if (jVar != null) {
            return (w) b(jVar, wVar);
        }
        return wVar;
    }

    public static <T> zj.a<T> p(zj.a<T> aVar) {
        j<? super zj.a, ? extends zj.a> jVar = f24913l;
        if (jVar != null) {
            return (zj.a) b(jVar, aVar);
        }
        return aVar;
    }

    public static boolean q() {
        e eVar = f24922u;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th2) {
            throw ExceptionHelper.e(th2);
        }
    }

    public static v r(v vVar) {
        j<? super v, ? extends v> jVar = f24908g;
        if (jVar == null) {
            return vVar;
        }
        return (v) b(jVar, vVar);
    }

    public static void s(Throwable th2) {
        f<? super Throwable> fVar = f24902a;
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (fVar != null) {
            try {
                fVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                C(th3);
            }
        }
        th2.printStackTrace();
        C(th2);
    }

    public static v t(v vVar) {
        j<? super v, ? extends v> jVar = f24910i;
        if (jVar == null) {
            return vVar;
        }
        return (v) b(jVar, vVar);
    }

    public static Runnable u(Runnable runnable) {
        xj.b.e(runnable, "run is null");
        j<? super Runnable, ? extends Runnable> jVar = f24903b;
        if (jVar == null) {
            return runnable;
        }
        return (Runnable) b(jVar, runnable);
    }

    public static v v(v vVar) {
        j<? super v, ? extends v> jVar = f24909h;
        if (jVar == null) {
            return vVar;
        }
        return (v) b(jVar, vVar);
    }

    public static d w(qj.a aVar, d dVar) {
        c<? super qj.a, ? super d, ? extends d> cVar = f24921t;
        if (cVar != null) {
            return (d) a(cVar, aVar, dVar);
        }
        return dVar;
    }

    public static <T> n<? super T> x(m<T> mVar, n<? super T> nVar) {
        c<? super m, ? super n, ? extends n> cVar = f24918q;
        if (cVar != null) {
            return (n) a(cVar, mVar, nVar);
        }
        return nVar;
    }

    public static <T> u<? super T> y(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = f24919r;
        if (cVar != null) {
            return (u) a(cVar, qVar, uVar);
        }
        return uVar;
    }

    public static <T> z<? super T> z(w<T> wVar, z<? super T> zVar) {
        c<? super w, ? super z, ? extends z> cVar = f24920s;
        if (cVar != null) {
            return (z) a(cVar, wVar, zVar);
        }
        return zVar;
    }
}

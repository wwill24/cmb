package qj;

import bk.a;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.e;
import io.reactivex.internal.operators.completable.f;
import io.reactivex.internal.operators.flowable.q;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.d;
import io.reactivex.internal.operators.single.h;
import io.reactivex.internal.operators.single.i;
import io.reactivex.internal.operators.single.k;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import vj.c;
import vj.g;
import vj.j;
import xj.b;

public abstract class w<T> implements b0<T> {
    public static <T> w<T> A(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        return a.o(new h(callable));
    }

    public static <T> w<T> C(T t10) {
        b.e(t10, "item is null");
        return a.o(new i(t10));
    }

    private w<T> M(long j10, TimeUnit timeUnit, v vVar, b0<? extends T> b0Var) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return a.o(new SingleTimeout(this, j10, timeUnit, vVar, b0Var));
    }

    public static w<Long> N(long j10, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return a.o(new SingleTimer(j10, timeUnit, vVar));
    }

    private static <T> w<T> Q(h<T> hVar) {
        return a.o(new q(hVar, null));
    }

    public static <T1, T2, T3, R> w<R> R(b0<? extends T1> b0Var, b0<? extends T2> b0Var2, b0<? extends T3> b0Var3, g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        b.e(b0Var, "source1 is null");
        b.e(b0Var2, "source2 is null");
        b.e(b0Var3, "source3 is null");
        return T(xj.a.l(gVar), b0Var, b0Var2, b0Var3);
    }

    public static <T1, T2, R> w<R> S(b0<? extends T1> b0Var, b0<? extends T2> b0Var2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(b0Var, "source1 is null");
        b.e(b0Var2, "source2 is null");
        return T(xj.a.k(cVar), b0Var, b0Var2);
    }

    public static <T, R> w<R> T(j<? super Object[], ? extends R> jVar, b0<? extends T>... b0VarArr) {
        b.e(jVar, "zipper is null");
        b.e(b0VarArr, "sources is null");
        if (b0VarArr.length == 0) {
            return t(new NoSuchElementException());
        }
        return a.o(new SingleZipArray(b0VarArr, jVar));
    }

    public static <T> w<T> k(a0<T> a0Var) {
        b.e(a0Var, "source is null");
        return a.o(new SingleCreate(a0Var));
    }

    public static <T> w<T> l(Callable<? extends b0<? extends T>> callable) {
        b.e(callable, "singleSupplier is null");
        return a.o(new io.reactivex.internal.operators.single.a(callable));
    }

    public static <T> w<T> t(Throwable th2) {
        b.e(th2, "exception is null");
        return u(xj.a.f(th2));
    }

    public static <T> w<T> u(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return a.o(new io.reactivex.internal.operators.single.g(callable));
    }

    public final a B() {
        return a.k(new f(this));
    }

    public final <R> w<R> D(j<? super T, ? extends R> jVar) {
        b.e(jVar, "mapper is null");
        return a.o(new io.reactivex.internal.operators.single.j(this, jVar));
    }

    public final w<T> E(v vVar) {
        b.e(vVar, "scheduler is null");
        return a.o(new SingleObserveOn(this, vVar));
    }

    public final w<T> F(j<? super Throwable, ? extends b0<? extends T>> jVar) {
        b.e(jVar, "resumeFunctionInCaseOfError is null");
        return a.o(new SingleResumeNext(this, jVar));
    }

    public final w<T> G(j<Throwable, ? extends T> jVar) {
        b.e(jVar, "resumeFunction is null");
        return a.o(new k(this, jVar, null));
    }

    public final w<T> H(T t10) {
        b.e(t10, "value is null");
        return a.o(new k(this, (j) null, t10));
    }

    public final w<T> I(j<? super h<Throwable>, ? extends rn.a<?>> jVar) {
        return Q(O().j0(jVar));
    }

    /* access modifiers changed from: protected */
    public abstract void J(z<? super T> zVar);

    public final w<T> K(v vVar) {
        b.e(vVar, "scheduler is null");
        return a.o(new SingleSubscribeOn(this, vVar));
    }

    public final w<T> L(long j10, TimeUnit timeUnit) {
        return M(j10, timeUnit, dk.a.a(), (b0) null);
    }

    public final h<T> O() {
        if (this instanceof yj.b) {
            return ((yj.b) this).i();
        }
        return a.l(new SingleToFlowable(this));
    }

    public final q<T> P() {
        if (this instanceof yj.c) {
            return ((yj.c) this).h();
        }
        return a.n(new SingleToObservable(this));
    }

    public final <U, R> w<R> U(b0<U> b0Var, c<? super T, ? super U, ? extends R> cVar) {
        return S(this, b0Var, cVar);
    }

    public final tj.b b(vj.f<? super T> fVar, vj.f<? super Throwable> fVar2) {
        b.e(fVar, "onSuccess is null");
        b.e(fVar2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(fVar, fVar2);
        f(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final tj.b c(vj.f<? super T> fVar) {
        return b(fVar, xj.a.f33969f);
    }

    public final tj.b d() {
        return b(xj.a.d(), xj.a.f33969f);
    }

    public final tj.b e(vj.b<? super T, ? super Throwable> bVar) {
        b.e(bVar, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(bVar);
        f(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final void f(z<? super T> zVar) {
        b.e(zVar, "observer is null");
        z<? super Object> z10 = a.z(this, zVar);
        b.e(z10, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            J(z10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            uj.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final <R> R g(x<T, ? extends R> xVar) {
        return ((x) b.e(xVar, "converter is null")).d(this);
    }

    public final T j() {
        e eVar = new e();
        f(eVar);
        return eVar.b();
    }

    public final w<T> m(long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return a.o(new io.reactivex.internal.operators.single.b(this, j10, timeUnit, vVar, z10));
    }

    public final w<T> n(long j10, TimeUnit timeUnit, boolean z10) {
        return m(j10, timeUnit, dk.a.a(), z10);
    }

    public final w<T> o(vj.a aVar) {
        b.e(aVar, "onFinally is null");
        return a.o(new SingleDoFinally(this, aVar));
    }

    public final w<T> p(vj.f<? super Throwable> fVar) {
        b.e(fVar, "onError is null");
        return a.o(new io.reactivex.internal.operators.single.c(this, fVar));
    }

    public final w<T> q(vj.f<? super tj.b> fVar) {
        b.e(fVar, "onSubscribe is null");
        return a.o(new d(this, fVar));
    }

    public final w<T> r(vj.f<? super T> fVar) {
        b.e(fVar, "onSuccess is null");
        return a.o(new io.reactivex.internal.operators.single.e(this, fVar));
    }

    public final w<T> s(vj.a aVar) {
        b.e(aVar, "onTerminate is null");
        return a.o(new io.reactivex.internal.operators.single.f(this, aVar));
    }

    public final <R> w<R> v(j<? super T, ? extends b0<? extends R>> jVar) {
        b.e(jVar, "mapper is null");
        return a.o(new SingleFlatMap(this, jVar));
    }

    public final a w(j<? super T, ? extends f> jVar) {
        b.e(jVar, "mapper is null");
        return a.k(new SingleFlatMapCompletable(this, jVar));
    }

    public final <R> q<R> x(j<? super T, ? extends s<? extends R>> jVar) {
        b.e(jVar, "mapper is null");
        return a.n(new SingleFlatMapObservable(this, jVar));
    }

    public final <R> h<R> y(j<? super T, ? extends rn.a<? extends R>> jVar) {
        b.e(jVar, "mapper is null");
        return a.l(new SingleFlatMapPublisher(this, jVar));
    }

    public final <U> h<U> z(j<? super T, ? extends Iterable<? extends U>> jVar) {
        b.e(jVar, "mapper is null");
        return a.l(new SingleFlatMapIterableFlowable(this, jVar));
    }
}

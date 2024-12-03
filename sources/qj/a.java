package qj;

import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.b;
import io.reactivex.internal.operators.completable.c;
import io.reactivex.internal.operators.completable.d;
import io.reactivex.internal.operators.completable.e;
import io.reactivex.internal.operators.completable.h;
import io.reactivex.internal.operators.completable.i;
import io.reactivex.internal.operators.completable.j;
import io.reactivex.internal.operators.completable.k;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import java.util.concurrent.Callable;
import vj.f;
import vj.l;

public abstract class a implements f {
    private static NullPointerException H(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    public static a m() {
        return bk.a.k(b.f30113a);
    }

    public static a n(e eVar) {
        xj.b.e(eVar, "source is null");
        return bk.a.k(new CompletableCreate(eVar));
    }

    public static a o(Callable<? extends f> callable) {
        xj.b.e(callable, "completableSupplier");
        return bk.a.k(new io.reactivex.internal.operators.completable.a(callable));
    }

    private a s(f<? super tj.b> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2, vj.a aVar3, vj.a aVar4) {
        xj.b.e(fVar, "onSubscribe is null");
        xj.b.e(fVar2, "onError is null");
        xj.b.e(aVar, "onComplete is null");
        xj.b.e(aVar2, "onTerminate is null");
        xj.b.e(aVar3, "onAfterTerminate is null");
        xj.b.e(aVar4, "onDispose is null");
        return bk.a.k(new j(this, fVar, fVar2, aVar, aVar2, aVar3, aVar4));
    }

    public static a v(Throwable th2) {
        xj.b.e(th2, "error is null");
        return bk.a.k(new c(th2));
    }

    public static a w(vj.a aVar) {
        xj.b.e(aVar, "run is null");
        return bk.a.k(new d(aVar));
    }

    public static <T> a x(rn.a<T> aVar) {
        xj.b.e(aVar, "publisher is null");
        return bk.a.k(new e(aVar));
    }

    public static a y(Iterable<? extends f> iterable) {
        xj.b.e(iterable, "sources is null");
        return bk.a.k(new h(iterable));
    }

    public final a A() {
        return B(xj.a.b());
    }

    public final a B(l<? super Throwable> lVar) {
        xj.b.e(lVar, "predicate is null");
        return bk.a.k(new i(this, lVar));
    }

    public final a C(vj.j<? super Throwable, ? extends f> jVar) {
        xj.b.e(jVar, "errorMapper is null");
        return bk.a.k(new CompletableResumeNext(this, jVar));
    }

    public final a D(vj.j<? super h<Throwable>, ? extends rn.a<?>> jVar) {
        return x(G().j0(jVar));
    }

    /* access modifiers changed from: protected */
    public abstract void E(d dVar);

    public final a F(v vVar) {
        xj.b.e(vVar, "scheduler is null");
        return bk.a.k(new CompletableSubscribeOn(this, vVar));
    }

    public final <T> h<T> G() {
        if (this instanceof yj.b) {
            return ((yj.b) this).i();
        }
        return bk.a.l(new k(this));
    }

    public final <T> w<T> I(Callable<? extends T> callable) {
        xj.b.e(callable, "completionValueSupplier is null");
        return bk.a.o(new io.reactivex.internal.operators.completable.l(this, callable, null));
    }

    public final <T> w<T> J(T t10) {
        xj.b.e(t10, "completionValue is null");
        return bk.a.o(new io.reactivex.internal.operators.completable.l(this, (Callable) null, t10));
    }

    public final a b(f fVar) {
        xj.b.e(fVar, "next is null");
        return bk.a.k(new CompletableAndThenCompletable(this, fVar));
    }

    public final <T> w<T> c(b0<T> b0Var) {
        xj.b.e(b0Var, "next is null");
        return bk.a.o(new SingleDelayWithCompletable(b0Var, this));
    }

    public final tj.b d() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        e(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final void e(d dVar) {
        xj.b.e(dVar, "observer is null");
        try {
            d w10 = bk.a.w(this, dVar);
            xj.b.e(w10, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            E(w10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            uj.a.b(th2);
            bk.a.s(th2);
            throw H(th2);
        }
    }

    public final tj.b f(vj.a aVar, f<? super Throwable> fVar) {
        xj.b.e(fVar, "onError is null");
        xj.b.e(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(fVar, aVar);
        e(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final tj.b g(vj.a aVar) {
        xj.b.e(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(aVar);
        e(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final <R> R j(b<? extends R> bVar) {
        return ((b) xj.b.e(bVar, "converter is null")).b(this);
    }

    public final void k() {
        io.reactivex.internal.observers.e eVar = new io.reactivex.internal.observers.e();
        e(eVar);
        eVar.b();
    }

    public final Throwable l() {
        io.reactivex.internal.observers.e eVar = new io.reactivex.internal.observers.e();
        e(eVar);
        return eVar.c();
    }

    public final a p(vj.a aVar) {
        xj.b.e(aVar, "onFinally is null");
        return bk.a.k(new CompletableDoFinally(this, aVar));
    }

    public final a q(vj.a aVar) {
        f d10 = xj.a.d();
        f d11 = xj.a.d();
        vj.a aVar2 = xj.a.f33966c;
        return s(d10, d11, aVar, aVar2, aVar2, aVar2);
    }

    public final a r(f<? super Throwable> fVar) {
        f d10 = xj.a.d();
        vj.a aVar = xj.a.f33966c;
        return s(d10, fVar, aVar, aVar, aVar, aVar);
    }

    public final a t(f<? super tj.b> fVar) {
        f d10 = xj.a.d();
        vj.a aVar = xj.a.f33966c;
        return s(fVar, d10, aVar, aVar, aVar, aVar);
    }

    public final a u(vj.a aVar) {
        f d10 = xj.a.d();
        f d11 = xj.a.d();
        vj.a aVar2 = xj.a.f33966c;
        return s(d10, d11, aVar2, aVar, aVar2, aVar2);
    }

    public final a z(v vVar) {
        xj.b.e(vVar, "scheduler is null");
        return bk.a.k(new CompletableObserveOn(this, vVar));
    }
}

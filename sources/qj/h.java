package qj;

import com.google.android.gms.common.api.a;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.d;
import io.reactivex.internal.operators.flowable.e;
import io.reactivex.internal.operators.flowable.g;
import io.reactivex.internal.operators.flowable.k;
import io.reactivex.internal.operators.flowable.m;
import io.reactivex.internal.operators.flowable.n;
import io.reactivex.internal.operators.flowable.o;
import io.reactivex.internal.operators.flowable.p;
import io.reactivex.internal.operators.flowable.r;
import io.reactivex.internal.operators.flowable.s;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import rn.a;
import vj.c;
import vj.f;
import vj.i;
import vj.j;
import vj.l;
import xj.b;

public abstract class h<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f33778a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static <T> h<T> G() {
        return bk.a.l(g.f30269b);
    }

    public static <T> h<T> H(Throwable th2) {
        b.e(th2, "throwable is null");
        return I(xj.a.f(th2));
    }

    public static <T> h<T> I(Callable<? extends Throwable> callable) {
        b.e(callable, "supplier is null");
        return bk.a.l(new io.reactivex.internal.operators.flowable.h(callable));
    }

    public static <T> h<T> U(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        return bk.a.l(new FlowableFromIterable(iterable));
    }

    public static <T> h<T> V(a<? extends T> aVar) {
        if (aVar instanceof h) {
            return bk.a.l((h) aVar);
        }
        b.e(aVar, "source is null");
        return bk.a.l(new k(aVar));
    }

    public static <T> h<T> X(T t10) {
        b.e(t10, "item is null");
        return bk.a.l(new n(t10));
    }

    public static <T> h<T> Z(Iterable<? extends a<? extends T>> iterable) {
        return U(iterable).M(xj.a.e());
    }

    public static h<Integer> i0(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return G();
        } else {
            if (i11 == 1) {
                return X(Integer.valueOf(i10));
            }
            if (((long) i10) + ((long) (i11 - 1)) <= 2147483647L) {
                return bk.a.l(new FlowableRange(i10, i11));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static int j() {
        return f33778a;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h<R> k(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, a<? extends T5> aVar5, a<? extends T6> aVar6, a<? extends T7> aVar7, a<? extends T8> aVar8, a<? extends T9> aVar9, i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> iVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        b.e(aVar3, "source3 is null");
        b.e(aVar4, "source4 is null");
        b.e(aVar5, "source5 is null");
        b.e(aVar6, "source6 is null");
        b.e(aVar7, "source7 is null");
        b.e(aVar8, "source8 is null");
        b.e(aVar9, "source9 is null");
        return o(xj.a.n(iVar), aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static <T1, T2, T3, T4, R> h<R> l(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, a<? extends T4> aVar4, vj.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        b.e(aVar3, "source3 is null");
        b.e(aVar4, "source4 is null");
        return o(xj.a.m(hVar), aVar, aVar2, aVar3, aVar4);
    }

    public static <T1, T2, T3, R> h<R> m(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, vj.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        b.e(aVar3, "source3 is null");
        return o(xj.a.l(gVar), aVar, aVar2, aVar3);
    }

    public static <T1, T2, R> h<R> n(a<? extends T1> aVar, a<? extends T2> aVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        return o(xj.a.k(cVar), aVar, aVar2);
    }

    public static <T, R> h<R> o(j<? super Object[], ? extends R> jVar, a<? extends T>... aVarArr) {
        return p(aVarArr, jVar, j());
    }

    public static <T, R> h<R> p(a<? extends T>[] aVarArr, j<? super Object[], ? extends R> jVar, int i10) {
        b.e(aVarArr, "sources is null");
        if (aVarArr.length == 0) {
            return G();
        }
        b.e(jVar, "combiner is null");
        b.f(i10, "bufferSize");
        return bk.a.l(new FlowableCombineLatest(aVarArr, jVar, i10, false));
    }

    public static <T> h<T> q(a<? extends T> aVar, a<? extends T> aVar2) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        return r(aVar, aVar2);
    }

    public static h<Long> q0(long j10, TimeUnit timeUnit) {
        return r0(j10, timeUnit, dk.a.a());
    }

    public static <T> h<T> r(a<? extends T>... aVarArr) {
        if (aVarArr.length == 0) {
            return G();
        }
        if (aVarArr.length == 1) {
            return V(aVarArr[0]);
        }
        return bk.a.l(new FlowableConcatArray(aVarArr, false));
    }

    public static h<Long> r0(long j10, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.l(new FlowableTimer(Math.max(0, j10), timeUnit, vVar));
    }

    public static <T> h<T> s(k<T> kVar, BackpressureStrategy backpressureStrategy) {
        b.e(kVar, "source is null");
        b.e(backpressureStrategy, "mode is null");
        return bk.a.l(new FlowableCreate(kVar, backpressureStrategy));
    }

    public static <T1, T2, T3, R> h<R> w0(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, vj.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        b.e(aVar3, "source3 is null");
        return y0(xj.a.l(gVar), false, j(), aVar, aVar2, aVar3);
    }

    public static <T1, T2, R> h<R> x0(a<? extends T1> aVar, a<? extends T2> aVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        return y0(xj.a.k(cVar), false, j(), aVar, aVar2);
    }

    public static <T, R> h<R> y0(j<? super Object[], ? extends R> jVar, boolean z10, int i10, a<? extends T>... aVarArr) {
        if (aVarArr.length == 0) {
            return G();
        }
        b.e(jVar, "zipper is null");
        b.f(i10, "bufferSize");
        return bk.a.l(new FlowableZip(aVarArr, (Iterable) null, jVar, i10, z10));
    }

    private h<T> z(f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        return bk.a.l(new d(this, fVar, fVar2, aVar, aVar2));
    }

    public final h<T> A(f<? super Throwable> fVar) {
        f d10 = xj.a.d();
        vj.a aVar = xj.a.f33966c;
        return z(d10, fVar, aVar, aVar);
    }

    public final h<T> B(f<? super rn.c> fVar, vj.k kVar, vj.a aVar) {
        b.e(fVar, "onSubscribe is null");
        b.e(kVar, "onRequest is null");
        b.e(aVar, "onCancel is null");
        return bk.a.l(new e(this, fVar, kVar, aVar));
    }

    public final h<T> C(f<? super T> fVar) {
        f d10 = xj.a.d();
        vj.a aVar = xj.a.f33966c;
        return z(fVar, d10, aVar, aVar);
    }

    public final h<T> D(f<? super rn.c> fVar) {
        return B(fVar, xj.a.f33970g, xj.a.f33966c);
    }

    public final w<T> E(long j10, T t10) {
        if (j10 >= 0) {
            b.e(t10, "defaultItem is null");
            return bk.a.o(new io.reactivex.internal.operators.flowable.f(this, j10, t10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final w<T> F(long j10) {
        if (j10 >= 0) {
            return bk.a.o(new io.reactivex.internal.operators.flowable.f(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final h<T> J(l<? super T> lVar) {
        b.e(lVar, "predicate is null");
        return bk.a.l(new io.reactivex.internal.operators.flowable.i(this, lVar));
    }

    public final w<T> K(T t10) {
        return E(0, t10);
    }

    public final w<T> L() {
        return F(0);
    }

    public final <R> h<R> M(j<? super T, ? extends a<? extends R>> jVar) {
        return N(jVar, false, j(), j());
    }

    public final <R> h<R> N(j<? super T, ? extends a<? extends R>> jVar, boolean z10, int i10, int i11) {
        b.e(jVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        b.f(i11, "bufferSize");
        if (!(this instanceof yj.g)) {
            return bk.a.l(new FlowableFlatMap(this, jVar, z10, i10, i11));
        }
        Object call = ((yj.g) this).call();
        if (call == null) {
            return G();
        }
        return p.a(call, jVar);
    }

    public final a O(j<? super T, ? extends f> jVar) {
        return P(jVar, false, a.e.API_PRIORITY_OTHER);
    }

    public final a P(j<? super T, ? extends f> jVar, boolean z10, int i10) {
        b.e(jVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        return bk.a.k(new FlowableFlatMapCompletableCompletable(this, jVar, z10, i10));
    }

    public final <R> h<R> Q(j<? super T, ? extends o<? extends R>> jVar) {
        return R(jVar, false, a.e.API_PRIORITY_OTHER);
    }

    public final <R> h<R> R(j<? super T, ? extends o<? extends R>> jVar, boolean z10, int i10) {
        b.e(jVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        return bk.a.l(new FlowableFlatMapMaybe(this, jVar, z10, i10));
    }

    public final <R> h<R> S(j<? super T, ? extends b0<? extends R>> jVar) {
        return T(jVar, false, a.e.API_PRIORITY_OTHER);
    }

    public final <R> h<R> T(j<? super T, ? extends b0<? extends R>> jVar, boolean z10, int i10) {
        b.e(jVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        return bk.a.l(new FlowableFlatMapSingle(this, jVar, z10, i10));
    }

    public final a W() {
        return bk.a.k(new m(this));
    }

    public final <R> h<R> Y(j<? super T, ? extends R> jVar) {
        b.e(jVar, "mapper is null");
        return bk.a.l(new o(this, jVar));
    }

    public final void a(rn.b<? super T> bVar) {
        if (bVar instanceof l) {
            m0((l) bVar);
            return;
        }
        b.e(bVar, "s is null");
        m0(new StrictSubscriber(bVar));
    }

    public final h<T> a0(v vVar) {
        return b0(vVar, false, j());
    }

    public final tj.b b(f<? super T> fVar, f<? super Throwable> fVar2) {
        return l0(fVar, fVar2, xj.a.f33966c, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public final h<T> b0(v vVar, boolean z10, int i10) {
        b.e(vVar, "scheduler is null");
        b.f(i10, "bufferSize");
        return bk.a.l(new FlowableObserveOn(this, vVar, z10, i10));
    }

    public final tj.b c(f<? super T> fVar) {
        return l0(fVar, xj.a.f33969f, xj.a.f33966c, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public final h<T> c0() {
        return d0(j(), false, true);
    }

    public final h<T> d0(int i10, boolean z10, boolean z11) {
        b.f(i10, "capacity");
        return bk.a.l(new FlowableOnBackpressureBuffer(this, i10, z11, z10, xj.a.f33966c));
    }

    public final h<T> e0() {
        return bk.a.l(new FlowableOnBackpressureDrop(this));
    }

    public final h<T> f0() {
        return bk.a.l(new FlowableOnBackpressureLatest(this));
    }

    public final <R> R g(i<T, ? extends R> iVar) {
        return ((i) b.e(iVar, "converter is null")).c(this);
    }

    public final h<T> g0(j<? super Throwable, ? extends rn.a<? extends T>> jVar) {
        b.e(jVar, "resumeFunction is null");
        return bk.a.l(new FlowableOnErrorNext(this, jVar, false));
    }

    public final T h() {
        io.reactivex.internal.subscribers.d dVar = new io.reactivex.internal.subscribers.d();
        m0(dVar);
        T a10 = dVar.a();
        if (a10 != null) {
            return a10;
        }
        throw new NoSuchElementException();
    }

    public final h<T> h0(j<? super Throwable, ? extends T> jVar) {
        b.e(jVar, "valueSupplier is null");
        return bk.a.l(new FlowableOnErrorReturn(this, jVar));
    }

    public final T i(T t10) {
        io.reactivex.internal.subscribers.d dVar = new io.reactivex.internal.subscribers.d();
        m0(dVar);
        T a10 = dVar.a();
        if (a10 != null) {
            return a10;
        }
        return t10;
    }

    public final h<T> j0(j<? super h<Throwable>, ? extends rn.a<?>> jVar) {
        b.e(jVar, "handler is null");
        return bk.a.l(new FlowableRetryWhen(this, jVar));
    }

    public final h<T> k0(long j10) {
        if (j10 <= 0) {
            return bk.a.l(this);
        }
        return bk.a.l(new r(this, j10));
    }

    public final tj.b l0(f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, f<? super rn.c> fVar3) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(fVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(fVar, fVar2, aVar, fVar3);
        m0(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void m0(l<? super T> lVar) {
        b.e(lVar, "s is null");
        try {
            rn.b<? super Object> A = bk.a.A(this, lVar);
            b.e(A, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            n0(A);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            uj.a.b(th2);
            bk.a.s(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void n0(rn.b<? super T> bVar);

    public final h<T> o0(v vVar) {
        b.e(vVar, "scheduler is null");
        return p0(vVar, !(this instanceof FlowableCreate));
    }

    public final h<T> p0(v vVar, boolean z10) {
        b.e(vVar, "scheduler is null");
        return bk.a.l(new FlowableSubscribeOn(this, vVar, z10));
    }

    public final w<List<T>> s0() {
        return bk.a.o(new s(this));
    }

    public final h<T> t(long j10, TimeUnit timeUnit) {
        return u(j10, timeUnit, dk.a.a(), false);
    }

    public final q<T> t0() {
        return bk.a.n(new io.reactivex.internal.operators.observable.n(this));
    }

    public final h<T> u(long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.l(new io.reactivex.internal.operators.flowable.b(this, Math.max(0, j10), timeUnit, vVar, z10));
    }

    public final w<List<T>> u0(Comparator<? super T> comparator) {
        b.e(comparator, "comparator is null");
        return s0().D(xj.a.g(comparator));
    }

    public final h<T> v() {
        return x(xj.a.e());
    }

    public final h<T> v0(v vVar) {
        b.e(vVar, "scheduler is null");
        return bk.a.l(new FlowableUnsubscribeOn(this, vVar));
    }

    public final h<T> w(vj.d<? super T, ? super T> dVar) {
        b.e(dVar, "comparer is null");
        return bk.a.l(new io.reactivex.internal.operators.flowable.c(this, xj.a.e(), dVar));
    }

    public final <K> h<T> x(j<? super T, K> jVar) {
        b.e(jVar, "keySelector is null");
        return bk.a.l(new io.reactivex.internal.operators.flowable.c(this, jVar, b.d()));
    }

    public final h<T> y(f<? super p<T>> fVar) {
        b.e(fVar, "onNotification is null");
        return z(xj.a.j(fVar), xj.a.i(fVar), xj.a.h(fVar), xj.a.f33966c);
    }

    public final <U, R> h<R> z0(rn.a<? extends U> aVar, c<? super T, ? super U, ? extends R> cVar) {
        b.e(aVar, "other is null");
        return x0(this, aVar, cVar);
    }
}

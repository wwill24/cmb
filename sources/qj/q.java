package qj;

import com.google.android.gms.common.api.a;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.a0;
import io.reactivex.internal.operators.observable.b0;
import io.reactivex.internal.operators.observable.d;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.g;
import io.reactivex.internal.operators.observable.h;
import io.reactivex.internal.operators.observable.i;
import io.reactivex.internal.operators.observable.k;
import io.reactivex.internal.operators.observable.l;
import io.reactivex.internal.operators.observable.m;
import io.reactivex.internal.operators.observable.o;
import io.reactivex.internal.operators.observable.p;
import io.reactivex.internal.operators.observable.r;
import io.reactivex.internal.operators.observable.s;
import io.reactivex.internal.operators.observable.t;
import io.reactivex.internal.operators.observable.u;
import io.reactivex.internal.operators.observable.v;
import io.reactivex.internal.operators.observable.x;
import io.reactivex.internal.operators.observable.y;
import io.reactivex.internal.operators.observable.z;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import vj.c;
import vj.f;
import vj.j;
import xj.b;

public abstract class q<T> implements s<T> {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33781a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33781a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33781a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33781a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33781a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: qj.q.a.<clinit>():void");
        }
    }

    public static <T> q<T> A(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return bk.a.n(new h(callable));
    }

    public static <T> q<T> M(T... tArr) {
        b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return y();
        }
        if (tArr.length == 1) {
            return V(tArr[0]);
        }
        return bk.a.n(new k(tArr));
    }

    public static <T> q<T> N(Callable<? extends T> callable) {
        b.e(callable, "supplier is null");
        return bk.a.n(new l(callable));
    }

    public static <T> q<T> O(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        return bk.a.n(new m(iterable));
    }

    public static q<Long> R(long j10, long j11, TimeUnit timeUnit) {
        return S(j10, j11, timeUnit, dk.a.a());
    }

    public static q<Long> S(long j10, long j11, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableInterval(Math.max(0, j10), Math.max(0, j11), timeUnit, vVar));
    }

    public static q<Long> T(long j10, TimeUnit timeUnit) {
        return S(j10, j10, timeUnit, dk.a.a());
    }

    public static q<Long> U(long j10, TimeUnit timeUnit, v vVar) {
        return S(j10, j10, timeUnit, vVar);
    }

    public static <T> q<T> V(T t10) {
        b.e(t10, "item is null");
        return bk.a.n(new s(t10));
    }

    public static <T> q<T> Y(s<? extends T> sVar, s<? extends T> sVar2) {
        b.e(sVar, "source1 is null");
        b.e(sVar2, "source2 is null");
        return M(sVar, sVar2).F(xj.a.e(), false, 2);
    }

    public static int j() {
        return h.j();
    }

    public static <T, R> q<R> k(Iterable<? extends s<? extends T>> iterable, j<? super Object[], ? extends R> jVar) {
        return l(iterable, jVar, j());
    }

    public static <T, R> q<R> l(Iterable<? extends s<? extends T>> iterable, j<? super Object[], ? extends R> jVar, int i10) {
        b.e(iterable, "sources is null");
        b.e(jVar, "combiner is null");
        b.f(i10, "bufferSize");
        return bk.a.n(new ObservableCombineLatest((s<? extends T>[]) null, iterable, jVar, i10 << 1, false));
    }

    public static <T1, T2, R> q<R> m(s<? extends T1> sVar, s<? extends T2> sVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(sVar, "source1 is null");
        b.e(sVar2, "source2 is null");
        return n(xj.a.k(cVar), j(), sVar, sVar2);
    }

    public static <T, R> q<R> n(j<? super Object[], ? extends R> jVar, int i10, s<? extends T>... sVarArr) {
        return o(sVarArr, jVar, i10);
    }

    public static <T, R> q<R> o(s<? extends T>[] sVarArr, j<? super Object[], ? extends R> jVar, int i10) {
        b.e(sVarArr, "sources is null");
        if (sVarArr.length == 0) {
            return y();
        }
        b.e(jVar, "combiner is null");
        b.f(i10, "bufferSize");
        return bk.a.n(new ObservableCombineLatest(sVarArr, (Iterable) null, jVar, i10 << 1, false));
    }

    public static q<Long> t0(long j10, TimeUnit timeUnit) {
        return u0(j10, timeUnit, dk.a.a());
    }

    private q<T> u(f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, vj.a aVar2) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        return bk.a.n(new d(this, fVar, fVar2, aVar, aVar2));
    }

    public static q<Long> u0(long j10, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableTimer(Math.max(j10, 0), timeUnit, vVar));
    }

    public static <T> q<T> y() {
        return bk.a.n(g.f30455a);
    }

    public static <T> q<T> z(Throwable th2) {
        b.e(th2, "exception is null");
        return A(xj.a.f(th2));
    }

    public static <T> q<T> z0(s<T> sVar) {
        b.e(sVar, "source is null");
        if (sVar instanceof q) {
            return bk.a.n((q) sVar);
        }
        return bk.a.n(new o(sVar));
    }

    public final q<T> B(vj.l<? super T> lVar) {
        b.e(lVar, "predicate is null");
        return bk.a.n(new i(this, lVar));
    }

    public final w<T> C() {
        return x(0);
    }

    public final <R> q<R> D(j<? super T, ? extends s<? extends R>> jVar) {
        return E(jVar, false);
    }

    public final <R> q<R> E(j<? super T, ? extends s<? extends R>> jVar, boolean z10) {
        return F(jVar, z10, a.e.API_PRIORITY_OTHER);
    }

    public final <R> q<R> F(j<? super T, ? extends s<? extends R>> jVar, boolean z10, int i10) {
        return G(jVar, z10, i10, j());
    }

    public final <R> q<R> G(j<? super T, ? extends s<? extends R>> jVar, boolean z10, int i10, int i11) {
        b.e(jVar, "mapper is null");
        b.f(i10, "maxConcurrency");
        b.f(i11, "bufferSize");
        if (!(this instanceof yj.g)) {
            return bk.a.n(new ObservableFlatMap(this, jVar, z10, i10, i11));
        }
        Object call = ((yj.g) this).call();
        if (call == null) {
            return y();
        }
        return ObservableScalarXMap.a(call, jVar);
    }

    public final a H(j<? super T, ? extends f> jVar) {
        return I(jVar, false);
    }

    public final a I(j<? super T, ? extends f> jVar, boolean z10) {
        b.e(jVar, "mapper is null");
        return bk.a.k(new ObservableFlatMapCompletableCompletable(this, jVar, z10));
    }

    public final <U> q<U> J(j<? super T, ? extends Iterable<? extends U>> jVar) {
        b.e(jVar, "mapper is null");
        return bk.a.n(new io.reactivex.internal.operators.observable.j(this, jVar));
    }

    public final <R> q<R> K(j<? super T, ? extends b0<? extends R>> jVar) {
        return L(jVar, false);
    }

    public final <R> q<R> L(j<? super T, ? extends b0<? extends R>> jVar, boolean z10) {
        b.e(jVar, "mapper is null");
        return bk.a.n(new ObservableFlatMapSingle(this, jVar, z10));
    }

    public final q<T> P() {
        return bk.a.n(new p(this));
    }

    public final a Q() {
        return bk.a.k(new r(this));
    }

    public final <R> q<R> W(j<? super T, ? extends R> jVar) {
        b.e(jVar, "mapper is null");
        return bk.a.n(new t(this, jVar));
    }

    public final q<p<T>> X() {
        return bk.a.n(new u(this));
    }

    public final q<T> Z(f fVar) {
        b.e(fVar, "other is null");
        return bk.a.n(new ObservableMergeWithCompletable(this, fVar));
    }

    public final q<T> a0(v vVar) {
        return b0(vVar, false, j());
    }

    public final tj.b b(f<? super T> fVar, f<? super Throwable> fVar2) {
        return k0(fVar, fVar2, xj.a.f33966c, xj.a.d());
    }

    public final q<T> b0(v vVar, boolean z10, int i10) {
        b.e(vVar, "scheduler is null");
        b.f(i10, "bufferSize");
        return bk.a.n(new ObservableObserveOn(this, vVar, z10, i10));
    }

    public final tj.b c(f<? super T> fVar) {
        return k0(fVar, xj.a.f33969f, xj.a.f33966c, xj.a.d());
    }

    public final q<T> c0(j<? super Throwable, ? extends T> jVar) {
        b.e(jVar, "valueSupplier is null");
        return bk.a.n(new v(this, jVar));
    }

    public final zj.a<T> d0(int i10) {
        b.f(i10, "bufferSize");
        return ObservableReplay.D0(this, i10);
    }

    public final void e(u<? super T> uVar) {
        b.e(uVar, "observer is null");
        try {
            u<? super Object> y10 = bk.a.y(this, uVar);
            b.e(y10, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            l0(y10);
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

    public final q<T> e0(long j10) {
        return f0(j10, xj.a.b());
    }

    public final q<T> f0(long j10, vj.l<? super Throwable> lVar) {
        if (j10 >= 0) {
            b.e(lVar, "predicate is null");
            return bk.a.n(new ObservableRetryPredicate(this, j10, lVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    public final <R> R g(r<T, ? extends R> rVar) {
        return ((r) b.e(rVar, "converter is null")).a(this);
    }

    public final q<T> g0(j<? super q<Throwable>, ? extends s<?>> jVar) {
        b.e(jVar, "handler is null");
        return bk.a.n(new ObservableRetryWhen(this, jVar));
    }

    public final T h() {
        io.reactivex.internal.observers.d dVar = new io.reactivex.internal.observers.d();
        e(dVar);
        T b10 = dVar.b();
        if (b10 != null) {
            return b10;
        }
        throw new NoSuchElementException();
    }

    public final m<T> h0() {
        return bk.a.m(new x(this));
    }

    public final Iterable<T> i() {
        return new io.reactivex.internal.operators.observable.b(this);
    }

    public final w<T> i0() {
        return bk.a.o(new y(this, null));
    }

    public final q<T> j0(long j10) {
        if (j10 <= 0) {
            return bk.a.n(this);
        }
        return bk.a.n(new z(this, j10));
    }

    public final tj.b k0(f<? super T> fVar, f<? super Throwable> fVar2, vj.a aVar, f<? super tj.b> fVar3) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(fVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(fVar, fVar2, aVar, fVar3);
        e(lambdaObserver);
        return lambdaObserver;
    }

    /* access modifiers changed from: protected */
    public abstract void l0(u<? super T> uVar);

    public final q<T> m0(v vVar) {
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableSubscribeOn(this, vVar));
    }

    public final q<T> n0(long j10) {
        if (j10 >= 0) {
            return bk.a.n(new a0(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    public final q<T> o0(vj.l<? super T> lVar) {
        b.e(lVar, "stopPredicate is null");
        return bk.a.n(new b0(this, lVar));
    }

    public final <R> q<R> p(t<? super T, ? extends R> tVar) {
        return z0(((t) b.e(tVar, "composer is null")).a(this));
    }

    public final q<T> p0(long j10, TimeUnit timeUnit) {
        return q0(j10, timeUnit, dk.a.a());
    }

    public final q<T> q(long j10, TimeUnit timeUnit) {
        return r(j10, timeUnit, dk.a.a());
    }

    public final q<T> q0(long j10, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableThrottleFirstTimed(this, j10, timeUnit, vVar));
    }

    public final q<T> r(long j10, TimeUnit timeUnit, v vVar) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableDebounceTimed(this, j10, timeUnit, vVar));
    }

    public final q<T> r0(long j10, TimeUnit timeUnit) {
        return s0(j10, timeUnit, dk.a.a(), false);
    }

    public final q<T> s() {
        return t(xj.a.e());
    }

    public final q<T> s0(long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        b.e(timeUnit, "unit is null");
        b.e(vVar, "scheduler is null");
        return bk.a.n(new ObservableThrottleLatest(this, j10, timeUnit, vVar, z10));
    }

    public final <K> q<T> t(j<? super T, K> jVar) {
        b.e(jVar, "keySelector is null");
        return bk.a.n(new io.reactivex.internal.operators.observable.c(this, jVar, b.d()));
    }

    public final q<T> v(f<? super T> fVar) {
        f d10 = xj.a.d();
        vj.a aVar = xj.a.f33966c;
        return u(fVar, d10, aVar, aVar);
    }

    public final h<T> v0(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.j jVar = new io.reactivex.internal.operators.flowable.j(this);
        int i10 = a.f33781a[backpressureStrategy.ordinal()];
        if (i10 == 1) {
            return jVar.e0();
        }
        if (i10 == 2) {
            return jVar.f0();
        }
        if (i10 == 3) {
            return jVar;
        }
        if (i10 != 4) {
            return jVar.c0();
        }
        return bk.a.l(new FlowableOnBackpressureError(jVar));
    }

    public final q<T> w(vj.a aVar) {
        b.e(aVar, "onTerminate is null");
        return u(xj.a.d(), xj.a.a(aVar), aVar, xj.a.f33966c);
    }

    public final w<List<T>> w0() {
        return x0(16);
    }

    public final w<T> x(long j10) {
        if (j10 >= 0) {
            return bk.a.o(new io.reactivex.internal.operators.observable.f(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final w<List<T>> x0(int i10) {
        b.f(i10, "capacityHint");
        return bk.a.o(new d0(this, i10));
    }

    public final w<List<T>> y0(Comparator<? super T> comparator) {
        b.e(comparator, "comparator is null");
        return w0().D(xj.a.g(comparator));
    }
}

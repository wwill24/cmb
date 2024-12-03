package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import qj.q;
import qj.s;
import qj.u;
import vj.j;
import xj.b;
import yj.d;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements d<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        final u<? super T> observer;
        final T value;

        public ScalarDisposable(u<? super T> uVar, T t10) {
            this.observer = uVar;
            this.value = t10;
        }

        public int b(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public boolean c() {
            return get() == 3;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.d(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }

    static final class a<T, R> extends q<R> {

        /* renamed from: a  reason: collision with root package name */
        final T f30380a;

        /* renamed from: b  reason: collision with root package name */
        final j<? super T, ? extends s<? extends R>> f30381b;

        a(T t10, j<? super T, ? extends s<? extends R>> jVar) {
            this.f30380a = t10;
            this.f30381b = jVar;
        }

        public void l0(u<? super R> uVar) {
            try {
                s sVar = (s) b.e(this.f30381b.apply(this.f30380a), "The mapper returned a null ObservableSource");
                if (sVar instanceof Callable) {
                    try {
                        Object call = ((Callable) sVar).call();
                        if (call == null) {
                            EmptyDisposable.e(uVar);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(uVar, call);
                        uVar.a(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        EmptyDisposable.i(th2, uVar);
                    }
                } else {
                    sVar.e(uVar);
                }
            } catch (Throwable th3) {
                EmptyDisposable.i(th3, uVar);
            }
        }
    }

    public static <T, U> q<U> a(T t10, j<? super T, ? extends s<? extends U>> jVar) {
        return bk.a.n(new a(t10, jVar));
    }

    public static <T, R> boolean b(s<T> sVar, u<? super R> uVar, j<? super T, ? extends s<? extends R>> jVar) {
        if (!(sVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) sVar).call();
            if (call == null) {
                EmptyDisposable.e(uVar);
                return true;
            }
            try {
                s sVar2 = (s) b.e(jVar.apply(call), "The mapper returned a null ObservableSource");
                if (sVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) sVar2).call();
                        if (call2 == null) {
                            EmptyDisposable.e(uVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(uVar, call2);
                        uVar.a(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        EmptyDisposable.i(th2, uVar);
                        return true;
                    }
                } else {
                    sVar2.e(uVar);
                }
                return true;
            } catch (Throwable th3) {
                uj.a.b(th3);
                EmptyDisposable.i(th3, uVar);
                return true;
            }
        } catch (Throwable th4) {
            uj.a.b(th4);
            EmptyDisposable.i(th4, uVar);
            return true;
        }
    }
}

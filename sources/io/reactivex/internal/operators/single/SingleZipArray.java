package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.b0;
import qj.w;
import qj.z;
import tj.b;
import vj.j;

public final class SingleZipArray<T, R> extends w<R> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T>[] f30544a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super Object[], ? extends R> f30545b;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = -5556924161382950569L;
        final z<? super R> downstream;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final j<? super Object[], ? extends R> zipper;

        ZipCoordinator(z<? super R> zVar, int i10, j<? super Object[], ? extends R> jVar) {
            super(i10);
            this.downstream = zVar;
            this.zipper = jVar;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                zipSingleObserverArr[i11] = new ZipSingleObserver<>(this, i11);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i10];
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i11 = 0; i11 < i10; i11++) {
                zipSingleObserverArr[i11].b();
            }
            while (true) {
                i10++;
                if (i10 < length) {
                    zipSingleObserverArr[i10].b();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th2, int i10) {
            if (getAndSet(0) > 0) {
                a(i10);
                this.downstream.onError(th2);
                return;
            }
            bk.a.s(th2);
        }

        public boolean c() {
            return get() <= 0;
        }

        /* access modifiers changed from: package-private */
        public void d(T t10, int i10) {
            this.values[i10] = t10;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(xj.b.e(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.downstream.onError(th2);
                }
            }
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> b10 : this.observers) {
                    b10.b();
                }
            }
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<b> implements z<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i10) {
            this.parent = zipCoordinator;
            this.index = i10;
        }

        public void a(b bVar) {
            DisposableHelper.i(this, bVar);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th2) {
            this.parent.b(th2, this.index);
        }

        public void onSuccess(T t10) {
            this.parent.d(t10, this.index);
        }
    }

    final class a implements j<T, R> {
        a() {
        }

        public R apply(T t10) throws Exception {
            return xj.b.e(SingleZipArray.this.f30545b.apply(new Object[]{t10}), "The zipper returned a null value");
        }
    }

    public SingleZipArray(b0<? extends T>[] b0VarArr, j<? super Object[], ? extends R> jVar) {
        this.f30544a = b0VarArr;
        this.f30545b = jVar;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super R> zVar) {
        b0<? extends T>[] b0VarArr = this.f30544a;
        int length = b0VarArr.length;
        int i10 = 0;
        if (length == 1) {
            b0VarArr[0].f(new j.a(zVar, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(zVar, length, this.f30545b);
        zVar.a(zipCoordinator);
        while (i10 < length && !zipCoordinator.c()) {
            b0<? extends T> b0Var = b0VarArr[i10];
            if (b0Var == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i10);
                return;
            } else {
                b0Var.f(zipCoordinator.observers[i10]);
                i10++;
            }
        }
    }
}

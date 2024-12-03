package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import qj.b0;
import qj.v;
import qj.w;
import qj.z;

public final class b<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final b0<? extends T> f30548a;

    /* renamed from: b  reason: collision with root package name */
    final long f30549b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30550c;

    /* renamed from: d  reason: collision with root package name */
    final v f30551d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f30552e;

    final class a implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        private final SequentialDisposable f30553a;

        /* renamed from: b  reason: collision with root package name */
        final z<? super T> f30554b;

        /* renamed from: io.reactivex.internal.operators.single.b$a$a  reason: collision with other inner class name */
        final class C0355a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f30556a;

            C0355a(Throwable th2) {
                this.f30556a = th2;
            }

            public void run() {
                a.this.f30554b.onError(this.f30556a);
            }
        }

        /* renamed from: io.reactivex.internal.operators.single.b$a$b  reason: collision with other inner class name */
        final class C0356b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final T f30558a;

            C0356b(T t10) {
                this.f30558a = t10;
            }

            public void run() {
                a.this.f30554b.onSuccess(this.f30558a);
            }
        }

        a(SequentialDisposable sequentialDisposable, z<? super T> zVar) {
            this.f30553a = sequentialDisposable;
            this.f30554b = zVar;
        }

        public void a(tj.b bVar) {
            this.f30553a.a(bVar);
        }

        public void onError(Throwable th2) {
            SequentialDisposable sequentialDisposable = this.f30553a;
            v vVar = b.this.f30551d;
            C0355a aVar = new C0355a(th2);
            b bVar = b.this;
            sequentialDisposable.a(vVar.d(aVar, bVar.f30552e ? bVar.f30549b : 0, bVar.f30550c));
        }

        public void onSuccess(T t10) {
            SequentialDisposable sequentialDisposable = this.f30553a;
            v vVar = b.this.f30551d;
            C0356b bVar = new C0356b(t10);
            b bVar2 = b.this;
            sequentialDisposable.a(vVar.d(bVar, bVar2.f30549b, bVar2.f30550c));
        }
    }

    public b(b0<? extends T> b0Var, long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        this.f30548a = b0Var;
        this.f30549b = j10;
        this.f30550c = timeUnit;
        this.f30551d = vVar;
        this.f30552e = z10;
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        zVar.a(sequentialDisposable);
        this.f30548a.f(new a(sequentialDisposable, zVar));
    }
}

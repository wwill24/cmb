package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import qj.q;
import qj.s;
import qj.u;
import tj.b;
import uj.a;
import vj.l;

public final class ObservableRetryPredicate<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final l<? super Throwable> f30377b;

    /* renamed from: c  reason: collision with root package name */
    final long f30378c;

    static final class RepeatObserver<T> extends AtomicInteger implements u<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final u<? super T> downstream;
        final l<? super Throwable> predicate;
        long remaining;
        final s<? extends T> source;
        final SequentialDisposable upstream;

        RepeatObserver(u<? super T> uVar, long j10, l<? super Throwable> lVar, SequentialDisposable sequentialDisposable, s<? extends T> sVar) {
            this.downstream = uVar;
            this.upstream = sequentialDisposable;
            this.source = sVar;
            this.predicate = lVar;
            this.remaining = j10;
        }

        public void a(b bVar) {
            this.upstream.a(bVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.upstream.c()) {
                    this.source.e(this);
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        public void d(T t10) {
            this.downstream.d(t10);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 == 0) {
                this.downstream.onError(th2);
                return;
            }
            try {
                if (!this.predicate.test(th2)) {
                    this.downstream.onError(th2);
                } else {
                    b();
                }
            } catch (Throwable th3) {
                a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }
    }

    public ObservableRetryPredicate(q<T> qVar, long j10, l<? super Throwable> lVar) {
        super(qVar);
        this.f30377b = lVar;
        this.f30378c = j10;
    }

    public void l0(u<? super T> uVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        uVar.a(sequentialDisposable);
        new RepeatObserver(uVar, this.f30378c, this.f30377b, sequentialDisposable, this.f30395a).b();
    }
}

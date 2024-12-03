package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import qj.p;
import qj.q;
import qj.s;

public final class b<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30401a;

    static final class a<T> extends ak.b<p<T>> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        p<T> f30402b;

        /* renamed from: c  reason: collision with root package name */
        final Semaphore f30403c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<p<T>> f30404d = new AtomicReference<>();

        a() {
        }

        /* renamed from: f */
        public void d(p<T> pVar) {
            boolean z10;
            if (this.f30404d.getAndSet(pVar) == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f30403c.release();
            }
        }

        public boolean hasNext() {
            p<T> pVar = this.f30402b;
            if (pVar == null || !pVar.f()) {
                if (this.f30402b == null) {
                    try {
                        c.a();
                        this.f30403c.acquire();
                        p<T> andSet = this.f30404d.getAndSet((Object) null);
                        this.f30402b = andSet;
                        if (andSet.f()) {
                            throw ExceptionHelper.e(andSet.d());
                        }
                    } catch (InterruptedException e10) {
                        dispose();
                        this.f30402b = p.b(e10);
                        throw ExceptionHelper.e(e10);
                    }
                }
                return this.f30402b.g();
            }
            throw ExceptionHelper.e(this.f30402b.d());
        }

        public T next() {
            if (hasNext()) {
                T e10 = this.f30402b.e();
                this.f30402b = null;
                return e10;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            bk.a.s(th2);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public b(s<T> sVar) {
        this.f30401a = sVar;
    }

    public Iterator<T> iterator() {
        a aVar = new a();
        q.z0(this.f30401a).X().e(aVar);
        return aVar;
    }
}

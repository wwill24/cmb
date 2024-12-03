package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.b;
import java.util.Iterator;
import qj.q;
import qj.u;

public final class m<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T> f30470a;

    static final class a<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30471a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends T> f30472b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f30473c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30474d;

        /* renamed from: e  reason: collision with root package name */
        boolean f30475e;

        /* renamed from: f  reason: collision with root package name */
        boolean f30476f;

        a(u<? super T> uVar, Iterator<? extends T> it) {
            this.f30471a = uVar;
            this.f30472b = it;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (!c()) {
                try {
                    this.f30471a.d(xj.b.e(this.f30472b.next(), "The iterator returned a null value"));
                    if (!c()) {
                        try {
                            if (!this.f30472b.hasNext()) {
                                if (!c()) {
                                    this.f30471a.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            uj.a.b(th2);
                            this.f30471a.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    this.f30471a.onError(th3);
                    return;
                }
            }
        }

        public int b(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f30474d = true;
            return 1;
        }

        public boolean c() {
            return this.f30473c;
        }

        public void clear() {
            this.f30475e = true;
        }

        public void dispose() {
            this.f30473c = true;
        }

        public boolean isEmpty() {
            return this.f30475e;
        }

        public T poll() {
            if (this.f30475e) {
                return null;
            }
            if (!this.f30476f) {
                this.f30476f = true;
            } else if (!this.f30472b.hasNext()) {
                this.f30475e = true;
                return null;
            }
            return xj.b.e(this.f30472b.next(), "The iterator returned a null value");
        }
    }

    public m(Iterable<? extends T> iterable) {
        this.f30470a = iterable;
    }

    public void l0(u<? super T> uVar) {
        try {
            Iterator<? extends T> it = this.f30470a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.e(uVar);
                    return;
                }
                a aVar = new a(uVar, it);
                uVar.a(aVar);
                if (!aVar.f30474d) {
                    aVar.a();
                }
            } catch (Throwable th2) {
                uj.a.b(th2);
                EmptyDisposable.i(th2, uVar);
            }
        } catch (Throwable th3) {
            uj.a.b(th3);
            EmptyDisposable.i(th3, uVar);
        }
    }
}

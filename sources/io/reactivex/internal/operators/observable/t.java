package io.reactivex.internal.operators.observable;

import qj.s;
import qj.u;
import vj.j;
import xj.b;

public final class t<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super T, ? extends U> f30489b;

    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends U> f30490f;

        a(u<? super U> uVar, j<? super T, ? extends U> jVar) {
            super(uVar);
            this.f30490f = jVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (!this.f30085d) {
                if (this.f30086e != 0) {
                    this.f30082a.d(null);
                    return;
                }
                try {
                    this.f30082a.d(b.e(this.f30490f.apply(t10), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    g(th2);
                }
            }
        }

        public U poll() throws Exception {
            T poll = this.f30084c.poll();
            if (poll != null) {
                return b.e(this.f30490f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public t(s<T> sVar, j<? super T, ? extends U> jVar) {
        super(sVar);
        this.f30489b = jVar;
    }

    public void l0(u<? super U> uVar) {
        this.f30395a.e(new a(uVar, this.f30489b));
    }
}

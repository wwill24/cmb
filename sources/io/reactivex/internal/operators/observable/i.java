package io.reactivex.internal.operators.observable;

import qj.s;
import qj.u;
import vj.l;

public final class i<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final l<? super T> f30457b;

    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final l<? super T> f30458f;

        a(u<? super T> uVar, l<? super T> lVar) {
            super(uVar);
            this.f30458f = lVar;
        }

        public int b(int i10) {
            return h(i10);
        }

        public void d(T t10) {
            if (this.f30086e == 0) {
                try {
                    if (this.f30458f.test(t10)) {
                        this.f30082a.d(t10);
                    }
                } catch (Throwable th2) {
                    g(th2);
                }
            } else {
                this.f30082a.d(null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public T poll() throws java.lang.Exception {
            /*
                r2 = this;
            L_0x0000:
                yj.d<T> r0 = r2.f30084c
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                vj.l<? super T> r1 = r2.f30458f
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.i.a.poll():java.lang.Object");
        }
    }

    public i(s<T> sVar, l<? super T> lVar) {
        super(sVar);
        this.f30457b = lVar;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(uVar, this.f30457b));
    }
}

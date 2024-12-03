package io.reactivex.internal.operators.flowable;

import qj.h;
import qj.q;
import qj.u;
import rn.b;
import rn.c;

public final class j<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final q<T> f30274b;

    static final class a<T> implements u<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f30275a;

        /* renamed from: b  reason: collision with root package name */
        tj.b f30276b;

        a(b<? super T> bVar) {
            this.f30275a = bVar;
        }

        public void a(tj.b bVar) {
            this.f30276b = bVar;
            this.f30275a.e(this);
        }

        public void cancel() {
            this.f30276b.dispose();
        }

        public void d(T t10) {
            this.f30275a.d(t10);
        }

        public void onComplete() {
            this.f30275a.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30275a.onError(th2);
        }

        public void r(long j10) {
        }
    }

    public j(q<T> qVar) {
        this.f30274b = qVar;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        this.f30274b.e(new a(bVar));
    }
}

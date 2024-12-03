package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import qj.h;
import qj.l;
import qj.v;

public final class b<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f30215c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f30216d;

    /* renamed from: e  reason: collision with root package name */
    final v f30217e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f30218f;

    static final class a<T> implements l<T>, rn.c {

        /* renamed from: a  reason: collision with root package name */
        final rn.b<? super T> f30219a;

        /* renamed from: b  reason: collision with root package name */
        final long f30220b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f30221c;

        /* renamed from: d  reason: collision with root package name */
        final v.c f30222d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f30223e;

        /* renamed from: f  reason: collision with root package name */
        rn.c f30224f;

        /* renamed from: io.reactivex.internal.operators.flowable.b$a$a  reason: collision with other inner class name */
        final class C0353a implements Runnable {
            C0353a() {
            }

            public void run() {
                try {
                    a.this.f30219a.onComplete();
                } finally {
                    a.this.f30222d.dispose();
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.b$a$b  reason: collision with other inner class name */
        final class C0354b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f30226a;

            C0354b(Throwable th2) {
                this.f30226a = th2;
            }

            public void run() {
                try {
                    a.this.f30219a.onError(this.f30226a);
                } finally {
                    a.this.f30222d.dispose();
                }
            }
        }

        final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final T f30228a;

            c(T t10) {
                this.f30228a = t10;
            }

            public void run() {
                a.this.f30219a.d(this.f30228a);
            }
        }

        a(rn.b<? super T> bVar, long j10, TimeUnit timeUnit, v.c cVar, boolean z10) {
            this.f30219a = bVar;
            this.f30220b = j10;
            this.f30221c = timeUnit;
            this.f30222d = cVar;
            this.f30223e = z10;
        }

        public void cancel() {
            this.f30224f.cancel();
            this.f30222d.dispose();
        }

        public void d(T t10) {
            this.f30222d.d(new c(t10), this.f30220b, this.f30221c);
        }

        public void e(rn.c cVar) {
            if (SubscriptionHelper.k(this.f30224f, cVar)) {
                this.f30224f = cVar;
                this.f30219a.e(this);
            }
        }

        public void onComplete() {
            this.f30222d.d(new C0353a(), this.f30220b, this.f30221c);
        }

        public void onError(Throwable th2) {
            this.f30222d.d(new C0354b(th2), this.f30223e ? this.f30220b : 0, this.f30221c);
        }

        public void r(long j10) {
            this.f30224f.r(j10);
        }
    }

    public b(h<T> hVar, long j10, TimeUnit timeUnit, v vVar, boolean z10) {
        super(hVar);
        this.f30215c = j10;
        this.f30216d = timeUnit;
        this.f30217e = vVar;
        this.f30218f = z10;
    }

    /* access modifiers changed from: protected */
    public void n0(rn.b<? super T> bVar) {
        ek.a aVar;
        if (this.f30218f) {
            aVar = bVar;
        } else {
            aVar = new ek.a(bVar);
        }
        this.f30214b.m0(new a(aVar, this.f30215c, this.f30216d, this.f30217e.b(), this.f30218f));
    }
}

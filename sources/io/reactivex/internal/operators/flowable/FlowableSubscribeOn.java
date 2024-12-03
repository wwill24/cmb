package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import qj.h;
import qj.l;
import qj.v;
import rn.b;
import rn.c;

public final class FlowableSubscribeOn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final v f30199c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30200d;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements l<T>, c, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final b<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();
        rn.a<T> source;
        final AtomicReference<c> upstream = new AtomicReference<>();
        final v.c worker;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final c f30201a;

            /* renamed from: b  reason: collision with root package name */
            final long f30202b;

            a(c cVar, long j10) {
                this.f30201a = cVar;
                this.f30202b = j10;
            }

            public void run() {
                this.f30201a.r(this.f30202b);
            }
        }

        SubscribeOnSubscriber(b<? super T> bVar, v.c cVar, rn.a<T> aVar, boolean z10) {
            this.downstream = bVar;
            this.worker = cVar;
            this.source = aVar;
            this.nonScheduledRequests = !z10;
        }

        /* access modifiers changed from: package-private */
        public void a(long j10, c cVar) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                cVar.r(j10);
            } else {
                this.worker.b(new a(cVar, j10));
            }
        }

        public void cancel() {
            SubscriptionHelper.a(this.upstream);
            this.worker.dispose();
        }

        public void d(T t10) {
            this.downstream.d(t10);
        }

        public void e(c cVar) {
            if (SubscriptionHelper.h(this.upstream, cVar)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, cVar);
                }
            }
        }

        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                c cVar = this.upstream.get();
                if (cVar != null) {
                    a(j10, cVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.requested, j10);
                c cVar2 = this.upstream.get();
                if (cVar2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, cVar2);
                    }
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            rn.a<T> aVar = this.source;
            this.source = null;
            aVar.a(this);
        }
    }

    public FlowableSubscribeOn(h<T> hVar, v vVar, boolean z10) {
        super(hVar);
        this.f30199c = vVar;
        this.f30200d = z10;
    }

    public void n0(b<? super T> bVar) {
        v.c b10 = this.f30199c.b();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(bVar, b10, this.f30214b, this.f30200d);
        bVar.e(subscribeOnSubscriber);
        b10.b(subscribeOnSubscriber);
    }
}

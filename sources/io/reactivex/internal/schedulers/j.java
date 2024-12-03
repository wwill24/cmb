package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import qj.v;

public final class j extends v {

    /* renamed from: c  reason: collision with root package name */
    private static final j f30678c = new j();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f30679a;

        /* renamed from: b  reason: collision with root package name */
        private final c f30680b;

        /* renamed from: c  reason: collision with root package name */
        private final long f30681c;

        a(Runnable runnable, c cVar, long j10) {
            this.f30679a = runnable;
            this.f30680b = cVar;
            this.f30681c = j10;
        }

        public void run() {
            if (!this.f30680b.f30689d) {
                long a10 = this.f30680b.a(TimeUnit.MILLISECONDS);
                long j10 = this.f30681c;
                if (j10 > a10) {
                    try {
                        Thread.sleep(j10 - a10);
                    } catch (InterruptedException e10) {
                        Thread.currentThread().interrupt();
                        bk.a.s(e10);
                        return;
                    }
                }
                if (!this.f30680b.f30689d) {
                    this.f30679a.run();
                }
            }
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f30682a;

        /* renamed from: b  reason: collision with root package name */
        final long f30683b;

        /* renamed from: c  reason: collision with root package name */
        final int f30684c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f30685d;

        b(Runnable runnable, Long l10, int i10) {
            this.f30682a = runnable;
            this.f30683b = l10.longValue();
            this.f30684c = i10;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int b10 = xj.b.b(this.f30683b, bVar.f30683b);
            if (b10 == 0) {
                return xj.b.a(this.f30684c, bVar.f30684c);
            }
            return b10;
        }
    }

    static final class c extends v.c {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f30686a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f30687b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f30688c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f30689d;

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f30690a;

            a(b bVar) {
                this.f30690a = bVar;
            }

            public void run() {
                this.f30690a.f30685d = true;
                c.this.f30686a.remove(this.f30690a);
            }
        }

        c() {
        }

        public tj.b b(Runnable runnable) {
            return f(runnable, a(TimeUnit.MILLISECONDS));
        }

        public boolean c() {
            return this.f30689d;
        }

        public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            long a10 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return f(new a(runnable, this, a10), a10);
        }

        public void dispose() {
            this.f30689d = true;
        }

        /* access modifiers changed from: package-private */
        public tj.b f(Runnable runnable, long j10) {
            if (this.f30689d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f30688c.incrementAndGet());
            this.f30686a.add(bVar);
            if (this.f30687b.getAndIncrement() != 0) {
                return io.reactivex.disposables.a.d(new a(bVar));
            }
            int i10 = 1;
            while (!this.f30689d) {
                b poll = this.f30686a.poll();
                if (poll == null) {
                    i10 = this.f30687b.addAndGet(-i10);
                    if (i10 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f30685d) {
                    poll.f30682a.run();
                }
            }
            this.f30686a.clear();
            return EmptyDisposable.INSTANCE;
        }
    }

    j() {
    }

    public static j f() {
        return f30678c;
    }

    public v.c b() {
        return new c();
    }

    public tj.b c(Runnable runnable) {
        bk.a.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            bk.a.u(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            bk.a.s(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}

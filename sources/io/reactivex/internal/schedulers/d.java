package io.reactivex.internal.schedulers;

import androidx.camera.view.h;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.v;

public final class d extends v {

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f30643e;

    /* renamed from: f  reason: collision with root package name */
    static final RxThreadFactory f30644f;

    /* renamed from: g  reason: collision with root package name */
    private static final long f30645g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: h  reason: collision with root package name */
    private static final TimeUnit f30646h = TimeUnit.SECONDS;

    /* renamed from: i  reason: collision with root package name */
    static final c f30647i;

    /* renamed from: j  reason: collision with root package name */
    static boolean f30648j = Boolean.getBoolean("rx2.io-scheduled-release");

    /* renamed from: k  reason: collision with root package name */
    static final a f30649k;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f30650c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<a> f30651d;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f30652a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f30653b;

        /* renamed from: c  reason: collision with root package name */
        final tj.a f30654c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f30655d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f30656e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f30657f;

        a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j11;
            ScheduledFuture<?> scheduledFuture;
            if (timeUnit != null) {
                j11 = timeUnit.toNanos(j10);
            } else {
                j11 = 0;
            }
            long j12 = j11;
            this.f30652a = j12;
            this.f30653b = new ConcurrentLinkedQueue<>();
            this.f30654c = new tj.a();
            this.f30657f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.f30644f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j12, j12, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f30655d = scheduledExecutorService;
            this.f30656e = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f30653b.isEmpty()) {
                long c10 = c();
                Iterator<c> it = this.f30653b.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.j() > c10) {
                        return;
                    }
                    if (this.f30653b.remove(next)) {
                        this.f30654c.d(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public c b() {
            if (this.f30654c.c()) {
                return d.f30647i;
            }
            while (!this.f30653b.isEmpty()) {
                c poll = this.f30653b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f30657f);
            this.f30654c.a(cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public void d(c cVar) {
            cVar.k(c() + this.f30652a);
            this.f30653b.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f30654c.dispose();
            Future<?> future = this.f30656e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f30655d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a();
        }
    }

    static final class b extends v.c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final tj.a f30658a;

        /* renamed from: b  reason: collision with root package name */
        private final a f30659b;

        /* renamed from: c  reason: collision with root package name */
        private final c f30660c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f30661d = new AtomicBoolean();

        b(a aVar) {
            this.f30659b = aVar;
            this.f30658a = new tj.a();
            this.f30660c = aVar.b();
        }

        public boolean c() {
            return this.f30661d.get();
        }

        public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f30658a.c()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f30660c.f(runnable, j10, timeUnit, this.f30658a);
        }

        public void dispose() {
            if (this.f30661d.compareAndSet(false, true)) {
                this.f30658a.dispose();
                if (d.f30648j) {
                    this.f30660c.f(this, 0, TimeUnit.NANOSECONDS, (wj.a) null);
                    return;
                }
                this.f30659b.d(this.f30660c);
            }
        }

        public void run() {
            this.f30659b.d(this.f30660c);
        }
    }

    static final class c extends f {

        /* renamed from: c  reason: collision with root package name */
        private long f30662c = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long j() {
            return this.f30662c;
        }

        public void k(long j10) {
            this.f30662c = j10;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f30647i = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f30643e = rxThreadFactory;
        f30644f = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, (TimeUnit) null, rxThreadFactory);
        f30649k = aVar;
        aVar.e();
    }

    public d() {
        this(f30643e);
    }

    public v.c b() {
        return new b(this.f30651d.get());
    }

    public void f() {
        a aVar = new a(f30645g, f30646h, this.f30650c);
        if (!h.a(this.f30651d, f30649k, aVar)) {
            aVar.e();
        }
    }

    public d(ThreadFactory threadFactory) {
        this.f30650c = threadFactory;
        this.f30651d = new AtomicReference<>(f30649k);
        f();
    }
}

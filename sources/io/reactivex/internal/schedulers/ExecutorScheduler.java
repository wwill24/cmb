package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.v;
import tj.b;

public final class ExecutorScheduler extends v {

    /* renamed from: e  reason: collision with root package name */
    static final v f30604e = dk.a.d();

    /* renamed from: c  reason: collision with root package name */
    final boolean f30605c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f30606d;

    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, b {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct = new SequentialDisposable();
        final SequentialDisposable timed = new SequentialDisposable();

        DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public boolean c() {
            return get() == null;
        }

        public void dispose() {
            if (getAndSet((Object) null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    SequentialDisposable sequentialDisposable = this.timed;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.direct.lazySet(disposableHelper);
                } catch (Throwable th2) {
                    lazySet((Object) null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                    throw th2;
                }
            }
        }
    }

    public static final class ExecutorWorker extends v.c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f30607a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f30608b;

        /* renamed from: c  reason: collision with root package name */
        final MpscLinkedQueue<Runnable> f30609c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f30610d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f30611e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        final tj.a f30612f = new tj.a();

        static final class BooleanRunnable extends AtomicBoolean implements Runnable, b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            public boolean c() {
                return get();
            }

            public void dispose() {
                lazySet(true);
            }

            public void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, b {
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final wj.a tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable runnable, wj.a aVar) {
                this.run = runnable;
                this.tasks = aVar;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                wj.a aVar = this.tasks;
                if (aVar != null) {
                    aVar.b(this);
                }
            }

            public boolean c() {
                return get() >= 2;
            }

            public void dispose() {
                while (true) {
                    int i10 = get();
                    if (i10 < 2) {
                        if (i10 == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread2 = this.thread;
                            if (thread2 != null) {
                                thread2.interrupt();
                                this.thread = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th2;
                        }
                    } else {
                        this.thread = null;
                    }
                }
            }
        }

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final SequentialDisposable f30613a;

            /* renamed from: b  reason: collision with root package name */
            private final Runnable f30614b;

            a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f30613a = sequentialDisposable;
                this.f30614b = runnable;
            }

            public void run() {
                this.f30613a.a(ExecutorWorker.this.b(this.f30614b));
            }
        }

        public ExecutorWorker(Executor executor, boolean z10) {
            this.f30608b = executor;
            this.f30609c = new MpscLinkedQueue<>();
            this.f30607a = z10;
        }

        public b b(Runnable runnable) {
            b bVar;
            if (this.f30610d) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable u10 = bk.a.u(runnable);
            if (this.f30607a) {
                bVar = new InterruptibleRunnable(u10, this.f30612f);
                this.f30612f.a(bVar);
            } else {
                bVar = new BooleanRunnable(u10);
            }
            this.f30609c.offer(bVar);
            if (this.f30611e.getAndIncrement() == 0) {
                try {
                    this.f30608b.execute(this);
                } catch (RejectedExecutionException e10) {
                    this.f30610d = true;
                    this.f30609c.clear();
                    bk.a.s(e10);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return bVar;
        }

        public boolean c() {
            return this.f30610d;
        }

        public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (j10 <= 0) {
                return b(runnable);
            }
            if (this.f30610d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, bk.a.u(runnable)), this.f30612f);
            this.f30612f.a(scheduledRunnable);
            Executor executor = this.f30608b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule(scheduledRunnable, j10, timeUnit));
                } catch (RejectedExecutionException e10) {
                    this.f30610d = true;
                    bk.a.s(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new b(ExecutorScheduler.f30604e.d(scheduledRunnable, j10, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        public void dispose() {
            if (!this.f30610d) {
                this.f30610d = true;
                this.f30612f.dispose();
                if (this.f30611e.getAndIncrement() == 0) {
                    this.f30609c.clear();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f30611e.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f30610d == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.f30609c
                r1 = 1
            L_0x0003:
                boolean r2 = r3.f30610d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.f30610d
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f30611e
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.f30610d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }
    }

    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final DelayedRunnable f30616a;

        a(DelayedRunnable delayedRunnable) {
            this.f30616a = delayedRunnable;
        }

        public void run() {
            DelayedRunnable delayedRunnable = this.f30616a;
            delayedRunnable.direct.a(ExecutorScheduler.this.c(delayedRunnable));
        }
    }

    public ExecutorScheduler(Executor executor, boolean z10) {
        this.f30606d = executor;
        this.f30605c = z10;
    }

    public v.c b() {
        return new ExecutorWorker(this.f30606d, this.f30605c);
    }

    public b c(Runnable runnable) {
        Runnable u10 = bk.a.u(runnable);
        try {
            if (this.f30606d instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u10);
                scheduledDirectTask.a(((ExecutorService) this.f30606d).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f30605c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(u10, (wj.a) null);
                this.f30606d.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(u10);
                this.f30606d.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e10) {
            bk.a.s(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        Runnable u10 = bk.a.u(runnable);
        if (this.f30606d instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(u10);
                scheduledDirectTask.a(((ScheduledExecutorService) this.f30606d).schedule(scheduledDirectTask, j10, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e10) {
                bk.a.s(e10);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(u10);
            delayedRunnable.timed.a(f30604e.d(new a(delayedRunnable), j10, timeUnit));
            return delayedRunnable;
        }
    }

    public b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        if (!(this.f30606d instanceof ScheduledExecutorService)) {
            return super.e(runnable, j10, j11, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(bk.a.u(runnable));
            scheduledDirectPeriodicTask.a(((ScheduledExecutorService) this.f30606d).scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e10) {
            bk.a.s(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}

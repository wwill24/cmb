package qj;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.f;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    static boolean f33782a = Boolean.getBoolean("rx2.scheduler.use-nanotime");

    /* renamed from: b  reason: collision with root package name */
    static final long f33783b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements tj.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f33784a;

        /* renamed from: b  reason: collision with root package name */
        final c f33785b;

        /* renamed from: c  reason: collision with root package name */
        Thread f33786c;

        a(Runnable runnable, c cVar) {
            this.f33784a = runnable;
            this.f33785b = cVar;
        }

        public boolean c() {
            return this.f33785b.c();
        }

        public void dispose() {
            if (this.f33786c == Thread.currentThread()) {
                c cVar = this.f33785b;
                if (cVar instanceof f) {
                    ((f) cVar).i();
                    return;
                }
            }
            this.f33785b.dispose();
        }

        public void run() {
            this.f33786c = Thread.currentThread();
            try {
                this.f33784a.run();
            } finally {
                dispose();
                this.f33786c = null;
            }
        }
    }

    static final class b implements tj.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f33787a;

        /* renamed from: b  reason: collision with root package name */
        final c f33788b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33789c;

        b(Runnable runnable, c cVar) {
            this.f33787a = runnable;
            this.f33788b = cVar;
        }

        public boolean c() {
            return this.f33789c;
        }

        public void dispose() {
            this.f33789c = true;
            this.f33788b.dispose();
        }

        public void run() {
            if (!this.f33789c) {
                try {
                    this.f33787a.run();
                } catch (Throwable th2) {
                    uj.a.b(th2);
                    this.f33788b.dispose();
                    throw ExceptionHelper.e(th2);
                }
            }
        }
    }

    public static abstract class c implements tj.b {

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Runnable f33790a;

            /* renamed from: b  reason: collision with root package name */
            final SequentialDisposable f33791b;

            /* renamed from: c  reason: collision with root package name */
            final long f33792c;

            /* renamed from: d  reason: collision with root package name */
            long f33793d;

            /* renamed from: e  reason: collision with root package name */
            long f33794e;

            /* renamed from: f  reason: collision with root package name */
            long f33795f;

            a(long j10, Runnable runnable, long j11, SequentialDisposable sequentialDisposable, long j12) {
                this.f33790a = runnable;
                this.f33791b = sequentialDisposable;
                this.f33792c = j12;
                this.f33794e = j11;
                this.f33795f = j10;
            }

            public void run() {
                long j10;
                this.f33790a.run();
                if (!this.f33791b.c()) {
                    c cVar = c.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a10 = cVar.a(timeUnit);
                    long j11 = v.f33783b;
                    long j12 = this.f33794e;
                    if (a10 + j11 >= j12) {
                        long j13 = this.f33792c;
                        if (a10 < j12 + j13 + j11) {
                            long j14 = this.f33795f;
                            long j15 = this.f33793d + 1;
                            this.f33793d = j15;
                            j10 = j14 + (j15 * j13);
                            this.f33794e = a10;
                            this.f33791b.a(c.this.d(this, j10 - a10, timeUnit));
                        }
                    }
                    long j16 = this.f33792c;
                    long j17 = a10 + j16;
                    long j18 = this.f33793d + 1;
                    this.f33793d = j18;
                    this.f33795f = j17 - (j16 * j18);
                    j10 = j17;
                    this.f33794e = a10;
                    this.f33791b.a(c.this.d(this, j10 - a10, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return v.a(timeUnit);
        }

        public tj.b b(Runnable runnable) {
            return d(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract tj.b d(Runnable runnable, long j10, TimeUnit timeUnit);

        public tj.b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            long j12 = j10;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable u10 = bk.a.u(runnable);
            long nanos = timeUnit2.toNanos(j11);
            long a10 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            a aVar = r0;
            a aVar2 = new a(a10 + timeUnit2.toNanos(j12), u10, a10, sequentialDisposable2, nanos);
            tj.b d10 = d(aVar, j12, timeUnit2);
            if (d10 == EmptyDisposable.INSTANCE) {
                return d10;
            }
            sequentialDisposable3.a(d10);
            return sequentialDisposable2;
        }
    }

    static long a(TimeUnit timeUnit) {
        if (!f33782a) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract c b();

    public tj.b c(Runnable runnable) {
        return d(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        c b10 = b();
        a aVar = new a(bk.a.u(runnable), b10);
        b10.d(aVar, j10, timeUnit);
        return aVar;
    }

    public tj.b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c b10 = b();
        b bVar = new b(bk.a.u(runnable), b10);
        tj.b e10 = b10.e(bVar, j10, j11, timeUnit);
        if (e10 == EmptyDisposable.INSTANCE) {
            return e10;
        }
        return bVar;
    }
}

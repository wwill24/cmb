package u;

import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class b<I, O> extends d<O> implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private a<? super I, ? extends O> f17911c;

    /* renamed from: d  reason: collision with root package name */
    private final BlockingQueue<Boolean> f17912d = new LinkedBlockingQueue(1);

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f17913e = new CountDownLatch(1);

    /* renamed from: f  reason: collision with root package name */
    private zf.a<? extends I> f17914f;

    /* renamed from: g  reason: collision with root package name */
    volatile zf.a<? extends O> f17915g;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ zf.a f17916a;

        a(zf.a aVar) {
            this.f17916a = aVar;
        }

        public void run() {
            try {
                b.this.b(f.e(this.f17916a));
            } catch (CancellationException unused) {
                b.this.cancel(false);
                b.this.f17915g = null;
                return;
            } catch (ExecutionException e10) {
                b.this.c(e10.getCause());
            } catch (Throwable th2) {
                b.this.f17915g = null;
                throw th2;
            }
            b.this.f17915g = null;
        }
    }

    b(@NonNull a<? super I, ? extends O> aVar, @NonNull zf.a<? extends I> aVar2) {
        this.f17911c = (a) h.g(aVar);
        this.f17914f = (zf.a) h.g(aVar2);
    }

    private void f(Future<?> future, boolean z10) {
        if (future != null) {
            future.cancel(z10);
        }
    }

    private <E> void g(@NonNull BlockingQueue<E> blockingQueue, @NonNull E e10) {
        boolean z10 = false;
        while (true) {
            try {
                blockingQueue.put(e10);
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private <E> E h(@NonNull BlockingQueue<E> blockingQueue) {
        E take;
        boolean z10 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    public boolean cancel(boolean z10) {
        if (!super.cancel(z10)) {
            return false;
        }
        g(this.f17912d, Boolean.valueOf(z10));
        f(this.f17914f, z10);
        f(this.f17915g, z10);
        return true;
    }

    public O get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            zf.a<? extends I> aVar = this.f17914f;
            if (aVar != null) {
                aVar.get();
            }
            this.f17913e.await();
            zf.a<? extends O> aVar2 = this.f17915g;
            if (aVar2 != null) {
                aVar2.get();
            }
        }
        return super.get();
    }

    public void run() {
        try {
            try {
                zf.a<? extends O> apply = this.f17911c.apply(f.e(this.f17914f));
                this.f17915g = apply;
                if (isCancelled()) {
                    apply.cancel(((Boolean) h(this.f17912d)).booleanValue());
                    this.f17915g = null;
                    this.f17911c = null;
                    this.f17914f = null;
                    this.f17913e.countDown();
                    return;
                }
                apply.addListener(new a(apply), androidx.camera.core.impl.utils.executor.a.a());
                this.f17911c = null;
                this.f17914f = null;
                this.f17913e.countDown();
            } catch (UndeclaredThrowableException e10) {
                c(e10.getCause());
            } catch (Exception e11) {
                c(e11);
            } catch (Error e12) {
                c(e12);
            } catch (Throwable th2) {
                this.f17911c = null;
                this.f17914f = null;
                this.f17913e.countDown();
                throw th2;
            }
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e13) {
            c(e13.getCause());
        }
    }

    public O get(long j10, @NonNull TimeUnit timeUnit) throws TimeoutException, ExecutionException, InterruptedException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j10 = timeUnit2.convert(j10, timeUnit);
                timeUnit = timeUnit2;
            }
            zf.a<? extends I> aVar = this.f17914f;
            if (aVar != null) {
                long nanoTime = System.nanoTime();
                aVar.get(j10, timeUnit);
                j10 -= Math.max(0, System.nanoTime() - nanoTime);
            }
            long nanoTime2 = System.nanoTime();
            if (this.f17913e.await(j10, timeUnit)) {
                j10 -= Math.max(0, System.nanoTime() - nanoTime2);
                zf.a<? extends O> aVar2 = this.f17915g;
                if (aVar2 != null) {
                    aVar2.get(j10, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return super.get(j10, timeUnit);
    }
}

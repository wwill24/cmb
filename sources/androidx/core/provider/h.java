package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class h {

    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f4683a;

        /* renamed from: b  reason: collision with root package name */
        private int f4684b;

        /* renamed from: androidx.core.provider.h$a$a  reason: collision with other inner class name */
        private static class C0040a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f4685a;

            C0040a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f4685a = i10;
            }

            public void run() {
                Process.setThreadPriority(this.f4685a);
                super.run();
            }
        }

        a(@NonNull String str, int i10) {
            this.f4683a = str;
            this.f4684b = i10;
        }

        public Thread newThread(Runnable runnable) {
            return new C0040a(runnable, this.f4683a, this.f4684b);
        }
    }

    private static class b<T> implements Runnable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private Callable<T> f4686a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private androidx.core.util.a<T> f4687b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private Handler f4688c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ androidx.core.util.a f4689a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f4690b;

            a(androidx.core.util.a aVar, Object obj) {
                this.f4689a = aVar;
                this.f4690b = obj;
            }

            public void run() {
                this.f4689a.accept(this.f4690b);
            }
        }

        b(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
            this.f4686a = callable;
            this.f4687b = aVar;
            this.f4688c = handler;
        }

        public void run() {
            T t10;
            try {
                t10 = this.f4686a.call();
            } catch (Exception unused) {
                t10 = null;
            }
            this.f4688c.post(new a(this.f4687b, t10));
        }
    }

    static ThreadPoolExecutor a(@NonNull String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull androidx.core.util.a<T> aVar) {
        executor.execute(new b(b.a(), callable, aVar));
    }

    static <T> T c(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i10, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e10) {
            throw new RuntimeException(e10);
        } catch (InterruptedException e11) {
            throw e11;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}

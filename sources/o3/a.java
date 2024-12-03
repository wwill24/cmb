package o3;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class a implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final long f16802b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f16803c;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f16804a;

    /* renamed from: o3.a$a  reason: collision with other inner class name */
    public static final class C0178a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f16805a;

        /* renamed from: b  reason: collision with root package name */
        private int f16806b;

        /* renamed from: c  reason: collision with root package name */
        private int f16807c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private c f16808d = c.f16819d;

        /* renamed from: e  reason: collision with root package name */
        private String f16809e;

        /* renamed from: f  reason: collision with root package name */
        private long f16810f;

        C0178a(boolean z10) {
            this.f16805a = z10;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f16809e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f16806b, this.f16807c, this.f16810f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f16809e, this.f16808d, this.f16805a));
                if (this.f16810f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f16809e);
        }

        public C0178a b(String str) {
            this.f16809e = str;
            return this;
        }

        public C0178a c(int i10) {
            this.f16806b = i10;
            this.f16807c = i10;
            return this;
        }
    }

    private static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f16811a;

        /* renamed from: b  reason: collision with root package name */
        final c f16812b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f16813c;

        /* renamed from: d  reason: collision with root package name */
        private int f16814d;

        /* renamed from: o3.a$b$a  reason: collision with other inner class name */
        class C0179a extends Thread {
            C0179a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f16813c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    b.this.f16812b.a(th2);
                }
            }
        }

        b(String str, c cVar, boolean z10) {
            this.f16811a = str;
            this.f16812b = cVar;
            this.f16813c = z10;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0179a aVar;
            aVar = new C0179a(runnable, "glide-" + this.f16811a + "-thread-" + this.f16814d);
            this.f16814d = this.f16814d + 1;
            return aVar;
        }
    }

    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f16816a = new C0180a();

        /* renamed from: b  reason: collision with root package name */
        public static final c f16817b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f16818c = new C0181c();

        /* renamed from: d  reason: collision with root package name */
        public static final c f16819d;

        /* renamed from: o3.a$c$a  reason: collision with other inner class name */
        class C0180a implements c {
            C0180a() {
            }

            public void a(Throwable th2) {
            }
        }

        class b implements c {
            b() {
            }

            public void a(Throwable th2) {
                if (th2 != null) {
                    Log.isLoggable("GlideExecutor", 6);
                }
            }
        }

        /* renamed from: o3.a$c$c  reason: collision with other inner class name */
        class C0181c implements c {
            C0181c() {
            }

            public void a(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            b bVar = new b();
            f16817b = bVar;
            f16819d = bVar;
        }

        void a(Throwable th2);
    }

    a(ExecutorService executorService) {
        this.f16804a = executorService;
    }

    public static int a() {
        if (f16803c == 0) {
            f16803c = Math.min(4, b.a());
        }
        return f16803c;
    }

    public static C0178a b() {
        int i10;
        if (a() >= 4) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        return new C0178a(true).c(i10).b("animation");
    }

    public static a c() {
        return b().a();
    }

    public static C0178a d() {
        return new C0178a(true).c(1).b("disk-cache");
    }

    public static a e() {
        return d().a();
    }

    public static C0178a f() {
        return new C0178a(false).c(a()).b("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, a.e.API_PRIORITY_OTHER, f16802b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f16819d, false)));
    }

    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f16804a.awaitTermination(j10, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f16804a.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f16804a.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f16804a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f16804a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f16804a.isTerminated();
    }

    public void shutdown() {
        this.f16804a.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f16804a.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f16804a.submit(runnable);
    }

    public String toString() {
        return this.f16804a.toString();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f16804a.invokeAll(collection, j10, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f16804a.invokeAny(collection, j10, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
        return this.f16804a.submit(runnable, t10);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f16804a.submit(callable);
    }
}

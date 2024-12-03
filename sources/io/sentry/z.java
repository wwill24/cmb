package io.sentry;

import io.sentry.util.l;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

final class z {

    /* renamed from: g  reason: collision with root package name */
    private static final long f31809g = TimeUnit.HOURS.toMillis(5);

    /* renamed from: h  reason: collision with root package name */
    private static final long f31810h = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: i  reason: collision with root package name */
    private static z f31811i;

    /* renamed from: a  reason: collision with root package name */
    private final long f31812a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f31813b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f31814c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f31815d;

    /* renamed from: e  reason: collision with root package name */
    private final Callable<InetAddress> f31816e;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f31817f;

    private static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f31818a;

        private b() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SentryHostnameCache-");
            int i10 = this.f31818a;
            this.f31818a = i10 + 1;
            sb2.append(i10);
            Thread thread = new Thread(runnable, sb2.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private z() {
        this(f31809g);
    }

    static z e() {
        if (f31811i == null) {
            f31811i = new z();
        }
        return f31811i;
    }

    private void f() {
        this.f31814c = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public /* synthetic */ Void h() throws Exception {
        try {
            this.f31813b = this.f31816e.call().getCanonicalHostName();
            this.f31814c = System.currentTimeMillis() + this.f31812a;
            this.f31815d.set(false);
            return null;
        } catch (Throwable th2) {
            this.f31815d.set(false);
            throw th2;
        }
    }

    private void i() {
        try {
            this.f31817f.submit(new y(this)).get(f31810h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            f();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            f();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f31817f.shutdown();
    }

    /* access modifiers changed from: package-private */
    public String d() {
        if (this.f31814c < System.currentTimeMillis() && this.f31815d.compareAndSet(false, true)) {
            i();
        }
        return this.f31813b;
    }

    z(long j10) {
        this(j10, new x());
    }

    z(long j10, Callable<InetAddress> callable) {
        this.f31815d = new AtomicBoolean(false);
        this.f31817f = Executors.newSingleThreadExecutor(new b());
        this.f31812a = j10;
        this.f31816e = (Callable) l.c(callable, "getLocalhost is required");
        i();
    }
}

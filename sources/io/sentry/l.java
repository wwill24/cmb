package io.sentry;

import io.sentry.hints.c;
import io.sentry.hints.e;
import io.sentry.hints.g;
import io.sentry.util.i;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private final h0 f31318a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31319b;

    private static final class a implements c, g, io.sentry.hints.l, e {

        /* renamed from: a  reason: collision with root package name */
        boolean f31320a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f31321b = false;

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f31322c;

        /* renamed from: d  reason: collision with root package name */
        private final long f31323d;

        /* renamed from: e  reason: collision with root package name */
        private final h0 f31324e;

        public a(long j10, h0 h0Var) {
            this.f31323d = j10;
            this.f31322c = new CountDownLatch(1);
            this.f31324e = h0Var;
        }

        public boolean a() {
            return this.f31320a;
        }

        public void b(boolean z10) {
            this.f31321b = z10;
            this.f31322c.countDown();
        }

        public void c(boolean z10) {
            this.f31320a = z10;
        }

        public boolean d() {
            try {
                return this.f31322c.await(this.f31323d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                this.f31324e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e10);
                return false;
            }
        }

        public boolean e() {
            return this.f31321b;
        }
    }

    l(h0 h0Var, long j10) {
        this.f31318a = h0Var;
        this.f31319b = j10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean d(File file, String str) {
        return c(str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean c(String str);

    public void e(File file) {
        int i10;
        try {
            h0 h0Var = this.f31318a;
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            h0Var.c(sentryLevel, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.f31318a.c(SentryLevel.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
            } else if (!file.isDirectory()) {
                this.f31318a.c(SentryLevel.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    this.f31318a.c(SentryLevel.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                    return;
                }
                File[] listFiles2 = file.listFiles(new k(this));
                h0 h0Var2 = this.f31318a;
                Object[] objArr = new Object[2];
                if (listFiles2 != null) {
                    i10 = listFiles2.length;
                } else {
                    i10 = 0;
                }
                objArr[0] = Integer.valueOf(i10);
                objArr[1] = file.getAbsolutePath();
                h0Var2.c(sentryLevel, "Processing %d items from cache dir %s", objArr);
                for (File file2 : listFiles) {
                    if (!file2.isFile()) {
                        this.f31318a.c(SentryLevel.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                    } else {
                        this.f31318a.c(SentryLevel.DEBUG, "Processing file: %s", file2.getAbsolutePath());
                        f(file2, i.e(new a(this.f31319b, this.f31318a)));
                    }
                }
            }
        } catch (Throwable th2) {
            this.f31318a.a(SentryLevel.ERROR, th2, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void f(File file, w wVar);
}

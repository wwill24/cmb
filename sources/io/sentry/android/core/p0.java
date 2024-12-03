package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.SentryLevel;
import io.sentry.f0;
import io.sentry.h0;
import io.sentry.hints.b;
import io.sentry.hints.c;
import io.sentry.hints.e;
import io.sentry.hints.f;
import io.sentry.hints.g;
import io.sentry.hints.l;
import io.sentry.util.i;
import io.sentry.w;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class p0 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private final String f31080a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f31081b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f31082c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31083d;

    private static final class a implements c, g, l, e, b, f {

        /* renamed from: a  reason: collision with root package name */
        boolean f31084a;

        /* renamed from: b  reason: collision with root package name */
        boolean f31085b;

        /* renamed from: c  reason: collision with root package name */
        private CountDownLatch f31086c;

        /* renamed from: d  reason: collision with root package name */
        private final long f31087d;

        /* renamed from: e  reason: collision with root package name */
        private final h0 f31088e;

        public a(long j10, h0 h0Var) {
            reset();
            this.f31087d = j10;
            this.f31088e = (h0) io.sentry.util.l.c(h0Var, "ILogger is required.");
        }

        public boolean a() {
            return this.f31084a;
        }

        public void b(boolean z10) {
            this.f31085b = z10;
            this.f31086c.countDown();
        }

        public void c(boolean z10) {
            this.f31084a = z10;
        }

        public boolean d() {
            try {
                return this.f31086c.await(this.f31087d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                this.f31088e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e10);
                return false;
            }
        }

        public boolean e() {
            return this.f31085b;
        }

        public void reset() {
            this.f31086c = new CountDownLatch(1);
            this.f31084a = false;
            this.f31085b = false;
        }
    }

    p0(String str, f0 f0Var, h0 h0Var, long j10) {
        super(str);
        this.f31080a = str;
        this.f31081b = (f0) io.sentry.util.l.c(f0Var, "Envelope sender is required.");
        this.f31082c = (h0) io.sentry.util.l.c(h0Var, "Logger is required.");
        this.f31083d = j10;
    }

    public void onEvent(int i10, String str) {
        if (str != null && i10 == 8) {
            this.f31082c.c(SentryLevel.DEBUG, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", Integer.valueOf(i10), this.f31080a, str);
            w e10 = i.e(new a(this.f31083d, this.f31082c));
            f0 f0Var = this.f31081b;
            f0Var.a(this.f31080a + File.separator + str, e10);
        }
    }
}

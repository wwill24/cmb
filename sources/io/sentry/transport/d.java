package io.sentry.transport;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.b2;
import io.sentry.cache.e;
import io.sentry.clientreport.DiscardReason;
import io.sentry.h0;
import io.sentry.hints.g;
import io.sentry.util.i;
import io.sentry.util.k;
import io.sentry.util.l;
import io.sentry.w;
import io.sentry.w2;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d implements p {

    /* renamed from: a  reason: collision with root package name */
    private final v f31643a;

    /* renamed from: b  reason: collision with root package name */
    private final e f31644b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SentryOptions f31645c;

    /* renamed from: d  reason: collision with root package name */
    private final y f31646d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final q f31647e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final n f31648f;

    private static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private int f31649a;

        private b() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SentryAsyncConnection-");
            int i10 = this.f31649a;
            this.f31649a = i10 + 1;
            sb2.append(i10);
            Thread thread = new Thread(runnable, sb2.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private final class c implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final w2 f31650a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final w f31651b;

        /* renamed from: c  reason: collision with root package name */
        private final e f31652c;

        /* renamed from: d  reason: collision with root package name */
        private final z f31653d = z.a();

        c(w2 w2Var, w wVar, e eVar) {
            this.f31650a = (w2) l.c(w2Var, "Envelope is required.");
            this.f31651b = wVar;
            this.f31652c = (e) l.c(eVar, "EnvelopeCache is required.");
        }

        private z j() {
            Class<g> cls = g.class;
            z zVar = this.f31653d;
            this.f31652c.a1(this.f31650a, this.f31651b);
            i.n(this.f31651b, io.sentry.hints.d.class, new f(this));
            if (d.this.f31647e.isConnected()) {
                w2 d10 = d.this.f31645c.getClientReportRecorder().d(this.f31650a);
                try {
                    z h10 = d.this.f31648f.h(d10);
                    if (h10.d()) {
                        this.f31652c.x(this.f31650a);
                        return h10;
                    }
                    String str = "The transport failed to send the envelope with response code " + h10.c();
                    d.this.f31645c.getLogger().c(SentryLevel.ERROR, str, new Object[0]);
                    if (h10.c() >= 400 && h10.c() != 429) {
                        i.m(this.f31651b, cls, new g(this, d10));
                    }
                    throw new IllegalStateException(str);
                } catch (IOException e10) {
                    i.o(this.f31651b, cls, new h(), new i(this, d10));
                    throw new IllegalStateException("Sending the event failed.", e10);
                }
            } else {
                i.o(this.f31651b, cls, new j(), new k(this));
                return zVar;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(io.sentry.hints.d dVar) {
            dVar.a();
            d.this.f31645c.getLogger().c(SentryLevel.DEBUG, "Disk flush envelope fired", new Object[0]);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(w2 w2Var, Object obj) {
            d.this.f31645c.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, w2Var);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(w2 w2Var, Object obj, Class cls) {
            k.a(cls, obj, d.this.f31645c.getLogger());
            d.this.f31645c.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, w2Var);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(Object obj, Class cls) {
            k.a(cls, obj, d.this.f31645c.getLogger());
            d.this.f31645c.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, this.f31650a);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(z zVar, io.sentry.hints.l lVar) {
            d.this.f31645c.getLogger().c(SentryLevel.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(zVar.d()));
            lVar.b(zVar.d());
        }

        public void run() {
            Class<io.sentry.hints.l> cls = io.sentry.hints.l.class;
            z zVar = this.f31653d;
            try {
                zVar = j();
                d.this.f31645c.getLogger().c(SentryLevel.DEBUG, "Envelope flushed", new Object[0]);
                i.n(this.f31651b, cls, new e(this, zVar));
            } catch (Throwable th2) {
                i.n(this.f31651b, cls, new e(this, zVar));
                throw th2;
            }
        }
    }

    public d(SentryOptions sentryOptions, y yVar, q qVar, b2 b2Var) {
        this(h(sentryOptions.getMaxQueueSize(), sentryOptions.getEnvelopeDiskCache(), sentryOptions.getLogger()), sentryOptions, yVar, qVar, new n(sentryOptions, b2Var, yVar));
    }

    private static v h(int i10, e eVar, h0 h0Var) {
        return new v(1, i10, new b(), new a(eVar, h0Var), h0Var);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(e eVar, h0 h0Var, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            if (!i.g(cVar.f31651b, io.sentry.hints.c.class)) {
                eVar.a1(cVar.f31650a, cVar.f31651b);
            }
            n(cVar.f31651b, true);
            h0Var.c(SentryLevel.WARNING, "Envelope rejected", new Object[0]);
        }
    }

    private static void n(w wVar, boolean z10) {
        i.n(wVar, io.sentry.hints.l.class, new b());
        i.n(wVar, g.class, new c(z10));
    }

    public void R(w2 w2Var, w wVar) throws IOException {
        e eVar = this.f31644b;
        boolean z10 = false;
        if (i.g(wVar, io.sentry.hints.c.class)) {
            eVar = r.b();
            this.f31645c.getLogger().c(SentryLevel.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z10 = true;
        }
        w2 d10 = this.f31646d.d(w2Var, wVar);
        if (d10 != null) {
            if (i.g(wVar, io.sentry.hints.d.class)) {
                d10 = this.f31645c.getClientReportRecorder().d(d10);
            }
            Future<?> submit = this.f31643a.submit(new c(d10, wVar, eVar));
            if (submit != null && submit.isCancelled()) {
                this.f31645c.getClientReportRecorder().b(DiscardReason.QUEUE_OVERFLOW, d10);
            }
        } else if (z10) {
            this.f31644b.x(w2Var);
        }
    }

    public void close() throws IOException {
        this.f31643a.shutdown();
        this.f31645c.getLogger().c(SentryLevel.DEBUG, "Shutting down", new Object[0]);
        try {
            if (!this.f31643a.awaitTermination(1, TimeUnit.MINUTES)) {
                this.f31645c.getLogger().c(SentryLevel.WARNING, "Failed to shutdown the async connection async sender within 1 minute. Trying to force it now.", new Object[0]);
                this.f31643a.shutdownNow();
            }
        } catch (InterruptedException unused) {
            this.f31645c.getLogger().c(SentryLevel.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    public void o(long j10) {
        this.f31643a.b(j10);
    }

    public d(v vVar, SentryOptions sentryOptions, y yVar, q qVar, n nVar) {
        this.f31643a = (v) l.c(vVar, "executor is required");
        this.f31644b = (e) l.c(sentryOptions.getEnvelopeDiskCache(), "envelopeCache is required");
        this.f31645c = (SentryOptions) l.c(sentryOptions, "options is required");
        this.f31646d = (y) l.c(yVar, "rateLimiter is required");
        this.f31647e = (q) l.c(qVar, "transportGate is required");
        this.f31648f = (n) l.c(nVar, "httpConnection is required");
    }
}

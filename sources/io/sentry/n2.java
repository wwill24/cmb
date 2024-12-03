package io.sentry;

import io.sentry.cache.d;
import io.sentry.config.g;
import io.sentry.internal.modules.b;
import io.sentry.internal.modules.c;
import io.sentry.internal.modules.e;
import io.sentry.internal.modules.f;
import io.sentry.protocol.o;
import io.sentry.protocol.x;
import io.sentry.transport.r;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<g0> f31346a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static volatile g0 f31347b = h1.b();

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f31348c = false;

    public interface a<T extends SentryOptions> {
        void a(T t10);
    }

    public static void b(d dVar, w wVar) {
        k().t(dVar, wVar);
    }

    private static <T extends SentryOptions> void c(a<T> aVar, T t10) {
        try {
            aVar.a(t10);
        } catch (Throwable th2) {
            t10.getLogger().b(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th2);
        }
    }

    public static o d(p3 p3Var, w wVar) {
        return k().x(p3Var, wVar);
    }

    public static o e(Throwable th2) {
        return k().z(th2);
    }

    public static o f(Throwable th2, w wVar) {
        return k().A(th2, wVar);
    }

    public static synchronized void g() {
        synchronized (n2.class) {
            g0 k10 = k();
            f31347b = h1.b();
            f31346a.remove();
            k10.close();
        }
    }

    public static void h(f2 f2Var) {
        k().u(f2Var);
    }

    public static void i() {
        k().w();
    }

    public static void j(long j10) {
        k().o(j10);
    }

    @ApiStatus.Internal
    public static g0 k() {
        if (f31348c) {
            return f31347b;
        }
        ThreadLocal<g0> threadLocal = f31346a;
        g0 g0Var = threadLocal.get();
        if (g0Var != null && !(g0Var instanceof h1)) {
            return g0Var;
        }
        g0 clone = f31347b.clone();
        threadLocal.set(clone);
        return clone;
    }

    public static <T extends SentryOptions> void l(t1<T> t1Var, a<T> aVar, boolean z10) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        SentryOptions sentryOptions = (SentryOptions) t1Var.b();
        c(aVar, sentryOptions);
        m(sentryOptions, z10);
    }

    private static synchronized void m(SentryOptions sentryOptions, boolean z10) {
        synchronized (n2.class) {
            if (o()) {
                sentryOptions.getLogger().c(SentryLevel.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
            }
            if (n(sentryOptions)) {
                sentryOptions.getLogger().c(SentryLevel.INFO, "GlobalHubMode: '%s'", String.valueOf(z10));
                f31348c = z10;
                g0 k10 = k();
                f31347b = new b0(sentryOptions);
                f31346a.set(f31347b);
                k10.close();
                for (Integration a10 : sentryOptions.getIntegrations()) {
                    a10.a(c0.b(), sentryOptions);
                }
            }
        }
    }

    private static boolean n(SentryOptions sentryOptions) {
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(u.f(g.a(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string to disable SDK.");
        } else if (dsn.isEmpty()) {
            g();
            return false;
        } else {
            new m(dsn);
            h0 logger = sentryOptions.getLogger();
            if (sentryOptions.isDebug() && (logger instanceof i1)) {
                sentryOptions.setLogger(new o4());
                logger = sentryOptions.getLogger();
            }
            SentryLevel sentryLevel = SentryLevel.INFO;
            logger.c(sentryLevel, "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
            String outboxPath = sentryOptions.getOutboxPath();
            if (outboxPath != null) {
                new File(outboxPath).mkdirs();
            } else {
                logger.c(sentryLevel, "No outbox dir path is defined in options.", new Object[0]);
            }
            String cacheDirPath = sentryOptions.getCacheDirPath();
            if (cacheDirPath != null) {
                new File(cacheDirPath).mkdirs();
                if (sentryOptions.getEnvelopeDiskCache() instanceof r) {
                    sentryOptions.setEnvelopeDiskCache(d.w(sentryOptions));
                }
            }
            String profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
            if (sentryOptions.isProfilingEnabled() && profilingTracesDirPath != null) {
                File file = new File(profilingTracesDirPath);
                file.mkdirs();
                sentryOptions.getExecutorService().submit((Runnable) new m2(file.listFiles()));
            }
            if (sentryOptions.getModulesLoader() instanceof e) {
                sentryOptions.setModulesLoader(new io.sentry.internal.modules.a(Arrays.asList(new b[]{new c(sentryOptions.getLogger()), new f(sentryOptions.getLogger())}), sentryOptions.getLogger()));
            }
            if (sentryOptions.getMainThreadChecker() instanceof io.sentry.util.thread.c) {
                sentryOptions.setMainThreadChecker(io.sentry.util.thread.b.e());
            }
            if (sentryOptions.getCollectors().isEmpty()) {
                sentryOptions.addCollector(new r0());
            }
            return true;
        }
    }

    public static boolean o() {
        return k().isEnabled();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void p(File[] fileArr) {
        if (fileArr != null) {
            for (File a10 : fileArr) {
                io.sentry.util.d.a(a10);
            }
        }
    }

    public static void q(String str, String str2) {
        k().a(str, str2);
    }

    public static void r(x xVar) {
        k().p(xVar);
    }

    public static void s() {
        k().C();
    }

    @ApiStatus.Internal
    public static n0 t(s4 s4Var, u4 u4Var) {
        return k().y(s4Var, u4Var);
    }
}

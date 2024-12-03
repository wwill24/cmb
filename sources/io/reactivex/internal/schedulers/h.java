package io.reactivex.internal.schedulers;

import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import vj.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f30667a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f30668b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f30669c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f30670d = new ConcurrentHashMap();

    static final class a implements Runnable {
        a() {
        }

        public void run() {
            Iterator it = new ArrayList(h.f30670d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    h.f30670d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class b implements j<String, String> {
        b() {
        }

        /* renamed from: a */
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean b10 = b(true, "rx2.purge-enabled", true, true, bVar);
        f30667a = b10;
        f30668b = c(b10, "rx2.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f30667a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z10, String str, boolean z11, boolean z12, j<String, String> jVar) {
        if (!z10) {
            return z12;
        }
        try {
            String apply = jVar.apply(str);
            if (apply == null) {
                return z11;
            }
            return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(apply);
        } catch (Throwable unused) {
            return z11;
        }
    }

    static int c(boolean z10, String str, int i10, int i11, j<String, String> jVar) {
        if (!z10) {
            return i11;
        }
        try {
            String apply = jVar.apply(str);
            if (apply == null) {
                return i10;
            }
            return Integer.parseInt(apply);
        } catch (Throwable unused) {
            return i10;
        }
    }

    public static void d() {
        f(f30667a);
    }

    static void e(boolean z10, ScheduledExecutorService scheduledExecutorService) {
        if (z10 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f30670d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z10) {
        if (z10) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f30669c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (androidx.camera.view.h.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        int i10 = f30668b;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, (long) i10, (long) i10, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}

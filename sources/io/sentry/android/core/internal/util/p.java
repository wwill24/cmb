package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.i0;
import io.sentry.util.l;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class p implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final i0 f31042a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Window> f31043b;

    /* renamed from: c  reason: collision with root package name */
    private final SentryOptions f31044c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f31045d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Window> f31046e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, b> f31047f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31048g;

    /* renamed from: h  reason: collision with root package name */
    private final c f31049h;

    /* renamed from: j  reason: collision with root package name */
    private Window.OnFrameMetricsAvailableListener f31050j;

    /* renamed from: k  reason: collision with root package name */
    private Choreographer f31051k;

    /* renamed from: l  reason: collision with root package name */
    private Field f31052l;

    /* renamed from: m  reason: collision with root package name */
    private long f31053m;

    /* renamed from: n  reason: collision with root package name */
    private long f31054n;

    class a implements c {
        a() {
        }
    }

    @ApiStatus.Internal
    public interface b {
        void a(long j10, long j11, float f10);
    }

    @ApiStatus.Internal
    public interface c {
        void a(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
            window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
        }

        void b(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
            window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }

    @SuppressLint({"NewApi"})
    public p(Context context, SentryOptions sentryOptions, i0 i0Var) {
        this(context, sentryOptions, i0Var, new a());
    }

    private long d(FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }

    @SuppressLint({"NewApi"})
    private long e(FrameMetrics frameMetrics) {
        Field field;
        if (this.f31042a.d() >= 26) {
            return frameMetrics.getMetric(10);
        }
        Choreographer choreographer = this.f31051k;
        if (choreographer == null || (field = this.f31052l) == null) {
            return -1;
        }
        try {
            Long l10 = (Long) field.get(choreographer);
            if (l10 != null) {
                return l10.longValue();
            }
            return -1;
        } catch (IllegalAccessException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f31051k = Choreographer.getInstance();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(i0 i0Var, Window window, FrameMetrics frameMetrics, int i10) {
        float f10;
        long nanoTime = System.nanoTime();
        if (i0Var.d() >= 30) {
            f10 = window.getContext().getDisplay().getRefreshRate();
        } else {
            f10 = window.getWindowManager().getDefaultDisplay().getRefreshRate();
        }
        long d10 = d(frameMetrics);
        long e10 = e(frameMetrics);
        if (e10 < 0) {
            e10 = nanoTime - d10;
        }
        long max = Math.max(e10, this.f31054n);
        if (max != this.f31053m) {
            this.f31053m = max;
            this.f31054n = max + d10;
            for (b a10 : this.f31047f.values()) {
                a10.a(this.f31054n, d10, f10);
            }
        }
    }

    private void i(Window window) {
        WeakReference<Window> weakReference = this.f31046e;
        if (weakReference == null || weakReference.get() != window) {
            this.f31046e = new WeakReference<>(window);
            m();
        }
    }

    @SuppressLint({"NewApi"})
    private void l(Window window) {
        if (this.f31043b.contains(window)) {
            if (this.f31042a.d() >= 24) {
                try {
                    this.f31049h.b(window, this.f31050j);
                } catch (Exception e10) {
                    this.f31044c.getLogger().b(SentryLevel.ERROR, "Failed to remove frameMetricsAvailableListener", e10);
                }
            }
            this.f31043b.remove(window);
        }
    }

    @SuppressLint({"NewApi"})
    private void m() {
        Window window;
        WeakReference<Window> weakReference = this.f31046e;
        if (weakReference != null) {
            window = weakReference.get();
        } else {
            window = null;
        }
        if (window != null && this.f31048g && !this.f31043b.contains(window) && !this.f31047f.isEmpty() && this.f31042a.d() >= 24 && this.f31045d != null) {
            this.f31043b.add(window);
            this.f31049h.a(window, this.f31050j, this.f31045d);
        }
    }

    public String j(b bVar) {
        if (!this.f31048g) {
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        this.f31047f.put(uuid, bVar);
        m();
        return uuid;
    }

    public void k(String str) {
        Window window;
        if (this.f31048g) {
            if (str != null) {
                this.f31047f.remove(str);
            }
            WeakReference<Window> weakReference = this.f31046e;
            if (weakReference != null) {
                window = weakReference.get();
            } else {
                window = null;
            }
            if (window != null && this.f31047f.isEmpty()) {
                l(window);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        i(activity.getWindow());
    }

    public void onActivityStopped(Activity activity) {
        l(activity.getWindow());
        WeakReference<Window> weakReference = this.f31046e;
        if (weakReference != null && weakReference.get() == activity.getWindow()) {
            this.f31046e = null;
        }
    }

    @SuppressLint({"NewApi", "DiscouragedPrivateApi"})
    public p(Context context, SentryOptions sentryOptions, i0 i0Var, c cVar) {
        this.f31043b = new HashSet();
        this.f31047f = new HashMap<>();
        this.f31048g = false;
        this.f31053m = 0;
        this.f31054n = 0;
        l.c(context, "The context is required");
        this.f31044c = (SentryOptions) l.c(sentryOptions, "SentryOptions is required");
        this.f31042a = (i0) l.c(i0Var, "BuildInfoProvider is required");
        this.f31049h = (c) l.c(cVar, "WindowFrameMetricsManager is required");
        if ((context instanceof Application) && i0Var.d() >= 24) {
            this.f31048g = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new m(sentryOptions));
            handlerThread.start();
            this.f31045d = new Handler(handlerThread.getLooper());
            ((Application) context).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new n(this));
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.f31052l = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Unable to get the frame timestamp from the choreographer: ", e10);
            }
            this.f31050j = new o(this, i0Var);
        }
    }
}

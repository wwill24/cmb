package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.b0;
import androidx.camera.core.impl.utils.h;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.w;
import androidx.camera.core.impl.y;
import androidx.camera.core.v;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.i;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import u.f;
import zf.a;

public final class CameraX {

    /* renamed from: o  reason: collision with root package name */
    private static final Object f2059o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static final SparseArray<Integer> f2060p = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    final y f2061a = new y();

    /* renamed from: b  reason: collision with root package name */
    private final Object f2062b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final v f2063c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2064d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f2065e;

    /* renamed from: f  reason: collision with root package name */
    private final HandlerThread f2066f;

    /* renamed from: g  reason: collision with root package name */
    private w f2067g;

    /* renamed from: h  reason: collision with root package name */
    private v f2068h;

    /* renamed from: i  reason: collision with root package name */
    private UseCaseConfigFactory f2069i;

    /* renamed from: j  reason: collision with root package name */
    private Context f2070j;

    /* renamed from: k  reason: collision with root package name */
    private final a<Void> f2071k;

    /* renamed from: l  reason: collision with root package name */
    private InternalInitState f2072l = InternalInitState.UNINITIALIZED;

    /* renamed from: m  reason: collision with root package name */
    private a<Void> f2073m = f.h(null);

    /* renamed from: n  reason: collision with root package name */
    private final Integer f2074n;

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraX(@NonNull Context context, v.b bVar) {
        if (bVar != null) {
            this.f2063c = bVar.getCameraXConfig();
        } else {
            v.b f10 = f(context);
            if (f10 != null) {
                this.f2063c = f10.getCameraXConfig();
            } else {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
        }
        Executor L = this.f2063c.L((Executor) null);
        Handler O = this.f2063c.O((Handler) null);
        this.f2064d = L == null ? new o() : L;
        if (O == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f2066f = handlerThread;
            handlerThread.start();
            this.f2065e = i.a(handlerThread.getLooper());
        } else {
            this.f2066f = null;
            this.f2065e = O;
        }
        Integer num = (Integer) this.f2063c.g(v.G, null);
        this.f2074n = num;
        i(num);
        this.f2071k = k(context);
    }

    private static v.b f(@NonNull Context context) {
        String str;
        Application b10 = h.b(context);
        if (b10 instanceof v.b) {
            return (v.b) b10;
        }
        try {
            Context a10 = h.a(context);
            Bundle bundle = a10.getPackageManager().getServiceInfo(new ComponentName(a10, MetadataHolderService.class), 640).metaData;
            if (bundle != null) {
                str = bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER");
            } else {
                str = null;
            }
            if (str != null) {
                return (v.b) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            v1.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e10) {
            v1.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e10);
            return null;
        }
    }

    private static void i(Integer num) {
        synchronized (f2059o) {
            if (num != null) {
                androidx.core.util.h.c(num.intValue(), 3, 6, "minLogLevel");
                SparseArray<Integer> sparseArray = f2060p;
                int i10 = 1;
                if (sparseArray.get(num.intValue()) != null) {
                    i10 = 1 + sparseArray.get(num.intValue()).intValue();
                }
                sparseArray.put(num.intValue(), Integer.valueOf(i10));
                p();
            }
        }
    }

    private void j(@NonNull Executor executor, long j10, @NonNull Context context, @NonNull CallbackToFutureAdapter.a<Void> aVar) {
        executor.execute(new t(this, context, executor, aVar, j10));
    }

    private a<Void> k(@NonNull Context context) {
        boolean z10;
        a<Void> a10;
        synchronized (this.f2062b) {
            if (this.f2072l == InternalInitState.UNINITIALIZED) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.j(z10, "CameraX.initInternal() should only be called once per instance");
            this.f2072l = InternalInitState.INITIALIZING;
            a10 = CallbackToFutureAdapter.a(new s(this, context));
        }
        return a10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Executor executor, long j10, CallbackToFutureAdapter.a aVar) {
        j(executor, j10, this.f2070j, aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Context context, Executor executor, CallbackToFutureAdapter.a aVar, long j10) {
        try {
            Application b10 = h.b(context);
            this.f2070j = b10;
            if (b10 == null) {
                this.f2070j = h.a(context);
            }
            w.a M = this.f2063c.M((w.a) null);
            if (M != null) {
                b0 a10 = b0.a(this.f2064d, this.f2065e);
                r K = this.f2063c.K((r) null);
                this.f2067g = M.a(this.f2070j, a10, K);
                v.a N = this.f2063c.N((v.a) null);
                if (N != null) {
                    this.f2068h = N.a(this.f2070j, this.f2067g.c(), this.f2067g.b());
                    UseCaseConfigFactory.b P = this.f2063c.P((UseCaseConfigFactory.b) null);
                    if (P != null) {
                        this.f2069i = P.a(this.f2070j);
                        if (executor instanceof o) {
                            ((o) executor).c(this.f2067g);
                        }
                        this.f2061a.b(this.f2067g);
                        CameraValidator.a(this.f2070j, this.f2061a, K);
                        o();
                        aVar.c(null);
                        return;
                    }
                    throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                }
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
        } catch (InitializationException | CameraValidator.CameraIdListIncorrectException | RuntimeException e10) {
            if (SystemClock.elapsedRealtime() - j10 < 2500) {
                v1.m("CameraX", "Retry init. Start time " + j10 + " current time " + SystemClock.elapsedRealtime(), e10);
                i.b(this.f2065e, new u(this, executor, j10, aVar), "retry_token", 500);
                return;
            }
            synchronized (this.f2062b) {
                this.f2072l = InternalInitState.INITIALIZING_ERROR;
                if (e10 instanceof CameraValidator.CameraIdListIncorrectException) {
                    v1.c("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    aVar.c(null);
                } else if (e10 instanceof InitializationException) {
                    aVar.f(e10);
                } else {
                    aVar.f(new InitializationException(e10));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(Context context, CallbackToFutureAdapter.a aVar) throws Exception {
        j(this.f2064d, SystemClock.elapsedRealtime(), context, aVar);
        return "CameraX initInternal";
    }

    private void o() {
        synchronized (this.f2062b) {
            this.f2072l = InternalInitState.INITIALIZED;
        }
    }

    private static void p() {
        SparseArray<Integer> sparseArray = f2060p;
        if (sparseArray.size() == 0) {
            v1.i();
        } else if (sparseArray.get(3) != null) {
            v1.j(3);
        } else if (sparseArray.get(4) != null) {
            v1.j(4);
        } else if (sparseArray.get(5) != null) {
            v1.j(5);
        } else if (sparseArray.get(6) != null) {
            v1.j(6);
        }
    }

    @NonNull
    public androidx.camera.core.impl.v d() {
        androidx.camera.core.impl.v vVar = this.f2068h;
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    public y e() {
        return this.f2061a;
    }

    @NonNull
    public UseCaseConfigFactory g() {
        UseCaseConfigFactory useCaseConfigFactory = this.f2069i;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    public a<Void> h() {
        return this.f2071k;
    }
}

package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.d3;
import androidx.camera.camera2.internal.r2;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.o0;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o.d0;
import o.h;
import p.k;
import u.c;
import u.d;
import u.f;

class x2 extends r2.a implements r2, d3.b {

    /* renamed from: a  reason: collision with root package name */
    final Object f2025a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final t1 f2026b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final Handler f2027c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final Executor f2028d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ScheduledExecutorService f2029e;

    /* renamed from: f  reason: collision with root package name */
    r2.a f2030f;

    /* renamed from: g  reason: collision with root package name */
    h f2031g;

    /* renamed from: h  reason: collision with root package name */
    zf.a<Void> f2032h;

    /* renamed from: i  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f2033i;

    /* renamed from: j  reason: collision with root package name */
    private zf.a<List<Surface>> f2034j;

    /* renamed from: k  reason: collision with root package name */
    private List<DeferrableSurface> f2035k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2036l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2037m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2038n = false;

    class a implements c<Void> {
        a() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            x2.this.d();
            x2 x2Var = x2.this;
            x2Var.f2026b.j(x2Var);
        }
    }

    class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            x2.this.A(cameraCaptureSession);
            x2 x2Var = x2.this;
            x2Var.n(x2Var);
        }

        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            x2.this.A(cameraCaptureSession);
            x2 x2Var = x2.this;
            x2Var.o(x2Var);
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            x2.this.A(cameraCaptureSession);
            x2 x2Var = x2.this;
            x2Var.p(x2Var);
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a<Void> aVar;
            try {
                x2.this.A(cameraCaptureSession);
                x2 x2Var = x2.this;
                x2Var.q(x2Var);
                synchronized (x2.this.f2025a) {
                    androidx.core.util.h.h(x2.this.f2033i, "OpenCaptureSession completer should not null");
                    x2 x2Var2 = x2.this;
                    aVar = x2Var2.f2033i;
                    x2Var2.f2033i = null;
                }
                aVar.f(new IllegalStateException("onConfigureFailed"));
            } catch (Throwable th2) {
                synchronized (x2.this.f2025a) {
                    androidx.core.util.h.h(x2.this.f2033i, "OpenCaptureSession completer should not null");
                    x2 x2Var3 = x2.this;
                    CallbackToFutureAdapter.a<Void> aVar2 = x2Var3.f2033i;
                    x2Var3.f2033i = null;
                    aVar2.f(new IllegalStateException("onConfigureFailed"));
                    throw th2;
                }
            }
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a<Void> aVar;
            try {
                x2.this.A(cameraCaptureSession);
                x2 x2Var = x2.this;
                x2Var.r(x2Var);
                synchronized (x2.this.f2025a) {
                    androidx.core.util.h.h(x2.this.f2033i, "OpenCaptureSession completer should not null");
                    x2 x2Var2 = x2.this;
                    aVar = x2Var2.f2033i;
                    x2Var2.f2033i = null;
                }
                aVar.c(null);
            } catch (Throwable th2) {
                synchronized (x2.this.f2025a) {
                    androidx.core.util.h.h(x2.this.f2033i, "OpenCaptureSession completer should not null");
                    x2 x2Var3 = x2.this;
                    CallbackToFutureAdapter.a<Void> aVar2 = x2Var3.f2033i;
                    x2Var3.f2033i = null;
                    aVar2.c(null);
                    throw th2;
                }
            }
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            x2.this.A(cameraCaptureSession);
            x2 x2Var = x2.this;
            x2Var.s(x2Var);
        }

        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            x2.this.A(cameraCaptureSession);
            x2 x2Var = x2.this;
            x2Var.u(x2Var, surface);
        }
    }

    x2(@NonNull t1 t1Var, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        this.f2026b = t1Var;
        this.f2027c = handler;
        this.f2028d = executor;
        this.f2029e = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D() {
        t(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(r2 r2Var) {
        this.f2026b.h(this);
        t(r2Var);
        Objects.requireNonNull(this.f2030f);
        this.f2030f.p(r2Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        this.f2030f.t(r2Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object G(List list, d0 d0Var, k kVar, CallbackToFutureAdapter.a aVar) throws Exception {
        boolean z10;
        String str;
        synchronized (this.f2025a) {
            B(list);
            if (this.f2033i == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.j(z10, "The openCaptureSessionCompleter can only set once!");
            this.f2033i = aVar;
            d0Var.a(kVar);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ zf.a H(List list, List list2) throws Exception {
        v1.a("SyncCaptureSessionBase", "[" + this + "] getSurface...done");
        if (list2.contains((Object) null)) {
            return f.f(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf((Object) null))));
        }
        if (list2.isEmpty()) {
            return f.f(new IllegalArgumentException("Unable to open capture session without surfaces"));
        }
        return f.h(list2);
    }

    /* access modifiers changed from: package-private */
    public void A(@NonNull CameraCaptureSession cameraCaptureSession) {
        if (this.f2031g == null) {
            this.f2031g = h.d(cameraCaptureSession, this.f2027c);
        }
    }

    /* access modifiers changed from: package-private */
    public void B(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        synchronized (this.f2025a) {
            I();
            o0.f(list);
            this.f2035k = list;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        boolean z10;
        synchronized (this.f2025a) {
            if (this.f2032h != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void I() {
        synchronized (this.f2025a) {
            List<DeferrableSurface> list = this.f2035k;
            if (list != null) {
                o0.e(list);
                this.f2035k = null;
            }
        }
    }

    @NonNull
    public Executor a() {
        return this.f2028d;
    }

    @NonNull
    public k b(int i10, @NonNull List<p.b> list, @NonNull r2.a aVar) {
        this.f2030f = aVar;
        return new k(i10, list, a(), new b());
    }

    @NonNull
    public r2.a c() {
        return this;
    }

    public void close() {
        androidx.core.util.h.h(this.f2031g, "Need to call openCaptureSession before using this API.");
        this.f2026b.i(this);
        this.f2031g.c().close();
        a().execute(new v2(this));
    }

    public void d() {
        I();
    }

    public void e() throws CameraAccessException {
        androidx.core.util.h.h(this.f2031g, "Need to call openCaptureSession before using this API.");
        this.f2031g.c().abortCaptures();
    }

    @NonNull
    public CameraDevice f() {
        androidx.core.util.h.g(this.f2031g);
        return this.f2031g.c().getDevice();
    }

    public int g(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        androidx.core.util.h.h(this.f2031g, "Need to call openCaptureSession before using this API.");
        return this.f2031g.b(captureRequest, a(), captureCallback);
    }

    @NonNull
    public zf.a<List<Surface>> h(@NonNull List<DeferrableSurface> list, long j10) {
        synchronized (this.f2025a) {
            if (this.f2037m) {
                zf.a<List<Surface>> f10 = f.f(new CancellationException("Opener is disabled"));
                return f10;
            }
            d<T> e10 = d.a(o0.k(list, false, j10, a(), this.f2029e)).e(new s2(this, list), a());
            this.f2034j = e10;
            zf.a<List<Surface>> j11 = f.j(e10);
            return j11;
        }
    }

    @NonNull
    public zf.a<Void> i(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list) {
        synchronized (this.f2025a) {
            if (this.f2037m) {
                zf.a<Void> f10 = f.f(new CancellationException("Opener is disabled"));
                return f10;
            }
            this.f2026b.l(this);
            zf.a<Void> a10 = CallbackToFutureAdapter.a(new t2(this, list, d0.b(cameraDevice, this.f2027c), kVar));
            this.f2032h = a10;
            f.b(a10, new a(), androidx.camera.core.impl.utils.executor.a.a());
            zf.a<Void> j10 = f.j(this.f2032h);
            return j10;
        }
    }

    public int j(@NonNull List<CaptureRequest> list, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        androidx.core.util.h.h(this.f2031g, "Need to call openCaptureSession before using this API.");
        return this.f2031g.a(list, a(), captureCallback);
    }

    @NonNull
    public h k() {
        androidx.core.util.h.g(this.f2031g);
        return this.f2031g;
    }

    public void l() throws CameraAccessException {
        androidx.core.util.h.h(this.f2031g, "Need to call openCaptureSession before using this API.");
        this.f2031g.c().stopRepeating();
    }

    @NonNull
    public zf.a<Void> m() {
        return f.h(null);
    }

    public void n(@NonNull r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        this.f2030f.n(r2Var);
    }

    public void o(@NonNull r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        this.f2030f.o(r2Var);
    }

    public void p(@NonNull r2 r2Var) {
        zf.a<Void> aVar;
        synchronized (this.f2025a) {
            if (!this.f2036l) {
                this.f2036l = true;
                androidx.core.util.h.h(this.f2032h, "Need to call openCaptureSession before using this API.");
                aVar = this.f2032h;
            } else {
                aVar = null;
            }
        }
        d();
        if (aVar != null) {
            aVar.addListener(new u2(this, r2Var), androidx.camera.core.impl.utils.executor.a.a());
        }
    }

    public void q(@NonNull r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        d();
        this.f2026b.j(this);
        this.f2030f.q(r2Var);
    }

    public void r(@NonNull r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        this.f2026b.k(this);
        this.f2030f.r(r2Var);
    }

    public void s(@NonNull r2 r2Var) {
        Objects.requireNonNull(this.f2030f);
        this.f2030f.s(r2Var);
    }

    public boolean stop() {
        boolean z10;
        zf.a<List<Surface>> aVar = null;
        try {
            synchronized (this.f2025a) {
                if (!this.f2037m) {
                    zf.a<List<Surface>> aVar2 = this.f2034j;
                    if (aVar2 != null) {
                        aVar = aVar2;
                    }
                    this.f2037m = true;
                }
                if (!C()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (aVar != null) {
                aVar.cancel(true);
            }
            return z10;
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.cancel(true);
            }
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull r2 r2Var) {
        zf.a<Void> aVar;
        synchronized (this.f2025a) {
            if (!this.f2038n) {
                this.f2038n = true;
                androidx.core.util.h.h(this.f2032h, "Need to call openCaptureSession before using this API.");
                aVar = this.f2032h;
            } else {
                aVar = null;
            }
        }
        if (aVar != null) {
            aVar.addListener(new w2(this, r2Var), androidx.camera.core.impl.utils.executor.a.a());
        }
    }

    public void u(@NonNull r2 r2Var, @NonNull Surface surface) {
        Objects.requireNonNull(this.f2030f);
        this.f2030f.u(r2Var, surface);
    }
}

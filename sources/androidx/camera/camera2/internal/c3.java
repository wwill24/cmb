package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.r1;
import androidx.camera.core.v1;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import p.k;
import r.g;
import r.h;
import r.v;
import u.f;
import zf.a;

class c3 extends x2 {

    /* renamed from: o  reason: collision with root package name */
    private final Object f1701o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private List<DeferrableSurface> f1702p;

    /* renamed from: q  reason: collision with root package name */
    a<Void> f1703q;

    /* renamed from: r  reason: collision with root package name */
    private final h f1704r;

    /* renamed from: s  reason: collision with root package name */
    private final v f1705s;

    /* renamed from: t  reason: collision with root package name */
    private final g f1706t;

    c3(@NonNull r1 r1Var, @NonNull r1 r1Var2, @NonNull t1 t1Var, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler) {
        super(t1Var, executor, scheduledExecutorService, handler);
        this.f1704r = new h(r1Var, r1Var2);
        this.f1705s = new v(r1Var);
        this.f1706t = new g(r1Var2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O() {
        N("Session call super.close()");
        super.close();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(r2 r2Var) {
        super.r(r2Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ a Q(CameraDevice cameraDevice, k kVar, List list) {
        return super.i(cameraDevice, kVar, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int R(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.g(captureRequest, captureCallback);
    }

    /* access modifiers changed from: package-private */
    public void N(String str) {
        v1.a("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    public void close() {
        N("Session call close()");
        this.f1705s.f();
        this.f1705s.c().addListener(new z2(this), a());
    }

    public int g(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f1705s.h(captureRequest, captureCallback, new y2(this));
    }

    @NonNull
    public a<List<Surface>> h(@NonNull List<DeferrableSurface> list, long j10) {
        a<List<Surface>> h10;
        synchronized (this.f1701o) {
            this.f1702p = list;
            h10 = super.h(list, j10);
        }
        return h10;
    }

    @NonNull
    public a<Void> i(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list) {
        a<Void> j10;
        synchronized (this.f1701o) {
            a<Void> g10 = this.f1705s.g(cameraDevice, kVar, list, this.f2026b.e(), new a3(this));
            this.f1703q = g10;
            j10 = f.j(g10);
        }
        return j10;
    }

    @NonNull
    public a<Void> m() {
        return this.f1705s.c();
    }

    public void p(@NonNull r2 r2Var) {
        synchronized (this.f1701o) {
            this.f1704r.a(this.f1702p);
        }
        N("onClosed()");
        super.p(r2Var);
    }

    public void r(@NonNull r2 r2Var) {
        N("Session onConfigured()");
        this.f1706t.c(r2Var, this.f2026b.f(), this.f2026b.d(), new b3(this));
    }

    public boolean stop() {
        boolean stop;
        synchronized (this.f1701o) {
            if (C()) {
                this.f1704r.a(this.f1702p);
            } else {
                a<Void> aVar = this.f1703q;
                if (aVar != null) {
                    aVar.cancel(true);
                }
            }
            stop = super.stop();
        }
        return stop;
    }
}

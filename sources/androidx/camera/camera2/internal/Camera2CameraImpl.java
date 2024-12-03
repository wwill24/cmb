package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.d3;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.a0;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.e2;
import androidx.camera.core.impl.f1;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.u1;
import androidx.camera.core.impl.x;
import androidx.camera.core.impl.y0;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.firebase.perf.util.Constants;
import com.leanplum.internal.ResourceQualifiers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import o.q0;
import q.l;

final class Camera2CameraImpl implements CameraInternal {
    @NonNull
    private final t1 B;
    @NonNull
    private final d3.a C;
    private final Set<String> D;
    @NonNull
    private r E;
    final Object F;
    private u1 G;
    boolean H;
    @NonNull
    private final v1 I;

    /* renamed from: a  reason: collision with root package name */
    private final e2 f1559a;

    /* renamed from: b  reason: collision with root package name */
    private final q0 f1560b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f1561c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f1562d;

    /* renamed from: e  reason: collision with root package name */
    volatile InternalState f1563e = InternalState.INITIALIZED;

    /* renamed from: f  reason: collision with root package name */
    private final f1<CameraInternal.State> f1564f;

    /* renamed from: g  reason: collision with root package name */
    private final j1 f1565g;

    /* renamed from: h  reason: collision with root package name */
    private final t f1566h;

    /* renamed from: j  reason: collision with root package name */
    private final f f1567j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    final i0 f1568k;

    /* renamed from: l  reason: collision with root package name */
    CameraDevice f1569l;

    /* renamed from: m  reason: collision with root package name */
    int f1570m;

    /* renamed from: n  reason: collision with root package name */
    r1 f1571n;

    /* renamed from: p  reason: collision with root package name */
    final AtomicInteger f1572p;

    /* renamed from: q  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f1573q;

    /* renamed from: t  reason: collision with root package name */
    final Map<r1, zf.a<Void>> f1574t;

    /* renamed from: w  reason: collision with root package name */
    private final d f1575w;

    /* renamed from: x  reason: collision with root package name */
    private final a0 f1576x;

    /* renamed from: y  reason: collision with root package name */
    final Set<CaptureSession> f1577y;

    /* renamed from: z  reason: collision with root package name */
    private k2 f1578z;

    enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    class a implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r1 f1588a;

        a(r1 r1Var) {
            this.f1588a = r1Var;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            CameraDevice cameraDevice;
            Camera2CameraImpl.this.f1574t.remove(this.f1588a);
            int i10 = c.f1591a[Camera2CameraImpl.this.f1563e.ordinal()];
            if (i10 != 3) {
                if (i10 != 6) {
                    if (i10 != 7) {
                        return;
                    }
                } else if (Camera2CameraImpl.this.f1570m == 0) {
                    return;
                }
            }
            if (Camera2CameraImpl.this.M() && (cameraDevice = Camera2CameraImpl.this.f1569l) != null) {
                o.a.a(cameraDevice);
                Camera2CameraImpl.this.f1569l = null;
            }
        }

        public void onFailure(@NonNull Throwable th2) {
        }
    }

    class b implements u.c<Void> {
        b() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            if (th2 instanceof DeferrableSurface.SurfaceClosedException) {
                SessionConfig H = Camera2CameraImpl.this.H(((DeferrableSurface.SurfaceClosedException) th2).a());
                if (H != null) {
                    Camera2CameraImpl.this.d0(H);
                }
            } else if (th2 instanceof CancellationException) {
                Camera2CameraImpl.this.F("Unable to configure camera cancelled");
            } else {
                InternalState internalState = Camera2CameraImpl.this.f1563e;
                InternalState internalState2 = InternalState.OPENED;
                if (internalState == internalState2) {
                    Camera2CameraImpl.this.j0(internalState2, CameraState.a.b(4, th2));
                }
                if (th2 instanceof CameraAccessException) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    camera2CameraImpl.F("Unable to configure camera due to " + th2.getMessage());
                } else if (th2 instanceof TimeoutException) {
                    v1.c("Camera2CameraImpl", "Unable to configure camera " + Camera2CameraImpl.this.f1568k.a() + ", timeout!");
                }
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1591a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1591a = r0
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.PENDING_OPEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.CLOSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.REOPENING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f1591a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.c.<clinit>():void");
        }
    }

    final class d extends CameraManager.AvailabilityCallback implements a0.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f1592a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1593b = true;

        d(String str) {
            this.f1592a = str;
        }

        public void a() {
            if (Camera2CameraImpl.this.f1563e == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.q0(false);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f1593b;
        }

        public void onCameraAvailable(@NonNull String str) {
            if (this.f1592a.equals(str)) {
                this.f1593b = true;
                if (Camera2CameraImpl.this.f1563e == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.q0(false);
                }
            }
        }

        public void onCameraUnavailable(@NonNull String str) {
            if (this.f1592a.equals(str)) {
                this.f1593b = false;
            }
        }
    }

    final class e implements CameraControlInternal.b {
        e() {
        }

        public void a() {
            Camera2CameraImpl.this.r0();
        }

        public void b(@NonNull List<d0> list) {
            Camera2CameraImpl.this.l0((List) h.g(list));
        }
    }

    final class f extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f1596a;

        /* renamed from: b  reason: collision with root package name */
        private final ScheduledExecutorService f1597b;

        /* renamed from: c  reason: collision with root package name */
        private b f1598c;

        /* renamed from: d  reason: collision with root package name */
        ScheduledFuture<?> f1599d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final a f1600e = new a();

        class a {

            /* renamed from: a  reason: collision with root package name */
            private long f1602a = -1;

            a() {
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                boolean z10;
                if (b() >= ((long) d())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return true;
                }
                e();
                return false;
            }

            /* access modifiers changed from: package-private */
            public long b() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f1602a == -1) {
                    this.f1602a = uptimeMillis;
                }
                return uptimeMillis - this.f1602a;
            }

            /* access modifiers changed from: package-private */
            public int c() {
                if (!f.this.f()) {
                    return Constants.FROZEN_FRAME_TIME;
                }
                long b10 = b();
                if (b10 <= 120000) {
                    return 1000;
                }
                if (b10 <= 300000) {
                    return 2000;
                }
                return 4000;
            }

            /* access modifiers changed from: package-private */
            public int d() {
                return !f.this.f() ? 10000 : 1800000;
            }

            /* access modifiers changed from: package-private */
            public void e() {
                this.f1602a = -1;
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private Executor f1604a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f1605b = false;

            b(@NonNull Executor executor) {
                this.f1604a = executor;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void c() {
                boolean z10;
                if (!this.f1605b) {
                    if (Camera2CameraImpl.this.f1563e == InternalState.REOPENING) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    h.i(z10);
                    if (f.this.f()) {
                        Camera2CameraImpl.this.p0(true);
                    } else {
                        Camera2CameraImpl.this.q0(true);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public void b() {
                this.f1605b = true;
            }

            public void run() {
                this.f1604a.execute(new g0(this));
            }
        }

        f(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
            this.f1596a = executor;
            this.f1597b = scheduledExecutorService;
        }

        private void b(@NonNull CameraDevice cameraDevice, int i10) {
            boolean z10;
            int i11;
            if (Camera2CameraImpl.this.f1563e == InternalState.OPENING || Camera2CameraImpl.this.f1563e == InternalState.OPENED || Camera2CameraImpl.this.f1563e == InternalState.REOPENING) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.f1563e);
            if (i10 == 1 || i10 == 2 || i10 == 4) {
                v1.a("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", new Object[]{cameraDevice.getId(), Camera2CameraImpl.J(i10)}));
                c(i10);
                return;
            }
            v1.c("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.J(i10) + " closing camera.");
            if (i10 == 3) {
                i11 = 5;
            } else {
                i11 = 6;
            }
            Camera2CameraImpl.this.j0(InternalState.CLOSING, CameraState.a.a(i11));
            Camera2CameraImpl.this.B(false);
        }

        private void c(int i10) {
            boolean z10;
            int i11 = 1;
            if (Camera2CameraImpl.this.f1570m != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i10 == 1) {
                i11 = 2;
            } else if (i10 != 2) {
                i11 = 3;
            }
            Camera2CameraImpl.this.j0(InternalState.REOPENING, CameraState.a.a(i11));
            Camera2CameraImpl.this.B(false);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            if (this.f1599d == null) {
                return false;
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.F("Cancelling scheduled re-open: " + this.f1598c);
            this.f1598c.b();
            this.f1598c = null;
            this.f1599d.cancel(false);
            this.f1599d = null;
            return true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f1600e.e();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            boolean z10;
            boolean z11 = true;
            if (this.f1598c == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.i(z10);
            if (this.f1599d != null) {
                z11 = false;
            }
            h.i(z11);
            if (this.f1600e.a()) {
                this.f1598c = new b(this.f1596a);
                Camera2CameraImpl.this.F("Attempting camera re-open in " + this.f1600e.c() + "ms: " + this.f1598c + " activeResuming = " + Camera2CameraImpl.this.H);
                this.f1599d = this.f1597b.schedule(this.f1598c, (long) this.f1600e.c(), TimeUnit.MILLISECONDS);
                return;
            }
            v1.c("Camera2CameraImpl", "Camera reopening attempted for " + this.f1600e.d() + "ms without success.");
            Camera2CameraImpl.this.k0(InternalState.PENDING_OPEN, (CameraState.a) null, false);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0 = r0.f1570m;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean f() {
            /*
                r3 = this;
                androidx.camera.camera2.internal.Camera2CameraImpl r0 = androidx.camera.camera2.internal.Camera2CameraImpl.this
                boolean r1 = r0.H
                r2 = 1
                if (r1 == 0) goto L_0x000f
                int r0 = r0.f1570m
                if (r0 == r2) goto L_0x0010
                r1 = 2
                if (r0 != r1) goto L_0x000f
                goto L_0x0010
            L_0x000f:
                r2 = 0
            L_0x0010:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.f.f():boolean");
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            boolean z10;
            Camera2CameraImpl.this.F("CameraDevice.onClosed()");
            if (Camera2CameraImpl.this.f1569l == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.j(z10, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i10 = c.f1591a[Camera2CameraImpl.this.f1563e.ordinal()];
            if (i10 != 3) {
                if (i10 == 6) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.f1570m != 0) {
                        camera2CameraImpl.F("Camera closed due to error: " + Camera2CameraImpl.J(Camera2CameraImpl.this.f1570m));
                        e();
                        return;
                    }
                    camera2CameraImpl.q0(false);
                    return;
                } else if (i10 != 7) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.f1563e);
                }
            }
            h.i(Camera2CameraImpl.this.M());
            Camera2CameraImpl.this.I();
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.F("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f1569l = cameraDevice;
            camera2CameraImpl.f1570m = i10;
            int i11 = c.f1591a[camera2CameraImpl.f1563e.ordinal()];
            if (i11 != 3) {
                if (i11 == 4 || i11 == 5 || i11 == 6) {
                    v1.a("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", new Object[]{cameraDevice.getId(), Camera2CameraImpl.J(i10), Camera2CameraImpl.this.f1563e.name()}));
                    b(cameraDevice, i10);
                    return;
                } else if (i11 != 7) {
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.f1563e);
                }
            }
            v1.c("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", new Object[]{cameraDevice.getId(), Camera2CameraImpl.J(i10), Camera2CameraImpl.this.f1563e.name()}));
            Camera2CameraImpl.this.B(false);
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Camera2CameraImpl.this.F("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f1569l = cameraDevice;
            camera2CameraImpl.f1570m = 0;
            d();
            int i10 = c.f1591a[Camera2CameraImpl.this.f1563e.ordinal()];
            if (i10 != 3) {
                if (i10 == 5 || i10 == 6) {
                    Camera2CameraImpl.this.i0(InternalState.OPENED);
                    Camera2CameraImpl.this.b0();
                    return;
                } else if (i10 != 7) {
                    throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.f1563e);
                }
            }
            h.i(Camera2CameraImpl.this.M());
            Camera2CameraImpl.this.f1569l.close();
            Camera2CameraImpl.this.f1569l = null;
        }
    }

    static abstract class g {
        g() {
        }

        @NonNull
        static g a(@NonNull String str, @NonNull Class<?> cls, @NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var, Size size) {
            return new b(str, cls, sessionConfig, f2Var, size);
        }

        @NonNull
        static g b(@NonNull UseCase useCase) {
            return a(Camera2CameraImpl.K(useCase), useCase.getClass(), useCase.m(), useCase.g(), useCase.c());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract SessionConfig c();

        /* access modifiers changed from: package-private */
        public abstract Size d();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract f2<?> e();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract String f();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Class<?> g();
    }

    Camera2CameraImpl(@NonNull q0 q0Var, @NonNull String str, @NonNull i0 i0Var, @NonNull a0 a0Var, @NonNull Executor executor, @NonNull Handler handler, @NonNull v1 v1Var) throws CameraUnavailableException {
        q0 q0Var2 = q0Var;
        String str2 = str;
        i0 i0Var2 = i0Var;
        a0 a0Var2 = a0Var;
        f1<CameraInternal.State> f1Var = new f1<>();
        this.f1564f = f1Var;
        this.f1570m = 0;
        this.f1572p = new AtomicInteger(0);
        this.f1574t = new LinkedHashMap();
        this.f1577y = new HashSet();
        this.D = new HashSet();
        this.E = u.a();
        this.F = new Object();
        this.H = false;
        this.f1560b = q0Var2;
        this.f1576x = a0Var2;
        ScheduledExecutorService e10 = androidx.camera.core.impl.utils.executor.a.e(handler);
        this.f1562d = e10;
        Executor f10 = androidx.camera.core.impl.utils.executor.a.f(executor);
        this.f1561c = f10;
        this.f1567j = new f(f10, e10);
        this.f1559a = new e2(str2);
        f1Var.m(CameraInternal.State.CLOSED);
        j1 j1Var = new j1(a0Var2);
        this.f1565g = j1Var;
        t1 t1Var = new t1(f10);
        this.B = t1Var;
        this.I = v1Var;
        this.f1571n = X();
        try {
            t tVar = new t(q0Var.c(str), e10, f10, new e(), i0Var.e());
            this.f1566h = tVar;
            this.f1568k = i0Var2;
            i0Var2.m(tVar);
            i0Var2.p(j1Var.a());
            this.C = new d3.a(f10, e10, handler, t1Var, i0Var.e(), l.b());
            d dVar = new d(str2);
            this.f1575w = dVar;
            a0Var2.e(this, f10, dVar);
            q0Var2.f(f10, dVar);
        } catch (CameraAccessExceptionCompat e11) {
            throw k1.a(e11);
        }
    }

    private boolean A(d0.a aVar) {
        if (!aVar.l().isEmpty()) {
            v1.l("Camera2CameraImpl", "The capture config builder already has surface inside.");
            return false;
        }
        for (SessionConfig h10 : this.f1559a.e()) {
            List<DeferrableSurface> e10 = h10.h().e();
            if (!e10.isEmpty()) {
                for (DeferrableSurface f10 : e10) {
                    aVar.f(f10);
                }
            }
        }
        if (!aVar.l().isEmpty()) {
            return true;
        }
        v1.l("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    private void C() {
        F("Closing camera.");
        int i10 = c.f1591a[this.f1563e.ordinal()];
        boolean z10 = false;
        if (i10 == 2) {
            if (this.f1569l == null) {
                z10 = true;
            }
            h.i(z10);
            i0(InternalState.INITIALIZED);
        } else if (i10 == 4) {
            i0(InternalState.CLOSING);
            B(false);
        } else if (i10 == 5 || i10 == 6) {
            boolean a10 = this.f1567j.a();
            i0(InternalState.CLOSING);
            if (a10) {
                h.i(M());
                I();
            }
        } else {
            F("close() ignored due to being in state: " + this.f1563e);
        }
    }

    private void D(boolean z10) {
        CaptureSession captureSession = new CaptureSession();
        this.f1577y.add(captureSession);
        h0(z10);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_XXHIGH);
        Surface surface = new Surface(surfaceTexture);
        d0 d0Var = new d0(surface, surfaceTexture);
        SessionConfig.b bVar = new SessionConfig.b();
        y0 y0Var = new y0(surface);
        bVar.h(y0Var);
        bVar.t(1);
        F("Start configAndClose.");
        captureSession.g(bVar.m(), (CameraDevice) h.g(this.f1569l), this.C.a()).addListener(new e0(this, captureSession, y0Var, d0Var), this.f1561c);
    }

    private CameraDevice.StateCallback E() {
        ArrayList arrayList = new ArrayList(this.f1559a.f().c().b());
        arrayList.add(this.B.c());
        arrayList.add(this.f1567j);
        return h1.a(arrayList);
    }

    private void G(@NonNull String str, Throwable th2) {
        v1.b("Camera2CameraImpl", String.format("{%s} %s", new Object[]{toString(), str}), th2);
    }

    static String J(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    @NonNull
    static String K(@NonNull UseCase useCase) {
        return useCase.j() + useCase.hashCode();
    }

    private boolean L() {
        if (((i0) l()).l() == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(List list) {
        try {
            n0(list);
        } finally {
            this.f1566h.v();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(String str, SessionConfig sessionConfig, f2 f2Var) {
        F("Use case " + str + " ACTIVE");
        this.f1559a.q(str, sessionConfig, f2Var);
        this.f1559a.u(str, sessionConfig, f2Var);
        r0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(String str) {
        F("Use case " + str + " INACTIVE");
        this.f1559a.t(str);
        r0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(String str, SessionConfig sessionConfig, f2 f2Var) {
        F("Use case " + str + " RESET");
        this.f1559a.u(str, sessionConfig, f2Var);
        h0(false);
        r0();
        if (this.f1563e == InternalState.OPENED) {
            b0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(String str, SessionConfig sessionConfig, f2 f2Var) {
        F("Use case " + str + " UPDATED");
        this.f1559a.u(str, sessionConfig, f2Var);
        r0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(boolean z10) {
        this.H = z10;
        if (z10 && this.f1563e == InternalState.PENDING_OPEN) {
            p0(false);
        }
    }

    @NonNull
    private r1 X() {
        synchronized (this.F) {
            if (this.G == null) {
                CaptureSession captureSession = new CaptureSession();
                return captureSession;
            }
            ProcessingCaptureSession processingCaptureSession = new ProcessingCaptureSession(this.G, this.f1568k, this.f1561c, this.f1562d);
            return processingCaptureSession;
        }
    }

    private void Y(List<UseCase> list) {
        for (UseCase next : list) {
            String K = K(next);
            if (!this.D.contains(K)) {
                this.D.add(K);
                next.D();
            }
        }
    }

    private void Z(List<UseCase> list) {
        for (UseCase next : list) {
            String K = K(next);
            if (this.D.contains(K)) {
                next.E();
                this.D.remove(K);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a0(boolean z10) {
        if (!z10) {
            this.f1567j.d();
        }
        this.f1567j.a();
        F("Opening camera.");
        i0(InternalState.OPENING);
        try {
            this.f1560b.e(this.f1568k.a(), this.f1561c, E());
        } catch (CameraAccessExceptionCompat e10) {
            F("Unable to open camera due to " + e10.getMessage());
            if (e10.d() == 10001) {
                j0(InternalState.INITIALIZED, CameraState.a.b(7, e10));
            }
        } catch (SecurityException e11) {
            F("Unable to open camera due to " + e11.getMessage());
            i0(InternalState.REOPENING);
            this.f1567j.e();
        }
    }

    private void c0() {
        int i10 = c.f1591a[this.f1563e.ordinal()];
        boolean z10 = false;
        if (i10 == 1 || i10 == 2) {
            p0(false);
        } else if (i10 != 3) {
            F("open() ignored due to being in state: " + this.f1563e);
        } else {
            i0(InternalState.REOPENING);
            if (!M() && this.f1570m == 0) {
                if (this.f1569l != null) {
                    z10 = true;
                }
                h.j(z10, "Camera Device should be open if session close is not complete");
                i0(InternalState.OPENED);
                b0();
            }
        }
    }

    private void g0() {
        if (this.f1578z != null) {
            e2 e2Var = this.f1559a;
            e2Var.s(this.f1578z.c() + this.f1578z.hashCode());
            e2 e2Var2 = this.f1559a;
            e2Var2.t(this.f1578z.c() + this.f1578z.hashCode());
            this.f1578z.b();
            this.f1578z = null;
        }
    }

    @NonNull
    private Collection<g> m0(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase b10 : collection) {
            arrayList.add(g.b(b10));
        }
        return arrayList;
    }

    private void n0(@NonNull Collection<g> collection) {
        Size d10;
        boolean isEmpty = this.f1559a.g().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (g next : collection) {
            if (!this.f1559a.l(next.f())) {
                this.f1559a.r(next.f(), next.c(), next.e());
                arrayList.add(next.f());
                if (next.g() == androidx.camera.core.f2.class && (d10 = next.d()) != null) {
                    rational = new Rational(d10.getWidth(), d10.getHeight());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            F("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
            if (isEmpty) {
                this.f1566h.e0(true);
                this.f1566h.M();
            }
            z();
            s0();
            r0();
            h0(false);
            if (this.f1563e == InternalState.OPENED) {
                b0();
            } else {
                c0();
            }
            if (rational != null) {
                this.f1566h.f0(rational);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o0 */
    public void Q(@NonNull Collection<g> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (g next : collection) {
            if (this.f1559a.l(next.f())) {
                this.f1559a.p(next.f());
                arrayList.add(next.f());
                if (next.g() == androidx.camera.core.f2.class) {
                    z10 = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            F("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
            if (z10) {
                this.f1566h.f0((Rational) null);
            }
            z();
            if (this.f1559a.h().isEmpty()) {
                this.f1566h.h0(false);
            } else {
                s0();
            }
            if (this.f1559a.g().isEmpty()) {
                this.f1566h.v();
                h0(false);
                this.f1566h.e0(false);
                this.f1571n = X();
                C();
                return;
            }
            r0();
            h0(false);
            if (this.f1563e == InternalState.OPENED) {
                b0();
            }
        }
    }

    private void s0() {
        boolean z10 = false;
        for (f2<?> A : this.f1559a.h()) {
            z10 |= A.A(false);
        }
        this.f1566h.h0(z10);
    }

    private void y() {
        if (this.f1578z != null) {
            e2 e2Var = this.f1559a;
            e2Var.r(this.f1578z.c() + this.f1578z.hashCode(), this.f1578z.e(), this.f1578z.f());
            e2 e2Var2 = this.f1559a;
            e2Var2.q(this.f1578z.c() + this.f1578z.hashCode(), this.f1578z.e(), this.f1578z.f());
        }
    }

    private void z() {
        SessionConfig c10 = this.f1559a.f().c();
        d0 h10 = c10.h();
        int size = h10.e().size();
        int size2 = c10.k().size();
        if (c10.k().isEmpty()) {
            return;
        }
        if (h10.e().isEmpty()) {
            if (this.f1578z == null) {
                this.f1578z = new k2(this.f1568k.j(), this.I);
            }
            y();
        } else if (size2 == 1 && size == 1) {
            g0();
        } else if (size >= 2) {
            g0();
        } else {
            v1.a("Camera2CameraImpl", "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        }
    }

    /* access modifiers changed from: package-private */
    public void B(boolean z10) {
        boolean z11;
        if (this.f1563e == InternalState.CLOSING || this.f1563e == InternalState.RELEASING || (this.f1563e == InternalState.REOPENING && this.f1570m != 0)) {
            z11 = true;
        } else {
            z11 = false;
        }
        h.j(z11, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.f1563e + " (error: " + J(this.f1570m) + ")");
        if (Build.VERSION.SDK_INT >= 29 || !L() || this.f1570m != 0) {
            h0(z10);
        } else {
            D(z10);
        }
        this.f1571n.b();
    }

    /* access modifiers changed from: package-private */
    public void F(@NonNull String str) {
        G(str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public SessionConfig H(@NonNull DeferrableSurface deferrableSurface) {
        for (SessionConfig next : this.f1559a.g()) {
            if (next.k().contains(deferrableSurface)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void I() {
        boolean z10;
        if (this.f1563e == InternalState.RELEASING || this.f1563e == InternalState.CLOSING) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.i(z10);
        h.i(this.f1574t.isEmpty());
        this.f1569l = null;
        if (this.f1563e == InternalState.CLOSING) {
            i0(InternalState.INITIALIZED);
            return;
        }
        this.f1560b.g(this.f1575w);
        i0(InternalState.RELEASED);
        CallbackToFutureAdapter.a<Void> aVar = this.f1573q;
        if (aVar != null) {
            aVar.c(null);
            this.f1573q = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return this.f1574t.isEmpty() && this.f1577y.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void b0() {
        boolean z10;
        if (this.f1563e == InternalState.OPENED) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.i(z10);
        SessionConfig.f f10 = this.f1559a.f();
        if (!f10.f()) {
            F("Unable to create capture session due to conflicting configurations");
            return;
        }
        Config d10 = f10.c().d();
        Config.a<Long> aVar = n.a.C;
        if (!d10.b(aVar)) {
            f10.b(aVar, Long.valueOf(p2.a(this.f1559a.h(), this.f1559a.g())));
        }
        u.f.b(this.f1571n.g(f10.c(), (CameraDevice) h.g(this.f1569l), this.C.a()), new b(), this.f1561c);
    }

    @NonNull
    public l1<CameraInternal.State> c() {
        return this.f1564f;
    }

    public void d(@NonNull UseCase useCase) {
        h.g(useCase);
        this.f1561c.execute(new y(this, K(useCase), useCase.m(), useCase.g()));
    }

    /* access modifiers changed from: package-private */
    public void d0(@NonNull SessionConfig sessionConfig) {
        ScheduledExecutorService d10 = androidx.camera.core.impl.utils.executor.a.d();
        List<SessionConfig.c> c10 = sessionConfig.c();
        if (!c10.isEmpty()) {
            G("Posting surface closed", new Throwable());
            d10.execute(new z(c10.get(0), sessionConfig));
        }
    }

    public void e(@NonNull UseCase useCase) {
        h.g(useCase);
        this.f1561c.execute(new a0(this, K(useCase), useCase.m(), useCase.g()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e0 */
    public void P(@NonNull CaptureSession captureSession, @NonNull DeferrableSurface deferrableSurface, @NonNull Runnable runnable) {
        this.f1577y.remove(captureSession);
        zf.a<Void> f02 = f0(captureSession, false);
        deferrableSurface.c();
        u.f.n(Arrays.asList(new zf.a[]{f02, deferrableSurface.i()})).addListener(runnable, androidx.camera.core.impl.utils.executor.a.a());
    }

    @NonNull
    public CameraControlInternal f() {
        return this.f1566h;
    }

    /* access modifiers changed from: package-private */
    public zf.a<Void> f0(@NonNull r1 r1Var, boolean z10) {
        r1Var.close();
        zf.a<Void> c10 = r1Var.c(z10);
        F("Releasing session in state " + this.f1563e.name());
        this.f1574t.put(r1Var, c10);
        u.f.b(c10, new a(r1Var), androidx.camera.core.impl.utils.executor.a.a());
        return c10;
    }

    @NonNull
    public r g() {
        return this.E;
    }

    public void h(boolean z10) {
        this.f1561c.execute(new x(this, z10));
    }

    /* access modifiers changed from: package-private */
    public void h0(boolean z10) {
        boolean z11;
        if (this.f1571n != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        h.i(z11);
        F("Resetting Capture Session");
        r1 r1Var = this.f1571n;
        SessionConfig e10 = r1Var.e();
        List<d0> d10 = r1Var.d();
        r1 X = X();
        this.f1571n = X;
        X.f(e10);
        this.f1571n.a(d10);
        f0(r1Var, z10);
    }

    public void i(@NonNull UseCase useCase) {
        h.g(useCase);
        this.f1561c.execute(new f0(this, K(useCase), useCase.m(), useCase.g()));
    }

    /* access modifiers changed from: package-private */
    public void i0(@NonNull InternalState internalState) {
        j0(internalState, (CameraState.a) null);
    }

    public void j(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            this.f1566h.M();
            Y(new ArrayList(arrayList));
            try {
                this.f1561c.execute(new c0(this, new ArrayList(m0(arrayList))));
            } catch (RejectedExecutionException e10) {
                G("Unable to attach use cases.", e10);
                this.f1566h.v();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j0(@NonNull InternalState internalState, CameraState.a aVar) {
        k0(internalState, aVar, true);
    }

    public void k(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(m0(arrayList));
            Z(new ArrayList(arrayList));
            this.f1561c.execute(new b0(this, arrayList2));
        }
    }

    /* access modifiers changed from: package-private */
    public void k0(@NonNull InternalState internalState, CameraState.a aVar, boolean z10) {
        CameraInternal.State state;
        F("Transitioning camera internal state: " + this.f1563e + " --> " + internalState);
        this.f1563e = internalState;
        switch (c.f1591a[internalState.ordinal()]) {
            case 1:
                state = CameraInternal.State.CLOSED;
                break;
            case 2:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 3:
                state = CameraInternal.State.CLOSING;
                break;
            case 4:
                state = CameraInternal.State.OPEN;
                break;
            case 5:
            case 6:
                state = CameraInternal.State.OPENING;
                break;
            case 7:
                state = CameraInternal.State.RELEASING;
                break;
            case 8:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.f1576x.c(this, state, z10);
        this.f1564f.m(state);
        this.f1565g.c(state, aVar);
    }

    @NonNull
    public x l() {
        return this.f1568k;
    }

    /* access modifiers changed from: package-private */
    public void l0(@NonNull List<d0> list) {
        ArrayList arrayList = new ArrayList();
        for (d0 next : list) {
            d0.a k10 = d0.a.k(next);
            if (next.g() == 5 && next.c() != null) {
                k10.o(next.c());
            }
            if (!next.e().isEmpty() || !next.h() || A(k10)) {
                arrayList.add(k10.h());
            }
        }
        F("Issue capture request");
        this.f1571n.a(arrayList);
    }

    public void m(r rVar) {
        if (rVar == null) {
            rVar = u.a();
        }
        u1 J = rVar.J((u1) null);
        this.E = rVar;
        synchronized (this.F) {
            this.G = J;
        }
    }

    public void n(@NonNull UseCase useCase) {
        h.g(useCase);
        this.f1561c.execute(new w(this, K(useCase)));
    }

    /* access modifiers changed from: package-private */
    public void p0(boolean z10) {
        F("Attempting to force open the camera.");
        if (!this.f1576x.f(this)) {
            F("No cameras available. Waiting for available camera before opening camera.");
            i0(InternalState.PENDING_OPEN);
            return;
        }
        a0(z10);
    }

    /* access modifiers changed from: package-private */
    public void q0(boolean z10) {
        boolean z11;
        F("Attempting to open the camera.");
        if (!this.f1575w.b() || !this.f1576x.f(this)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            F("No cameras available. Waiting for available camera before opening camera.");
            i0(InternalState.PENDING_OPEN);
            return;
        }
        a0(z10);
    }

    /* access modifiers changed from: package-private */
    public void r0() {
        SessionConfig.f d10 = this.f1559a.d();
        if (d10.f()) {
            this.f1566h.g0(d10.c().l());
            d10.a(this.f1566h.D());
            this.f1571n.f(d10.c());
            return;
        }
        this.f1566h.d0();
        this.f1571n.f(this.f1566h.D());
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", new Object[]{Integer.valueOf(hashCode()), this.f1568k.a()});
    }
}
